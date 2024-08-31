grammar Hello;

eval returns [double value]
    :    exp=additionExp {$value = $exp.value;}
    ;

additionExp returns [double value]
    :    m1=multiplyExp       {$value =  $m1.value;} 
         ( '+' m2=multiplyExp {$value += $m2.value;} 
         | '-' m2=multiplyExp {$value -= $m2.value;}
         )* 
    ;

multiplyExp returns [double value]
    :    a1=atomExp       {$value =  $a1.value;}
         ( '*' a2=atomExp {$value *= $a2.value;} 
         | '/' a2=atomExp {$value /= $a2.value;}
         )* 
    ;

atomExp returns [double value]
    :    n=Number                {$value = Double.parseDouble($n.text);}
    |    '(' exp=additionExp ')' {$value = $exp.value;}
    ;

Number
    :    ('0'..'9')+ ('.' ('0'..'9')+)?
    ;

WS  
    :   (' ' | '\t' | '\r'| '\n') 
    ;