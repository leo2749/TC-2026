// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiLenguajeLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETRA", "DIGITO", "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", 
			"PUNTO", "IGUAL", "EQL", "DISTINTO", "MAYOR_IGUAL", "MENOR_IGUAL", "MAYOR", 
			"MENOR", "SUM", "RES", "MUL", "DIV", "MOD", "SUMSUM", "RESRES", "OR", 
			"AND", "NOT", "FOR", "WHILE", "IF", "ELSE", "INT", "CHAR", "DOUBLE", 
			"VOID", "RETURN", "TRUE", "FALSE", "BOOLEAN_TYPE", "STRING_TYPE", "ID", 
			"INTEGER", "DECIMAL", "CHARACTER", "STRING", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", 
			"WS", "OTRO"
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


	public MiLenguajeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u013d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3"+
		"$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3("+
		"\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\5+\u00f2\n+"+
		"\3+\3+\3+\7+\u00f7\n+\f+\16+\u00fa\13+\3,\6,\u00fd\n,\r,\16,\u00fe\3-"+
		"\6-\u0102\n-\r-\16-\u0103\3-\3-\6-\u0108\n-\r-\16-\u0109\3.\3.\3.\3.\5"+
		".\u0110\n.\3.\3.\3/\3/\3/\3/\7/\u0118\n/\f/\16/\u011b\13/\3/\3/\3\60\3"+
		"\60\3\60\3\60\7\60\u0123\n\60\f\60\16\60\u0126\13\60\3\60\3\60\3\61\3"+
		"\61\3\61\3\61\7\61\u012e\n\61\f\61\16\61\u0131\13\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\u012f\2\64\3\2\5\2\7\3\t\4\13"+
		"\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23"+
		")\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%"+
		"M&O\'Q(S)U*W+Y,[-]._/a\60c\61e\62\3\2\b\4\2C\\c|\3\2\62;\6\2\f\f\17\17"+
		"))^^\6\2\f\f\17\17$$^^\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0146\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3"+
		"g\3\2\2\2\5i\3\2\2\2\7k\3\2\2\2\tm\3\2\2\2\13o\3\2\2\2\rq\3\2\2\2\17s"+
		"\3\2\2\2\21u\3\2\2\2\23w\3\2\2\2\25y\3\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33"+
		"\177\3\2\2\2\35\u0082\3\2\2\2\37\u0085\3\2\2\2!\u0088\3\2\2\2#\u008b\3"+
		"\2\2\2%\u008d\3\2\2\2\'\u008f\3\2\2\2)\u0091\3\2\2\2+\u0093\3\2\2\2-\u0095"+
		"\3\2\2\2/\u0097\3\2\2\2\61\u0099\3\2\2\2\63\u009c\3\2\2\2\65\u009f\3\2"+
		"\2\2\67\u00a2\3\2\2\29\u00a5\3\2\2\2;\u00a7\3\2\2\2=\u00ab\3\2\2\2?\u00b1"+
		"\3\2\2\2A\u00b4\3\2\2\2C\u00b9\3\2\2\2E\u00bd\3\2\2\2G\u00c2\3\2\2\2I"+
		"\u00c9\3\2\2\2K\u00ce\3\2\2\2M\u00d5\3\2\2\2O\u00da\3\2\2\2Q\u00e0\3\2"+
		"\2\2S\u00e8\3\2\2\2U\u00f1\3\2\2\2W\u00fc\3\2\2\2Y\u0101\3\2\2\2[\u010b"+
		"\3\2\2\2]\u0113\3\2\2\2_\u011e\3\2\2\2a\u0129\3\2\2\2c\u0137\3\2\2\2e"+
		"\u013b\3\2\2\2gh\t\2\2\2h\4\3\2\2\2ij\t\3\2\2j\6\3\2\2\2kl\7*\2\2l\b\3"+
		"\2\2\2mn\7+\2\2n\n\3\2\2\2op\7]\2\2p\f\3\2\2\2qr\7_\2\2r\16\3\2\2\2st"+
		"\7}\2\2t\20\3\2\2\2uv\7\177\2\2v\22\3\2\2\2wx\7=\2\2x\24\3\2\2\2yz\7."+
		"\2\2z\26\3\2\2\2{|\7\60\2\2|\30\3\2\2\2}~\7?\2\2~\32\3\2\2\2\177\u0080"+
		"\7?\2\2\u0080\u0081\7?\2\2\u0081\34\3\2\2\2\u0082\u0083\7#\2\2\u0083\u0084"+
		"\7?\2\2\u0084\36\3\2\2\2\u0085\u0086\7@\2\2\u0086\u0087\7?\2\2\u0087 "+
		"\3\2\2\2\u0088\u0089\7>\2\2\u0089\u008a\7?\2\2\u008a\"\3\2\2\2\u008b\u008c"+
		"\7@\2\2\u008c$\3\2\2\2\u008d\u008e\7>\2\2\u008e&\3\2\2\2\u008f\u0090\7"+
		"-\2\2\u0090(\3\2\2\2\u0091\u0092\7/\2\2\u0092*\3\2\2\2\u0093\u0094\7,"+
		"\2\2\u0094,\3\2\2\2\u0095\u0096\7\61\2\2\u0096.\3\2\2\2\u0097\u0098\7"+
		"\'\2\2\u0098\60\3\2\2\2\u0099\u009a\7-\2\2\u009a\u009b\7-\2\2\u009b\62"+
		"\3\2\2\2\u009c\u009d\7/\2\2\u009d\u009e\7/\2\2\u009e\64\3\2\2\2\u009f"+
		"\u00a0\7~\2\2\u00a0\u00a1\7~\2\2\u00a1\66\3\2\2\2\u00a2\u00a3\7(\2\2\u00a3"+
		"\u00a4\7(\2\2\u00a48\3\2\2\2\u00a5\u00a6\7#\2\2\u00a6:\3\2\2\2\u00a7\u00a8"+
		"\7h\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7t\2\2\u00aa<\3\2\2\2\u00ab\u00ac"+
		"\7y\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7n\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0>\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7h\2\2\u00b3"+
		"@\3\2\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7u\2\2\u00b7"+
		"\u00b8\7g\2\2\u00b8B\3\2\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7p\2\2\u00bb"+
		"\u00bc\7v\2\2\u00bcD\3\2\2\2\u00bd\u00be\7e\2\2\u00be\u00bf\7j\2\2\u00bf"+
		"\u00c0\7c\2\2\u00c0\u00c1\7t\2\2\u00c1F\3\2\2\2\u00c2\u00c3\7f\2\2\u00c3"+
		"\u00c4\7q\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7d\2\2\u00c6\u00c7\7n\2\2"+
		"\u00c7\u00c8\7g\2\2\u00c8H\3\2\2\2\u00c9\u00ca\7x\2\2\u00ca\u00cb\7q\2"+
		"\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7f\2\2\u00cdJ\3\2\2\2\u00ce\u00cf\7"+
		"t\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3"+
		"\7t\2\2\u00d3\u00d4\7p\2\2\u00d4L\3\2\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7"+
		"\7t\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7g\2\2\u00d9N\3\2\2\2\u00da\u00db"+
		"\7h\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de\7u\2\2\u00de"+
		"\u00df\7g\2\2\u00dfP\3\2\2\2\u00e0\u00e1\7d\2\2\u00e1\u00e2\7q\2\2\u00e2"+
		"\u00e3\7q\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7c\2\2"+
		"\u00e6\u00e7\7p\2\2\u00e7R\3\2\2\2\u00e8\u00e9\7U\2\2\u00e9\u00ea\7v\2"+
		"\2\u00ea\u00eb\7t\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7p\2\2\u00ed\u00ee"+
		"\7i\2\2\u00eeT\3\2\2\2\u00ef\u00f2\5\3\2\2\u00f0\u00f2\7a\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f8\3\2\2\2\u00f3\u00f7\5\3\2\2\u00f4"+
		"\u00f7\5\5\3\2\u00f5\u00f7\7a\2\2\u00f6\u00f3\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9V\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\5\5\3\2"+
		"\u00fc\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff"+
		"\3\2\2\2\u00ffX\3\2\2\2\u0100\u0102\5\5\3\2\u0101\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0107\7\60\2\2\u0106\u0108\5\5\3\2\u0107\u0106\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010aZ\3\2\2\2"+
		"\u010b\u010f\7)\2\2\u010c\u0110\n\4\2\2\u010d\u010e\7^\2\2\u010e\u0110"+
		"\13\2\2\2\u010f\u010c\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\3\2\2\2"+
		"\u0111\u0112\7)\2\2\u0112\\\3\2\2\2\u0113\u0119\7$\2\2\u0114\u0118\n\5"+
		"\2\2\u0115\u0116\7^\2\2\u0116\u0118\13\2\2\2\u0117\u0114\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7$\2\2\u011d"+
		"^\3\2\2\2\u011e\u011f\7\61\2\2\u011f\u0120\7\61\2\2\u0120\u0124\3\2\2"+
		"\2\u0121\u0123\n\6\2\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127"+
		"\u0128\b\60\2\2\u0128`\3\2\2\2\u0129\u012a\7\61\2\2\u012a\u012b\7,\2\2"+
		"\u012b\u012f\3\2\2\2\u012c\u012e\13\2\2\2\u012d\u012c\3\2\2\2\u012e\u0131"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\3\2\2\2\u0131"+
		"\u012f\3\2\2\2\u0132\u0133\7,\2\2\u0133\u0134\7\61\2\2\u0134\u0135\3\2"+
		"\2\2\u0135\u0136\b\61\2\2\u0136b\3\2\2\2\u0137\u0138\t\7\2\2\u0138\u0139"+
		"\3\2\2\2\u0139\u013a\b\62\2\2\u013ad\3\2\2\2\u013b\u013c\13\2\2\2\u013c"+
		"f\3\2\2\2\16\2\u00f1\u00f6\u00f8\u00fe\u0103\u0109\u010f\u0117\u0119\u0124"+
		"\u012f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}