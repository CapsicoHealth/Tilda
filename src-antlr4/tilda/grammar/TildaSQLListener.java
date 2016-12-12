// Generated from TildaSQL.g4 by ANTLR 4.5.3
package tilda.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TildaSQLParser}.
 */
public interface TildaSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TildaSQLParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TildaSQLParser.MainContext ctx);
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
	 * Enter a parse tree produced by {@link TildaSQLParser#func_name}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name(TildaSQLParser.Func_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#func_name}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name(TildaSQLParser.Func_nameContext ctx);
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
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueNumericLiteral(TildaSQLParser.ValueNumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueNumericLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueNumericLiteral(TildaSQLParser.ValueNumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueBooleanLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueBooleanLiteral(TildaSQLParser.ValueBooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBooleanLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueBooleanLiteral(TildaSQLParser.ValueBooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueTimestampLiteral(TildaSQLParser.ValueTimestampLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueTimestampLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueTimestampLiteral(TildaSQLParser.ValueTimestampLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueStringLiteral(TildaSQLParser.ValueStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueStringLiteral}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueStringLiteral(TildaSQLParser.ValueStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterValueBindParam(TildaSQLParser.ValueBindParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBindParam}
	 * labeled alternative in {@link TildaSQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitValueBindParam(TildaSQLParser.ValueBindParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaSQLParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(TildaSQLParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaSQLParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(TildaSQLParser.Boolean_literalContext ctx);
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