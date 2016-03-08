package com.example.calculator.token;

import com.example.calculator.state.MaybeValue;
import com.example.calculator.state.Value;

public class EndOfFile extends AbstractTokenList {

    public MaybeValue endOfFile(int forwardedExpression) {
        return new Value(forwardedExpression);
    }
}
