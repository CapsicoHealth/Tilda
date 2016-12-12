// Generated from TildaSQL2.g4 by ANTLR 4.5.3
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
public class TildaSQL2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NUMERIC_LITERAL=12, TIMESTAMP_LITERAL=13, CURRENT_TIMESTAMP=14, 
		TIMESTAMP_YESTERDAY=15, TIMESTAMP_TODAY=16, TIMESTAMP_TOMORROW=17, LAST=18, 
		STRING_LITERAL=19, BIND_PARAMETER=20, K_AND=21, K_BETWEEN=22, K_IN=23, 
		K_IS=24, K_LIKE=25, K_NOT=26, K_NULL=27, K_EMPTY=28, K_OR=29, K_REGEXP=30, 
		K_LT=31, K_LTE=32, K_GT=33, K_GTE=34, K_EQ=35, K_NEQ=36, K_DIV=37, K_MINUS=38, 
		K_LEN=39, K_DAYS_BETWEEN=40, K_CASE=41, K_WHEN=42, K_THEN=43, K_ELSE=44, 
		K_END=45, IDENTIFIER=46, PLUS_MINUS=47, YEAR_LITERAL=48, MONTH_LITERAL=49, 
		DAY_LITERAL=50, HOUR_LITERAL_24=51, MINUTE_LITERAL=52, SECOND_LITERAL=53, 
		HOUR_LITERAL_12=54, SPACES=55, UNEXPECTED_CHAR=56;
	public static final int
		RULE_main = 0, RULE_expr = 1, RULE_unary_operator = 2, RULE_func_name = 3, 
		RULE_bin_like = 4, RULE_arithmetic_op_add = 5, RULE_arithmetic_op_mul = 6, 
		RULE_isnull_op = 7, RULE_between_op = 8, RULE_literal = 9, RULE_numeric_literal = 10, 
		RULE_timestamp_literal = 11, RULE_string_literal = 12, RULE_bind_parameter = 13, 
		RULE_column = 14;
	public static final String[] ruleNames = {
		"main", "expr", "unary_operator", "func_name", "bin_like", "arithmetic_op_add", 
		"arithmetic_op_mul", "isnull_op", "between_op", "literal", "numeric_literal", 
		"timestamp_literal", "string_literal", "bind_parameter", "column"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'||'", "'='", "'=='", "'!='", "'<>'", "'('", "','", "')'", "'+'", 
		"'*'", "'.'", null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "'<'", "'<='", "'>'", 
		"'>='", null, null, "'/'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NUMERIC_LITERAL", "TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", 
		"TIMESTAMP_TODAY", "TIMESTAMP_TOMORROW", "LAST", "STRING_LITERAL", "BIND_PARAMETER", 
		"K_AND", "K_BETWEEN", "K_IN", "K_IS", "K_LIKE", "K_NOT", "K_NULL", "K_EMPTY", 
		"K_OR", "K_REGEXP", "K_LT", "K_LTE", "K_GT", "K_GTE", "K_EQ", "K_NEQ", 
		"K_DIV", "K_MINUS", "K_LEN", "K_DAYS_BETWEEN", "K_CASE", "K_WHEN", "K_THEN", 
		"K_ELSE", "K_END", "IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", "MONTH_LITERAL", 
		"DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", 
		"HOUR_LITERAL_12", "SPACES", "UNEXPECTED_CHAR"
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
	public String getGrammarFileName() { return "TildaSQL2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TildaSQL2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TildaSQL2Parser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitMain(this);
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
		public Token concat;
		public Token comparators1;
		public Token comparators2;
		public Bin_likeContext like;
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
		public TerminalNode K_CASE() { return getToken(TildaSQL2Parser.K_CASE, 0); }
		public TerminalNode K_END() { return getToken(TildaSQL2Parser.K_END, 0); }
		public List<TerminalNode> K_WHEN() { return getTokens(TildaSQL2Parser.K_WHEN); }
		public TerminalNode K_WHEN(int i) {
			return getToken(TildaSQL2Parser.K_WHEN, i);
		}
		public List<TerminalNode> K_THEN() { return getTokens(TildaSQL2Parser.K_THEN); }
		public TerminalNode K_THEN(int i) {
			return getToken(TildaSQL2Parser.K_THEN, i);
		}
		public TerminalNode K_ELSE() { return getToken(TildaSQL2Parser.K_ELSE, 0); }
		public Arithmetic_op_mulContext arithmetic_op_mul() {
			return getRuleContext(Arithmetic_op_mulContext.class,0);
		}
		public Arithmetic_op_addContext arithmetic_op_add() {
			return getRuleContext(Arithmetic_op_addContext.class,0);
		}
		public Bin_likeContext bin_like() {
			return getRuleContext(Bin_likeContext.class,0);
		}
		public TerminalNode K_AND() { return getToken(TildaSQL2Parser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQL2Parser.K_OR, 0); }
		public Between_opContext between_op() {
			return getRuleContext(Between_opContext.class,0);
		}
		public Isnull_opContext isnull_op() {
			return getRuleContext(Isnull_opContext.class,0);
		}
		public TerminalNode K_IN() { return getToken(TildaSQL2Parser.K_IN, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQL2Parser.K_NOT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitExpr(this);
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << NUMERIC_LITERAL) | (1L << TIMESTAMP_LITERAL) | (1L << CURRENT_TIMESTAMP) | (1L << TIMESTAMP_YESTERDAY) | (1L << TIMESTAMP_TODAY) | (1L << TIMESTAMP_TOMORROW) | (1L << STRING_LITERAL) | (1L << BIND_PARAMETER) | (1L << K_NOT) | (1L << K_MINUS) | (1L << K_LEN) | (1L << K_DAYS_BETWEEN) | (1L << K_CASE) | (1L << IDENTIFIER))) != 0)) {
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
					expr(0);
					setState(60);
					match(K_THEN);
					setState(61);
					expr(0);
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
					expr(0);
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
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(126);
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
						((ExprContext)_localctx).like = bin_like();
						setState(94);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(97);
						match(K_AND);
						setState(98);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(100);
						match(K_OR);
						setState(101);
						expr(8);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(103);
						((ExprContext)_localctx).between = between_op();
						setState(104);
						expr(0);
						setState(105);
						match(K_AND);
						setState(106);
						expr(4);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(108);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(109);
						((ExprContext)_localctx).isnull = isnull_op();
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(112);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(111);
							match(K_NOT);
							}
						}

						setState(114);
						match(K_IN);
						setState(115);
						match(T__5);
						setState(116);
						expr(0);
						setState(121);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__6) {
							{
							{
							setState(117);
							match(T__6);
							setState(118);
							expr(0);
							}
							}
							setState(123);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(124);
						match(T__7);
						}
						break;
					}
					} 
				}
				setState(130);
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
		public TerminalNode K_NOT() { return getToken(TildaSQL2Parser.K_NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
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
		public TerminalNode K_LEN() { return getToken(TildaSQL2Parser.K_LEN, 0); }
		public TerminalNode K_DAYS_BETWEEN() { return getToken(TildaSQL2Parser.K_DAYS_BETWEEN, 0); }
		public Func_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterFunc_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitFunc_name(this);
		}
	}

	public final Func_nameContext func_name() throws RecognitionException {
		Func_nameContext _localctx = new Func_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
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

	public static class Bin_likeContext extends ParserRuleContext {
		public TerminalNode K_LIKE() { return getToken(TildaSQL2Parser.K_LIKE, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQL2Parser.K_NOT, 0); }
		public Bin_likeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_like; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterBin_like(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitBin_like(this);
		}
	}

	public final Bin_likeContext bin_like() throws RecognitionException {
		Bin_likeContext _localctx = new Bin_likeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bin_like);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(135);
				match(K_NOT);
				}
			}

			setState(138);
			match(K_LIKE);
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
		public TerminalNode K_MINUS() { return getToken(TildaSQL2Parser.K_MINUS, 0); }
		public Arithmetic_op_addContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_op_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterArithmetic_op_add(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitArithmetic_op_add(this);
		}
	}

	public final Arithmetic_op_addContext arithmetic_op_add() throws RecognitionException {
		Arithmetic_op_addContext _localctx = new Arithmetic_op_addContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arithmetic_op_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
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
		public TerminalNode K_DIV() { return getToken(TildaSQL2Parser.K_DIV, 0); }
		public Arithmetic_op_mulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_op_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterArithmetic_op_mul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitArithmetic_op_mul(this);
		}
	}

	public final Arithmetic_op_mulContext arithmetic_op_mul() throws RecognitionException {
		Arithmetic_op_mulContext _localctx = new Arithmetic_op_mulContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arithmetic_op_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
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
		public TerminalNode K_IS() { return getToken(TildaSQL2Parser.K_IS, 0); }
		public TerminalNode K_NULL() { return getToken(TildaSQL2Parser.K_NULL, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQL2Parser.K_NOT, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQL2Parser.K_OR, 0); }
		public TerminalNode K_EMPTY() { return getToken(TildaSQL2Parser.K_EMPTY, 0); }
		public Isnull_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isnull_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterIsnull_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitIsnull_op(this);
		}
	}

	public final Isnull_opContext isnull_op() throws RecognitionException {
		Isnull_opContext _localctx = new Isnull_opContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_isnull_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(K_IS);
			setState(146);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(145);
				match(K_NOT);
				}
			}

			setState(148);
			match(K_NULL);
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(149);
				match(K_OR);
				setState(150);
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
		public TerminalNode K_BETWEEN() { return getToken(TildaSQL2Parser.K_BETWEEN, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQL2Parser.K_NOT, 0); }
		public Between_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterBetween_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitBetween_op(this);
		}
	}

	public final Between_opContext between_op() throws RecognitionException {
		Between_opContext _localctx = new Between_opContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_between_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(153);
				match(K_NOT);
				}
			}

			setState(156);
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
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterValueBindParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitValueBindParam(this);
		}
	}
	public static class ValueStringLiteralContext extends LiteralContext {
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public ValueStringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterValueStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitValueStringLiteral(this);
		}
	}
	public static class ValueNumericLiteralContext extends LiteralContext {
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public ValueNumericLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterValueNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitValueNumericLiteral(this);
		}
	}
	public static class ValueTimestampLiteralContext extends LiteralContext {
		public Timestamp_literalContext timestamp_literal() {
			return getRuleContext(Timestamp_literalContext.class,0);
		}
		public ValueTimestampLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterValueTimestampLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitValueTimestampLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_literal);
		try {
			setState(162);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				_localctx = new ValueNumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				numeric_literal();
				}
				break;
			case TIMESTAMP_LITERAL:
			case CURRENT_TIMESTAMP:
			case TIMESTAMP_YESTERDAY:
			case TIMESTAMP_TODAY:
			case TIMESTAMP_TOMORROW:
				_localctx = new ValueTimestampLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				timestamp_literal();
				}
				break;
			case STRING_LITERAL:
				_localctx = new ValueStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				string_literal();
				}
				break;
			case BIND_PARAMETER:
				_localctx = new ValueBindParamContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
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

	public static class Numeric_literalContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(TildaSQL2Parser.NUMERIC_LITERAL, 0); }
		public Numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterNumeric_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitNumeric_literal(this);
		}
	}

	public final Numeric_literalContext numeric_literal() throws RecognitionException {
		Numeric_literalContext _localctx = new Numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
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
		public TerminalNode TIMESTAMP_LITERAL() { return getToken(TildaSQL2Parser.TIMESTAMP_LITERAL, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(TildaSQL2Parser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode TIMESTAMP_YESTERDAY() { return getToken(TildaSQL2Parser.TIMESTAMP_YESTERDAY, 0); }
		public TerminalNode LAST() { return getToken(TildaSQL2Parser.LAST, 0); }
		public TerminalNode TIMESTAMP_TODAY() { return getToken(TildaSQL2Parser.TIMESTAMP_TODAY, 0); }
		public TerminalNode TIMESTAMP_TOMORROW() { return getToken(TildaSQL2Parser.TIMESTAMP_TOMORROW, 0); }
		public Timestamp_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestamp_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterTimestamp_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitTimestamp_literal(this);
		}
	}

	public final Timestamp_literalContext timestamp_literal() throws RecognitionException {
		Timestamp_literalContext _localctx = new Timestamp_literalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_timestamp_literal);
		try {
			setState(180);
			switch (_input.LA(1)) {
			case TIMESTAMP_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(TIMESTAMP_LITERAL);
				}
				break;
			case CURRENT_TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(CURRENT_TIMESTAMP);
				}
				break;
			case TIMESTAMP_YESTERDAY:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(TIMESTAMP_YESTERDAY);
				setState(170);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(169);
					match(LAST);
					}
					break;
				}
				}
				break;
			case TIMESTAMP_TODAY:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(TIMESTAMP_TODAY);
				setState(174);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(173);
					match(LAST);
					}
					break;
				}
				}
				break;
			case TIMESTAMP_TOMORROW:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				match(TIMESTAMP_TOMORROW);
				setState(178);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(177);
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
		public TerminalNode STRING_LITERAL() { return getToken(TildaSQL2Parser.STRING_LITERAL, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitString_literal(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		public TerminalNode BIND_PARAMETER() { return getToken(TildaSQL2Parser.BIND_PARAMETER, 0); }
		public Bind_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bind_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterBind_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitBind_parameter(this);
		}
	}

	public final Bind_parameterContext bind_parameter() throws RecognitionException {
		Bind_parameterContext _localctx = new Bind_parameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_bind_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(TildaSQL2Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(TildaSQL2Parser.IDENTIFIER, i);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQL2Listener ) ((TildaSQL2Listener)listener).exitColumn(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(186);
				match(IDENTIFIER);
				setState(187);
				match(T__10);
				}
				break;
			}
			setState(190);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3:\u00c3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\5\3\64"+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3B\n\3\r\3\16\3"+
		"C\3\3\3\3\5\3H\n\3\3\3\3\3\5\3L\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3s\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3z\n\3\f\3\16\3}\13\3\3\3\3\3\7\3\u0081\n\3\f\3\16\3\u0084\13\3"+
		"\3\4\3\4\3\5\3\5\3\6\5\6\u008b\n\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\5\t"+
		"\u0095\n\t\3\t\3\t\3\t\5\t\u009a\n\t\3\n\5\n\u009d\n\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\5\13\u00a5\n\13\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00ad\n\r\3"+
		"\r\3\r\5\r\u00b1\n\r\3\r\3\r\5\r\u00b5\n\r\5\r\u00b7\n\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\5\20\u00bf\n\20\3\20\3\20\3\20\2\3\4\21\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36\2\b\3\2!$\3\2\4\7\5\2\13\13\34\34((\3\2)*\4\2"+
		"\13\13((\4\2\f\f\'\'\u00d8\2 \3\2\2\2\4K\3\2\2\2\6\u0085\3\2\2\2\b\u0087"+
		"\3\2\2\2\n\u008a\3\2\2\2\f\u008e\3\2\2\2\16\u0090\3\2\2\2\20\u0092\3\2"+
		"\2\2\22\u009c\3\2\2\2\24\u00a4\3\2\2\2\26\u00a6\3\2\2\2\30\u00b6\3\2\2"+
		"\2\32\u00b8\3\2\2\2\34\u00ba\3\2\2\2\36\u00be\3\2\2\2 !\5\4\3\2!\"\7\2"+
		"\2\3\"\3\3\2\2\2#$\b\3\1\2$L\5\24\13\2%L\5\36\20\2&\'\5\6\4\2\'(\5\4\3"+
		"\21(L\3\2\2\2)*\5\b\5\2*\63\7\b\2\2+\60\5\4\3\2,-\7\t\2\2-/\5\4\3\2.,"+
		"\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\64\3\2\2\2\62\60\3\2"+
		"\2\2\63+\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\n\2\2\66L\3\2\2\2"+
		"\678\7\b\2\289\5\4\3\29:\7\n\2\2:L\3\2\2\2;A\7+\2\2<=\7,\2\2=>\5\4\3\2"+
		">?\7-\2\2?@\5\4\3\2@B\3\2\2\2A<\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2"+
		"DG\3\2\2\2EF\7.\2\2FH\5\4\3\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7/\2\2J"+
		"L\3\2\2\2K#\3\2\2\2K%\3\2\2\2K&\3\2\2\2K)\3\2\2\2K\67\3\2\2\2K;\3\2\2"+
		"\2L\u0082\3\2\2\2MN\f\20\2\2NO\7\3\2\2O\u0081\5\4\3\21PQ\f\17\2\2QR\5"+
		"\16\b\2RS\5\4\3\20S\u0081\3\2\2\2TU\f\16\2\2UV\5\f\7\2VW\5\4\3\17W\u0081"+
		"\3\2\2\2XY\f\r\2\2YZ\t\2\2\2Z\u0081\5\4\3\16[\\\f\f\2\2\\]\t\3\2\2]\u0081"+
		"\5\4\3\r^_\f\13\2\2_`\5\n\6\2`a\5\4\3\fa\u0081\3\2\2\2bc\f\n\2\2cd\7\27"+
		"\2\2d\u0081\5\4\3\13ef\f\t\2\2fg\7\37\2\2g\u0081\5\4\3\nhi\f\5\2\2ij\5"+
		"\22\n\2jk\5\4\3\2kl\7\27\2\2lm\5\4\3\6m\u0081\3\2\2\2no\f\6\2\2o\u0081"+
		"\5\20\t\2pr\f\4\2\2qs\7\34\2\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\31\2"+
		"\2uv\7\b\2\2v{\5\4\3\2wx\7\t\2\2xz\5\4\3\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7\n\2\2\177\u0081\3\2\2\2\u0080"+
		"M\3\2\2\2\u0080P\3\2\2\2\u0080T\3\2\2\2\u0080X\3\2\2\2\u0080[\3\2\2\2"+
		"\u0080^\3\2\2\2\u0080b\3\2\2\2\u0080e\3\2\2\2\u0080h\3\2\2\2\u0080n\3"+
		"\2\2\2\u0080p\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\5\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\t\4\2\2\u0086"+
		"\7\3\2\2\2\u0087\u0088\t\5\2\2\u0088\t\3\2\2\2\u0089\u008b\7\34\2\2\u008a"+
		"\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\33"+
		"\2\2\u008d\13\3\2\2\2\u008e\u008f\t\6\2\2\u008f\r\3\2\2\2\u0090\u0091"+
		"\t\7\2\2\u0091\17\3\2\2\2\u0092\u0094\7\32\2\2\u0093\u0095\7\34\2\2\u0094"+
		"\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\7\35"+
		"\2\2\u0097\u0098\7\37\2\2\u0098\u009a\7\36\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\21\3\2\2\2\u009b\u009d\7\34\2\2\u009c\u009b\3\2\2"+
		"\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\30\2\2\u009f"+
		"\23\3\2\2\2\u00a0\u00a5\5\26\f\2\u00a1\u00a5\5\30\r\2\u00a2\u00a5\5\32"+
		"\16\2\u00a3\u00a5\5\34\17\2\u00a4\u00a0\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\25\3\2\2\2\u00a6\u00a7\7\16\2"+
		"\2\u00a7\27\3\2\2\2\u00a8\u00b7\7\17\2\2\u00a9\u00b7\7\20\2\2\u00aa\u00ac"+
		"\7\21\2\2\u00ab\u00ad\7\24\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2"+
		"\u00ad\u00b7\3\2\2\2\u00ae\u00b0\7\22\2\2\u00af\u00b1\7\24\2\2\u00b0\u00af"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b7\3\2\2\2\u00b2\u00b4\7\23\2\2"+
		"\u00b3\u00b5\7\24\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7"+
		"\3\2\2\2\u00b6\u00a8\3\2\2\2\u00b6\u00a9\3\2\2\2\u00b6\u00aa\3\2\2\2\u00b6"+
		"\u00ae\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b7\31\3\2\2\2\u00b8\u00b9\7\25\2"+
		"\2\u00b9\33\3\2\2\2\u00ba\u00bb\7\26\2\2\u00bb\35\3\2\2\2\u00bc\u00bd"+
		"\7\60\2\2\u00bd\u00bf\7\r\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2"+
		"\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\60\2\2\u00c1\37\3\2\2\2\25\60\63CG"+
		"Kr{\u0080\u0082\u008a\u0094\u0099\u009c\u00a4\u00ac\u00b0\u00b4\u00b6"+
		"\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}