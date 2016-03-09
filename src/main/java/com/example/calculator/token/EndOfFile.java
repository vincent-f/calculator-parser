package com.example.calculator.token;

import com.example.calculator.state.Value;

public class EndOfFile extends AbstractTokenList {

    public Value endOfFile(int forwardedExpression) {
        return new Value(forwardedExpression);
    }
}
