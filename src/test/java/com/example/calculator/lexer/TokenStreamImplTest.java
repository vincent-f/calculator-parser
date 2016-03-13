package com.example.calculator.lexer;

import com.example.calculator.token.EndOfFile;
import com.example.calculator.token.Number;
import com.example.calculator.token.TailedTokenList;
import com.example.calculator.token.TokenList;
import org.junit.Test;

import static com.example.calculator.lexer.CharStreamHelper.createFakeCharStream;
import static com.google.common.truth.Truth.assertThat;

public class TokenStreamImplTest {

    @Test
    public void skipWhitespaceBetweenTokens() {
        TokenStreamImpl ts = new TokenStreamImpl(new LookaheadCharStreamImpl(createFakeCharStream('1', ' ', '4')));
        Number one = (Number)ts.getTokenList();
        assertThat(one.value).isEqualTo(1);
        Number four = (Number)one.next;
        assertThat(four.value).isEqualTo(4);
    }

    @Test
    public void whenEndOfStream_returnsEndOfFileToken() {
        TokenStreamImpl ts = new TokenStreamImpl(new LookaheadCharStreamImpl(createFakeCharStream('1')));
        TailedTokenList firstToken = (TailedTokenList)ts.getTokenList();
        TokenList eof = firstToken.next;
        assertThat(eof).isInstanceOf(EndOfFile.class);
    }
}
