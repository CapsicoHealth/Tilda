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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NUMERIC_LITERAL=12, TIMESTAMP_LITERAL=13, CURRENT_TIMESTAMP=14, 
		TIMESTAMP_YESTERDAY=15, TIMESTAMP_TODAY=16, TIMESTAMP_TOMORROW=17, LAST=18, 
		STRING_LITERAL=19, BIND_PARAMETER=20, K_AND=21, K_BETWEEN=22, K_IN=23, 
		K_IS=24, K_LIKE=25, K_NOT_LIKE=26, K_NOT=27, K_NULL=28, K_EMPTY=29, K_OR=30, 
		K_REGEXP=31, K_LT=32, K_LTE=33, K_GT=34, K_GTE=35, K_EQ=36, K_NEQ=37, 
		K_DIV=38, K_MINUS=39, K_LEN=40, K_DAYS_BETWEEN=41, K_CASE=42, K_WHEN=43, 
		K_THEN=44, K_ELSE=45, K_END=46, K_TRUE=47, K_FALSE=48, IDENTIFIER=49, 
		PLUS_MINUS=50, YEAR_LITERAL=51, MONTH_LITERAL=52, DAY_LITERAL=53, HOUR_LITERAL_24=54, 
		MINUTE_LITERAL=55, SECOND_LITERAL=56, HOUR_LITERAL_12=57, SPACES=58, UNEXPECTED_CHAR=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NUMERIC_LITERAL", "TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", 
		"TIMESTAMP_YESTERDAY", "TIMESTAMP_TODAY", "TIMESTAMP_TOMORROW", "LAST", 
		"STRING_LITERAL", "BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", "K_IS", 
		"K_LIKE", "K_NOT_LIKE", "K_NOT", "K_NULL", "K_EMPTY", "K_OR", "K_REGEXP", 
		"K_LT", "K_LTE", "K_GT", "K_GTE", "K_EQ", "K_NEQ", "K_DIV", "K_MINUS", 
		"K_LEN", "K_DAYS_BETWEEN", "K_CASE", "K_WHEN", "K_THEN", "K_ELSE", "K_END", 
		"K_TRUE", "K_FALSE", "IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", "MONTH_LITERAL", 
		"DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", 
		"HOUR_LITERAL_12", "SPACES", "UNEXPECTED_CHAR", "DIGIT", "A", "B", "C", 
		"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
		"R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'||'", "'='", "'=='", "'!='", "'<>'", "'('", "','", "')'", "'+'", 
		"'*'", "'.'", null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "'<'", "'<='", 
		"'>'", "'>='", null, null, "'/'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NUMERIC_LITERAL", "TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", 
		"TIMESTAMP_TODAY", "TIMESTAMP_TOMORROW", "LAST", "STRING_LITERAL", "BIND_PARAMETER", 
		"K_AND", "K_BETWEEN", "K_IN", "K_IS", "K_LIKE", "K_NOT_LIKE", "K_NOT", 
		"K_NULL", "K_EMPTY", "K_OR", "K_REGEXP", "K_LT", "K_LTE", "K_GT", "K_GTE", 
		"K_EQ", "K_NEQ", "K_DIV", "K_MINUS", "K_LEN", "K_DAYS_BETWEEN", "K_CASE", 
		"K_WHEN", "K_THEN", "K_ELSE", "K_END", "K_TRUE", "K_FALSE", "IDENTIFIER", 
		"PLUS_MINUS", "YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", 
		"MINUTE_LITERAL", "SECOND_LITERAL", "HOUR_LITERAL_12", "SPACES", "UNEXPECTED_CHAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u0233\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\r\u00cb\n"+
		"\r\r\r\16\r\u00cc\3\r\3\r\7\r\u00d1\n\r\f\r\16\r\u00d4\13\r\5\r\u00d6"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00e9\n\16\5\16\u00eb\n\16\5\16\u00ed\n\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7"+
		"\24\u0143\n\24\f\24\16\24\u0146\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\6\33\u016b\n\33\r\33\16\33\u016c\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3"+
		"%\5%\u0199\n%\3&\3&\3&\3&\5&\u019f\n&\3\'\3\'\3(\3(\3)\3)\3)\3)\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\62\3\62\7\62\u01da\n\62\f\62\16\62\u01dd\13\62\3"+
		"\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3;\3<\3<\3=\3=\3>\3>\3?\3"+
		"?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3"+
		"K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3"+
		"V\3W\3W\2\2X\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g"+
		"\65i\66k\67m8o9q:s;u<w=y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2"+
		"\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099"+
		"\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab"+
		"\2\u00ad\2\3\2\"\3\2))\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\5\2\13\r\17\17"+
		"\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4"+
		"\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRr"+
		"r\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2"+
		"[[{{\4\2\\\\||\u0223\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2"+
		"\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w"+
		"\3\2\2\2\3\u00af\3\2\2\2\5\u00b2\3\2\2\2\7\u00b4\3\2\2\2\t\u00b7\3\2\2"+
		"\2\13\u00ba\3\2\2\2\r\u00bd\3\2\2\2\17\u00bf\3\2\2\2\21\u00c1\3\2\2\2"+
		"\23\u00c3\3\2\2\2\25\u00c5\3\2\2\2\27\u00c7\3\2\2\2\31\u00ca\3\2\2\2\33"+
		"\u00d7\3\2\2\2\35\u00f0\3\2\2\2\37\u0102\3\2\2\2!\u0116\3\2\2\2#\u0126"+
		"\3\2\2\2%\u0139\3\2\2\2\'\u013e\3\2\2\2)\u0149\3\2\2\2+\u014f\3\2\2\2"+
		"-\u0153\3\2\2\2/\u015b\3\2\2\2\61\u015e\3\2\2\2\63\u0161\3\2\2\2\65\u0166"+
		"\3\2\2\2\67\u0173\3\2\2\29\u0177\3\2\2\2;\u017c\3\2\2\2=\u0182\3\2\2\2"+
		"?\u0185\3\2\2\2A\u018c\3\2\2\2C\u018e\3\2\2\2E\u0191\3\2\2\2G\u0193\3"+
		"\2\2\2I\u0196\3\2\2\2K\u019e\3\2\2\2M\u01a0\3\2\2\2O\u01a2\3\2\2\2Q\u01a4"+
		"\3\2\2\2S\u01a8\3\2\2\2U\u01b4\3\2\2\2W\u01b9\3\2\2\2Y\u01be\3\2\2\2["+
		"\u01c3\3\2\2\2]\u01c8\3\2\2\2_\u01cc\3\2\2\2a\u01d1\3\2\2\2c\u01d7\3\2"+
		"\2\2e\u01de\3\2\2\2g\u01e0\3\2\2\2i\u01e5\3\2\2\2k\u01e8\3\2\2\2m\u01eb"+
		"\3\2\2\2o\u01ee\3\2\2\2q\u01f1\3\2\2\2s\u01f4\3\2\2\2u\u01f7\3\2\2\2w"+
		"\u01fb\3\2\2\2y\u01fd\3\2\2\2{\u01ff\3\2\2\2}\u0201\3\2\2\2\177\u0203"+
		"\3\2\2\2\u0081\u0205\3\2\2\2\u0083\u0207\3\2\2\2\u0085\u0209\3\2\2\2\u0087"+
		"\u020b\3\2\2\2\u0089\u020d\3\2\2\2\u008b\u020f\3\2\2\2\u008d\u0211\3\2"+
		"\2\2\u008f\u0213\3\2\2\2\u0091\u0215\3\2\2\2\u0093\u0217\3\2\2\2\u0095"+
		"\u0219\3\2\2\2\u0097\u021b\3\2\2\2\u0099\u021d\3\2\2\2\u009b\u021f\3\2"+
		"\2\2\u009d\u0221\3\2\2\2\u009f\u0223\3\2\2\2\u00a1\u0225\3\2\2\2\u00a3"+
		"\u0227\3\2\2\2\u00a5\u0229\3\2\2\2\u00a7\u022b\3\2\2\2\u00a9\u022d\3\2"+
		"\2\2\u00ab\u022f\3\2\2\2\u00ad\u0231\3\2\2\2\u00af\u00b0\7~\2\2\u00b0"+
		"\u00b1\7~\2\2\u00b1\4\3\2\2\2\u00b2\u00b3\7?\2\2\u00b3\6\3\2\2\2\u00b4"+
		"\u00b5\7?\2\2\u00b5\u00b6\7?\2\2\u00b6\b\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8"+
		"\u00b9\7?\2\2\u00b9\n\3\2\2\2\u00ba\u00bb\7>\2\2\u00bb\u00bc\7@\2\2\u00bc"+
		"\f\3\2\2\2\u00bd\u00be\7*\2\2\u00be\16\3\2\2\2\u00bf\u00c0\7.\2\2\u00c0"+
		"\20\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2\22\3\2\2\2\u00c3\u00c4\7-\2\2\u00c4"+
		"\24\3\2\2\2\u00c5\u00c6\7,\2\2\u00c6\26\3\2\2\2\u00c7\u00c8\7\60\2\2\u00c8"+
		"\30\3\2\2\2\u00c9\u00cb\5y=\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2"+
		"\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00d5\3\2\2\2\u00ce\u00d2"+
		"\7\60\2\2\u00cf\u00d1\5y=\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d5\u00ce\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\32\3\2\2\2\u00d7\u00d8"+
		"\7)\2\2\u00d8\u00d9\5g\64\2\u00d9\u00da\7/\2\2\u00da\u00db\5i\65\2\u00db"+
		"\u00dc\7/\2\2\u00dc\u00ec\5k\66\2\u00dd\u00de\7V\2\2\u00de\u00df\5m\67"+
		"\2\u00df\u00e0\7<\2\2\u00e0\u00ea\5o8\2\u00e1\u00e2\7<\2\2\u00e2\u00e8"+
		"\5q9\2\u00e3\u00e4\5e\63\2\u00e4\u00e5\5s:\2\u00e5\u00e6\7<\2\2\u00e6"+
		"\u00e7\5o8\2\u00e7\u00e9\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e9\3\2\2"+
		"\2\u00e9\u00eb\3\2\2\2\u00ea\u00e1\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed"+
		"\3\2\2\2\u00ec\u00dd\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\7)\2\2\u00ef\34\3\2\2\2\u00f0\u00f1\5\177@\2\u00f1\u00f2\5\u00a3"+
		"R\2\u00f2\u00f3\5\u009dO\2\u00f3\u00f4\5\u009dO\2\u00f4\u00f5\5\u0083"+
		"B\2\u00f5\u00f6\5\u0095K\2\u00f6\u00f7\5\u00a1Q\2\u00f7\u00f8\7a\2\2\u00f8"+
		"\u00f9\5\u00a1Q\2\u00f9\u00fa\5\u008bF\2\u00fa\u00fb\5\u0093J\2\u00fb"+
		"\u00fc\5\u0083B\2\u00fc\u00fd\5\u009fP\2\u00fd\u00fe\5\u00a1Q\2\u00fe"+
		"\u00ff\5{>\2\u00ff\u0100\5\u0093J\2\u0100\u0101\5\u0099M\2\u0101\36\3"+
		"\2\2\2\u0102\u0103\5\u00a1Q\2\u0103\u0104\5\u008bF\2\u0104\u0105\5\u0093"+
		"J\2\u0105\u0106\5\u0083B\2\u0106\u0107\5\u009fP\2\u0107\u0108\5\u00a1"+
		"Q\2\u0108\u0109\5{>\2\u0109\u010a\5\u0093J\2\u010a\u010b\5\u0099M\2\u010b"+
		"\u010c\7a\2\2\u010c\u010d\5\u00abV\2\u010d\u010e\5\u0083B\2\u010e\u010f"+
		"\5\u009fP\2\u010f\u0110\5\u00a1Q\2\u0110\u0111\5\u0083B\2\u0111\u0112"+
		"\5\u009dO\2\u0112\u0113\5\u0081A\2\u0113\u0114\5{>\2\u0114\u0115\5\u00ab"+
		"V\2\u0115 \3\2\2\2\u0116\u0117\5\u00a1Q\2\u0117\u0118\5\u008bF\2\u0118"+
		"\u0119\5\u0093J\2\u0119\u011a\5\u0083B\2\u011a\u011b\5\u009fP\2\u011b"+
		"\u011c\5\u00a1Q\2\u011c\u011d\5{>\2\u011d\u011e\5\u0093J\2\u011e\u011f"+
		"\5\u0099M\2\u011f\u0120\7a\2\2\u0120\u0121\5\u00a1Q\2\u0121\u0122\5\u0097"+
		"L\2\u0122\u0123\5\u0081A\2\u0123\u0124\5{>\2\u0124\u0125\5\u00abV\2\u0125"+
		"\"\3\2\2\2\u0126\u0127\5\u00a1Q\2\u0127\u0128\5\u008bF\2\u0128\u0129\5"+
		"\u0093J\2\u0129\u012a\5\u0083B\2\u012a\u012b\5\u009fP\2\u012b\u012c\5"+
		"\u00a1Q\2\u012c\u012d\5{>\2\u012d\u012e\5\u0093J\2\u012e\u012f\5\u0099"+
		"M\2\u012f\u0130\7a\2\2\u0130\u0131\5\u00a1Q\2\u0131\u0132\5\u0097L\2\u0132"+
		"\u0133\5\u0093J\2\u0133\u0134\5\u0097L\2\u0134\u0135\5\u009dO\2\u0135"+
		"\u0136\5\u009dO\2\u0136\u0137\5\u0097L\2\u0137\u0138\5\u00a7T\2\u0138"+
		"$\3\2\2\2\u0139\u013a\5\u0091I\2\u013a\u013b\5{>\2\u013b\u013c\5\u009f"+
		"P\2\u013c\u013d\5\u00a1Q\2\u013d&\3\2\2\2\u013e\u0144\7)\2\2\u013f\u0143"+
		"\n\2\2\2\u0140\u0141\7)\2\2\u0141\u0143\7)\2\2\u0142\u013f\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7)\2\2\u0148"+
		"(\3\2\2\2\u0149\u014a\7A\2\2\u014a\u014b\7}\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014d\5c\62\2\u014d\u014e\7\177\2\2\u014e*\3\2\2\2\u014f\u0150\5{>\2"+
		"\u0150\u0151\5\u0095K\2\u0151\u0152\5\u0081A\2\u0152,\3\2\2\2\u0153\u0154"+
		"\5}?\2\u0154\u0155\5\u0083B\2\u0155\u0156\5\u00a1Q\2\u0156\u0157\5\u00a7"+
		"T\2\u0157\u0158\5\u0083B\2\u0158\u0159\5\u0083B\2\u0159\u015a\5\u0095"+
		"K\2\u015a.\3\2\2\2\u015b\u015c\5\u008bF\2\u015c\u015d\5\u0095K\2\u015d"+
		"\60\3\2\2\2\u015e\u015f\5\u008bF\2\u015f\u0160\5\u009fP\2\u0160\62\3\2"+
		"\2\2\u0161\u0162\5\u0091I\2\u0162\u0163\5\u008bF\2\u0163\u0164\5\u008f"+
		"H\2\u0164\u0165\5\u0083B\2\u0165\64\3\2\2\2\u0166\u0167\5\u0095K\2\u0167"+
		"\u0168\5\u0097L\2\u0168\u016a\5\u00a1Q\2\u0169\u016b\7\"\2\2\u016a\u0169"+
		"\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016f\5\u0091I\2\u016f\u0170\5\u008bF\2\u0170\u0171"+
		"\5\u008fH\2\u0171\u0172\5\u0083B\2\u0172\66\3\2\2\2\u0173\u0174\5\u0095"+
		"K\2\u0174\u0175\5\u0097L\2\u0175\u0176\5\u00a1Q\2\u01768\3\2\2\2\u0177"+
		"\u0178\5\u0095K\2\u0178\u0179\5\u00a3R\2\u0179\u017a\5\u0091I\2\u017a"+
		"\u017b\5\u0091I\2\u017b:\3\2\2\2\u017c\u017d\5\u0083B\2\u017d\u017e\5"+
		"\u0093J\2\u017e\u017f\5\u0099M\2\u017f\u0180\5\u00a1Q\2\u0180\u0181\5"+
		"\u00abV\2\u0181<\3\2\2\2\u0182\u0183\5\u0097L\2\u0183\u0184\5\u009dO\2"+
		"\u0184>\3\2\2\2\u0185\u0186\5\u009dO\2\u0186\u0187\5\u0083B\2\u0187\u0188"+
		"\5\u0087D\2\u0188\u0189\5\u0083B\2\u0189\u018a\5\u00a9U\2\u018a\u018b"+
		"\5\u0099M\2\u018b@\3\2\2\2\u018c\u018d\7>\2\2\u018dB\3\2\2\2\u018e\u018f"+
		"\7>\2\2\u018f\u0190\7?\2\2\u0190D\3\2\2\2\u0191\u0192\7@\2\2\u0192F\3"+
		"\2\2\2\u0193\u0194\7@\2\2\u0194\u0195\7?\2\2\u0195H\3\2\2\2\u0196\u0198"+
		"\7?\2\2\u0197\u0199\7?\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199"+
		"J\3\2\2\2\u019a\u019b\7>\2\2\u019b\u019f\7@\2\2\u019c\u019d\7#\2\2\u019d"+
		"\u019f\7?\2\2\u019e\u019a\3\2\2\2\u019e\u019c\3\2\2\2\u019fL\3\2\2\2\u01a0"+
		"\u01a1\7\61\2\2\u01a1N\3\2\2\2\u01a2\u01a3\7/\2\2\u01a3P\3\2\2\2\u01a4"+
		"\u01a5\5\u0091I\2\u01a5\u01a6\5\u0083B\2\u01a6\u01a7\5\u0095K\2\u01a7"+
		"R\3\2\2\2\u01a8\u01a9\5\u0081A\2\u01a9\u01aa\5{>\2\u01aa\u01ab\5\u00ab"+
		"V\2\u01ab\u01ac\5\u009fP\2\u01ac\u01ad\5}?\2\u01ad\u01ae\5\u0083B\2\u01ae"+
		"\u01af\5\u00a1Q\2\u01af\u01b0\5\u00a7T\2\u01b0\u01b1\5\u0083B\2\u01b1"+
		"\u01b2\5\u0083B\2\u01b2\u01b3\5\u0095K\2\u01b3T\3\2\2\2\u01b4\u01b5\5"+
		"\177@\2\u01b5\u01b6\5{>\2\u01b6\u01b7\5\u009fP\2\u01b7\u01b8\5\u0083B"+
		"\2\u01b8V\3\2\2\2\u01b9\u01ba\5\u00a7T\2\u01ba\u01bb\5\u0089E\2\u01bb"+
		"\u01bc\5\u0083B\2\u01bc\u01bd\5\u0095K\2\u01bdX\3\2\2\2\u01be\u01bf\5"+
		"\u00a1Q\2\u01bf\u01c0\5\u0089E\2\u01c0\u01c1\5\u0083B\2\u01c1\u01c2\5"+
		"\u0095K\2\u01c2Z\3\2\2\2\u01c3\u01c4\5\u0083B\2\u01c4\u01c5\5\u0091I\2"+
		"\u01c5\u01c6\5\u009fP\2\u01c6\u01c7\5\u0083B\2\u01c7\\\3\2\2\2\u01c8\u01c9"+
		"\5\u0083B\2\u01c9\u01ca\5\u0095K\2\u01ca\u01cb\5\u0081A\2\u01cb^\3\2\2"+
		"\2\u01cc\u01cd\5\u00a1Q\2\u01cd\u01ce\5\u009dO\2\u01ce\u01cf\5\u00a3R"+
		"\2\u01cf\u01d0\5\u0083B\2\u01d0`\3\2\2\2\u01d1\u01d2\5\u0085C\2\u01d2"+
		"\u01d3\5{>\2\u01d3\u01d4\5\u0091I\2\u01d4\u01d5\5\u009fP\2\u01d5\u01d6"+
		"\5\u0083B\2\u01d6b\3\2\2\2\u01d7\u01db\t\3\2\2\u01d8\u01da\t\4\2\2\u01d9"+
		"\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2"+
		"\2\2\u01dcd\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\t\5\2\2\u01dff\3\2"+
		"\2\2\u01e0\u01e1\5y=\2\u01e1\u01e2\5y=\2\u01e2\u01e3\5y=\2\u01e3\u01e4"+
		"\5y=\2\u01e4h\3\2\2\2\u01e5\u01e6\5y=\2\u01e6\u01e7\5y=\2\u01e7j\3\2\2"+
		"\2\u01e8\u01e9\5y=\2\u01e9\u01ea\5y=\2\u01eal\3\2\2\2\u01eb\u01ec\5y="+
		"\2\u01ec\u01ed\5y=\2\u01edn\3\2\2\2\u01ee\u01ef\5y=\2\u01ef\u01f0\5y="+
		"\2\u01f0p\3\2\2\2\u01f1\u01f2\5y=\2\u01f2\u01f3\5y=\2\u01f3r\3\2\2\2\u01f4"+
		"\u01f5\5y=\2\u01f5\u01f6\5y=\2\u01f6t\3\2\2\2\u01f7\u01f8\t\6\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fa\b;\2\2\u01fav\3\2\2\2\u01fb\u01fc\13\2\2\2"+
		"\u01fcx\3\2\2\2\u01fd\u01fe\t\7\2\2\u01fez\3\2\2\2\u01ff\u0200\t\b\2\2"+
		"\u0200|\3\2\2\2\u0201\u0202\t\t\2\2\u0202~\3\2\2\2\u0203\u0204\t\n\2\2"+
		"\u0204\u0080\3\2\2\2\u0205\u0206\t\13\2\2\u0206\u0082\3\2\2\2\u0207\u0208"+
		"\t\f\2\2\u0208\u0084\3\2\2\2\u0209\u020a\t\r\2\2\u020a\u0086\3\2\2\2\u020b"+
		"\u020c\t\16\2\2\u020c\u0088\3\2\2\2\u020d\u020e\t\17\2\2\u020e\u008a\3"+
		"\2\2\2\u020f\u0210\t\20\2\2\u0210\u008c\3\2\2\2\u0211\u0212\t\21\2\2\u0212"+
		"\u008e\3\2\2\2\u0213\u0214\t\22\2\2\u0214\u0090\3\2\2\2\u0215\u0216\t"+
		"\23\2\2\u0216\u0092\3\2\2\2\u0217\u0218\t\24\2\2\u0218\u0094\3\2\2\2\u0219"+
		"\u021a\t\25\2\2\u021a\u0096\3\2\2\2\u021b\u021c\t\26\2\2\u021c\u0098\3"+
		"\2\2\2\u021d\u021e\t\27\2\2\u021e\u009a\3\2\2\2\u021f\u0220\t\30\2\2\u0220"+
		"\u009c\3\2\2\2\u0221\u0222\t\31\2\2\u0222\u009e\3\2\2\2\u0223\u0224\t"+
		"\32\2\2\u0224\u00a0\3\2\2\2\u0225\u0226\t\33\2\2\u0226\u00a2\3\2\2\2\u0227"+
		"\u0228\t\34\2\2\u0228\u00a4\3\2\2\2\u0229\u022a\t\35\2\2\u022a\u00a6\3"+
		"\2\2\2\u022b\u022c\t\36\2\2\u022c\u00a8\3\2\2\2\u022d\u022e\t\37\2\2\u022e"+
		"\u00aa\3\2\2\2\u022f\u0230\t \2\2\u0230\u00ac\3\2\2\2\u0231\u0232\t!\2"+
		"\2\u0232\u00ae\3\2\2\2\17\2\u00cc\u00d2\u00d5\u00e8\u00ea\u00ec\u0142"+
		"\u0144\u016c\u0198\u019e\u01db\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}