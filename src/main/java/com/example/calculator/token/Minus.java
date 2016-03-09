package com.example.calculator.token;

import com.example.calculator.state.SubtractionState;

public class Minus extends TailedTokenList {

    public Minus(TokenList next) {
        super(next);
    }

    @Override
    public SubtractionState additiveOperator(int forwardedTerm) {
        return new SubtractionState(forwardedTerm, next);
    }
}
