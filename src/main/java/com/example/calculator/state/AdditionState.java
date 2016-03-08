package com.example.calculator.state;

import com.example.calculator.token.TokenList;

public class AdditionState implements MaybeAddOpState {

    public final int leftTerm;
    public final TokenList next;

    public AdditionState(int leftTerm, TokenList next) {
        this.leftTerm = leftTerm;
        this.next = next;
    }
    @Override
    public MaybeParseState parseExpression() {
        return next
                .expression()
                .add(leftTerm);
    }
}
