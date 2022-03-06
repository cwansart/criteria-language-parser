package de.cwansart.criteriaparser.parser;

import de.cwansart.criteriaparser.entities.Gender;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

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

    @Test
    void ageAndGender() {
        testToken("age [1,10], gender male");
        assertThat(listener.getAgeCriteria()).hasSize(1);
        assertThat(listener.getGender()).isEqualTo(Gender.MALE);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "age [1,10], age [20,25], gender female",
            "age [1,10], gender female, age [20,25]",
    })
    void twoAgesAndGender(String token) {
        testToken(token);
        assertThat(listener.getAgeCriteria()).hasSize(2);
        assertThat(listener.getGender()).isEqualTo(Gender.FEMALE);
    }
}