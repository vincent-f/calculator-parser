package com.example.calculator.state;

import com.example.calculator.token.TokenList;

public class ParseState implements MaybeParseState, MaybeMultOpState, MaybeAddOpState {

    public final int value;
    public final TokenList next;

    public ParseState(int value, TokenList next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public MaybeParseState add(int term) {
        return new ParseState(term + value, next);
    }

    @Override
    public MaybeParseState subtract(int term) {
        return new ParseState(term - value, next);
    }

    @Override
    public MaybeParseState multiply(int factor) {
        return new ParseState(factor * value, next);
    }

    @Override
    public MaybeParseState divide(int dividend) {
        return new ParseState(dividend / value, next);
    }

    @Override
    public MaybeValue parseEndOfFile() {
        return next.endOfFile(value);
    }

    @Override
    public MaybeParseState parseRParenthesis() {
        return next.rightParenthesis(value);
    }

    @Override
    public MaybeMultOpState parseMultiplicativeOperator() {
        return next.multiplicativeOperator(value);
    }

    @Override
    public MaybeParseState parseTerm() {
        return this;
    }

    @Override
    public MaybeAddOpState parseAdditiveOperator() {
        return next.additiveOperator(value);
    }

    @Override
    public MaybeParseState parseExpression() {
        return this;
    }
}
