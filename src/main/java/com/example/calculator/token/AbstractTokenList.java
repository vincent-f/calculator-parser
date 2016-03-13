package com.example.calculator.token;

import com.example.calculator.state.*;

public class AbstractTokenList implements TokenList {

    @Override
    public MaybeValue input() {
        return expression().endOfFile();
    }

    @Override
    public MaybeValue endOfFile(int forwardedExpression) {
        return new InvalidExpression();
    }

    @Override
    public MaybeParseState expression() {
        return term().additiveOperator().expression();
    }

    @Override
    public MaybeParseState term() {
        return factor().multiplicativeOperator().term();
    }

    @Override
    public MaybeParseState factor() {
        return new InvalidExpression();
    }

    @Override
    public MaybeParseState parenthesizedExpression() {
        return leftParenthesis().expression().rightParenthesis();
    }

    @Override
    public MaybeValidState leftParenthesis() {
        return new InvalidExpression();
    }

    @Override
    public MaybeParseState rightParenthesis(int forwardedExpression) {
        return new InvalidExpression();
    }

    @Override
    public MaybeMultOpState multiplicativeOperator(int forwardedFactor) {
        return new ParseState(forwardedFactor, this);
    }

    @Override
    public MaybeAddOpState additiveOperator(int forwardedTerm) {
        return new ParseState(forwardedTerm, this);
    }
}
