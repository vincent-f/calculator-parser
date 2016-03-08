package com.example.calculator.token;

import com.example.calculator.state.*;

public class AbstractTokenList implements TokenList {

    @Override
    public MaybeValue input() {
        return expression().parseEndOfFile();
    }

    @Override
    public MaybeValue endOfFile(int forwardedExpression) {
        return new InvalidExpression();
    }

    @Override
    public MaybeParseState expression() {
        return term().parseAdditiveOperator().parseExpression();
    }

    @Override
    public MaybeParseState term() {
        return factor().parseMultiplicativeOperator().parseTerm();
    }

    @Override
    public MaybeParseState factor() {
        return new InvalidExpression();
    }

    @Override
    public MaybeParseState parenthesizedExpression() {
        return leftParenthesis().parseExpression().parseRParenthesis();
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
