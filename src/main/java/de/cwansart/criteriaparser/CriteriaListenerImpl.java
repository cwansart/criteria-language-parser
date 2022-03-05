package de.cwansart.criteriaparser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class CriteriaListenerImpl implements CriteriaListener{
    @Override
    public void enterR(CriteriaParser.RContext ctx) {
        System.out.println("enterR:" + ctx.getText());
    }

    @Override
    public void exitR(CriteriaParser.RContext ctx) {

    }

    @Override
    public void enterAge(CriteriaParser.AgeContext ctx) {
        System.out.println("enterAge:"+ ctx.INT(0).getText());
    }

    @Override
    public void exitAge(CriteriaParser.AgeContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
