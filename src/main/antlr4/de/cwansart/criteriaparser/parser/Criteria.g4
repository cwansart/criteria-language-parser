grammar Criteria;
r   : availableToken (',' availableToken)*
    ;

availableToken: age
              | gender
              ;

// Age
age: ageIdentifier INT '-' INT
   | ageIdentifier OPENING_BRACKETS INT ',' INT CLOSING_BRACKETS
   ;

ageIdentifier : 'age'
              | 'alter'
              ;

// Gender
gender : 'gender' GENDER_TOKEN
       | 'geschlecht' GENDER_TOKEN
       ;

GENDER_TOKEN: 'male'
            | 'female'
            | 'both'
            | 'unknown'
            | 'männlich'
            | 'weiblich'
            | 'beide'
            | 'unbekannt'
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