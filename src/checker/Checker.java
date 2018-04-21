package checker;

import generated.ownParser;

import java.util.ArrayList;
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
    ArrayList<String> errors = new ArrayList(); //lista para almacenar los errores

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
        int typeAD; // Addition expression type
        int typeC; // Comparison type

        typeAD = (int) visit(ctx.additionExpression());
        typeC = (int) visit(ctx.comparison());
        if(typeAD == typeC)
        {
            return typeC;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public Object visitCompMenMonkey(ownParser.CompMenMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.additionExpression(0));
        for (int i=0; i<= ctx.additionExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.additionExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitCompMayMonkey(ownParser.CompMayMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.additionExpression(0));
        for (int i=0; i<= ctx.additionExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.additionExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitCompMeIMonkey(ownParser.CompMeIMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.additionExpression(0));
        for (int i=0; i<= ctx.additionExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.additionExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitCompMaIMonkey(ownParser.CompMaIMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.additionExpression(0));
        for (int i=0; i<= ctx.additionExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.additionExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitCompIgMonkey(ownParser.CompIgMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.additionExpression(0));
        for (int i=0; i<= ctx.additionExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.additionExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitAddExprMonkey(ownParser.AddExprMonkeyContext ctx)
    {
        int typeME; // Multiplication expression type
        int typeAF; // Addition factor type

        typeME = (int) visit(ctx.multiplicationExpression());
        typeAF = (int) visit(ctx.additionFactor());
        if(typeME == typeAF)
        {
            return typeAF;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public Object visitAddFSumMonkey(ownParser.AddFSumMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.multiplicationExpression(0));
        for (int i=0; i<= ctx.multiplicationExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.multiplicationExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitAddFSubMonkey(ownParser.AddFSubMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.multiplicationExpression(0));
        for (int i=0; i<= ctx.multiplicationExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.multiplicationExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitMulExprMonkey(ownParser.MulExprMonkeyContext ctx)
    {
        int typeEE; // Element expression type
        int typeMF; // Multiplication factor type

        typeEE = (int) visit(ctx.elementExpression());
        typeMF = (int) visit(ctx.multiplicationFactor());
        if(typeEE == typeMF)
        {
            return typeMF;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public Object visitMulFMulMonkey(ownParser.MulFMulMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.elementExpression(0));
        for (int i=0; i<= ctx.elementExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.elementExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitMulFDivMonkey(ownParser.MulFDivMonkeyContext ctx)
    {
        int t1 = -1;
        int t2 = -1;
        t1 = (Integer) visit(ctx.elementExpression(0));
        for (int i=0; i<= ctx.elementExpression().size()-1; i++) {
            t2 = (Integer) visit(ctx.elementExpression(i + 1));
            if(t1 == -1 || t2 == -1 || t1 == 2 || t2 == 2 || t1 == 3 || t2 == 3)
            {
                //falta hacer el error
                return -1;
            }
            else if (t1 != t2) {

                return -1;
            }
            t1 = t2;
        }
        return t1;
    }

    @Override
    public Object visitElemExprMonkey(ownParser.ElemExprMonkeyContext ctx)
    {
        ctx.primitiveExpression();
        if(ctx.children.equals(ownParser.ElementAccessContext.class))
        {
            ctx.elementAccess();
        }
        else if(ctx.children.equals(ownParser.CallExpressionContext.class))
        {
            ctx.callExpression();
        }
        return null;
    }

    @Override
    public Object visitElemAcsMonkey(ownParser.ElemAcsMonkeyContext ctx)
    {
        ctx.expression();
        return null;
    }

    @Override
    public Object visitCallExprMonkey(ownParser.CallExprMonkeyContext ctx)
    {
        ctx.expressionList();
        return null;
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
        VariableSymbolsTable.Ident i;
        if ((i = this.variableSymbolsTable.search(ctx.ID().getText())) != null) {
            return i.type;
        }/*
        else if((i = this.methodSymbolsTable.search(ctx.ID().getText())) != null))
        {

        }*///si es un metodo?
        return -1;
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
