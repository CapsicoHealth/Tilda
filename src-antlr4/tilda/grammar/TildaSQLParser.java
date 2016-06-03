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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NUMERIC_LITERAL=8, 
		TIMESTAMP_LITERAL=9, CURRENT_TIMESTAMP=10, TIMESTAMP_YESTERDAY=11, TIMESTAMP_YESTERDAY_LAST=12, 
		TIMESTAMP_TODAY=13, TIMESTAMP_TODAY_LAST=14, TIMESTAMP_TOMORROW=15, TIMESTAMP_TOMORROW_LAST=16, 
		STRING_LITERAL=17, BIND_PARAMETER=18, K_AND=19, K_BETWEEN=20, K_IN=21, 
		K_IS=22, K_LIKE=23, K_NOT=24, K_NULL=25, K_ON=26, K_OR=27, K_REGEXP=28, 
		K_LT=29, K_LTE=30, K_GT=31, K_GTE=32, K_EQ=33, K_NEQ=34, K_DIV=35, K_MINUS=36, 
		IDENTIFIER=37, PLUS_MINUS=38, YEAR_LITERAL=39, MONTH_LITERAL=40, DAY_LITERAL=41, 
		HOUR_LITERAL_24=42, MINUTE_LITERAL=43, SECOND_LITERAL=44, HOUR_LITERAL_12=45, 
		QUOTE=46, SPACES=47, UNEXPECTED_CHAR=48;
	public static final int
		RULE_where = 0, RULE_expr = 1, RULE_expr_sub = 2, RULE_bool_expr = 3, 
		RULE_bool_op = 4, RULE_bool_expr_sub = 5, RULE_bin_expr = 6, RULE_bin_expr_lhs = 7, 
		RULE_value_list = 8, RULE_bin_op = 9, RULE_arithmetic_expr_base = 10, 
		RULE_arithmetic_expr = 11, RULE_arithmetic_expr_sub = 12, RULE_arithmetic_op_add = 13, 
		RULE_arithmetic_op_mul = 14, RULE_isnull_expr = 15, RULE_isnull_op = 16, 
		RULE_between_expr = 17, RULE_between_op = 18, RULE_value = 19, RULE_numeric_literal = 20, 
		RULE_timestamp_literal = 21, RULE_string_literal = 22, RULE_bind_parameter = 23, 
		RULE_function = 24, RULE_column = 25;
	public static final String[] ruleNames = {
		"where", "expr", "expr_sub", "bool_expr", "bool_op", "bool_expr_sub", 
		"bin_expr", "bin_expr_lhs", "value_list", "bin_op", "arithmetic_expr_base", 
		"arithmetic_expr", "arithmetic_expr_sub", "arithmetic_op_add", "arithmetic_op_mul", 
		"isnull_expr", "isnull_op", "between_expr", "between_op", "value", "numeric_literal", 
		"timestamp_literal", "string_literal", "bind_parameter", "function", "column"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'||'", "','", "'*'", "'.'", null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "'<'", null, "'>'", null, null, null, 
		"'/'", "'-'", null, null, null, null, null, null, null, null, null, "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "NUMERIC_LITERAL", "TIMESTAMP_LITERAL", 
		"CURRENT_TIMESTAMP", "TIMESTAMP_YESTERDAY", "TIMESTAMP_YESTERDAY_LAST", 
		"TIMESTAMP_TODAY", "TIMESTAMP_TODAY_LAST", "TIMESTAMP_TOMORROW", "TIMESTAMP_TOMORROW_LAST", 
		"STRING_LITERAL", "BIND_PARAMETER", "K_AND", "K_BETWEEN", "K_IN", "K_IS", 
		"K_LIKE", "K_NOT", "K_NULL", "K_ON", "K_OR", "K_REGEXP", "K_LT", "K_LTE", 
		"K_GT", "K_GTE", "K_EQ", "K_NEQ", "K_DIV", "K_MINUS", "IDENTIFIER", "PLUS_MINUS", 
		"YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", "MINUTE_LITERAL", 
		"SECOND_LITERAL", "HOUR_LITERAL_12", "QUOTE", "SPACES", "UNEXPECTED_CHAR"
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
			setState(52);
			expr();
			setState(53);
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
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				bool_expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				bin_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				isnull_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				between_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(59);
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
			setState(62);
			match(T__0);
			setState(63);
			expr();
			setState(64);
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
			setState(69);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(67);
				((Bool_exprContext)_localctx).s_expr = bin_expr();
				}
				break;
			case T__0:
				{
				setState(68);
				bool_expr_sub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(77);
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
					setState(71);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(72);
					((Bool_exprContext)_localctx).op = bool_op();
					setState(73);
					((Bool_exprContext)_localctx).r_expr = bool_expr(4);
					}
					} 
				}
				setState(79);
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
			setState(88);
			switch (_input.LA(1)) {
			case K_AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(K_AND);
				setState(82);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(81);
					match(K_NOT);
					}
				}

				}
				break;
			case K_OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(K_OR);
				setState(86);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(85);
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
			setState(90);
			match(T__0);
			setState(91);
			bool_expr(0);
			setState(92);
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
		public Bin_expr_lhsContext bin_expr_lhs() {
			return getRuleContext(Bin_expr_lhsContext.class,0);
		}
		public Bin_opContext bin_op() {
			return getRuleContext(Bin_opContext.class,0);
		}
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public Arithmetic_expr_baseContext arithmetic_expr_base() {
			return getRuleContext(Arithmetic_expr_baseContext.class,0);
		}
		public TerminalNode K_IN() { return getToken(TildaSQLParser.K_IN, 0); }
		public Value_listContext value_list() {
			return getRuleContext(Value_listContext.class,0);
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
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				bin_expr_lhs();
				setState(95);
				bin_op();
				setState(98);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(96);
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
					setState(97);
					arithmetic_expr_base();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				bin_expr_lhs();
				setState(101);
				match(K_IN);
				setState(102);
				value_list();
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

	public static class Bin_expr_lhsContext extends ParserRuleContext {
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public Bin_expr_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_expr_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBin_expr_lhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBin_expr_lhs(this);
		}
	}

	public final Bin_expr_lhsContext bin_expr_lhs() throws RecognitionException {
		Bin_expr_lhsContext _localctx = new Bin_expr_lhsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bin_expr_lhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			column();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(107);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(108);
				column();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Value_listContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public Value_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValue_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValue_list(this);
		}
	}

	public final Value_listContext value_list() throws RecognitionException {
		Value_listContext _localctx = new Value_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__0);
			setState(115);
			value();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(116);
				match(T__4);
				setState(117);
				value();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
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
		enterRule(_localctx, 18, RULE_bin_op);
		int _la;
		try {
			setState(135);
			switch (_input.LA(1)) {
			case K_LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(K_LT);
				}
				break;
			case K_LTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(K_LTE);
				}
				break;
			case K_GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(K_GT);
				}
				break;
			case K_GTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				match(K_GTE);
				}
				break;
			case K_EQ:
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				match(K_EQ);
				}
				break;
			case K_NEQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				match(K_NEQ);
				}
				break;
			case K_LIKE:
			case K_NOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(132);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(131);
					match(K_NOT);
					}
				}

				setState(134);
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

	public static class Arithmetic_expr_baseContext extends ParserRuleContext {
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public Arithmetic_expr_baseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expr_base; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArithmetic_expr_base(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArithmetic_expr_base(this);
		}
	}

	public final Arithmetic_expr_baseContext arithmetic_expr_base() throws RecognitionException {
		Arithmetic_expr_baseContext _localctx = new Arithmetic_expr_baseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arithmetic_expr_base);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			arithmetic_expr(0);
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

	public static class Arithmetic_exprContext extends ParserRuleContext {
		public Arithmetic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expr; }
	 
		public Arithmetic_exprContext() { }
		public void copyFrom(Arithmetic_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArithmeticExprContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public Arithmetic_op_mulContext arithmetic_op_mul() {
			return getRuleContext(Arithmetic_op_mulContext.class,0);
		}
		public Arithmetic_op_addContext arithmetic_op_add() {
			return getRuleContext(Arithmetic_op_addContext.class,0);
		}
		public ArithmeticExprContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArithmeticExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArithmeticExpr(this);
		}
	}
	public static class ArithmeticExprSubContext extends Arithmetic_exprContext {
		public Arithmetic_expr_subContext arithmetic_expr_sub() {
			return getRuleContext(Arithmetic_expr_subContext.class,0);
		}
		public ArithmeticExprSubContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArithmeticExprSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArithmeticExprSub(this);
		}
	}
	public static class ArithmeticExprValContext extends Arithmetic_exprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ArithmeticExprValContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArithmeticExprVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArithmeticExprVal(this);
		}
	}

	public final Arithmetic_exprContext arithmetic_expr() throws RecognitionException {
		return arithmetic_expr(0);
	}

	private Arithmetic_exprContext arithmetic_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_exprContext _localctx = new Arithmetic_exprContext(_ctx, _parentState);
		Arithmetic_exprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_arithmetic_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
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
				_localctx = new ArithmeticExprValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(140);
				value();
				}
				break;
			case T__0:
				{
				_localctx = new ArithmeticExprSubContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				arithmetic_expr_sub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(152);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExprContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(144);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(145);
						arithmetic_op_mul();
						setState(146);
						arithmetic_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExprContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(148);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(149);
						arithmetic_op_add();
						setState(150);
						arithmetic_expr(4);
						}
						break;
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class Arithmetic_expr_subContext extends ParserRuleContext {
		public Arithmetic_exprContext s_expr;
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public Arithmetic_expr_subContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expr_sub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterArithmetic_expr_sub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitArithmetic_expr_sub(this);
		}
	}

	public final Arithmetic_expr_subContext arithmetic_expr_sub() throws RecognitionException {
		Arithmetic_expr_subContext _localctx = new Arithmetic_expr_subContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arithmetic_expr_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__0);
			setState(158);
			((Arithmetic_expr_subContext)_localctx).s_expr = arithmetic_expr(0);
			setState(159);
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
		enterRule(_localctx, 26, RULE_arithmetic_op_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==K_MINUS) ) {
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
		enterRule(_localctx, 28, RULE_arithmetic_op_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==K_DIV) ) {
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
		enterRule(_localctx, 30, RULE_isnull_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			column();
			setState(166);
			isnull_op();
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
		enterRule(_localctx, 32, RULE_isnull_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(K_IS);
			setState(170);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(169);
				match(K_NOT);
				}
			}

			setState(172);
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
		enterRule(_localctx, 34, RULE_between_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((Between_exprContext)_localctx).col = column();
			setState(175);
			((Between_exprContext)_localctx).op = between_op();
			setState(176);
			((Between_exprContext)_localctx).val1 = value();
			setState(177);
			match(K_AND);
			setState(178);
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
		enterRule(_localctx, 36, RULE_between_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(180);
				match(K_NOT);
				}
			}

			setState(183);
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
		enterRule(_localctx, 38, RULE_value);
		try {
			setState(189);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				_localctx = new ValueNumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
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
				setState(186);
				timestamp_literal();
				}
				break;
			case STRING_LITERAL:
				_localctx = new ValueStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				string_literal();
				}
				break;
			case BIND_PARAMETER:
				_localctx = new ValueBindParamContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
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
		enterRule(_localctx, 40, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
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
		enterRule(_localctx, 42, RULE_timestamp_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
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
		enterRule(_localctx, 44, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
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
		enterRule(_localctx, 46, RULE_bind_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
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
		public List<Arithmetic_expr_baseContext> arithmetic_expr_base() {
			return getRuleContexts(Arithmetic_expr_baseContext.class);
		}
		public Arithmetic_expr_baseContext arithmetic_expr_base(int i) {
			return getRuleContext(Arithmetic_expr_baseContext.class,i);
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
		enterRule(_localctx, 48, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(IDENTIFIER);
			setState(200);
			match(T__0);
			setState(209);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NUMERIC_LITERAL) | (1L << TIMESTAMP_LITERAL) | (1L << CURRENT_TIMESTAMP) | (1L << TIMESTAMP_YESTERDAY) | (1L << TIMESTAMP_YESTERDAY_LAST) | (1L << TIMESTAMP_TODAY) | (1L << TIMESTAMP_TODAY_LAST) | (1L << TIMESTAMP_TOMORROW) | (1L << TIMESTAMP_TOMORROW_LAST) | (1L << STRING_LITERAL) | (1L << BIND_PARAMETER))) != 0)) {
				{
				setState(201);
				arithmetic_expr_base();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(202);
					match(T__4);
					setState(203);
					arithmetic_expr_base();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(211);
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
		enterRule(_localctx, 50, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(213);
				match(IDENTIFIER);
				setState(214);
				match(T__6);
				}
				break;
			}
			setState(217);
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
		case 11:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
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
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u00de\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3?\n\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\5\5H\n\5\3\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5"+
		"\3\6\3\6\5\6U\n\6\3\6\3\6\5\6Y\n\6\5\6[\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\5\be\n\b\3\b\3\b\3\b\3\b\5\bk\n\b\3\t\3\t\3\t\7\tp\n\t\f\t\16\t"+
		"s\13\t\3\n\3\n\3\n\3\n\7\ny\n\n\f\n\16\n|\13\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0087\n\13\3\13\5\13\u008a\n\13\3\f\3\f\3\r"+
		"\3\r\3\r\5\r\u0091\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u009b\n\r\f"+
		"\r\16\r\u009e\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\3\22\3\22\5\22\u00ad\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\5\24\u00b8\n\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00c0\n\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\7\32\u00cf"+
		"\n\32\f\32\16\32\u00d2\13\32\5\32\u00d4\n\32\3\32\3\32\3\33\3\33\5\33"+
		"\u00da\n\33\3\33\3\33\3\33\2\4\b\30\34\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\2\6\3\2\5\6\4\2\5\5&&\4\2\b\b%%\3\2\13\22\u00e2"+
		"\2\66\3\2\2\2\4>\3\2\2\2\6@\3\2\2\2\bG\3\2\2\2\nZ\3\2\2\2\f\\\3\2\2\2"+
		"\16j\3\2\2\2\20l\3\2\2\2\22t\3\2\2\2\24\u0089\3\2\2\2\26\u008b\3\2\2\2"+
		"\30\u0090\3\2\2\2\32\u009f\3\2\2\2\34\u00a3\3\2\2\2\36\u00a5\3\2\2\2 "+
		"\u00a7\3\2\2\2\"\u00aa\3\2\2\2$\u00b0\3\2\2\2&\u00b7\3\2\2\2(\u00bf\3"+
		"\2\2\2*\u00c1\3\2\2\2,\u00c3\3\2\2\2.\u00c5\3\2\2\2\60\u00c7\3\2\2\2\62"+
		"\u00c9\3\2\2\2\64\u00d9\3\2\2\2\66\67\5\4\3\2\678\7\2\2\38\3\3\2\2\29"+
		"?\5\b\5\2:?\5\16\b\2;?\5 \21\2<?\5$\23\2=?\5\6\4\2>9\3\2\2\2>:\3\2\2\2"+
		">;\3\2\2\2><\3\2\2\2>=\3\2\2\2?\5\3\2\2\2@A\7\3\2\2AB\5\4\3\2BC\7\4\2"+
		"\2C\7\3\2\2\2DE\b\5\1\2EH\5\16\b\2FH\5\f\7\2GD\3\2\2\2GF\3\2\2\2HO\3\2"+
		"\2\2IJ\f\5\2\2JK\5\n\6\2KL\5\b\5\6LN\3\2\2\2MI\3\2\2\2NQ\3\2\2\2OM\3\2"+
		"\2\2OP\3\2\2\2P\t\3\2\2\2QO\3\2\2\2RT\7\25\2\2SU\7\32\2\2TS\3\2\2\2TU"+
		"\3\2\2\2U[\3\2\2\2VX\7\35\2\2WY\7\32\2\2XW\3\2\2\2XY\3\2\2\2Y[\3\2\2\2"+
		"ZR\3\2\2\2ZV\3\2\2\2[\13\3\2\2\2\\]\7\3\2\2]^\5\b\5\2^_\7\4\2\2_\r\3\2"+
		"\2\2`a\5\20\t\2ad\5\24\13\2be\5\64\33\2ce\5\26\f\2db\3\2\2\2dc\3\2\2\2"+
		"ek\3\2\2\2fg\5\20\t\2gh\7\27\2\2hi\5\22\n\2ik\3\2\2\2j`\3\2\2\2jf\3\2"+
		"\2\2k\17\3\2\2\2lq\5\64\33\2mn\t\2\2\2np\5\64\33\2om\3\2\2\2ps\3\2\2\2"+
		"qo\3\2\2\2qr\3\2\2\2r\21\3\2\2\2sq\3\2\2\2tu\7\3\2\2uz\5(\25\2vw\7\7\2"+
		"\2wy\5(\25\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2"+
		"\2}~\7\4\2\2~\23\3\2\2\2\177\u008a\7\37\2\2\u0080\u008a\7 \2\2\u0081\u008a"+
		"\7!\2\2\u0082\u008a\7\"\2\2\u0083\u008a\7#\2\2\u0084\u008a\7$\2\2\u0085"+
		"\u0087\7\32\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3"+
		"\2\2\2\u0088\u008a\7\31\2\2\u0089\177\3\2\2\2\u0089\u0080\3\2\2\2\u0089"+
		"\u0081\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0083\3\2\2\2\u0089\u0084\3\2"+
		"\2\2\u0089\u0086\3\2\2\2\u008a\25\3\2\2\2\u008b\u008c\5\30\r\2\u008c\27"+
		"\3\2\2\2\u008d\u008e\b\r\1\2\u008e\u0091\5(\25\2\u008f\u0091\5\32\16\2"+
		"\u0090\u008d\3\2\2\2\u0090\u008f\3\2\2\2\u0091\u009c\3\2\2\2\u0092\u0093"+
		"\f\6\2\2\u0093\u0094\5\36\20\2\u0094\u0095\5\30\r\7\u0095\u009b\3\2\2"+
		"\2\u0096\u0097\f\5\2\2\u0097\u0098\5\34\17\2\u0098\u0099\5\30\r\6\u0099"+
		"\u009b\3\2\2\2\u009a\u0092\3\2\2\2\u009a\u0096\3\2\2\2\u009b\u009e\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\31\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a0\7\3\2\2\u00a0\u00a1\5\30\r\2\u00a1\u00a2\7\4\2\2"+
		"\u00a2\33\3\2\2\2\u00a3\u00a4\t\3\2\2\u00a4\35\3\2\2\2\u00a5\u00a6\t\4"+
		"\2\2\u00a6\37\3\2\2\2\u00a7\u00a8\5\64\33\2\u00a8\u00a9\5\"\22\2\u00a9"+
		"!\3\2\2\2\u00aa\u00ac\7\30\2\2\u00ab\u00ad\7\32\2\2\u00ac\u00ab\3\2\2"+
		"\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\33\2\2\u00af"+
		"#\3\2\2\2\u00b0\u00b1\5\64\33\2\u00b1\u00b2\5&\24\2\u00b2\u00b3\5(\25"+
		"\2\u00b3\u00b4\7\25\2\2\u00b4\u00b5\5(\25\2\u00b5%\3\2\2\2\u00b6\u00b8"+
		"\7\32\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2"+
		"\u00b9\u00ba\7\26\2\2\u00ba\'\3\2\2\2\u00bb\u00c0\5*\26\2\u00bc\u00c0"+
		"\5,\27\2\u00bd\u00c0\5.\30\2\u00be\u00c0\5\60\31\2\u00bf\u00bb\3\2\2\2"+
		"\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0)\3"+
		"\2\2\2\u00c1\u00c2\7\n\2\2\u00c2+\3\2\2\2\u00c3\u00c4\t\5\2\2\u00c4-\3"+
		"\2\2\2\u00c5\u00c6\7\23\2\2\u00c6/\3\2\2\2\u00c7\u00c8\7\24\2\2\u00c8"+
		"\61\3\2\2\2\u00c9\u00ca\7\'\2\2\u00ca\u00d3\7\3\2\2\u00cb\u00d0\5\26\f"+
		"\2\u00cc\u00cd\7\7\2\2\u00cd\u00cf\5\26\f\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d6\7\4\2\2\u00d6\63\3\2\2\2\u00d7\u00d8\7\'\2"+
		"\2\u00d8\u00da\7\t\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00db\u00dc\7\'\2\2\u00dc\65\3\2\2\2\27>GOTXZdjqz\u0086\u0089"+
		"\u0090\u009a\u009c\u00ac\u00b7\u00bf\u00d0\u00d3\u00d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}