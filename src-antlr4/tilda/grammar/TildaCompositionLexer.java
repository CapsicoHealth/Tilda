// Generated from TildaComposition.g4 by ANTLR 4.5.3
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
public class TildaCompositionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, K_AND=3, K_NOT=4, K_OR=5, IDENTIFIER=6, SPACES=7, UNEXPECTED_CHAR=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "K_AND", "K_NOT", "K_OR", "IDENTIFIER", "SPACES", "UNEXPECTED_CHAR", 
		"DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
		"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "K_AND", "K_NOT", "K_OR", "IDENTIFIER", "SPACES", "UNEXPECTED_CHAR"
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


	public TildaCompositionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TildaComposition.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u009b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\7\3\7\7\7[\n\7\f\7\16\7^\13\7\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\2\2%\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61"+
		"\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2\3\2 \5\2C\\aac|\6\2\62;C\\a"+
		"ac|\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGg"+
		"g\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2"+
		"PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4"+
		"\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\u0080\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3"+
		"I\3\2\2\2\5K\3\2\2\2\7M\3\2\2\2\tQ\3\2\2\2\13U\3\2\2\2\rX\3\2\2\2\17_"+
		"\3\2\2\2\21c\3\2\2\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33"+
		"m\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2!s\3\2\2\2#u\3\2\2\2%w\3\2\2\2\'y\3\2"+
		"\2\2){\3\2\2\2+}\3\2\2\2-\177\3\2\2\2/\u0081\3\2\2\2\61\u0083\3\2\2\2"+
		"\63\u0085\3\2\2\2\65\u0087\3\2\2\2\67\u0089\3\2\2\29\u008b\3\2\2\2;\u008d"+
		"\3\2\2\2=\u008f\3\2\2\2?\u0091\3\2\2\2A\u0093\3\2\2\2C\u0095\3\2\2\2E"+
		"\u0097\3\2\2\2G\u0099\3\2\2\2IJ\7*\2\2J\4\3\2\2\2KL\7+\2\2L\6\3\2\2\2"+
		"MN\5\25\13\2NO\5/\30\2OP\5\33\16\2P\b\3\2\2\2QR\5/\30\2RS\5\61\31\2ST"+
		"\5;\36\2T\n\3\2\2\2UV\5\61\31\2VW\5\67\34\2W\f\3\2\2\2X\\\t\2\2\2Y[\t"+
		"\3\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\16\3\2\2\2^\\\3\2\2"+
		"\2_`\t\4\2\2`a\3\2\2\2ab\b\b\2\2b\20\3\2\2\2cd\13\2\2\2d\22\3\2\2\2ef"+
		"\t\5\2\2f\24\3\2\2\2gh\t\6\2\2h\26\3\2\2\2ij\t\7\2\2j\30\3\2\2\2kl\t\b"+
		"\2\2l\32\3\2\2\2mn\t\t\2\2n\34\3\2\2\2op\t\n\2\2p\36\3\2\2\2qr\t\13\2"+
		"\2r \3\2\2\2st\t\f\2\2t\"\3\2\2\2uv\t\r\2\2v$\3\2\2\2wx\t\16\2\2x&\3\2"+
		"\2\2yz\t\17\2\2z(\3\2\2\2{|\t\20\2\2|*\3\2\2\2}~\t\21\2\2~,\3\2\2\2\177"+
		"\u0080\t\22\2\2\u0080.\3\2\2\2\u0081\u0082\t\23\2\2\u0082\60\3\2\2\2\u0083"+
		"\u0084\t\24\2\2\u0084\62\3\2\2\2\u0085\u0086\t\25\2\2\u0086\64\3\2\2\2"+
		"\u0087\u0088\t\26\2\2\u0088\66\3\2\2\2\u0089\u008a\t\27\2\2\u008a8\3\2"+
		"\2\2\u008b\u008c\t\30\2\2\u008c:\3\2\2\2\u008d\u008e\t\31\2\2\u008e<\3"+
		"\2\2\2\u008f\u0090\t\32\2\2\u0090>\3\2\2\2\u0091\u0092\t\33\2\2\u0092"+
		"@\3\2\2\2\u0093\u0094\t\34\2\2\u0094B\3\2\2\2\u0095\u0096\t\35\2\2\u0096"+
		"D\3\2\2\2\u0097\u0098\t\36\2\2\u0098F\3\2\2\2\u0099\u009a\t\37\2\2\u009a"+
		"H\3\2\2\2\4\2\\\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}