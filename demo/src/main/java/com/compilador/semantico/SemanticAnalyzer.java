package com.compilador.semantico;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.compilador.MiLenguajeBaseVisitor;
import com.compilador.MiLenguajeParser;

/**
 * Recorre el árbol de parseo generado por ANTLR y realiza el análisis semántico.
 *
 * Extiende MiLenguajeBaseVisitor<String>: el tipo String es el tipo de dato
 * que devuelve cada método visit. Las expresiones devuelven su tipo ("int",
 * "bool", etc.) y las sentencias devuelven null porque no tienen tipo.
 *
 * Los errores y advertencias se acumulan en listas separadas; el análisis
 * no se detiene al encontrar el primero.
 */
public class SemanticAnalyzer extends MiLenguajeBaseVisitor<String> {

    private final SymbolTable         tabla;
    private final List<SemanticError> errores;
    private final List<SemanticError> advertencias;

    // Tipo de retorno de la función que se está visitando en este momento.
    // null significa que estamos en el scope global (fuera de toda función).
    private String tipoRetornoActual;

    public SemanticAnalyzer() {
        this.tabla        = new SymbolTable();
        this.errores      = new ArrayList<>();
        this.advertencias = new ArrayList<>();
        tabla.definir(Symbol.variable("System", "object", true, 0, 0));
    }

    // ── Diagnósticos ─────────────────────────────────────────────────────────

    private void error(Token token, String mensaje) {
        errores.add(new SemanticError(
            token.getLine(),
            token.getCharPositionInLine(),
            mensaje,
            SemanticError.Severidad.ERROR
        ));
    }

    private void warning(Token token, String mensaje) {
        advertencias.add(new SemanticError(
            token.getLine(),
            token.getCharPositionInLine(),
            mensaje,
            SemanticError.Severidad.ADVERTENCIA
        ));
    }

    public List<SemanticError> getErrores()       { return errores;               }
    public List<SemanticError> getAdvertencias()  { return advertencias;          }
    public boolean             hayErrores()       { return !errores.isEmpty();    }
    public boolean             hayAdvertencias()  { return !advertencias.isEmpty(); }
    public SymbolTable         getTablaSimbolos() { return tabla;                }

    // ── Programa ─────────────────────────────────────────────────────────────

    @Override
    public String visitPrograma(MiLenguajeParser.ProgramaContext ctx) {
        return visitChildren(ctx);
    }

    // ── Delegadores de "sentencia" ──────────────────────────────────────────
    //
    // La regla "sentencia" tiene alternativas etiquetadas con #, por lo que
    // ANTLR genera un Context distinto para cada una. Cada uno solo contiene
    // la subregla real; hay que bajar un nivel con visit().

    @Override
    public String visitSentenciaBloque(MiLenguajeParser.SentenciaBloqueContext ctx) {
        return visit(ctx.bloque());
    }

    @Override
    public String visitSentenciaFor(MiLenguajeParser.SentenciaForContext ctx) {
        return visit(ctx.expresion_for());
    }

