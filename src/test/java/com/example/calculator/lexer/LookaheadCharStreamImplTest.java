package com.example.calculator.lexer;

import org.junit.Test;

import static com.example.calculator.lexer.CharStreamHelper.createFakeCharStream;
import static com.google.common.truth.Truth.assertThat;

public class LookaheadCharStreamImplTest {

	@Test
	public void getNext_returnsConsecutiveCharsFromString() {
		LookaheadCharStreamImpl lcs = new LookaheadCharStreamImpl(createFakeCharStream('a', 'b'));
		assertThat(lcs.getNext()).isEqualTo('a');
		assertThat(lcs.getNext()).isEqualTo('b');
	}

	@Test
	public void whenAllCharsReturned_hasNoMoreChars() {
		LookaheadCharStreamImpl lcs = new LookaheadCharStreamImpl(createFakeCharStream('a', 'b'));
		lcs.getNext();
		lcs.getNext();
		assertThat(lcs.hasNext()).isFalse();
	}

	@Test
	public void whenNotAllCharsReturned_hasMoreChars() {
		LookaheadCharStreamImpl lcs = new LookaheadCharStreamImpl(createFakeCharStream('a', 'b'));
		lcs.getNext();
		assertThat(lcs.hasNext()).isTrue();
	}

	@Test
	public void consume_skipsOneChar() {
		LookaheadCharStreamImpl lcs = new LookaheadCharStreamImpl(createFakeCharStream('a', 'b'));
		lcs.consume();
		assertThat(lcs.getNext()).isEqualTo('b');
	}
	
	@Test
	public void getLookahead_returnsCommingChar() {
		LookaheadCharStreamImpl lcs = new LookaheadCharStreamImpl(createFakeCharStream('a', 'b'));
		char lookahead = lcs.getLookahead();
		assertThat(lookahead).isEqualTo(lcs.getNext());
	}

}
