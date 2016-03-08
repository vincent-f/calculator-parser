package com.example.calculator.token;

import com.example.calculator.state.AdditionState;
import com.example.calculator.state.MaybeAddOpState;

public class Plus extends TailedTokenList {

    public Plus(TokenList next) {
        super(next);
    }

    @Override
    public MaybeAddOpState additiveOperator(int forwardedTerm) {
        return new AdditionState(forwardedTerm, next);
    }
}
