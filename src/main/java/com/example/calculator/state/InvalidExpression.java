package com.example.calculator.state;

public class InvalidExpression implements MaybeParseState, MaybeValidState, MaybeValue, MaybeMultOpState, MaybeAddOpState {

    public InvalidExpression() {}

    @Override
    public InvalidExpression add(int term) {
        return this;
    }

    @Override
    public InvalidExpression subtract(int term) {
        return this;
    }

    @Override
    public InvalidExpression multiply(int factor) {
        return this;
    }

    @Override
    public InvalidExpression divide(int dividend) {
        return this;
    }

    @Override
    public InvalidExpression parseEndOfFile() {
        return this;
    }

    @Override
    public InvalidExpression parseRParenthesis() {
        return this;
    }

    @Override
    public InvalidExpression parseMultiplicativeOperator() {
        return this;
    }

    @Override
    public InvalidExpression parseAdditiveOperator() {
        return this;
    }

    @Override
    public String asString() {
        return "invalid expression";
    }

    @Override
    public InvalidExpression parseExpression() {
        return this;
    }

    @Override
    public InvalidExpression parseTerm() {
        return this;
    }
}
