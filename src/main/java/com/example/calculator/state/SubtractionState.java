package com.example.calculator.state;

import com.example.calculator.token.TokenList;

public class SubtractionState implements MaybeAddOpState {

    public final int leftTerm;
    public final TokenList next;

    public SubtractionState(int leftTerm, TokenList next) {
        this.leftTerm = leftTerm;
        this.next = next;
    }
    @Override
    public MaybeParseState expression() {
        return next
                .expression()
                .subtract(leftTerm);
    }
}
