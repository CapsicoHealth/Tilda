// Generated from Hello.g4 by ANTLR 4.5.3
package tilda.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(HelloParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(HelloParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExp(HelloParser.AdditionExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExp(HelloParser.AdditionExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExp(HelloParser.MultiplyExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExp(HelloParser.MultiplyExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void enterAtomExp(HelloParser.AtomExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void exitAtomExp(HelloParser.AtomExpContext ctx);
}