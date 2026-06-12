package com.compilador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import com.compilador.codigo.CodigoVisitor;
import com.compilador.codigo.GeneradorCodigo;
import com.compilador.semantico.SemanticAnalyzer;
import com.compilador.semantico.SemanticError;

public class App {

    // ── Colores ANSI ──────────────────────────────────────────────────────────
    private static final String RESET   = "\u001B[0m";
    private static final String ROJO    = "\u001B[31m";
    private static final String AMBAR   = "\u001B[33m";
    private static final String VERDE   = "\u001B[32m";
    private static final String CYAN    = "\u001B[36m";
    private static final String NEGRITA = "\u001B[1m";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar demo-1.0-jar-with-dependencies.jar <archivo.txt>");
            System.exit(1);
        }

        try {
            CharStream input = CharStreams.fromFileName(args[0]);
            System.out.println(NEGRITA + CYAN + "Analizando archivo: " + args[0] + RESET);

            // ── FASE 1: ANÁLISIS LÉXICO ───────────────────────────────────────
            MiLenguajeLexer lexer = new MiLenguajeLexer(input);

            List<String> erroresLexicos = new ArrayList<>();
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine, String msg,
                                        RecognitionException e) {
                    erroresLexicos.add("  [L" + line + ":" + charPositionInLine + "] " + msg);
                }
            });

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();

            System.out.println(NEGRITA + "\n=== ANÁLISIS LÉXICO ===" + RESET);
            System.out.printf("%-20s %-30s %-10s %-10s\n", "TIPO", "LEXEMA", "LÍNEA", "COLUMNA");
            System.out.println("-".repeat(72));

            for (Token token : tokens.getTokens()) {
                if (token.getType() != Token.EOF) {
                    String tokenName = MiLenguajeLexer.VOCABULARY.getSymbolicName(token.getType());
                    System.out.printf("%-20s %-30s %-10d %-10d\n",
                        tokenName, token.getText(),
                        token.getLine(), token.getCharPositionInLine());
                }
            }

            if (!erroresLexicos.isEmpty()) {
                System.out.println(ROJO + "\n✖  Errores léxicos encontrados:" + RESET);
                erroresLexicos.forEach(e -> System.out.println(ROJO + e + RESET));
                System.out.println(ROJO + "\n✖  Análisis detenido por errores léxicos." + RESET);
                System.exit(1);
            }
            System.out.println(VERDE + "\n✔  Análisis léxico completado sin errores." + RESET);

            // ── FASE 2: ANÁLISIS SINTÁCTICO ───────────────────────────────────
            tokens.reset();
            MiLenguajeParser parser = new MiLenguajeParser(tokens);

            List<String> erroresSintacticos = new ArrayList<>();
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine, String msg,
                                        RecognitionException e) {
                    String simbolo = offendingSymbol != null ? " cerca de '" + offendingSymbol + "'" : "";
                    erroresSintacticos.add("  [L" + line + ":" + charPositionInLine + "]" +
                                           simbolo + " → " + msg);
                }
            });

            ParseTree tree = parser.programa();

            System.out.println(NEGRITA + "\n=== ANÁLISIS SINTÁCTICO ===" + RESET);
            if (!erroresSintacticos.isEmpty()) {
                System.out.println(ROJO + "✖  Errores sintácticos encontrados:" + RESET);
                erroresSintacticos.forEach(e -> System.out.println(ROJO + e + RESET));
                System.out.println(ROJO + "\n✖  Análisis detenido por errores sintácticos." + RESET);
                System.exit(1);
            }
            System.out.println(VERDE + "✔  Análisis sintáctico completado sin errores." + RESET);

            // ── FASE 3: ANÁLISIS SEMÁNTICO ────────────────────────────────────
            System.out.println(NEGRITA + "\n=== ANÁLISIS SEMÁNTICO ===" + RESET);

            SemanticAnalyzer semantico = new SemanticAnalyzer();
            semantico.visit(tree);

            // Tabla de símbolos
            semantico.getTablaSimbolos().imprimirTabla();

            // Advertencias
            List<SemanticError> advertencias = semantico.getAdvertencias();
            if (!advertencias.isEmpty()) {
                System.out.println(NEGRITA + AMBAR + "\n=== ADVERTENCIAS (" + advertencias.size() + ") ===" + RESET);
                for (SemanticError a : advertencias) {
                    System.out.println(AMBAR + "⚠  " + a + RESET);
                }
            }

            // Errores
            List<SemanticError> errores = semantico.getErrores();
            if (!errores.isEmpty()) {
                System.out.println(NEGRITA + ROJO + "\n=== ERRORES SEMÁNTICOS (" + errores.size() + ") ===" + RESET);
                for (SemanticError e : errores) {
                    System.out.println(ROJO + "✖  " + e + RESET);
                }
                System.out.println(NEGRITA + ROJO + "\n✖  Análisis semántico completado con errores." + RESET);
                System.exit(1);
            } else {
                System.out.println(NEGRITA + VERDE + "\n✔  Análisis semántico completado sin errores." + RESET);
                if (!advertencias.isEmpty()) {
                    System.out.println(AMBAR + "⚠  Se encontraron " + advertencias.size() + " advertencia(s)." + RESET);
                }

                // ── FASE 4: CÓDIGO INTERMEDIO (TAC) ─────────────────────────
                System.out.println(NEGRITA + "\n=== CÓDIGO INTERMEDIO (3 DIRECCIONES) ===" + RESET);

                GeneradorCodigo generador = new GeneradorCodigo();
                CodigoVisitor codigoVisitor = new CodigoVisitor(generador);
                codigoVisitor.visit(tree);

                generador.imprimir();

                try {
                    generador.guardarArchivo("codigo_intermedio.txt");
                    System.out.println(VERDE + "\n✔  Código intermedio guardado en 'codigo_intermedio.txt'" + RESET);
                } catch (IOException ioEx) {
                    System.out.println(ROJO + "✖  No se pudo guardar el archivo: " + ioEx.getMessage() + RESET);
                }

                // ── ÁRBOL DE PARSEO ────────────────────────────────────────────
                // Solo se muestra si TODAS las fases pasaron sin errores.
                System.out.println(CYAN + "\nAbriendo ventana con el árbol de parseo..." + RESET);
                javax.swing.SwingUtilities.invokeLater(() -> {
                    Trees.inspect(tree, parser);
                });
            }

        } catch (IOException e) {
            System.err.println(ROJO + "✖  Error al leer el archivo: " + e.getMessage() + RESET);
            System.exit(1);
        } catch (Exception e) {
            System.err.println(ROJO + "✖  Error inesperado: " + e.getMessage() + RESET);
            e.printStackTrace();
            System.exit(1);
        }
    }
}