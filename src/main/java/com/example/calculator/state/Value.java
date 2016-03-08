package com.example.calculator.state;


public class Value implements MaybeValue {

    public final int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public String asString() {
        return Integer.toString(value);
    }

}
