package com.example.calculator.token;

public abstract class TailedTokenList extends AbstractTokenList {

    public TokenList next;

    public TailedTokenList(TokenList next) {
        this.next = next;
    }

}
