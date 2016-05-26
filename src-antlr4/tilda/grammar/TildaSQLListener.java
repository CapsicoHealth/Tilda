// Generated from TildaSQL.g4 by ANTLR 4.5.3
package tilda.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TildaSQLParser}.
 */
public interface TildaSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(TildaSQLParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(TildaSQLParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TildaSQLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TildaSQLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(TildaSQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(TildaSQLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#sub_expr}.
	 * @param ctx the parse tree
	 */
	void enterSub_expr(TildaSQLParser.Sub_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#sub_expr}.
	 * @param ctx the parse tree
	 */
	void exitSub_expr(TildaSQLParser.Sub_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bin_operator}.
	 * @param ctx the parse tree
	 */
	void enterBin_operator(TildaSQLParser.Bin_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bin_operator}.
	 * @param ctx the parse tree
	 */
	void exitBin_operator(TildaSQLParser.Bin_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(TildaSQLParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(TildaSQLParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(TildaSQLParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(TildaSQLParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(TildaSQLParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(TildaSQLParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(TildaSQLParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(TildaSQLParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(TildaSQLParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(TildaSQLParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(TildaSQLParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(TildaSQLParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(TildaSQLParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(TildaSQLParser.Any_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_literal(TildaSQLParser.Numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_literal(TildaSQLParser.Numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(TildaSQLParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(TildaSQLParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bind_parameter}.
	 * @param ctx the parse tree
	 */
	void enterBind_parameter(TildaSQLParser.Bind_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bind_parameter}.
	 * @param ctx the parse tree
	 */
	void exitBind_parameter(TildaSQLParser.Bind_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void enterTimestamp_literal(TildaSQLParser.Timestamp_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void exitTimestamp_literal(TildaSQLParser.Timestamp_literalContext ctx);
}