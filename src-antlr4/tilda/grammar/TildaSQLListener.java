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
	 * Enter a parse tree produced by the {@code ArythExprAddExpr}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void enterArythExprAddExpr(TildaSQLParser.ArythExprAddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArythExprAddExpr}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void exitArythExprAddExpr(TildaSQLParser.ArythExprAddExprContext ctx);
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
	 * Enter a parse tree produced by the {@code ArythExprMultExpr}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void enterArythExprMultExpr(TildaSQLParser.ArythExprMultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArythExprMultExpr}
	 * labeled alternative in {@link TildaSQLParser#aryth_expr}.
	 * @param ctx the parse tree
	 */
	void exitArythExprMultExpr(TildaSQLParser.ArythExprMultExprContext ctx);
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
	 * Enter a parse tree produced by the {@code ValueLiteralNumeric}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueLiteralNumeric(TildaSQLParser.ValueLiteralNumericContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueLiteralNumeric}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueLiteralNumeric(TildaSQLParser.ValueLiteralNumericContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueLiteralTimestamp}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueLiteralTimestamp(TildaSQLParser.ValueLiteralTimestampContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueLiteralTimestamp}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueLiteralTimestamp(TildaSQLParser.ValueLiteralTimestampContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueLiteralString}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueLiteralString(TildaSQLParser.ValueLiteralStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueLiteralString}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueLiteralString(TildaSQLParser.ValueLiteralStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueLiteralNull}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueLiteralNull(TildaSQLParser.ValueLiteralNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueLiteralNull}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueLiteralNull(TildaSQLParser.ValueLiteralNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueBind}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueBind(TildaSQLParser.ValueBindContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBind}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueBind(TildaSQLParser.ValueBindContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueColumn}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueColumn(TildaSQLParser.ValueColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueColumn}
	 * labeled alternative in {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueColumn(TildaSQLParser.ValueColumnContext ctx);
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