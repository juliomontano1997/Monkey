lexer grammar ownScanner;

/****************************
    Símbolos del lenguaje
****************************/

PyCOMA : ';';
COMA: ',';
CIZQ: '[';
CDER: ']';
PIZQ: '(';
PDER: ')';
LIZQ: '{';
LDER: '}';
DOSPUN: ':';

/****************************
Operadores Lógicos
****************************/
MENOR: '<';
MAYOR: '>';
MENORIGUAL: '<=';
MAYORIGUAL: '>=';
ASSIGN: '=';
IGUALCOMP: '==';
/****************************
Operadores Matemáticos
****************************/
SUM: '+';
SUB: '-';
MUL: '*';
DIV: '/';

/*****************************
Palabras reservadas
******************************/
LET: 'let';
RETURN: 'return';
LEN: 'len';
FIRST: 'first';
LAST: 'last';
REST: 'rest';
PUSH: 'push';
FN: 'fn';
PUTS: 'puts';
IF: 'if';
ELSE: 'else';
TRUE: 'true';
FALSE: 'false';

/*******************************
Tipos Primitivos
********************************/
ID: LETTER (LETTER |DIGIT)*;
INTEGER: DIGIT DIGIT*;
STRING: '"' .*? (~'"')* '"';

/*********************************
Comentarios
**********************************/
LINE_COMMENT:   '//' .*? '\r'? '\n' -> skip ;

SPECIAL_COMMENT: '/*' ( SPECIAL_COMMENT | DELIMITED_COMMENT | . )*? '*/' -> skip;

fragment DELIMITED_COMMENT
 : '/*' .*? '*/'
 ;
/*********************************
Fragment
**********************************/
fragment LETTER : 'a'..'z' | 'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9';

WS: [ \t\n\r]+ -> skip;


