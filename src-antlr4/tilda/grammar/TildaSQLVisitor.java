// Generated from TildaSQL.g4 by ANTLR 4.5.3
package tilda.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TildaSQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TildaSQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(TildaSQLParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(TildaSQLParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(TildaSQLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#sub_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub_expr(TildaSQLParser.Sub_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#bin_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBin_operator(TildaSQLParser.Bin_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(TildaSQLParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(TildaSQLParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(TildaSQLParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(TildaSQLParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(TildaSQLParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(TildaSQLParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#any_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_name(TildaSQLParser.Any_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#numeric_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_literal(TildaSQLParser.Numeric_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(TildaSQLParser.String_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#bind_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBind_parameter(TildaSQLParser.Bind_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TildaSQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestamp_literal(TildaSQLParser.Timestamp_literalContext ctx);
}