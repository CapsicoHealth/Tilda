// Generated from TildaSQL2.g4 by ANTLR 4.5.3
package tilda.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TildaSQL2Parser}.
 */
public interface TildaSQL2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TildaSQL2Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TildaSQL2Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TildaSQL2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TildaSQL2Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(TildaSQL2Parser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(TildaSQL2Parser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#func_name}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name(TildaSQL2Parser.Func_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#func_name}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name(TildaSQL2Parser.Func_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#bin_like}.
	 * @param ctx the parse tree
	 */
	void enterBin_like(TildaSQL2Parser.Bin_likeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#bin_like}.
	 * @param ctx the parse tree
	 */
	void exitBin_like(TildaSQL2Parser.Bin_likeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#arithmetic_op_add}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_op_add(TildaSQL2Parser.Arithmetic_op_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#arithmetic_op_add}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_op_add(TildaSQL2Parser.Arithmetic_op_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#arithmetic_op_mul}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_op_mul(TildaSQL2Parser.Arithmetic_op_mulContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#arithmetic_op_mul}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_op_mul(TildaSQL2Parser.Arithmetic_op_mulContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#isnull_op}.
	 * @param ctx the parse tree
	 */
	void enterIsnull_op(TildaSQL2Parser.Isnull_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#isnull_op}.
	 * @param ctx the parse tree
	 */
	void exitIsnull_op(TildaSQL2Parser.Isnull_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#between_op}.
	 * @param ctx the parse tree
	 */
	void enterBetween_op(TildaSQL2Parser.Between_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#between_op}.
	 * @param ctx the parse tree
	 */
	void exitBetween_op(TildaSQL2Parser.Between_opContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueNumericLiteral(TildaSQL2Parser.ValueNumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueNumericLiteral(TildaSQL2Parser.ValueNumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueTimestampLiteral(TildaSQL2Parser.ValueTimestampLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueTimestampLiteral(TildaSQL2Parser.ValueTimestampLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueStringLiteral(TildaSQL2Parser.ValueStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueStringLiteral(TildaSQL2Parser.ValueStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueBindParam(TildaSQL2Parser.ValueBindParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueBindParam(TildaSQL2Parser.ValueBindParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_literal(TildaSQL2Parser.Numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_literal(TildaSQL2Parser.Numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void enterTimestamp_literal(TildaSQL2Parser.Timestamp_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void exitTimestamp_literal(TildaSQL2Parser.Timestamp_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(TildaSQL2Parser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(TildaSQL2Parser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#bind_parameter}.
	 * @param ctx the parse tree
	 */
	void enterBind_parameter(TildaSQL2Parser.Bind_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#bind_parameter}.
	 * @param ctx the parse tree
	 */
	void exitBind_parameter(TildaSQL2Parser.Bind_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQL2Parser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(TildaSQL2Parser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQL2Parser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(TildaSQL2Parser.ColumnContext ctx);
}