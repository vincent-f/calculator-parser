package com.example.calculator.state;

import com.example.calculator.token.TokenList;

public class DivisionState implements MaybeMultOpState {

    public final int dividend;
    public final TokenList next;

    public DivisionState(int dividend, TokenList next) {
        this.dividend = dividend;
        this.next = next;
    }

    @Override
    public MaybeParseState term() {
        return next
                .term()
                .divide(dividend);
    }
}
