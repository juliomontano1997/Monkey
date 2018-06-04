parser grammar ownParser;
options
{
    tokenVocab = ownScanner;
}
program                  : statement*                                               #ProgMonkey;

statement   	         : LET letStatement                                         #StLetMonkey
                         | RETURN returnStatement                                   #StRtnMonkey
                         | expressionStatement                                      #StExprMonkey;

letStatement  locals [int storageIndex = 0]: ID ASSIGN expression ( PyCOMA | )      #LetStMonkey;
returnStatement	         : expression ( PyCOMA | )                                  #RtnStMonkey;
expressionStatement 	 : expression ( PyCOMA | )                                  #ExprStMonkey;

expression             	 :  additionExpression(MENOR additionExpression)*           #CompMenMonkey
                           |additionExpression(MAYOR additionExpression)*           #CompMayMonkey
                           |additionExpression(MENORIGUAL additionExpression)*      #CompMeIMonkey
                           |additionExpression(MAYORIGUAL additionExpression)*      #CompMaIMonkey
                           |additionExpression(IGUALCOMP additionExpression)*       #CompIgMonkey;

additionExpression	     : multiplicationExpression (SUM multiplicationExpression)* #AddFSumMonkey
                           |multiplicationExpression(SUB multiplicationExpression)* #AddFSubMonkey;

multiplicationExpression :  elementExpression (MUL elementExpression)*              #MulFMulMonkey
                           |elementExpression (DIV elementExpression)*              #MulFDivMonkey;

elementExpression 	     :  elementAccess                                           #ElemExprEAcMonkey
                           |callExpression                                          #ElemExprCExpMonkey
                           |primitiveExpression                                     #ElemExprPrimiMonkey;

elementAccess       	 : primitiveExpression (CIZQ expression CDER)+              #ElemAcsMonkey;
callExpression	         : primitiveExpression (PIZQ expressionList PDER)           #CallExprMonkey;

primitiveExpression	     : INTEGER                                                  #PrimExprIntMonkey
                         | STRING                                                   #PrimExprStrMonkey
                         | identifier                                               #PrimExprIdMonkey
                         | TRUE                                                     #PrimExprTMonkey
                         | FALSE                                                    #PrimExprFMonkey
                         | PIZQ expression PDER                                     #PrimExprMonkey
                         | arrayLiteral                                             #PrimArrLMonkey
                         | arrayFunctions PIZQ primitiveExpression PDER      #PrimArrFMonkey
                         | functionLiteral                                          #PrimFunLtlMonkey
                         | hashLiteral                                              #PrimHshLtlMonkey
                         | printExpression                                          #PrimPrtExprMonkey
                         | ifExpression                                             #PrimIfExprMonkey;

arrayFunctions	         : LEN                                                      #ArrFLenMonkey
                         | FIRST                                                    #ArrFFirMonkey
                         | LAST                                                     #ArrFLstMonkey
                         | REST                                                     #ArrFRstMonkey
                         | PUSH                                                     #ArrFPshMonkey;

arrayLiteral   	         : CIZQ expressionList CDER                                 #ArrLtlMonkey;
functionLiteral	         : FN PIZQ functionParameters PDER blockStatement           #FunLtlMonkey;
functionParameters	     : (ID (COMA ID)*| )                                        #FunPrmtMonkey;
hashLiteral		         : LIZQ hashContent moreHashContent LDER                    #HshLtlMonkey;
hashContent	             : expression DOSPUN expression                             #HshCntMonkey;
moreHashContent	         : (COMA hashContent)*                                      #MreHshCntMonkey;
expressionList       	 : expression (COMA expression)*                            #ExprLstMonkey;
printExpression      	 : PUTS PIZQ expression PDER                                #PrtExprMonkey;
ifExpression	         : IF expression blockStatement ELSE blockStatement         #IfElseExprMonkey
                         | IF expression blockStatement                             #IfExprMonkey;
blockStatement	         : LIZQ statement* LDER                                     #BlckStMonkey;
identifier locals [ParserRuleContext decl = null]: ID                               #IdMonkey;