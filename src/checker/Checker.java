package checker;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.bind.v2.model.core.ID;
import generated.ownParser;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
    private static final int ARRAY_FUNCTIONS = 7;



    private List<ANTLRErrorListener> _listeners = new CopyOnWriteArrayList<ANTLRErrorListener>() {
        {
            this.add(ConsoleErrorListener.INSTANCE);
        }
    };

    public void addErrorListener(ANTLRErrorListener listener)
    {
        if (listener == null)
        {
            throw new NullPointerException("listener cannot be null.");
        }
        else
        {
            this._listeners.add(listener);
        }
    }



    public Checker()
    {
        this.variablesTable = new VariablesTable();
        this.methodsTable = new MethodsTable();
    }



    @Override
    public Object visitProgMonkey(ownParser.ProgMonkeyContext ctx) {
        for(ownParser.StatementContext element : ctx.statement())
        {
            visit(element);
        }
        return NONE;
    }



    @Override
    public Object visitStLetMonkey(ownParser.StLetMonkeyContext ctx) {
        visit(ctx.letStatement());
        return NONE;
    }

    @Override
    public Object visitStRtnMonkey(ownParser.StRtnMonkeyContext ctx) {
        visit(ctx.returnStatement());
        return NONE;
    }

    @Override
    public Object visitStExprMonkey(ownParser.StExprMonkeyContext ctx) {
        visit(ctx.expressionStatement());
        return NONE;
    }




    @Override
    public Object visitLetStMonkey(ownParser.LetStMonkeyContext ctx) {
        // Falta verificar si el nombre de la variable o el metodo ya existen en la tabla contraria.
        int type = (int)visit(ctx.expression());
        if(type!= NONE && type!= FUNCTION){
            Object response = variablesTable.insert(ctx.ID().getText(), type, ctx);
            if(response!= null){
                return NONE;
            }
            else {
                System.out.println("Ocurrio un error en la insercion de la variable");
                //ERROR
                return NONE;
            }
        }
        else if (type== FUNCTION){
            Object response = variablesTable.insert(ctx.ID().getText(), type, ctx);
            if(response!= null){
                return NONE;
            }
            else {
                System.out.println("Ocurrio un error en la insercion del metodo");
                //ERROR
                return NONE;
            }
        }
        else {
            System.out.println("Ocurrio un error en la declaracion");
            // ERROR
            return NONE;
        }
    }

    @Override
    public Object visitRtnStMonkey(ownParser.RtnStMonkeyContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitExprStMonkey(ownParser.ExprStMonkeyContext ctx) {
        return visit(ctx.expression());
    }


    @Override
    public Object visitExprMonkey(ownParser.ExprMonkeyContext ctx) {
        int typeAddExp = (int) visit(ctx.additionExpression());
        //DUDE  ¿Que pasa si en ctx.comparison() no hay nada?, ¿Que hace por debajo el sistema tira algun error?
        // hay que hacer un if para ver si el comparison esta nulo
        int typeComp = (int) visit(ctx.comparison());
        if(typeAddExp==typeComp || typeComp==NEUTRAL || typeComp==NONE)
        {
            return typeAddExp;
        }
        else {
            //Error
            System.out.println("Ocurrió un error en la comparacion");
            return NONE;
        }
    }

    @Override
    public Object visitCompMenMonkey(ownParser.CompMenMonkeyContext ctx){
        int type1 = (Integer) visit(ctx.additionExpression(0));
        int type2;
        for (ownParser.AdditionExpressionContext element: ctx.additionExpression()) {
            type2 = (Integer) visit(element);
            if(type1 == NONE || type2 == NONE || type1 == STRING|| type2 == STRING || type1 == BOOLEAN  || type2 == BOOLEAN) {
                //ERROR
                System.out.println("Error en la comparacion: tipos inoperables");
                return NONE;
            }
            else if (type1 != type2){
                //ERROR
                System.out.println("Error en la comparacion: los tipos son incompatibles entre si");
                return NONE;
            }
            else {
                type1 = type2;
            }
        }
        return type1;
    }

    @Override
    public Object visitCompMayMonkey(ownParser.CompMayMonkeyContext ctx) {
        int type1 = (Integer) visit(ctx.additionExpression(0));
        int type2;
        for (ownParser.AdditionExpressionContext element: ctx.additionExpression()) {
            type2 = (Integer) visit(element);
            if(type1 == NONE || type2 == NONE || type1 == STRING|| type2 == STRING || type1 == BOOLEAN  || type2 == BOOLEAN) {
                //ERROR
                System.out.println("Error en la comparacion: tipos inoperables");
                return NONE;
            }
            else if (type1 != type2){
                //ERROR
                System.out.println("Error en la comparacion: los tipos son incompatibles entre si");
                return NONE;
            }
            else {
                type1 = type2;
            }
        }
        return type1;
    }

    @Override
    public Object visitCompMeIMonkey(ownParser.CompMeIMonkeyContext ctx) {
        int type1 = (Integer) visit(ctx.additionExpression(0));
        int type2;
        for (ownParser.AdditionExpressionContext element: ctx.additionExpression()) {
            type2 = (Integer) visit(element);
            if(type1 == NONE || type2 == NONE || type1 == STRING|| type2 == STRING || type1 == BOOLEAN  || type2 == BOOLEAN) {
                //ERROR
                System.out.println("Error en la comparacion: tipos inoperables");
                return NONE;
            }
            else if (type1 != type2){
                //ERROR
                System.out.println("Error en la comparacion: los tipos son incompatibles entre si");
                return NONE;
            }
            else {
                type1 = type2;
            }
        }
        return type1;
    }

    @Override
    public Object visitCompMaIMonkey(ownParser.CompMaIMonkeyContext ctx) {
        int type1 = (Integer) visit(ctx.additionExpression(0));
        int type2;
        for (ownParser.AdditionExpressionContext element: ctx.additionExpression()) {
            type2 = (Integer) visit(element);
            if(type1 == NONE || type2 == NONE || type1 == STRING|| type2 == STRING || type1 == BOOLEAN  || type2 == BOOLEAN) {
                //ERROR
                System.out.println("Error en la comparacion: tipos inoperables");
                return NONE;
            }
            else if (type1 != type2){
                //ERROR
                System.out.println("Error en la comparacion: los tipos son incompatibles entre si");
                return NONE;
            }
            else {
                type1 = type2;
            }
        }
        return type1;
    }

    @Override
    public Object visitCompIgMonkey(ownParser.CompIgMonkeyContext ctx) {
        int type1 = (Integer) visit(ctx.additionExpression(0));
        int type2;
        for (ownParser.AdditionExpressionContext element: ctx.additionExpression()) {
            type2 = (Integer) visit(element);
            if(type1 == NONE || type2 == NONE || type1 == STRING|| type2 == STRING || type1 == BOOLEAN  || type2 == BOOLEAN) {
                //ERROR
                System.out.println("Error en la comparacion: tipos inoperables");
                return NONE;
            }
            else if (type1 != type2){
                //ERROR
                System.out.println("Error en la comparacion: los tipos son incompatibles entre si");
                return NONE;
            }
            else {
                type1 = type2;
            }
        }
        return type1;
    }

    @Override
    public Object visitAddExprMonkey(ownParser.AddExprMonkeyContext ctx) {
        int typeAddExp = (int) visit(ctx.multiplicationExpression());
        //DUDE : ¿Que pasa cuando no existe addition factor?; porque por lo visto tambien lo debe aceptar cuando no viene nada
        int typeComp = (int) visit(ctx.additionFactor());
        if(typeAddExp==typeComp || typeComp==NEUTRAL || typeComp==NONE)
        {
            return typeAddExp;
        }
        else {
            //Error
            System.out.println("Ocurrió un error en la expression");
            return NONE;
        }
    }

    @Override
    public Object visitAddFSumMonkey(ownParser.AddFSumMonkeyContext ctx) {
        int type=NONE;
        for (ownParser.MultiplicationExpressionContext element: ctx.multiplicationExpression()){
            type = (int) visit(element);
            if(type!= INT)
            {
                //ERROR
                System.out.println("Ocurrió un error en la expression");
                return NONE;
            }
        }
        return type;
    }

    @Override
    public Object visitAddFSubMonkey(ownParser.AddFSubMonkeyContext ctx) {
        int type=NONE;
        for (ownParser.MultiplicationExpressionContext element: ctx.multiplicationExpression()){
            type = (int) visit(element);
            if(type!= INT)
            {
                //ERROR
                System.out.println("Ocurrió un error en la expression");
                return NONE;
            }
        }
        return type;
    }

    @Override
    public Object visitMulExprMonkey(ownParser.MulExprMonkeyContext ctx) {
        int typeElemtExp = (int)visit(ctx.elementExpression());
        int typemultFact = (int)visit(ctx.multiplicationFactor());
        if(typeElemtExp==typemultFact || typemultFact==NEUTRAL || typemultFact==NONE){
            return typeElemtExp;
        }
        else{
            //Error
            System.out.println("Ocurrió un error en la comparacion");
            return NONE;
        }
    }

    @Override
    public Object visitMulFMulMonkey(ownParser.MulFMulMonkeyContext ctx) {
        int type=NONE;
        for (ownParser.ElementExpressionContext element: ctx.elementExpression()){
            type = (int) visit(element);
            if(type!= INT)
            {
                //ERROR
                System.out.println("Ocurrió un error en la expression");
                return NONE;
            }
        }
        return type;
    }

    @Override
    public Object visitMulFDivMonkey(ownParser.MulFDivMonkeyContext ctx) {
        int type=NONE;
        for (ownParser.ElementExpressionContext element: ctx.elementExpression()){
            type = (int) visit(element);
            if(type!= INT)
            {
                //ERROR
                System.out.println("Ocurrió un error en la expression");
                return NONE;
            }
        }
        return type;
    }

    @Override
    public Object visitElemExprMonkey(ownParser.ElemExprMonkeyContext ctx) {

        int typePrim =(int) visit(ctx.primitiveExpression());

        //DUDE ¿Esto funciona? : hay que asegurarse que esto funcione
        if(ctx.children.equals(ownParser.ElementAccessContext.class))
        {
            int typeElemAcs = (int)visit(ctx.elementAccess());
            if(typePrim == ARRAY)
            {
                if (typeElemAcs!=INT)
                {
                    //ERROR
                    System.out.println("Error accesando al array el tipo dado no es int");
                    return NONE;
                }
                else {
                    return NEUTRAL;
                }
            }
            else if(typePrim == HASH_LITERAL)
            {
                if(typeElemAcs!=INT && typeElemAcs!= STRING)
                {
                    // ERROR
                    System.out.println("Error accesando al diccionario el tipo dado no es int ni tampoco String");
                    return NONE;
                }
                else {
                    return NEUTRAL;
                }
            }
            else
            {
                //ERROR
                return NONE;
            }
        }
        else if(ctx.children.equals(ownParser.CallExpressionContext.class))
        {
            int type = (int)visit(ctx.callExpression());
            if(typePrim != FUNCTION)
            {
                //ERROR
                System.out.println("Error esto no es una funcion");
                return NONE;
            }
            else{
                //DUDE
                return NEUTRAL;
            }
        }

        return typePrim;

    }

    @Override
    public Object visitElemAcsMonkey(ownParser.ElemAcsMonkeyContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitCallExprMonkey(ownParser.CallExprMonkeyContext ctx){
        //DUDE  ¿Se deben verificar/retornar la cantidad de parametros de la funcion especifica?
        return NEUTRAL;
    }

    @Override
    public Object visitPrimExprIntMonkey(ownParser.PrimExprIntMonkeyContext ctx) {
        return INT;
    }

    @Override
    public Object visitPrimExprStrMonkey(ownParser.PrimExprStrMonkeyContext ctx) {
        return STRING;
    }

    @Override
    public Object visitPrimExprIdMonkey(ownParser.PrimExprIdMonkeyContext ctx){
        VariablesTable.Element variable = variablesTable.search(ctx.ID().getText());
        MethodsTable.Element method = null;//= methodsTable.search(ctx.ID().getText());

        //DUDE para Nathalie
        if (variable!= null)
        {
            return variable.type;
        }
        else if(method != null)
        {
            return FUNCTION;
        }
        else
        {
            return NONE;
        }
    }

    @Override
    public Object visitPrimExprTMonkey(ownParser.PrimExprTMonkeyContext ctx) {
        return BOOLEAN;
    }

    @Override
    public Object visitPrimExprFMonkey(ownParser.PrimExprFMonkeyContext ctx) {
        return BOOLEAN;
    }

    @Override
    public Object visitPrimExprMonkey(ownParser.PrimExprMonkeyContext ctx) {
        //DUDE ¿Para que se utiliza esto?,¿Es valido hacerlo asi solo devolver el valor de la exp?
        return visit(ctx.expression());
    }

    @Override
    public Object visitPrimArrLMonkey(ownParser.PrimArrLMonkeyContext ctx) {

        return visit(ctx.arrayLiteral());
    }

    @Override
    public Object visitPrimArrFMonkey(ownParser.PrimArrFMonkeyContext ctx){
        //DUDE ¿Hay que aclarar que tipo de dato retornaria por ejemplo LEN retorna entero?
        int typeExpList   = (int) visit(ctx.expressionList());
        if(typeExpList==NONE)
        {
            //ERROR
            return NONE;
        }
        else {
            return NEUTRAL;
        }
    }

    @Override
    public Object visitPrimFunLtlMonkey(ownParser.PrimFunLtlMonkeyContext ctx) {
        return visit(ctx.functionLiteral());
    }

    @Override
    public Object visitPrimHshLtlMonkey(ownParser.PrimHshLtlMonkeyContext ctx) {
        return visit(ctx.hashLiteral());
    }


    @Override
    public Object visitPrimPrtExprMonkey(ownParser.PrimPrtExprMonkeyContext ctx) {
        //DUDE ¿Se debe devolver algun tipo especial, como FUNCTION?
        return visit(ctx.printExpression());
    }

    @Override
    public Object visitPrimIfExprMonkey(ownParser.PrimIfExprMonkeyContext ctx) {
        return visit(ctx.ifExpression());
    }






    @Override
    public Object visitArrFLenMonkey(ownParser.ArrFLenMonkeyContext ctx) {
        //DUDE ¿Que devuelvo, que el retorno es un entero o una funcion?
        return INT;
    }

    @Override
    public Object visitArrFFirMonkey(ownParser.ArrFFirMonkeyContext ctx) {
        //DUDE ¿Que devuelvo, que el retorno es un entero o una funcion?
        return NEUTRAL;
    }

    @Override
    public Object visitArrFLstMonkey(ownParser.ArrFLstMonkeyContext ctx) {
        //DUDE ¿Que devuelvo, que el retorno es un entero o una funcion?
        return NEUTRAL;
    }

    @Override
    public Object visitArrFRstMonkey(ownParser.ArrFRstMonkeyContext ctx) {
        //DUDE ¿Que devuelvo, que el retorno es un entero o una funcion?
        return ARRAY;
    }

    @Override
    public Object visitArrFPshMonkey(ownParser.ArrFPshMonkeyContext ctx) {
        //DUDE ¿Que devuelvo, que el retorno es un entero o una funcion?
        return NONE;
    }




    @Override
    public Object visitArrLtlMonkey(ownParser.ArrLtlMonkeyContext ctx) {
        int type =(int) visit(ctx.expressionList());
        if(type == NONE)
        {
            return NONE;
        }
        return type;
    }

    @Override
    public Object visitFunLtlMonkey(ownParser.FunLtlMonkeyContext ctx){
        //DUDE ¿Que retorno?
        int type1 = (int) visit(ctx.functionParameters());
        int type2 = (int) visit(ctx.blockStatement());
        return FUNCTION;
    }

    @Override
    public Object visitFunPrmtMonket(ownParser.FunPrmtMonketContext ctx) {
        int typeID;
        for (TerminalNode element: ctx.ID()){
            typeID = (int)visit(element);
            if(typeID == NONE)
            {
                //ERROR
                //DUDE
                System.out.println("Ocurrio un error verificando los parametros");
                return NONE;
            }
        }
        //ACEPTED
        return NONE;
    }







    @Override
    public Object visitHshLtlMonkey(ownParser.HshLtlMonkeyContext ctx) {
        int typeHC = (int)visit(ctx.hashContent());
        int typeMHC=(int)visit(ctx.moreHashContent());
        if(typeHC==HASH_LITERAL && typeMHC == HASH_LITERAL)
        {
            return HASH_LITERAL;
        }
        else
        {
            return NONE;
        }
    }


    @Override
    public Object visitHshCntMonkey(ownParser.HshCntMonkeyContext ctx) {
        int typeExp1 = (int) visit(ctx.expression(0));
        int typeExp2 = (int) visit(ctx.expression(1));
        if((typeExp1==INT || typeExp1==STRING) && typeExp2!= NONE )
        {
            return HASH_LITERAL;
        }
        else {
            //ERROR
            System.out.println("Ocurrio un error en la deficion del hashliteral");
            return NONE;
        }
    }




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

    @Override
    public Object visitExprLstMonkey(ownParser.ExprLstMonkeyContext ctx){
        for(ownParser.ExpressionContext element : ctx.expression())
        {
            if((int)visit(element)== NONE)
            {
                return NONE;
            }
        }
        return ARRAY;
    }

    @Override
    public Object visitPrtExprMonkey(ownParser.PrtExprMonkeyContext ctx){
         int typeExp =(int)visit(ctx.expression());

         if(typeExp != NONE)
         {
             return NONE;
         }
         else {
             //ERROR
             System.out.println("Ocurrio un error en los elementos para imprimir ");
             return  NONE;
         }
    }

    @Override
    public Object visitIfElseExprMonkey(ownParser.IfElseExprMonkeyContext ctx) {
        int type = (int) visit(ctx.expression());
        if(type == BOOLEAN || type==NEUTRAL)
        {
            return NONE;
        }
        else
        {
            //ERROR
            System.out.println("Ocurrio un error en la expresion del if");
            return  NONE;
        }
    }

    @Override
    public Object visitIfExprMonkey(ownParser.IfExprMonkeyContext ctx) {
        int type = (int) visit(ctx.expression());
        if(type == BOOLEAN || type==NEUTRAL)
        {
            return NONE;
        }
        else
        {
            //ERROR
            System.out.println("Ocurrio un error en la expresion del if");
            return  NONE;
        }
    }

    @Override
    public Object visitBlckStMonkey(ownParser.BlckStMonkeyContext ctx) {
        variablesTable.openScope();
        methodsTable.openScope();
        for(ownParser.StatementContext statementContext : ctx.statement())
        {
            visit(statementContext);
        }
        variablesTable.closeScope();
        methodsTable.closeScope();
        return NONE;
    }
}
