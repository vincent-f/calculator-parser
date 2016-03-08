package com.example.calculator.lexer;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class StringCharStreamTest {

	@Test
	public void getNext_returnsConsecutiveCharsFromString() {
		StringCharStream scs = new StringCharStream("ab");
		assertThat(scs.getNext()).isEqualTo('a');
		assertThat(scs.getNext()).isEqualTo('b');
	}

	@Test
	public void whenAllCharsReturned_hasNoMoreChars() {
		StringCharStream scs = new StringCharStream("ab");
		scs.getNext();
		scs.getNext();
		assertThat(scs.hasNext()).isFalse();
	}

	@Test
	public void whenNotAllCharsReturned_hasMoreChars() {
		StringCharStream scs = new StringCharStream("ab");
		scs.getNext();
		assertThat(scs.hasNext()).isTrue();
	}

	@Test
	public void consume_skipsOneChar() {
		StringCharStream scs = new StringCharStream("ab");
		scs.consume();
		assertThat(scs.getNext()).isEqualTo('b');
	}

}
