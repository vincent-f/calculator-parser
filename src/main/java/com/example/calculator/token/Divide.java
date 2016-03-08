package com.example.calculator.token;

import com.example.calculator.state.DivisionState;
import com.example.calculator.state.MaybeMultOpState;

public class Divide extends TailedTokenList {

    public Divide(TokenList next) {
        super(next);
    }

    @Override
    public MaybeMultOpState multiplicativeOperator(int forwardedDividend) {
        return new DivisionState(forwardedDividend, next);
    }
}