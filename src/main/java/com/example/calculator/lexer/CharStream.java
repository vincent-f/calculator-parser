package com.example.calculator.lexer;

public interface CharStream {
	
	char getNext();

	boolean hasNext();

	void consume();
}
