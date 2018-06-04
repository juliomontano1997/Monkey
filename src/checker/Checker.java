package checker;
import generated.ownParser;

public class Checker extends generated.ownParserBaseVisitor
{
    private VariablesTable variablesTable;
    private MethodsTable methodsTable;
    private static final int NONE = -1;
    private static final int NEUTRAL = 0;
    private static final int INT = 1;
    private static final int STRING = 2;
    private static final int BOOLEAN = 3;
    private static final int ARRAY = 4;
    private static final int HASH_LITERAL = 5;
    private static final int FUNCTION = 6;
    private String  VARIABLE_NAME = null;
    private int PARAMS_NUMBER = 0;


    public Checker()
    {
        this.variablesTable = new VariablesTable();
        this.methodsTable = new MethodsTable();
    }

    // DONE
    @Override
    public Object visitProgMonkey(ownParser.ProgMonkeyContext ctx) {
        for(ownParser.StatementContext ele : ctx.statement())
        {
            visit(ele);
        }
        return null;
    }

    // DONE
    @Override
    public Object visitStLetMonkey(ownParser.StLetMonkeyContext ctx) {
        visit(ctx.letStatement());
        return null;
    }

    // DONE
    @Override
    public Object visitStRtnMonkey(ownParser.StRtnMonkeyContext ctx) {
        return visit(ctx.returnStatement()); // Revisar este retorno.
    }

    // DONE
    @Override
    public Object visitStExprMonkey(ownParser.StExprMonkeyContext ctx) {

        return visit(ctx.expressionStatement());
    }


    @Override
    public Object visitLetStMonkey(ownParser.LetStMonkeyContext ctx) {
        VariablesTable.Element responseV = this.variablesTable.search(ctx.ID().getText());
        MethodsTable.Element responseM = this.methodsTable.search(ctx.ID().getText());
        VARIABLE_NAME = ctx.ID().getText();

        if(responseM== null && responseV==null)
        {
            int type = (Integer) visit(ctx.expression());
            if(type!=FUNCTION && type!= NONE)
            {
                variablesTable.insert(ctx.ID().getText(), type, ctx);
            }
            else if(type==NONE)
            {
                throw new CheckerErrors("Error: Declaration error invalid type");
            }
            else
            {
                methodsTable.search(ctx.ID().getText()).context = ctx;
            }
        }
        else if(responseM!= null && responseV==null)
        {
            int type = (Integer) visit(ctx.expression());
            if(type!=FUNCTION && type!= NONE)
            {
                variablesTable.insert(ctx.ID().getText(), type, ctx);
                methodsTable.getTable().remove(responseM);
            }
            else if(type==NONE)
            {
                throw new CheckerErrors("\"Error: Declaration error invalid type\"");
            }
            else
            {
                methodsTable.search(ctx.ID().getText()).context = ctx;
            }
        }
        else if (responseM == null)
        {
            int type = (Integer) visit(ctx.expression());
            if(type!=FUNCTION && type!= NONE)
            {
                variablesTable.insert(ctx.ID().getText(), type, ctx);
                variablesTable.getTable().remove(responseV);
            }
            else if(type==NONE)
            {
                throw new CheckerErrors("\"Error: Declaration invalid type\"");
            }
            else{
                methodsTable.search(ctx.ID().getText()).context = ctx;
            }
        }

        return null;
    }

    @Override
    public Object visitRtnStMonkey(ownParser.RtnStMonkeyContext ctx) {
        return visit(ctx.expression());
    }

    // DONE
    @Override
    public Object visitExprStMonkey(ownParser.ExprStMonkeyContext ctx) {
        return visit(ctx.expression());
    }

