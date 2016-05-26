/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

grammar TildaSQL;




where
 : expr EOF
 ;


expr
 : value
// | unary_operator expr
 | expr bin_operator expr
 | function 
 | sub_expr
 | column ( K_ISNULL | K_NOTNULL | K_NOT K_NULL )
 | column K_NOT? K_BETWEEN expr K_AND expr
 ;
 
 
value
 : numeric_literal
 | timestamp_literal
 | string_literal
 | K_NULL
 | K_CURRENT_TIME
 | K_CURRENT_DATE
 | K_CURRENT_TIMESTAMP
 | bind_parameter
 | column
 ;

sub_expr
 : '(' expr ')'
 ;


/*
    We support the following binary operators, in order from highest to lowest precedence:
    ||
    *    /    %
    +    -
    <    <=   >    >=
    =    ==   !=   <>   IS   IS NOT   IN   LIKE   GLOB   MATCH   REGEXP
    AND
    OR
*/
bin_operator
 : '||'
 | ( '*' | '/' | '%' )
 | ( '+' | '-/' )
 | ( '<' | '<=' | '>' | '>=' )
 | ( '=' | '==' | '!=' | '<>' | K_IS | K_IS K_NOT | K_IN | K_LIKE | K_REGEXP )
 | K_AND
 | K_OR
 | K_NOT? ( K_LIKE | K_REGEXP )
 ;

function
 : IDENTIFIER '(' ( expr ( ',' expr )* )? ')'
 ;

column
 : ( IDENTIFIER '.' )? IDENTIFIER
 ;


unary_operator
 : '-'
 | '+'
 | '~'
 | K_NOT
 ;


keyword
 : K_AND
 | K_BETWEEN
 | K_CURRENT_DATE
 | K_CURRENT_TIME
 | K_CURRENT_TIMESTAMP
 | K_IN
 | K_IS 
 | K_ISNULL
 | K_LIKE
 | K_NOT
 | K_NOTNULL
 | K_NULL
 | K_ON
 | K_OR
 | K_REGEXP
 ;

// TODO check all names below

name
 : any_name
 ;

function_name
 : any_name
 ;

any_name
 : IDENTIFIER 
 | keyword
 | string_literal
 | '(' any_name ')'
 ;

SCOL : ';';
DOT : '.';
OPEN_PAR : '(';
CLOSE_PAR : ')';
COMMA : ',';
ASSIGN : '=';
STAR : '*';
PLUS : '+';
MINUS : '-';
TILDE : '~';
PIPE2 : '||';
DIV : '/';
MOD : '%';
LT2 : '<<';
GT2 : '>>';
AMP : '&';
PIPE : '|';
LT : '<';
LT_EQ : '<=';
GT : '>';
GT_EQ : '>=';
EQ : '==';
NOT_EQ1 : '!=';
NOT_EQ2 : '<>';


K_AND : A N D;
K_BETWEEN : B E T W E E N;
K_CURRENT_DATE : C U R R E N T '_' D A T E;
K_CURRENT_TIME : C U R R E N T '_' T I M E;
K_CURRENT_TIMESTAMP : C U R R E N T '_' T I M E S T A M P;
K_IN : I N;
K_IS : I S;
K_ISNULL : I S N U L L;
K_LIKE : L I K E;
K_NOT : N O T;
K_NOTNULL : N O T N U L L;
K_NULL : N U L L;
K_ON : O N;
K_OR : O R;
K_REGEXP : R E G E X P;

IDENTIFIER
 : [a-zA-Z_] [a-zA-Z_0-9]* 
 ;


numeric_literal
 : NUMERIC_LITERAL 
 ;

NUMERIC_LITERAL
 : DIGIT+ ( '.' DIGIT* )? ( E [-+]? DIGIT+ )?
 | '.' DIGIT+ ( E [-+]? DIGIT+ )?
 ;

string_literal
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;
 
bind_parameter
 : BIND_PARAMETER
 ;

BIND_PARAMETER
 : '?{' IDENTIFIER '}'
 ;
 
timestamp_literal  
 : TIMESTAMP_LITERAL
 ;

TIMESTAMP_LITERAL // ISO: '2011-12-03T10:15:30+01:00'.
 : '\'' YEAR_LITERAL '-' MONTH_LITERAL '-' DAY_LITERAL ('T' HOUR_LITERAL_24 ':' MINUTE_LITERAL (':' SECOND_LITERAL ([+-] HOUR_LITERAL_12 ':' MINUTE_LITERAL)?)?)? '\''
 ;

 
YEAR_LITERAL // 1800-2199
// : ([0-9])|('2'[0-1]) DIGIT DIGIT
 : DIGIT DIGIT DIGIT DIGIT
 ;
 
MONTH_LITERAL
// : ('0'[1-9])|('1'[0-2])
 : DIGIT DIGIT
 ;
 
DAY_LITERAL
// : ('0'[1-9])|([1-2][0-9])|('3'[0-1]) 
 : DIGIT DIGIT
 ;
 
HOUR_LITERAL_24
// : ([0-1][0-9]) | ('2'[0-3])
 : DIGIT DIGIT
 ;
 
MINUTE_LITERAL
// : ([0-5][0-9])
 : DIGIT DIGIT
 ;
 
SECOND_LITERAL
// : ([0-5][0-9])
 : DIGIT DIGIT
 ;
 
HOUR_LITERAL_12
// : ('0'[0-9])|('1'[0-2])
 : DIGIT DIGIT
 ;
 

SPACES
 : [ \u000B\t\r\n] -> channel(HIDDEN)
 ;

UNEXPECTED_CHAR
 : .
 ;


fragment DIGIT : [0-9];
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];
