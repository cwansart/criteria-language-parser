grammar Criteria;
r   : age ;         // match keyword hello followed by an identifier
ID  : [a-z]+ ;             // match lower-case identifiers
INT :  '0'..'9'+ ;
CLOSING_BRACKETS : ')'
                 | ']'
                 ;
OPENING_BRACKETS : '('
                 | '['
                 ;
WS  : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

ageToken : 'age'
          | 'alter'
          ;

age: ageToken INT '-' INT
   | ageToken OPENING_BRACKETS INT '-' INT CLOSING_BRACKETS
   ;