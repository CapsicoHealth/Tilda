// Generated from TildaSQL.g4 by ANTLR 4.4
package tilda.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TildaSQLParser}.
 */
public interface TildaSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueBindParam(@NotNull TildaSQLParser.ValueBindParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueBindParam(@NotNull TildaSQLParser.ValueBindParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bin_like}.
	 * @param ctx the parse tree
	 */
	void enterBin_like(@NotNull TildaSQLParser.Bin_likeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bin_like}.
	 * @param ctx the parse tree
	 */
	void exitBin_like(@NotNull TildaSQLParser.Bin_likeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bool_op}.
	 * @param ctx the parse tree
	 */
	void enterBool_op(@NotNull TildaSQLParser.Bool_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bool_op}.
	 * @param ctx the parse tree
	 */
	void exitBool_op(@NotNull TildaSQLParser.Bool_opContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExprVal}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExprVal(@NotNull TildaSQLParser.ArithmeticExprValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExprVal}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExprVal(@NotNull TildaSQLParser.ArithmeticExprValContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#arithmetic_expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expr_sub(@NotNull TildaSQLParser.Arithmetic_expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#arithmetic_expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expr_sub(@NotNull TildaSQLParser.Arithmetic_expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#arithmetic_expr_base}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expr_base(@NotNull TildaSQLParser.Arithmetic_expr_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#arithmetic_expr_base}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expr_base(@NotNull TildaSQLParser.Arithmetic_expr_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#between_expr}.
	 * @param ctx the parse tree
	 */
	void enterBetween_expr(@NotNull TildaSQLParser.Between_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#between_expr}.
	 * @param ctx the parse tree
	 */
	void exitBetween_expr(@NotNull TildaSQLParser.Between_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpr}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpr(@NotNull TildaSQLParser.ArithmeticExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpr}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpr(@NotNull TildaSQLParser.ArithmeticExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull TildaSQLParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull TildaSQLParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(@NotNull TildaSQLParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(@NotNull TildaSQLParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull TildaSQLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull TildaSQLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#arithmetic_op_mul}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_op_mul(@NotNull TildaSQLParser.Arithmetic_op_mulContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#arithmetic_op_mul}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_op_mul(@NotNull TildaSQLParser.Arithmetic_op_mulContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#isnull_op}.
	 * @param ctx the parse tree
	 */
	void enterIsnull_op(@NotNull TildaSQLParser.Isnull_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#isnull_op}.
	 * @param ctx the parse tree
	 */
	void exitIsnull_op(@NotNull TildaSQLParser.Isnull_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_literal(@NotNull TildaSQLParser.Numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_literal(@NotNull TildaSQLParser.Numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr_sub(@NotNull TildaSQLParser.Expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr_sub(@NotNull TildaSQLParser.Expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bool_expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr_sub(@NotNull TildaSQLParser.Bool_expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bool_expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr_sub(@NotNull TildaSQLParser.Bool_expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#func_expr}.
	 * @param ctx the parse tree
	 */
	void enterFunc_expr(@NotNull TildaSQLParser.Func_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#func_expr}.
	 * @param ctx the parse tree
	 */
	void exitFunc_expr(@NotNull TildaSQLParser.Func_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void enterTimestamp_literal(@NotNull TildaSQLParser.Timestamp_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void exitTimestamp_literal(@NotNull TildaSQLParser.Timestamp_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bind_parameter}.
	 * @param ctx the parse tree
	 */
	void enterBind_parameter(@NotNull TildaSQLParser.Bind_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bind_parameter}.
	 * @param ctx the parse tree
	 */
	void exitBind_parameter(@NotNull TildaSQLParser.Bind_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(@NotNull TildaSQLParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(@NotNull TildaSQLParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#value_list}.
	 * @param ctx the parse tree
	 */
	void enterValue_list(@NotNull TildaSQLParser.Value_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#value_list}.
	 * @param ctx the parse tree
	 */
	void exitValue_list(@NotNull TildaSQLParser.Value_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bin_expr}.
	 * @param ctx the parse tree
	 */
	void enterBin_expr(@NotNull TildaSQLParser.Bin_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bin_expr}.
	 * @param ctx the parse tree
	 */
	void exitBin_expr(@NotNull TildaSQLParser.Bin_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExprSub}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExprSub(@NotNull TildaSQLParser.ArithmeticExprSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExprSub}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExprSub(@NotNull TildaSQLParser.ArithmeticExprSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueTimestampLiteral(@NotNull TildaSQLParser.ValueTimestampLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueTimestampLiteral(@NotNull TildaSQLParser.ValueTimestampLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void enterBin_op(@NotNull TildaSQLParser.Bin_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void exitBin_op(@NotNull TildaSQLParser.Bin_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#isnull_expr}.
	 * @param ctx the parse tree
	 */
	void enterIsnull_expr(@NotNull TildaSQLParser.Isnull_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#isnull_expr}.
	 * @param ctx the parse tree
	 */
	void exitIsnull_expr(@NotNull TildaSQLParser.Isnull_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(@NotNull TildaSQLParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(@NotNull TildaSQLParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bin_expr_lhs}.
	 * @param ctx the parse tree
	 */
	void enterBin_expr_lhs(@NotNull TildaSQLParser.Bin_expr_lhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bin_expr_lhs}.
	 * @param ctx the parse tree
	 */
	void exitBin_expr_lhs(@NotNull TildaSQLParser.Bin_expr_lhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr(@NotNull TildaSQLParser.Bool_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr(@NotNull TildaSQLParser.Bool_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueStringLiteral(@NotNull TildaSQLParser.ValueStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueStringLiteral(@NotNull TildaSQLParser.ValueStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueNumericLiteral(@NotNull TildaSQLParser.ValueNumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueNumericLiteral(@NotNull TildaSQLParser.ValueNumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#arithmetic_op_add}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_op_add(@NotNull TildaSQLParser.Arithmetic_op_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#arithmetic_op_add}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_op_add(@NotNull TildaSQLParser.Arithmetic_op_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void enterBetween_op(@NotNull TildaSQLParser.Between_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void exitBetween_op(@NotNull TildaSQLParser.Between_opContext ctx);
}