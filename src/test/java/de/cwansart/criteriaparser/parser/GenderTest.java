package de.cwansart.criteriaparser.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GenderTest {

    private CriteriaListenerImpl listener;

    private ParseTreeWalker walker;

    @BeforeEach()
    void setUp() {
        listener = new CriteriaListenerImpl();
        walker = new ParseTreeWalker();
    }

    private void testToken(String str) {
        CriteriaLexer lexer = new CriteriaLexer(CharStreams.fromString(str));
        CommonTokenStream token = new CommonTokenStream(lexer);
        CriteriaParser parser = new CriteriaParser(token);
        ParseTree tree = parser.r();
        walker.walk(listener, tree);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "gender male",
            "gender female",
            "gender both",
            "gender unknown",
            "geschlecht männlich",
            "geschlecht weiblich",
            "geschlecht beide",
            "geschlecht unbekannt"
    })
    void validGender(String token) {
        testToken(token);
        assertThat(listener.getErrors()).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "age 1 - 10, age 15 - 20",
            "alter 1 - 10, age 15 - 20",
            "alter 1 - 10, alter 15 - 20",
    })
    void multipleRanges(String token) {
        testToken(token);
        assertThat(listener.getAgeCriteria()).hasSize(2);
    }


}