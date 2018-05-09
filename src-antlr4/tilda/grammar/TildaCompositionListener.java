// Generated from TildaComposition.g4 by ANTLR 4.4
package tilda.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TildaCompositionParser}.
 */
public interface TildaCompositionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr_sub(@NotNull TildaCompositionParser.Expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr_sub(@NotNull TildaCompositionParser.Expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr(@NotNull TildaCompositionParser.Bool_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr(@NotNull TildaCompositionParser.Bool_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#bool_expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr_sub(@NotNull TildaCompositionParser.Bool_expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#bool_expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr_sub(@NotNull TildaCompositionParser.Bool_expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull TildaCompositionParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull TildaCompositionParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(@NotNull TildaCompositionParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(@NotNull TildaCompositionParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull TildaCompositionParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull TildaCompositionParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#bool_op}.
	 * @param ctx the parse tree
	 */
	void enterBool_op(@NotNull TildaCompositionParser.Bool_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#bool_op}.
	 * @param ctx the parse tree
	 */
	void exitBool_op(@NotNull TildaCompositionParser.Bool_opContext ctx);
}