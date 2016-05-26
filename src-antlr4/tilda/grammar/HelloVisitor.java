// Generated from Hello.g4 by ANTLR 4.5.3
package tilda.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval(HelloParser.EvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#additionExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExp(HelloParser.AdditionExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#multiplyExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExp(HelloParser.MultiplyExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#atomExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExp(HelloParser.AtomExpContext ctx);
}