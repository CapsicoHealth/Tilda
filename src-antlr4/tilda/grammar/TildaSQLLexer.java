// Generated from TildaSQL.g4 by ANTLR 4.5.3
package tilda.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TildaSQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUMERIC_LITERAL=9, 
		TIMESTAMP_LITERAL=10, CURRENT_TIMESTAMP=11, TIMESTAMP_RELATIVE=12, STRING_LITERAL=13, 
		BIND_PARAMETER=14, K_AND=15, K_BETWEEN=16, K_IN=17, K_IS=18, K_LIKE=19, 
		K_NOT=20, K_NULL=21, K_ON=22, K_OR=23, K_REGEXP=24, K_LT=25, K_LTE=26, 
		K_GT=27, K_GTE=28, K_EQ=29, K_NEQ=30, IDENTIFIER=31, YEAR_LITERAL=32, 
		MONTH_LITERAL=33, DAY_LITERAL=34, HOUR_LITERAL_24=35, MINUTE_LITERAL=36, 
		SECOND_LITERAL=37, HOUR_LITERAL_12=38, SPACES=39, UNEXPECTED_CHAR=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NUMERIC_LITERAL", 
		"TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_RELATIVE", "STRING_LITERAL", 
		"BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", "K_IS", "K_LIKE", "K_NOT", 
		"K_NULL", "K_ON", "K_OR", "K_REGEXP", "K_LT", "K_LTE", "K_GT", "K_GTE", 
		"K_EQ", "K_NEQ", "IDENTIFIER", "YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", 
		"HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", "HOUR_LITERAL_12", 
		"SPACES", "UNEXPECTED_CHAR", "DIGIT", "A", "B", "C", "D", "E", "F", "G", 
		"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
		"V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "','", "'.'", null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'<'", null, "'>'", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "NUMERIC_LITERAL", 
		"TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_RELATIVE", "STRING_LITERAL", 
		"BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", "K_IS", "K_LIKE", "K_NOT", 
		"K_NULL", "K_ON", "K_OR", "K_REGEXP", "K_LT", "K_LTE", "K_GT", "K_GTE", 
		"K_EQ", "K_NEQ", "IDENTIFIER", "YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", 
		"HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", "HOUR_LITERAL_12", 
		"SPACES", "UNEXPECTED_CHAR"
	};
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


	public TildaSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TildaSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u01d3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\6\n\u009b\n\n\r\n\16\n\u009c"+
		"\3\n\3\n\7\n\u00a1\n\n\f\n\16\n\u00a4\13\n\5\n\u00a6\n\n\3\n\3\n\5\n\u00aa"+
		"\n\n\3\n\6\n\u00ad\n\n\r\n\16\n\u00ae\5\n\u00b1\n\n\3\n\3\n\6\n\u00b5"+
		"\n\n\r\n\16\n\u00b6\3\n\3\n\5\n\u00bb\n\n\3\n\6\n\u00be\n\n\r\n\16\n\u00bf"+
		"\5\n\u00c2\n\n\5\n\u00c4\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d7\n\13\5\13\u00d9"+
		"\n\13\5\13\u00db\n\13\3\13\3\13\3\13\3\13\5\13\u00e1\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0118"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0120\n\r\3\16\3\16\3\16\3\16\7\16\u0126"+
		"\n\16\f\16\16\16\u0129\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\5\20\u0139\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u015f\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\5\37\u0178\n\37\3 \3 \7 \u017c\n \f \16 \u017f\13 \3!\3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\2\2E"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2"+
		"q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\3\2\"\4\2"+
		"--//\3\2))\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\r\17\17\"\"\3\2\62;\4\2CC"+
		"cc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2"+
		"LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4"+
		"\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\u01d0"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3\u0089\3\2"+
		"\2\2\5\u008b\3\2\2\2\7\u008d\3\2\2\2\t\u008f\3\2\2\2\13\u0091\3\2\2\2"+
		"\r\u0093\3\2\2\2\17\u0095\3\2\2\2\21\u0097\3\2\2\2\23\u00c3\3\2\2\2\25"+
		"\u00e0\3\2\2\2\27\u00e2\3\2\2\2\31\u00f4\3\2\2\2\33\u0121\3\2\2\2\35\u012c"+
		"\3\2\2\2\37\u0138\3\2\2\2!\u013a\3\2\2\2#\u0142\3\2\2\2%\u0145\3\2\2\2"+
		"\'\u0148\3\2\2\2)\u014d\3\2\2\2+\u0151\3\2\2\2-\u0156\3\2\2\2/\u015e\3"+
		"\2\2\2\61\u0160\3\2\2\2\63\u0167\3\2\2\2\65\u0169\3\2\2\2\67\u016c\3\2"+
		"\2\29\u016e\3\2\2\2;\u0171\3\2\2\2=\u0177\3\2\2\2?\u0179\3\2\2\2A\u0180"+
		"\3\2\2\2C\u0185\3\2\2\2E\u0188\3\2\2\2G\u018b\3\2\2\2I\u018e\3\2\2\2K"+
		"\u0191\3\2\2\2M\u0194\3\2\2\2O\u0197\3\2\2\2Q\u019b\3\2\2\2S\u019d\3\2"+
		"\2\2U\u019f\3\2\2\2W\u01a1\3\2\2\2Y\u01a3\3\2\2\2[\u01a5\3\2\2\2]\u01a7"+
		"\3\2\2\2_\u01a9\3\2\2\2a\u01ab\3\2\2\2c\u01ad\3\2\2\2e\u01af\3\2\2\2g"+
		"\u01b1\3\2\2\2i\u01b3\3\2\2\2k\u01b5\3\2\2\2m\u01b7\3\2\2\2o\u01b9\3\2"+
		"\2\2q\u01bb\3\2\2\2s\u01bd\3\2\2\2u\u01bf\3\2\2\2w\u01c1\3\2\2\2y\u01c3"+
		"\3\2\2\2{\u01c5\3\2\2\2}\u01c7\3\2\2\2\177\u01c9\3\2\2\2\u0081\u01cb\3"+
		"\2\2\2\u0083\u01cd\3\2\2\2\u0085\u01cf\3\2\2\2\u0087\u01d1\3\2\2\2\u0089"+
		"\u008a\7*\2\2\u008a\4\3\2\2\2\u008b\u008c\7+\2\2\u008c\6\3\2\2\2\u008d"+
		"\u008e\7-\2\2\u008e\b\3\2\2\2\u008f\u0090\7/\2\2\u0090\n\3\2\2\2\u0091"+
		"\u0092\7,\2\2\u0092\f\3\2\2\2\u0093\u0094\7\61\2\2\u0094\16\3\2\2\2\u0095"+
		"\u0096\7.\2\2\u0096\20\3\2\2\2\u0097\u0098\7\60\2\2\u0098\22\3\2\2\2\u0099"+
		"\u009b\5S*\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2"+
		"\2\u009c\u009d\3\2\2\2\u009d\u00a5\3\2\2\2\u009e\u00a2\7\60\2\2\u009f"+
		"\u00a1\5S*\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2"+
		"\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u009e"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00b0\3\2\2\2\u00a7\u00a9\5]/\2\u00a8"+
		"\u00aa\t\2\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2"+
		"\2\2\u00ab\u00ad\5S*\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00a7\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00c4\3\2\2\2\u00b2\u00b4\7\60\2\2\u00b3\u00b5\5"+
		"S*\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00c1\3\2\2\2\u00b8\u00ba\5]/\2\u00b9\u00bb\t\2\2"+
		"\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00be"+
		"\5S*\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c4\3\2\2\2\u00c3\u009a\3\2\2\2\u00c3\u00b2\3\2\2\2\u00c4"+
		"\24\3\2\2\2\u00c5\u00c6\7)\2\2\u00c6\u00c7\5A!\2\u00c7\u00c8\7/\2\2\u00c8"+
		"\u00c9\5C\"\2\u00c9\u00ca\7/\2\2\u00ca\u00da\5E#\2\u00cb\u00cc\7V\2\2"+
		"\u00cc\u00cd\5G$\2\u00cd\u00ce\7<\2\2\u00ce\u00d8\5I%\2\u00cf\u00d0\7"+
		"<\2\2\u00d0\u00d6\5K&\2\u00d1\u00d2\t\2\2\2\u00d2\u00d3\5M\'\2\u00d3\u00d4"+
		"\7<\2\2\u00d4\u00d5\5I%\2\u00d5\u00d7\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00cf\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00db\3\2\2\2\u00da\u00cb\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00dd\7)\2\2\u00dd\u00e1\3\2\2\2\u00de\u00e1\5\27"+
		"\f\2\u00df\u00e1\5\31\r\2\u00e0\u00c5\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00df\3\2\2\2\u00e1\26\3\2\2\2\u00e2\u00e3\5Y-\2\u00e3\u00e4\5}?\2\u00e4"+
		"\u00e5\5w<\2\u00e5\u00e6\5w<\2\u00e6\u00e7\5]/\2\u00e7\u00e8\5o8\2\u00e8"+
		"\u00e9\5{>\2\u00e9\u00ea\7a\2\2\u00ea\u00eb\5{>\2\u00eb\u00ec\5e\63\2"+
		"\u00ec\u00ed\5m\67\2\u00ed\u00ee\5]/\2\u00ee\u00ef\5y=\2\u00ef\u00f0\5"+
		"{>\2\u00f0\u00f1\5U+\2\u00f1\u00f2\5m\67\2\u00f2\u00f3\5s:\2\u00f3\30"+
		"\3\2\2\2\u00f4\u00f5\5{>\2\u00f5\u00f6\5e\63\2\u00f6\u00f7\5m\67\2\u00f7"+
		"\u00f8\5]/\2\u00f8\u00f9\5y=\2\u00f9\u00fa\5{>\2\u00fa\u00fb\5U+\2\u00fb"+
		"\u00fc\5m\67\2\u00fc\u00fd\5s:\2\u00fd\u0117\7a\2\2\u00fe\u00ff\5\u0085"+
		"C\2\u00ff\u0100\5]/\2\u0100\u0101\5y=\2\u0101\u0102\5{>\2\u0102\u0103"+
		"\5]/\2\u0103\u0104\5w<\2\u0104\u0105\5[.\2\u0105\u0106\5U+\2\u0106\u0107"+
		"\5\u0085C\2\u0107\u0118\3\2\2\2\u0108\u0109\5{>\2\u0109\u010a\5q9\2\u010a"+
		"\u010b\5[.\2\u010b\u010c\5U+\2\u010c\u010d\5\u0085C\2\u010d\u0118\3\2"+
		"\2\2\u010e\u010f\5{>\2\u010f\u0110\5q9\2\u0110\u0111\5m\67\2\u0111\u0112"+
		"\5q9\2\u0112\u0113\5w<\2\u0113\u0114\5w<\2\u0114\u0115\5q9\2\u0115\u0116"+
		"\5\u0081A\2\u0116\u0118\3\2\2\2\u0117\u00fe\3\2\2\2\u0117\u0108\3\2\2"+
		"\2\u0117\u010e\3\2\2\2\u0118\u011f\3\2\2\2\u0119\u011a\7a\2\2\u011a\u011b"+
		"\5k\66\2\u011b\u011c\5U+\2\u011c\u011d\5y=\2\u011d\u011e\5{>\2\u011e\u0120"+
		"\3\2\2\2\u011f\u0119\3\2\2\2\u011f\u0120\3\2\2\2\u0120\32\3\2\2\2\u0121"+
		"\u0127\7)\2\2\u0122\u0126\n\3\2\2\u0123\u0124\7)\2\2\u0124\u0126\7)\2"+
		"\2\u0125\u0122\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012b\7)\2\2\u012b\34\3\2\2\2\u012c\u012d\7A\2\2\u012d\u012e\7}\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0130\5? \2\u0130\u0131\7\177\2\2\u0131\36\3\2\2"+
		"\2\u0132\u0133\5U+\2\u0133\u0134\5o8\2\u0134\u0135\5[.\2\u0135\u0139\3"+
		"\2\2\2\u0136\u0137\7(\2\2\u0137\u0139\7(\2\2\u0138\u0132\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0139 \3\2\2\2\u013a\u013b\5W,\2\u013b\u013c\5]/\2\u013c"+
		"\u013d\5{>\2\u013d\u013e\5\u0081A\2\u013e\u013f\5]/\2\u013f\u0140\5]/"+
		"\2\u0140\u0141\5o8\2\u0141\"\3\2\2\2\u0142\u0143\5e\63\2\u0143\u0144\5"+
		"o8\2\u0144$\3\2\2\2\u0145\u0146\5e\63\2\u0146\u0147\5y=\2\u0147&\3\2\2"+
		"\2\u0148\u0149\5k\66\2\u0149\u014a\5e\63\2\u014a\u014b\5i\65\2\u014b\u014c"+
		"\5]/\2\u014c(\3\2\2\2\u014d\u014e\5o8\2\u014e\u014f\5q9\2\u014f\u0150"+
		"\5{>\2\u0150*\3\2\2\2\u0151\u0152\5o8\2\u0152\u0153\5}?\2\u0153\u0154"+
		"\5k\66\2\u0154\u0155\5k\66\2\u0155,\3\2\2\2\u0156\u0157\5q9\2\u0157\u0158"+
		"\5o8\2\u0158.\3\2\2\2\u0159\u015a\5q9\2\u015a\u015b\5w<\2\u015b\u015f"+
		"\3\2\2\2\u015c\u015d\7~\2\2\u015d\u015f\7~\2\2\u015e\u0159\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015f\60\3\2\2\2\u0160\u0161\5w<\2\u0161\u0162\5]/\2\u0162"+
		"\u0163\5a\61\2\u0163\u0164\5]/\2\u0164\u0165\5\u0083B\2\u0165\u0166\5"+
		"s:\2\u0166\62\3\2\2\2\u0167\u0168\7>\2\2\u0168\64\3\2\2\2\u0169\u016a"+
		"\7>\2\2\u016a\u016b\7?\2\2\u016b\66\3\2\2\2\u016c\u016d\7@\2\2\u016d8"+
		"\3\2\2\2\u016e\u016f\7@\2\2\u016f\u0170\7?\2\2\u0170:\3\2\2\2\u0171\u0172"+
		"\7?\2\2\u0172<\3\2\2\2\u0173\u0174\7>\2\2\u0174\u0178\7@\2\2\u0175\u0176"+
		"\7#\2\2\u0176\u0178\7?\2\2\u0177\u0173\3\2\2\2\u0177\u0175\3\2\2\2\u0178"+
		">\3\2\2\2\u0179\u017d\t\4\2\2\u017a\u017c\t\5\2\2\u017b\u017a\3\2\2\2"+
		"\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e@\3"+
		"\2\2\2\u017f\u017d\3\2\2\2\u0180\u0181\5S*\2\u0181\u0182\5S*\2\u0182\u0183"+
		"\5S*\2\u0183\u0184\5S*\2\u0184B\3\2\2\2\u0185\u0186\5S*\2\u0186\u0187"+
		"\5S*\2\u0187D\3\2\2\2\u0188\u0189\5S*\2\u0189\u018a\5S*\2\u018aF\3\2\2"+
		"\2\u018b\u018c\5S*\2\u018c\u018d\5S*\2\u018dH\3\2\2\2\u018e\u018f\5S*"+
		"\2\u018f\u0190\5S*\2\u0190J\3\2\2\2\u0191\u0192\5S*\2\u0192\u0193\5S*"+
		"\2\u0193L\3\2\2\2\u0194\u0195\5S*\2\u0195\u0196\5S*\2\u0196N\3\2\2\2\u0197"+
		"\u0198\t\6\2\2\u0198\u0199\3\2\2\2\u0199\u019a\b(\2\2\u019aP\3\2\2\2\u019b"+
		"\u019c\13\2\2\2\u019cR\3\2\2\2\u019d\u019e\t\7\2\2\u019eT\3\2\2\2\u019f"+
		"\u01a0\t\b\2\2\u01a0V\3\2\2\2\u01a1\u01a2\t\t\2\2\u01a2X\3\2\2\2\u01a3"+
		"\u01a4\t\n\2\2\u01a4Z\3\2\2\2\u01a5\u01a6\t\13\2\2\u01a6\\\3\2\2\2\u01a7"+
		"\u01a8\t\f\2\2\u01a8^\3\2\2\2\u01a9\u01aa\t\r\2\2\u01aa`\3\2\2\2\u01ab"+
		"\u01ac\t\16\2\2\u01acb\3\2\2\2\u01ad\u01ae\t\17\2\2\u01aed\3\2\2\2\u01af"+
		"\u01b0\t\20\2\2\u01b0f\3\2\2\2\u01b1\u01b2\t\21\2\2\u01b2h\3\2\2\2\u01b3"+
		"\u01b4\t\22\2\2\u01b4j\3\2\2\2\u01b5\u01b6\t\23\2\2\u01b6l\3\2\2\2\u01b7"+
		"\u01b8\t\24\2\2\u01b8n\3\2\2\2\u01b9\u01ba\t\25\2\2\u01bap\3\2\2\2\u01bb"+
		"\u01bc\t\26\2\2\u01bcr\3\2\2\2\u01bd\u01be\t\27\2\2\u01bet\3\2\2\2\u01bf"+
		"\u01c0\t\30\2\2\u01c0v\3\2\2\2\u01c1\u01c2\t\31\2\2\u01c2x\3\2\2\2\u01c3"+
		"\u01c4\t\32\2\2\u01c4z\3\2\2\2\u01c5\u01c6\t\33\2\2\u01c6|\3\2\2\2\u01c7"+
		"\u01c8\t\34\2\2\u01c8~\3\2\2\2\u01c9\u01ca\t\35\2\2\u01ca\u0080\3\2\2"+
		"\2\u01cb\u01cc\t\36\2\2\u01cc\u0082\3\2\2\2\u01cd\u01ce\t\37\2\2\u01ce"+
		"\u0084\3\2\2\2\u01cf\u01d0\t \2\2\u01d0\u0086\3\2\2\2\u01d1\u01d2\t!\2"+
		"\2\u01d2\u0088\3\2\2\2\32\2\u009c\u00a2\u00a5\u00a9\u00ae\u00b0\u00b6"+
		"\u00ba\u00bf\u00c1\u00c3\u00d6\u00d8\u00da\u00e0\u0117\u011f\u0125\u0127"+
		"\u0138\u015e\u0177\u017d\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}