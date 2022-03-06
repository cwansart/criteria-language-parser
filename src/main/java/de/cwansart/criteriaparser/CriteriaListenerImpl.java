package de.cwansart.criteriaparser;

import de.cwansart.criteriaparser.entities.AgeRange;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class CriteriaListenerImpl implements CriteriaListener {

    private final List<String> errors = new ArrayList<>();

    private final List<AgeRange> ageCriteria = new ArrayList<>();

    private Gender gender;

    public List<String> getErrors() {
        return errors;
    }

    public List<AgeRange> getAgeCriteria() {
        return ageCriteria;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {
        this.errors.add(errorNode.getText());
    }

    @Override
    public void enterAge(CriteriaParser.AgeContext ctx) {
        if (ctx.INT(0) != null && ctx.INT(1) != null) {
            // The range will be inclusive if no brackets are given, e.g. "age 1 - 10".
            boolean inclusiveStart = isNullOrBracket(ctx.OPENING_BRACKETS());
            boolean inclusiveEnd = isNullOrBracket(ctx.CLOSING_BRACKETS());
            int start = Integer.parseInt(ctx.INT(0).getText());
            int end = Integer.parseInt(ctx.INT(1).getText());
            this.ageCriteria.add(new AgeRange(inclusiveStart, inclusiveEnd, start, end));
        }
    }

    private boolean isNullOrBracket(TerminalNode node) {
        return node == null || node.getText().equals("[") || node.getText().equals("]");
    }

    @Override
    public void enterGender(CriteriaParser.GenderContext ctx) {
        gender = Gender.fromString(ctx.GENDER_TOKEN().getText());
    }

    //<editor-fold desc="nothing to do">
    @Override
    public void visitTerminal(TerminalNode terminalNode) {
        // nothing to do
    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        // nothing to do
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {
        // nothing to do
    }

    @Override
    public void enterR(CriteriaParser.RContext ctx) {
        // nothing to do
    }

    @Override
    public void exitR(CriteriaParser.RContext ctx) {
        // nothing to do
    }

    @Override
    public void enterAvailableToken(CriteriaParser.AvailableTokenContext ctx) {
        // nothing to do
    }

    @Override
    public void exitAvailableToken(CriteriaParser.AvailableTokenContext ctx) {
        // nothing to do
    }

    @Override
    public void enterAgeIdentifier(CriteriaParser.AgeIdentifierContext ctx) {
        // nothing to do
    }

    @Override
    public void exitAgeIdentifier(CriteriaParser.AgeIdentifierContext ctx) {
        // nothing to do
    }

    @Override
    public void exitGender(CriteriaParser.GenderContext ctx) {
        // nothing to do
    }

    @Override
    public void exitAge(CriteriaParser.AgeContext ctx) {
        // nothing to do
    }
    //</editor-fold>
}
