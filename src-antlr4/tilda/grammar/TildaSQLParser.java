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
		NUMERIC_LITERAL=10, TIMESTAMP_LITERAL=11, CURRENT_TIMESTAMP=12, TIMESTAMP_YESTERDAY=13, 
		TIMESTAMP_YESTERDAY_LAST=14, TIMESTAMP_TODAY=15, TIMESTAMP_TODAY_LAST=16, 
		TIMESTAMP_TOMORROW=17, TIMESTAMP_TOMORROW_LAST=18, STRING_LITERAL=19, 
		BIND_PARAMETER=20, K_AND=21, K_BETWEEN=22, K_IN=23, K_IS=24, K_LIKE=25, 
		K_NOT=26, K_NULL=27, K_ON=28, K_OR=29, K_REGEXP=30, K_LT=31, K_LTE=32, 
		K_GT=33, K_GTE=34, K_EQ=35, K_NEQ=36, IDENTIFIER=37, PLUS_MINUS=38, YEAR_LITERAL=39, 
		MONTH_LITERAL=40, DAY_LITERAL=41, HOUR_LITERAL_24=42, MINUTE_LITERAL=43, 
		SECOND_LITERAL=44, HOUR_LITERAL_12=45, QUOTE=46, SPACES=47, UNEXPECTED_CHAR=48;
	public static final int
		RULE_where = 0, RULE_expr = 1, RULE_expr_sub = 2, RULE_bool_expr = 3, 
		RULE_bool_op = 4, RULE_bool_expr_sub = 5, RULE_bin_expr = 6, RULE_bin_expr_lhs = 7, 
		RULE_value_list = 8, RULE_bin_op = 9, RULE_aryth_expr = 10, RULE_aryth_expr_sub = 11, 
		RULE_aryth_op_add = 12, RULE_aryth_op_mul = 13, RULE_isnull_expr = 14, 
		RULE_isnull_op = 15, RULE_between_expr = 16, RULE_between_op = 17, RULE_value = 18, 
		RULE_numeric_literal = 19, RULE_timestamp_literal = 20, RULE_string_literal = 21, 
		RULE_bind_parameter = 22, RULE_function = 23, RULE_column = 24;
	public static final String[] ruleNames = {
		"where", "expr", "expr_sub", "bool_expr", "bool_op", "bool_expr_sub", 
		"bin_expr", "bin_expr_lhs", "value_list", "bin_op", "aryth_expr", "aryth_expr_sub", 
		"aryth_op_add", "aryth_op_mul", "isnull_expr", "isnull_op", "between_expr", 
		"between_op", "value", "numeric_literal", "timestamp_literal", "string_literal", 
		"bind_parameter", "function", "column"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'||'", "','", "'-'", "'*'", "'/'", "'.'", 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "'<'", null, "'>'", 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "NUMERIC_LITERAL", 
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
			setState(50);
			expr();
			setState(51);
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
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				bool_expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				bin_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				isnull_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				between_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
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
			setState(60);
			match(T__0);
			setState(61);
			expr();
			setState(62);
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
			setState(67);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(65);
				((Bool_exprContext)_localctx).s_expr = bin_expr();
				}
				break;
			case T__0:
				{
				setState(66);
				bool_expr_sub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
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
					setState(69);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(70);
					((Bool_exprContext)_localctx).op = bool_op();
					setState(71);
					((Bool_exprContext)_localctx).r_expr = bool_expr(4);
					}
					} 
				}
				setState(77);
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
			setState(86);
			switch (_input.LA(1)) {
			case K_AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(K_AND);
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
			case K_OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(K_OR);
				setState(84);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(83);
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
			setState(88);
			match(T__0);
			setState(89);
			bool_expr(0);
			setState(90);
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
		public Aryth_exprContext aryth_expr() {
			return getRuleContext(Aryth_exprContext.class,0);
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
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				bin_expr_lhs();
				setState(93);
				bin_op();
				setState(96);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(94);
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
					setState(95);
					aryth_expr(0);
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
				setState(98);
				bin_expr_lhs();
				setState(99);
				match(K_IN);
				setState(100);
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
			setState(104);
			column();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(105);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(106);
				column();
				}
				}
				setState(111);
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
			setState(112);
			match(T__0);
			setState(113);
			value();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(114);
				match(T__4);
				setState(115);
				value();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
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
			setState(133);
			switch (_input.LA(1)) {
			case K_LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(K_LT);
				}
				break;
			case K_LTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(K_LTE);
				}
				break;
			case K_GT:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(K_GT);
				}
				break;
			case K_GTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				match(K_GTE);
				}
				break;
			case K_EQ:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				match(K_EQ);
				}
				break;
			case K_NEQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				match(K_NEQ);
				}
				break;
			case K_LIKE:
			case K_NOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(130);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(129);
					match(K_NOT);
					}
				}

				setState(132);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_aryth_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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

				setState(136);
				value();
				}
				break;
			case T__0:
				{
				_localctx = new ArythExprSubContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				aryth_expr_sub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(148);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ArythExprContext(new Aryth_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aryth_expr);
						setState(140);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(141);
						aryth_op_mul();
						setState(142);
						aryth_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ArythExprContext(new Aryth_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_aryth_expr);
						setState(144);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(145);
						aryth_op_add();
						setState(146);
						aryth_expr(4);
						}
						break;
					}
					} 
				}
				setState(152);
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
		enterRule(_localctx, 22, RULE_aryth_expr_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__0);
			setState(154);
			((Aryth_expr_subContext)_localctx).s_expr = aryth_expr(0);
			setState(155);
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
		enterRule(_localctx, 24, RULE_aryth_op_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__5) ) {
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
		enterRule(_localctx, 26, RULE_aryth_op_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
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
		enterRule(_localctx, 28, RULE_isnull_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			column();
			setState(162);
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
		enterRule(_localctx, 30, RULE_isnull_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(K_IS);
			setState(166);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(165);
				match(K_NOT);
				}
			}

			setState(168);
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
		enterRule(_localctx, 32, RULE_between_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			((Between_exprContext)_localctx).col = column();
			setState(171);
			((Between_exprContext)_localctx).op = between_op();
			setState(172);
			((Between_exprContext)_localctx).val1 = value();
			setState(173);
			match(K_AND);
			setState(174);
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
		enterRule(_localctx, 34, RULE_between_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if (_la==K_NOT) {
				{
				setState(176);
				match(K_NOT);
				}
			}

			setState(179);
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
		enterRule(_localctx, 36, RULE_value);
		try {
			setState(185);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				_localctx = new ValueNumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
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
				setState(182);
				timestamp_literal();
				}
				break;
			case STRING_LITERAL:
				_localctx = new ValueStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				string_literal();
				}
				break;
			case BIND_PARAMETER:
				_localctx = new ValueBindParamContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
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
		enterRule(_localctx, 38, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
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
		enterRule(_localctx, 40, RULE_timestamp_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
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
		enterRule(_localctx, 42, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
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
		enterRule(_localctx, 44, RULE_bind_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
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
		enterRule(_localctx, 46, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(IDENTIFIER);
			setState(196);
			match(T__0);
			setState(205);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NUMERIC_LITERAL) | (1L << TIMESTAMP_LITERAL) | (1L << CURRENT_TIMESTAMP) | (1L << TIMESTAMP_YESTERDAY) | (1L << TIMESTAMP_YESTERDAY_LAST) | (1L << TIMESTAMP_TODAY) | (1L << TIMESTAMP_TODAY_LAST) | (1L << TIMESTAMP_TOMORROW) | (1L << TIMESTAMP_TOMORROW_LAST) | (1L << STRING_LITERAL) | (1L << BIND_PARAMETER))) != 0)) {
				{
				setState(197);
				aryth_expr(0);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(198);
					match(T__4);
					setState(199);
					aryth_expr(0);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(207);
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
		enterRule(_localctx, 48, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(209);
				match(IDENTIFIER);
				setState(210);
				match(T__8);
				}
				break;
			}
			setState(213);
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
		case 10:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u00da\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\5\5F\n\5\3\5\3\5\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\3\6\3\6\5"+
		"\6S\n\6\3\6\3\6\5\6W\n\6\5\6Y\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b"+
		"c\n\b\3\b\3\b\3\b\3\b\5\bi\n\b\3\t\3\t\3\t\7\tn\n\t\f\t\16\tq\13\t\3\n"+
		"\3\n\3\n\3\n\7\nw\n\n\f\n\16\nz\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0085\n\13\3\13\5\13\u0088\n\13\3\f\3\f\3\f\5\f\u008d"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\5\21\u00a9"+
		"\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\5\23\u00b4\n\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\5\24\u00bc\n\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\7\31\u00cb\n\31\f\31\16\31\u00ce\13"+
		"\31\5\31\u00d0\n\31\3\31\3\31\3\32\3\32\5\32\u00d6\n\32\3\32\3\32\3\32"+
		"\2\4\b\26\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\6"+
		"\3\2\5\6\4\2\5\5\b\b\3\2\t\n\3\2\r\24\u00df\2\64\3\2\2\2\4<\3\2\2\2\6"+
		">\3\2\2\2\bE\3\2\2\2\nX\3\2\2\2\fZ\3\2\2\2\16h\3\2\2\2\20j\3\2\2\2\22"+
		"r\3\2\2\2\24\u0087\3\2\2\2\26\u008c\3\2\2\2\30\u009b\3\2\2\2\32\u009f"+
		"\3\2\2\2\34\u00a1\3\2\2\2\36\u00a3\3\2\2\2 \u00a6\3\2\2\2\"\u00ac\3\2"+
		"\2\2$\u00b3\3\2\2\2&\u00bb\3\2\2\2(\u00bd\3\2\2\2*\u00bf\3\2\2\2,\u00c1"+
		"\3\2\2\2.\u00c3\3\2\2\2\60\u00c5\3\2\2\2\62\u00d5\3\2\2\2\64\65\5\4\3"+
		"\2\65\66\7\2\2\3\66\3\3\2\2\2\67=\5\b\5\28=\5\16\b\29=\5\36\20\2:=\5\""+
		"\22\2;=\5\6\4\2<\67\3\2\2\2<8\3\2\2\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=\5"+
		"\3\2\2\2>?\7\3\2\2?@\5\4\3\2@A\7\4\2\2A\7\3\2\2\2BC\b\5\1\2CF\5\16\b\2"+
		"DF\5\f\7\2EB\3\2\2\2ED\3\2\2\2FM\3\2\2\2GH\f\5\2\2HI\5\n\6\2IJ\5\b\5\6"+
		"JL\3\2\2\2KG\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\t\3\2\2\2OM\3\2\2"+
		"\2PR\7\27\2\2QS\7\34\2\2RQ\3\2\2\2RS\3\2\2\2SY\3\2\2\2TV\7\37\2\2UW\7"+
		"\34\2\2VU\3\2\2\2VW\3\2\2\2WY\3\2\2\2XP\3\2\2\2XT\3\2\2\2Y\13\3\2\2\2"+
		"Z[\7\3\2\2[\\\5\b\5\2\\]\7\4\2\2]\r\3\2\2\2^_\5\20\t\2_b\5\24\13\2`c\5"+
		"\62\32\2ac\5\26\f\2b`\3\2\2\2ba\3\2\2\2ci\3\2\2\2de\5\20\t\2ef\7\31\2"+
		"\2fg\5\22\n\2gi\3\2\2\2h^\3\2\2\2hd\3\2\2\2i\17\3\2\2\2jo\5\62\32\2kl"+
		"\t\2\2\2ln\5\62\32\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\21\3\2\2"+
		"\2qo\3\2\2\2rs\7\3\2\2sx\5&\24\2tu\7\7\2\2uw\5&\24\2vt\3\2\2\2wz\3\2\2"+
		"\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7\4\2\2|\23\3\2\2\2}\u0088"+
		"\7!\2\2~\u0088\7\"\2\2\177\u0088\7#\2\2\u0080\u0088\7$\2\2\u0081\u0088"+
		"\7%\2\2\u0082\u0088\7&\2\2\u0083\u0085\7\34\2\2\u0084\u0083\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\7\33\2\2\u0087}\3\2\2\2"+
		"\u0087~\3\2\2\2\u0087\177\3\2\2\2\u0087\u0080\3\2\2\2\u0087\u0081\3\2"+
		"\2\2\u0087\u0082\3\2\2\2\u0087\u0084\3\2\2\2\u0088\25\3\2\2\2\u0089\u008a"+
		"\b\f\1\2\u008a\u008d\5&\24\2\u008b\u008d\5\30\r\2\u008c\u0089\3\2\2\2"+
		"\u008c\u008b\3\2\2\2\u008d\u0098\3\2\2\2\u008e\u008f\f\6\2\2\u008f\u0090"+
		"\5\34\17\2\u0090\u0091\5\26\f\7\u0091\u0097\3\2\2\2\u0092\u0093\f\5\2"+
		"\2\u0093\u0094\5\32\16\2\u0094\u0095\5\26\f\6\u0095\u0097\3\2\2\2\u0096"+
		"\u008e\3\2\2\2\u0096\u0092\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\27\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c"+
		"\7\3\2\2\u009c\u009d\5\26\f\2\u009d\u009e\7\4\2\2\u009e\31\3\2\2\2\u009f"+
		"\u00a0\t\3\2\2\u00a0\33\3\2\2\2\u00a1\u00a2\t\4\2\2\u00a2\35\3\2\2\2\u00a3"+
		"\u00a4\5\62\32\2\u00a4\u00a5\5 \21\2\u00a5\37\3\2\2\2\u00a6\u00a8\7\32"+
		"\2\2\u00a7\u00a9\7\34\2\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\7\35\2\2\u00ab!\3\2\2\2\u00ac\u00ad\5\62\32"+
		"\2\u00ad\u00ae\5$\23\2\u00ae\u00af\5&\24\2\u00af\u00b0\7\27\2\2\u00b0"+
		"\u00b1\5&\24\2\u00b1#\3\2\2\2\u00b2\u00b4\7\34\2\2\u00b3\u00b2\3\2\2\2"+
		"\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7\30\2\2\u00b6%\3"+
		"\2\2\2\u00b7\u00bc\5(\25\2\u00b8\u00bc\5*\26\2\u00b9\u00bc\5,\27\2\u00ba"+
		"\u00bc\5.\30\2\u00bb\u00b7\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bb\u00b9\3\2"+
		"\2\2\u00bb\u00ba\3\2\2\2\u00bc\'\3\2\2\2\u00bd\u00be\7\f\2\2\u00be)\3"+
		"\2\2\2\u00bf\u00c0\t\5\2\2\u00c0+\3\2\2\2\u00c1\u00c2\7\25\2\2\u00c2-"+
		"\3\2\2\2\u00c3\u00c4\7\26\2\2\u00c4/\3\2\2\2\u00c5\u00c6\7\'\2\2\u00c6"+
		"\u00cf\7\3\2\2\u00c7\u00cc\5\26\f\2\u00c8\u00c9\7\7\2\2\u00c9\u00cb\5"+
		"\26\f\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00c7\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7\4\2\2\u00d2"+
		"\61\3\2\2\2\u00d3\u00d4\7\'\2\2\u00d4\u00d6\7\13\2\2\u00d5\u00d3\3\2\2"+
		"\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\7\'\2\2\u00d8\63"+
		"\3\2\2\2\27<EMRVXbhox\u0084\u0087\u008c\u0096\u0098\u00a8\u00b3\u00bb"+
		"\u00cc\u00cf\u00d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}