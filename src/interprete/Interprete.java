package interprete;
import generated.ownParser;


import java.lang.reflect.Array;
import java.util.*;
public class Interprete extends generated.ownParserBaseVisitor {
    public  DataStorage dataStorage = new DataStorage();
    public  EvaluationStack evaluationStack = new EvaluationStack();

    public String logs = "";
    private boolean IN_RETURN = false;

    public Interprete(){
    }

    @Override
    public Object visitProgMonkey(ownParser.ProgMonkeyContext ctx) {
        for (ownParser.StatementContext statementContext : ctx.statement()) {
            visit(statementContext);
        }
        return null;
    }

    //DONE
    @Override
    public Object visitStLetMonkey(ownParser.StLetMonkeyContext ctx) {
        if(!IN_RETURN)
        {
            visit(ctx.letStatement());
        }
        return null;
    }

    @Override
    public Object visitStRtnMonkey(ownParser.StRtnMonkeyContext ctx) {
        if(!IN_RETURN){
            visit(ctx.returnStatement());
            this.IN_RETURN = true;
        }
        return null;
    }

    //DONE
    @Override
    public Object visitStExprMonkey(ownParser.StExprMonkeyContext ctx) {
        if (!IN_RETURN){
            visit(ctx.expressionStatement());
        }
        return null;
    }













    //DONE
    @Override
    public Object visitLetStMonkey(ownParser.LetStMonkeyContext ctx) {
        visit(ctx.expression());
        ctx.storageIndex = this.dataStorage.getActualStorageIndex();
        Object value =  this.evaluationStack.popValue();
        this.dataStorage.addData(ctx.ID().getText(),value);
        return null;
    }

    //DONE
    @Override
    public Object visitRtnStMonkey(ownParser.RtnStMonkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }

    //DONE
    @Override
    public Object visitExprStMonkey(ownParser.ExprStMonkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }


    //DONE
    @Override
    public Object visitCompMenMonkey(ownParser.CompMenMonkeyContext ctx) {
        if (ctx.additionExpression().size() == 1) {
            visit(ctx.additionExpression(0));
            return null;
        } else {
            visit(ctx.additionExpression(0));
            visit(ctx.additionExpression(1));
            Object b = this.evaluationStack.popValue();
            Object a = this.evaluationStack.popValue();
            if(a.getClass().toString().equals("class java.lang.Integer")&& b.getClass().toString().equals("class java.lang.Integer"))
            {
                this.evaluationStack.pushValue((int)a < (int)b);
            }
            else {
                throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types for comparation");
            }

            return null;
        }
    }

    //DONE
    @Override
    public Object visitCompMayMonkey(ownParser.CompMayMonkeyContext ctx) {
        if (ctx.additionExpression().size() == 1) {
            visit(ctx.additionExpression(0));
            return null;
        } else {
            visit(ctx.additionExpression(0));
            visit(ctx.additionExpression(1));
            Object b = this.evaluationStack.popValue();
            Object a =  this.evaluationStack.popValue();
            if(a.getClass().toString().equals("class java.lang.Integer")&& b.getClass().toString().equals("class java.lang.Integer"))
            {
                this.evaluationStack.pushValue((int)a > (int)b);
            }
            else {
                throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types for comparation");
            }

            return null;
        }
    }

    //DONE
    @Override
    public Object visitCompMeIMonkey(ownParser.CompMeIMonkeyContext ctx) {
        if (ctx.additionExpression().size() == 1) {
            visit(ctx.additionExpression(0));
            return null;
        } else {
            visit(ctx.additionExpression(0));
            visit(ctx.additionExpression(1));
            Object b = this.evaluationStack.popValue();
            Object a = this.evaluationStack.popValue();
            if(a.getClass().toString().equals("class java.lang.Integer")&& b.getClass().toString().equals("class java.lang.Integer"))
            {
                this.evaluationStack.pushValue((int)a <= (int)b);
            }
            else {
                throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types for comparation");
            }

            return null;
        }
    }

    //DONE
    @Override
    public Object visitCompMaIMonkey(ownParser.CompMaIMonkeyContext ctx) {
        if (ctx.additionExpression().size() == 1) {
            visit(ctx.additionExpression(0));
            return null;
        } else {
            visit(ctx.additionExpression(0));
            visit(ctx.additionExpression(1));
            Object b = this.evaluationStack.popValue();
            Object a = this.evaluationStack.popValue();
            if(a.getClass().toString().equals("class java.lang.Integer")&& b.getClass().toString().equals("class java.lang.Integer"))
            {
                this.evaluationStack.pushValue((int)a >= (int)b);
            }
            else {
                throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types for comparation");
            }

            return null;
        }
    }

