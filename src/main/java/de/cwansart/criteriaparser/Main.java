package de.cwansart.criteriaparser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) {
        CriteriaLexer lexer = new CriteriaLexer(CharStreams.fromString("age [1 - 10)"));
        CommonTokenStream token = new CommonTokenStream(lexer);
        CriteriaParser parser = new CriteriaParser(token);
        ParseTree tree = parser.r();

        CriteriaListenerImpl listener = new CriteriaListenerImpl();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
    }
}
