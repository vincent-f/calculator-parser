package com.example.calculator.state;

import com.example.calculator.token.TokenList;

public class MultiplicationState implements MaybeMultOpState {

    public final int leftFactor;
    public final TokenList next;

    public MultiplicationState(int leftFactor, TokenList next) {
        this.leftFactor = leftFactor;
        this.next = next;
    }

    @Override
    public MaybeParseState parseTerm() {
        return next
                .term()
                .multiply(leftFactor);
    }
}
