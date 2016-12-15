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
		CHAR_LITERAL=19, STRING_LITERAL=20, BIND_PARAMETER=21, K_AND=22, K_BETWEEN=23, 
		K_IN=24, K_IS=25, K_LIKE=26, K_NOT_LIKE=27, K_NOT=28, K_NULL=29, K_EMPTY=30, 
		K_OR=31, K_REGEXP=32, K_LT=33, K_LTE=34, K_GT=35, K_GTE=36, K_EQ=37, K_NEQ=38, 
		K_DIV=39, K_MINUS=40, K_LEN=41, K_DAYS_BETWEEN=42, K_CASE=43, K_WHEN=44, 
		K_THEN=45, K_ELSE=46, K_END=47, K_TRUE=48, K_FALSE=49, IDENTIFIER=50, 
		PLUS_MINUS=51, YEAR_LITERAL=52, MONTH_LITERAL=53, DAY_LITERAL=54, HOUR_LITERAL_24=55, 
		MINUTE_LITERAL=56, SECOND_LITERAL=57, HOUR_LITERAL_12=58, SPACES=59, UNEXPECTED_CHAR=60;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NUMERIC_LITERAL", "TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", 
		"TIMESTAMP_YESTERDAY", "TIMESTAMP_TODAY", "TIMESTAMP_TOMORROW", "LAST", 
		"CHAR_LITERAL", "STRING_LITERAL", "BIND_PARAMETER", "K_AND", "K_BETWEEN", 
		"K_IN", "K_IS", "K_LIKE", "K_NOT_LIKE", "K_NOT", "K_NULL", "K_EMPTY", 
		"K_OR", "K_REGEXP", "K_LT", "K_LTE", "K_GT", "K_GTE", "K_EQ", "K_NEQ", 
		"K_DIV", "K_MINUS", "K_LEN", "K_DAYS_BETWEEN", "K_CASE", "K_WHEN", "K_THEN", 
		"K_ELSE", "K_END", "K_TRUE", "K_FALSE", "IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", 
		"MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", 
		"HOUR_LITERAL_12", "SPACES", "UNEXPECTED_CHAR", "DIGIT", "A", "B", "C", 
		"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
		"R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'||'", "'='", "'=='", "'!='", "'<>'", "'('", "','", "')'", "'+'", 
		"'*'", "'.'", null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "'<'", 
		"'<='", "'>'", "'>='", null, null, "'/'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NUMERIC_LITERAL", "TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", 
		"TIMESTAMP_TODAY", "TIMESTAMP_TOMORROW", "LAST", "CHAR_LITERAL", "STRING_LITERAL", 
		"BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", "K_IS", "K_LIKE", "K_NOT_LIKE", 
		"K_NOT", "K_NULL", "K_EMPTY", "K_OR", "K_REGEXP", "K_LT", "K_LTE", "K_GT", 
		"K_GTE", "K_EQ", "K_NEQ", "K_DIV", "K_MINUS", "K_LEN", "K_DAYS_BETWEEN", 
		"K_CASE", "K_WHEN", "K_THEN", "K_ELSE", "K_END", "K_TRUE", "K_FALSE", 
		"IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2>\u023f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\r\u00cd"+
		"\n\r\r\r\16\r\u00ce\3\r\3\r\7\r\u00d3\n\r\f\r\16\r\u00d6\13\r\5\r\u00d8"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00eb\n\16\5\16\u00ed\n\16\5\16\u00ef\n\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\5\24\u0147\n\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u014f\n\25"+
		"\f\25\16\25\u0152\13\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\6\34\u0177"+
		"\n\34\r\34\16\34\u0178\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3"+
		"!\3!\3!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3&\3&\5&\u01a5\n&\3\'\3"+
		"\'\3\'\3\'\5\'\u01ab\n\'\3(\3(\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/"+
		"\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\7\63\u01e6\n\63\f\63\16\63\u01e9\13\63\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\3"+
		"9\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3"+
		"B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3"+
		"N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\2\2Y"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o"+
		"9q:s;u<w=y>{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b"+
		"\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d"+
		"\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad\2\u00af"+
		"\2\3\2\"\3\2))\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\5\2\13\r\17\17\"\"\3"+
		"\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJj"+
		"j\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2"+
		"SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4"+
		"\2\\\\||\u0231\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\2y\3\2\2\2\3\u00b1\3\2\2\2\5\u00b4\3\2\2\2\7\u00b6\3\2\2\2\t\u00b9"+
		"\3\2\2\2\13\u00bc\3\2\2\2\r\u00bf\3\2\2\2\17\u00c1\3\2\2\2\21\u00c3\3"+
		"\2\2\2\23\u00c5\3\2\2\2\25\u00c7\3\2\2\2\27\u00c9\3\2\2\2\31\u00cc\3\2"+
		"\2\2\33\u00d9\3\2\2\2\35\u00f2\3\2\2\2\37\u0104\3\2\2\2!\u0118\3\2\2\2"+
		"#\u0128\3\2\2\2%\u013b\3\2\2\2\'\u0140\3\2\2\2)\u014a\3\2\2\2+\u0155\3"+
		"\2\2\2-\u015b\3\2\2\2/\u015f\3\2\2\2\61\u0167\3\2\2\2\63\u016a\3\2\2\2"+
		"\65\u016d\3\2\2\2\67\u0172\3\2\2\29\u017f\3\2\2\2;\u0183\3\2\2\2=\u0188"+
		"\3\2\2\2?\u018e\3\2\2\2A\u0191\3\2\2\2C\u0198\3\2\2\2E\u019a\3\2\2\2G"+
		"\u019d\3\2\2\2I\u019f\3\2\2\2K\u01a2\3\2\2\2M\u01aa\3\2\2\2O\u01ac\3\2"+
		"\2\2Q\u01ae\3\2\2\2S\u01b0\3\2\2\2U\u01b4\3\2\2\2W\u01c0\3\2\2\2Y\u01c5"+
		"\3\2\2\2[\u01ca\3\2\2\2]\u01cf\3\2\2\2_\u01d4\3\2\2\2a\u01d8\3\2\2\2c"+
		"\u01dd\3\2\2\2e\u01e3\3\2\2\2g\u01ea\3\2\2\2i\u01ec\3\2\2\2k\u01f1\3\2"+
		"\2\2m\u01f4\3\2\2\2o\u01f7\3\2\2\2q\u01fa\3\2\2\2s\u01fd\3\2\2\2u\u0200"+
		"\3\2\2\2w\u0203\3\2\2\2y\u0207\3\2\2\2{\u0209\3\2\2\2}\u020b\3\2\2\2\177"+
		"\u020d\3\2\2\2\u0081\u020f\3\2\2\2\u0083\u0211\3\2\2\2\u0085\u0213\3\2"+
		"\2\2\u0087\u0215\3\2\2\2\u0089\u0217\3\2\2\2\u008b\u0219\3\2\2\2\u008d"+
		"\u021b\3\2\2\2\u008f\u021d\3\2\2\2\u0091\u021f\3\2\2\2\u0093\u0221\3\2"+
		"\2\2\u0095\u0223\3\2\2\2\u0097\u0225\3\2\2\2\u0099\u0227\3\2\2\2\u009b"+
		"\u0229\3\2\2\2\u009d\u022b\3\2\2\2\u009f\u022d\3\2\2\2\u00a1\u022f\3\2"+
		"\2\2\u00a3\u0231\3\2\2\2\u00a5\u0233\3\2\2\2\u00a7\u0235\3\2\2\2\u00a9"+
		"\u0237\3\2\2\2\u00ab\u0239\3\2\2\2\u00ad\u023b\3\2\2\2\u00af\u023d\3\2"+
		"\2\2\u00b1\u00b2\7~\2\2\u00b2\u00b3\7~\2\2\u00b3\4\3\2\2\2\u00b4\u00b5"+
		"\7?\2\2\u00b5\6\3\2\2\2\u00b6\u00b7\7?\2\2\u00b7\u00b8\7?\2\2\u00b8\b"+
		"\3\2\2\2\u00b9\u00ba\7#\2\2\u00ba\u00bb\7?\2\2\u00bb\n\3\2\2\2\u00bc\u00bd"+
		"\7>\2\2\u00bd\u00be\7@\2\2\u00be\f\3\2\2\2\u00bf\u00c0\7*\2\2\u00c0\16"+
		"\3\2\2\2\u00c1\u00c2\7.\2\2\u00c2\20\3\2\2\2\u00c3\u00c4\7+\2\2\u00c4"+
		"\22\3\2\2\2\u00c5\u00c6\7-\2\2\u00c6\24\3\2\2\2\u00c7\u00c8\7,\2\2\u00c8"+
		"\26\3\2\2\2\u00c9\u00ca\7\60\2\2\u00ca\30\3\2\2\2\u00cb\u00cd\5{>\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf\u00d7\3\2\2\2\u00d0\u00d4\7\60\2\2\u00d1\u00d3\5{>\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\32\3\2\2\2\u00d9\u00da\7)\2\2\u00da\u00db\5i\65\2"+
		"\u00db\u00dc\7/\2\2\u00dc\u00dd\5k\66\2\u00dd\u00de\7/\2\2\u00de\u00ee"+
		"\5m\67\2\u00df\u00e0\7V\2\2\u00e0\u00e1\5o8\2\u00e1\u00e2\7<\2\2\u00e2"+
		"\u00ec\5q9\2\u00e3\u00e4\7<\2\2\u00e4\u00ea\5s:\2\u00e5\u00e6\5g\64\2"+
		"\u00e6\u00e7\5u;\2\u00e7\u00e8\7<\2\2\u00e8\u00e9\5q9\2\u00e9\u00eb\3"+
		"\2\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec"+
		"\u00e3\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00df\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7)\2\2\u00f1"+
		"\34\3\2\2\2\u00f2\u00f3\5\u0081A\2\u00f3\u00f4\5\u00a5S\2\u00f4\u00f5"+
		"\5\u009fP\2\u00f5\u00f6\5\u009fP\2\u00f6\u00f7\5\u0085C\2\u00f7\u00f8"+
		"\5\u0097L\2\u00f8\u00f9\5\u00a3R\2\u00f9\u00fa\7a\2\2\u00fa\u00fb\5\u00a3"+
		"R\2\u00fb\u00fc\5\u008dG\2\u00fc\u00fd\5\u0095K\2\u00fd\u00fe\5\u0085"+
		"C\2\u00fe\u00ff\5\u00a1Q\2\u00ff\u0100\5\u00a3R\2\u0100\u0101\5}?\2\u0101"+
		"\u0102\5\u0095K\2\u0102\u0103\5\u009bN\2\u0103\36\3\2\2\2\u0104\u0105"+
		"\5\u00a3R\2\u0105\u0106\5\u008dG\2\u0106\u0107\5\u0095K\2\u0107\u0108"+
		"\5\u0085C\2\u0108\u0109\5\u00a1Q\2\u0109\u010a\5\u00a3R\2\u010a\u010b"+
		"\5}?\2\u010b\u010c\5\u0095K\2\u010c\u010d\5\u009bN\2\u010d\u010e\7a\2"+
		"\2\u010e\u010f\5\u00adW\2\u010f\u0110\5\u0085C\2\u0110\u0111\5\u00a1Q"+
		"\2\u0111\u0112\5\u00a3R\2\u0112\u0113\5\u0085C\2\u0113\u0114\5\u009fP"+
		"\2\u0114\u0115\5\u0083B\2\u0115\u0116\5}?\2\u0116\u0117\5\u00adW\2\u0117"+
		" \3\2\2\2\u0118\u0119\5\u00a3R\2\u0119\u011a\5\u008dG\2\u011a\u011b\5"+
		"\u0095K\2\u011b\u011c\5\u0085C\2\u011c\u011d\5\u00a1Q\2\u011d\u011e\5"+
		"\u00a3R\2\u011e\u011f\5}?\2\u011f\u0120\5\u0095K\2\u0120\u0121\5\u009b"+
		"N\2\u0121\u0122\7a\2\2\u0122\u0123\5\u00a3R\2\u0123\u0124\5\u0099M\2\u0124"+
		"\u0125\5\u0083B\2\u0125\u0126\5}?\2\u0126\u0127\5\u00adW\2\u0127\"\3\2"+
		"\2\2\u0128\u0129\5\u00a3R\2\u0129\u012a\5\u008dG\2\u012a\u012b\5\u0095"+
		"K\2\u012b\u012c\5\u0085C\2\u012c\u012d\5\u00a1Q\2\u012d\u012e\5\u00a3"+
		"R\2\u012e\u012f\5}?\2\u012f\u0130\5\u0095K\2\u0130\u0131\5\u009bN\2\u0131"+
		"\u0132\7a\2\2\u0132\u0133\5\u00a3R\2\u0133\u0134\5\u0099M\2\u0134\u0135"+
		"\5\u0095K\2\u0135\u0136\5\u0099M\2\u0136\u0137\5\u009fP\2\u0137\u0138"+
		"\5\u009fP\2\u0138\u0139\5\u0099M\2\u0139\u013a\5\u00a9U\2\u013a$\3\2\2"+
		"\2\u013b\u013c\5\u0093J\2\u013c\u013d\5}?\2\u013d\u013e\5\u00a1Q\2\u013e"+
		"\u013f\5\u00a3R\2\u013f&\3\2\2\2\u0140\u0146\7)\2\2\u0141\u0147\n\2\2"+
		"\2\u0142\u0143\7)\2\2\u0143\u0147\7)\2\2\u0144\u0145\7^\2\2\u0145\u0147"+
		"\7)\2\2\u0146\u0141\3\2\2\2\u0146\u0142\3\2\2\2\u0146\u0144\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0149\7)\2\2\u0149(\3\2\2\2\u014a\u0150\7)\2\2\u014b"+
		"\u014f\n\2\2\2\u014c\u014d\7)\2\2\u014d\u014f\7)\2\2\u014e\u014b\3\2\2"+
		"\2\u014e\u014c\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\7)\2\2\u0154"+
		"*\3\2\2\2\u0155\u0156\7A\2\2\u0156\u0157\7}\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u0159\5e\63\2\u0159\u015a\7\177\2\2\u015a,\3\2\2\2\u015b\u015c\5}?\2"+
		"\u015c\u015d\5\u0097L\2\u015d\u015e\5\u0083B\2\u015e.\3\2\2\2\u015f\u0160"+
		"\5\177@\2\u0160\u0161\5\u0085C\2\u0161\u0162\5\u00a3R\2\u0162\u0163\5"+
		"\u00a9U\2\u0163\u0164\5\u0085C\2\u0164\u0165\5\u0085C\2\u0165\u0166\5"+
		"\u0097L\2\u0166\60\3\2\2\2\u0167\u0168\5\u008dG\2\u0168\u0169\5\u0097"+
		"L\2\u0169\62\3\2\2\2\u016a\u016b\5\u008dG\2\u016b\u016c\5\u00a1Q\2\u016c"+
		"\64\3\2\2\2\u016d\u016e\5\u0093J\2\u016e\u016f\5\u008dG\2\u016f\u0170"+
		"\5\u0091I\2\u0170\u0171\5\u0085C\2\u0171\66\3\2\2\2\u0172\u0173\5\u0097"+
		"L\2\u0173\u0174\5\u0099M\2\u0174\u0176\5\u00a3R\2\u0175\u0177\7\"\2\2"+
		"\u0176\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\5\u0093J\2\u017b\u017c\5\u008d"+
		"G\2\u017c\u017d\5\u0091I\2\u017d\u017e\5\u0085C\2\u017e8\3\2\2\2\u017f"+
		"\u0180\5\u0097L\2\u0180\u0181\5\u0099M\2\u0181\u0182\5\u00a3R\2\u0182"+
		":\3\2\2\2\u0183\u0184\5\u0097L\2\u0184\u0185\5\u00a5S\2\u0185\u0186\5"+
		"\u0093J\2\u0186\u0187\5\u0093J\2\u0187<\3\2\2\2\u0188\u0189\5\u0085C\2"+
		"\u0189\u018a\5\u0095K\2\u018a\u018b\5\u009bN\2\u018b\u018c\5\u00a3R\2"+
		"\u018c\u018d\5\u00adW\2\u018d>\3\2\2\2\u018e\u018f\5\u0099M\2\u018f\u0190"+
		"\5\u009fP\2\u0190@\3\2\2\2\u0191\u0192\5\u009fP\2\u0192\u0193\5\u0085"+
		"C\2\u0193\u0194\5\u0089E\2\u0194\u0195\5\u0085C\2\u0195\u0196\5\u00ab"+
		"V\2\u0196\u0197\5\u009bN\2\u0197B\3\2\2\2\u0198\u0199\7>\2\2\u0199D\3"+
		"\2\2\2\u019a\u019b\7>\2\2\u019b\u019c\7?\2\2\u019cF\3\2\2\2\u019d\u019e"+
		"\7@\2\2\u019eH\3\2\2\2\u019f\u01a0\7@\2\2\u01a0\u01a1\7?\2\2\u01a1J\3"+
		"\2\2\2\u01a2\u01a4\7?\2\2\u01a3\u01a5\7?\2\2\u01a4\u01a3\3\2\2\2\u01a4"+
		"\u01a5\3\2\2\2\u01a5L\3\2\2\2\u01a6\u01a7\7>\2\2\u01a7\u01ab\7@\2\2\u01a8"+
		"\u01a9\7#\2\2\u01a9\u01ab\7?\2\2\u01aa\u01a6\3\2\2\2\u01aa\u01a8\3\2\2"+
		"\2\u01abN\3\2\2\2\u01ac\u01ad\7\61\2\2\u01adP\3\2\2\2\u01ae\u01af\7/\2"+
		"\2\u01afR\3\2\2\2\u01b0\u01b1\5\u0093J\2\u01b1\u01b2\5\u0085C\2\u01b2"+
		"\u01b3\5\u0097L\2\u01b3T\3\2\2\2\u01b4\u01b5\5\u0083B\2\u01b5\u01b6\5"+
		"}?\2\u01b6\u01b7\5\u00adW\2\u01b7\u01b8\5\u00a1Q\2\u01b8\u01b9\5\177@"+
		"\2\u01b9\u01ba\5\u0085C\2\u01ba\u01bb\5\u00a3R\2\u01bb\u01bc\5\u00a9U"+
		"\2\u01bc\u01bd\5\u0085C\2\u01bd\u01be\5\u0085C\2\u01be\u01bf\5\u0097L"+
		"\2\u01bfV\3\2\2\2\u01c0\u01c1\5\u0081A\2\u01c1\u01c2\5}?\2\u01c2\u01c3"+
		"\5\u00a1Q\2\u01c3\u01c4\5\u0085C\2\u01c4X\3\2\2\2\u01c5\u01c6\5\u00a9"+
		"U\2\u01c6\u01c7\5\u008bF\2\u01c7\u01c8\5\u0085C\2\u01c8\u01c9\5\u0097"+
		"L\2\u01c9Z\3\2\2\2\u01ca\u01cb\5\u00a3R\2\u01cb\u01cc\5\u008bF\2\u01cc"+
		"\u01cd\5\u0085C\2\u01cd\u01ce\5\u0097L\2\u01ce\\\3\2\2\2\u01cf\u01d0\5"+
		"\u0085C\2\u01d0\u01d1\5\u0093J\2\u01d1\u01d2\5\u00a1Q\2\u01d2\u01d3\5"+
		"\u0085C\2\u01d3^\3\2\2\2\u01d4\u01d5\5\u0085C\2\u01d5\u01d6\5\u0097L\2"+
		"\u01d6\u01d7\5\u0083B\2\u01d7`\3\2\2\2\u01d8\u01d9\5\u00a3R\2\u01d9\u01da"+
		"\5\u009fP\2\u01da\u01db\5\u00a5S\2\u01db\u01dc\5\u0085C\2\u01dcb\3\2\2"+
		"\2\u01dd\u01de\5\u0087D\2\u01de\u01df\5}?\2\u01df\u01e0\5\u0093J\2\u01e0"+
		"\u01e1\5\u00a1Q\2\u01e1\u01e2\5\u0085C\2\u01e2d\3\2\2\2\u01e3\u01e7\t"+
		"\3\2\2\u01e4\u01e6\t\4\2\2\u01e5\u01e4\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7"+
		"\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8f\3\2\2\2\u01e9\u01e7\3\2\2\2"+
		"\u01ea\u01eb\t\5\2\2\u01ebh\3\2\2\2\u01ec\u01ed\5{>\2\u01ed\u01ee\5{>"+
		"\2\u01ee\u01ef\5{>\2\u01ef\u01f0\5{>\2\u01f0j\3\2\2\2\u01f1\u01f2\5{>"+
		"\2\u01f2\u01f3\5{>\2\u01f3l\3\2\2\2\u01f4\u01f5\5{>\2\u01f5\u01f6\5{>"+
		"\2\u01f6n\3\2\2\2\u01f7\u01f8\5{>\2\u01f8\u01f9\5{>\2\u01f9p\3\2\2\2\u01fa"+
		"\u01fb\5{>\2\u01fb\u01fc\5{>\2\u01fcr\3\2\2\2\u01fd\u01fe\5{>\2\u01fe"+
		"\u01ff\5{>\2\u01fft\3\2\2\2\u0200\u0201\5{>\2\u0201\u0202\5{>\2\u0202"+
		"v\3\2\2\2\u0203\u0204\t\6\2\2\u0204\u0205\3\2\2\2\u0205\u0206\b<\2\2\u0206"+
		"x\3\2\2\2\u0207\u0208\13\2\2\2\u0208z\3\2\2\2\u0209\u020a\t\7\2\2\u020a"+
		"|\3\2\2\2\u020b\u020c\t\b\2\2\u020c~\3\2\2\2\u020d\u020e\t\t\2\2\u020e"+
		"\u0080\3\2\2\2\u020f\u0210\t\n\2\2\u0210\u0082\3\2\2\2\u0211\u0212\t\13"+
		"\2\2\u0212\u0084\3\2\2\2\u0213\u0214\t\f\2\2\u0214\u0086\3\2\2\2\u0215"+
		"\u0216\t\r\2\2\u0216\u0088\3\2\2\2\u0217\u0218\t\16\2\2\u0218\u008a\3"+
		"\2\2\2\u0219\u021a\t\17\2\2\u021a\u008c\3\2\2\2\u021b\u021c\t\20\2\2\u021c"+
		"\u008e\3\2\2\2\u021d\u021e\t\21\2\2\u021e\u0090\3\2\2\2\u021f\u0220\t"+
		"\22\2\2\u0220\u0092\3\2\2\2\u0221\u0222\t\23\2\2\u0222\u0094\3\2\2\2\u0223"+
		"\u0224\t\24\2\2\u0224\u0096\3\2\2\2\u0225\u0226\t\25\2\2\u0226\u0098\3"+
		"\2\2\2\u0227\u0228\t\26\2\2\u0228\u009a\3\2\2\2\u0229\u022a\t\27\2\2\u022a"+
		"\u009c\3\2\2\2\u022b\u022c\t\30\2\2\u022c\u009e\3\2\2\2\u022d\u022e\t"+
		"\31\2\2\u022e\u00a0\3\2\2\2\u022f\u0230\t\32\2\2\u0230\u00a2\3\2\2\2\u0231"+
		"\u0232\t\33\2\2\u0232\u00a4\3\2\2\2\u0233\u0234\t\34\2\2\u0234\u00a6\3"+
		"\2\2\2\u0235\u0236\t\35\2\2\u0236\u00a8\3\2\2\2\u0237\u0238\t\36\2\2\u0238"+
		"\u00aa\3\2\2\2\u0239\u023a\t\37\2\2\u023a\u00ac\3\2\2\2\u023b\u023c\t"+
		" \2\2\u023c\u00ae\3\2\2\2\u023d\u023e\t!\2\2\u023e\u00b0\3\2\2\2\20\2"+
		"\u00ce\u00d4\u00d7\u00ea\u00ec\u00ee\u0146\u014e\u0150\u0178\u01a4\u01aa"+
		"\u01e7\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}