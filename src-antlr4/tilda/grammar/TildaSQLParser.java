// Generated from TildaSQL.g4 by ANTLR 4.4
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, NUMERIC_LITERAL=12, TIMESTAMP_LITERAL=13, CURRENT_TIMESTAMP=14, 
		TIMESTAMP_YESTERDAY=15, TIMESTAMP_TODAY=16, TIMESTAMP_TOMORROW=17, LAST=18, 
		CHAR_LITERAL=19, STRING_LITERAL=20, BIND_PARAMETER=21, K_AND=22, K_BETWEEN=23, 
		K_IN=24, K_IS=25, K_LIKE=26, K_NOT_LIKE=27, K_NOT=28, K_NULL=29, K_OR=30, 
		K_EMPTY=31, K_NULL_OR_EMPTY=32, K_REGEXP=33, K_LT=34, K_LTE=35, K_GT=36, 
		K_GTE=37, K_EQ=38, K_NEQ=39, K_DIV=40, K_MINUS=41, K_LEN=42, K_DAYS_BETWEEN=43, 
		K_CASE=44, K_WHEN=45, K_THEN=46, K_ELSE=47, K_END=48, K_TRUE=49, K_FALSE=50, 
		IDENTIFIER=51, PLUS_MINUS=52, YEAR_LITERAL=53, MONTH_LITERAL=54, DAY_LITERAL=55, 
		HOUR_LITERAL_24=56, MINUTE_LITERAL=57, SECOND_LITERAL=58, HOUR_LITERAL_12=59, 
		SPACES=60, UNEXPECTED_CHAR=61;
	public static final String[] tokenNames = {
		"<INVALID>", "'!='", "'||'", "'=='", "'='", "'<>'", "'('", "')'", "'*'", 
		"'+'", "','", "'.'", "NUMERIC_LITERAL", "TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", 
		"TIMESTAMP_YESTERDAY", "TIMESTAMP_TODAY", "TIMESTAMP_TOMORROW", "LAST", 
		"CHAR_LITERAL", "STRING_LITERAL", "BIND_PARAMETER", "K_AND", "K_BETWEEN", 
		"K_IN", "K_IS", "K_LIKE", "K_NOT_LIKE", "K_NOT", "K_NULL", "K_OR", "K_EMPTY", 
		"K_NULL_OR_EMPTY", "K_REGEXP", "'<'", "'<='", "'>'", "'>='", "K_EQ", "K_NEQ", 
		"'/'", "'-'", "K_LEN", "K_DAYS_BETWEEN", "K_CASE", "K_WHEN", "K_THEN", 
		"K_ELSE", "K_END", "K_TRUE", "K_FALSE", "IDENTIFIER", "PLUS_MINUS", "YEAR_LITERAL", 
		"MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", "SECOND_LITERAL", 
		"HOUR_LITERAL_12", "SPACES", "UNEXPECTED_CHAR"
	};
	public static final int
		RULE_main = 0, RULE_expr = 1, RULE_case_when_expr = 2, RULE_case_else_expr = 3, 
		RULE_unary_operator = 4, RULE_func_name = 5, RULE_arithmetic_op_add = 6, 
		RULE_arithmetic_op_mul = 7, RULE_isnull_op = 8, RULE_between_op = 9, RULE_literal = 10, 
		RULE_boolean_literal = 11, RULE_numeric_literal = 12, RULE_timestamp_literal = 13, 
		RULE_char_literal = 14, RULE_string_literal = 15, RULE_bind_parameter = 16, 
		RULE_column = 17;
	public static final String[] ruleNames = {
		"main", "expr", "case_when_expr", "case_else_expr", "unary_operator", 
		"func_name", "arithmetic_op_add", "arithmetic_op_mul", "isnull_op", "between_op", 
		"literal", "boolean_literal", "numeric_literal", "timestamp_literal", 
		"char_literal", "string_literal", "bind_parameter", "column"
	};

	@Override
	public String getGrammarFileName() { return "TildaSQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
			setState(36); expr(0);
			setState(37); match(EOF);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr_compContext extends ExprContext {
		public Token comparators1;
		public Token comparators2;
		public Token like;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode K_NOT_LIKE() { return getToken(TildaSQLParser.K_NOT_LIKE, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_LIKE() { return getToken(TildaSQLParser.K_LIKE, 0); }
		public Expr_compContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_comp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_comp(this);
		}
	}
	public static class Expr_subContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_subContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_sub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_sub(this);
		}
	}
	public static class Expr_caseContext extends ExprContext {
		public Case_when_exprContext case_when_expr(int i) {
			return getRuleContext(Case_when_exprContext.class,i);
		}
		public Case_else_exprContext case_else_expr() {
			return getRuleContext(Case_else_exprContext.class,0);
		}
		public List<Case_when_exprContext> case_when_expr() {
			return getRuleContexts(Case_when_exprContext.class);
		}
		public TerminalNode K_CASE() { return getToken(TildaSQLParser.K_CASE, 0); }
		public TerminalNode K_END() { return getToken(TildaSQLParser.K_END, 0); }
		public Expr_caseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_case(this);
		}
	}
	public static class Expr_arithContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Arithmetic_op_mulContext arithmetic_op_mul() {
			return getRuleContext(Arithmetic_op_mulContext.class,0);
		}
		public Arithmetic_op_addContext arithmetic_op_add() {
			return getRuleContext(Arithmetic_op_addContext.class,0);
		}
		public Expr_arithContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_arith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_arith(this);
		}
	}
	public static class Expr_columnContext extends ExprContext {
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public Expr_columnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_column(this);
		}
	}
	public static class Expr_boolContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_AND() { return getToken(TildaSQLParser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQLParser.K_OR, 0); }
		public Expr_boolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_bool(this);
		}
	}
	public static class Expr_literalContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Expr_literalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_literal(this);
		}
	}
	public static class Expr_concatContext extends ExprContext {
		public Token concat;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_concatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_concat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_concat(this);
		}
	}
	public static class Expr_funcContext extends ExprContext {
		public Func_nameContext func;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public Expr_funcContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_func(this);
		}
	}
	public static class Expr_betweenContext extends ExprContext {
		public Between_opContext between;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Between_opContext between_op() {
			return getRuleContext(Between_opContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_AND() { return getToken(TildaSQLParser.K_AND, 0); }
		public Expr_betweenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_between(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_between(this);
		}
	}
	public static class Expr_inContext extends ExprContext {
		public ExprContext in_main;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode K_IN() { return getToken(TildaSQLParser.K_IN, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public Expr_inContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_in(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_in(this);
		}
	}
	public static class Expr_isnullContext extends ExprContext {
		public Isnull_opContext isnull;
		public Isnull_opContext isnull_op() {
			return getRuleContext(Isnull_opContext.class,0);
		}
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public Expr_isnullContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_isnull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_isnull(this);
		}
	}
	public static class Expr_unaryContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public Expr_unaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_unary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_unary(this);
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
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_unaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(40); unary_operator();
				setState(41); expr(1);
				}
				break;
			case 2:
				{
				_localctx = new Expr_funcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43); ((Expr_funcContext)_localctx).func = func_name();
				setState(44); match(T__5);
				setState(53);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__2) | (1L << NUMERIC_LITERAL) | (1L << TIMESTAMP_LITERAL) | (1L << CURRENT_TIMESTAMP) | (1L << TIMESTAMP_YESTERDAY) | (1L << TIMESTAMP_TODAY) | (1L << TIMESTAMP_TOMORROW) | (1L << CHAR_LITERAL) | (1L << STRING_LITERAL) | (1L << BIND_PARAMETER) | (1L << K_NOT) | (1L << K_MINUS) | (1L << K_LEN) | (1L << K_DAYS_BETWEEN) | (1L << K_CASE) | (1L << K_TRUE) | (1L << K_FALSE) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(45); expr(0);
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(46); match(T__1);
						setState(47); expr(0);
						}
						}
						setState(52);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(55); match(T__4);
				}
				break;
			case 3:
				{
				_localctx = new Expr_subContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57); match(T__5);
				setState(58); expr(0);
				setState(59); match(T__4);
				}
				break;
			case 4:
				{
				_localctx = new Expr_isnullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61); column();
				setState(62); ((Expr_isnullContext)_localctx).isnull = isnull_op();
				}
				break;
			case 5:
				{
				_localctx = new Expr_caseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64); match(K_CASE);
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(65); case_when_expr();
					}
					}
					setState(68); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(71);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(70); case_else_expr();
					}
				}

				setState(73); match(K_END);
				}
				break;
			case 6:
				{
				_localctx = new Expr_literalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75); literal();
				}
				break;
			case 7:
				{
				_localctx = new Expr_columnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76); column();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(127);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_concatContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(80); ((Expr_concatContext)_localctx).concat = match(T__9);
						setState(81); expr(18);
						}
						break;
					case 2:
						{
						_localctx = new Expr_arithContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(83); arithmetic_op_mul();
						setState(84); expr(17);
						}
						break;
					case 3:
						{
						_localctx = new Expr_arithContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(87); arithmetic_op_add();
						setState(88); expr(16);
						}
						break;
					case 4:
						{
						_localctx = new Expr_compContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(91);
						((Expr_compContext)_localctx).comparators1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_LT) | (1L << K_LTE) | (1L << K_GT) | (1L << K_GTE))) != 0)) ) {
							((Expr_compContext)_localctx).comparators1 = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(92); expr(15);
						}
						break;
					case 5:
						{
						_localctx = new Expr_compContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(93);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(94);
						((Expr_compContext)_localctx).comparators2 = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__8) | (1L << T__7) | (1L << T__6))) != 0)) ) {
							((Expr_compContext)_localctx).comparators2 = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(95); expr(14);
						}
						break;
					case 6:
						{
						_localctx = new Expr_compContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(97);
						((Expr_compContext)_localctx).like = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==K_LIKE || _la==K_NOT_LIKE) ) {
							((Expr_compContext)_localctx).like = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(98); expr(13);
						}
						break;
					case 7:
						{
						_localctx = new Expr_betweenContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(100); ((Expr_betweenContext)_localctx).between = between_op();
						setState(101); expr(0);
						setState(102); match(K_AND);
						setState(103); expr(9);
						}
						break;
					case 8:
						{
						_localctx = new Expr_boolContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(106); match(K_AND);
						setState(107); expr(6);
						}
						break;
					case 9:
						{
						_localctx = new Expr_boolContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(108);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(109); match(K_OR);
						setState(110); expr(5);
						}
						break;
					case 10:
						{
						_localctx = new Expr_inContext(new ExprContext(_parentctx, _parentState));
						((Expr_inContext)_localctx).in_main = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(113);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(112); match(K_NOT);
							}
						}

						setState(115); match(K_IN);
						setState(116); match(T__5);
						setState(117); expr(0);
						setState(122);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__1) {
							{
							{
							setState(118); match(T__1);
							setState(119); expr(0);
							}
							}
							setState(124);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(125); match(T__4);
						}
						break;
					}
					} 
				}
				setState(131);
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

	public static class Case_when_exprContext extends ParserRuleContext {
		public ExprContext case_when;
		public ExprContext case_then;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_WHEN() { return getToken(TildaSQLParser.K_WHEN, 0); }
		public TerminalNode K_THEN() { return getToken(TildaSQLParser.K_THEN, 0); }
		public Case_when_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_when_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterCase_when_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitCase_when_expr(this);
		}
	}

	public final Case_when_exprContext case_when_expr() throws RecognitionException {
		Case_when_exprContext _localctx = new Case_when_exprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_case_when_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); match(K_WHEN);
			setState(133); ((Case_when_exprContext)_localctx).case_when = expr(0);
			setState(134); match(K_THEN);
			setState(135); ((Case_when_exprContext)_localctx).case_then = expr(0);
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

	public static class Case_else_exprContext extends ParserRuleContext {
		public ExprContext case_else;
		public TerminalNode K_ELSE() { return getToken(TildaSQLParser.K_ELSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Case_else_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_else_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterCase_else_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitCase_else_expr(this);
		}
	}

	public final Case_else_exprContext case_else_expr() throws RecognitionException {
		Case_else_exprContext _localctx = new Case_else_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_case_else_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(K_ELSE);
			setState(138); ((Case_else_exprContext)_localctx).case_else = expr(0);
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
		enterRule(_localctx, 8, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << K_NOT) | (1L << K_MINUS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		enterRule(_localctx, 10, RULE_func_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==K_LEN || _la==K_DAYS_BETWEEN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		enterRule(_localctx, 12, RULE_arithmetic_op_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==K_MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		enterRule(_localctx, 14, RULE_arithmetic_op_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==K_DIV) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		public TerminalNode K_EMPTY() { return getToken(TildaSQLParser.K_EMPTY, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQLParser.K_OR, 0); }
		public TerminalNode K_NULL_OR_EMPTY() { return getToken(TildaSQLParser.K_NULL_OR_EMPTY, 0); }
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
		enterRule(_localctx, 16, RULE_isnull_op);
		int _la;
		try {
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148); match(K_IS);
				setState(150);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(149); match(K_NOT);
					}
				}

				setState(152); match(K_NULL);
				setState(155);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(153); match(K_OR);
					setState(154); match(K_EMPTY);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157); match(K_IS);
				setState(159);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(158); match(K_NOT);
					}
					break;
				}
				setState(162);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(161); match(K_NULL_OR_EMPTY);
					}
					break;
				}
				}
				break;
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
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public TerminalNode K_BETWEEN() { return getToken(TildaSQLParser.K_BETWEEN, 0); }
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
		enterRule(_localctx, 18, RULE_between_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(166); match(K_NOT);
				}
			}

			setState(169); match(K_BETWEEN);
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
	public static class ValueCharLiteralContext extends LiteralContext {
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public ValueCharLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueCharLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueCharLiteral(this);
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
		enterRule(_localctx, 20, RULE_literal);
		try {
			setState(177);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				_localctx = new ValueNumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171); numeric_literal();
				}
				break;
			case K_TRUE:
			case K_FALSE:
				_localctx = new ValueBooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172); boolean_literal();
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
				setState(173); timestamp_literal();
				}
				break;
			case CHAR_LITERAL:
				_localctx = new ValueCharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(174); char_literal();
				}
				break;
			case STRING_LITERAL:
				_localctx = new ValueStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(175); string_literal();
				}
				break;
			case BIND_PARAMETER:
				_localctx = new ValueBindParamContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(176); bind_parameter();
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
		public TerminalNode K_FALSE() { return getToken(TildaSQLParser.K_FALSE, 0); }
		public TerminalNode K_TRUE() { return getToken(TildaSQLParser.K_TRUE, 0); }
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
		enterRule(_localctx, 22, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_la = _input.LA(1);
			if ( !(_la==K_TRUE || _la==K_FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		enterRule(_localctx, 24, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(NUMERIC_LITERAL);
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
		public TerminalNode TIMESTAMP_TODAY() { return getToken(TildaSQLParser.TIMESTAMP_TODAY, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(TildaSQLParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode TIMESTAMP_YESTERDAY() { return getToken(TildaSQLParser.TIMESTAMP_YESTERDAY, 0); }
		public TerminalNode TIMESTAMP_LITERAL() { return getToken(TildaSQLParser.TIMESTAMP_LITERAL, 0); }
		public TerminalNode TIMESTAMP_TOMORROW() { return getToken(TildaSQLParser.TIMESTAMP_TOMORROW, 0); }
		public TerminalNode LAST() { return getToken(TildaSQLParser.LAST, 0); }
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
		enterRule(_localctx, 26, RULE_timestamp_literal);
		try {
			setState(197);
			switch (_input.LA(1)) {
			case TIMESTAMP_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); match(TIMESTAMP_LITERAL);
				}
				break;
			case CURRENT_TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(184); match(CURRENT_TIMESTAMP);
				}
				break;
			case TIMESTAMP_YESTERDAY:
				enterOuterAlt(_localctx, 3);
				{
				setState(185); match(TIMESTAMP_YESTERDAY);
				setState(187);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(186); match(LAST);
					}
					break;
				}
				}
				break;
			case TIMESTAMP_TODAY:
				enterOuterAlt(_localctx, 4);
				{
				setState(189); match(TIMESTAMP_TODAY);
				setState(191);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(190); match(LAST);
					}
					break;
				}
				}
				break;
			case TIMESTAMP_TOMORROW:
				enterOuterAlt(_localctx, 5);
				{
				setState(193); match(TIMESTAMP_TOMORROW);
				setState(195);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(194); match(LAST);
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

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode CHAR_LITERAL() { return getToken(TildaSQLParser.CHAR_LITERAL, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterChar_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitChar_literal(this);
		}
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(CHAR_LITERAL);
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
		enterRule(_localctx, 30, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); match(STRING_LITERAL);
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
		enterRule(_localctx, 32, RULE_bind_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(BIND_PARAMETER);
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
		public TerminalNode IDENTIFIER(int i) {
			return getToken(TildaSQLParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(TildaSQLParser.IDENTIFIER); }
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
		enterRule(_localctx, 34, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(205); match(IDENTIFIER);
				setState(206); match(T__0);
				}
				break;
			}
			setState(209); match(IDENTIFIER);
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
		case 1: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 17);
		case 1: return precpred(_ctx, 16);
		case 2: return precpred(_ctx, 15);
		case 3: return precpred(_ctx, 14);
		case 4: return precpred(_ctx, 13);
		case 5: return precpred(_ctx, 12);
		case 6: return precpred(_ctx, 8);
		case 7: return precpred(_ctx, 5);
		case 8: return precpred(_ctx, 4);
		case 9: return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3?\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n\3"+
		"\f\3\16\3\66\13\3\5\38\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\6\3E\n\3\r\3\16\3F\3\3\5\3J\n\3\3\3\3\3\3\3\3\3\5\3P\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3t\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\7\3{\n\3\f\3\16\3~\13\3\3\3\3\3\7\3\u0082\n\3\f\3\16\3"+
		"\u0085\13\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\5\n\u0099\n\n\3\n\3\n\3\n\5\n\u009e\n\n\3\n\3\n\5\n\u00a2"+
		"\n\n\3\n\5\n\u00a5\n\n\5\n\u00a7\n\n\3\13\5\13\u00aa\n\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b4\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\5\17\u00be\n\17\3\17\3\17\5\17\u00c2\n\17\3\17\3\17\5\17\u00c6\n"+
		"\17\5\17\u00c8\n\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\5\23\u00d2"+
		"\n\23\3\23\3\23\3\23\2\3\4\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$\2\n\3\2$\'\4\2\3\3\5\7\3\2\34\35\5\2\13\13\36\36++\3\2,-\4\2\13\13"+
		"++\4\2\n\n**\3\2\63\64\u00ec\2&\3\2\2\2\4O\3\2\2\2\6\u0086\3\2\2\2\b\u008b"+
		"\3\2\2\2\n\u008e\3\2\2\2\f\u0090\3\2\2\2\16\u0092\3\2\2\2\20\u0094\3\2"+
		"\2\2\22\u00a6\3\2\2\2\24\u00a9\3\2\2\2\26\u00b3\3\2\2\2\30\u00b5\3\2\2"+
		"\2\32\u00b7\3\2\2\2\34\u00c7\3\2\2\2\36\u00c9\3\2\2\2 \u00cb\3\2\2\2\""+
		"\u00cd\3\2\2\2$\u00d1\3\2\2\2&\'\5\4\3\2\'(\7\2\2\3(\3\3\2\2\2)*\b\3\1"+
		"\2*+\5\n\6\2+,\5\4\3\3,P\3\2\2\2-.\5\f\7\2.\67\7\b\2\2/\64\5\4\3\2\60"+
		"\61\7\f\2\2\61\63\5\4\3\2\62\60\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64"+
		"\65\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\67/\3\2\2\2\678\3\2\2\289\3\2\2"+
		"\29:\7\t\2\2:P\3\2\2\2;<\7\b\2\2<=\5\4\3\2=>\7\t\2\2>P\3\2\2\2?@\5$\23"+
		"\2@A\5\22\n\2AP\3\2\2\2BD\7.\2\2CE\5\6\4\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2"+
		"\2FG\3\2\2\2GI\3\2\2\2HJ\5\b\5\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\62"+
		"\2\2LP\3\2\2\2MP\5\26\f\2NP\5$\23\2O)\3\2\2\2O-\3\2\2\2O;\3\2\2\2O?\3"+
		"\2\2\2OB\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\u0083\3\2\2\2QR\f\23\2\2RS\7\4\2"+
		"\2S\u0082\5\4\3\24TU\f\22\2\2UV\5\20\t\2VW\5\4\3\23W\u0082\3\2\2\2XY\f"+
		"\21\2\2YZ\5\16\b\2Z[\5\4\3\22[\u0082\3\2\2\2\\]\f\20\2\2]^\t\2\2\2^\u0082"+
		"\5\4\3\21_`\f\17\2\2`a\t\3\2\2a\u0082\5\4\3\20bc\f\16\2\2cd\t\4\2\2d\u0082"+
		"\5\4\3\17ef\f\n\2\2fg\5\24\13\2gh\5\4\3\2hi\7\30\2\2ij\5\4\3\13j\u0082"+
		"\3\2\2\2kl\f\7\2\2lm\7\30\2\2m\u0082\5\4\3\bno\f\6\2\2op\7 \2\2p\u0082"+
		"\5\4\3\7qs\f\t\2\2rt\7\36\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\32\2\2"+
		"vw\7\b\2\2w|\5\4\3\2xy\7\f\2\2y{\5\4\3\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2"+
		"|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\7\t\2\2\u0080\u0082\3\2\2"+
		"\2\u0081Q\3\2\2\2\u0081T\3\2\2\2\u0081X\3\2\2\2\u0081\\\3\2\2\2\u0081"+
		"_\3\2\2\2\u0081b\3\2\2\2\u0081e\3\2\2\2\u0081k\3\2\2\2\u0081n\3\2\2\2"+
		"\u0081q\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3"+
		"\2\2\2\u0084\5\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7/\2\2\u0087\u0088"+
		"\5\4\3\2\u0088\u0089\7\60\2\2\u0089\u008a\5\4\3\2\u008a\7\3\2\2\2\u008b"+
		"\u008c\7\61\2\2\u008c\u008d\5\4\3\2\u008d\t\3\2\2\2\u008e\u008f\t\5\2"+
		"\2\u008f\13\3\2\2\2\u0090\u0091\t\6\2\2\u0091\r\3\2\2\2\u0092\u0093\t"+
		"\7\2\2\u0093\17\3\2\2\2\u0094\u0095\t\b\2\2\u0095\21\3\2\2\2\u0096\u0098"+
		"\7\33\2\2\u0097\u0099\7\36\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009d\7\37\2\2\u009b\u009c\7 \2\2\u009c\u009e"+
		"\7!\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a7\3\2\2\2\u009f"+
		"\u00a1\7\33\2\2\u00a0\u00a2\7\36\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3"+
		"\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a5\7\"\2\2\u00a4\u00a3\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u0096\3\2\2\2\u00a6\u009f\3\2"+
		"\2\2\u00a7\23\3\2\2\2\u00a8\u00aa\7\36\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\31\2\2\u00ac\25\3\2\2\2\u00ad"+
		"\u00b4\5\32\16\2\u00ae\u00b4\5\30\r\2\u00af\u00b4\5\34\17\2\u00b0\u00b4"+
		"\5\36\20\2\u00b1\u00b4\5 \21\2\u00b2\u00b4\5\"\22\2\u00b3\u00ad\3\2\2"+
		"\2\u00b3\u00ae\3\2\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\27\3\2\2\2\u00b5\u00b6\t\t\2\2\u00b6"+
		"\31\3\2\2\2\u00b7\u00b8\7\16\2\2\u00b8\33\3\2\2\2\u00b9\u00c8\7\17\2\2"+
		"\u00ba\u00c8\7\20\2\2\u00bb\u00bd\7\21\2\2\u00bc\u00be\7\24\2\2\u00bd"+
		"\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c8\3\2\2\2\u00bf\u00c1\7\22"+
		"\2\2\u00c0\u00c2\7\24\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c8\3\2\2\2\u00c3\u00c5\7\23\2\2\u00c4\u00c6\7\24\2\2\u00c5\u00c4\3"+
		"\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00b9\3\2\2\2\u00c7"+
		"\u00ba\3\2\2\2\u00c7\u00bb\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c3\3\2"+
		"\2\2\u00c8\35\3\2\2\2\u00c9\u00ca\7\25\2\2\u00ca\37\3\2\2\2\u00cb\u00cc"+
		"\7\26\2\2\u00cc!\3\2\2\2\u00cd\u00ce\7\27\2\2\u00ce#\3\2\2\2\u00cf\u00d0"+
		"\7\65\2\2\u00d0\u00d2\7\r\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2"+
		"\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7\65\2\2\u00d4%\3\2\2\2\27\64\67FIOs"+
		"|\u0081\u0083\u0098\u009d\u00a1\u00a4\u00a6\u00a9\u00b3\u00bd\u00c1\u00c5"+
		"\u00c7\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}