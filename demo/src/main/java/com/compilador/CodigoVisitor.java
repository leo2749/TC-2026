package com.compilador.codigo;

import java.util.ArrayList;
import java.util.List;

import com.compilador.MiLenguajeBaseVisitor;
import com.compilador.MiLenguajeParser;

/**
 * CodigoVisitor — "El Arquitecto".
 *
 * Recorre el AST (ya validado por el análisis semántico) y decide:
 *   - QUÉ instrucciones de 3 direcciones generar
 *   - CUÁNDO crear temporales y etiquetas
 *   - EN QUÉ ORDEN evaluar las cosas
 *
 * No conoce los detalles de "cómo" se ve una instrucción — eso lo
 * delega siempre a GeneradorCodigo.
 *
 * Cada visitXxx() de una EXPRESIÓN devuelve un String: el "lugar"
 * (variable, temporal o literal) donde queda el resultado de esa
 * expresión. Las SENTENCIAS devuelven null porque no producen un valor.
 */
public class CodigoVisitor extends MiLenguajeBaseVisitor<String> {

    private final GeneradorCodigo gen;

    public CodigoVisitor(GeneradorCodigo gen) {
        this.gen = gen;
    }

    public GeneradorCodigo getGenerador() {
        return gen;
    }

    // ── Programa ─────────────────────────────────────────────────────────────

    @Override
    public String visitPrograma(MiLenguajeParser.ProgramaContext ctx) {
        return visitChildren(ctx);
    }

