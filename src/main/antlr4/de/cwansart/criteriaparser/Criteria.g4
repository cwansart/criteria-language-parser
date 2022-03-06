grammar Criteria;
r   : age (',' age)*
    ;

ageIdentifier : 'age'
              | 'alter'
              ;

age: ageIdentifier INT '-' INT
   | ageIdentifier OPENING_BRACKETS INT ',' INT CLOSING_BRACKETS
   ;

// Tokens
INT :  '0'..'9'+ ; //
CLOSING_BRACKETS : ')'
                 | ']'
                 ;
OPENING_BRACKETS : '('
                 | '['
                 ;
WS  : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines