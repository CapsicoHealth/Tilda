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
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueBindParam(@NotNull TildaSQLParser.ValueBindParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueBindParam(@NotNull TildaSQLParser.ValueBindParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_case}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_case(@NotNull TildaSQLParser.Expr_caseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_case}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_case(@NotNull TildaSQLParser.Expr_caseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_arith}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_arith(@NotNull TildaSQLParser.Expr_arithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_arith}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_arith(@NotNull TildaSQLParser.Expr_arithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueCharLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueCharLiteral(@NotNull TildaSQLParser.ValueCharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueCharLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueCharLiteral(@NotNull TildaSQLParser.ValueCharLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(@NotNull TildaSQLParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(@NotNull TildaSQLParser.Boolean_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(@NotNull TildaSQLParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(@NotNull TildaSQLParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_bool}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_bool(@NotNull TildaSQLParser.Expr_boolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_bool}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_bool(@NotNull TildaSQLParser.Expr_boolContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#case_else_expr}.
	 * @param ctx the parse tree
	 */
	void enterCase_else_expr(@NotNull TildaSQLParser.Case_else_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#case_else_expr}.
	 * @param ctx the parse tree
	 */
	void exitCase_else_expr(@NotNull TildaSQLParser.Case_else_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_concat}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_concat(@NotNull TildaSQLParser.Expr_concatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_concat}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_concat(@NotNull TildaSQLParser.Expr_concatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_in}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_in(@NotNull TildaSQLParser.Expr_inContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_in}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_in(@NotNull TildaSQLParser.Expr_inContext ctx);
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
	 * Enter a parse tree produced by {@link TildaSQLParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(@NotNull TildaSQLParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(@NotNull TildaSQLParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#func_name}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name(@NotNull TildaSQLParser.Func_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#func_name}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name(@NotNull TildaSQLParser.Func_nameContext ctx);
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
	 * Enter a parse tree produced by the {@code expr_comp}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_comp(@NotNull TildaSQLParser.Expr_compContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_comp}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_comp(@NotNull TildaSQLParser.Expr_compContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_sub}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_sub(@NotNull TildaSQLParser.Expr_subContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_sub}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_sub(@NotNull TildaSQLParser.Expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(@NotNull TildaSQLParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(@NotNull TildaSQLParser.Unary_operatorContext ctx);
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
	 * Enter a parse tree produced by the {@code expr_column}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_column(@NotNull TildaSQLParser.Expr_columnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_column}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_column(@NotNull TildaSQLParser.Expr_columnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueTimestampLiteral(@NotNull TildaSQLParser.ValueTimestampLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueTimestampLiteral(@NotNull TildaSQLParser.ValueTimestampLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_literal}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_literal(@NotNull TildaSQLParser.Expr_literalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_literal}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_literal(@NotNull TildaSQLParser.Expr_literalContext ctx);
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
	 * Enter a parse tree produced by the {@code ValueBooleanLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueBooleanLiteral(@NotNull TildaSQLParser.ValueBooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBooleanLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueBooleanLiteral(@NotNull TildaSQLParser.ValueBooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_func}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_func(@NotNull TildaSQLParser.Expr_funcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_func}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_func(@NotNull TildaSQLParser.Expr_funcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_between}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_between(@NotNull TildaSQLParser.Expr_betweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_between}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_between(@NotNull TildaSQLParser.Expr_betweenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueStringLiteral(@NotNull TildaSQLParser.ValueStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueStringLiteral(@NotNull TildaSQLParser.ValueStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_isnull}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_isnull(@NotNull TildaSQLParser.Expr_isnullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_isnull}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_isnull(@NotNull TildaSQLParser.Expr_isnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#case_when_expr}.
	 * @param ctx the parse tree
	 */
	void enterCase_when_expr(@NotNull TildaSQLParser.Case_when_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#case_when_expr}.
	 * @param ctx the parse tree
	 */
	void exitCase_when_expr(@NotNull TildaSQLParser.Case_when_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_unary}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_unary(@NotNull TildaSQLParser.Expr_unaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_unary}
	 * labeled alternative in {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_unary(@NotNull TildaSQLParser.Expr_unaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueNumericLiteral(@NotNull TildaSQLParser.ValueNumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
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