    @Override
    public String visitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
        return visit(ctx.expresion_while());
    }

    @Override
    public String visitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx) {
        return visit(ctx.expresion_if());
    }

    @Override
    public String visitSentenciaFuncion(MiLenguajeParser.SentenciaFuncionContext ctx) {
        return visit(ctx.declaracionFuncion());
    }

    @Override
    public String visitSentenciaDeclaracion(MiLenguajeParser.SentenciaDeclaracionContext ctx) {
        return visit(ctx.declaracion());
    }

    @Override
    public String visitSentenciaAsignacion(MiLenguajeParser.SentenciaAsignacionContext ctx) {
        return visit(ctx.asignacion());
    }

    @Override
    public String visitSentenciaRetorno(MiLenguajeParser.SentenciaRetornoContext ctx) {
        return visit(ctx.sentenciaReturn());
    }

    @Override
    public String visitSentenciaExpr(MiLenguajeParser.SentenciaExprContext ctx) {
        return visit(ctx.expresion());
    }

    // ── Declaración de variables ────────────────────────────────────────────

    @Override
    public String visitDeclaracion(MiLenguajeParser.DeclaracionContext ctx) {
        String tipo   = normalizarTipo(ctx.tipo().getText());
        String nombre = ctx.ID().getText();
        Token  token  = ctx.ID().getSymbol();

        if (tabla.estaDeclaradoLocalmente(nombre)) {
            error(token, "variable '" + nombre + "' ya fue declarada en este ámbito.");
            return null;
        }

        boolean tieneValorInicial = (ctx.expresion() != null);

        if (tieneValorInicial) {
            String tipoExpr = visit(ctx.expresion());
            if (tipoExpr != null && !TypeSystem.ERROR.equals(tipoExpr)) {
                if (!TypeSystem.esCompatibleAsignacion(tipo, tipoExpr)) {
                    error(token,
                          TypeSystem.msgIncompatible(tipo, tipoExpr)
                          + " en la declaración de '" + nombre + "'.");
                }
            }
        }

        tabla.definir(Symbol.variable(nombre, tipo, tieneValorInicial,
                                      token.getLine(), token.getCharPositionInLine()));
        return null;
    }

    // ── Asignación ───────────────────────────────────────────────────────────

    @Override
    public String visitAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String nombre  = ctx.ID().getText();
        Token  token   = ctx.ID().getSymbol();
        Symbol simbolo = tabla.resolver(nombre);

        if (simbolo == null) {
            error(token, "variable '" + nombre + "' no fue declarada.");
            visit(ctx.expresion());
            return null;
        }

        String tipoExpr = visit(ctx.expresion());

        if (tipoExpr != null && !TypeSystem.ERROR.equals(tipoExpr)) {
            if (!TypeSystem.esCompatibleAsignacion(simbolo.getTipo(), tipoExpr)) {
                error(token,
                      TypeSystem.msgIncompatible(simbolo.getTipo(), tipoExpr)
                      + " al asignar a '" + nombre + "'.");
            }
        }

        simbolo.setInicializado(true);
        return null;
    }

    // ── If ───────────────────────────────────────────────────────────────────

    @Override
    public String visitExpresion_if(MiLenguajeParser.Expresion_ifContext ctx) {
        String tipoCondicion = visit(ctx.expresion());
        Token  tokenIf       = ctx.IF().getSymbol();

        if (tipoCondicion != null && !TypeSystem.ERROR.equals(tipoCondicion)
                && !TypeSystem.BOOL.equals(tipoCondicion)) {
            error(tokenIf,
                  "la condición del 'if' debe ser bool, pero es '" + tipoCondicion + "'. "
                  + "Sugerencia: usa una comparación como 'x > 0'.");
        }

        // ctx.bloque() puede tener 1 (solo if) o 2 elementos (if + else).
        for (MiLenguajeParser.BloqueContext bloque : ctx.bloque()) {
            visit(bloque);
        }
        return null;
    }

    // ── While ────────────────────────────────────────────────────────────────

    @Override
    public String visitExpresion_while(MiLenguajeParser.Expresion_whileContext ctx) {
        String tipoCondicion = visit(ctx.expresion());
        Token  tokenWhile    = ctx.WHILE().getSymbol();

        if (tipoCondicion != null && !TypeSystem.ERROR.equals(tipoCondicion)
                && !TypeSystem.BOOL.equals(tipoCondicion)) {
            error(tokenWhile,
                  "la condición del 'while' debe ser bool, pero es '" + tipoCondicion + "'. "
                  + "Sugerencia: usa una comparación como 'x < 100'.");
        }

        visit(ctx.bloque());
        return null;
    }

    // ── For ──────────────────────────────────────────────────────────────────

    @Override
    public String visitExpresion_for(MiLenguajeParser.Expresion_forContext ctx) {
        // El for abre su propio scope para la variable del inicializador
        tabla.entrarScope("for");
        visit(ctx.declaracion());
        visit(ctx.condicion_for());
        visit(ctx.actualizacion());
        visit(ctx.bloque());
        tabla.salirScope();
        return null;
    }

    @Override
    public String visitCondicion_for(MiLenguajeParser.Condicion_forContext ctx) {
        String tipo = visit(ctx.expresion());
        if (tipo != null && !TypeSystem.ERROR.equals(tipo) && !TypeSystem.BOOL.equals(tipo)) {
            error(ctx.getStart(),
                  "la condición del 'for' debe ser bool, pero es '" + tipo + "'.");
        }
        return null;
    }

    @Override
    public String visitActualizacion(MiLenguajeParser.ActualizacionContext ctx) {
        String nombre = ctx.ID().getText();
        Token  token  = ctx.ID().getSymbol();

        Symbol simbolo = tabla.resolver(nombre);
        if (simbolo == null) {
            error(token, "variable '" + nombre + "' no fue declarada.");
            return null;
        }

        // Si es i = expresion, verificar tipo
        if (ctx.expresion() != null) {
            String tipoExpr = visit(ctx.expresion());
            if (tipoExpr != null && !TypeSystem.ERROR.equals(tipoExpr)
                    && !TypeSystem.esCompatibleAsignacion(simbolo.getTipo(), tipoExpr)) {
                error(token,
                      TypeSystem.msgIncompatible(simbolo.getTipo(), tipoExpr)
                      + " al actualizar '" + nombre + "'.");
            }
            simbolo.setInicializado(true);
        } else {
            // i++ / i--  →  debe ser numérico
            if (!TypeSystem.esNumerico(simbolo.getTipo())) {
                error(token,
                      "el operador '" + ctx.getText().replace(nombre, "")
                      + "' no puede aplicarse a tipo '" + simbolo.getTipo() + "'.");
            }
        }
        return null;
    }

    // ── Bloque (scope) ───────────────────────────────────────────────────────

    @Override
    public String visitBloque(MiLenguajeParser.BloqueContext ctx) {
        tabla.entrarScope("bloque");
        visitChildren(ctx);
        tabla.salirScope();
        return null;
    }

    // ── Declaración de función ───────────────────────────────────────────────

    @Override
    public String visitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
        String tipoRetorno = normalizarTipo(ctx.tipo().getText());
        String nombre      = ctx.ID().getText();
        Token  token       = ctx.ID().getSymbol();

        if (tabla.estaDeclaradoLocalmente(nombre)) {
            error(token, "función '" + nombre + "' ya fue declarada en este ámbito.");
            return null;
        }

        tabla.definir(Symbol.funcion(nombre, tipoRetorno, token.getLine(), token.getCharPositionInLine()));
        tabla.entrarScope("funcion_" + nombre);

        if (ctx.listaParametros() != null) {
            for (MiLenguajeParser.ParametroContext param : ctx.listaParametros().parametro()) {
                String tipoParam   = normalizarTipo(ctx.tipo().getText()); 
                String nombreParam = param.ID().getText();
                Token  tokenParam  = param.ID().getSymbol();
                tabla.definir(Symbol.parametro(nombreParam, tipoParam,
                                               tokenParam.getLine(), tokenParam.getCharPositionInLine()));
            }
        }

        String tipoAnterior = tipoRetornoActual;
        tipoRetornoActual   = tipoRetorno;

        // visitChildren sobre el bloque (no visit(bloque)) para evitar un scope extra.
        visitChildren(ctx.bloque());

        tipoRetornoActual = tipoAnterior;
        tabla.salirScope();
        return null;
    }

    // ── Return ───────────────────────────────────────────────────────────────

    @Override
    public String visitSentenciaReturn(MiLenguajeParser.SentenciaReturnContext ctx) {
        Token tokenReturn = ctx.RETURN().getSymbol();

        if (tipoRetornoActual == null) {
            error(tokenReturn, "'return' usado fuera de una función.");
            return null;
        }

        boolean tieneValor = (ctx.expresion() != null);

        if (tieneValor) {
            String tipoExpr = visit(ctx.expresion());
            if (TypeSystem.VOID.equals(tipoRetornoActual)) {
                error(tokenReturn, "función 'void' no puede retornar un valor.");
            } else if (tipoExpr != null && !TypeSystem.ERROR.equals(tipoExpr)
                       && !TypeSystem.esCompatibleAsignacion(tipoRetornoActual, tipoExpr)) {
                error(tokenReturn,
                      "tipo de retorno '" + tipoExpr + "' no es compatible con el tipo declarado '"
                      + tipoRetornoActual + "'.");
            }
        } else {
            if (!TypeSystem.VOID.equals(tipoRetornoActual)) {
                error(tokenReturn,
                      "función de tipo '" + tipoRetornoActual + "' debe retornar un valor.");
            }
        }

        return null;
    }

    // ── Expresiones binarias ────────────────────────────────────────────────

    @Override
    public String visitExprOr(MiLenguajeParser.ExprOrContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String res = TypeSystem.inferirLogico(izq, der);
        if (TypeSystem.ERROR.equals(res))
            error(ctx.OR().getSymbol(),
                  TypeSystem.msgOperadorInvalido("||", izq, der) + " (se esperan dos bool).");
        return res;
    }

    @Override
    public String visitExprAnd(MiLenguajeParser.ExprAndContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String res = TypeSystem.inferirLogico(izq, der);
        if (TypeSystem.ERROR.equals(res))
            error(ctx.AND().getSymbol(),
                  TypeSystem.msgOperadorInvalido("&&", izq, der) + " (se esperan dos bool).");
        return res;
    }

    @Override
    public String visitExprIgualdad(MiLenguajeParser.ExprIgualdadContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String op  = ctx.getChild(1).getText();
        String res = TypeSystem.inferirIgualdad(izq, der);
        if (TypeSystem.ERROR.equals(res)) {
            Token opToken = ((TerminalNode) ctx.getChild(1)).getSymbol();
            error(opToken, "no se pueden comparar '" + izq + "' y '" + der + "' con '" + op + "'.");
        }
        return res;
    }

    @Override
    public String visitExprRelacional(MiLenguajeParser.ExprRelacionalContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String op  = ctx.getChild(1).getText();
        String res = TypeSystem.inferirRelacional(izq, der);
        if (TypeSystem.ERROR.equals(res)) {
            Token opToken = ((TerminalNode) ctx.getChild(1)).getSymbol();
            error(opToken, TypeSystem.msgOperadorInvalido(op, izq, der) + " (se esperan tipos numéricos).");
        }
        return res;
    }

    @Override
    public String visitExprAditiva(MiLenguajeParser.ExprAditivaContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String op  = ctx.getChild(1).getText();
        String res = TypeSystem.inferirAritmetico(izq, der);
        if (TypeSystem.ERROR.equals(res)) {
            Token opToken = ((TerminalNode) ctx.getChild(1)).getSymbol();
            error(opToken, TypeSystem.msgOperadorInvalido(op, izq, der) + " (se esperan tipos numéricos).");
        }
        return res;
    }

    @Override
    public String visitExprMultiplicativa(MiLenguajeParser.ExprMultiplicativaContext ctx) {
        String izq = visit(ctx.expresion(0));
        String der = visit(ctx.expresion(1));
        String op  = ctx.getChild(1).getText();
        String res = TypeSystem.inferirAritmetico(izq, der);
        if (TypeSystem.ERROR.equals(res)) {
            Token opToken = ((TerminalNode) ctx.getChild(1)).getSymbol();
            error(opToken, TypeSystem.msgOperadorInvalido(op, izq, der) + " (se esperan tipos numéricos).");
        }
        return res;
    }

    // ── Expresiones unarias ─────────────────────────────────────────────────

    @Override
    public String visitExprNot(MiLenguajeParser.ExprNotContext ctx) {
        String operando = visit(ctx.expresion());
        String res      = TypeSystem.inferirNot(operando);
        if (TypeSystem.ERROR.equals(res))
            error(ctx.NOT().getSymbol(),
                  TypeSystem.msgUnarioInvalido("!", operando) + " (se espera bool).");
        return res;
    }

    @Override
    public String visitExprNegativo(MiLenguajeParser.ExprNegativoContext ctx) {
        String operando = visit(ctx.expresion());
        String res      = TypeSystem.inferirNegativo(operando);
        if (TypeSystem.ERROR.equals(res))
            error(ctx.RES().getSymbol(),
                  TypeSystem.msgUnarioInvalido("-", operando) + " (se espera tipo numérico).");
        return res;
    }

    @Override
    public String visitExprAgrupada(MiLenguajeParser.ExprAgrupadaContext ctx) {
        return visit(ctx.expresion());
    }

    // ── Literales ────────────────────────────────────────────────────────────

    @Override public String visitExprEntero(MiLenguajeParser.ExprEnteroContext ctx)       { return TypeSystem.INT;    }
    @Override public String visitExprDecimal(MiLenguajeParser.ExprDecimalContext ctx)     { return TypeSystem.DOUBLE; }
    @Override public String visitExprCaracter(MiLenguajeParser.ExprCaracterContext ctx)   { return TypeSystem.CHAR;   }
    @Override public String visitExprCadena(MiLenguajeParser.ExprCadenaContext ctx)       { return TypeSystem.STRING; }
    @Override public String visitExprVerdadero(MiLenguajeParser.ExprVerdaderoContext ctx) { return TypeSystem.BOOL;   }
    @Override public String visitExprFalso(MiLenguajeParser.ExprFalsoContext ctx)         { return TypeSystem.BOOL;   }

    // ── Llamada a función ───────────────────────────────────────────────────

    @Override
    public String visitExprLlamada(MiLenguajeParser.ExprLlamadaContext ctx) {
        String nombre  = ctx.ID().getText();
        Token  token   = ctx.ID().getSymbol();
        Symbol simbolo = tabla.resolver(nombre);

        if (simbolo == null) {
            error(token, "función '" + nombre + "' no fue declarada.");
            // Visitar argumentos igual para detectar errores dentro de ellos
            if (ctx.argumentos() != null) visit(ctx.argumentos());
            return TypeSystem.ERROR;
        }

        if (simbolo.getCategoria() != Symbol.Categoria.FUNCION) {
            error(token, "'" + nombre + "' no es una función, es una "
                         + simbolo.getCategoria().toString().toLowerCase() + ".");
            if (ctx.argumentos() != null) visit(ctx.argumentos());
            return TypeSystem.ERROR;
        }

        if (ctx.argumentos() != null) {
            visit(ctx.argumentos());
        }

        return simbolo.getTipo();
    }

    @Override
    public String visitArgumentos(MiLenguajeParser.ArgumentosContext ctx) {
        for (MiLenguajeParser.ExpresionContext e : ctx.expresion()) {
            visit(e);
        }
        return null;
    }

    // ── Identificador ────────────────────────────────────────────────────────

    @Override
    public String visitExprIdentificador(MiLenguajeParser.ExprIdentificadorContext ctx) {
        String nombre  = ctx.ID().getText();
        Token  token   = ctx.ID().getSymbol();
        Symbol simbolo = tabla.resolver(nombre);

        if (simbolo == null) {
            error(token, "variable '" + nombre + "' no fue declarada.");
            return TypeSystem.ERROR;
        }

        if (!simbolo.isInicializado()) {
            warning(token, "variable '" + nombre + "' podría no estar inicializada.");
        }

        return simbolo.getTipo();
    }
    private String normalizarTipo(String tipoTexto) {
        switch (tipoTexto) {
            case "String":  return TypeSystem.STRING;  // "string"
            case "boolean": return TypeSystem.BOOL;    // "bool"
            default:        return tipoTexto;          // int, double, char, void
        }
    }

    
}