    //DONE
    @Override
    public Object visitCompIgMonkey(ownParser.CompIgMonkeyContext ctx) {
        if (ctx.additionExpression().size() == 1) {
            visit(ctx.additionExpression(0));
            return null;
        }
        else
            {
            visit(ctx.additionExpression(0));
            visit(ctx.additionExpression(1));
            Object a =  this.evaluationStack.popValue();
            Object b =  this.evaluationStack.popValue();

            this.evaluationStack.pushValue(a == b);
            return null;
        }
    }

    //DONE
    @Override
    public Object visitAddFSumMonkey(ownParser.AddFSumMonkeyContext ctx) {
        if (ctx.multiplicationExpression().size() == 1) {
            visit(ctx.multiplicationExpression(0));
            return null;
        } else {
            for (ownParser.MultiplicationExpressionContext expression : ctx.multiplicationExpression()) {
                visit(expression);
            }

            int operatorsNumber = ctx.SUM().size();
            while (operatorsNumber > 0) {
                Object a =  this.evaluationStack.popValue();
                Object b =  this.evaluationStack.popValue();

                if(a.getClass().toString().equals("class java.lang.Integer")&& b.getClass().toString().equals("class java.lang.Integer"))
                {
                    this.evaluationStack.pushValue((int)a + (int)b);
                    operatorsNumber--;
                }
                else {
                    throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types for addition");
                }
            }
            return null;
        }
    }

    //DONE
    @Override
    public Object visitAddFSubMonkey(ownParser.AddFSubMonkeyContext ctx) {

        if (ctx.multiplicationExpression().size() == 1) {
            visit(ctx.multiplicationExpression(0));
            return null;
        } else {
            for (ownParser.MultiplicationExpressionContext expression : ctx.multiplicationExpression()) {
                visit(expression);
            }
            int operatorsNumber = ctx.SUB().size();
            while (operatorsNumber > 0) {
                Object a =  this.evaluationStack.popValue();
                Object b =  this.evaluationStack.popValue();

                if(a.getClass().toString().equals("class java.lang.Integer")&& b.getClass().toString().equals("class java.lang.Integer"))
                {
                    this.evaluationStack.pushValue((int)b - (int)a);
                    operatorsNumber--;
                }
                else {
                    throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types for substraction");
                }
            }
            return null;
        }
    }


