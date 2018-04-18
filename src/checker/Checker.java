package checker;

import generated.ownParser;
/*
Data Types:
-1 none
0 neutral
1 int
2 string
3 boolean
 */

public class Checker extends generated.ownParserBaseVisitor
{
    VariableSymbolsTable variableSymbolsTable;
    MethodSymbolsTable methodSymbolsTable;
    @Override
    public Object visitProgMonkey(ownParser.ProgMonkeyContext ctx)
    {
        for(ownParser.StatementContext element: ctx.statement())
        {
            visit(element);
        }
        return null;
    }

    @Override
    public Object visitStLetMonkey(ownParser.StLetMonkeyContext ctx)
    {
        //Open scope
        visit(ctx.letStatement());
        return null;
    }

    @Override
    public Object visitStRtnMonkey(ownParser.StRtnMonkeyContext ctx)
    {
        visit(ctx.returnStatement());
        return null;
    }

    @Override
    public Object visitStExprMonkey(ownParser.StExprMonkeyContext ctx)
    {
        visit(ctx.expressionStatement());
        return null;
    }


    @Override
    public Object visitLetStMonkey(ownParser.LetStMonkeyContext ctx)
    {
        // meter en la tabla
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitRtnStMonkey(ownParser.RtnStMonkeyContext ctx)
    {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExprStMonkey(ownParser.ExprStMonkeyContext ctx)
    {
        visit(ctx.expression());
        return null;
    }


    @Override
    public Object visitExprMonkey(ownParser.ExprMonkeyContext ctx)
    {
        int typeME; // Multiplication expression type
        int typeAF; // Addition factor type

        typeME = (int) visit(ctx.additionExpression());
        typeAF = (int) visit(ctx.comparison());
        if(typeME==typeAF)
        {
            return typeAF;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public Object visitCompMenMonkey(ownParser.CompMenMonkeyContext ctx)
    {
        return super.visitCompMenMonkey(ctx);
    }

    @Override
    public Object visitCompMayMonkey(ownParser.CompMayMonkeyContext ctx)
    {
        return super.visitCompMayMonkey(ctx);
    }

    @Override
    public Object visitCompMeIMonkey(ownParser.CompMeIMonkeyContext ctx)
    {
        return super.visitCompMeIMonkey(ctx);
    }

    @Override
    public Object visitCompMaIMonkey(ownParser.CompMaIMonkeyContext ctx)
    {
        return super.visitCompMaIMonkey(ctx);
    }

    @Override
    public Object visitCompIgMonkey(ownParser.CompIgMonkeyContext ctx)
    {
        return super.visitCompIgMonkey(ctx);
    }



    @Override
    public Object visitAddExprMonkey(ownParser.AddExprMonkeyContext ctx)
    {
        return super.visitAddExprMonkey(ctx);
    }

    @Override
    public Object visitAddFSumMonkey(ownParser.AddFSumMonkeyContext ctx)
    {
        return super.visitAddFSumMonkey(ctx);
    }

    @Override
    public Object visitAddFSubMonkey(ownParser.AddFSubMonkeyContext ctx)
    {
        return super.visitAddFSubMonkey(ctx);
    }

    @Override
    public Object visitMulExprMonkey(ownParser.MulExprMonkeyContext ctx)
    {
        return super.visitMulExprMonkey(ctx);
    }

    @Override
    public Object visitMulFMulMonkey(ownParser.MulFMulMonkeyContext ctx)
    {
        return super.visitMulFMulMonkey(ctx);
    }

    @Override
    public Object visitMulFDivMonkey(ownParser.MulFDivMonkeyContext ctx)
    {
        return super.visitMulFDivMonkey(ctx);
    }

    @Override
    public Object visitElemExprMonkey(ownParser.ElemExprMonkeyContext ctx)
    {
        return super.visitElemExprMonkey(ctx);
    }

    @Override
    public Object visitElemAcsMonkey(ownParser.ElemAcsMonkeyContext ctx)
    {
        return super.visitElemAcsMonkey(ctx);
    }

    @Override
    public Object visitCallExprMonkey(ownParser.CallExprMonkeyContext ctx)
    {
        return super.visitCallExprMonkey(ctx);
    }

    @Override
    public Object visitPrimExprIntMonkey(ownParser.PrimExprIntMonkeyContext ctx)
    {
        return 1;
    }

    @Override
    public Object visitPrimExprStrMonkey(ownParser.PrimExprStrMonkeyContext ctx)
    {
        return 2;
    }

    @Override
    public Object visitPrimExprIdMonkey(ownParser.PrimExprIdMonkeyContext ctx)
    {
        // Buscar id en la tabla y retornar el tipo
        return super.visitPrimExprIdMonkey(ctx);
    }

    @Override
    public Object visitPrimExprTMonkey(ownParser.PrimExprTMonkeyContext ctx)
    {
        return 3;
    }

    @Override
    public Object visitPrimExprFMonkey(ownParser.PrimExprFMonkeyContext ctx) {
        return 3;
    }

    @Override
    public Object visitPrimExprMonkey(ownParser.PrimExprMonkeyContext ctx)
    {
        int typeExp = (int) visit(ctx.expression());
        return typeExp;
    }

    @Override
    public Object visitPrimArrLMonkey(ownParser.PrimArrLMonkeyContext ctx)
    {
        return super.visitPrimArrLMonkey(ctx);
    }

    @Override
    public Object visitPrimArrFMonkey(ownParser.PrimArrFMonkeyContext ctx)
    {
        return super.visitPrimArrFMonkey(ctx);
    }

    @Override
    public Object visitPrimFunLtlMonkey(ownParser.PrimFunLtlMonkeyContext ctx)
    {
        return super.visitPrimFunLtlMonkey(ctx);
    }

    @Override
    public Object visitPrimHshLtlMonkey(ownParser.PrimHshLtlMonkeyContext ctx)
    {
        return super.visitPrimHshLtlMonkey(ctx);
    }

    @Override
    public Object visitPrimPrtExprMonkey(ownParser.PrimPrtExprMonkeyContext ctx)
    {
        return super.visitPrimPrtExprMonkey(ctx);
    }

    @Override
    public Object visitPrimIfExprMonkey(ownParser.PrimIfExprMonkeyContext ctx)
    {
        return super.visitPrimIfExprMonkey(ctx);
    }

    @Override
    public Object visitArrFLenMonkey(ownParser.ArrFLenMonkeyContext ctx)
    {
        return super.visitArrFLenMonkey(ctx);
    }

    @Override
    public Object visitArrFFirMonkey(ownParser.ArrFFirMonkeyContext ctx)
    {
        return super.visitArrFFirMonkey(ctx);
    }

    @Override
    public Object visitArrFRstMonkey(ownParser.ArrFRstMonkeyContext ctx) {
        return super.visitArrFRstMonkey(ctx);
    }

    @Override
    public Object visitArrFPshMonkey(ownParser.ArrFPshMonkeyContext ctx)
    {
        return super.visitArrFPshMonkey(ctx);
    }

    @Override
    public Object visitArrLtlMonkey(ownParser.ArrLtlMonkeyContext ctx) {
        return super.visitArrLtlMonkey(ctx);
    }

    @Override
    public Object visitFunLtlMonkey(ownParser.FunLtlMonkeyContext ctx)
    {
        return super.visitFunLtlMonkey(ctx);
    }

    @Override
    public Object visitFunPrmtMonket(ownParser.FunPrmtMonketContext ctx)
    {
        return super.visitFunPrmtMonket(ctx);
    }

    @Override
    public Object visitMreIdentMonkey(ownParser.MreIdentMonkeyContext ctx)
    {
        return super.visitMreIdentMonkey(ctx);
    }

    @Override
    public Object visitHshLtlMonkey(ownParser.HshLtlMonkeyContext ctx)
    {
        return super.visitHshLtlMonkey(ctx);
    }

    @Override
    public Object visitHshCntMonkey(ownParser.HshCntMonkeyContext ctx)
    {
        return super.visitHshCntMonkey(ctx);
    }

    @Override
    public Object visitMreHshCntMonkey(ownParser.MreHshCntMonkeyContext ctx)
    {
        return super.visitMreHshCntMonkey(ctx);
    }

    @Override
    public Object visitExprLstMreMonkey(ownParser.ExprLstMreMonkeyContext ctx)
    {
        return super.visitExprLstMreMonkey(ctx);
    }

    @Override
    public Object visitExprLstMonkey(ownParser.ExprLstMonkeyContext ctx)
    {
        return super.visitExprLstMonkey(ctx);
    }

    @Override
    public Object visitMreExprMonkey(ownParser.MreExprMonkeyContext ctx)
    {
        return super.visitMreExprMonkey(ctx);
    }

    @Override
    public Object visitPrtExprMonkey(ownParser.PrtExprMonkeyContext ctx)
    {
        return super.visitPrtExprMonkey(ctx);
    }

    @Override
    public Object visitIfElseExprMonkey(ownParser.IfElseExprMonkeyContext ctx)
    {
        return super.visitIfElseExprMonkey(ctx);
    }

    @Override
    public Object visitIfExprMonkey(ownParser.IfExprMonkeyContext ctx)
    {
        int typeExp = (int)visit(ctx.expression());  // Hay que verificar el tipo de expression retornada?
        return super.visitIfExprMonkey(ctx);
    }

    @Override
    public Object visitBlckStMonkey(ownParser.BlckStMonkeyContext ctx)
    {
        // abrir nuevo nivel
        for(ownParser.StatementContext statementContext : ctx.statement())
        {
            visit(statementContext);
        }
        return null;
    }

    @Override
    public Object visitArrFLstMonkey(ownParser.ArrFLstMonkeyContext ctx)
    {
        return super.visitArrFLstMonkey(ctx);
    }
}
