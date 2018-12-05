package com.example.calculator.lexer;

import com.example.calculator.token.*;
import com.example.calculator.token.Number;

public class TokenStreamImpl implements TokenStream {
	private final LookaheadCharStream cs;
    private boolean closed = false;

	public TokenStreamImpl(LookaheadCharStream cs) {
		this.cs = cs;
	}

	@Override
	public TokenList getTokenList() {
        if(closed)
            throw new RuntimeException();
		skipWhitespace();
		if(!cs.hasNext()) {
            closed = true;
            return new EndOfFile();
        }
		char lookahead = cs.getLookahead();
		if (lookahead == '+') {
			cs.consume();
			return new Plus(getTokenList());
		}
		else if (lookahead == '-') {
			cs.consume();
			return new Minus(getTokenList());
		}
		else if (lookahead == '*') {
			cs.consume();
			return new Times(getTokenList());
		}
		else if (lookahead == '/') {
			cs.consume();
			return new Divide(getTokenList());
		}
		else if (lookahead == '(') {
			cs.consume();
			return new LParenthesis(getTokenList());
		}
		else if (lookahead == ')') {
			cs.consume();
			return new RParenthesis(getTokenList());
		}
		else if (Character.isDigit(lookahead)) {
			int value = getIntValue();
			return new Number(getTokenList(), value);
		}
		else
			return new InvalidToken();
	}

	private int getIntValue() {
		var builder = new StringBuilder();
		do
			builder.append(cs.getNext());
		while (cs.hasNext() && isDigit(cs.getLookahead()));
		return Integer.parseInt(builder.toString());
	}

	private void skipWhitespace() {
		while (cs.hasNext() && isWhitespace(cs.getLookahead()))
			cs.consume();
	}

	private boolean isWhitespace(char c) {
		return c == ' ' || c == '\t' || c == '\n' || c == '\r';
	}

	private boolean isDigit(char c) {
		return ('0' <= c && c <= '9');
	}
}
