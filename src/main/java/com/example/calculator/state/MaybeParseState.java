package com.example.calculator.state;

public interface MaybeParseState {

    MaybeParseState add(int term);

    MaybeParseState subtract(int term);

    MaybeParseState multiply(int factor);

    MaybeParseState divide(int dividend);

    MaybeValue endOfFile();

    MaybeParseState rightParenthesis();

    MaybeMultOpState multiplicativeOperator();

    MaybeAddOpState additiveOperator();
}
