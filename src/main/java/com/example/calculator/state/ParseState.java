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
    public ParseState add(int term) {
        return new ParseState(term + value, next);
    }

    @Override
    public ParseState subtract(int term) {
        return new ParseState(term - value, next);
    }

    @Override
    public ParseState multiply(int factor) {
        return new ParseState(factor * value, next);
    }

    @Override
    public ParseState divide(int dividend) {
        return new ParseState(dividend / value, next);
    }

    @Override
    public MaybeValue endOfFile() {
        return next.endOfFile(value);
    }

    @Override
    public MaybeParseState rightParenthesis() {
        return next.rightParenthesis(value);
    }

    @Override
    public MaybeMultOpState multiplicativeOperator() {
        return next.multiplicativeOperator(value);
    }

    @Override
    public ParseState term() {
        return this;
    }

    @Override
    public MaybeAddOpState additiveOperator() {
        return next.additiveOperator(value);
    }

    @Override
    public ParseState expression() {
        return this;
    }
}
