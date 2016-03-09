package com.example.calculator.token;

import com.example.calculator.state.MaybeParseState;
import com.example.calculator.state.ValidState;

public class LParenthesis extends TailedTokenList {

    public LParenthesis(TokenList next) {
        super(next);
    }

    @Override
    public MaybeParseState factor() {
        return parenthesizedExpression();
    }

    @Override
    public ValidState leftParenthesis() {
        return new ValidState(next);
    }
}