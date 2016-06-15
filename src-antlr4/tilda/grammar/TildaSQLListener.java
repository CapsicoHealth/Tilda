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
	 * Enter a parse tree produced by {@link TildaSQLParser#expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr_sub(TildaSQLParser.Expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr_sub(TildaSQLParser.Expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr(TildaSQLParser.Bool_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr(TildaSQLParser.Bool_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bool_op}.
	 * @param ctx the parse tree
	 */
	void enterBool_op(TildaSQLParser.Bool_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bool_op}.
	 * @param ctx the parse tree
	 */
	void exitBool_op(TildaSQLParser.Bool_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bool_expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr_sub(TildaSQLParser.Bool_expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bool_expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr_sub(TildaSQLParser.Bool_expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bin_expr}.
	 * @param ctx the parse tree
	 */
	void enterBin_expr(TildaSQLParser.Bin_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bin_expr}.
	 * @param ctx the parse tree
	 */
	void exitBin_expr(TildaSQLParser.Bin_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bin_expr_lhs}.
	 * @param ctx the parse tree
	 */
	void enterBin_expr_lhs(TildaSQLParser.Bin_expr_lhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bin_expr_lhs}.
	 * @param ctx the parse tree
	 */
	void exitBin_expr_lhs(TildaSQLParser.Bin_expr_lhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#value_list}.
	 * @param ctx the parse tree
	 */
	void enterValue_list(TildaSQLParser.Value_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#value_list}.
	 * @param ctx the parse tree
	 */
	void exitValue_list(TildaSQLParser.Value_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void enterBin_op(TildaSQLParser.Bin_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void exitBin_op(TildaSQLParser.Bin_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#arithmetic_expr_base}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expr_base(TildaSQLParser.Arithmetic_expr_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#arithmetic_expr_base}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expr_base(TildaSQLParser.Arithmetic_expr_baseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpr}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpr(TildaSQLParser.ArithmeticExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpr}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpr(TildaSQLParser.ArithmeticExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExprSub}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExprSub(TildaSQLParser.ArithmeticExprSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExprSub}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExprSub(TildaSQLParser.ArithmeticExprSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExprVal}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExprVal(TildaSQLParser.ArithmeticExprValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExprVal}
	 * labeled alternative in {@link TildaSQLParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExprVal(TildaSQLParser.ArithmeticExprValContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#arithmetic_expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expr_sub(TildaSQLParser.Arithmetic_expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#arithmetic_expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expr_sub(TildaSQLParser.Arithmetic_expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#arithmetic_op_add}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_op_add(TildaSQLParser.Arithmetic_op_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#arithmetic_op_add}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_op_add(TildaSQLParser.Arithmetic_op_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#arithmetic_op_mul}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_op_mul(TildaSQLParser.Arithmetic_op_mulContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#arithmetic_op_mul}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_op_mul(TildaSQLParser.Arithmetic_op_mulContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#isnull_expr}.
	 * @param ctx the parse tree
	 */
	void enterIsnull_expr(TildaSQLParser.Isnull_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#isnull_expr}.
	 * @param ctx the parse tree
	 */
	void exitIsnull_expr(TildaSQLParser.Isnull_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#isnull_op}.
	 * @param ctx the parse tree
	 */
	void enterIsnull_op(TildaSQLParser.Isnull_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#isnull_op}.
	 * @param ctx the parse tree
	 */
	void exitIsnull_op(TildaSQLParser.Isnull_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#between_expr}.
	 * @param ctx the parse tree
	 */
	void enterBetween_expr(TildaSQLParser.Between_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#between_expr}.
	 * @param ctx the parse tree
	 */
	void exitBetween_expr(TildaSQLParser.Between_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void enterBetween_op(TildaSQLParser.Between_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void exitBetween_op(TildaSQLParser.Between_opContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueNumericLiteral(TildaSQLParser.ValueNumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueNumericLiteral(TildaSQLParser.ValueNumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueTimestampLiteral(TildaSQLParser.ValueTimestampLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueTimestampLiteral(TildaSQLParser.ValueTimestampLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueStringLiteral(TildaSQLParser.ValueStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueStringLiteral(TildaSQLParser.ValueStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueBindParam(TildaSQLParser.ValueBindParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueBindParam(TildaSQLParser.ValueBindParamContext ctx);
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
	 * Enter a parse tree produced by {@link TildaSQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void enterTimestamp_literal(TildaSQLParser.Timestamp_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void exitTimestamp_literal(TildaSQLParser.Timestamp_literalContext ctx);
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
}