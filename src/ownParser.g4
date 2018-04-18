parser grammar ownParser;
options
{
    tokenVocab = ownScanner;
}

program                  : statement*                                              #ProgMonkey;

statement   	         : LET letStatement                                        #StLetMonkey
                         | RETURN returnStatement                                  #StRtnMonkey
                         | expressionStatement                                     #StExprMonkey;

letStatement   	         : ID ASSIGN expression ( PyCOMA | )                       #LetStMonkey;
returnStatement	         : expression ( PyCOMA | )                                 #RtnStMonkey;
expressionStatement 	 : expression ( PyCOMA | )                                 #ExprStMonkey;
expression             	 : additionExpression comparison                           #ExprMonkey;

comparison            	 : (MENOR additionExpression)*                             #CompMenMonkey
                           |(MAYOR additionExpression)*                            #CompMayMonkey
                           |(MENORIGUAL additionExpression)*                       #CompMeIMonkey
                           |(MAYORIGUAL additionExpression)*                       #CompMaIMonkey
                           |(IGUALCOMP additionExpression)*                        #CompIgMonkey;

additionExpression	     : multiplicationExpression additionFactor                 #AddExprMonkey;

additionFactor       	 : (SUM multiplicationExpression)*                         #AddFSumMonkey
                           |(SUB multiplicationExpression)*                        #AddFSubMonkey;

multiplicationExpression : elementExpression multiplicationFactor                  #MulExprMonkey;

multiplicationFactor	 : (MUL elementExpression)*                                #MulFMulMonkey
                           |(DIV elementExpression)*                               #MulFDivMonkey;

elementExpression 	     : primitiveExpression (elementAccess|callExpression| )    #ElemExprMonkey;

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

functionParameters	     : ID moreIdentifiers                                      #FunPrmtMonket;

moreIdentifiers	         : (COMA ID)*                                              #MreIdentMonkey;

hashLiteral		         : LIZQ hashContent moreHashContent LDER                   #HshLtlMonkey;

hashContent	             : expression DOSPUN expression                            #HshCntMonkey;

moreHashContent	         : (COMA hashContent)*                                     #MreHshCntMonkey;

expressionList       	 : expression moreExpressions                              #ExprLstMreMonkey
                         | expression                                              #ExprLstMonkey;

moreExpressions    	     : (COMA expression)*                                      #MreExprMonkey;

printExpression      	 : PUTS PIZQ expression PDER                               #PrtExprMonkey;

ifExpression	         : IF expression blockStatement ELSE blockStatement        #IfElseExprMonkey
                         | IF expression blockStatement                            #IfExprMonkey;

blockStatement	         : LIZQ statement* LDER                                    #BlckStMonkey;