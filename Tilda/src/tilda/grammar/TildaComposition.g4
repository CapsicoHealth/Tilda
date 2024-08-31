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

grammar TildaComposition;


where
 : expr EOF
 ;

expr
 : bool_expr
 | expr_sub
 ;
 
expr_sub
 : '(' expr ')'
 ;
 
bool_expr
 : l_expr=bool_expr op=bool_op r_expr=bool_expr
 | bool_expr_sub
 | parameter
 ;

bool_op
 : K_AND K_NOT?
 | K_OR K_NOT?
 ;
 
bool_expr_sub
 : '(' bool_expr ')'
 ; 

parameter
 : IDENTIFIER
 ;

K_AND : A N D;
K_NOT : N O T;
K_OR : O R;

IDENTIFIER
 : [a-zA-Z_] [a-zA-Z_0-9]* 
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
