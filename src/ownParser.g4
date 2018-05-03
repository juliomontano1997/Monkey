parser grammar ownParser;
options
{
    tokenVocab = ownScanner;
}

program                  : statement*                                               #ProgMonkey;

statement   	         : LET letStatement                                         #StLetMonkey
                         | RETURN returnStatement                                   #StRtnMonkey
                         | expressionStatement                                      #StExprMonkey;


letStatement   	         : ID ASSIGN expression ( PyCOMA | )                        #LetStMonkey;
returnStatement	         : expression ( PyCOMA | )                                 #RtnStMonkey;
expressionStatement 	 : expression ( PyCOMA | )                                 #ExprStMonkey;





expression             	 : additionExpression comparison                            #ExprMonkey;

comparison            	 : (MENOR additionExpression)*                             #CompMenMonkey
                           |(MAYOR additionExpression)*                            #CompMayMonkey
                           |(MENORIGUAL additionExpression)*                       #CompMeIMonkey
                           |(MAYORIGUAL additionExpression)*                       #CompMaIMonkey
                           |(IGUALCOMP additionExpression)*                        #CompIgMonkey;

additionExpression	     : multiplicationExpression additionFactor                  #AddExprMonkey;



// solo entran los que son numeros enteros
additionFactor       	 : (SUM multiplicationExpression)*                          #AddFSumMonkey
                           |(SUB multiplicationExpression)*                         #AddFSubMonkey;




multiplicationExpression : elementExpression multiplicationFactor                   #MulExprMonkey;

// solo entran los que son numeros enteros
multiplicationFactor	 : (MUL elementExpression)*                                 #MulFMulMonkey
                           |(DIV elementExpression)*                                #MulFDivMonkey;



elementExpression 	     : primitiveExpression ((elementAccess|callExpression)*| ) #ElemExprMonkey;

elementAccess       	 : CIZQ expression CDER                                    #ElemAcsMonkey;

callExpression	         : PIZQ expressionList PDER                                #CallExprMonkey;




primitiveExpression	     : INTEGER                                                 #PrimExprIntMonkey
                         | STRING                                                  #PrimExprStrMonkey
                         | ID                                                      #PrimExprIdMonkey
                         | TRUE                                                    #PrimExprTMonkey
                         | FALSE                                                   #PrimExprFMonkey
                         | PIZQ expression PDER                                    #PrimExprMonkey
                         | arrayLiteral                                            #PrimArrLMonkey
                         | arrayFunctions PIZQ expressionList PDER                 #PrimArrFMonkey
                         | functionLiteral                                         #PrimFunLtlMonkey
                         | hashLiteral                                             #PrimHshLtlMonkey
                         | printExpression                                         #PrimPrtExprMonkey
                         | ifExpression                                            #PrimIfExprMonkey;



arrayFunctions	         : LEN                                                     #ArrFLenMonkey
                         | FIRST                                                   #ArrFFirMonkey
                         | LAST                                                    #ArrFLstMonkey
                         | REST                                                    #ArrFRstMonkey
                         | PUSH                                                    #ArrFPshMonkey;

arrayLiteral   	         : CIZQ expressionList CDER                                #ArrLtlMonkey;

functionLiteral	         : FN PIZQ functionParameters PDER blockStatement          #FunLtlMonkey;

functionParameters	     : ID (COMA ID)*                                           #FunPrmtMonket;

hashLiteral		         : LIZQ hashContent moreHashContent LDER                   #HshLtlMonkey;

hashContent	             : expression DOSPUN expression                            #HshCntMonkey;

moreHashContent	         : (COMA hashContent)*                                     #MreHshCntMonkey;

expressionList       	 : (expression (COMA expression)*| )                       #ExprLstMonkey;

printExpression      	 : PUTS PIZQ expression PDER                               #PrtExprMonkey;

ifExpression	         : IF expression blockStatement ELSE blockStatement        #IfElseExprMonkey
                         | IF expression blockStatement                            #IfExprMonkey;
blockStatement	         : LIZQ statement* LDER                                    #BlckStMonkey;