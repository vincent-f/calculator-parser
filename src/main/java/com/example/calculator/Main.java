package com.example.calculator;

public class Main {
    public static void main(String[] args) {
        var calculator = new CalculatorFactoryImpl().create("4+(9* 2-1)");
        calculator.calculate();
    }
}
