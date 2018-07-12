// Generated from Hello.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void enterAtomExp(@NotNull HelloParser.AtomExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void exitAtomExp(@NotNull HelloParser.AtomExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(@NotNull HelloParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(@NotNull HelloParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExp(@NotNull HelloParser.MultiplyExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExp(@NotNull HelloParser.MultiplyExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExp(@NotNull HelloParser.AdditionExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExp(@NotNull HelloParser.AdditionExpContext ctx);
}