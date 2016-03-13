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
    public InvalidExpression endOfFile() {
        return this;
    }

    @Override
    public InvalidExpression rightParenthesis() {
        return this;
    }

    @Override
    public InvalidExpression multiplicativeOperator() {
        return this;
    }

    @Override
    public InvalidExpression additiveOperator() {
        return this;
    }

    @Override
    public String asString() {
        return "invalid expression";
    }

    @Override
    public InvalidExpression expression() {
        return this;
    }

    @Override
    public InvalidExpression term() {
        return this;
    }
}
