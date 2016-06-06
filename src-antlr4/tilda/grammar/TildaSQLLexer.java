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
		K_ON=24, K_OR=25, K_REGEXP=26, K_LT=27, K_LTE=28, K_GT=29, K_GTE=30, K_EQ=31, 
		K_NEQ=32, K_DIV=33, K_MINUS=34, IDENTIFIER=35, PLUS_MINUS=36, YEAR_LITERAL=37, 
		MONTH_LITERAL=38, DAY_LITERAL=39, HOUR_LITERAL_24=40, MINUTE_LITERAL=41, 
		SECOND_LITERAL=42, HOUR_LITERAL_12=43, QUOTE=44, SPACES=45, UNEXPECTED_CHAR=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "NUMERIC_LITERAL", 
		"TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", "TIMESTAMP_TODAY", 
		"TIMESTAMP_TOMORROW", "LAST", "STRING_LITERAL", "BIND_PARAMETER", "K_AND", 
		"K_BETWEEN", "K_IN", "K_IS", "K_LIKE", "K_NOT", "K_NULL", "K_ON", "K_OR", 
		"K_REGEXP", "K_LT", "K_LTE", "K_GT", "K_GTE", "K_EQ", "K_NEQ", "K_DIV", 
		"K_MINUS", "IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", "MONTH_LITERAL", 
		"DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", 
		"HOUR_LITERAL_12", "QUOTE", "SPACES", "UNEXPECTED_CHAR", "DIGIT", "A", 
		"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
		"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'||'", "','", "'*'", "'.'", null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "'<'", null, "'>'", null, null, null, "'/'", "'-'", 
		null, null, null, null, null, null, null, null, null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "NUMERIC_LITERAL", "TIMESTAMP_LITERAL", 
		"CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", "TIMESTAMP_TODAY", "TIMESTAMP_TOMORROW", 
		"LAST", "STRING_LITERAL", "BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", 
		"K_IS", "K_LIKE", "K_NOT", "K_NULL", "K_ON", "K_OR", "K_REGEXP", "K_LT", 
		"K_LTE", "K_GT", "K_GTE", "K_EQ", "K_NEQ", "K_DIV", "K_MINUS", "IDENTIFIER", 
		"PLUS_MINUS", "YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", 
		"MINUTE_LITERAL", "SECOND_LITERAL", "HOUR_LITERAL_12", "QUOTE", "SPACES", 
		"UNEXPECTED_CHAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u01d5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\6\t\u00a6\n\t\r\t\16\t\u00a7\3\t\3\t\7\t\u00ac\n\t\f\t\16\t\u00af"+
		"\13\t\5\t\u00b1\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u00c4\n\n\5\n\u00c6\n\n\5\n\u00c8\n\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\7\20\u011e\n\20\f\20\16\20\u0121\13\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0131"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u0157\n\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3\37\3 \3 \5 \u016c\n \3!\3!\3!\3!\5!\u0172\n!\3\"\3\"\3#\3#\3$\3$\7"+
		"$\u017a\n$\f$\16$\u017d\13$\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3("+
		"\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3.\3.\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C"+
		"\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\2\2K\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177"+
		"\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091"+
		"\2\u0093\2\3\2\"\3\2))\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\5\2\13\r\17\17"+
		"\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4"+
		"\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRr"+
		"r\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2"+
		"[[{{\4\2\\\\||\u01c6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\3\u0095\3\2\2\2\5\u0097\3\2\2\2\7\u0099\3\2\2\2\t\u009b\3\2\2\2\13"+
		"\u009e\3\2\2\2\r\u00a0\3\2\2\2\17\u00a2\3\2\2\2\21\u00a5\3\2\2\2\23\u00b2"+
		"\3\2\2\2\25\u00cb\3\2\2\2\27\u00dd\3\2\2\2\31\u00f1\3\2\2\2\33\u0101\3"+
		"\2\2\2\35\u0114\3\2\2\2\37\u0119\3\2\2\2!\u0124\3\2\2\2#\u0130\3\2\2\2"+
		"%\u0132\3\2\2\2\'\u013a\3\2\2\2)\u013d\3\2\2\2+\u0140\3\2\2\2-\u0145\3"+
		"\2\2\2/\u0149\3\2\2\2\61\u014e\3\2\2\2\63\u0156\3\2\2\2\65\u0158\3\2\2"+
		"\2\67\u015f\3\2\2\29\u0161\3\2\2\2;\u0164\3\2\2\2=\u0166\3\2\2\2?\u0169"+
		"\3\2\2\2A\u0171\3\2\2\2C\u0173\3\2\2\2E\u0175\3\2\2\2G\u0177\3\2\2\2I"+
		"\u017e\3\2\2\2K\u0180\3\2\2\2M\u0185\3\2\2\2O\u0188\3\2\2\2Q\u018b\3\2"+
		"\2\2S\u018e\3\2\2\2U\u0191\3\2\2\2W\u0194\3\2\2\2Y\u0197\3\2\2\2[\u0199"+
		"\3\2\2\2]\u019d\3\2\2\2_\u019f\3\2\2\2a\u01a1\3\2\2\2c\u01a3\3\2\2\2e"+
		"\u01a5\3\2\2\2g\u01a7\3\2\2\2i\u01a9\3\2\2\2k\u01ab\3\2\2\2m\u01ad\3\2"+
		"\2\2o\u01af\3\2\2\2q\u01b1\3\2\2\2s\u01b3\3\2\2\2u\u01b5\3\2\2\2w\u01b7"+
		"\3\2\2\2y\u01b9\3\2\2\2{\u01bb\3\2\2\2}\u01bd\3\2\2\2\177\u01bf\3\2\2"+
		"\2\u0081\u01c1\3\2\2\2\u0083\u01c3\3\2\2\2\u0085\u01c5\3\2\2\2\u0087\u01c7"+
		"\3\2\2\2\u0089\u01c9\3\2\2\2\u008b\u01cb\3\2\2\2\u008d\u01cd\3\2\2\2\u008f"+
		"\u01cf\3\2\2\2\u0091\u01d1\3\2\2\2\u0093\u01d3\3\2\2\2\u0095\u0096\7*"+
		"\2\2\u0096\4\3\2\2\2\u0097\u0098\7+\2\2\u0098\6\3\2\2\2\u0099\u009a\7"+
		"-\2\2\u009a\b\3\2\2\2\u009b\u009c\7~\2\2\u009c\u009d\7~\2\2\u009d\n\3"+
		"\2\2\2\u009e\u009f\7.\2\2\u009f\f\3\2\2\2\u00a0\u00a1\7,\2\2\u00a1\16"+
		"\3\2\2\2\u00a2\u00a3\7\60\2\2\u00a3\20\3\2\2\2\u00a4\u00a6\5_\60\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00b0\3\2\2\2\u00a9\u00ad\7\60\2\2\u00aa\u00ac\5_\60\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00a9\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\22\3\2\2\2\u00b2\u00b3\7)\2\2\u00b3\u00b4\5K&\2\u00b4"+
		"\u00b5\7/\2\2\u00b5\u00b6\5M\'\2\u00b6\u00b7\7/\2\2\u00b7\u00c7\5O(\2"+
		"\u00b8\u00b9\7V\2\2\u00b9\u00ba\5Q)\2\u00ba\u00bb\7<\2\2\u00bb\u00c5\5"+
		"S*\2\u00bc\u00bd\7<\2\2\u00bd\u00c3\5U+\2\u00be\u00bf\5I%\2\u00bf\u00c0"+
		"\5W,\2\u00c0\u00c1\7<\2\2\u00c1\u00c2\5S*\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00be\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00bc\3\2"+
		"\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00b8\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7)\2\2\u00ca\24\3\2\2\2"+
		"\u00cb\u00cc\5e\63\2\u00cc\u00cd\5\u0089E\2\u00cd\u00ce\5\u0083B\2\u00ce"+
		"\u00cf\5\u0083B\2\u00cf\u00d0\5i\65\2\u00d0\u00d1\5{>\2\u00d1\u00d2\5"+
		"\u0087D\2\u00d2\u00d3\7a\2\2\u00d3\u00d4\5\u0087D\2\u00d4\u00d5\5q9\2"+
		"\u00d5\u00d6\5y=\2\u00d6\u00d7\5i\65\2\u00d7\u00d8\5\u0085C\2\u00d8\u00d9"+
		"\5\u0087D\2\u00d9\u00da\5a\61\2\u00da\u00db\5y=\2\u00db\u00dc\5\177@\2"+
		"\u00dc\26\3\2\2\2\u00dd\u00de\5\u0087D\2\u00de\u00df\5q9\2\u00df\u00e0"+
		"\5y=\2\u00e0\u00e1\5i\65\2\u00e1\u00e2\5\u0085C\2\u00e2\u00e3\5\u0087"+
		"D\2\u00e3\u00e4\5a\61\2\u00e4\u00e5\5y=\2\u00e5\u00e6\5\177@\2\u00e6\u00e7"+
		"\7a\2\2\u00e7\u00e8\5\u0091I\2\u00e8\u00e9\5i\65\2\u00e9\u00ea\5\u0085"+
		"C\2\u00ea\u00eb\5\u0087D\2\u00eb\u00ec\5i\65\2\u00ec\u00ed\5\u0083B\2"+
		"\u00ed\u00ee\5g\64\2\u00ee\u00ef\5a\61\2\u00ef\u00f0\5\u0091I\2\u00f0"+
		"\30\3\2\2\2\u00f1\u00f2\5\u0087D\2\u00f2\u00f3\5q9\2\u00f3\u00f4\5y=\2"+
		"\u00f4\u00f5\5i\65\2\u00f5\u00f6\5\u0085C\2\u00f6\u00f7\5\u0087D\2\u00f7"+
		"\u00f8\5a\61\2\u00f8\u00f9\5y=\2\u00f9\u00fa\5\177@\2\u00fa\u00fb\7a\2"+
		"\2\u00fb\u00fc\5\u0087D\2\u00fc\u00fd\5}?\2\u00fd\u00fe\5g\64\2\u00fe"+
		"\u00ff\5a\61\2\u00ff\u0100\5\u0091I\2\u0100\32\3\2\2\2\u0101\u0102\5\u0087"+
		"D\2\u0102\u0103\5q9\2\u0103\u0104\5y=\2\u0104\u0105\5i\65\2\u0105\u0106"+
		"\5\u0085C\2\u0106\u0107\5\u0087D\2\u0107\u0108\5a\61\2\u0108\u0109\5y"+
		"=\2\u0109\u010a\5\177@\2\u010a\u010b\7a\2\2\u010b\u010c\5\u0087D\2\u010c"+
		"\u010d\5}?\2\u010d\u010e\5y=\2\u010e\u010f\5}?\2\u010f\u0110\5\u0083B"+
		"\2\u0110\u0111\5\u0083B\2\u0111\u0112\5}?\2\u0112\u0113\5\u008dG\2\u0113"+
		"\34\3\2\2\2\u0114\u0115\5w<\2\u0115\u0116\5a\61\2\u0116\u0117\5\u0085"+
		"C\2\u0117\u0118\5\u0087D\2\u0118\36\3\2\2\2\u0119\u011f\7)\2\2\u011a\u011e"+
		"\n\2\2\2\u011b\u011c\7)\2\2\u011c\u011e\7)\2\2\u011d\u011a\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\7)\2\2\u0123"+
		" \3\2\2\2\u0124\u0125\7A\2\2\u0125\u0126\7}\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0128\5G$\2\u0128\u0129\7\177\2\2\u0129\"\3\2\2\2\u012a\u012b\5a\61\2"+
		"\u012b\u012c\5{>\2\u012c\u012d\5g\64\2\u012d\u0131\3\2\2\2\u012e\u012f"+
		"\7(\2\2\u012f\u0131\7(\2\2\u0130\u012a\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"$\3\2\2\2\u0132\u0133\5c\62\2\u0133\u0134\5i\65\2\u0134\u0135\5\u0087"+
		"D\2\u0135\u0136\5\u008dG\2\u0136\u0137\5i\65\2\u0137\u0138\5i\65\2\u0138"+
		"\u0139\5{>\2\u0139&\3\2\2\2\u013a\u013b\5q9\2\u013b\u013c\5{>\2\u013c"+
		"(\3\2\2\2\u013d\u013e\5q9\2\u013e\u013f\5\u0085C\2\u013f*\3\2\2\2\u0140"+
		"\u0141\5w<\2\u0141\u0142\5q9\2\u0142\u0143\5u;\2\u0143\u0144\5i\65\2\u0144"+
		",\3\2\2\2\u0145\u0146\5{>\2\u0146\u0147\5}?\2\u0147\u0148\5\u0087D\2\u0148"+
		".\3\2\2\2\u0149\u014a\5{>\2\u014a\u014b\5\u0089E\2\u014b\u014c\5w<\2\u014c"+
		"\u014d\5w<\2\u014d\60\3\2\2\2\u014e\u014f\5}?\2\u014f\u0150\5{>\2\u0150"+
		"\62\3\2\2\2\u0151\u0152\5}?\2\u0152\u0153\5\u0083B\2\u0153\u0157\3\2\2"+
		"\2\u0154\u0155\7~\2\2\u0155\u0157\7~\2\2\u0156\u0151\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0157\64\3\2\2\2\u0158\u0159\5\u0083B\2\u0159\u015a\5i\65\2\u015a"+
		"\u015b\5m\67\2\u015b\u015c\5i\65\2\u015c\u015d\5\u008fH\2\u015d\u015e"+
		"\5\177@\2\u015e\66\3\2\2\2\u015f\u0160\7>\2\2\u01608\3\2\2\2\u0161\u0162"+
		"\7>\2\2\u0162\u0163\7?\2\2\u0163:\3\2\2\2\u0164\u0165\7@\2\2\u0165<\3"+
		"\2\2\2\u0166\u0167\7@\2\2\u0167\u0168\7?\2\2\u0168>\3\2\2\2\u0169\u016b"+
		"\7?\2\2\u016a\u016c\7?\2\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"@\3\2\2\2\u016d\u016e\7>\2\2\u016e\u0172\7@\2\2\u016f\u0170\7#\2\2\u0170"+
		"\u0172\7?\2\2\u0171\u016d\3\2\2\2\u0171\u016f\3\2\2\2\u0172B\3\2\2\2\u0173"+
		"\u0174\7\61\2\2\u0174D\3\2\2\2\u0175\u0176\7/\2\2\u0176F\3\2\2\2\u0177"+
		"\u017b\t\3\2\2\u0178\u017a\t\4\2\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2"+
		"\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017cH\3\2\2\2\u017d\u017b"+
		"\3\2\2\2\u017e\u017f\t\5\2\2\u017fJ\3\2\2\2\u0180\u0181\5_\60\2\u0181"+
		"\u0182\5_\60\2\u0182\u0183\5_\60\2\u0183\u0184\5_\60\2\u0184L\3\2\2\2"+
		"\u0185\u0186\5_\60\2\u0186\u0187\5_\60\2\u0187N\3\2\2\2\u0188\u0189\5"+
		"_\60\2\u0189\u018a\5_\60\2\u018aP\3\2\2\2\u018b\u018c\5_\60\2\u018c\u018d"+
		"\5_\60\2\u018dR\3\2\2\2\u018e\u018f\5_\60\2\u018f\u0190\5_\60\2\u0190"+
		"T\3\2\2\2\u0191\u0192\5_\60\2\u0192\u0193\5_\60\2\u0193V\3\2\2\2\u0194"+
		"\u0195\5_\60\2\u0195\u0196\5_\60\2\u0196X\3\2\2\2\u0197\u0198\7)\2\2\u0198"+
		"Z\3\2\2\2\u0199\u019a\t\6\2\2\u019a\u019b\3\2\2\2\u019b\u019c\b.\2\2\u019c"+
		"\\\3\2\2\2\u019d\u019e\13\2\2\2\u019e^\3\2\2\2\u019f\u01a0\t\7\2\2\u01a0"+
		"`\3\2\2\2\u01a1\u01a2\t\b\2\2\u01a2b\3\2\2\2\u01a3\u01a4\t\t\2\2\u01a4"+
		"d\3\2\2\2\u01a5\u01a6\t\n\2\2\u01a6f\3\2\2\2\u01a7\u01a8\t\13\2\2\u01a8"+
		"h\3\2\2\2\u01a9\u01aa\t\f\2\2\u01aaj\3\2\2\2\u01ab\u01ac\t\r\2\2\u01ac"+
		"l\3\2\2\2\u01ad\u01ae\t\16\2\2\u01aen\3\2\2\2\u01af\u01b0\t\17\2\2\u01b0"+
		"p\3\2\2\2\u01b1\u01b2\t\20\2\2\u01b2r\3\2\2\2\u01b3\u01b4\t\21\2\2\u01b4"+
		"t\3\2\2\2\u01b5\u01b6\t\22\2\2\u01b6v\3\2\2\2\u01b7\u01b8\t\23\2\2\u01b8"+
		"x\3\2\2\2\u01b9\u01ba\t\24\2\2\u01baz\3\2\2\2\u01bb\u01bc\t\25\2\2\u01bc"+
		"|\3\2\2\2\u01bd\u01be\t\26\2\2\u01be~\3\2\2\2\u01bf\u01c0\t\27\2\2\u01c0"+
		"\u0080\3\2\2\2\u01c1\u01c2\t\30\2\2\u01c2\u0082\3\2\2\2\u01c3\u01c4\t"+
		"\31\2\2\u01c4\u0084\3\2\2\2\u01c5\u01c6\t\32\2\2\u01c6\u0086\3\2\2\2\u01c7"+
		"\u01c8\t\33\2\2\u01c8\u0088\3\2\2\2\u01c9\u01ca\t\34\2\2\u01ca\u008a\3"+
		"\2\2\2\u01cb\u01cc\t\35\2\2\u01cc\u008c\3\2\2\2\u01cd\u01ce\t\36\2\2\u01ce"+
		"\u008e\3\2\2\2\u01cf\u01d0\t\37\2\2\u01d0\u0090\3\2\2\2\u01d1\u01d2\t"+
		" \2\2\u01d2\u0092\3\2\2\2\u01d3\u01d4\t!\2\2\u01d4\u0094\3\2\2\2\20\2"+
		"\u00a7\u00ad\u00b0\u00c3\u00c5\u00c7\u011d\u011f\u0130\u0156\u016b\u0171"+
		"\u017b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}