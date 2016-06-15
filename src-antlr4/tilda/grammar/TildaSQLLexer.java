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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NUMERIC_LITERAL=8, 
		TIMESTAMP_LITERAL=9, CURRENT_TIMESTAMP=10, TIMESTAMP_YESTERDAY=11, TIMESTAMP_TODAY=12, 
		TIMESTAMP_TOMORROW=13, LAST=14, STRING_LITERAL=15, BIND_PARAMETER=16, 
		K_AND=17, K_BETWEEN=18, K_IN=19, K_IS=20, K_LIKE=21, K_NOT=22, K_NULL=23, 
		K_OR=24, K_REGEXP=25, K_LT=26, K_LTE=27, K_GT=28, K_GTE=29, K_EQ=30, K_NEQ=31, 
		K_DIV=32, K_MINUS=33, IDENTIFIER=34, PLUS_MINUS=35, YEAR_LITERAL=36, MONTH_LITERAL=37, 
		DAY_LITERAL=38, HOUR_LITERAL_24=39, MINUTE_LITERAL=40, SECOND_LITERAL=41, 
		HOUR_LITERAL_12=42, SPACES=43, UNEXPECTED_CHAR=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "NUMERIC_LITERAL", 
		"TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", "TIMESTAMP_TODAY", 
		"TIMESTAMP_TOMORROW", "LAST", "STRING_LITERAL", "BIND_PARAMETER", "K_AND", 
		"K_BETWEEN", "K_IN", "K_IS", "K_LIKE", "K_NOT", "K_NULL", "K_OR", "K_REGEXP", 
		"K_LT", "K_LTE", "K_GT", "K_GTE", "K_EQ", "K_NEQ", "K_DIV", "K_MINUS", 
		"IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", 
		"HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", "HOUR_LITERAL_12", 
		"SPACES", "UNEXPECTED_CHAR", "DIGIT", "A", "B", "C", "D", "E", "F", "G", 
		"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
		"V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'||'", "','", "'*'", "'.'", null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "'<'", "'<='", "'>'", "'>='", null, null, "'/'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "NUMERIC_LITERAL", "TIMESTAMP_LITERAL", 
		"CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", "TIMESTAMP_TODAY", "TIMESTAMP_TOMORROW", 
		"LAST", "STRING_LITERAL", "BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", 
		"K_IS", "K_LIKE", "K_NOT", "K_NULL", "K_OR", "K_REGEXP", "K_LT", "K_LTE", 
		"K_GT", "K_GTE", "K_EQ", "K_NEQ", "K_DIV", "K_MINUS", "IDENTIFIER", "PLUS_MINUS", 
		"YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", 
		"SECOND_LITERAL", "HOUR_LITERAL_12", "SPACES", "UNEXPECTED_CHAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u01c4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\6\t\u00a2"+
		"\n\t\r\t\16\t\u00a3\3\t\3\t\7\t\u00a8\n\t\f\t\16\t\u00ab\13\t\5\t\u00ad"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u00c0\n\n\5\n\u00c2\n\n\5\n\u00c4\n\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\7\20\u011a\n\20\f\20\16\20\u011d\13\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3"+
		"\37\3\37\5\37\u015d\n\37\3 \3 \3 \3 \5 \u0163\n \3!\3!\3\"\3\"\3#\3#\7"+
		"#\u016b\n#\f#\16#\u016e\13#\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'"+
		"\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60"+
		"\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3"+
		"B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\2\2I\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081"+
		"\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\3\2\"\3\2)"+
		")\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\5\2\13\r\17\17\"\"\3\2\62;\4\2CCc"+
		"c\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2"+
		"LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4"+
		"\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\u01b3"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3\u0091\3\2\2\2\5\u0093\3\2\2\2\7\u0095"+
		"\3\2\2\2\t\u0097\3\2\2\2\13\u009a\3\2\2\2\r\u009c\3\2\2\2\17\u009e\3\2"+
		"\2\2\21\u00a1\3\2\2\2\23\u00ae\3\2\2\2\25\u00c7\3\2\2\2\27\u00d9\3\2\2"+
		"\2\31\u00ed\3\2\2\2\33\u00fd\3\2\2\2\35\u0110\3\2\2\2\37\u0115\3\2\2\2"+
		"!\u0120\3\2\2\2#\u0126\3\2\2\2%\u012a\3\2\2\2\'\u0132\3\2\2\2)\u0135\3"+
		"\2\2\2+\u0138\3\2\2\2-\u013d\3\2\2\2/\u0141\3\2\2\2\61\u0146\3\2\2\2\63"+
		"\u0149\3\2\2\2\65\u0150\3\2\2\2\67\u0152\3\2\2\29\u0155\3\2\2\2;\u0157"+
		"\3\2\2\2=\u015a\3\2\2\2?\u0162\3\2\2\2A\u0164\3\2\2\2C\u0166\3\2\2\2E"+
		"\u0168\3\2\2\2G\u016f\3\2\2\2I\u0171\3\2\2\2K\u0176\3\2\2\2M\u0179\3\2"+
		"\2\2O\u017c\3\2\2\2Q\u017f\3\2\2\2S\u0182\3\2\2\2U\u0185\3\2\2\2W\u0188"+
		"\3\2\2\2Y\u018c\3\2\2\2[\u018e\3\2\2\2]\u0190\3\2\2\2_\u0192\3\2\2\2a"+
		"\u0194\3\2\2\2c\u0196\3\2\2\2e\u0198\3\2\2\2g\u019a\3\2\2\2i\u019c\3\2"+
		"\2\2k\u019e\3\2\2\2m\u01a0\3\2\2\2o\u01a2\3\2\2\2q\u01a4\3\2\2\2s\u01a6"+
		"\3\2\2\2u\u01a8\3\2\2\2w\u01aa\3\2\2\2y\u01ac\3\2\2\2{\u01ae\3\2\2\2}"+
		"\u01b0\3\2\2\2\177\u01b2\3\2\2\2\u0081\u01b4\3\2\2\2\u0083\u01b6\3\2\2"+
		"\2\u0085\u01b8\3\2\2\2\u0087\u01ba\3\2\2\2\u0089\u01bc\3\2\2\2\u008b\u01be"+
		"\3\2\2\2\u008d\u01c0\3\2\2\2\u008f\u01c2\3\2\2\2\u0091\u0092\7*\2\2\u0092"+
		"\4\3\2\2\2\u0093\u0094\7+\2\2\u0094\6\3\2\2\2\u0095\u0096\7-\2\2\u0096"+
		"\b\3\2\2\2\u0097\u0098\7~\2\2\u0098\u0099\7~\2\2\u0099\n\3\2\2\2\u009a"+
		"\u009b\7.\2\2\u009b\f\3\2\2\2\u009c\u009d\7,\2\2\u009d\16\3\2\2\2\u009e"+
		"\u009f\7\60\2\2\u009f\20\3\2\2\2\u00a0\u00a2\5[.\2\u00a1\u00a0\3\2\2\2"+
		"\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00ac"+
		"\3\2\2\2\u00a5\u00a9\7\60\2\2\u00a6\u00a8\5[.\2\u00a7\u00a6\3\2\2\2\u00a8"+
		"\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ad\3\2"+
		"\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00a5\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\22\3\2\2\2\u00ae\u00af\7)\2\2\u00af\u00b0\5I%\2\u00b0\u00b1\7/\2\2\u00b1"+
		"\u00b2\5K&\2\u00b2\u00b3\7/\2\2\u00b3\u00c3\5M\'\2\u00b4\u00b5\7V\2\2"+
		"\u00b5\u00b6\5O(\2\u00b6\u00b7\7<\2\2\u00b7\u00c1\5Q)\2\u00b8\u00b9\7"+
		"<\2\2\u00b9\u00bf\5S*\2\u00ba\u00bb\5G$\2\u00bb\u00bc\5U+\2\u00bc\u00bd"+
		"\7<\2\2\u00bd\u00be\5Q)\2\u00be\u00c0\3\2\2\2\u00bf\u00ba\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00b4\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\7)\2\2\u00c6\24\3\2\2\2\u00c7\u00c8\5a\61\2"+
		"\u00c8\u00c9\5\u0085C\2\u00c9\u00ca\5\177@\2\u00ca\u00cb\5\177@\2\u00cb"+
		"\u00cc\5e\63\2\u00cc\u00cd\5w<\2\u00cd\u00ce\5\u0083B\2\u00ce\u00cf\7"+
		"a\2\2\u00cf\u00d0\5\u0083B\2\u00d0\u00d1\5m\67\2\u00d1\u00d2\5u;\2\u00d2"+
		"\u00d3\5e\63\2\u00d3\u00d4\5\u0081A\2\u00d4\u00d5\5\u0083B\2\u00d5\u00d6"+
		"\5]/\2\u00d6\u00d7\5u;\2\u00d7\u00d8\5{>\2\u00d8\26\3\2\2\2\u00d9\u00da"+
		"\5\u0083B\2\u00da\u00db\5m\67\2\u00db\u00dc\5u;\2\u00dc\u00dd\5e\63\2"+
		"\u00dd\u00de\5\u0081A\2\u00de\u00df\5\u0083B\2\u00df\u00e0\5]/\2\u00e0"+
		"\u00e1\5u;\2\u00e1\u00e2\5{>\2\u00e2\u00e3\7a\2\2\u00e3\u00e4\5\u008d"+
		"G\2\u00e4\u00e5\5e\63\2\u00e5\u00e6\5\u0081A\2\u00e6\u00e7\5\u0083B\2"+
		"\u00e7\u00e8\5e\63\2\u00e8\u00e9\5\177@\2\u00e9\u00ea\5c\62\2\u00ea\u00eb"+
		"\5]/\2\u00eb\u00ec\5\u008dG\2\u00ec\30\3\2\2\2\u00ed\u00ee\5\u0083B\2"+
		"\u00ee\u00ef\5m\67\2\u00ef\u00f0\5u;\2\u00f0\u00f1\5e\63\2\u00f1\u00f2"+
		"\5\u0081A\2\u00f2\u00f3\5\u0083B\2\u00f3\u00f4\5]/\2\u00f4\u00f5\5u;\2"+
		"\u00f5\u00f6\5{>\2\u00f6\u00f7\7a\2\2\u00f7\u00f8\5\u0083B\2\u00f8\u00f9"+
		"\5y=\2\u00f9\u00fa\5c\62\2\u00fa\u00fb\5]/\2\u00fb\u00fc\5\u008dG\2\u00fc"+
		"\32\3\2\2\2\u00fd\u00fe\5\u0083B\2\u00fe\u00ff\5m\67\2\u00ff\u0100\5u"+
		";\2\u0100\u0101\5e\63\2\u0101\u0102\5\u0081A\2\u0102\u0103\5\u0083B\2"+
		"\u0103\u0104\5]/\2\u0104\u0105\5u;\2\u0105\u0106\5{>\2\u0106\u0107\7a"+
		"\2\2\u0107\u0108\5\u0083B\2\u0108\u0109\5y=\2\u0109\u010a\5u;\2\u010a"+
		"\u010b\5y=\2\u010b\u010c\5\177@\2\u010c\u010d\5\177@\2\u010d\u010e\5y"+
		"=\2\u010e\u010f\5\u0089E\2\u010f\34\3\2\2\2\u0110\u0111\5s:\2\u0111\u0112"+
		"\5]/\2\u0112\u0113\5\u0081A\2\u0113\u0114\5\u0083B\2\u0114\36\3\2\2\2"+
		"\u0115\u011b\7)\2\2\u0116\u011a\n\2\2\2\u0117\u0118\7)\2\2\u0118\u011a"+
		"\7)\2\2\u0119\u0116\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011d\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011e\u011f\7)\2\2\u011f \3\2\2\2\u0120\u0121\7A\2\2\u0121\u0122"+
		"\7}\2\2\u0122\u0123\3\2\2\2\u0123\u0124\5E#\2\u0124\u0125\7\177\2\2\u0125"+
		"\"\3\2\2\2\u0126\u0127\5]/\2\u0127\u0128\5w<\2\u0128\u0129\5c\62\2\u0129"+
		"$\3\2\2\2\u012a\u012b\5_\60\2\u012b\u012c\5e\63\2\u012c\u012d\5\u0083"+
		"B\2\u012d\u012e\5\u0089E\2\u012e\u012f\5e\63\2\u012f\u0130\5e\63\2\u0130"+
		"\u0131\5w<\2\u0131&\3\2\2\2\u0132\u0133\5m\67\2\u0133\u0134\5w<\2\u0134"+
		"(\3\2\2\2\u0135\u0136\5m\67\2\u0136\u0137\5\u0081A\2\u0137*\3\2\2\2\u0138"+
		"\u0139\5s:\2\u0139\u013a\5m\67\2\u013a\u013b\5q9\2\u013b\u013c\5e\63\2"+
		"\u013c,\3\2\2\2\u013d\u013e\5w<\2\u013e\u013f\5y=\2\u013f\u0140\5\u0083"+
		"B\2\u0140.\3\2\2\2\u0141\u0142\5w<\2\u0142\u0143\5\u0085C\2\u0143\u0144"+
		"\5s:\2\u0144\u0145\5s:\2\u0145\60\3\2\2\2\u0146\u0147\5y=\2\u0147\u0148"+
		"\5\177@\2\u0148\62\3\2\2\2\u0149\u014a\5\177@\2\u014a\u014b\5e\63\2\u014b"+
		"\u014c\5i\65\2\u014c\u014d\5e\63\2\u014d\u014e\5\u008bF\2\u014e\u014f"+
		"\5{>\2\u014f\64\3\2\2\2\u0150\u0151\7>\2\2\u0151\66\3\2\2\2\u0152\u0153"+
		"\7>\2\2\u0153\u0154\7?\2\2\u01548\3\2\2\2\u0155\u0156\7@\2\2\u0156:\3"+
		"\2\2\2\u0157\u0158\7@\2\2\u0158\u0159\7?\2\2\u0159<\3\2\2\2\u015a\u015c"+
		"\7?\2\2\u015b\u015d\7?\2\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		">\3\2\2\2\u015e\u015f\7>\2\2\u015f\u0163\7@\2\2\u0160\u0161\7#\2\2\u0161"+
		"\u0163\7?\2\2\u0162\u015e\3\2\2\2\u0162\u0160\3\2\2\2\u0163@\3\2\2\2\u0164"+
		"\u0165\7\61\2\2\u0165B\3\2\2\2\u0166\u0167\7/\2\2\u0167D\3\2\2\2\u0168"+
		"\u016c\t\3\2\2\u0169\u016b\t\4\2\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2"+
		"\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016dF\3\2\2\2\u016e\u016c"+
		"\3\2\2\2\u016f\u0170\t\5\2\2\u0170H\3\2\2\2\u0171\u0172\5[.\2\u0172\u0173"+
		"\5[.\2\u0173\u0174\5[.\2\u0174\u0175\5[.\2\u0175J\3\2\2\2\u0176\u0177"+
		"\5[.\2\u0177\u0178\5[.\2\u0178L\3\2\2\2\u0179\u017a\5[.\2\u017a\u017b"+
		"\5[.\2\u017bN\3\2\2\2\u017c\u017d\5[.\2\u017d\u017e\5[.\2\u017eP\3\2\2"+
		"\2\u017f\u0180\5[.\2\u0180\u0181\5[.\2\u0181R\3\2\2\2\u0182\u0183\5[."+
		"\2\u0183\u0184\5[.\2\u0184T\3\2\2\2\u0185\u0186\5[.\2\u0186\u0187\5[."+
		"\2\u0187V\3\2\2\2\u0188\u0189\t\6\2\2\u0189\u018a\3\2\2\2\u018a\u018b"+
		"\b,\2\2\u018bX\3\2\2\2\u018c\u018d\13\2\2\2\u018dZ\3\2\2\2\u018e\u018f"+
		"\t\7\2\2\u018f\\\3\2\2\2\u0190\u0191\t\b\2\2\u0191^\3\2\2\2\u0192\u0193"+
		"\t\t\2\2\u0193`\3\2\2\2\u0194\u0195\t\n\2\2\u0195b\3\2\2\2\u0196\u0197"+
		"\t\13\2\2\u0197d\3\2\2\2\u0198\u0199\t\f\2\2\u0199f\3\2\2\2\u019a\u019b"+
		"\t\r\2\2\u019bh\3\2\2\2\u019c\u019d\t\16\2\2\u019dj\3\2\2\2\u019e\u019f"+
		"\t\17\2\2\u019fl\3\2\2\2\u01a0\u01a1\t\20\2\2\u01a1n\3\2\2\2\u01a2\u01a3"+
		"\t\21\2\2\u01a3p\3\2\2\2\u01a4\u01a5\t\22\2\2\u01a5r\3\2\2\2\u01a6\u01a7"+
		"\t\23\2\2\u01a7t\3\2\2\2\u01a8\u01a9\t\24\2\2\u01a9v\3\2\2\2\u01aa\u01ab"+
		"\t\25\2\2\u01abx\3\2\2\2\u01ac\u01ad\t\26\2\2\u01adz\3\2\2\2\u01ae\u01af"+
		"\t\27\2\2\u01af|\3\2\2\2\u01b0\u01b1\t\30\2\2\u01b1~\3\2\2\2\u01b2\u01b3"+
		"\t\31\2\2\u01b3\u0080\3\2\2\2\u01b4\u01b5\t\32\2\2\u01b5\u0082\3\2\2\2"+
		"\u01b6\u01b7\t\33\2\2\u01b7\u0084\3\2\2\2\u01b8\u01b9\t\34\2\2\u01b9\u0086"+
		"\3\2\2\2\u01ba\u01bb\t\35\2\2\u01bb\u0088\3\2\2\2\u01bc\u01bd\t\36\2\2"+
		"\u01bd\u008a\3\2\2\2\u01be\u01bf\t\37\2\2\u01bf\u008c\3\2\2\2\u01c0\u01c1"+
		"\t \2\2\u01c1\u008e\3\2\2\2\u01c2\u01c3\t!\2\2\u01c3\u0090\3\2\2\2\16"+
		"\2\u00a3\u00a9\u00ac\u00bf\u00c1\u00c3\u0119\u011b\u015c\u0162\u016c\3"+
		"\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}