// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiLenguajeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiLenguajeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MiLenguajeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(MiLenguajeParser.TokenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaBloque}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaBloque(MiLenguajeParser.SentenciaBloqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaFor}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaFor(MiLenguajeParser.SentenciaForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaWhile}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaIf}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaFuncion}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaFuncion(MiLenguajeParser.SentenciaFuncionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaDeclaracion}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaDeclaracion(MiLenguajeParser.SentenciaDeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaAsignacion}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaAsignacion(MiLenguajeParser.SentenciaAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaRetorno}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaRetorno(MiLenguajeParser.SentenciaRetornoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaCout}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaCout(MiLenguajeParser.SentenciaCoutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SentenciaExpr}
	 * labeled alternative in {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaExpr(MiLenguajeParser.SentenciaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(MiLenguajeParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(MiLenguajeParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(MiLenguajeParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#sentenciaReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaReturn(MiLenguajeParser.SentenciaReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#listaParametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaParametros(MiLenguajeParser.ListaParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(MiLenguajeParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#expresion_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion_for(MiLenguajeParser.Expresion_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#condicion_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion_for(MiLenguajeParser.Condicion_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#actualizacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualizacion(MiLenguajeParser.ActualizacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#expresion_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion_while(MiLenguajeParser.Expresion_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#expresion_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion_if(MiLenguajeParser.Expresion_ifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAgrupada}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAgrupada(MiLenguajeParser.ExprAgrupadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEntero(MiLenguajeParser.ExprEnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLlamadaMetodo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLlamadaMetodo(MiLenguajeParser.ExprLlamadaMetodoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(MiLenguajeParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(MiLenguajeParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCadena(MiLenguajeParser.ExprCadenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIdentificador}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIdentificador(MiLenguajeParser.ExprIdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNegativo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNegativo(MiLenguajeParser.ExprNegativoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCaracter(MiLenguajeParser.ExprCaracterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprArreglo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArreglo(MiLenguajeParser.ExprArregloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLlamada}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLlamada(MiLenguajeParser.ExprLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNot(MiLenguajeParser.ExprNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAditiva}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAditiva(MiLenguajeParser.ExprAditivaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(MiLenguajeParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDecimal}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDecimal(MiLenguajeParser.ExprDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFalso}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFalso(MiLenguajeParser.ExprFalsoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVerdadero}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVerdadero(MiLenguajeParser.ExprVerdaderoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(MiLenguajeParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultiplicativa}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicativa(MiLenguajeParser.ExprMultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAccesoCampo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAccesoCampo(MiLenguajeParser.ExprAccesoCampoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(MiLenguajeParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(MiLenguajeParser.TipoContext ctx);
}