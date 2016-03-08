package com.example.calculator.token;

import com.example.calculator.state.*;

public interface TokenList {

    /**
     * input := expression END_OF_FILE
     */
    MaybeValue input();

    /**
     * input_1 := END_OF_FILE
     */
    MaybeValue endOfFile(int forwardedExpression);

    /**
     * expression := term ((PLUS|MINUS) expression)?
     */
    MaybeParseState expression();

    /**
     * term := factor ((TIMES|DIVIDE) term)?
     */
    MaybeParseState term();

    /**
     * factor := parenthesizedExpression|value
     */
    MaybeParseState factor();

    /**
     * parenthesizedExpression := L_PARENTHESIS expression R_PARENTHESIS
     */
    MaybeParseState parenthesizedExpression();

    MaybeValidState leftParenthesis();

    MaybeParseState rightParenthesis(int forwardedExpression);

    MaybeMultOpState multiplicativeOperator(int forwardedFactor);

    MaybeAddOpState additiveOperator(int value);
}