    // ── Delegadores de "sentencia" ──────────────────────────────────────────

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
        visit(ctx.expresion());
        return null;
    }

    // ── System.out.println(expr) ────────────────────────────────────────────

    @Override
    public String visitSentenciaCout(MiLenguajeParser.SentenciaCoutContext ctx) {
        // ctx.argumentos() contiene lo que va dentro de println(...)
        if (ctx.argumentos() != null) {
            for (MiLenguajeParser.ExpresionContext arg : ctx.argumentos().expresion()) {
                String valor = visit(arg);
                gen.emitirPrint(valor);
            }
        }
        return null;
    }

    // ── Declaración de variables ────────────────────────────────────────────

    @Override
    public String visitDeclaracion(MiLenguajeParser.DeclaracionContext ctx) {
        String nombre = ctx.ID().getText();
        if (ctx.expresion() != null) {
            String valor = visit(ctx.expresion());
            gen.emitirCopia(nombre, valor);
        }
        // Si no tiene inicializador, no se genera código (la variable
        // simplemente queda reservada en la tabla de símbolos).
        return null;
    }

    // ── Asignación ───────────────────────────────────────────────────────────

    @Override
    public String visitAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String nombre = ctx.ID().getText();
        String valor  = visit(ctx.expresion());
        gen.emitirCopia(nombre, valor);
        return null;
    }

    // ── Bloque ───────────────────────────────────────────────────────────────

    @Override
    public String visitBloque(MiLenguajeParser.BloqueContext ctx) {
        return visitChildren(ctx);
    }

    // ── If / Else ────────────────────────────────────────────────────────────
    //
    //  if (cond) { ... }                    if (cond) { ... } else { ... }
    //
    //  t0 = cond                            t0 = cond
    //  if !t0 goto Lfin                     if !t0 goto Lelse
    //    ...bloque if...                      ...bloque if...
    //  Lfin:                                  goto Lfin
    //                                        Lelse:
    //                                          ...bloque else...
    //                                        Lfin:

    @Override
    public String visitExpresion_if(MiLenguajeParser.Expresion_ifContext ctx) {
        String cond = visit(ctx.expresion());

        boolean tieneElse = ctx.bloque().size() > 1;

        if (!tieneElse) {
            String lFin = gen.nuevaEtiqueta();
            gen.emitirIfFalseGoto(cond, lFin);
            visit(ctx.bloque(0));
            gen.emitirEtiqueta(lFin);
        } else {
            String lElse = gen.nuevaEtiqueta();
            String lFin  = gen.nuevaEtiqueta();

            gen.emitirIfFalseGoto(cond, lElse);
            visit(ctx.bloque(0));          // bloque del if
            gen.emitirGoto(lFin);
            gen.emitirEtiqueta(lElse);
            visit(ctx.bloque(1));          // bloque del else
            gen.emitirEtiqueta(lFin);
        }
        return null;
    }

    // ── While ────────────────────────────────────────────────────────────────
    //
    //  Linicio:
    //    t0 = cond
    //    if !t0 goto Lfin
    //    ...bloque...
    //    goto Linicio
    //  Lfin:

    @Override
    public String visitExpresion_while(MiLenguajeParser.Expresion_whileContext ctx) {
        String lInicio = gen.nuevaEtiqueta();
        String lFin    = gen.nuevaEtiqueta();

        gen.emitirEtiqueta(lInicio);
        String cond = visit(ctx.expresion());
        gen.emitirIfFalseGoto(cond, lFin);

        visit(ctx.bloque());

        gen.emitirGoto(lInicio);
        gen.emitirEtiqueta(lFin);
        return null;
    }

    // ── For ──────────────────────────────────────────────────────────────────
    //
    //  ...declaracion (inicializacion)...
    //  Linicio:
    //    t0 = condicion
    //    if !t0 goto Lfin
    //    ...bloque...
    //    ...actualizacion...
    //    goto Linicio
    //  Lfin:

    @Override
    public String visitExpresion_for(MiLenguajeParser.Expresion_forContext ctx) {
        // Inicialización (ej. int i = 0;)
        visit(ctx.declaracion());

        String lInicio = gen.nuevaEtiqueta();
        String lFin    = gen.nuevaEtiqueta();

        gen.emitirEtiqueta(lInicio);

        // Condición
        String cond = visit(ctx.condicion_for().expresion());
        gen.emitirIfFalseGoto(cond, lFin);

        // Cuerpo
        visit(ctx.bloque());

        // Actualización (ej. i++)
        visit(ctx.actualizacion());

        gen.emitirGoto(lInicio);
        gen.emitirEtiqueta(lFin);
        return null;
    }

    @Override
    public String visitActualizacion(MiLenguajeParser.ActualizacionContext ctx) {
        String nombre = ctx.ID().getText();

        if (ctx.expresion() != null) {
            // i = expresion
            String valor = visit(ctx.expresion());
            gen.emitirCopia(nombre, valor);
        } else {
            // i++  o  i--
            String texto = ctx.getText();
            String op = texto.endsWith("++") ? "+" : "-";
            String temp = gen.nuevoTemporal();
            gen.emitirAsignacionBinaria(temp, nombre, op, "1");
            gen.emitirCopia(nombre, temp);
        }
        return null;
    }

    // ── Función ──────────────────────────────────────────────────────────────

    @Override
    public String visitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
        String nombre = ctx.ID().getText();

        gen.emitirInicioFuncion(nombre);

        // Los parámetros llegan ya colocados por la convención de llamada;
        // no se genera código adicional para ellos aquí.
        visitChildren(ctx.bloque());

        return null;
    }

    // ── Return ───────────────────────────────────────────────────────────────

    @Override
    public String visitSentenciaReturn(MiLenguajeParser.SentenciaReturnContext ctx) {
        if (ctx.expresion() != null) {
            String valor = visit(ctx.expresion());
            gen.emitirReturn(valor);
        } else {
            gen.emitirReturn();
        }
        return null;
    }

    // ── Expresiones binarias ─────────────────────────────────────────────────
    //
    // IMPORTANTE: el orden de evaluación es siempre IZQUIERDA primero,
    // luego DERECHA. Esto es crítico para operadores no conmutativos
    // (-, /, %, <, >, <=, >=) — invertir el orden cambia el resultado.

    @Override
    public String visitExprOr(MiLenguajeParser.ExprOrContext ctx) {
        return generarBinaria(ctx.expresion(0), "||", ctx.expresion(1));
    }

    @Override
    public String visitExprAnd(MiLenguajeParser.ExprAndContext ctx) {
        return generarBinaria(ctx.expresion(0), "&&", ctx.expresion(1));
    }

    @Override
    public String visitExprIgualdad(MiLenguajeParser.ExprIgualdadContext ctx) {
        String op = ctx.getChild(1).getText(); // == o !=
        return generarBinaria(ctx.expresion(0), op, ctx.expresion(1));
    }

    @Override
    public String visitExprRelacional(MiLenguajeParser.ExprRelacionalContext ctx) {
        String op = ctx.getChild(1).getText(); // < > <= >=
        return generarBinaria(ctx.expresion(0), op, ctx.expresion(1));
    }

    @Override
    public String visitExprAditiva(MiLenguajeParser.ExprAditivaContext ctx) {
        String op = ctx.getChild(1).getText(); // + -
        return generarBinaria(ctx.expresion(0), op, ctx.expresion(1));
    }

    @Override
    public String visitExprMultiplicativa(MiLenguajeParser.ExprMultiplicativaContext ctx) {
        String op = ctx.getChild(1).getText(); // * / %

        // ── Verificación de división por cero literal ──────────────────────
        if ((op.equals("/") || op.equals("%"))
                && esLiteralCero(ctx.expresion(1))) {
            // Se reporta como comentario en el código intermedio.
            // (El error real ya debería haberse detectado en semántico
            //  si se desea bloquear la compilación; aquí solo se deja
            //  constancia en el TAC.)
            gen.emitir("// ADVERTENCIA: división por cero detectada en línea "
                       + ctx.getStart().getLine());
        }

        return generarBinaria(ctx.expresion(0), op, ctx.expresion(1));
    }

    /**
     * Genera el código de 3 direcciones para una operación binaria genérica:
     *   1. Evalúa el operando izquierdo (en ese orden)
     *   2. Evalúa el operando derecho
     *   3. Emite: temp = izq OP der
     *   4. Devuelve "temp" como lugar del resultado
     *
     * El orden izquierda→derecha se respeta SIEMPRE, lo cual es obligatorio
     * para operadores no conmutativos como -, /, %, <, >, <=, >=.
     */
    private String generarBinaria(MiLenguajeParser.ExpresionContext izqCtx,
                                   String operador,
                                   MiLenguajeParser.ExpresionContext derCtx) {
        String izq = visit(izqCtx);
        String der = visit(derCtx);
        String temp = gen.nuevoTemporal();
        gen.emitirAsignacionBinaria(temp, izq, operador, der);
        return temp;
    }

    /** true si la expresión es literalmente el entero 0 (para detectar división por cero). */
    private boolean esLiteralCero(MiLenguajeParser.ExpresionContext ctx) {
        if (ctx instanceof MiLenguajeParser.ExprEnteroContext) {
            return ctx.getText().equals("0");
        }
        if (ctx instanceof MiLenguajeParser.ExprDecimalContext) {
            try {
                return Double.parseDouble(ctx.getText()) == 0.0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    // ── Expresiones unarias ─────────────────────────────────────────────────

    @Override
    public String visitExprNot(MiLenguajeParser.ExprNotContext ctx) {
        String operando = visit(ctx.expresion());
        String temp = gen.nuevoTemporal();
        gen.emitirAsignacionUnaria(temp, "!", operando);
        return temp;
    }

    @Override
    public String visitExprNegativo(MiLenguajeParser.ExprNegativoContext ctx) {
        String operando = visit(ctx.expresion());
        String temp = gen.nuevoTemporal();
        gen.emitirAsignacionUnaria(temp, "-", operando);
        return temp;
    }

    @Override
    public String visitExprAgrupada(MiLenguajeParser.ExprAgrupadaContext ctx) {
        // Los paréntesis solo afectan la precedencia, ya resuelta por el parser.
        // No generan instrucciones propias.
        return visit(ctx.expresion());
    }

    // ── Literales ────────────────────────────────────────────────────────────
    //
    // Los literales no necesitan temporales: se usan directamente como
    // operandos en las instrucciones que los referencian.

    @Override
    public String visitExprEntero(MiLenguajeParser.ExprEnteroContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitExprDecimal(MiLenguajeParser.ExprDecimalContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitExprCaracter(MiLenguajeParser.ExprCaracterContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitExprCadena(MiLenguajeParser.ExprCadenaContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitExprVerdadero(MiLenguajeParser.ExprVerdaderoContext ctx) {
        return "true";
    }

    @Override
    public String visitExprFalso(MiLenguajeParser.ExprFalsoContext ctx) {
        return "false";
    }

    // ── Identificador ────────────────────────────────────────────────────────

    @Override
    public String visitExprIdentificador(MiLenguajeParser.ExprIdentificadorContext ctx) {
        // El "lugar" de una variable es simplemente su propio nombre.
        return ctx.ID().getText();
    }

    // ── Llamada a función ───────────────────────────────────────────────────

    @Override
    public String visitExprLlamada(MiLenguajeParser.ExprLlamadaContext ctx) {
        String nombre = ctx.ID().getText();

        List<String> args = new ArrayList<>();
        if (ctx.argumentos() != null) {
            for (MiLenguajeParser.ExpresionContext arg : ctx.argumentos().expresion()) {
                args.add(visit(arg));
            }
        }

        String temp = gen.nuevoTemporal();
        gen.emitirCall(temp, nombre, args);
        return temp;
    }
}