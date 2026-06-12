package com.compilador.codigo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * GeneradorCodigo — "El Constructor".
 *
 * Conoce los detalles técnicos de la generación de código de 3 direcciones:
 *   - Crea nombres únicos para temporales (t0, t1, t2...)
 *   - Crea nombres únicos para etiquetas (L0, L1, L2...)
 *   - Almacena la lista de instrucciones generadas, en orden
 *   - Permite imprimirlas o guardarlas en un archivo
 *
 * No toma decisiones sobre QUÉ generar — eso es responsabilidad de
 * CodigoVisitor. Este solo ejecuta órdenes.
 */
public class GeneradorCodigo {

    private final List<String> instrucciones = new ArrayList<>();
    private int contadorTemporales = 0;
    private int contadorEtiquetas  = 0;

    // ── Temporales y etiquetas ────────────────────────────────────────────────

    /** Genera un nuevo nombre de variable temporal único: t0, t1, t2... */
    public String nuevoTemporal() {
        return "t" + (contadorTemporales++);
    }

    /** Genera un nuevo nombre de etiqueta único: L0, L1, L2... */
    public String nuevaEtiqueta() {
        return "L" + (contadorEtiquetas++);
    }

    // ── Emisión de instrucciones ─────────────────────────────────────────────

    /** Agrega una instrucción tal cual al final del listado. */
    public void emitir(String instruccion) {
        instrucciones.add(instruccion);
    }

    /**
     * Emite una asignación de 3 direcciones: destino = izq OP der
     * Ejemplo: emitirAsignacionBinaria("t0", "a", "+", "b") → "t0 = a + b"
     */
    public void emitirAsignacionBinaria(String destino, String izq, String op, String der) {
        emitir(destino + " = " + izq + " " + op + " " + der);
    }

    /**
     * Emite una asignación unaria: destino = OP operando
     * Ejemplo: emitirAsignacionUnaria("t0", "-", "a") → "t0 = -a"
     */
    public void emitirAsignacionUnaria(String destino, String op, String operando) {
        emitir(destino + " = " + op + operando);
    }

    /** Emite una copia simple: destino = origen */
    public void emitirCopia(String destino, String origen) {
        if (destino.equals(origen)) return; // evita "x = x"
        emitir(destino + " = " + origen);
    }

    /** Emite una etiqueta: "L0:" */
    public void emitirEtiqueta(String etiqueta) {
        emitir(etiqueta + ":");
    }

    /** Emite un salto incondicional: "goto L0" */
    public void emitirGoto(String etiqueta) {
        emitir("goto " + etiqueta);
    }

    /** Emite un salto condicional negado: "if !cond goto L0" */
    public void emitirIfFalseGoto(String condicion, String etiqueta) {
        emitir("if !" + condicion + " goto " + etiqueta);
    }

    /** Emite un salto condicional: "if cond goto L0" */
    public void emitirIfGoto(String condicion, String etiqueta) {
        emitir("if " + condicion + " goto " + etiqueta);
    }

    /** Emite una instrucción de impresión: "print x" */
    public void emitirPrint(String valor) {
        emitir("print " + valor);
    }

    /** Emite un return sin valor: "return" */
    public void emitirReturn() {
        emitir("return");
    }

    /** Emite un return con valor: "return t0" */
    public void emitirReturn(String valor) {
        emitir("return " + valor);
    }

    /** Emite la declaración de una etiqueta de función: "func_nombre:" */
    public void emitirInicioFuncion(String nombre) {
        emitir("func_" + nombre + ":");
    }

    /** Emite el fin de una función: "endfunc_nombre" */
    public void emitirFinFuncion(String nombre) {
        emitir("endfunc_" + nombre);
    }

    /**
     * Emite una llamada a función con resultado: destino = call nombre, args...
     * Ejemplo: "t0 = call suma, a, b"
     */
    public void emitirCall(String destino, String nombre, List<String> args) {
        String argsStr = String.join(", ", args);
        if (argsStr.isEmpty()) {
            emitir(destino + " = call " + nombre);
        } else {
            emitir(destino + " = call " + nombre + ", " + argsStr);
        }
    }

    /** Emite una llamada a función sin resultado (void). */
    public void emitirCallVoid(String nombre, List<String> args) {
        String argsStr = String.join(", ", args);
        if (argsStr.isEmpty()) {
            emitir("call " + nombre);
        } else {
            emitir("call " + nombre + ", " + argsStr);
        }
    }

    // ── Acceso al código generado ─────────────────────────────────────────────

    public List<String> getInstrucciones() {
        return instrucciones;
    }

    /** Cantidad de instrucciones generadas hasta ahora. */
    public int size() {
        return instrucciones.size();
    }

    /** Imprime el código de tres direcciones numerado, en consola. */
    public void imprimir() {
        for (int i = 0; i < instrucciones.size(); i++) {
            System.out.printf("%3d: %s%n", i, instrucciones.get(i));
        }
        System.out.println("\nTotal de instrucciones: " + instrucciones.size());
    }

    /**
     * Guarda el código generado en un archivo de texto, con el mismo formato
     * de encabezado y numeración que usa el material de la materia.
     */
    public void guardarArchivo(String ruta) throws IOException {
        try (PrintWriter out = new PrintWriter(ruta, "UTF-8")) {
            out.println("// Código de tres direcciones generado automáticamente");
            out.println("// Archivo: " + ruta);
            out.println("// Total de instrucciones: " + instrucciones.size());
            out.println();
            for (int i = 0; i < instrucciones.size(); i++) {
                out.printf("%3d: %s%n", i, instrucciones.get(i));
            }
        }
    }

    /** Reinicia el generador (útil para tests). */
    public void reset() {
        instrucciones.clear();
        contadorTemporales = 0;
        contadorEtiquetas  = 0;
    }
}