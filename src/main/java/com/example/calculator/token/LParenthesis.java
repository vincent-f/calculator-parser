package com.example.calculator.token;

import com.example.calculator.state.MaybeParseState;
import com.example.calculator.state.MaybeValidState;
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
    public MaybeValidState leftParenthesis() {
        return new ValidState(next);
    }
}