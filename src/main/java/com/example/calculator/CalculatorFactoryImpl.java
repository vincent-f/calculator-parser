package com.example.calculator;

import com.example.calculator.lexer.LookaheadCharStreamImpl;
import com.example.calculator.lexer.StringCharStream;
import com.example.calculator.lexer.TokenStreamImpl;

public class CalculatorFactoryImpl implements CalculatorFactory {

    @Override
    public Calculator create(String input) {
        return
                new CalculatorImpl(
                        new TokenStreamImpl(
                                new LookaheadCharStreamImpl(
                                        new StringCharStream(input))),
                        new PrintStreamWriter(
                                System.out));
    }
}
