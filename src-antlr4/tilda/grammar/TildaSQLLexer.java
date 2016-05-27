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
		TIMESTAMP_LITERAL=10, CURRENT_TIMESTAMP=11, TIMESTAMP_YESTERDAY=12, TIMESTAMP_YESTERDAY_LAST=13, 
		TIMESTAMP_TODAY=14, TIMESTAMP_TODAY_LAST=15, TIMESTAMP_TOMORROW=16, TIMESTAMP_TOMORROW_LAST=17, 
		STRING_LITERAL=18, BIND_PARAMETER=19, K_AND=20, K_BETWEEN=21, K_IN=22, 
		K_IS=23, K_LIKE=24, K_NOT=25, K_NULL=26, K_ON=27, K_OR=28, K_REGEXP=29, 
		K_LT=30, K_LTE=31, K_GT=32, K_GTE=33, K_EQ=34, K_NEQ=35, IDENTIFIER=36, 
		PLUS_MINUS=37, YEAR_LITERAL=38, MONTH_LITERAL=39, DAY_LITERAL=40, HOUR_LITERAL_24=41, 
		MINUTE_LITERAL=42, SECOND_LITERAL=43, HOUR_LITERAL_12=44, QUOTE=45, SPACES=46, 
		UNEXPECTED_CHAR=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NUMERIC_LITERAL", 
		"TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", "TIMESTAMP_YESTERDAY_LAST", 
		"TIMESTAMP_TODAY", "TIMESTAMP_TODAY_LAST", "TIMESTAMP_TOMORROW", "TIMESTAMP_TOMORROW_LAST", 
		"STRING_LITERAL", "BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", "K_IS", 
		"K_LIKE", "K_NOT", "K_NULL", "K_ON", "K_OR", "K_REGEXP", "K_LT", "K_LTE", 
		"K_GT", "K_GTE", "K_EQ", "K_NEQ", "IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", 
		"MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", 
		"HOUR_LITERAL_12", "QUOTE", "SPACES", "UNEXPECTED_CHAR", "DIGIT", "A", 
		"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
		"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "','", "'.'", null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "'<'", null, "'>'", null, "'='", 
		null, null, null, null, null, null, null, null, null, null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "NUMERIC_LITERAL", 
		"TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", "TIMESTAMP_YESTERDAY_LAST", 
		"TIMESTAMP_TODAY", "TIMESTAMP_TODAY_LAST", "TIMESTAMP_TOMORROW", "TIMESTAMP_TOMORROW_LAST", 
		"STRING_LITERAL", "BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", "K_IS", 
		"K_LIKE", "K_NOT", "K_NULL", "K_ON", "K_OR", "K_REGEXP", "K_LT", "K_LTE", 
		"K_GT", "K_GTE", "K_EQ", "K_NEQ", "IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", 
		"MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", 
		"HOUR_LITERAL_12", "QUOTE", "SPACES", "UNEXPECTED_CHAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u0213\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\6\n\u00a9\n\n\r\n\16\n\u00aa\3\n\3\n\7\n\u00af\n\n\f\n"+
		"\16\n\u00b2\13\n\5\n\u00b4\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c7\n\13\5\13\u00c9"+
		"\n\13\5\13\u00cb\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u0162\n\23\f\23\16\23\u0165\13\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0175\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u019b\n\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3"+
		"\"\3#\3#\3$\3$\3$\3$\5$\u01b4\n$\3%\3%\7%\u01b8\n%\f%\16%\u01bb\13%\3"+
		"&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,"+
		"\3-\3-\3-\3.\3.\3/\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3"+
		"=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3"+
		"H\3I\3I\3J\3J\3K\3K\2\2L\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\2c"+
		"\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085"+
		"\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\3\2"+
		"\"\3\2))\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\5\2\13\r\17\17\"\"\3\2\62;"+
		"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2K"+
		"Kkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4"+
		"\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\"+
		"||\u0203\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\3\u0097\3\2\2\2\5\u0099\3\2\2\2\7\u009b\3\2\2\2\t\u009d\3\2\2\2\13"+
		"\u009f\3\2\2\2\r\u00a1\3\2\2\2\17\u00a3\3\2\2\2\21\u00a5\3\2\2\2\23\u00a8"+
		"\3\2\2\2\25\u00b5\3\2\2\2\27\u00ce\3\2\2\2\31\u00e0\3\2\2\2\33\u00f4\3"+
		"\2\2\2\35\u010d\3\2\2\2\37\u011d\3\2\2\2!\u0132\3\2\2\2#\u0145\3\2\2\2"+
		"%\u015d\3\2\2\2\'\u0168\3\2\2\2)\u0174\3\2\2\2+\u0176\3\2\2\2-\u017e\3"+
		"\2\2\2/\u0181\3\2\2\2\61\u0184\3\2\2\2\63\u0189\3\2\2\2\65\u018d\3\2\2"+
		"\2\67\u0192\3\2\2\29\u019a\3\2\2\2;\u019c\3\2\2\2=\u01a3\3\2\2\2?\u01a5"+
		"\3\2\2\2A\u01a8\3\2\2\2C\u01aa\3\2\2\2E\u01ad\3\2\2\2G\u01b3\3\2\2\2I"+
		"\u01b5\3\2\2\2K\u01bc\3\2\2\2M\u01be\3\2\2\2O\u01c3\3\2\2\2Q\u01c6\3\2"+
		"\2\2S\u01c9\3\2\2\2U\u01cc\3\2\2\2W\u01cf\3\2\2\2Y\u01d2\3\2\2\2[\u01d5"+
		"\3\2\2\2]\u01d7\3\2\2\2_\u01db\3\2\2\2a\u01dd\3\2\2\2c\u01df\3\2\2\2e"+
		"\u01e1\3\2\2\2g\u01e3\3\2\2\2i\u01e5\3\2\2\2k\u01e7\3\2\2\2m\u01e9\3\2"+
		"\2\2o\u01eb\3\2\2\2q\u01ed\3\2\2\2s\u01ef\3\2\2\2u\u01f1\3\2\2\2w\u01f3"+
		"\3\2\2\2y\u01f5\3\2\2\2{\u01f7\3\2\2\2}\u01f9\3\2\2\2\177\u01fb\3\2\2"+
		"\2\u0081\u01fd\3\2\2\2\u0083\u01ff\3\2\2\2\u0085\u0201\3\2\2\2\u0087\u0203"+
		"\3\2\2\2\u0089\u0205\3\2\2\2\u008b\u0207\3\2\2\2\u008d\u0209\3\2\2\2\u008f"+
		"\u020b\3\2\2\2\u0091\u020d\3\2\2\2\u0093\u020f\3\2\2\2\u0095\u0211\3\2"+
		"\2\2\u0097\u0098\7*\2\2\u0098\4\3\2\2\2\u0099\u009a\7+\2\2\u009a\6\3\2"+
		"\2\2\u009b\u009c\7-\2\2\u009c\b\3\2\2\2\u009d\u009e\7/\2\2\u009e\n\3\2"+
		"\2\2\u009f\u00a0\7,\2\2\u00a0\f\3\2\2\2\u00a1\u00a2\7\61\2\2\u00a2\16"+
		"\3\2\2\2\u00a3\u00a4\7.\2\2\u00a4\20\3\2\2\2\u00a5\u00a6\7\60\2\2\u00a6"+
		"\22\3\2\2\2\u00a7\u00a9\5a\61\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2"+
		"\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00b3\3\2\2\2\u00ac\u00b0"+
		"\7\60\2\2\u00ad\u00af\5a\61\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2"+
		"\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b3\u00ac\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\24\3\2\2\2\u00b5"+
		"\u00b6\7)\2\2\u00b6\u00b7\5M\'\2\u00b7\u00b8\7/\2\2\u00b8\u00b9\5O(\2"+
		"\u00b9\u00ba\7/\2\2\u00ba\u00ca\5Q)\2\u00bb\u00bc\7V\2\2\u00bc\u00bd\5"+
		"S*\2\u00bd\u00be\7<\2\2\u00be\u00c8\5U+\2\u00bf\u00c0\7<\2\2\u00c0\u00c6"+
		"\5W,\2\u00c1\u00c2\5K&\2\u00c2\u00c3\5Y-\2\u00c3\u00c4\7<\2\2\u00c4\u00c5"+
		"\5U+\2\u00c5\u00c7\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c9\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00bb\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\7)\2\2\u00cd\26\3\2\2\2\u00ce\u00cf\5g\64\2\u00cf\u00d0\5\u008b"+
		"F\2\u00d0\u00d1\5\u0085C\2\u00d1\u00d2\5\u0085C\2\u00d2\u00d3\5k\66\2"+
		"\u00d3\u00d4\5}?\2\u00d4\u00d5\5\u0089E\2\u00d5\u00d6\7a\2\2\u00d6\u00d7"+
		"\5\u0089E\2\u00d7\u00d8\5s:\2\u00d8\u00d9\5{>\2\u00d9\u00da\5k\66\2\u00da"+
		"\u00db\5\u0087D\2\u00db\u00dc\5\u0089E\2\u00dc\u00dd\5c\62\2\u00dd\u00de"+
		"\5{>\2\u00de\u00df\5\u0081A\2\u00df\30\3\2\2\2\u00e0\u00e1\5\u0089E\2"+
		"\u00e1\u00e2\5s:\2\u00e2\u00e3\5{>\2\u00e3\u00e4\5k\66\2\u00e4\u00e5\5"+
		"\u0087D\2\u00e5\u00e6\5\u0089E\2\u00e6\u00e7\5c\62\2\u00e7\u00e8\5{>\2"+
		"\u00e8\u00e9\5\u0081A\2\u00e9\u00ea\7a\2\2\u00ea\u00eb\5\u0093J\2\u00eb"+
		"\u00ec\5k\66\2\u00ec\u00ed\5\u0087D\2\u00ed\u00ee\5\u0089E\2\u00ee\u00ef"+
		"\5k\66\2\u00ef\u00f0\5\u0085C\2\u00f0\u00f1\5i\65\2\u00f1\u00f2\5c\62"+
		"\2\u00f2\u00f3\5\u0093J\2\u00f3\32\3\2\2\2\u00f4\u00f5\5\u0089E\2\u00f5"+
		"\u00f6\5s:\2\u00f6\u00f7\5{>\2\u00f7\u00f8\5k\66\2\u00f8\u00f9\5\u0087"+
		"D\2\u00f9\u00fa\5\u0089E\2\u00fa\u00fb\5c\62\2\u00fb\u00fc\5{>\2\u00fc"+
		"\u00fd\5\u0081A\2\u00fd\u00fe\7a\2\2\u00fe\u00ff\5\u0093J\2\u00ff\u0100"+
		"\5k\66\2\u0100\u0101\5\u0087D\2\u0101\u0102\5\u0089E\2\u0102\u0103\5k"+
		"\66\2\u0103\u0104\5\u0085C\2\u0104\u0105\5i\65\2\u0105\u0106\5c\62\2\u0106"+
		"\u0107\5\u0093J\2\u0107\u0108\7a\2\2\u0108\u0109\5y=\2\u0109\u010a\5c"+
		"\62\2\u010a\u010b\5\u0087D\2\u010b\u010c\5\u0089E\2\u010c\34\3\2\2\2\u010d"+
		"\u010e\5\u0089E\2\u010e\u010f\5s:\2\u010f\u0110\5{>\2\u0110\u0111\5k\66"+
		"\2\u0111\u0112\5\u0087D\2\u0112\u0113\5\u0089E\2\u0113\u0114\5c\62\2\u0114"+
		"\u0115\5{>\2\u0115\u0116\5\u0081A\2\u0116\u0117\7a\2\2\u0117\u0118\5\u0089"+
		"E\2\u0118\u0119\5\177@\2\u0119\u011a\5i\65\2\u011a\u011b\5c\62\2\u011b"+
		"\u011c\5\u0093J\2\u011c\36\3\2\2\2\u011d\u011e\5\u0089E\2\u011e\u011f"+
		"\5s:\2\u011f\u0120\5{>\2\u0120\u0121\5k\66\2\u0121\u0122\5\u0087D\2\u0122"+
		"\u0123\5\u0089E\2\u0123\u0124\5c\62\2\u0124\u0125\5{>\2\u0125\u0126\5"+
		"\u0081A\2\u0126\u0127\7a\2\2\u0127\u0128\5\u0089E\2\u0128\u0129\5\177"+
		"@\2\u0129\u012a\5i\65\2\u012a\u012b\5c\62\2\u012b\u012c\5\u0093J\2\u012c"+
		"\u012d\7a\2\2\u012d\u012e\5y=\2\u012e\u012f\5c\62\2\u012f\u0130\5\u0087"+
		"D\2\u0130\u0131\5\u0089E\2\u0131 \3\2\2\2\u0132\u0133\5\u0089E\2\u0133"+
		"\u0134\5s:\2\u0134\u0135\5{>\2\u0135\u0136\5k\66\2\u0136\u0137\5\u0087"+
		"D\2\u0137\u0138\5\u0089E\2\u0138\u0139\5c\62\2\u0139\u013a\5{>\2\u013a"+
		"\u013b\5\u0081A\2\u013b\u013c\7a\2\2\u013c\u013d\5\u0089E\2\u013d\u013e"+
		"\5\177@\2\u013e\u013f\5{>\2\u013f\u0140\5\177@\2\u0140\u0141\5\u0085C"+
		"\2\u0141\u0142\5\u0085C\2\u0142\u0143\5\177@\2\u0143\u0144\5\u008fH\2"+
		"\u0144\"\3\2\2\2\u0145\u0146\5\u0089E\2\u0146\u0147\5s:\2\u0147\u0148"+
		"\5{>\2\u0148\u0149\5k\66\2\u0149\u014a\5\u0087D\2\u014a\u014b\5\u0089"+
		"E\2\u014b\u014c\5c\62\2\u014c\u014d\5{>\2\u014d\u014e\5\u0081A\2\u014e"+
		"\u014f\7a\2\2\u014f\u0150\5\u0089E\2\u0150\u0151\5\177@\2\u0151\u0152"+
		"\5{>\2\u0152\u0153\5\177@\2\u0153\u0154\5\u0085C\2\u0154\u0155\5\u0085"+
		"C\2\u0155\u0156\5\177@\2\u0156\u0157\5\u008fH\2\u0157\u0158\7a\2\2\u0158"+
		"\u0159\5y=\2\u0159\u015a\5c\62\2\u015a\u015b\5\u0087D\2\u015b\u015c\5"+
		"\u0089E\2\u015c$\3\2\2\2\u015d\u0163\7)\2\2\u015e\u0162\n\2\2\2\u015f"+
		"\u0160\7)\2\2\u0160\u0162\7)\2\2\u0161\u015e\3\2\2\2\u0161\u015f\3\2\2"+
		"\2\u0162\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166"+
		"\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0167\7)\2\2\u0167&\3\2\2\2\u0168\u0169"+
		"\7A\2\2\u0169\u016a\7}\2\2\u016a\u016b\3\2\2\2\u016b\u016c\5I%\2\u016c"+
		"\u016d\7\177\2\2\u016d(\3\2\2\2\u016e\u016f\5c\62\2\u016f\u0170\5}?\2"+
		"\u0170\u0171\5i\65\2\u0171\u0175\3\2\2\2\u0172\u0173\7(\2\2\u0173\u0175"+
		"\7(\2\2\u0174\u016e\3\2\2\2\u0174\u0172\3\2\2\2\u0175*\3\2\2\2\u0176\u0177"+
		"\5e\63\2\u0177\u0178\5k\66\2\u0178\u0179\5\u0089E\2\u0179\u017a\5\u008f"+
		"H\2\u017a\u017b\5k\66\2\u017b\u017c\5k\66\2\u017c\u017d\5}?\2\u017d,\3"+
		"\2\2\2\u017e\u017f\5s:\2\u017f\u0180\5}?\2\u0180.\3\2\2\2\u0181\u0182"+
		"\5s:\2\u0182\u0183\5\u0087D\2\u0183\60\3\2\2\2\u0184\u0185\5y=\2\u0185"+
		"\u0186\5s:\2\u0186\u0187\5w<\2\u0187\u0188\5k\66\2\u0188\62\3\2\2\2\u0189"+
		"\u018a\5}?\2\u018a\u018b\5\177@\2\u018b\u018c\5\u0089E\2\u018c\64\3\2"+
		"\2\2\u018d\u018e\5}?\2\u018e\u018f\5\u008bF\2\u018f\u0190\5y=\2\u0190"+
		"\u0191\5y=\2\u0191\66\3\2\2\2\u0192\u0193\5\177@\2\u0193\u0194\5}?\2\u0194"+
		"8\3\2\2\2\u0195\u0196\5\177@\2\u0196\u0197\5\u0085C\2\u0197\u019b\3\2"+
		"\2\2\u0198\u0199\7~\2\2\u0199\u019b\7~\2\2\u019a\u0195\3\2\2\2\u019a\u0198"+
		"\3\2\2\2\u019b:\3\2\2\2\u019c\u019d\5\u0085C\2\u019d\u019e\5k\66\2\u019e"+
		"\u019f\5o8\2\u019f\u01a0\5k\66\2\u01a0\u01a1\5\u0091I\2\u01a1\u01a2\5"+
		"\u0081A\2\u01a2<\3\2\2\2\u01a3\u01a4\7>\2\2\u01a4>\3\2\2\2\u01a5\u01a6"+
		"\7>\2\2\u01a6\u01a7\7?\2\2\u01a7@\3\2\2\2\u01a8\u01a9\7@\2\2\u01a9B\3"+
		"\2\2\2\u01aa\u01ab\7@\2\2\u01ab\u01ac\7?\2\2\u01acD\3\2\2\2\u01ad\u01ae"+
		"\7?\2\2\u01aeF\3\2\2\2\u01af\u01b0\7>\2\2\u01b0\u01b4\7@\2\2\u01b1\u01b2"+
		"\7#\2\2\u01b2\u01b4\7?\2\2\u01b3\u01af\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4"+
		"H\3\2\2\2\u01b5\u01b9\t\3\2\2\u01b6\u01b8\t\4\2\2\u01b7\u01b6\3\2\2\2"+
		"\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01baJ\3"+
		"\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01bd\t\5\2\2\u01bdL\3\2\2\2\u01be\u01bf"+
		"\5a\61\2\u01bf\u01c0\5a\61\2\u01c0\u01c1\5a\61\2\u01c1\u01c2\5a\61\2\u01c2"+
		"N\3\2\2\2\u01c3\u01c4\5a\61\2\u01c4\u01c5\5a\61\2\u01c5P\3\2\2\2\u01c6"+
		"\u01c7\5a\61\2\u01c7\u01c8\5a\61\2\u01c8R\3\2\2\2\u01c9\u01ca\5a\61\2"+
		"\u01ca\u01cb\5a\61\2\u01cbT\3\2\2\2\u01cc\u01cd\5a\61\2\u01cd\u01ce\5"+
		"a\61\2\u01ceV\3\2\2\2\u01cf\u01d0\5a\61\2\u01d0\u01d1\5a\61\2\u01d1X\3"+
		"\2\2\2\u01d2\u01d3\5a\61\2\u01d3\u01d4\5a\61\2\u01d4Z\3\2\2\2\u01d5\u01d6"+
		"\7)\2\2\u01d6\\\3\2\2\2\u01d7\u01d8\t\6\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\b/\2\2\u01da^\3\2\2\2\u01db\u01dc\13\2\2\2\u01dc`\3\2\2\2\u01dd"+
		"\u01de\t\7\2\2\u01deb\3\2\2\2\u01df\u01e0\t\b\2\2\u01e0d\3\2\2\2\u01e1"+
		"\u01e2\t\t\2\2\u01e2f\3\2\2\2\u01e3\u01e4\t\n\2\2\u01e4h\3\2\2\2\u01e5"+
		"\u01e6\t\13\2\2\u01e6j\3\2\2\2\u01e7\u01e8\t\f\2\2\u01e8l\3\2\2\2\u01e9"+
		"\u01ea\t\r\2\2\u01ean\3\2\2\2\u01eb\u01ec\t\16\2\2\u01ecp\3\2\2\2\u01ed"+
		"\u01ee\t\17\2\2\u01eer\3\2\2\2\u01ef\u01f0\t\20\2\2\u01f0t\3\2\2\2\u01f1"+
		"\u01f2\t\21\2\2\u01f2v\3\2\2\2\u01f3\u01f4\t\22\2\2\u01f4x\3\2\2\2\u01f5"+
		"\u01f6\t\23\2\2\u01f6z\3\2\2\2\u01f7\u01f8\t\24\2\2\u01f8|\3\2\2\2\u01f9"+
		"\u01fa\t\25\2\2\u01fa~\3\2\2\2\u01fb\u01fc\t\26\2\2\u01fc\u0080\3\2\2"+
		"\2\u01fd\u01fe\t\27\2\2\u01fe\u0082\3\2\2\2\u01ff\u0200\t\30\2\2\u0200"+
		"\u0084\3\2\2\2\u0201\u0202\t\31\2\2\u0202\u0086\3\2\2\2\u0203\u0204\t"+
		"\32\2\2\u0204\u0088\3\2\2\2\u0205\u0206\t\33\2\2\u0206\u008a\3\2\2\2\u0207"+
		"\u0208\t\34\2\2\u0208\u008c\3\2\2\2\u0209\u020a\t\35\2\2\u020a\u008e\3"+
		"\2\2\2\u020b\u020c\t\36\2\2\u020c\u0090\3\2\2\2\u020d\u020e\t\37\2\2\u020e"+
		"\u0092\3\2\2\2\u020f\u0210\t \2\2\u0210\u0094\3\2\2\2\u0211\u0212\t!\2"+
		"\2\u0212\u0096\3\2\2\2\17\2\u00aa\u00b0\u00b3\u00c6\u00c8\u00ca\u0161"+
		"\u0163\u0174\u019a\u01b3\u01b9\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}