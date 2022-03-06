grammar Criteria;
r   : age
    ;         // match keyword hello followed by an identifier

ageIdentifier : 'age'
              | 'alter'
              ;

age: ageIdentifier INT '-' INT
   | ageIdentifier OPENING_BRACKETS INT ',' INT CLOSING_BRACKETS
   ;

// Tokens
ID  : [a-z]+ ;             // match lower-case identifiers
INT :  '0'..'9'+ ; //
CLOSING_BRACKETS : ')'
                 | ']'
                 ;
OPENING_BRACKETS : '('
                 | '['
                 ;
WS  : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines