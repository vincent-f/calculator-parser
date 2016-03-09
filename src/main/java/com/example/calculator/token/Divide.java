package com.example.calculator.token;

import com.example.calculator.state.DivisionState;

public class Divide extends TailedTokenList {

    public Divide(TokenList next) {
        super(next);
    }

    @Override
    public DivisionState multiplicativeOperator(int forwardedDividend) {
        return new DivisionState(forwardedDividend, next);
    }
}