    //DONE
    @Override
    public Object visitMulFMulMonkey(ownParser.MulFMulMonkeyContext ctx) {
        if (ctx.elementExpression().size() == 1) {
            visit(ctx.elementExpression(0));
            return null;
        } else {
            for (ownParser.ElementExpressionContext expression : ctx.elementExpression()) {
                visit(expression);
            }
            int operatorsNumber = ctx.MUL().size();
            while (operatorsNumber > 0) {
                Object a =  this.evaluationStack.popValue();
                Object b =  this.evaluationStack.popValue();

                if(a.getClass().toString().equals("class java.lang.Integer")&& b.getClass().toString().equals("class java.lang.Integer"))
                {
                    this.evaluationStack.pushValue((int)a * (int)b);
                    operatorsNumber--;
                }
                else {
                    throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " incompatible types for multiplication");
                }
            }
            return null;
        }
    }

    //DONE
    @Override
    public Object visitMulFDivMonkey(ownParser.MulFDivMonkeyContext ctx) {
        if (ctx.elementExpression().size() == 1) {
            visit(ctx.elementExpression(0));
            return null;
        } else {
            for (ownParser.ElementExpressionContext expression : ctx.elementExpression()) {
                visit(expression);
            }
            int operatorsNumber = ctx.DIV().size();
            while (operatorsNumber > 0) {
                int b = (int) this.evaluationStack.popValue();
                int a = (int) this.evaluationStack.popValue();

                if(b == 0)
                {
                    throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " division by 0");
                }

                this.evaluationStack.pushValue(a / b);
                operatorsNumber--;
            }
            return null;
        }
    }






    @Override
    public Object visitElemExprEAcMonkey(ownParser.ElemExprEAcMonkeyContext ctx) {
        visit(ctx.elementAccess());
        return null;
    }

    @Override
    public Object visitElemExprCExpMonkey(ownParser.ElemExprCExpMonkeyContext ctx) {
        visit(ctx.callExpression());
        return null;
    }

    @Override
    public Object visitElemExprPrimiMonkey(ownParser.ElemExprPrimiMonkeyContext ctx) {
        visit(ctx.primitiveExpression());
        return null;
    }




    //DONE
    @Override
    public Object visitElemAcsMonkey(ownParser.ElemAcsMonkeyContext ctx) {
        visit(ctx.primitiveExpression());
        int accessNumber = ctx.expression().size();

        int counter = 0;
        while (counter<accessNumber)
        {
            Object element = this.evaluationStack.popValue();
            if(element.getClass().toString().equals("class java.util.LinkedList"))
            {
                LinkedList linkedList = (LinkedList) element;
                visit(ctx.expression(counter));
                try
                {
                    this.evaluationStack.pushValue(linkedList.get((int)this.evaluationStack.popValue()));
                }
                catch (IndexOutOfBoundsException e)
                {
                    throw new InterpreteErrors(this.logs+"\nError:  Line " + ctx.start.getLine() + ":" +
                            ctx.start.getCharPositionInLine() + " index violation");
                }
            }

            else if(element.getClass().toString().equals("class java.util.Hashtable")){
                Hashtable hashtable = (Hashtable) element;
                visit(ctx.expression(counter));
                Object key = this.evaluationStack.popValue();
                this.evaluationStack.pushValue(hashtable.get(key));
            }
            counter++;
        }
        return null;
    }

    @Override
    public Object visitCallExprMonkey(ownParser.CallExprMonkeyContext ctx) {
        visit(ctx.primitiveExpression());

        // To get the function
        ownParser.FunLtlMonkeyContext ctxFunction;
        try{
            ctxFunction = (ownParser.FunLtlMonkeyContext) this.evaluationStack.popValue();
        }
        catch(ClassCastException e){
            throw new InterpreteErrors(this.logs+"\nError:  Line " + ctx.start.getLine() + ":" +
                    ctx.start.getCharPositionInLine() + " expected type {function}");
        }
        catch (Exception e)
        {
            throw new InterpreteErrors(this.logs+"\nError:  Line " + ctx.start.getLine() + ":" +
                    ctx.start.getCharPositionInLine() + " expected type {function}");
        }

        List<String> paramsNames = new LinkedList<>();
        List<Object> paramsValues = new LinkedList<>();
        visit(ctxFunction.functionParameters());

        int numberOfParams =(int) this.evaluationStack.popValue();
        while (numberOfParams>0)
        {
            paramsNames.add((String)this.evaluationStack.popValue());
            numberOfParams--;
        }

        visit(ctx.expressionList());
        numberOfParams =(int)this.evaluationStack.popValue();
        while (numberOfParams>0)
        {
            paramsValues.add(this.evaluationStack.popValue());
            numberOfParams--;
        }

        int iterator = 0;
        if(paramsNames.size()!=paramsValues.size())
        {
            throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() +
                    ":" + ctx.start.getCharPositionInLine() + " the number of params is incorrect");
        }
        this.dataStorage.openScope();
        while (iterator<paramsNames.size())
        {
            System.out.println(paramsNames.get(iterator)+"=>"+ paramsValues.get(iterator).toString());
            this.dataStorage.addData(paramsNames.get(iterator), paramsValues.get(iterator));
            dataStorage.print();
            iterator++;
        }
        visit(ctxFunction.blockStatement());
        this.dataStorage.closeScope();
        this.IN_RETURN = false;
        return null;
    }





    //DONE
    @Override
    public Object visitPrimExprIntMonkey(ownParser.PrimExprIntMonkeyContext ctx) {
        this.evaluationStack.pushValue(Integer.parseInt(ctx.INTEGER().getText()));
        return null;
    }
    //DONE
    @Override
    public Object visitPrimExprStrMonkey(ownParser.PrimExprStrMonkeyContext ctx) {
        this.evaluationStack.pushValue(ctx.STRING().getText());
        return null;
    }
    //DONE
    @Override
    public Object visitPrimExprIdMonkey(ownParser.PrimExprIdMonkeyContext ctx) {
        visit(ctx.identifier());
        return null;
    }
    //DONE
    @Override
    public Object visitPrimExprTMonkey(ownParser.PrimExprTMonkeyContext ctx) {
        this.evaluationStack.pushValue(true);
        return null;
    }
    //DONE
    @Override
    public Object visitPrimExprFMonkey(ownParser.PrimExprFMonkeyContext ctx) {
        this.evaluationStack.pushValue(false);
        return null;
    }
    //Done
    @Override
    public Object visitPrimExprMonkey(ownParser.PrimExprMonkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }
    //DONE
    @Override
    public Object visitPrimArrLMonkey(ownParser.PrimArrLMonkeyContext ctx) {
        visit(ctx.arrayLiteral());
        return null;
    }
    //DONE
    @Override
    public Object visitPrimArrFMonkey(ownParser.PrimArrFMonkeyContext ctx) {
        visit(ctx.primitiveExpression());
        visit(ctx.arrayFunctions());
        return null;
    }
    //DONE
    @Override
    public Object visitPrimFunLtlMonkey(ownParser.PrimFunLtlMonkeyContext ctx) {
        visit(ctx.functionLiteral());
        return null;
    }
    //DONE
    @Override
    public Object visitPrimHshLtlMonkey(ownParser.PrimHshLtlMonkeyContext ctx) {
        visit(ctx.hashLiteral());
        return null;
    }
    //DONE
    @Override
    public Object visitPrimPrtExprMonkey(ownParser.PrimPrtExprMonkeyContext ctx) {
        visit(ctx.printExpression());
        return null;
    }
    //DONE
    @Override
    public Object visitPrimIfExprMonkey(ownParser.PrimIfExprMonkeyContext ctx) {
        visit(ctx.ifExpression());
        return null;
    }







    @Override
    public Object visitArrFLenMonkey(ownParser.ArrFLenMonkeyContext ctx) {
        Object element = this.evaluationStack.popValue();
        System.out.println(element.toString());
        try{
            List theList = (List) element;
            this.evaluationStack.pushValue(theList.size());
        }
        catch (Exception e)
        {
            throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() +
                    ":" + ctx.start.getCharPositionInLine() + " expected type {ARRAY}");
        }
        return null;
    }

    @Override
    public Object visitArrFFirMonkey(ownParser.ArrFFirMonkeyContext ctx) {
        Object element = this.evaluationStack.popValue();
        try{
            List theList = (List) element;
            this.evaluationStack.pushValue(theList.get(0));
        }
        catch (Exception e)
        {
            throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() +
                    ":" + ctx.start.getCharPositionInLine() + " expected type {ARRAY}");
        }
        return null;
    }

    @Override
    public Object visitArrFLstMonkey(ownParser.ArrFLstMonkeyContext ctx) {
        Object element = this.evaluationStack.popValue();
        try{
            List theList = (List) element;
            this.evaluationStack.pushValue(theList.get(theList.size()-1));
        }
        catch (Exception e)
        {
            throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() +
                    ":" + ctx.start.getCharPositionInLine() + " expected type {ARRAY}");
        }
        return null;
    }

    @Override
    public Object visitArrFRstMonkey(ownParser.ArrFRstMonkeyContext ctx) {
        Object element = this.evaluationStack.popValue();
        try{
            List theList = (List) element;
            if(theList.size()==1)
            {
                theList.clear();
                this.evaluationStack.pushValue(theList);
            }
            else {
                this.evaluationStack.pushValue(theList.subList(1, theList.size()));
            }
        }
        catch (Exception e)
        {
            throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() +
                    ":" + ctx.start.getCharPositionInLine() + " expected type {ARRAY}");
        }
        return null;
    }

    @Override
    public Object visitArrFPshMonkey(ownParser.ArrFPshMonkeyContext ctx) {
        Object element = this.evaluationStack.popValue();
        try{
            List theList = (List) element;
            LinkedList newList;
            try
            {
                newList =(LinkedList) theList.get(0);
            }
            catch (Exception e)
            {
                throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() +
                        ":" + ctx.start.getCharPositionInLine() + "violated format espect puts([ARRAY, NEW_ELEMENT])");
            }

            Object newValue  = theList.get(1);
            newList.push(newValue);
            this.evaluationStack.pushValue(newList);
        }
        catch (Exception e)
        {
            throw new InterpreteErrors(this.logs+"\nError:  line " + ctx.start.getLine() +
                    ":" + ctx.start.getCharPositionInLine() + "violated format espect puts([ARRAY, NEW_ELEMENT])");

        }
        return null;
    }









    @Override
    public Object visitArrLtlMonkey(ownParser.ArrLtlMonkeyContext ctx) {
        visit(ctx.expressionList());
        List<Object> newArray = new LinkedList<>();
        int listSize =(int) this.evaluationStack.popValue();
        while (listSize>0)
        {
            newArray.add(this.evaluationStack.popValue());
            listSize--;
        }
        Collections.reverse(newArray);
        this.evaluationStack.pushValue(newArray);
        return null;
    }

    @Override
    public Object visitFunLtlMonkey(ownParser.FunLtlMonkeyContext ctx) {
        this.evaluationStack.pushValue(ctx);
        return null;
    }

    @Override
    public Object visitFunPrmtMonkey(ownParser.FunPrmtMonkeyContext ctx) {
        int i = 0;
        while (i< ctx.ID().size())
        {
            this.evaluationStack.pushValue(ctx.ID().get(i).getText());
            i++;
        }
        this.evaluationStack.pushValue(i);
        return null;
    }

    @Override
    public Object visitHshLtlMonkey(ownParser.HshLtlMonkeyContext ctx) {
        visit(ctx.hashContent());
        visit(ctx.moreHashContent());
        Hashtable<Object, Object> newHashTable = new Hashtable<>();
        int elementNumber = (Integer) this.evaluationStack.popValue();
        while (elementNumber>0)
        {
            newHashTable.put(this.evaluationStack.popValue(), this.evaluationStack.popValue());
            elementNumber--;
        }
        this.evaluationStack.pushValue(newHashTable);
        return null;
    }

    @Override
    public Object visitHshCntMonkey(ownParser.HshCntMonkeyContext ctx) {
        visit(ctx.expression(1));
        visit(ctx.expression(0));
        return null;
    }

    @Override
    public Object visitMreHshCntMonkey(ownParser.MreHshCntMonkeyContext ctx) {
        int elementsNumber = ctx.hashContent().size();
        for (ownParser.HashContentContext element : ctx.hashContent()){
            visit(element);
        }
        this.evaluationStack.pushValue(elementsNumber+1);
        return null;
    }

    @Override
    public Object visitExprLstMonkey(ownParser.ExprLstMonkeyContext ctx) {
        int listSize = ctx.expression().size();
        for (ownParser.ExpressionContext element : ctx.expression()) {
            visit(element);
        }
        this.evaluationStack.pushValue(listSize);
        return null;
    }

    @Override
    public Object visitPrtExprMonkey(ownParser.PrtExprMonkeyContext ctx) {
        visit(ctx.expression());
        Object result =  this.evaluationStack.popValue();
        if(result!= null){
            this.logs += "\n"+result.toString();
        }
        else {
            throw new InterpreteErrors(this.logs+"\nError:  Line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " expression return is null");
        }
        return  null;
    }

    @Override
    public Object visitIfElseExprMonkey(ownParser.IfElseExprMonkeyContext ctx) {
        visit(ctx.expression());
        if((Boolean)this.evaluationStack.popValue())
        {
            this.dataStorage.openScope();
            visit(ctx.blockStatement(0));
            this.dataStorage.closeScope();
        }
        else {
            this.dataStorage.openScope();
            visit(ctx.blockStatement(1));
            this.dataStorage.closeScope();
        }
        return null;
    }

    @Override
    public Object visitIfExprMonkey(ownParser.IfExprMonkeyContext ctx) {
        visit(ctx.expression());
        if((Boolean)this.evaluationStack.popValue())
        {
            this.dataStorage.openScope();
            visit(ctx.blockStatement());
            this.dataStorage.closeScope();
        }
        return null;
    }

    @Override
    public Object visitBlckStMonkey(ownParser.BlckStMonkeyContext ctx){
        for(ownParser.StatementContext statementContext : ctx.statement())
        {
            visit(statementContext);
        }
        return null;
    }

    @Override
    public Object visitIdMonkey(ownParser.IdMonkeyContext ctx) {
        DataStorage.Value element = this.dataStorage.getData(ctx.ID().getText());
        this.evaluationStack.pushValue(element.value);
        return null;
    }
}
