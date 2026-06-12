// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PA=1, PC=2, CA=3, CC=4, LA=5, LC=6, PYC=7, COMA=8, PUNTO=9, IGUAL=10, 
		EQL=11, DISTINTO=12, MAYOR_IGUAL=13, MENOR_IGUAL=14, MAYOR=15, MENOR=16, 
		SUM=17, RES=18, MUL=19, DIV=20, MOD=21, SUMSUM=22, RESRES=23, OR=24, AND=25, 
		NOT=26, FOR=27, WHILE=28, IF=29, ELSE=30, INT=31, CHAR=32, DOUBLE=33, 
		VOID=34, RETURN=35, TRUE=36, FALSE=37, BOOLEAN_TYPE=38, STRING_TYPE=39, 
		ID=40, INTEGER=41, DECIMAL=42, CHARACTER=43, STRING=44, COMENTARIO_LINEA=45, 
		COMENTARIO_BLOQUE=46, WS=47, OTRO=48;
	public static final int
		RULE_programa = 0, RULE_token = 1, RULE_sentencia = 2, RULE_bloque = 3, 
		RULE_declaracion = 4, RULE_asignacion = 5, RULE_sentenciaReturn = 6, RULE_declaracionFuncion = 7, 
		RULE_listaParametros = 8, RULE_parametro = 9, RULE_expresion_for = 10, 
		RULE_condicion_for = 11, RULE_actualizacion = 12, RULE_expresion_while = 13, 
		RULE_expresion_if = 14, RULE_expresion = 15, RULE_argumentos = 16, RULE_tipo = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "token", "sentencia", "bloque", "declaracion", "asignacion", 
			"sentenciaReturn", "declaracionFuncion", "listaParametros", "parametro", 
			"expresion_for", "condicion_for", "actualizacion", "expresion_while", 
			"expresion_if", "expresion", "argumentos", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "'.'", 
			"'='", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'++'", "'--'", "'||'", "'&&'", "'!'", "'for'", "'while'", 
			"'if'", "'else'", "'int'", "'char'", "'double'", "'void'", "'return'", 
			"'true'", "'false'", "'boolean'", "'String'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "PUNTO", "IGUAL", 
			"EQL", "DISTINTO", "MAYOR_IGUAL", "MENOR_IGUAL", "MAYOR", "MENOR", "SUM", 
			"RES", "MUL", "DIV", "MOD", "SUMSUM", "RESRES", "OR", "AND", "NOT", "FOR", 
			"WHILE", "IF", "ELSE", "INT", "CHAR", "DOUBLE", "VOID", "RETURN", "TRUE", 
			"FALSE", "BOOLEAN_TYPE", "STRING_TYPE", "ID", "INTEGER", "DECIMAL", "CHARACTER", 
			"STRING", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "WS", "OTRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiLenguajeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiLenguajeParser.EOF, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << LA) | (1L << RES) | (1L << NOT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << RETURN) | (1L << TRUE) | (1L << FALSE) | (1L << BOOLEAN_TYPE) | (1L << STRING_TYPE) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
				{
				{
				setState(36);
				sentencia();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public TerminalNode LA() { return getToken(MiLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiLenguajeParser.LC, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public TerminalNode COMA() { return getToken(MiLenguajeParser.COMA, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public TerminalNode MAYOR() { return getToken(MiLenguajeParser.MAYOR, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(MiLenguajeParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR() { return getToken(MiLenguajeParser.MENOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(MiLenguajeParser.MENOR_IGUAL, 0); }
		public TerminalNode EQL() { return getToken(MiLenguajeParser.EQL, 0); }
		public TerminalNode DISTINTO() { return getToken(MiLenguajeParser.DISTINTO, 0); }
		public TerminalNode SUM() { return getToken(MiLenguajeParser.SUM, 0); }
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public TerminalNode MUL() { return getToken(MiLenguajeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiLenguajeParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiLenguajeParser.MOD, 0); }
		public TerminalNode OR() { return getToken(MiLenguajeParser.OR, 0); }
		public TerminalNode AND() { return getToken(MiLenguajeParser.AND, 0); }
		public TerminalNode NOT() { return getToken(MiLenguajeParser.NOT, 0); }
		public TerminalNode FOR() { return getToken(MiLenguajeParser.FOR, 0); }
		public TerminalNode WHILE() { return getToken(MiLenguajeParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(MiLenguajeParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(MiLenguajeParser.ELSE, 0); }
		public TerminalNode INT() { return getToken(MiLenguajeParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiLenguajeParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(MiLenguajeParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(MiLenguajeParser.VOID, 0); }
		public TerminalNode RETURN() { return getToken(MiLenguajeParser.RETURN, 0); }
		public TerminalNode TRUE() { return getToken(MiLenguajeParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MiLenguajeParser.FALSE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(MiLenguajeParser.BOOLEAN_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(MiLenguajeParser.STRING_TYPE, 0); }
		public TerminalNode PUNTO() { return getToken(MiLenguajeParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(MiLenguajeParser.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(MiLenguajeParser.DECIMAL, 0); }
		public TerminalNode CHARACTER() { return getToken(MiLenguajeParser.CHARACTER, 0); }
		public TerminalNode STRING() { return getToken(MiLenguajeParser.STRING, 0); }
		public TerminalNode OTRO() { return getToken(MiLenguajeParser.OTRO, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_token);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << PC) | (1L << CA) | (1L << CC) | (1L << LA) | (1L << LC) | (1L << PYC) | (1L << COMA) | (1L << PUNTO) | (1L << IGUAL) | (1L << EQL) | (1L << DISTINTO) | (1L << MAYOR_IGUAL) | (1L << MENOR_IGUAL) | (1L << MAYOR) | (1L << MENOR) | (1L << SUM) | (1L << RES) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << OR) | (1L << AND) | (1L << NOT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << ELSE) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << RETURN) | (1L << TRUE) | (1L << FALSE) | (1L << BOOLEAN_TYPE) | (1L << STRING_TYPE) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING) | (1L << OTRO))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContext extends ParserRuleContext {
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	 
		public SentenciaContext() { }
		public void copyFrom(SentenciaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SentenciaForContext extends SentenciaContext {
		public Expresion_forContext expresion_for() {
			return getRuleContext(Expresion_forContext.class,0);
		}
		public SentenciaForContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaWhileContext extends SentenciaContext {
		public Expresion_whileContext expresion_while() {
			return getRuleContext(Expresion_whileContext.class,0);
		}
		public SentenciaWhileContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaExprContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaExprContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaRetornoContext extends SentenciaContext {
		public SentenciaReturnContext sentenciaReturn() {
			return getRuleContext(SentenciaReturnContext.class,0);
		}
		public SentenciaRetornoContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaRetorno(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaAsignacionContext extends SentenciaContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public SentenciaAsignacionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaIfContext extends SentenciaContext {
		public Expresion_ifContext expresion_if() {
			return getRuleContext(Expresion_ifContext.class,0);
		}
		public SentenciaIfContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaDeclaracionContext extends SentenciaContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public SentenciaDeclaracionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaBloqueContext extends SentenciaContext {
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentenciaBloqueContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaBloque(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaFuncionContext extends SentenciaContext {
		public DeclaracionFuncionContext declaracionFuncion() {
			return getRuleContext(DeclaracionFuncionContext.class,0);
		}
		public SentenciaFuncionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaFuncion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SentenciaCoutContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO() { return getToken(MiLenguajeParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public SentenciaCoutContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaCout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sentencia);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SentenciaBloqueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				bloque();
				}
				break;
			case 2:
				_localctx = new SentenciaForContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				expresion_for();
				}
				break;
			case 3:
				_localctx = new SentenciaWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				expresion_while();
				}
				break;
			case 4:
				_localctx = new SentenciaIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				expresion_if();
				}
				break;
			case 5:
				_localctx = new SentenciaFuncionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				declaracionFuncion();
				}
				break;
			case 6:
				_localctx = new SentenciaDeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				declaracion();
				}
				break;
			case 7:
				_localctx = new SentenciaAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				asignacion();
				}
				break;
			case 8:
				_localctx = new SentenciaRetornoContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(53);
				sentenciaReturn();
				}
				break;
			case 9:
				_localctx = new SentenciaCoutContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(54);
				expresion(0);
				setState(55);
				match(PUNTO);
				setState(56);
				match(ID);
				setState(57);
				match(PA);
				setState(58);
				argumentos();
				setState(59);
				match(PC);
				setState(60);
				match(PYC);
				}
				break;
			case 10:
				_localctx = new SentenciaExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(62);
				expresion(0);
				setState(63);
				match(PYC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(MiLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiLenguajeParser.LC, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(LA);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << LA) | (1L << RES) | (1L << NOT) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << RETURN) | (1L << TRUE) | (1L << FALSE) | (1L << BOOLEAN_TYPE) | (1L << STRING_TYPE) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
				{
				{
				setState(68);
				sentencia();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(LC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracion);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				tipo();
				setState(77);
				match(ID);
				setState(78);
				match(PYC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				tipo();
				setState(81);
				match(ID);
				setState(82);
				match(IGUAL);
				setState(83);
				expresion(0);
				setState(84);
				match(PYC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(ID);
			setState(89);
			match(IGUAL);
			setState(90);
			expresion(0);
			setState(91);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiLenguajeParser.RETURN, 0); }
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SentenciaReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaReturn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitSentenciaReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaReturnContext sentenciaReturn() throws RecognitionException {
		SentenciaReturnContext _localctx = new SentenciaReturnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentenciaReturn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(RETURN);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << RES) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
				{
				setState(94);
				expresion(0);
				}
			}

			setState(97);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionFuncionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ListaParametrosContext listaParametros() {
			return getRuleContext(ListaParametrosContext.class,0);
		}
		public DeclaracionFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionFuncion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitDeclaracionFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionFuncionContext declaracionFuncion() throws RecognitionException {
		DeclaracionFuncionContext _localctx = new DeclaracionFuncionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaracionFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			tipo();
			setState(100);
			match(ID);
			setState(101);
			match(PA);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOLEAN_TYPE) | (1L << STRING_TYPE))) != 0)) {
				{
				setState(102);
				listaParametros();
				}
			}

			setState(105);
			match(PC);
			setState(106);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiLenguajeParser.COMA, i);
		}
		public ListaParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParametros; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitListaParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaParametrosContext listaParametros() throws RecognitionException {
		ListaParametrosContext _localctx = new ListaParametrosContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listaParametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			parametro();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(109);
				match(COMA);
				setState(110);
				parametro();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			tipo();
			setState(117);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expresion_forContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiLenguajeParser.FOR, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public Condicion_forContext condicion_for() {
			return getRuleContext(Condicion_forContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiLenguajeParser.PYC, 0); }
		public ActualizacionContext actualizacion() {
			return getRuleContext(ActualizacionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Expresion_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion_for; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExpresion_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expresion_forContext expresion_for() throws RecognitionException {
		Expresion_forContext _localctx = new Expresion_forContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expresion_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(FOR);
			setState(120);
			match(PA);
			setState(121);
			declaracion();
			setState(122);
			condicion_for();
			setState(123);
			match(PYC);
			setState(124);
			actualizacion();
			setState(125);
			match(PC);
			setState(126);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Condicion_forContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public Condicion_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicion_for; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitCondicion_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condicion_forContext condicion_for() throws RecognitionException {
		Condicion_forContext _localctx = new Condicion_forContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condicion_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			expresion(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualizacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode SUMSUM() { return getToken(MiLenguajeParser.SUMSUM, 0); }
		public TerminalNode RESRES() { return getToken(MiLenguajeParser.RESRES, 0); }
		public TerminalNode IGUAL() { return getToken(MiLenguajeParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ActualizacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualizacion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitActualizacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualizacionContext actualizacion() throws RecognitionException {
		ActualizacionContext _localctx = new ActualizacionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_actualizacion);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(ID);
				setState(131);
				match(SUMSUM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(ID);
				setState(133);
				match(RESRES);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(ID);
				setState(135);
				match(IGUAL);
				setState(136);
				expresion(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expresion_whileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiLenguajeParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Expresion_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion_while; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExpresion_while(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expresion_whileContext expresion_while() throws RecognitionException {
		Expresion_whileContext _localctx = new Expresion_whileContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expresion_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(WHILE);
			setState(140);
			match(PA);
			setState(141);
			expresion(0);
			setState(142);
			match(PC);
			setState(143);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expresion_ifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiLenguajeParser.IF, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiLenguajeParser.ELSE, 0); }
		public Expresion_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion_if; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExpresion_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expresion_ifContext expresion_if() throws RecognitionException {
		Expresion_ifContext _localctx = new Expresion_ifContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expresion_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(IF);
			setState(146);
			match(PA);
			setState(147);
			expresion(0);
			setState(148);
			match(PC);
			setState(149);
			bloque();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(150);
				match(ELSE);
				setState(151);
				bloque();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprAgrupadaContext extends ExpresionContext {
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public ExprAgrupadaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAgrupada(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprEnteroContext extends ExpresionContext {
		public TerminalNode INTEGER() { return getToken(MiLenguajeParser.INTEGER, 0); }
		public ExprEnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprEntero(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLlamadaMetodoContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO() { return getToken(MiLenguajeParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public ExprLlamadaMetodoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprLlamadaMetodo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIgualdadContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode EQL() { return getToken(MiLenguajeParser.EQL, 0); }
		public TerminalNode DISTINTO() { return getToken(MiLenguajeParser.DISTINTO, 0); }
		public ExprIgualdadContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprRelacionalContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYOR() { return getToken(MiLenguajeParser.MAYOR, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(MiLenguajeParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR() { return getToken(MiLenguajeParser.MENOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(MiLenguajeParser.MENOR_IGUAL, 0); }
		public ExprRelacionalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCadenaContext extends ExpresionContext {
		public TerminalNode STRING() { return getToken(MiLenguajeParser.STRING, 0); }
		public ExprCadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprCadena(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIdentificadorContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public ExprIdentificadorContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNegativoContext extends ExpresionContext {
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprNegativoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprNegativo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCaracterContext extends ExpresionContext {
		public TerminalNode CHARACTER() { return getToken(MiLenguajeParser.CHARACTER, 0); }
		public ExprCaracterContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprCaracter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprArregloContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode CA() { return getToken(MiLenguajeParser.CA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode CC() { return getToken(MiLenguajeParser.CC, 0); }
		public ExprArregloContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLlamadaContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiLenguajeParser.PA, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiLenguajeParser.PC, 0); }
		public ExprLlamadaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprLlamada(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNotContext extends ExpresionContext {
		public TerminalNode NOT() { return getToken(MiLenguajeParser.NOT, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprNotContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAditivaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode SUM() { return getToken(MiLenguajeParser.SUM, 0); }
		public TerminalNode RES() { return getToken(MiLenguajeParser.RES, 0); }
		public ExprAditivaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAditiva(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAndContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode AND() { return getToken(MiLenguajeParser.AND, 0); }
		public ExprAndContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDecimalContext extends ExpresionContext {
		public TerminalNode DECIMAL() { return getToken(MiLenguajeParser.DECIMAL, 0); }
		public ExprDecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFalsoContext extends ExpresionContext {
		public TerminalNode FALSE() { return getToken(MiLenguajeParser.FALSE, 0); }
		public ExprFalsoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprFalso(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprVerdaderoContext extends ExpresionContext {
		public TerminalNode TRUE() { return getToken(MiLenguajeParser.TRUE, 0); }
		public ExprVerdaderoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprVerdadero(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprOrContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OR() { return getToken(MiLenguajeParser.OR, 0); }
		public ExprOrContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultiplicativaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MiLenguajeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MiLenguajeParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiLenguajeParser.MOD, 0); }
		public ExprMultiplicativaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprMultiplicativa(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAccesoCampoContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO() { return getToken(MiLenguajeParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(MiLenguajeParser.ID, 0); }
		public ExprAccesoCampoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitExprAccesoCampo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(155);
				match(NOT);
				setState(156);
				expresion(18);
				}
				break;
			case 2:
				{
				_localctx = new ExprNegativoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(RES);
				setState(158);
				expresion(13);
				}
				break;
			case 3:
				{
				_localctx = new ExprAgrupadaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(PA);
				setState(160);
				expresion(0);
				setState(161);
				match(PC);
				}
				break;
			case 4:
				{
				_localctx = new ExprArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(ID);
				setState(164);
				match(CA);
				setState(165);
				expresion(0);
				setState(166);
				match(CC);
				}
				break;
			case 5:
				{
				_localctx = new ExprLlamadaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(ID);
				setState(169);
				match(PA);
				setState(170);
				argumentos();
				setState(171);
				match(PC);
				}
				break;
			case 6:
				{
				_localctx = new ExprIdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(ID);
				}
				break;
			case 7:
				{
				_localctx = new ExprEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(INTEGER);
				}
				break;
			case 8:
				{
				_localctx = new ExprDecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(DECIMAL);
				}
				break;
			case 9:
				{
				_localctx = new ExprCaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(CHARACTER);
				}
				break;
			case 10:
				{
				_localctx = new ExprCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new ExprVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(TRUE);
				}
				break;
			case 12:
				{
				_localctx = new ExprFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(210);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExprOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(182);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(183);
						match(OR);
						setState(184);
						expresion(21);
						}
						break;
					case 2:
						{
						_localctx = new ExprAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(185);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(186);
						match(AND);
						setState(187);
						expresion(20);
						}
						break;
					case 3:
						{
						_localctx = new ExprIgualdadContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(188);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(189);
						_la = _input.LA(1);
						if ( !(_la==EQL || _la==DISTINTO) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(190);
						expresion(18);
						}
						break;
					case 4:
						{
						_localctx = new ExprRelacionalContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(191);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(192);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAYOR_IGUAL) | (1L << MENOR_IGUAL) | (1L << MAYOR) | (1L << MENOR))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(193);
						expresion(17);
						}
						break;
					case 5:
						{
						_localctx = new ExprAditivaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(194);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(195);
						_la = _input.LA(1);
						if ( !(_la==SUM || _la==RES) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(196);
						expresion(16);
						}
						break;
					case 6:
						{
						_localctx = new ExprMultiplicativaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(197);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(198);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(199);
						expresion(15);
						}
						break;
					case 7:
						{
						_localctx = new ExprLlamadaMetodoContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(200);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(201);
						match(PUNTO);
						setState(202);
						match(ID);
						setState(203);
						match(PA);
						setState(204);
						argumentos();
						setState(205);
						match(PC);
						}
						break;
					case 8:
						{
						_localctx = new ExprAccesoCampoContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(207);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(208);
						match(PUNTO);
						setState(209);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiLenguajeParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << RES) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER) | (1L << STRING))) != 0)) {
				{
				setState(215);
				expresion(0);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(216);
					match(COMA);
					setState(217);
					expresion(0);
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiLenguajeParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiLenguajeParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(MiLenguajeParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(MiLenguajeParser.VOID, 0); }
		public TerminalNode STRING_TYPE() { return getToken(MiLenguajeParser.STRING_TYPE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(MiLenguajeParser.BOOLEAN_TYPE, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiLenguajeVisitor ) return ((MiLenguajeVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << BOOLEAN_TYPE) | (1L << STRING_TYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u00e6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4D\n\4"+
		"\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6Y\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\5\bb\n\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\5\tj\n\t\3\t\3\t\3\t\3\n\3\n\3\n\7\nr\n\n\f\n\16\nu\13\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16\u008c\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u009b\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b7\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00d5\n\21"+
		"\f\21\16\21\u00d8\13\21\3\22\3\22\3\22\7\22\u00dd\n\22\f\22\16\22\u00e0"+
		"\13\22\5\22\u00e2\n\22\3\23\3\23\3\23\2\3 \24\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$\2\b\5\2\3\27\32.\62\62\3\2\r\16\3\2\17\22\3\2\23\24"+
		"\3\2\25\27\4\2!$()\2\u00fa\2)\3\2\2\2\4.\3\2\2\2\6C\3\2\2\2\bE\3\2\2\2"+
		"\nX\3\2\2\2\fZ\3\2\2\2\16_\3\2\2\2\20e\3\2\2\2\22n\3\2\2\2\24v\3\2\2\2"+
		"\26y\3\2\2\2\30\u0082\3\2\2\2\32\u008b\3\2\2\2\34\u008d\3\2\2\2\36\u0093"+
		"\3\2\2\2 \u00b6\3\2\2\2\"\u00e1\3\2\2\2$\u00e3\3\2\2\2&(\5\6\4\2\'&\3"+
		"\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\2\2\3-\3"+
		"\3\2\2\2./\t\2\2\2/\5\3\2\2\2\60D\5\b\5\2\61D\5\26\f\2\62D\5\34\17\2\63"+
		"D\5\36\20\2\64D\5\20\t\2\65D\5\n\6\2\66D\5\f\7\2\67D\5\16\b\289\5 \21"+
		"\29:\7\13\2\2:;\7*\2\2;<\7\3\2\2<=\5\"\22\2=>\7\4\2\2>?\7\t\2\2?D\3\2"+
		"\2\2@A\5 \21\2AB\7\t\2\2BD\3\2\2\2C\60\3\2\2\2C\61\3\2\2\2C\62\3\2\2\2"+
		"C\63\3\2\2\2C\64\3\2\2\2C\65\3\2\2\2C\66\3\2\2\2C\67\3\2\2\2C8\3\2\2\2"+
		"C@\3\2\2\2D\7\3\2\2\2EI\7\7\2\2FH\5\6\4\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2"+
		"\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\b\2\2M\t\3\2\2\2NO\5$\23\2OP\7*\2"+
		"\2PQ\7\t\2\2QY\3\2\2\2RS\5$\23\2ST\7*\2\2TU\7\f\2\2UV\5 \21\2VW\7\t\2"+
		"\2WY\3\2\2\2XN\3\2\2\2XR\3\2\2\2Y\13\3\2\2\2Z[\7*\2\2[\\\7\f\2\2\\]\5"+
		" \21\2]^\7\t\2\2^\r\3\2\2\2_a\7%\2\2`b\5 \21\2a`\3\2\2\2ab\3\2\2\2bc\3"+
		"\2\2\2cd\7\t\2\2d\17\3\2\2\2ef\5$\23\2fg\7*\2\2gi\7\3\2\2hj\5\22\n\2i"+
		"h\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\4\2\2lm\5\b\5\2m\21\3\2\2\2ns\5\24\13"+
		"\2op\7\n\2\2pr\5\24\13\2qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\23\3"+
		"\2\2\2us\3\2\2\2vw\5$\23\2wx\7*\2\2x\25\3\2\2\2yz\7\35\2\2z{\7\3\2\2{"+
		"|\5\n\6\2|}\5\30\r\2}~\7\t\2\2~\177\5\32\16\2\177\u0080\7\4\2\2\u0080"+
		"\u0081\5\b\5\2\u0081\27\3\2\2\2\u0082\u0083\5 \21\2\u0083\31\3\2\2\2\u0084"+
		"\u0085\7*\2\2\u0085\u008c\7\30\2\2\u0086\u0087\7*\2\2\u0087\u008c\7\31"+
		"\2\2\u0088\u0089\7*\2\2\u0089\u008a\7\f\2\2\u008a\u008c\5 \21\2\u008b"+
		"\u0084\3\2\2\2\u008b\u0086\3\2\2\2\u008b\u0088\3\2\2\2\u008c\33\3\2\2"+
		"\2\u008d\u008e\7\36\2\2\u008e\u008f\7\3\2\2\u008f\u0090\5 \21\2\u0090"+
		"\u0091\7\4\2\2\u0091\u0092\5\b\5\2\u0092\35\3\2\2\2\u0093\u0094\7\37\2"+
		"\2\u0094\u0095\7\3\2\2\u0095\u0096\5 \21\2\u0096\u0097\7\4\2\2\u0097\u009a"+
		"\5\b\5\2\u0098\u0099\7 \2\2\u0099\u009b\5\b\5\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\37\3\2\2\2\u009c\u009d\b\21\1\2\u009d\u009e\7\34"+
		"\2\2\u009e\u00b7\5 \21\24\u009f\u00a0\7\24\2\2\u00a0\u00b7\5 \21\17\u00a1"+
		"\u00a2\7\3\2\2\u00a2\u00a3\5 \21\2\u00a3\u00a4\7\4\2\2\u00a4\u00b7\3\2"+
		"\2\2\u00a5\u00a6\7*\2\2\u00a6\u00a7\7\5\2\2\u00a7\u00a8\5 \21\2\u00a8"+
		"\u00a9\7\6\2\2\u00a9\u00b7\3\2\2\2\u00aa\u00ab\7*\2\2\u00ab\u00ac\7\3"+
		"\2\2\u00ac\u00ad\5\"\22\2\u00ad\u00ae\7\4\2\2\u00ae\u00b7\3\2\2\2\u00af"+
		"\u00b7\7*\2\2\u00b0\u00b7\7+\2\2\u00b1\u00b7\7,\2\2\u00b2\u00b7\7-\2\2"+
		"\u00b3\u00b7\7.\2\2\u00b4\u00b7\7&\2\2\u00b5\u00b7\7\'\2\2\u00b6\u009c"+
		"\3\2\2\2\u00b6\u009f\3\2\2\2\u00b6\u00a1\3\2\2\2\u00b6\u00a5\3\2\2\2\u00b6"+
		"\u00aa\3\2\2\2\u00b6\u00af\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6\u00b1\3\2"+
		"\2\2\u00b6\u00b2\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b5\3\2\2\2\u00b7\u00d6\3\2\2\2\u00b8\u00b9\f\26\2\2\u00b9\u00ba\7"+
		"\32\2\2\u00ba\u00d5\5 \21\27\u00bb\u00bc\f\25\2\2\u00bc\u00bd\7\33\2\2"+
		"\u00bd\u00d5\5 \21\26\u00be\u00bf\f\23\2\2\u00bf\u00c0\t\3\2\2\u00c0\u00d5"+
		"\5 \21\24\u00c1\u00c2\f\22\2\2\u00c2\u00c3\t\4\2\2\u00c3\u00d5\5 \21\23"+
		"\u00c4\u00c5\f\21\2\2\u00c5\u00c6\t\5\2\2\u00c6\u00d5\5 \21\22\u00c7\u00c8"+
		"\f\20\2\2\u00c8\u00c9\t\6\2\2\u00c9\u00d5\5 \21\21\u00ca\u00cb\f\r\2\2"+
		"\u00cb\u00cc\7\13\2\2\u00cc\u00cd\7*\2\2\u00cd\u00ce\7\3\2\2\u00ce\u00cf"+
		"\5\"\22\2\u00cf\u00d0\7\4\2\2\u00d0\u00d5\3\2\2\2\u00d1\u00d2\f\f\2\2"+
		"\u00d2\u00d3\7\13\2\2\u00d3\u00d5\7*\2\2\u00d4\u00b8\3\2\2\2\u00d4\u00bb"+
		"\3\2\2\2\u00d4\u00be\3\2\2\2\u00d4\u00c1\3\2\2\2\u00d4\u00c4\3\2\2\2\u00d4"+
		"\u00c7\3\2\2\2\u00d4\u00ca\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d5\u00d8\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7!\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00de\5 \21\2\u00da\u00db\7\n\2\2\u00db\u00dd\5 \21\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2#\3\2\2\2\u00e3\u00e4\t\7\2\2\u00e4%\3\2\2\2\20)C"+
		"IXais\u008b\u009a\u00b6\u00d4\u00d6\u00de\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}