    //DONE
    @Override
    public Object visitCompMenMonkey(ownParser.CompMenMonkeyContext ctx) {
        if(ctx.additionExpression().size() == 1 && ctx.MENOR().size()==0)
        {
            return visit(ctx.additionExpression(0));
        }
        else if(ctx.additionExpression().size()==2 && ctx.MENOR().size()==1)
        {
            int type1= (Integer) visit(ctx.additionExpression(0));
            int type2= (Integer) visit(ctx.additionExpression(1));
            if ((type1 == NEUTRAL || type1 == INT)&&(type2 == NEUTRAL || type2 == INT))
            {
                return BOOLEAN;
            }
            else
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");
            }
        }
        else {
            return NONE;
        }
    }

    //DONE
    @Override
    public Object visitCompMayMonkey(ownParser.CompMayMonkeyContext ctx)
    {
        if(ctx.additionExpression().size() == 1 && ctx.MAYOR().size()==0)
        {
            return visit(ctx.additionExpression(0));
        }
        else if(ctx.additionExpression().size()==2 && ctx.MAYOR().size()==1)
        {
            int type1= (Integer) visit(ctx.additionExpression(0));
            int type2= (Integer) visit(ctx.additionExpression(1));
            if ((type1 == NEUTRAL || type1 == INT)&&(type2 == NEUTRAL || type2 == INT))
            {
                return BOOLEAN;
            }
            else
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");
            }
        }
        else {
            return NONE;
        }
    }

    //DONE
    @Override
    public Object visitCompMeIMonkey(ownParser.CompMeIMonkeyContext ctx) {
        if(ctx.additionExpression().size() == 1 && ctx.MENORIGUAL().size()==0)
        {
            return visit(ctx.additionExpression(0));
        }
        else if(ctx.additionExpression().size()==2 && ctx.MENORIGUAL().size()==1)
        {
            int type1= (Integer) visit(ctx.additionExpression(0));
            int type2= (Integer) visit(ctx.additionExpression(1));
            if ((type1 == NEUTRAL || type1 == INT)&&(type2 == NEUTRAL || type2 == INT))
            {
                return BOOLEAN;
            }
            else
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");
            }
        }
        else {
            return NONE;
        }
    }

    //DONE
    @Override
    public Object visitCompMaIMonkey(ownParser.CompMaIMonkeyContext ctx) {
        if(ctx.additionExpression().size() == 1 && ctx.MAYORIGUAL().size()==0)
        {
            return visit(ctx.additionExpression(0));
        }
        else if(ctx.additionExpression().size()==2 && ctx.MAYORIGUAL().size()==1)
        {
            int type1= (Integer) visit(ctx.additionExpression(0));
            int type2= (Integer) visit(ctx.additionExpression(1));
            if ((type1 == NEUTRAL || type1 == INT)&&(type2 == NEUTRAL || type2 == INT))
            {
                return BOOLEAN;
            }
            else
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");
            }
        }
        else {
            return NONE;
        }
    }

    //DONE
    @Override
    public Object visitCompIgMonkey(ownParser.CompIgMonkeyContext ctx) {
        if(ctx.additionExpression().size() == 1 && ctx.IGUALCOMP().size()==0)
        {
            return visit(ctx.additionExpression(0));
        }
        else if(ctx.additionExpression().size()==2 && ctx.IGUALCOMP().size()==1)
        {
            int type1= (Integer) visit(ctx.additionExpression(0));
            int type2= (Integer) visit(ctx.additionExpression(1));

            if (type1 != NONE && type2!= NONE &&(type1==INT || type1==STRING || type1==NEUTRAL || type1==BOOLEAN)&&(type2==INT || type2==STRING || type2==NEUTRAL || type2==BOOLEAN))
            {
                if(type1==NEUTRAL || type2==NEUTRAL)
                {
                    return BOOLEAN;
                }
                else if(type1==type2)
                {
                    return BOOLEAN;
                }
                else {
                    return NONE;
                }
            }
            else
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");
            }
        }
        else {
            return NONE;
        }
    }

    //DONE
    @Override
    public Object visitAddFSumMonkey(ownParser.AddFSumMonkeyContext ctx) {
        if(ctx.multiplicationExpression().size() == 1 && ctx.SUM().size()==0)
        {
            return visit(ctx.multiplicationExpression(0));
        }
        int type;
        for (ownParser.MultiplicationExpressionContext element: ctx.multiplicationExpression()){
            type = (Integer) visit(element);
            if(type != INT && type != NEUTRAL)
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");
            }
        }
        return INT;
    }

    //DONE
    @Override
    public Object visitAddFSubMonkey(ownParser.AddFSubMonkeyContext ctx) {
        if(ctx.multiplicationExpression().size() == 1 && ctx.SUB().size()==0)
        {
            return visit(ctx.multiplicationExpression(0));
        }
        int type;
        for (ownParser.MultiplicationExpressionContext element: ctx.multiplicationExpression()){
            type = (Integer) visit(element);
            if(type != INT && type != NEUTRAL)
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");
            }
        }
        return INT;
    }

    //DONE
    @Override
    public Object visitMulFMulMonkey(ownParser.MulFMulMonkeyContext ctx) {
        if(ctx.elementExpression().size() == 1 && ctx.MUL().size()==0)
        {
            return visit(ctx.elementExpression(0));
        }

        int type;
        for (ownParser.ElementExpressionContext element: ctx.elementExpression()){
            type = (Integer) visit(element);

            if(type != INT && type != NEUTRAL)
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");

            }
        }
        return INT;
    }

    //DONE
    @Override
    public Object visitMulFDivMonkey(ownParser.MulFDivMonkeyContext ctx) {
        if(ctx.elementExpression().size() == 1 && ctx.DIV().size()==0)
        {
            return visit(ctx.elementExpression(0));
        }

        int type;
        for (ownParser.ElementExpressionContext element: ctx.elementExpression()){
            type = (Integer) visit(element);

            if(type != INT && type != NEUTRAL)
            {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");

            }
        }
        return INT;
    }

    //DONE
    @Override
    public Object visitElemExprEAcMonkey(ownParser.ElemExprEAcMonkeyContext ctx) {
        return visit(ctx.elementAccess());
    }
    //DONE
    @Override
    public Object visitElemExprCExpMonkey(ownParser.ElemExprCExpMonkeyContext ctx) {
        return visit(ctx.callExpression());
    }
    //DONE
    @Override
    public Object visitElemExprPrimiMonkey(ownParser.ElemExprPrimiMonkeyContext ctx) {
        return visit(ctx.primitiveExpression());
    }

    @Override
    public Object visitElemAcsMonkey(ownParser.ElemAcsMonkeyContext ctx) {
        int type = (Integer) visit(ctx.primitiveExpression());
        if(type==NEUTRAL)
        {
            return NEUTRAL;
        }
        if(type == ARRAY)
        {
            for(ownParser.ExpressionContext element : ctx.expression())
            {
                int tyExp = (Integer) visit(element);
                if(tyExp != INT && tyExp != NEUTRAL)
                {
                    throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER} ");
                }
            }
            return NEUTRAL;
        }
        else if (type == HASH_LITERAL)
        {
            for (ownParser.ExpressionContext element:ctx.expression()) {
                int tyExp = (Integer) visit(element);
                if(tyExp != INT && tyExp != STRING && tyExp != NEUTRAL)
                {
                    throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER, STRING} ");

                }
            }
            return NEUTRAL;
        }
        else
        {
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {ARRAY, HASH} ");
        }
    }



    @Override
    public Object visitCallExprMonkey(ownParser.CallExprMonkeyContext ctx)
    {
        int typeExp =(Integer) visit(ctx.primitiveExpression());

        if(typeExp==NEUTRAL)
        {
            return NEUTRAL;
        }
        if(typeExp == FUNCTION)
        {
            visit(ctx.expressionList());
            MethodsTable.Element method = this.methodsTable.search(ctx.primitiveExpression().getText());
            if(this.PARAMS_NUMBER == method.numberParams)
            {
                return NEUTRAL;
            }
            else {
                throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible number of params: expected "+method.numberParams+" dado:"+this.PARAMS_NUMBER);
            }
        }
        throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {FUNCTION} ");
    }




    //DONE
    @Override
    public Object visitPrimExprIntMonkey(ownParser.PrimExprIntMonkeyContext ctx) {
        return INT;
    }
    //DONE
    @Override
    public Object visitPrimExprStrMonkey(ownParser.PrimExprStrMonkeyContext ctx) {
        return STRING;
    }

    //DONE
    @Override
    public Object visitPrimExprIdMonkey(ownParser.PrimExprIdMonkeyContext ctx) {
        return visit(ctx.identifier());
    }


    //DONE
    @Override
    public Object visitPrimExprTMonkey(ownParser.PrimExprTMonkeyContext ctx) {
        return BOOLEAN;
    }

    //DONE
    @Override
    public Object visitPrimExprFMonkey(ownParser.PrimExprFMonkeyContext ctx) {
        return BOOLEAN;
    }

    @Override
    public Object visitPrimExprMonkey(ownParser.PrimExprMonkeyContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitPrimArrLMonkey(ownParser.PrimArrLMonkeyContext ctx) {
        return visit(ctx.arrayLiteral());
    }

    @Override
    public Object visitPrimArrFMonkey(ownParser.PrimArrFMonkeyContext ctx) {
        int typeArrF = (Integer) visit(ctx.arrayFunctions());
        int type = (Integer) visit(ctx.primitiveExpression());
        if(type == ARRAY || type == NEUTRAL)
        {
            return typeArrF;
        }
        else
        {
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {ARRAY}");
        }
    }

    //DONE
    @Override
    public Object visitPrimFunLtlMonkey(ownParser.PrimFunLtlMonkeyContext ctx) {
        return visit(ctx.functionLiteral());
    }
    //DONE
    @Override
    public Object visitPrimHshLtlMonkey(ownParser.PrimHshLtlMonkeyContext ctx) {
        return visit(ctx.hashLiteral());
    }
    //DONE
    @Override
    public Object visitPrimPrtExprMonkey(ownParser.PrimPrtExprMonkeyContext ctx) {
        return visit(ctx.printExpression());
    }

    @Override
    public Object visitPrimIfExprMonkey(ownParser.PrimIfExprMonkeyContext ctx) {
        return visit(ctx.ifExpression());
    }



    @Override
    public Object visitArrFLenMonkey(ownParser.ArrFLenMonkeyContext ctx) {
        return INT;
    }

    @Override
    public Object visitArrFFirMonkey(ownParser.ArrFFirMonkeyContext ctx) {
        return NEUTRAL;
    }

    @Override
    public Object visitArrFLstMonkey(ownParser.ArrFLstMonkeyContext ctx) {
        return NEUTRAL;
    }

    @Override
    public Object visitArrFRstMonkey(ownParser.ArrFRstMonkeyContext ctx) {
        return ARRAY;
    }

    @Override
    public Object visitArrFPshMonkey(ownParser.ArrFPshMonkeyContext ctx) {
        return ARRAY;
    }


    //DONE
    @Override
    public Object visitArrLtlMonkey(ownParser.ArrLtlMonkeyContext ctx) {
        int type =(Integer) visit(ctx.expressionList());

        if(type == NONE)
        {
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {ARRAY} ");

        }
        return ARRAY;
    }

    @Override
    public Object visitFunLtlMonkey(ownParser.FunLtlMonkeyContext ctx) {
        variablesTable.openScope();
        methodsTable.openScope();
        methodsTable.insert(VARIABLE_NAME, NEUTRAL, ctx.getParent());
        visit(ctx.functionParameters());
        methodsTable.search(VARIABLE_NAME).setNumberParams(PARAMS_NUMBER);
        methodsTable.search(VARIABLE_NAME).level-=1;
        visit(ctx.blockStatement());
        variablesTable.closeScope();
        methodsTable.closeScope();
        return FUNCTION;
    }

    //DONE
    @Override
    public Object visitFunPrmtMonkey(ownParser.FunPrmtMonkeyContext ctx) {
        this.PARAMS_NUMBER=0;
        if (ctx.ID().isEmpty()){return NONE;}
        int i = 0;
        while (i< ctx.ID().size())
        {
            variablesTable.insert(ctx.ID().get(i).getText(),NEUTRAL,ctx);
            this.PARAMS_NUMBER++;
            i++;
        }
        return NEUTRAL;
    }

    //DONE
    @Override
    public Object visitHshLtlMonkey(ownParser.HshLtlMonkeyContext ctx) {
        int typeHC = (Integer) visit(ctx.hashContent());
        int typeMHC =(Integer) visit(ctx.moreHashContent());
        if(typeHC == HASH_LITERAL && typeMHC == HASH_LITERAL)
        {
            return HASH_LITERAL;
        }
        else
        {
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {HASH} ");
        }
    }

    //DONE
    @Override
    public Object visitHshCntMonkey(ownParser.HshCntMonkeyContext ctx) {
        int typeExp1 = (Integer) visit(ctx.expression(0));
        int typeExp2 = (Integer) visit(ctx.expression(1));

        if((typeExp1 == INT || typeExp1 == STRING) && typeExp2 != NONE )
        {
            return HASH_LITERAL;
        }
        else{
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {HASh} ");
        }
    }

    //DONE
    @Override
    public Object visitMreHshCntMonkey(ownParser.MreHshCntMonkeyContext ctx) {
        for (ownParser.HashContentContext element:ctx.hashContent()) {
            if((int)visit(element)!= HASH_LITERAL)
            {
                return NONE;
            }
        }
        return HASH_LITERAL;
    }

    //DONE
    @Override
    public Object visitExprLstMonkey(ownParser.ExprLstMonkeyContext ctx) {
        this.PARAMS_NUMBER=0;
        int typeExp;
        for(ownParser.ExpressionContext element : ctx.expression())
        {
            typeExp = (Integer)visit(element);
            if(typeExp == NONE)
            {
                this.PARAMS_NUMBER = 0;
                return NONE;
            }
            this.PARAMS_NUMBER++;
        }
        return ARRAY;
    }

    //DONE
    @Override
    public Object visitPrtExprMonkey(ownParser.PrtExprMonkeyContext ctx) {
        int typeExp =(Integer) visit(ctx.expression());
        if(typeExp != NONE && typeExp!=FUNCTION)
        {
            return NONE;
        }
        else {
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {INTEGER, STRING, ARRAY, BOOLEAN} ");
        }
    }

    //DONE
    @Override
    public Object visitIfElseExprMonkey(ownParser.IfElseExprMonkeyContext ctx) {
        int type = (Integer) visit(ctx.expression());

        if(type == BOOLEAN || type == NEUTRAL)
        {
            variablesTable.openScope();
            methodsTable.openScope();
            visit(ctx.blockStatement(0));
            variablesTable.closeScope();
            methodsTable.closeScope();

            variablesTable.openScope();
            methodsTable.openScope();
            visit(ctx.blockStatement(1));
            variablesTable.closeScope();
            methodsTable.closeScope();

            return NONE;
        }
        else
        {
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {BOOLEAN, NEUTRAL}");

        }
    }

    //DONE
    @Override
    public Object visitIfExprMonkey(ownParser.IfExprMonkeyContext ctx) {
        int type = (Integer) visit(ctx.expression());

        if(type == BOOLEAN || type == NEUTRAL)
        {
            variablesTable.openScope();
            methodsTable.openScope();
            visit(ctx.blockStatement());
            variablesTable.closeScope();
            methodsTable.closeScope();
            return NONE;
        }
        else
        {
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types expecting {BOOLEAN, NEUTRAL");

        }
    }

    //DONE
    @Override
    public Object visitBlckStMonkey(ownParser.BlckStMonkeyContext ctx) {
        for(ownParser.StatementContext statementContext : ctx.statement())
        {
            visit(statementContext);
        }
        return NONE;
    }

    @Override
    public Object visitIdMonkey(ownParser.IdMonkeyContext ctx) {
        VariablesTable.Element variable = variablesTable.search(ctx.ID().getText());
        MethodsTable.Element method = methodsTable.search(ctx.ID().getText());
        if (variable!= null)
        {
            ctx.decl = variable.context;
            return variable.type;
        }
        else if(method != null)
        {
            ctx.decl = method.context;
            return FUNCTION;
        }
        else
        {
            throw new CheckerErrors("Error:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " variable " +ctx.ID().getText()+" is not defined");
        }
    }
}
