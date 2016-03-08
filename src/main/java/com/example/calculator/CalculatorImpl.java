package com.example.calculator;

import com.example.calculator.lexer.TokenStream;

public class CalculatorImpl implements Calculator {

    private final TokenStream tokenStream;
    private final Writer writer;

    public CalculatorImpl(TokenStream tokenStream, Writer writer) {
        this.tokenStream = tokenStream;
        this.writer = writer;
    }

    @Override
    public void calculate() {
        String result =
                tokenStream
                        .getTokenList()
                        .input()
                        .asString();
        writer.writeLine(result);
    }
}
