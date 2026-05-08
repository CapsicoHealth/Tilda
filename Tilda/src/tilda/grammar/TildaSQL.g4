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
 : bool_expr
 | bin_expr
 | between_expr
 | expr_sub
 ;
 
expr_sub
 : '(' expr ')'
 ;
 
bool_expr
 : l_expr=bool_expr op=bool_op r_expr=bool_expr     
 | s_expr=bin_expr                                                                
 | isnull_expr
 | bool_expr_sub                                                                  
 ;

bool_op
 : K_AND K_NOT?
 | K_OR K_NOT?
 ;
 
bool_expr_sub
 : '(' bool_expr ')'
 ; 

bin_expr
 : (bin_expr_lhs | func_expr '(' bin_expr_lhs ')') (bin_op|bin_like) (column | arithmetic_expr_base)
 | bin_expr_lhs (K_NOT)? K_IN  value_list
 ;

bin_expr_lhs
 : column (('+' | '||') column)*
 ;
 
func_expr
 : K_LEN
 ;

value_list
 : '(' value (',' value)* ')'
 ;

bin_like: (K_NOT)? K_LIKE;
bin_op: K_LT | K_LTE | K_GT | K_GTE | K_EQ | K_NEQ;

arithmetic_expr_base
 : arithmetic_expr
 ;

arithmetic_expr
 : arithmetic_expr arithmetic_op_mul arithmetic_expr      # ArithmeticExpr
 | arithmetic_expr arithmetic_op_add arithmetic_expr      # ArithmeticExpr
 | value                                                  # ArithmeticExprVal
 | arithmetic_expr_sub                                    # ArithmeticExprSub
 ;
 
arithmetic_expr_sub
 : '(' s_expr=arithmetic_expr ')'
 ;

arithmetic_op_add: '+' | K_MINUS;
arithmetic_op_mul: '*' | K_DIV;
 

isnull_expr
 : column isnull_op
 ;

isnull_op
 : K_IS K_NOT? (K_NULL|K_NULL_OR_EMPTY)
 ;

between_expr
 : col=column op=between_op val1=value K_AND val2=value
 ;

between_op
 : K_NOT? K_BETWEEN
 ;

value
 : numeric_literal     # ValueNumericLiteral
 | timestamp_literal   # ValueTimestampLiteral
 | string_literal      # ValueStringLiteral
 | bind_parameter      # ValueBindParam
 ; 

numeric_literal
 : NUMERIC_LITERAL
 ;

NUMERIC_LITERAL
 : DIGIT+ ( '.' DIGIT* )?
 ;


timestamp_literal // ISO: '2011-12-03T10:15:30+01:00'.
 : TIMESTAMP_LITERAL
 | CURRENT_TIMESTAMP
 | TIMESTAMP_YESTERDAY LAST?
 | TIMESTAMP_TODAY LAST?
 | TIMESTAMP_TOMORROW LAST?
 ;

TIMESTAMP_LITERAL        : '\'' YEAR_LITERAL '-' MONTH_LITERAL '-' DAY_LITERAL ('T' HOUR_LITERAL_24 ':' MINUTE_LITERAL (':' SECOND_LITERAL (PLUS_MINUS HOUR_LITERAL_12 ':' MINUTE_LITERAL)?)?)? '\'' ;
CURRENT_TIMESTAMP        : C U R R E N T '_' T I M E S T A M P;
TIMESTAMP_YESTERDAY      : T I M E S T A M P '_' Y E S T E R D A Y;
TIMESTAMP_TODAY          : T I M E S T A M P '_' T O D A Y;
TIMESTAMP_TOMORROW       : T I M E S T A M P '_' T O M O R R O W;
LAST: L A S T;


string_literal
 : STRING_LITERAL
 ;
 
STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;
 
bind_parameter
 : BIND_PARAMETER
 ;
 
BIND_PARAMETER
 : '?{' IDENTIFIER '}'
 ;


function
 : IDENTIFIER '(' ( arithmetic_expr_base ( ',' arithmetic_expr_base )* )? ')'
 ;

column
 : ( IDENTIFIER '.' )? IDENTIFIER
 ;


K_AND : A N D;
K_BETWEEN : B E T W E E N;
K_IN : I N;
K_IS : I S;
K_LIKE : L I K E;
K_NOT : N O T;
K_NULL : N U L L;
K_OR : O R;
K_NULL_OR_EMPTY : N O E;
K_REGEXP : R E G E X P;
K_LT: '<';
K_LTE: '<=';
K_GT: '>';
K_GTE: '>=';
K_EQ: '=' '='?;
K_NEQ: '<>' | '!=';
K_DIV: '/';
K_MINUS: '-';
K_LEN: L E N;


IDENTIFIER
 : [a-zA-Z_] [a-zA-Z_0-9]* 
 ;

 
PLUS_MINUS
 : '+'
 | '-'
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
