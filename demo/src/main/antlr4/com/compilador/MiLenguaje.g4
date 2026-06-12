grammar MiLenguaje;

programa : sentencia* EOF ;

token : PA | PC | CA | CC | LA | LC | PYC | COMA | IGUAL | MAYOR | MAYOR_IGUAL
      | MENOR | MENOR_IGUAL | EQL | DISTINTO | SUM | RES | MUL | DIV | MOD
      | OR | AND | NOT | FOR | WHILE | IF | ELSE | INT | CHAR | DOUBLE | VOID
      | RETURN | TRUE | FALSE | BOOLEAN_TYPE | STRING_TYPE | PUNTO
      | ID | INTEGER | DECIMAL | CHARACTER | STRING | OTRO
      ;

sentencia
    : bloque                                               # SentenciaBloque
    | expresion_for                                        # SentenciaFor
    | expresion_while                                      # SentenciaWhile
    | expresion_if                                         # SentenciaIf
    | declaracionFuncion                                   # SentenciaFuncion
    | declaracion                                          # SentenciaDeclaracion
    | asignacion                                           # SentenciaAsignacion
    | sentenciaReturn                                      # SentenciaRetorno
    | expresion PUNTO ID PA argumentos PC PYC              # SentenciaCout
    | expresion PYC                                        # SentenciaExpr
    ;

bloque : LA sentencia* LC ;

declaracion
    : tipo ID PYC
    | tipo ID IGUAL expresion PYC
    ;

asignacion : ID IGUAL expresion PYC ;

sentenciaReturn : RETURN expresion? PYC ;

// Declaración de función
declaracionFuncion
    : tipo ID PA listaParametros? PC bloque
    ;

listaParametros
    : parametro (COMA parametro)*
    ;

parametro
    : tipo ID
    ;

expresion_for
    : FOR PA declaracion condicion_for PYC actualizacion PC bloque
    ;

condicion_for : expresion ;

actualizacion
    : ID SUMSUM
    | ID RESRES
    | ID IGUAL expresion
    ;

expresion_while : WHILE PA expresion PC bloque ;

expresion_if : IF PA expresion PC bloque (ELSE bloque)? ;

// Expresiones con etiquetas para el Visitor
expresion
    : expresion OR  expresion                           # ExprOr
    | expresion AND expresion                           # ExprAnd
    | NOT expresion                                     # ExprNot
    | expresion (EQL | DISTINTO) expresion              # ExprIgualdad
    | expresion (MAYOR | MAYOR_IGUAL | MENOR | MENOR_IGUAL) expresion  # ExprRelacional
    | expresion (SUM | RES) expresion                   # ExprAditiva
    | expresion (MUL | DIV | MOD) expresion             # ExprMultiplicativa
    | RES expresion                                     # ExprNegativo
    | PA expresion PC                                   # ExprAgrupada
    | expresion PUNTO ID PA argumentos PC               # ExprLlamadaMetodo
    | expresion PUNTO ID                                # ExprAccesoCampo
    | ID CA expresion CC                                # ExprArreglo
    | ID PA argumentos PC                               # ExprLlamada
    | ID                                                # ExprIdentificador
    | INTEGER                                           # ExprEntero
    | DECIMAL                                           # ExprDecimal
    | CHARACTER                                         # ExprCaracter
    | STRING                                            # ExprCadena
    | TRUE                                              # ExprVerdadero
    | FALSE                                             # ExprFalso
    ;

argumentos : (expresion (COMA expresion)*)? ;

tipo : INT | CHAR | DOUBLE | VOID | STRING_TYPE | BOOLEAN_TYPE ;


// ─── TOKENS LEXER ────────────────────────────────────────────

fragment LETRA  : [A-Za-z] ;
fragment DIGITO : [0-9] ;

PA   : '(' ;   PC   : ')' ;
CA   : '[' ;   CC   : ']' ;
LA   : '{' ;   LC   : '}' ;

PYC   : ';' ;
COMA  : ',' ;
PUNTO : '.' ;

IGUAL       : '=' ;
EQL         : '==' ;
DISTINTO    : '!=' ;
MAYOR_IGUAL : '>=' ;
MENOR_IGUAL : '<=' ;
MAYOR       : '>' ;
MENOR       : '<' ;

SUM    : '+' ;
RES    : '-' ;
MUL    : '*' ;
DIV    : '/' ;
MOD    : '%' ;
SUMSUM : '++' ;
RESRES : '--' ;

OR  : '||' ;
AND : '&&' ;
NOT : '!'  ;

FOR          : 'for'     ;
WHILE        : 'while'   ;
IF           : 'if'      ;
ELSE         : 'else'    ;
INT          : 'int'     ;
CHAR         : 'char'    ;
DOUBLE       : 'double'  ;
VOID         : 'void'    ;
RETURN       : 'return'  ;
TRUE         : 'true'    ;
FALSE        : 'false'   ;
BOOLEAN_TYPE : 'boolean' ;
STRING_TYPE  : 'String'  ;

ID        : (LETRA | '_') (LETRA | DIGITO | '_')* ;
INTEGER   : DIGITO+ ;
DECIMAL   : DIGITO+ '.' DIGITO+ ;
CHARACTER : '\'' (~['\r\n\\] | '\\' .) '\'' ;
STRING    : '"' (~["\r\n\\] | '\\' .)* '"' ;

COMENTARIO_LINEA  : '//' ~[\r\n]* -> skip ;
COMENTARIO_BLOQUE : '/*' .*? '*/' -> skip ;
WS                : [ \r\n\t]    -> skip ;

OTRO : . ;