// Generated from TildaComposition.g4 by ANTLR 4.10.1
package tilda.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TildaCompositionParser}.
 */
public interface TildaCompositionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(TildaCompositionParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(TildaCompositionParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TildaCompositionParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TildaCompositionParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterExpr_sub(TildaCompositionParser.Expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitExpr_sub(TildaCompositionParser.Expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr(TildaCompositionParser.Bool_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr(TildaCompositionParser.Bool_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#bool_op}.
	 * @param ctx the parse tree
	 */
	void enterBool_op(TildaCompositionParser.Bool_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#bool_op}.
	 * @param ctx the parse tree
	 */
	void exitBool_op(TildaCompositionParser.Bool_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#bool_expr_sub}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr_sub(TildaCompositionParser.Bool_expr_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#bool_expr_sub}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr_sub(TildaCompositionParser.Bool_expr_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link TildaCompositionParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(TildaCompositionParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TildaCompositionParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(TildaCompositionParser.ParameterContext ctx);
}