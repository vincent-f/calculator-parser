package com.example.calculator.state;

public interface MaybeParseState {

    MaybeParseState add(int term);

    MaybeParseState subtract(int term);

    MaybeParseState multiply(int factor);

    MaybeParseState divide(int dividend);

    MaybeValue parseEndOfFile();

    MaybeParseState parseRParenthesis();

    MaybeMultOpState parseMultiplicativeOperator();

    MaybeAddOpState parseAdditiveOperator();
}
