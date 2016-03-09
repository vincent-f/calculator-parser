package com.example.calculator.token;

import com.example.calculator.state.AdditionState;

public class Plus extends TailedTokenList {

    public Plus(TokenList next) {
        super(next);
    }

    @Override
    public AdditionState additiveOperator(int forwardedTerm) {
        return new AdditionState(forwardedTerm, next);
    }
}
