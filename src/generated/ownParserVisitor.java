// Generated from C:/Users/julio/Desktop/ProyectoII/src\ownParser.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ownParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ownParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ProgMonkey}
	 * labeled alternative in {@link ownParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgMonkey(ownParser.ProgMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StLetMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStLetMonkey(ownParser.StLetMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StRtnMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStRtnMonkey(ownParser.StRtnMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StExprMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStExprMonkey(ownParser.StExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetStMonkey}
	 * labeled alternative in {@link ownParser#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStMonkey(ownParser.LetStMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RtnStMonkey}
	 * labeled alternative in {@link ownParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtnStMonkey(ownParser.RtnStMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStMonkey}
	 * labeled alternative in {@link ownParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStMonkey(ownParser.ExprStMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMonkey}
	 * labeled alternative in {@link ownParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMonkey(ownParser.ExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompMenMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompMenMonkey(ownParser.CompMenMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompMayMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompMayMonkey(ownParser.CompMayMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompMeIMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompMeIMonkey(ownParser.CompMeIMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompMaIMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompMaIMonkey(ownParser.CompMaIMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompIgMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompIgMonkey(ownParser.CompIgMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExprMonkey}
	 * labeled alternative in {@link ownParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExprMonkey(ownParser.AddExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddFSumMonkey}
	 * labeled alternative in {@link ownParser#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddFSumMonkey(ownParser.AddFSumMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddFSubMonkey}
	 * labeled alternative in {@link ownParser#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddFSubMonkey(ownParser.AddFSubMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulExprMonkey}
	 * labeled alternative in {@link ownParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExprMonkey(ownParser.MulExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulFMulMonkey}
	 * labeled alternative in {@link ownParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulFMulMonkey(ownParser.MulFMulMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulFDivMonkey}
	 * labeled alternative in {@link ownParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulFDivMonkey(ownParser.MulFDivMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElemExprEAcMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemExprEAcMonkey(ownParser.ElemExprEAcMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElemExprCExpMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemExprCExpMonkey(ownParser.ElemExprCExpMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElemExprPrimiMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemExprPrimiMonkey(ownParser.ElemExprPrimiMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElemAcsMonkey}
	 * labeled alternative in {@link ownParser#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemAcsMonkey(ownParser.ElemAcsMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExprMonkey}
	 * labeled alternative in {@link ownParser#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExprMonkey(ownParser.CallExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimExprIntMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExprIntMonkey(ownParser.PrimExprIntMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimExprStrMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExprStrMonkey(ownParser.PrimExprStrMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimExprIdMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExprIdMonkey(ownParser.PrimExprIdMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimExprTMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExprTMonkey(ownParser.PrimExprTMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimExprFMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExprFMonkey(ownParser.PrimExprFMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExprMonkey(ownParser.PrimExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimArrLMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimArrLMonkey(ownParser.PrimArrLMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimArrFMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimArrFMonkey(ownParser.PrimArrFMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimFunLtlMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimFunLtlMonkey(ownParser.PrimFunLtlMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimHshLtlMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimHshLtlMonkey(ownParser.PrimHshLtlMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimPrtExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimPrtExprMonkey(ownParser.PrimPrtExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimIfExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimIfExprMonkey(ownParser.PrimIfExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrFLenMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrFLenMonkey(ownParser.ArrFLenMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrFFirMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrFFirMonkey(ownParser.ArrFFirMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrFLstMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrFLstMonkey(ownParser.ArrFLstMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrFRstMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrFRstMonkey(ownParser.ArrFRstMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrFPshMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrFPshMonkey(ownParser.ArrFPshMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrLtlMonkey}
	 * labeled alternative in {@link ownParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrLtlMonkey(ownParser.ArrLtlMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunLtlMonkey}
	 * labeled alternative in {@link ownParser#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunLtlMonkey(ownParser.FunLtlMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunPrmtMonket}
	 * labeled alternative in {@link ownParser#functionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunPrmtMonket(ownParser.FunPrmtMonketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HshLtlMonkey}
	 * labeled alternative in {@link ownParser#hashLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHshLtlMonkey(ownParser.HshLtlMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HshCntMonkey}
	 * labeled alternative in {@link ownParser#hashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHshCntMonkey(ownParser.HshCntMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MreHshCntMonkey}
	 * labeled alternative in {@link ownParser#moreHashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMreHshCntMonkey(ownParser.MreHshCntMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLstMonkey}
	 * labeled alternative in {@link ownParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLstMonkey(ownParser.ExprLstMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrtExprMonkey}
	 * labeled alternative in {@link ownParser#printExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrtExprMonkey(ownParser.PrtExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseExprMonkey}
	 * labeled alternative in {@link ownParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseExprMonkey(ownParser.IfElseExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfExprMonkey}
	 * labeled alternative in {@link ownParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExprMonkey(ownParser.IfExprMonkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlckStMonkey}
	 * labeled alternative in {@link ownParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlckStMonkey(ownParser.BlckStMonkeyContext ctx);
}