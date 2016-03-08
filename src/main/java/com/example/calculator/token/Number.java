package com.example.calculator.token;

import com.example.calculator.state.MaybeParseState;
import com.example.calculator.state.ParseState;

public class Number extends TailedTokenList {

    private final int value;

    public Number(TokenList next, int value) {
        super(next);
        this.value = value;
    }

    @Override
    public MaybeParseState factor() {
        return new ParseState(value, next);
    }
}
