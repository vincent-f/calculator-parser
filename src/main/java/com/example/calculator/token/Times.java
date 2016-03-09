package com.example.calculator.token;

import com.example.calculator.state.MultiplicationState;

public class Times extends TailedTokenList {

    public Times(TokenList next) {
        super(next);
    }

    @Override
    public MultiplicationState multiplicativeOperator(int forwardedFactor) {
        return new MultiplicationState(forwardedFactor, next);
    }
}
