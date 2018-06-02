// Generated from C:/Users/julio/Desktop/ProyectoII/src\ownParser.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ownParser}.
 */
public interface ownParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ProgMonkey}
	 * labeled alternative in {@link ownParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgMonkey(ownParser.ProgMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgMonkey}
	 * labeled alternative in {@link ownParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgMonkey(ownParser.ProgMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StLetMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStLetMonkey(ownParser.StLetMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StLetMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStLetMonkey(ownParser.StLetMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StRtnMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStRtnMonkey(ownParser.StRtnMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StRtnMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStRtnMonkey(ownParser.StRtnMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StExprMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStExprMonkey(ownParser.StExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StExprMonkey}
	 * labeled alternative in {@link ownParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStExprMonkey(ownParser.StExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetStMonkey}
	 * labeled alternative in {@link ownParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStMonkey(ownParser.LetStMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetStMonkey}
	 * labeled alternative in {@link ownParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStMonkey(ownParser.LetStMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RtnStMonkey}
	 * labeled alternative in {@link ownParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterRtnStMonkey(ownParser.RtnStMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RtnStMonkey}
	 * labeled alternative in {@link ownParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitRtnStMonkey(ownParser.RtnStMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStMonkey}
	 * labeled alternative in {@link ownParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExprStMonkey(ownParser.ExprStMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStMonkey}
	 * labeled alternative in {@link ownParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExprStMonkey(ownParser.ExprStMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMonkey}
	 * labeled alternative in {@link ownParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMonkey(ownParser.ExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMonkey}
	 * labeled alternative in {@link ownParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMonkey(ownParser.ExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompMenMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterCompMenMonkey(ownParser.CompMenMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompMenMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitCompMenMonkey(ownParser.CompMenMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompMayMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterCompMayMonkey(ownParser.CompMayMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompMayMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitCompMayMonkey(ownParser.CompMayMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompMeIMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterCompMeIMonkey(ownParser.CompMeIMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompMeIMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitCompMeIMonkey(ownParser.CompMeIMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompMaIMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterCompMaIMonkey(ownParser.CompMaIMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompMaIMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitCompMaIMonkey(ownParser.CompMaIMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompIgMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterCompIgMonkey(ownParser.CompIgMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompIgMonkey}
	 * labeled alternative in {@link ownParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitCompIgMonkey(ownParser.CompIgMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExprMonkey}
	 * labeled alternative in {@link ownParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddExprMonkey(ownParser.AddExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExprMonkey}
	 * labeled alternative in {@link ownParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddExprMonkey(ownParser.AddExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddFSumMonkey}
	 * labeled alternative in {@link ownParser#additionFactor}.
	 * @param ctx the parse tree
	 */
	void enterAddFSumMonkey(ownParser.AddFSumMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddFSumMonkey}
	 * labeled alternative in {@link ownParser#additionFactor}.
	 * @param ctx the parse tree
	 */
	void exitAddFSumMonkey(ownParser.AddFSumMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddFSubMonkey}
	 * labeled alternative in {@link ownParser#additionFactor}.
	 * @param ctx the parse tree
	 */
	void enterAddFSubMonkey(ownParser.AddFSubMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddFSubMonkey}
	 * labeled alternative in {@link ownParser#additionFactor}.
	 * @param ctx the parse tree
	 */
	void exitAddFSubMonkey(ownParser.AddFSubMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulExprMonkey}
	 * labeled alternative in {@link ownParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMulExprMonkey(ownParser.MulExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulExprMonkey}
	 * labeled alternative in {@link ownParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMulExprMonkey(ownParser.MulExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulFMulMonkey}
	 * labeled alternative in {@link ownParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void enterMulFMulMonkey(ownParser.MulFMulMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulFMulMonkey}
	 * labeled alternative in {@link ownParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void exitMulFMulMonkey(ownParser.MulFMulMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulFDivMonkey}
	 * labeled alternative in {@link ownParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void enterMulFDivMonkey(ownParser.MulFDivMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulFDivMonkey}
	 * labeled alternative in {@link ownParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void exitMulFDivMonkey(ownParser.MulFDivMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElemExprEAcMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterElemExprEAcMonkey(ownParser.ElemExprEAcMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElemExprEAcMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitElemExprEAcMonkey(ownParser.ElemExprEAcMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElemExprCExpMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterElemExprCExpMonkey(ownParser.ElemExprCExpMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElemExprCExpMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitElemExprCExpMonkey(ownParser.ElemExprCExpMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElemExprPrimiMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterElemExprPrimiMonkey(ownParser.ElemExprPrimiMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElemExprPrimiMonkey}
	 * labeled alternative in {@link ownParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitElemExprPrimiMonkey(ownParser.ElemExprPrimiMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElemAcsMonkey}
	 * labeled alternative in {@link ownParser#elementAccess}.
	 * @param ctx the parse tree
	 */
	void enterElemAcsMonkey(ownParser.ElemAcsMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElemAcsMonkey}
	 * labeled alternative in {@link ownParser#elementAccess}.
	 * @param ctx the parse tree
	 */
	void exitElemAcsMonkey(ownParser.ElemAcsMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallExprMonkey}
	 * labeled alternative in {@link ownParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallExprMonkey(ownParser.CallExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallExprMonkey}
	 * labeled alternative in {@link ownParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallExprMonkey(ownParser.CallExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimExprIntMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimExprIntMonkey(ownParser.PrimExprIntMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimExprIntMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimExprIntMonkey(ownParser.PrimExprIntMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimExprStrMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimExprStrMonkey(ownParser.PrimExprStrMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimExprStrMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimExprStrMonkey(ownParser.PrimExprStrMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimExprIdenMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimExprIdenMonkey(ownParser.PrimExprIdenMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimExprIdenMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimExprIdenMonkey(ownParser.PrimExprIdenMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimExprTMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimExprTMonkey(ownParser.PrimExprTMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimExprTMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimExprTMonkey(ownParser.PrimExprTMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimExprFMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimExprFMonkey(ownParser.PrimExprFMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimExprFMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimExprFMonkey(ownParser.PrimExprFMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimExprMonkey(ownParser.PrimExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimExprMonkey(ownParser.PrimExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimArrLMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimArrLMonkey(ownParser.PrimArrLMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimArrLMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimArrLMonkey(ownParser.PrimArrLMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimArrFMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimArrFMonkey(ownParser.PrimArrFMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimArrFMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimArrFMonkey(ownParser.PrimArrFMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimFunLtlMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimFunLtlMonkey(ownParser.PrimFunLtlMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimFunLtlMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimFunLtlMonkey(ownParser.PrimFunLtlMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimHshLtlMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimHshLtlMonkey(ownParser.PrimHshLtlMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimHshLtlMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimHshLtlMonkey(ownParser.PrimHshLtlMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimPrtExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimPrtExprMonkey(ownParser.PrimPrtExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimPrtExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimPrtExprMonkey(ownParser.PrimPrtExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimIfExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimIfExprMonkey(ownParser.PrimIfExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimIfExprMonkey}
	 * labeled alternative in {@link ownParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimIfExprMonkey(ownParser.PrimIfExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrFLenMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrFLenMonkey(ownParser.ArrFLenMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrFLenMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrFLenMonkey(ownParser.ArrFLenMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrFFirMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrFFirMonkey(ownParser.ArrFFirMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrFFirMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrFFirMonkey(ownParser.ArrFFirMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrFLstMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrFLstMonkey(ownParser.ArrFLstMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrFLstMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrFLstMonkey(ownParser.ArrFLstMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrFRstMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrFRstMonkey(ownParser.ArrFRstMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrFRstMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrFRstMonkey(ownParser.ArrFRstMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrFPshMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrFPshMonkey(ownParser.ArrFPshMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrFPshMonkey}
	 * labeled alternative in {@link ownParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrFPshMonkey(ownParser.ArrFPshMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrLtlMonkey}
	 * labeled alternative in {@link ownParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrLtlMonkey(ownParser.ArrLtlMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrLtlMonkey}
	 * labeled alternative in {@link ownParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrLtlMonkey(ownParser.ArrLtlMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunLtlMonkey}
	 * labeled alternative in {@link ownParser#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFunLtlMonkey(ownParser.FunLtlMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunLtlMonkey}
	 * labeled alternative in {@link ownParser#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFunLtlMonkey(ownParser.FunLtlMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunPrmtMonkey}
	 * labeled alternative in {@link ownParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunPrmtMonkey(ownParser.FunPrmtMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunPrmtMonkey}
	 * labeled alternative in {@link ownParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunPrmtMonkey(ownParser.FunPrmtMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HshLtlMonkey}
	 * labeled alternative in {@link ownParser#hashLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHshLtlMonkey(ownParser.HshLtlMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HshLtlMonkey}
	 * labeled alternative in {@link ownParser#hashLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHshLtlMonkey(ownParser.HshLtlMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HshCntMonkey}
	 * labeled alternative in {@link ownParser#hashContent}.
	 * @param ctx the parse tree
	 */
	void enterHshCntMonkey(ownParser.HshCntMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HshCntMonkey}
	 * labeled alternative in {@link ownParser#hashContent}.
	 * @param ctx the parse tree
	 */
	void exitHshCntMonkey(ownParser.HshCntMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MreHshCntMonkey}
	 * labeled alternative in {@link ownParser#moreHashContent}.
	 * @param ctx the parse tree
	 */
	void enterMreHshCntMonkey(ownParser.MreHshCntMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MreHshCntMonkey}
	 * labeled alternative in {@link ownParser#moreHashContent}.
	 * @param ctx the parse tree
	 */
	void exitMreHshCntMonkey(ownParser.MreHshCntMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLstMonkey}
	 * labeled alternative in {@link ownParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExprLstMonkey(ownParser.ExprLstMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLstMonkey}
	 * labeled alternative in {@link ownParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExprLstMonkey(ownParser.ExprLstMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrtExprMonkey}
	 * labeled alternative in {@link ownParser#printExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrtExprMonkey(ownParser.PrtExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrtExprMonkey}
	 * labeled alternative in {@link ownParser#printExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrtExprMonkey(ownParser.PrtExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseExprMonkey}
	 * labeled alternative in {@link ownParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfElseExprMonkey(ownParser.IfElseExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseExprMonkey}
	 * labeled alternative in {@link ownParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfElseExprMonkey(ownParser.IfElseExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExprMonkey}
	 * labeled alternative in {@link ownParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExprMonkey(ownParser.IfExprMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExprMonkey}
	 * labeled alternative in {@link ownParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExprMonkey(ownParser.IfExprMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlckStMonkey}
	 * labeled alternative in {@link ownParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlckStMonkey(ownParser.BlckStMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlckStMonkey}
	 * labeled alternative in {@link ownParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlckStMonkey(ownParser.BlckStMonkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdMonkey}
	 * labeled alternative in {@link ownParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdMonkey(ownParser.IdMonkeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdMonkey}
	 * labeled alternative in {@link ownParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdMonkey(ownParser.IdMonkeyContext ctx);
}