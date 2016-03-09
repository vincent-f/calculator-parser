package com.example.calculator.token;

import com.example.calculator.state.ParseState;

public class RParenthesis extends TailedTokenList {

    public RParenthesis(TokenList next) {
        super(next);
    }

    @Override
    public ParseState rightParenthesis(int forwardedExpression) {
        return new ParseState(forwardedExpression, next);
    }
}
