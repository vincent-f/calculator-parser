package com.example.calculator.state;

import com.example.calculator.token.TokenList;

public class ValidState implements MaybeValidState {

    public final TokenList next;

    public ValidState(TokenList next) {
        this.next = next;
    }

    @Override
    public MaybeParseState parseExpression() {
        return next.expression();
    }
}
