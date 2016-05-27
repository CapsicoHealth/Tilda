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
	 * Enter a parse tree produced by the {@code ArythExpr}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void enterArythExpr(TildaSQLParser.ArythExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArythExpr}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void exitArythExpr(TildaSQLParser.ArythExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArythExprSub}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void enterArythExprSub(TildaSQLParser.ArythExprSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArythExprSub}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void exitArythExprSub(TildaSQLParser.ArythExprSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArythExprVal}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void enterArythExprVal(TildaSQLParser.ArythExprValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArythExprVal}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void exitArythExprVal(TildaSQLParser.ArythExprValContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#aryth_expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterAryth_expr_sub(TildaSQLParser.Aryth_expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#aryth_expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitAryth_expr_sub(TildaSQLParser.Aryth_expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#aryth_op_add}.
	 * @param ctx the parse tree
	 */
	void enterAryth_op_add(TildaSQLParser.Aryth_op_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#aryth_op_add}.
	 * @param ctx the parse tree
	 */
	void exitAryth_op_add(TildaSQLParser.Aryth_op_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#aryth_op_mul}.
	 * @param ctx the parse tree
	 */
	void enterAryth_op_mul(TildaSQLParser.Aryth_op_mulContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#aryth_op_mul}.
	 * @param ctx the parse tree
	 */
	void exitAryth_op_mul(TildaSQLParser.Aryth_op_mulContext ctx);
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