package com.example.calculator.lexer;

public class LookaheadCharStreamImpl implements LookaheadCharStream {
	
	private final CharStream cs;
	private char lookahead;
	private boolean validLookahead = false;

	public LookaheadCharStreamImpl(CharStream cs) {
		this.cs = cs;
	}

	@Override
	public char getLookahead() {
		if(!validLookahead) {
			lookahead = cs.getNext();
			validLookahead = true;
		}
		return lookahead;
	}

	@Override
	public char getNext() {
		if(validLookahead) {
			validLookahead = false;
			return lookahead;
		}
		return cs.getNext();
	}

	@Override
	public boolean hasNext() {
		return validLookahead || cs.hasNext();
	}
	
	@Override
	public void consume() {
		getNext();
	}

}
