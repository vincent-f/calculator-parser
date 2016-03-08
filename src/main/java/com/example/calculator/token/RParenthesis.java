package com.example.calculator.token;

import com.example.calculator.state.MaybeParseState;
import com.example.calculator.state.ParseState;

public class RParenthesis extends TailedTokenList {

    public RParenthesis(TokenList next) {
        super(next);
    }

    @Override
    public MaybeParseState rightParenthesis(int forwardedExpression) {
        return new ParseState(forwardedExpression, next);
    }
}
