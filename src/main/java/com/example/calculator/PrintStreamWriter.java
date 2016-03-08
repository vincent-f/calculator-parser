package com.example.calculator;

import java.io.PrintStream;

public class PrintStreamWriter implements Writer {

    private final PrintStream out;

    public PrintStreamWriter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void writeLine(String line) {
        out.println(line);
    }
}
