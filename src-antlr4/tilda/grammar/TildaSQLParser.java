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
		TIMESTAMP_LITERAL=10, CURRENT_TIMESTAMP=11, TIMESTAMP_RELATIVE=12, STRING_LITERAL=13, 
		BIND_PARAMETER=14, K_AND=15, K_BETWEEN=16, K_IN=17, K_IS=18, K_LIKE=19, 
		K_NOT=20, K_NULL=21, K_ON=22, K_OR=23, K_REGEXP=24, K_LT=25, K_LTE=26, 
		K_GT=27, K_GTE=28, K_EQ=29, K_NEQ=30, IDENTIFIER=31, YEAR_LITERAL=32, 
		MONTH_LITERAL=33, DAY_LITERAL=34, HOUR_LITERAL_24=35, MINUTE_LITERAL=36, 
		SECOND_LITERAL=37, HOUR_LITERAL_12=38, SPACES=39, UNEXPECTED_CHAR=40;
	public static final int
		RULE_where = 0, RULE_expr = 1, RULE_expr_sub = 2, RULE_bool_expr = 3, 
		RULE_bool_op = 4, RULE_bool_expr_sub = 5, RULE_bin_expr = 6, RULE_bin_op = 7, 
		RULE_aryth_expr = 8, RULE_aryth_expr_sub = 9, RULE_aryth_op_add = 10, 
		RULE_aryth_op_mul = 11, RULE_isnull_expr = 12, RULE_isnull_op = 13, RULE_between_expr = 14, 
		RULE_between_op = 15, RULE_value = 16, RULE_function = 17, RULE_column = 18;
	public static final String[] ruleNames = {
		"where", "expr", "expr_sub", "bool_expr", "bool_op", "bool_expr_sub", 
		"bin_expr", "bin_op", "aryth_expr", "aryth_expr_sub", "aryth_op_add", 
		"aryth_op_mul", "isnull_expr", "isnull_op", "between_expr", "between_op", 
		"value", "function", "column"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "','", "'.'", null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'<'", null, "'>'", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "NUMERIC_LITERAL", 
		"TIMESTAMP_LITERAL", "CURRENT_TIMESTAMP", "TIMESTAMP_RELATIVE", "STRING_LITERAL", 
		"BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", "K_IS", "K_LIKE", "K_NOT", 
		"K_NULL", "K_ON", "K_OR", "K_REGEXP", "K_LT", "K_LTE", "K_GT", "K_GTE", 
		"K_EQ", "K_NEQ", "IDENTIFIER", "YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", 
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
			setState(38);
			expr();
			setState(39);
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
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				bool_expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				bin_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				isnull_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				between_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
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
			setState(48);
			match(T__0);
			setState(49);
			expr();
			setState(50);
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
			setState(55);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(53);
				((Bool_exprContext)_localctx).s_expr = bin_expr();
				}
				break;
			case T__0:
				{
				setState(54);
				bool_expr_sub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
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
					setState(57);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(58);
					((Bool_exprContext)_localctx).op = bool_op();
					setState(59);
					((Bool_exprContext)_localctx).r_expr = bool_expr(4);
					}
					} 
				}
				setState(65);
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
			setState(74);
			switch (_input.LA(1)) {
			case K_AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(K_AND);
				setState(68);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(67);
					match(K_NOT);
					}
				}

				}
				break;
			case K_OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(K_OR);
				setState(72);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(71);
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
			setState(76);
			match(T__0);
			setState(77);
			bool_expr(0);
			setState(78);
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
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
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
			setState(80);
			column();
			setState(81);
			bin_op();
			setState(82);
			aryth_expr(0);
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
			setState(94);
			switch (_input.LA(1)) {
			case K_LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(K_LT);
				}
				break;
			case K_LTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(K_LTE);
				}
				break;
			case K_GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				match(K_GT);
				}
				break;
			case K_GTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				match(K_GTE);
				}
				break;
			case K_EQ:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				match(K_EQ);
				}
				break;
			case K_NEQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
				match(K_NEQ);
				}
				break;
			case K_LIKE:
			case K_NOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(91);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(90);
					match(K_NOT);
					}
				}

				setState(93);
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
	public static class ArythExprAddExprContext extends Aryth_exprContext {
		public Aryth_exprContext l_expr;
		public Aryth_op_mulContext op;
		public Aryth_exprContext r_expr;
		public List<Aryth_exprContext> aryth_expr() {
			return getRuleContexts(Aryth_exprContext.class);
		}
		public Aryth_exprContext aryth_expr(int i) {
			return getRuleContext(Aryth_exprContext.class,i);
		}
		public Aryth_op_mulContext aryth_op_mul() {
			return getRuleContext(Aryth_op_mulContext.class,0);
		}
		public ArythExprAddExprContext(Aryth_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArythExprAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArythExprAddExpr(this);
		}
	}
	public static class ArythExprSubContext extends Aryth_exprContext {
		public Aryth_expr_subContext s_expr;
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
		public ValueContext val;
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
	public static class ArythExprMultExprContext extends Aryth_exprContext {
		public Aryth_exprContext l_expr;
		public Aryth_op_addContext op;
		public Aryth_exprContext r_expr;
		public List<Aryth_exprContext> aryth_expr() {
			return getRuleContexts(Aryth_exprContext.class);
		}
		public Aryth_exprContext aryth_expr(int i) {
			return getRuleContext(Aryth_exprContext.class,i);
		}
		public Aryth_op_addContext aryth_op_add() {
			return getRuleContext(Aryth_op_addContext.class,0);
		}
		public ArythExprMultExprContext(Aryth_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArythExprMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArythExprMultExpr(this);
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
			setState(99);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
			case TIMESTAMP_LITERAL:
			case STRING_LITERAL:
			case BIND_PARAMETER:
			case K_NULL:
			case IDENTIFIER:
				{
				_localctx = new ArythExprValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(97);
				((ArythExprValContext)_localctx).val = value();
				}
				break;
			case T__0:
				{
				_localctx = new ArythExprSubContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				((ArythExprSubContext)_localctx).s_expr = aryth_expr_sub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ArythExprAddExprContext(new Aryth_exprContext(_parentctx, _parentState));
						((ArythExprAddExprContext)_localctx).l_expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aryth_expr);
						setState(101);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(102);
						((ArythExprAddExprContext)_localctx).op = aryth_op_mul();
						setState(103);
						((ArythExprAddExprContext)_localctx).r_expr = aryth_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ArythExprMultExprContext(new Aryth_exprContext(_parentctx, _parentState));
						((ArythExprMultExprContext)_localctx).l_expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aryth_expr);
						setState(105);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(106);
						((ArythExprMultExprContext)_localctx).op = aryth_op_add();
						setState(107);
						((ArythExprMultExprContext)_localctx).r_expr = aryth_expr(4);
						}
						break;
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
			setState(114);
			match(T__0);
			setState(115);
			((Aryth_expr_subContext)_localctx).s_expr = aryth_expr(0);
			setState(116);
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
			setState(118);
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
			setState(120);
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
			setState(122);
			((Isnull_exprContext)_localctx).col = column();
			setState(123);
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
			setState(125);
			match(K_IS);
			setState(127);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(126);
				match(K_NOT);
				}
			}

			setState(129);
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
			setState(131);
			((Between_exprContext)_localctx).col = column();
			setState(132);
			((Between_exprContext)_localctx).op = between_op();
			setState(133);
			((Between_exprContext)_localctx).val1 = value();
			setState(134);
			match(K_AND);
			setState(135);
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
			setState(138);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(137);
				match(K_NOT);
				}
			}

			setState(140);
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
	public static class ValueLiteralTimestampContext extends ValueContext {
		public Token tim;
		public TerminalNode TIMESTAMP_LITERAL() { return getToken(TildaSQLParser.TIMESTAMP_LITERAL, 0); }
		public ValueLiteralTimestampContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueLiteralTimestamp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueLiteralTimestamp(this);
		}
	}
	public static class ValueBindContext extends ValueContext {
		public Token bnd;
		public TerminalNode BIND_PARAMETER() { return getToken(TildaSQLParser.BIND_PARAMETER, 0); }
		public ValueBindContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueBind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueBind(this);
		}
	}
	public static class ValueLiteralNumericContext extends ValueContext {
		public Token num;
		public TerminalNode NUMERIC_LITERAL() { return getToken(TildaSQLParser.NUMERIC_LITERAL, 0); }
		public ValueLiteralNumericContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueLiteralNumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueLiteralNumeric(this);
		}
	}
	public static class ValueLiteralStringContext extends ValueContext {
		public Token str;
		public TerminalNode STRING_LITERAL() { return getToken(TildaSQLParser.STRING_LITERAL, 0); }
		public ValueLiteralStringContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueLiteralString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueLiteralString(this);
		}
	}
	public static class ValueLiteralNullContext extends ValueContext {
		public Token nul;
		public TerminalNode K_NULL() { return getToken(TildaSQLParser.K_NULL, 0); }
		public ValueLiteralNullContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueLiteralNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueLiteralNull(this);
		}
	}
	public static class ValueColumnContext extends ValueContext {
		public ColumnContext col;
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public ValueColumnContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValueColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValueColumn(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value);
		try {
			setState(148);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				_localctx = new ValueLiteralNumericContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				((ValueLiteralNumericContext)_localctx).num = match(NUMERIC_LITERAL);
				}
				break;
			case TIMESTAMP_LITERAL:
				_localctx = new ValueLiteralTimestampContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				((ValueLiteralTimestampContext)_localctx).tim = match(TIMESTAMP_LITERAL);
				}
				break;
			case STRING_LITERAL:
				_localctx = new ValueLiteralStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				((ValueLiteralStringContext)_localctx).str = match(STRING_LITERAL);
				}
				break;
			case K_NULL:
				_localctx = new ValueLiteralNullContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				((ValueLiteralNullContext)_localctx).nul = match(K_NULL);
				}
				break;
			case BIND_PARAMETER:
				_localctx = new ValueBindContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				((ValueBindContext)_localctx).bnd = match(BIND_PARAMETER);
				}
				break;
			case IDENTIFIER:
				_localctx = new ValueColumnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				((ValueColumnContext)_localctx).col = column();
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
		enterRule(_localctx, 34, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(IDENTIFIER);
			setState(151);
			match(T__0);
			setState(160);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NUMERIC_LITERAL) | (1L << TIMESTAMP_LITERAL) | (1L << STRING_LITERAL) | (1L << BIND_PARAMETER) | (1L << K_NULL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(152);
				aryth_expr(0);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(153);
					match(T__6);
					setState(154);
					aryth_expr(0);
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(162);
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
		enterRule(_localctx, 36, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(164);
				match(IDENTIFIER);
				setState(165);
				match(T__7);
				}
				break;
			}
			setState(168);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00ad\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\5\5:\n\5\3\5\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13"+
		"\5\3\6\3\6\5\6G\n\6\3\6\3\6\5\6K\n\6\5\6M\n\6\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t^\n\t\3\t\5\ta\n\t\3\n\3\n\3\n"+
		"\5\nf\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\np\n\n\f\n\16\ns\13\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\5\17\u0082\n"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\5\21\u008d\n\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0097\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\7\23\u009e\n\23\f\23\16\23\u00a1\13\23\5\23\u00a3\n\23\3\23\3\23"+
		"\3\24\3\24\5\24\u00a9\n\24\3\24\3\24\3\24\2\4\b\22\25\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&\2\4\3\2\5\6\3\2\7\b\u00b6\2(\3\2\2\2\4\60\3"+
		"\2\2\2\6\62\3\2\2\2\b9\3\2\2\2\nL\3\2\2\2\fN\3\2\2\2\16R\3\2\2\2\20`\3"+
		"\2\2\2\22e\3\2\2\2\24t\3\2\2\2\26x\3\2\2\2\30z\3\2\2\2\32|\3\2\2\2\34"+
		"\177\3\2\2\2\36\u0085\3\2\2\2 \u008c\3\2\2\2\"\u0096\3\2\2\2$\u0098\3"+
		"\2\2\2&\u00a8\3\2\2\2()\5\4\3\2)*\7\2\2\3*\3\3\2\2\2+\61\5\b\5\2,\61\5"+
		"\16\b\2-\61\5\32\16\2.\61\5\36\20\2/\61\5\6\4\2\60+\3\2\2\2\60,\3\2\2"+
		"\2\60-\3\2\2\2\60.\3\2\2\2\60/\3\2\2\2\61\5\3\2\2\2\62\63\7\3\2\2\63\64"+
		"\5\4\3\2\64\65\7\4\2\2\65\7\3\2\2\2\66\67\b\5\1\2\67:\5\16\b\28:\5\f\7"+
		"\29\66\3\2\2\298\3\2\2\2:A\3\2\2\2;<\f\5\2\2<=\5\n\6\2=>\5\b\5\6>@\3\2"+
		"\2\2?;\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\t\3\2\2\2CA\3\2\2\2DF\7"+
		"\21\2\2EG\7\26\2\2FE\3\2\2\2FG\3\2\2\2GM\3\2\2\2HJ\7\31\2\2IK\7\26\2\2"+
		"JI\3\2\2\2JK\3\2\2\2KM\3\2\2\2LD\3\2\2\2LH\3\2\2\2M\13\3\2\2\2NO\7\3\2"+
		"\2OP\5\b\5\2PQ\7\4\2\2Q\r\3\2\2\2RS\5&\24\2ST\5\20\t\2TU\5\22\n\2U\17"+
		"\3\2\2\2Va\7\33\2\2Wa\7\34\2\2Xa\7\35\2\2Ya\7\36\2\2Za\7\37\2\2[a\7 \2"+
		"\2\\^\7\26\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_a\7\25\2\2`V\3\2\2\2`W\3"+
		"\2\2\2`X\3\2\2\2`Y\3\2\2\2`Z\3\2\2\2`[\3\2\2\2`]\3\2\2\2a\21\3\2\2\2b"+
		"c\b\n\1\2cf\5\"\22\2df\5\24\13\2eb\3\2\2\2ed\3\2\2\2fq\3\2\2\2gh\f\6\2"+
		"\2hi\5\30\r\2ij\5\22\n\7jp\3\2\2\2kl\f\5\2\2lm\5\26\f\2mn\5\22\n\6np\3"+
		"\2\2\2og\3\2\2\2ok\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\23\3\2\2\2s"+
		"q\3\2\2\2tu\7\3\2\2uv\5\22\n\2vw\7\4\2\2w\25\3\2\2\2xy\t\2\2\2y\27\3\2"+
		"\2\2z{\t\3\2\2{\31\3\2\2\2|}\5&\24\2}~\5\34\17\2~\33\3\2\2\2\177\u0081"+
		"\7\24\2\2\u0080\u0082\7\26\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\u0084\7\27\2\2\u0084\35\3\2\2\2\u0085\u0086"+
		"\5&\24\2\u0086\u0087\5 \21\2\u0087\u0088\5\"\22\2\u0088\u0089\7\21\2\2"+
		"\u0089\u008a\5\"\22\2\u008a\37\3\2\2\2\u008b\u008d\7\26\2\2\u008c\u008b"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\22\2\2"+
		"\u008f!\3\2\2\2\u0090\u0097\7\13\2\2\u0091\u0097\7\f\2\2\u0092\u0097\7"+
		"\17\2\2\u0093\u0097\7\27\2\2\u0094\u0097\7\20\2\2\u0095\u0097\5&\24\2"+
		"\u0096\u0090\3\2\2\2\u0096\u0091\3\2\2\2\u0096\u0092\3\2\2\2\u0096\u0093"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097#\3\2\2\2\u0098"+
		"\u0099\7!\2\2\u0099\u00a2\7\3\2\2\u009a\u009f\5\22\n\2\u009b\u009c\7\t"+
		"\2\2\u009c\u009e\5\22\n\2\u009d\u009b\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a2\u009a\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\7\4\2\2\u00a5%\3\2\2\2\u00a6\u00a7\7!\2\2\u00a7\u00a9\7\n\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\7!"+
		"\2\2\u00ab\'\3\2\2\2\23\609AFJL]`eoq\u0081\u008c\u0096\u009f\u00a2\u00a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}