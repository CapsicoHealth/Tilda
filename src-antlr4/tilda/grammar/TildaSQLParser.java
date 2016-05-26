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
		T__0=1, T__1=2, T__2=3, SCOL=4, DOT=5, OPEN_PAR=6, CLOSE_PAR=7, COMMA=8, 
		ASSIGN=9, STAR=10, PLUS=11, MINUS=12, TILDE=13, PIPE2=14, DIV=15, MOD=16, 
		LT2=17, GT2=18, AMP=19, PIPE=20, LT=21, LT_EQ=22, GT=23, GT_EQ=24, EQ=25, 
		NOT_EQ1=26, NOT_EQ2=27, K_AND=28, K_BETWEEN=29, K_CURRENT_DATE=30, K_CURRENT_TIME=31, 
		K_CURRENT_TIMESTAMP=32, K_IN=33, K_IS=34, K_ISNULL=35, K_LIKE=36, K_NOT=37, 
		K_NOTNULL=38, K_NULL=39, K_ON=40, K_OR=41, K_REGEXP=42, IDENTIFIER=43, 
		NUMERIC_LITERAL=44, BIND_PARAMETER=45, TIMESTAMP_LITERAL=46, YEAR_LITERAL=47, 
		MONTH_LITERAL=48, DAY_LITERAL=49, HOUR_LITERAL_24=50, MINUTE_LITERAL=51, 
		SECOND_LITERAL=52, HOUR_LITERAL_12=53, SPACES=54, UNEXPECTED_CHAR=55;
	public static final int
		RULE_where = 0, RULE_expr = 1, RULE_value = 2, RULE_sub_expr = 3, RULE_bin_operator = 4, 
		RULE_function = 5, RULE_column = 6, RULE_unary_operator = 7, RULE_keyword = 8, 
		RULE_name = 9, RULE_function_name = 10, RULE_any_name = 11, RULE_numeric_literal = 12, 
		RULE_string_literal = 13, RULE_bind_parameter = 14, RULE_timestamp_literal = 15;
	public static final String[] ruleNames = {
		"where", "expr", "value", "sub_expr", "bin_operator", "function", "column", 
		"unary_operator", "keyword", "name", "function_name", "any_name", "numeric_literal", 
		"string_literal", "bind_parameter", "timestamp_literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'-/'", "'''", "''''", "';'", "'.'", "'('", "')'", "','", "'='", 
		"'*'", "'+'", "'-'", "'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", 
		"'|'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'<>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", 
		"ASSIGN", "STAR", "PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", 
		"GT2", "AMP", "PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", 
		"K_AND", "K_BETWEEN", "K_CURRENT_DATE", "K_CURRENT_TIME", "K_CURRENT_TIMESTAMP", 
		"K_IN", "K_IS", "K_ISNULL", "K_LIKE", "K_NOT", "K_NOTNULL", "K_NULL", 
		"K_ON", "K_OR", "K_REGEXP", "IDENTIFIER", "NUMERIC_LITERAL", "BIND_PARAMETER", 
		"TIMESTAMP_LITERAL", "YEAR_LITERAL", "MONTH_LITERAL", "DAY_LITERAL", "HOUR_LITERAL_24", 
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitWhere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			expr(0);
			setState(33);
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Sub_exprContext sub_expr() {
			return getRuleContext(Sub_exprContext.class,0);
		}
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public TerminalNode K_ISNULL() { return getToken(TildaSQLParser.K_ISNULL, 0); }
		public TerminalNode K_NOTNULL() { return getToken(TildaSQLParser.K_NOTNULL, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public TerminalNode K_NULL() { return getToken(TildaSQLParser.K_NULL, 0); }
		public TerminalNode K_BETWEEN() { return getToken(TildaSQLParser.K_BETWEEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_AND() { return getToken(TildaSQLParser.K_AND, 0); }
		public Bin_operatorContext bin_operator() {
			return getRuleContext(Bin_operatorContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
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
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(36);
				value();
				}
				break;
			case 2:
				{
				setState(37);
				function();
				}
				break;
			case 3:
				{
				setState(38);
				sub_expr();
				}
				break;
			case 4:
				{
				setState(39);
				column();
				setState(44);
				switch (_input.LA(1)) {
				case K_ISNULL:
					{
					setState(40);
					match(K_ISNULL);
					}
					break;
				case K_NOTNULL:
					{
					setState(41);
					match(K_NOTNULL);
					}
					break;
				case K_NOT:
					{
					setState(42);
					match(K_NOT);
					setState(43);
					match(K_NULL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				{
				setState(46);
				column();
				setState(48);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(47);
					match(K_NOT);
					}
				}

				setState(50);
				match(K_BETWEEN);
				setState(51);
				expr(0);
				setState(52);
				match(K_AND);
				setState(53);
				expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(57);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(58);
					bin_operator();
					setState(59);
					expr(6);
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public Timestamp_literalContext timestamp_literal() {
			return getRuleContext(Timestamp_literalContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public TerminalNode K_NULL() { return getToken(TildaSQLParser.K_NULL, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(TildaSQLParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(TildaSQLParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(TildaSQLParser.K_CURRENT_TIMESTAMP, 0); }
		public Bind_parameterContext bind_parameter() {
			return getRuleContext(Bind_parameterContext.class,0);
		}
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_value);
		try {
			setState(75);
			switch (_input.LA(1)) {
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				numeric_literal();
				}
				break;
			case TIMESTAMP_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				timestamp_literal();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				string_literal();
				}
				break;
			case K_NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(K_NULL);
				}
				break;
			case K_CURRENT_TIME:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(K_CURRENT_TIME);
				}
				break;
			case K_CURRENT_DATE:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				match(K_CURRENT_DATE);
				}
				break;
			case K_CURRENT_TIMESTAMP:
				enterOuterAlt(_localctx, 7);
				{
				setState(72);
				match(K_CURRENT_TIMESTAMP);
				}
				break;
			case BIND_PARAMETER:
				enterOuterAlt(_localctx, 8);
				{
				setState(73);
				bind_parameter();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 9);
				{
				setState(74);
				column();
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

	public static class Sub_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Sub_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterSub_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitSub_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitSub_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sub_exprContext sub_expr() throws RecognitionException {
		Sub_exprContext _localctx = new Sub_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sub_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(OPEN_PAR);
			setState(78);
			expr(0);
			setState(79);
			match(CLOSE_PAR);
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

	public static class Bin_operatorContext extends ParserRuleContext {
		public TerminalNode K_IS() { return getToken(TildaSQLParser.K_IS, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public TerminalNode K_IN() { return getToken(TildaSQLParser.K_IN, 0); }
		public TerminalNode K_LIKE() { return getToken(TildaSQLParser.K_LIKE, 0); }
		public TerminalNode K_REGEXP() { return getToken(TildaSQLParser.K_REGEXP, 0); }
		public TerminalNode K_AND() { return getToken(TildaSQLParser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQLParser.K_OR, 0); }
		public Bin_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterBin_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitBin_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitBin_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bin_operatorContext bin_operator() throws RecognitionException {
		Bin_operatorContext _localctx = new Bin_operatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bin_operator);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(PIPE2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==PLUS) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(85);
					match(ASSIGN);
					}
					break;
				case 2:
					{
					setState(86);
					match(EQ);
					}
					break;
				case 3:
					{
					setState(87);
					match(NOT_EQ1);
					}
					break;
				case 4:
					{
					setState(88);
					match(NOT_EQ2);
					}
					break;
				case 5:
					{
					setState(89);
					match(K_IS);
					}
					break;
				case 6:
					{
					setState(90);
					match(K_IS);
					setState(91);
					match(K_NOT);
					}
					break;
				case 7:
					{
					setState(92);
					match(K_IN);
					}
					break;
				case 8:
					{
					setState(93);
					match(K_LIKE);
					}
					break;
				case 9:
					{
					setState(94);
					match(K_REGEXP);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(97);
				match(K_AND);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				match(K_OR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(99);
					match(K_NOT);
					}
				}

				setState(102);
				_la = _input.LA(1);
				if ( !(_la==K_LIKE || _la==K_REGEXP) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TildaSQLParser.IDENTIFIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(IDENTIFIER);
			setState(106);
			match(OPEN_PAR);
			setState(115);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << OPEN_PAR) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_NULL) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL) | (1L << BIND_PARAMETER) | (1L << TIMESTAMP_LITERAL))) != 0)) {
				{
				setState(107);
				expr(0);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(108);
					match(COMMA);
					setState(109);
					expr(0);
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(117);
			match(CLOSE_PAR);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(119);
				match(IDENTIFIER);
				setState(120);
				match(DOT);
				}
				break;
			}
			setState(123);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << K_NOT))) != 0)) ) {
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode K_AND() { return getToken(TildaSQLParser.K_AND, 0); }
		public TerminalNode K_BETWEEN() { return getToken(TildaSQLParser.K_BETWEEN, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(TildaSQLParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(TildaSQLParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(TildaSQLParser.K_CURRENT_TIMESTAMP, 0); }
		public TerminalNode K_IN() { return getToken(TildaSQLParser.K_IN, 0); }
		public TerminalNode K_IS() { return getToken(TildaSQLParser.K_IS, 0); }
		public TerminalNode K_ISNULL() { return getToken(TildaSQLParser.K_ISNULL, 0); }
		public TerminalNode K_LIKE() { return getToken(TildaSQLParser.K_LIKE, 0); }
		public TerminalNode K_NOT() { return getToken(TildaSQLParser.K_NOT, 0); }
		public TerminalNode K_NOTNULL() { return getToken(TildaSQLParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(TildaSQLParser.K_NULL, 0); }
		public TerminalNode K_ON() { return getToken(TildaSQLParser.K_ON, 0); }
		public TerminalNode K_OR() { return getToken(TildaSQLParser.K_OR, 0); }
		public TerminalNode K_REGEXP() { return getToken(TildaSQLParser.K_REGEXP, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_AND) | (1L << K_BETWEEN) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_IN) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_LIKE) | (1L << K_NOT) | (1L << K_NOTNULL) | (1L << K_NULL) | (1L << K_ON) | (1L << K_OR) | (1L << K_REGEXP))) != 0)) ) {
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

	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			any_name();
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

	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitFunction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitFunction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			any_name();
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

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TildaSQLParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TildaSQLListener ) ((TildaSQLListener)listener).exitAny_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitAny_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_any_name);
		try {
			setState(140);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(IDENTIFIER);
				}
				break;
			case K_AND:
			case K_BETWEEN:
			case K_CURRENT_DATE:
			case K_CURRENT_TIME:
			case K_CURRENT_TIMESTAMP:
			case K_IN:
			case K_IS:
			case K_ISNULL:
			case K_LIKE:
			case K_NOT:
			case K_NOTNULL:
			case K_NULL:
			case K_ON:
			case K_OR:
			case K_REGEXP:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				keyword();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				string_literal();
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				match(OPEN_PAR);
				setState(137);
				any_name();
				setState(138);
				match(CLOSE_PAR);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitNumeric_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_literalContext numeric_literal() throws RecognitionException {
		Numeric_literalContext _localctx = new Numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
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

	public static class String_literalContext extends ParserRuleContext {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitString_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_string_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__1);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << SCOL) | (1L << DOT) | (1L << OPEN_PAR) | (1L << CLOSE_PAR) | (1L << COMMA) | (1L << ASSIGN) | (1L << STAR) | (1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << PIPE2) | (1L << DIV) | (1L << MOD) | (1L << LT2) | (1L << GT2) | (1L << AMP) | (1L << PIPE) | (1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ) | (1L << EQ) | (1L << NOT_EQ1) | (1L << NOT_EQ2) | (1L << K_AND) | (1L << K_BETWEEN) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_IN) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_LIKE) | (1L << K_NOT) | (1L << K_NOTNULL) | (1L << K_NULL) | (1L << K_ON) | (1L << K_OR) | (1L << K_REGEXP) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL) | (1L << BIND_PARAMETER) | (1L << TIMESTAMP_LITERAL) | (1L << YEAR_LITERAL) | (1L << MONTH_LITERAL) | (1L << DAY_LITERAL) | (1L << HOUR_LITERAL_24) | (1L << MINUTE_LITERAL) | (1L << SECOND_LITERAL) | (1L << HOUR_LITERAL_12) | (1L << SPACES) | (1L << UNEXPECTED_CHAR))) != 0)) {
				{
				setState(147);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(145);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==T__1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case 2:
					{
					setState(146);
					match(T__2);
					}
					break;
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitBind_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bind_parameterContext bind_parameter() throws RecognitionException {
		Bind_parameterContext _localctx = new Bind_parameterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bind_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
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

	public static class Timestamp_literalContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP_LITERAL() { return getToken(TildaSQLParser.TIMESTAMP_LITERAL, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TildaSQLVisitor ) return ((TildaSQLVisitor<? extends T>)visitor).visitTimestamp_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Timestamp_literalContext timestamp_literal() throws RecognitionException {
		Timestamp_literalContext _localctx = new Timestamp_literalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(TIMESTAMP_LITERAL);
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
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u00a1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\3\3\3\5\3\63\n\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\3\3\3\7\3@\n\3\f\3\16\3C\13\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4N\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6b\n\6\3\6\3\6\3\6\5\6"+
		"g\n\6\3\6\5\6j\n\6\3\7\3\7\3\7\3\7\3\7\7\7q\n\7\f\7\16\7t\13\7\5\7v\n"+
		"\7\3\7\3\7\3\b\3\b\5\b|\n\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008f\n\r\3\16\3\16\3\17\3\17\3\17\7"+
		"\17\u0096\n\17\f\17\16\17\u0099\13\17\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\2\3\4\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\t\4\2\f\f\21\22"+
		"\4\2\3\3\r\r\3\2\27\32\4\2&&,,\4\2\r\17\'\'\3\2\36,\3\2\4\4\u00b8\2\""+
		"\3\2\2\2\49\3\2\2\2\6M\3\2\2\2\bO\3\2\2\2\ni\3\2\2\2\fk\3\2\2\2\16{\3"+
		"\2\2\2\20\177\3\2\2\2\22\u0081\3\2\2\2\24\u0083\3\2\2\2\26\u0085\3\2\2"+
		"\2\30\u008e\3\2\2\2\32\u0090\3\2\2\2\34\u0092\3\2\2\2\36\u009c\3\2\2\2"+
		" \u009e\3\2\2\2\"#\5\4\3\2#$\7\2\2\3$\3\3\2\2\2%&\b\3\1\2&:\5\6\4\2\'"+
		":\5\f\7\2(:\5\b\5\2).\5\16\b\2*/\7%\2\2+/\7(\2\2,-\7\'\2\2-/\7)\2\2.*"+
		"\3\2\2\2.+\3\2\2\2.,\3\2\2\2/:\3\2\2\2\60\62\5\16\b\2\61\63\7\'\2\2\62"+
		"\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\37\2\2\65\66\5\4\3\2\66"+
		"\67\7\36\2\2\678\5\4\3\28:\3\2\2\29%\3\2\2\29\'\3\2\2\29(\3\2\2\29)\3"+
		"\2\2\29\60\3\2\2\2:A\3\2\2\2;<\f\7\2\2<=\5\n\6\2=>\5\4\3\b>@\3\2\2\2?"+
		";\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\5\3\2\2\2CA\3\2\2\2DN\5\32\16"+
		"\2EN\5 \21\2FN\5\34\17\2GN\7)\2\2HN\7!\2\2IN\7 \2\2JN\7\"\2\2KN\5\36\20"+
		"\2LN\5\16\b\2MD\3\2\2\2ME\3\2\2\2MF\3\2\2\2MG\3\2\2\2MH\3\2\2\2MI\3\2"+
		"\2\2MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\7\3\2\2\2OP\7\b\2\2PQ\5\4\3\2QR\7"+
		"\t\2\2R\t\3\2\2\2Sj\7\20\2\2Tj\t\2\2\2Uj\t\3\2\2Vj\t\4\2\2Wb\7\13\2\2"+
		"Xb\7\33\2\2Yb\7\34\2\2Zb\7\35\2\2[b\7$\2\2\\]\7$\2\2]b\7\'\2\2^b\7#\2"+
		"\2_b\7&\2\2`b\7,\2\2aW\3\2\2\2aX\3\2\2\2aY\3\2\2\2aZ\3\2\2\2a[\3\2\2\2"+
		"a\\\3\2\2\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2bj\3\2\2\2cj\7\36\2\2dj\7+\2"+
		"\2eg\7\'\2\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hj\t\5\2\2iS\3\2\2\2iT\3\2\2"+
		"\2iU\3\2\2\2iV\3\2\2\2ia\3\2\2\2ic\3\2\2\2id\3\2\2\2if\3\2\2\2j\13\3\2"+
		"\2\2kl\7-\2\2lu\7\b\2\2mr\5\4\3\2no\7\n\2\2oq\5\4\3\2pn\3\2\2\2qt\3\2"+
		"\2\2rp\3\2\2\2rs\3\2\2\2sv\3\2\2\2tr\3\2\2\2um\3\2\2\2uv\3\2\2\2vw\3\2"+
		"\2\2wx\7\t\2\2x\r\3\2\2\2yz\7-\2\2z|\7\7\2\2{y\3\2\2\2{|\3\2\2\2|}\3\2"+
		"\2\2}~\7-\2\2~\17\3\2\2\2\177\u0080\t\6\2\2\u0080\21\3\2\2\2\u0081\u0082"+
		"\t\7\2\2\u0082\23\3\2\2\2\u0083\u0084\5\30\r\2\u0084\25\3\2\2\2\u0085"+
		"\u0086\5\30\r\2\u0086\27\3\2\2\2\u0087\u008f\7-\2\2\u0088\u008f\5\22\n"+
		"\2\u0089\u008f\5\34\17\2\u008a\u008b\7\b\2\2\u008b\u008c\5\30\r\2\u008c"+
		"\u008d\7\t\2\2\u008d\u008f\3\2\2\2\u008e\u0087\3\2\2\2\u008e\u0088\3\2"+
		"\2\2\u008e\u0089\3\2\2\2\u008e\u008a\3\2\2\2\u008f\31\3\2\2\2\u0090\u0091"+
		"\7.\2\2\u0091\33\3\2\2\2\u0092\u0097\7\4\2\2\u0093\u0096\n\b\2\2\u0094"+
		"\u0096\7\5\2\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009b\7\4\2\2\u009b\35\3\2\2\2\u009c\u009d\7/\2\2"+
		"\u009d\37\3\2\2\2\u009e\u009f\7\60\2\2\u009f!\3\2\2\2\20.\629AMafiru{"+
		"\u008e\u0095\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}