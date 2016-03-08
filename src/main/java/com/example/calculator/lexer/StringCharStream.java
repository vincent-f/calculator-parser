package com.example.calculator.lexer;

public class StringCharStream implements CharStream {

	private final String input;
	private char p = 0; // index of next char (p==input.length() when end of
						// input)

	public StringCharStream(String input) {
		this.input = input;
	}

	@Override
	public void consume() {
		if (!hasNext())
			throw new IllegalStateException();
		p++;
	}

	@Override
	public char getNext() {
		if (!hasNext())
			throw new IllegalStateException();
		return input.charAt(p++);
	}

	@Override
	public boolean hasNext() {
		return p != input.length();
	}

}
