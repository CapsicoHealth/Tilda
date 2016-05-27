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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUMERIC_LITERAL=9, 
		TIMESTAMP_LITERAL=10, CURRENT_TIMESTAMP=11, TIMESTAMP_YESTERDAY=12, TIMESTAMP_YESTERDAY_LAST=13, 
		TIMESTAMP_TODAY=14, TIMESTAMP_TODAY_LAST=15, TIMESTAMP_TOMORROW=16, TIMESTAMP_TOMORROW_LAST=17, 
		STRING_LITERAL=18, BIND_PARAMETER=19, K_AND=20, K_BETWEEN=21, K_IN=22, 
		K_IS=23, K_LIKE=24, K_NOT=25, K_NULL=26, K_ON=27, K_OR=28, K_REGEXP=29, 
		K_LT=30, K_LTE=31, K_GT=32, K_GTE=33, K_EQ=34, K_NEQ=35, IDENTIFIER=36, 
		PLUS_MINUS=37, YEAR_LITERAL=38, MONTH_LITERAL=39, DAY_LITERAL=40, HOUR_LITERAL_24=41, 
		MINUTE_LITERAL=42, SECOND_LITERAL=43, HOUR_LITERAL_12=44, QUOTE=45, SPACES=46, 
		UNEXPECTED_CHAR=47;
	public static final int
		RULE_where = 0, RULE_expr = 1, RULE_expr_sub = 2, RULE_bool_expr = 3, 
		RULE_bool_op = 4, RULE_bool_expr_sub = 5, RULE_bin_expr = 6, RULE_bin_op = 7, 
		RULE_aryth_expr = 8, RULE_aryth_expr_sub = 9, RULE_aryth_op_add = 10, 
		RULE_aryth_op_mul = 11, RULE_isnull_expr = 12, RULE_isnull_op = 13, RULE_between_expr = 14, 
		RULE_between_op = 15, RULE_value = 16, RULE_numeric_literal = 17, RULE_timestamp_literal = 18, 
		RULE_string_literal = 19, RULE_bind_parameter = 20, RULE_function = 21, 
		RULE_column = 22;
	public static final String[] ruleNames = {
		"where", "expr", "expr_sub", "bool_expr", "bool_op", "bool_expr_sub", 
		"bin_expr", "bin_op", "aryth_expr", "aryth_expr_sub", "aryth_op_add", 
		"aryth_op_mul", "isnull_expr", "isnull_op", "between_expr", "between_op", 
		"value", "numeric_literal", "timestamp_literal", "string_literal", "bind_parameter", 
		"function", "column"
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
	public static class WhereContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TildaSQLParser.EOF, 0); }
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitWhere(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			expr();
			setState(47);
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
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public Bin_exprContext bin_expr() {
			return getRuleContext(Bin_exprContext.class,0);
		}
		public Isnull_exprContext isnull_expr() {
			return getRuleContext(Isnull_exprContext.class,0);
		}
		public Between_exprContext between_expr() {
			return getRuleContext(Between_exprContext.class,0);
		}
		public Expr_subContext expr_sub() {
			return getRuleContext(Expr_subContext.class,0);
		}
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
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				bool_expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				bin_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				isnull_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				between_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				expr_sub();
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

	public static class Expr_subContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_sub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterExpr_sub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitExpr_sub(this);
		}
	}

	public final Expr_subContext expr_sub() throws RecognitionException {
		Expr_subContext _localctx = new Expr_subContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__0);
			setState(57);
			expr();
			setState(58);
			match(T__1);
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

	public static class Bool_exprContext extends ParserRuleContext {
		public Bool_exprContext l_expr;
		public Bin_exprContext s_expr;
		public Bool_opContext op;
		public Bool_exprContext r_expr;
		public Bin_exprContext bin_expr() {
			return getRuleContext(Bin_exprContext.class,0);
		}
		public Bool_expr_subContext bool_expr_sub() {
			return getRuleContext(Bool_expr_subContext.class,0);
		}
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public Bool_opContext bool_op() {
			return getRuleContext(Bool_opContext.class,0);
		}
		public Bool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBool_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBool_expr(this);
		}
	}

	public final Bool_exprContext bool_expr() throws RecognitionException {
		return bool_expr(0);
	}

	private Bool_exprContext bool_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, _parentState);
		Bool_exprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_bool_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(61);
				((Bool_exprContext)_localctx).s_expr = bin_expr();
				}
				break;
			case T__0:
				{
				setState(62);
				bool_expr_sub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bool_exprContext(_parentctx, _parentState);
					_localctx.l_expr = _prevctx;
					_localctx.l_expr = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
					setState(65);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(66);
					((Bool_exprContext)_localctx).op = bool_op();
					setState(67);
					((Bool_exprContext)_localctx).r_expr = bool_expr(4);
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class Bool_opContext extends ParserRuleContext {
		public TerminalNode K_AND() { return getToken(TildaSQLParser.K_AND, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQLParser.K_OR, 0); }
		public Bool_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBool_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBool_op(this);
		}
	}

	public final Bool_opContext bool_op() throws RecognitionException {
		Bool_opContext _localctx = new Bool_opContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bool_op);
		int _la;
		try {
			setState(82);
			switch (_input.LA(1)) {
			case K_AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(K_AND);
				setState(76);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(75);
					match(K_NOT);
					}
				}

				}
				break;
			case K_OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(K_OR);
				setState(80);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(79);
					match(K_NOT);
					}
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

	public static class Bool_expr_subContext extends ParserRuleContext {
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public Bool_expr_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr_sub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBool_expr_sub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBool_expr_sub(this);
		}
	}

	public final Bool_expr_subContext bool_expr_sub() throws RecognitionException {
		Bool_expr_subContext _localctx = new Bool_expr_subContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool_expr_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__0);
			setState(85);
			bool_expr(0);
			setState(86);
			match(T__1);
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

	public static class Bin_exprContext extends ParserRuleContext {
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public Bin_opContext bin_op() {
			return getRuleContext(Bin_opContext.class,0);
		}
		public Aryth_exprContext aryth_expr() {
			return getRuleContext(Aryth_exprContext.class,0);
		}
		public Bin_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBin_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBin_expr(this);
		}
	}

	public final Bin_exprContext bin_expr() throws RecognitionException {
		Bin_exprContext _localctx = new Bin_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bin_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			column();
			setState(89);
			bin_op();
			setState(92);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(90);
				column();
				}
				break;
			case T__0:
			case NUMERIC_LITERAL:
			case TIMESTAMP_LITERAL:
			case CURRENT_TIMESTAMP:
			case TIMESTAMP_YESTERDAY:
			case TIMESTAMP_YESTERDAY_LAST:
			case TIMESTAMP_TODAY:
			case TIMESTAMP_TODAY_LAST:
			case TIMESTAMP_TOMORROW:
			case TIMESTAMP_TOMORROW_LAST:
			case STRING_LITERAL:
			case BIND_PARAMETER:
				{
				setState(91);
				aryth_expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Bin_opContext extends ParserRuleContext {
		public TerminalNode K_LT() { return getToken(TildaSQLParser.K_LT, 0); }
		public TerminalNode K_LTE() { return getToken(TildaSQLParser.K_LTE, 0); }
		public TerminalNode K_GT() { return getToken(TildaSQLParser.K_GT, 0); }
		public TerminalNode K_GTE() { return getToken(TildaSQLParser.K_GTE, 0); }
		public TerminalNode K_EQ() { return getToken(TildaSQLParser.K_EQ, 0); }
		public TerminalNode K_NEQ() { return getToken(TildaSQLParser.K_NEQ, 0); }
		public TerminalNode K_LIKE() { return getToken(TildaSQLParser.K_LIKE, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public Bin_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBin_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBin_op(this);
		}
	}

	public final Bin_opContext bin_op() throws RecognitionException {
		Bin_opContext _localctx = new Bin_opContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bin_op);
		int _la;
		try {
			setState(104);
			switch (_input.LA(1)) {
			case K_LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(K_LT);
				}
				break;
			case K_LTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(K_LTE);
				}
				break;
			case K_GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(K_GT);
				}
				break;
			case K_GTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				match(K_GTE);
				}
				break;
			case K_EQ:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				match(K_EQ);
				}
				break;
			case K_NEQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
				match(K_NEQ);
				}
				break;
			case K_LIKE:
			case K_NOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(101);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(100);
					match(K_NOT);
					}
				}

				setState(103);
				match(K_LIKE);
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

	public static class Aryth_exprContext extends ParserRuleContext {
		public Aryth_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aryth_expr; }
	 
		public Aryth_exprContext() { }
		public void copyFrom(Aryth_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArythExprContext extends Aryth_exprContext {
		public List<Aryth_exprContext> aryth_expr() {
			return getRuleContexts(Aryth_exprContext.class);
		}
		public Aryth_exprContext aryth_expr(int i) {
			return getRuleContext(Aryth_exprContext.class,i);
		}
		public Aryth_op_mulContext aryth_op_mul() {
			return getRuleContext(Aryth_op_mulContext.class,0);
		}
		public Aryth_op_addContext aryth_op_add() {
			return getRuleContext(Aryth_op_addContext.class,0);
		}
		public ArythExprContext(Aryth_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArythExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArythExpr(this);
		}
	}
	public static class ArythExprSubContext extends Aryth_exprContext {
		public Aryth_expr_subContext aryth_expr_sub() {
			return getRuleContext(Aryth_expr_subContext.class,0);
		}
		public ArythExprSubContext(Aryth_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArythExprSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArythExprSub(this);
		}
	}
	public static class ArythExprValContext extends Aryth_exprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ArythExprValContext(Aryth_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArythExprVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArythExprVal(this);
		}
	}

	public final Aryth_exprContext aryth_expr() throws RecognitionException {
		return aryth_expr(0);
	}

	private Aryth_exprContext aryth_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Aryth_exprContext _localctx = new Aryth_exprContext(_ctx, _parentState);
		Aryth_exprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_aryth_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
			case TIMESTAMP_LITERAL:
			case CURRENT_TIMESTAMP:
			case TIMESTAMP_YESTERDAY:
			case TIMESTAMP_YESTERDAY_LAST:
			case TIMESTAMP_TODAY:
			case TIMESTAMP_TODAY_LAST:
			case TIMESTAMP_TOMORROW:
			case TIMESTAMP_TOMORROW_LAST:
			case STRING_LITERAL:
			case BIND_PARAMETER:
				{
				_localctx = new ArythExprValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(107);
				value();
				}
				break;
			case T__0:
				{
				_localctx = new ArythExprSubContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				aryth_expr_sub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(119);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ArythExprContext(new Aryth_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aryth_expr);
						setState(111);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(112);
						aryth_op_mul();
						setState(113);
						aryth_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ArythExprContext(new Aryth_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aryth_expr);
						setState(115);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(116);
						aryth_op_add();
						setState(117);
						aryth_expr(4);
						}
						break;
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Aryth_expr_subContext extends ParserRuleContext {
		public Aryth_exprContext s_expr;
		public Aryth_exprContext aryth_expr() {
			return getRuleContext(Aryth_exprContext.class,0);
		}
		public Aryth_expr_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aryth_expr_sub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterAryth_expr_sub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitAryth_expr_sub(this);
		}
	}

	public final Aryth_expr_subContext aryth_expr_sub() throws RecognitionException {
		Aryth_expr_subContext _localctx = new Aryth_expr_subContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_aryth_expr_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__0);
			setState(125);
			((Aryth_expr_subContext)_localctx).s_expr = aryth_expr(0);
			setState(126);
			match(T__1);
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

	public static class Aryth_op_addContext extends ParserRuleContext {
		public Aryth_op_addContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aryth_op_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterAryth_op_add(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitAryth_op_add(this);
		}
	}

	public final Aryth_op_addContext aryth_op_add() throws RecognitionException {
		Aryth_op_addContext _localctx = new Aryth_op_addContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_aryth_op_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
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

	public static class Aryth_op_mulContext extends ParserRuleContext {
		public Aryth_op_mulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aryth_op_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterAryth_op_mul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitAryth_op_mul(this);
		}
	}

	public final Aryth_op_mulContext aryth_op_mul() throws RecognitionException {
		Aryth_op_mulContext _localctx = new Aryth_op_mulContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_aryth_op_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
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

	public static class Isnull_exprContext extends ParserRuleContext {
		public ColumnContext col;
		public Isnull_opContext op;
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public Isnull_opContext isnull_op() {
			return getRuleContext(Isnull_opContext.class,0);
		}
		public Isnull_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isnull_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterIsnull_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitIsnull_expr(this);
		}
	}

	public final Isnull_exprContext isnull_expr() throws RecognitionException {
		Isnull_exprContext _localctx = new Isnull_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_isnull_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			((Isnull_exprContext)_localctx).col = column();
			setState(133);
			((Isnull_exprContext)_localctx).op = isnull_op();
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
		enterRule(_localctx, 26, RULE_isnull_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(K_IS);
			setState(137);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(136);
				match(K_NOT);
				}
			}

			setState(139);
			match(K_NULL);
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

	public static class Between_exprContext extends ParserRuleContext {
		public ColumnContext col;
		public Between_opContext op;
		public ValueContext val1;
		public ValueContext val2;
		public TerminalNode K_AND() { return getToken(TildaSQLParser.K_AND, 0); }
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public Between_opContext between_op() {
			return getRuleContext(Between_opContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public Between_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBetween_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBetween_expr(this);
		}
	}

	public final Between_exprContext between_expr() throws RecognitionException {
		Between_exprContext _localctx = new Between_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_between_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			((Between_exprContext)_localctx).col = column();
			setState(142);
			((Between_exprContext)_localctx).op = between_op();
			setState(143);
			((Between_exprContext)_localctx).val1 = value();
			setState(144);
			match(K_AND);
			setState(145);
			((Between_exprContext)_localctx).val2 = value();
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
		enterRule(_localctx, 30, RULE_between_op);
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueBindParamContext extends ValueContext {
		public Bind_parameterContext bind_parameter() {
			return getRuleContext(Bind_parameterContext.class,0);
		}
		public ValueBindParamContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueBindParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueBindParam(this);
		}
	}
	public static class ValueStringLiteralContext extends ValueContext {
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public ValueStringLiteralContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueStringLiteral(this);
		}
	}
	public static class ValueNumericLiteralContext extends ValueContext {
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public ValueNumericLiteralContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueNumericLiteral(this);
		}
	}
	public static class ValueTimestampLiteralContext extends ValueContext {
		public Timestamp_literalContext timestamp_literal() {
			return getRuleContext(Timestamp_literalContext.class,0);
		}
		public ValueTimestampLiteralContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueTimestampLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueTimestampLiteral(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value);
		try {
			setState(156);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				_localctx = new ValueNumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				numeric_literal();
				}
				break;
			case TIMESTAMP_LITERAL:
			case CURRENT_TIMESTAMP:
			case TIMESTAMP_YESTERDAY:
			case TIMESTAMP_YESTERDAY_LAST:
			case TIMESTAMP_TODAY:
			case TIMESTAMP_TODAY_LAST:
			case TIMESTAMP_TOMORROW:
			case TIMESTAMP_TOMORROW_LAST:
				_localctx = new ValueTimestampLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				timestamp_literal();
				}
				break;
			case STRING_LITERAL:
				_localctx = new ValueStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				string_literal();
				}
				break;
			case BIND_PARAMETER:
				_localctx = new ValueBindParamContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
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
		enterRule(_localctx, 34, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
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
		public TerminalNode TIMESTAMP_YESTERDAY_LAST() { return getToken(TildaSQLParser.TIMESTAMP_YESTERDAY_LAST, 0); }
		public TerminalNode TIMESTAMP_TODAY() { return getToken(TildaSQLParser.TIMESTAMP_TODAY, 0); }
		public TerminalNode TIMESTAMP_TODAY_LAST() { return getToken(TildaSQLParser.TIMESTAMP_TODAY_LAST, 0); }
		public TerminalNode TIMESTAMP_TOMORROW() { return getToken(TildaSQLParser.TIMESTAMP_TOMORROW, 0); }
		public TerminalNode TIMESTAMP_TOMORROW_LAST() { return getToken(TildaSQLParser.TIMESTAMP_TOMORROW_LAST, 0); }
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
		enterRule(_localctx, 36, RULE_timestamp_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMESTAMP_LITERAL) | (1L << CURRENT_TIMESTAMP) | (1L << TIMESTAMP_YESTERDAY) | (1L << TIMESTAMP_YESTERDAY_LAST) | (1L << TIMESTAMP_TODAY) | (1L << TIMESTAMP_TODAY_LAST) | (1L << TIMESTAMP_TOMORROW) | (1L << TIMESTAMP_TOMORROW_LAST))) != 0)) ) {
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
		enterRule(_localctx, 38, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
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
		enterRule(_localctx, 40, RULE_bind_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TildaSQLParser.IDENTIFIER, 0); }
		public List<Aryth_exprContext> aryth_expr() {
			return getRuleContexts(Aryth_exprContext.class);
		}
		public Aryth_exprContext aryth_expr(int i) {
			return getRuleContext(Aryth_exprContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(IDENTIFIER);
			setState(167);
			match(T__0);
			setState(176);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NUMERIC_LITERAL) | (1L << TIMESTAMP_LITERAL) | (1L << CURRENT_TIMESTAMP) | (1L << TIMESTAMP_YESTERDAY) | (1L << TIMESTAMP_YESTERDAY_LAST) | (1L << TIMESTAMP_TODAY) | (1L << TIMESTAMP_TODAY_LAST) | (1L << TIMESTAMP_TOMORROW) | (1L << TIMESTAMP_TOMORROW_LAST) | (1L << STRING_LITERAL) | (1L << BIND_PARAMETER))) != 0)) {
				{
				setState(168);
				aryth_expr(0);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(169);
					match(T__6);
					setState(170);
					aryth_expr(0);
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(178);
			match(T__1);
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
		enterRule(_localctx, 44, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(180);
				match(IDENTIFIER);
				setState(181);
				match(T__7);
				}
				break;
			}
			setState(184);
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
		case 3:
			return bool_expr_sempred((Bool_exprContext)_localctx, predIndex);
		case 8:
			return aryth_expr_sempred((Aryth_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean bool_expr_sempred(Bool_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean aryth_expr_sempred(Aryth_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u00bd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\5\39\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5B\n\5\3"+
		"\5\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\6\3\6\5\6O\n\6\3\6\3\6\5\6S\n"+
		"\6\5\6U\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\th\n\t\3\t\5\tk\n\t\3\n\3\n\3\n\5\np\n\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\nz\n\n\f\n\16\n}\13\n\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\5\17\u008c\n\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\5\21\u0097\n\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\5\22\u009f\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\7\27\u00ae\n\27\f\27\16\27\u00b1\13\27\5\27\u00b3\n\27\3\27"+
		"\3\27\3\30\3\30\5\30\u00b9\n\30\3\30\3\30\3\30\2\4\b\22\31\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\5\3\2\5\6\3\2\7\b\3\2\f\23\u00c1"+
		"\2\60\3\2\2\2\48\3\2\2\2\6:\3\2\2\2\bA\3\2\2\2\nT\3\2\2\2\fV\3\2\2\2\16"+
		"Z\3\2\2\2\20j\3\2\2\2\22o\3\2\2\2\24~\3\2\2\2\26\u0082\3\2\2\2\30\u0084"+
		"\3\2\2\2\32\u0086\3\2\2\2\34\u0089\3\2\2\2\36\u008f\3\2\2\2 \u0096\3\2"+
		"\2\2\"\u009e\3\2\2\2$\u00a0\3\2\2\2&\u00a2\3\2\2\2(\u00a4\3\2\2\2*\u00a6"+
		"\3\2\2\2,\u00a8\3\2\2\2.\u00b8\3\2\2\2\60\61\5\4\3\2\61\62\7\2\2\3\62"+
		"\3\3\2\2\2\639\5\b\5\2\649\5\16\b\2\659\5\32\16\2\669\5\36\20\2\679\5"+
		"\6\4\28\63\3\2\2\28\64\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29\5"+
		"\3\2\2\2:;\7\3\2\2;<\5\4\3\2<=\7\4\2\2=\7\3\2\2\2>?\b\5\1\2?B\5\16\b\2"+
		"@B\5\f\7\2A>\3\2\2\2A@\3\2\2\2BI\3\2\2\2CD\f\5\2\2DE\5\n\6\2EF\5\b\5\6"+
		"FH\3\2\2\2GC\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\t\3\2\2\2KI\3\2\2"+
		"\2LN\7\26\2\2MO\7\33\2\2NM\3\2\2\2NO\3\2\2\2OU\3\2\2\2PR\7\36\2\2QS\7"+
		"\33\2\2RQ\3\2\2\2RS\3\2\2\2SU\3\2\2\2TL\3\2\2\2TP\3\2\2\2U\13\3\2\2\2"+
		"VW\7\3\2\2WX\5\b\5\2XY\7\4\2\2Y\r\3\2\2\2Z[\5.\30\2[^\5\20\t\2\\_\5.\30"+
		"\2]_\5\22\n\2^\\\3\2\2\2^]\3\2\2\2_\17\3\2\2\2`k\7 \2\2ak\7!\2\2bk\7\""+
		"\2\2ck\7#\2\2dk\7$\2\2ek\7%\2\2fh\7\33\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2"+
		"\2ik\7\32\2\2j`\3\2\2\2ja\3\2\2\2jb\3\2\2\2jc\3\2\2\2jd\3\2\2\2je\3\2"+
		"\2\2jg\3\2\2\2k\21\3\2\2\2lm\b\n\1\2mp\5\"\22\2np\5\24\13\2ol\3\2\2\2"+
		"on\3\2\2\2p{\3\2\2\2qr\f\6\2\2rs\5\30\r\2st\5\22\n\7tz\3\2\2\2uv\f\5\2"+
		"\2vw\5\26\f\2wx\5\22\n\6xz\3\2\2\2yq\3\2\2\2yu\3\2\2\2z}\3\2\2\2{y\3\2"+
		"\2\2{|\3\2\2\2|\23\3\2\2\2}{\3\2\2\2~\177\7\3\2\2\177\u0080\5\22\n\2\u0080"+
		"\u0081\7\4\2\2\u0081\25\3\2\2\2\u0082\u0083\t\2\2\2\u0083\27\3\2\2\2\u0084"+
		"\u0085\t\3\2\2\u0085\31\3\2\2\2\u0086\u0087\5.\30\2\u0087\u0088\5\34\17"+
		"\2\u0088\33\3\2\2\2\u0089\u008b\7\31\2\2\u008a\u008c\7\33\2\2\u008b\u008a"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\34\2\2"+
		"\u008e\35\3\2\2\2\u008f\u0090\5.\30\2\u0090\u0091\5 \21\2\u0091\u0092"+
		"\5\"\22\2\u0092\u0093\7\26\2\2\u0093\u0094\5\"\22\2\u0094\37\3\2\2\2\u0095"+
		"\u0097\7\33\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3"+
		"\2\2\2\u0098\u0099\7\27\2\2\u0099!\3\2\2\2\u009a\u009f\5$\23\2\u009b\u009f"+
		"\5&\24\2\u009c\u009f\5(\25\2\u009d\u009f\5*\26\2\u009e\u009a\3\2\2\2\u009e"+
		"\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f#\3\2\2\2"+
		"\u00a0\u00a1\7\13\2\2\u00a1%\3\2\2\2\u00a2\u00a3\t\4\2\2\u00a3\'\3\2\2"+
		"\2\u00a4\u00a5\7\24\2\2\u00a5)\3\2\2\2\u00a6\u00a7\7\25\2\2\u00a7+\3\2"+
		"\2\2\u00a8\u00a9\7&\2\2\u00a9\u00b2\7\3\2\2\u00aa\u00af\5\22\n\2\u00ab"+
		"\u00ac\7\t\2\2\u00ac\u00ae\5\22\n\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3"+
		"\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b5\7\4\2\2\u00b5-\3\2\2\2\u00b6\u00b7\7&\2\2\u00b7\u00b9"+
		"\7\n\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\7&\2\2\u00bb/\3\2\2\2\248AINRT^gjoy{\u008b\u0096\u009e\u00af\u00b2"+
		"\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}