// Generated from TildaSQL.g4 by ANTLR 4.5.3
package tilda.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TildaSQLParser extends Parser {
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
	public static final int
		RULE_main = 0, RULE_expr = 1, RULE_unary_operator = 2, RULE_func_name = 3, 
		RULE_arithmetic_op_add = 4, RULE_arithmetic_op_mul = 5, RULE_isnull_op = 6, 
		RULE_between_op = 7, RULE_literal = 8, RULE_boolean_literal = 9, RULE_numeric_literal = 10, 
		RULE_timestamp_literal = 11, RULE_string_literal = 12, RULE_bind_parameter = 13, 
		RULE_column = 14;
	public static final String[] ruleNames = {
		"main", "expr", "unary_operator", "func_name", "arithmetic_op_add", "arithmetic_op_mul", 
		"isnull_op", "between_op", "literal", "boolean_literal", "numeric_literal", 
		"timestamp_literal", "string_literal", "bind_parameter", "column"
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

	@Override
	public String getGrammarFileName() { return "TildaSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TildaSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TildaSQLParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitMain(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			expr(0);
			setState(31);
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

	public static class ExprContext extends ParserRuleContext {
		public Func_nameContext func;
		public ExprContext case_when;
		public ExprContext case_then;
		public ExprContext case_else;
		public Token concat;
		public Token comparators1;
		public Token comparators2;
		public Token like;
		public Between_opContext between;
		public Isnull_opContext isnull;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public TerminalNode K_CASE() { return getToken(TildaSQLParser.K_CASE, 0); }
		public TerminalNode K_END() { return getToken(TildaSQLParser.K_END, 0); }
		public List<TerminalNode> K_WHEN() { return getTokens(TildaSQLParser.K_WHEN); }
		public TerminalNode K_WHEN(int i) {
			return getToken(TildaSQLParser.K_WHEN, i);
		}
		public List<TerminalNode> K_THEN() { return getTokens(TildaSQLParser.K_THEN); }
		public TerminalNode K_THEN(int i) {
			return getToken(TildaSQLParser.K_THEN, i);
		}
		public TerminalNode K_ELSE() { return getToken(TildaSQLParser.K_ELSE, 0); }
		public Arithmetic_op_mulContext arithmetic_op_mul() {
			return getRuleContext(Arithmetic_op_mulContext.class,0);
		}
		public Arithmetic_op_addContext arithmetic_op_add() {
			return getRuleContext(Arithmetic_op_addContext.class,0);
		}
		public TerminalNode K_NOT_LIKE() { return getToken(TildaSQLParser.K_NOT_LIKE, 0); }
		public TerminalNode K_LIKE() { return getToken(TildaSQLParser.K_LIKE, 0); }
		public TerminalNode K_AND() { return getToken(TildaSQLParser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQLParser.K_OR, 0); }
		public Between_opContext between_op() {
			return getRuleContext(Between_opContext.class,0);
		}
		public Isnull_opContext isnull_op() {
			return getRuleContext(Isnull_opContext.class,0);
		}
		public TerminalNode K_IN() { return getToken(TildaSQLParser.K_IN, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
			case TIMESTAMP_LITERAL:
			case CURRENT_TIMESTAMP:
			case TIMESTAMP_YESTERDAY:
			case TIMESTAMP_TODAY:
			case TIMESTAMP_TOMORROW:
			case STRING_LITERAL:
			case BIND_PARAMETER:
			case K_TRUE:
			case K_FALSE:
				{
				setState(34);
				literal();
				}
				break;
			case IDENTIFIER:
				{
				setState(35);
				column();
				}
				break;
			case T__8:
			case K_NOT:
			case K_MINUS:
				{
				setState(36);
				unary_operator();
				setState(37);
				expr(15);
				}
				break;
			case K_LEN:
			case K_DAYS_BETWEEN:
				{
				setState(39);
				((ExprContext)_localctx).func = func_name();
				setState(40);
				match(T__5);
				setState(49);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << NUMERIC_LITERAL) | (1L << TIMESTAMP_LITERAL) | (1L << CURRENT_TIMESTAMP) | (1L << TIMESTAMP_YESTERDAY) | (1L << TIMESTAMP_TODAY) | (1L << TIMESTAMP_TOMORROW) | (1L << STRING_LITERAL) | (1L << BIND_PARAMETER) | (1L << K_NOT) | (1L << K_MINUS) | (1L << K_LEN) | (1L << K_DAYS_BETWEEN) | (1L << K_CASE) | (1L << K_TRUE) | (1L << K_FALSE) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(41);
					expr(0);
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(42);
						match(T__6);
						setState(43);
						expr(0);
						}
						}
						setState(48);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(51);
				match(T__7);
				}
				break;
			case T__5:
				{
				setState(53);
				match(T__5);
				setState(54);
				expr(0);
				setState(55);
				match(T__7);
				}
				break;
			case K_CASE:
				{
				setState(57);
				match(K_CASE);
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(58);
					match(K_WHEN);
					setState(59);
					((ExprContext)_localctx).case_when = expr(0);
					setState(60);
					match(K_THEN);
					setState(61);
					((ExprContext)_localctx).case_then = expr(0);
					}
					}
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(69);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(67);
					match(K_ELSE);
					setState(68);
					((ExprContext)_localctx).case_else = expr(0);
					}
				}

				setState(71);
				match(K_END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(125);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(76);
						((ExprContext)_localctx).concat = match(T__0);
						setState(77);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(79);
						arithmetic_op_mul();
						setState(80);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(83);
						arithmetic_op_add();
						setState(84);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(87);
						((ExprContext)_localctx).comparators1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_LT) | (1L << K_LTE) | (1L << K_GT) | (1L << K_GTE))) != 0)) ) {
							((ExprContext)_localctx).comparators1 = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(88);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(90);
						((ExprContext)_localctx).comparators2 = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
							((ExprContext)_localctx).comparators2 = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(91);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(93);
						((ExprContext)_localctx).like = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==K_LIKE || _la==K_NOT_LIKE) ) {
							((ExprContext)_localctx).like = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(94);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(96);
						match(K_AND);
						setState(97);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(99);
						match(K_OR);
						setState(100);
						expr(8);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(102);
						((ExprContext)_localctx).between = between_op();
						setState(103);
						expr(0);
						setState(104);
						match(K_AND);
						setState(105);
						expr(4);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(108);
						((ExprContext)_localctx).isnull = isnull_op();
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(111);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(110);
							match(K_NOT);
							}
						}

						setState(113);
						match(K_IN);
						setState(114);
						match(T__5);
						setState(115);
						expr(0);
						setState(120);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__6) {
							{
							{
							setState(116);
							match(T__6);
							setState(117);
							expr(0);
							}
							}
							setState(122);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(123);
						match(T__7);
						}
						break;
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << K_NOT) | (1L << K_MINUS))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class Func_nameContext extends ParserRuleContext {
		public TerminalNode K_LEN() { return getToken(TildaSQLParser.K_LEN, 0); }
		public TerminalNode K_DAYS_BETWEEN() { return getToken(TildaSQLParser.K_DAYS_BETWEEN, 0); }
		public Func_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterFunc_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitFunc_name(this);
		}
	}

	public final Func_nameContext func_name() throws RecognitionException {
		Func_nameContext _localctx = new Func_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !(_la==K_LEN || _la==K_DAYS_BETWEEN) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class Arithmetic_op_addContext extends ParserRuleContext {
		public TerminalNode K_MINUS() { return getToken(TildaSQLParser.K_MINUS, 0); }
		public Arithmetic_op_addContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_op_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArithmetic_op_add(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArithmetic_op_add(this);
		}
	}

	public final Arithmetic_op_addContext arithmetic_op_add() throws RecognitionException {
		Arithmetic_op_addContext _localctx = new Arithmetic_op_addContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arithmetic_op_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==K_MINUS) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class Arithmetic_op_mulContext extends ParserRuleContext {
		public TerminalNode K_DIV() { return getToken(TildaSQLParser.K_DIV, 0); }
		public Arithmetic_op_mulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_op_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArithmetic_op_mul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArithmetic_op_mul(this);
		}
	}

	public final Arithmetic_op_mulContext arithmetic_op_mul() throws RecognitionException {
		Arithmetic_op_mulContext _localctx = new Arithmetic_op_mulContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arithmetic_op_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==K_DIV) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class Isnull_opContext extends ParserRuleContext {
		public TerminalNode K_IS() { return getToken(TildaSQLParser.K_IS, 0); }
		public TerminalNode K_NULL() { return getToken(TildaSQLParser.K_NULL, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQLParser.K_OR, 0); }
		public TerminalNode K_EMPTY() { return getToken(TildaSQLParser.K_EMPTY, 0); }
		public Isnull_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isnull_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterIsnull_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitIsnull_op(this);
		}
	}

	public final Isnull_opContext isnull_op() throws RecognitionException {
		Isnull_opContext _localctx = new Isnull_opContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_isnull_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(K_IS);
			setState(140);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(139);
				match(K_NOT);
				}
			}

			setState(142);
			match(K_NULL);
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(143);
				match(K_OR);
				setState(144);
				match(K_EMPTY);
				}
				break;
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

	public static class Between_opContext extends ParserRuleContext {
		public TerminalNode K_BETWEEN() { return getToken(TildaSQLParser.K_BETWEEN, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public Between_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBetween_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBetween_op(this);
		}
	}

	public final Between_opContext between_op() throws RecognitionException {
		Between_opContext _localctx = new Between_opContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_between_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(147);
				match(K_NOT);
				}
			}

			setState(150);
			match(K_BETWEEN);
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueBindParamContext extends LiteralContext {
		public Bind_parameterContext bind_parameter() {
			return getRuleContext(Bind_parameterContext.class,0);
		}
		public ValueBindParamContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueBindParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueBindParam(this);
		}
	}
	public static class ValueBooleanLiteralContext extends LiteralContext {
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public ValueBooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueBooleanLiteral(this);
		}
	}
	public static class ValueStringLiteralContext extends LiteralContext {
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public ValueStringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueStringLiteral(this);
		}
	}
	public static class ValueNumericLiteralContext extends LiteralContext {
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public ValueNumericLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueNumericLiteral(this);
		}
	}
	public static class ValueTimestampLiteralContext extends LiteralContext {
		public Timestamp_literalContext timestamp_literal() {
			return getRuleContext(Timestamp_literalContext.class,0);
		}
		public ValueTimestampLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueTimestampLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueTimestampLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_literal);
		try {
			setState(157);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				_localctx = new ValueNumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				numeric_literal();
				}
				break;
			case K_TRUE:
			case K_FALSE:
				_localctx = new ValueBooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				boolean_literal();
				}
				break;
			case TIMESTAMP_LITERAL:
			case CURRENT_TIMESTAMP:
			case TIMESTAMP_YESTERDAY:
			case TIMESTAMP_TODAY:
			case TIMESTAMP_TOMORROW:
				_localctx = new ValueTimestampLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				timestamp_literal();
				}
				break;
			case STRING_LITERAL:
				_localctx = new ValueStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				string_literal();
				}
				break;
			case BIND_PARAMETER:
				_localctx = new ValueBindParamContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				bind_parameter();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode K_TRUE() { return getToken(TildaSQLParser.K_TRUE, 0); }
		public TerminalNode K_FALSE() { return getToken(TildaSQLParser.K_FALSE, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBoolean_literal(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !(_la==K_TRUE || _la==K_FALSE) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class Numeric_literalContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(TildaSQLParser.NUMERIC_LITERAL, 0); }
		public Numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterNumeric_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitNumeric_literal(this);
		}
	}

	public final Numeric_literalContext numeric_literal() throws RecognitionException {
		Numeric_literalContext _localctx = new Numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(NUMERIC_LITERAL);
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

	public static class Timestamp_literalContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP_LITERAL() { return getToken(TildaSQLParser.TIMESTAMP_LITERAL, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(TildaSQLParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode TIMESTAMP_YESTERDAY() { return getToken(TildaSQLParser.TIMESTAMP_YESTERDAY, 0); }
		public TerminalNode LAST() { return getToken(TildaSQLParser.LAST, 0); }
		public TerminalNode TIMESTAMP_TODAY() { return getToken(TildaSQLParser.TIMESTAMP_TODAY, 0); }
		public TerminalNode TIMESTAMP_TOMORROW() { return getToken(TildaSQLParser.TIMESTAMP_TOMORROW, 0); }
		public Timestamp_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestamp_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterTimestamp_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitTimestamp_literal(this);
		}
	}

	public final Timestamp_literalContext timestamp_literal() throws RecognitionException {
		Timestamp_literalContext _localctx = new Timestamp_literalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_timestamp_literal);
		try {
			setState(177);
			switch (_input.LA(1)) {
			case TIMESTAMP_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(TIMESTAMP_LITERAL);
				}
				break;
			case CURRENT_TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(CURRENT_TIMESTAMP);
				}
				break;
			case TIMESTAMP_YESTERDAY:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(TIMESTAMP_YESTERDAY);
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(166);
					match(LAST);
					}
					break;
				}
				}
				break;
			case TIMESTAMP_TODAY:
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				match(TIMESTAMP_TODAY);
				setState(171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(170);
					match(LAST);
					}
					break;
				}
				}
				break;
			case TIMESTAMP_TOMORROW:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				match(TIMESTAMP_TOMORROW);
				setState(175);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(174);
					match(LAST);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class String_literalContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(TildaSQLParser.STRING_LITERAL, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitString_literal(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(STRING_LITERAL);
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

	public static class Bind_parameterContext extends ParserRuleContext {
		public TerminalNode BIND_PARAMETER() { return getToken(TildaSQLParser.BIND_PARAMETER, 0); }
		public Bind_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bind_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBind_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBind_parameter(this);
		}
	}

	public final Bind_parameterContext bind_parameter() throws RecognitionException {
		Bind_parameterContext _localctx = new Bind_parameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_bind_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(BIND_PARAMETER);
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

	public static class ColumnContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(TildaSQLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(TildaSQLParser.IDENTIFIER, i);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitColumn(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(183);
				match(IDENTIFIER);
				setState(184);
				match(T__10);
				}
				break;
			}
			setState(187);
			match(IDENTIFIER);
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
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\u00c0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\5\3\64"+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3B\n\3\r\3\16\3"+
		"C\3\3\3\3\5\3H\n\3\3\3\3\3\5\3L\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3r\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3y\n\3\f\3\16\3|\13\3\3\3\3\3\7\3\u0080\n\3\f\3\16\3\u0083\13\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\5\b\u008f\n\b\3\b\3\b\3\b\5\b\u0094"+
		"\n\b\3\t\5\t\u0097\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u00a0\n\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00aa\n\r\3\r\3\r\5\r\u00ae\n\r\3\r"+
		"\3\r\5\r\u00b2\n\r\5\r\u00b4\n\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u00bc"+
		"\n\20\3\20\3\20\3\20\2\3\4\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2"+
		"\n\3\2\"%\3\2\4\7\3\2\33\34\5\2\13\13\35\35))\3\2*+\4\2\13\13))\4\2\f"+
		"\f((\3\2\61\62\u00d5\2 \3\2\2\2\4K\3\2\2\2\6\u0084\3\2\2\2\b\u0086\3\2"+
		"\2\2\n\u0088\3\2\2\2\f\u008a\3\2\2\2\16\u008c\3\2\2\2\20\u0096\3\2\2\2"+
		"\22\u009f\3\2\2\2\24\u00a1\3\2\2\2\26\u00a3\3\2\2\2\30\u00b3\3\2\2\2\32"+
		"\u00b5\3\2\2\2\34\u00b7\3\2\2\2\36\u00bb\3\2\2\2 !\5\4\3\2!\"\7\2\2\3"+
		"\"\3\3\2\2\2#$\b\3\1\2$L\5\22\n\2%L\5\36\20\2&\'\5\6\4\2\'(\5\4\3\21("+
		"L\3\2\2\2)*\5\b\5\2*\63\7\b\2\2+\60\5\4\3\2,-\7\t\2\2-/\5\4\3\2.,\3\2"+
		"\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2"+
		"\63+\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\n\2\2\66L\3\2\2\2\67"+
		"8\7\b\2\289\5\4\3\29:\7\n\2\2:L\3\2\2\2;A\7,\2\2<=\7-\2\2=>\5\4\3\2>?"+
		"\7.\2\2?@\5\4\3\2@B\3\2\2\2A<\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG"+
		"\3\2\2\2EF\7/\2\2FH\5\4\3\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\60\2\2J"+
		"L\3\2\2\2K#\3\2\2\2K%\3\2\2\2K&\3\2\2\2K)\3\2\2\2K\67\3\2\2\2K;\3\2\2"+
		"\2L\u0081\3\2\2\2MN\f\20\2\2NO\7\3\2\2O\u0080\5\4\3\21PQ\f\17\2\2QR\5"+
		"\f\7\2RS\5\4\3\20S\u0080\3\2\2\2TU\f\16\2\2UV\5\n\6\2VW\5\4\3\17W\u0080"+
		"\3\2\2\2XY\f\r\2\2YZ\t\2\2\2Z\u0080\5\4\3\16[\\\f\f\2\2\\]\t\3\2\2]\u0080"+
		"\5\4\3\r^_\f\13\2\2_`\t\4\2\2`\u0080\5\4\3\fab\f\n\2\2bc\7\27\2\2c\u0080"+
		"\5\4\3\13de\f\t\2\2ef\7 \2\2f\u0080\5\4\3\ngh\f\5\2\2hi\5\20\t\2ij\5\4"+
		"\3\2jk\7\27\2\2kl\5\4\3\6l\u0080\3\2\2\2mn\f\6\2\2n\u0080\5\16\b\2oq\f"+
		"\4\2\2pr\7\35\2\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\31\2\2tu\7\b\2\2u"+
		"z\5\4\3\2vw\7\t\2\2wy\5\4\3\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{}\3\2\2\2|z\3\2\2\2}~\7\n\2\2~\u0080\3\2\2\2\177M\3\2\2\2\177P\3\2\2"+
		"\2\177T\3\2\2\2\177X\3\2\2\2\177[\3\2\2\2\177^\3\2\2\2\177a\3\2\2\2\177"+
		"d\3\2\2\2\177g\3\2\2\2\177m\3\2\2\2\177o\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\5\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0085\t\5\2\2\u0085\7\3\2\2\2\u0086\u0087\t\6\2\2\u0087\t\3\2\2\2\u0088"+
		"\u0089\t\7\2\2\u0089\13\3\2\2\2\u008a\u008b\t\b\2\2\u008b\r\3\2\2\2\u008c"+
		"\u008e\7\32\2\2\u008d\u008f\7\35\2\2\u008e\u008d\3\2\2\2\u008e\u008f\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\7\36\2\2\u0091\u0092\7 \2\2\u0092"+
		"\u0094\7\37\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\17\3\2\2"+
		"\2\u0095\u0097\7\35\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\7\30\2\2\u0099\21\3\2\2\2\u009a\u00a0\5\26"+
		"\f\2\u009b\u00a0\5\24\13\2\u009c\u00a0\5\30\r\2\u009d\u00a0\5\32\16\2"+
		"\u009e\u00a0\5\34\17\2\u009f\u009a\3\2\2\2\u009f\u009b\3\2\2\2\u009f\u009c"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\23\3\2\2\2\u00a1"+
		"\u00a2\t\t\2\2\u00a2\25\3\2\2\2\u00a3\u00a4\7\16\2\2\u00a4\27\3\2\2\2"+
		"\u00a5\u00b4\7\17\2\2\u00a6\u00b4\7\20\2\2\u00a7\u00a9\7\21\2\2\u00a8"+
		"\u00aa\7\24\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00b4\3"+
		"\2\2\2\u00ab\u00ad\7\22\2\2\u00ac\u00ae\7\24\2\2\u00ad\u00ac\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b4\3\2\2\2\u00af\u00b1\7\23\2\2\u00b0\u00b2\7"+
		"\24\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00a5\3\2\2\2\u00b3\u00a6\3\2\2\2\u00b3\u00a7\3\2\2\2\u00b3\u00ab\3\2"+
		"\2\2\u00b3\u00af\3\2\2\2\u00b4\31\3\2\2\2\u00b5\u00b6\7\25\2\2\u00b6\33"+
		"\3\2\2\2\u00b7\u00b8\7\26\2\2\u00b8\35\3\2\2\2\u00b9\u00ba\7\63\2\2\u00ba"+
		"\u00bc\7\r\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00be\7\63\2\2\u00be\37\3\2\2\2\24\60\63CGKqz\177\u0081\u008e"+
		"\u0093\u0096\u009f\u00a9\u00ad\u00b1\u00b3\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}