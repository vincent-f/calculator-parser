package com.example.calculator.lexer;

public interface LookaheadCharStream {

	char getLookahead();

	char getNext();

	boolean hasNext();

	void consume();

}
