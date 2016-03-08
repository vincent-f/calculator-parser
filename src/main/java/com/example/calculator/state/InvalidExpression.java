package com.example.calculator.state;

public class InvalidExpression implements MaybeParseState, MaybeValidState, MaybeValue, MaybeMultOpState, MaybeAddOpState {

    public InvalidExpression() {}

    @Override
    public MaybeParseState add(int term) {
        return this;
    }

    @Override
    public MaybeParseState subtract(int term) {
        return this;
    }

    @Override
    public MaybeParseState multiply(int factor) {
        return this;
    }

    @Override
    public MaybeParseState divide(int dividend) {
        return this;
    }

    @Override
    public MaybeValue parseEndOfFile() {
        return this;
    }

    @Override
    public MaybeParseState parseRParenthesis() {
        return this;
    }

    @Override
    public MaybeMultOpState parseMultiplicativeOperator() {
        return this;
    }

    @Override
    public MaybeAddOpState parseAdditiveOperator() {
        return this;
    }

    @Override
    public String asString() {
        return "invalid expression";
    }

    @Override
    public MaybeParseState parseExpression() {
        return this;
    }

    @Override
    public MaybeParseState parseTerm() {
        return this;
    }
}
