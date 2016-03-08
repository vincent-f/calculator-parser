package com.example.calculator.lexer;

import java.util.Arrays;
import java.util.Iterator;

public class CharStreamHelper {
	
	public static CharStream createFakeCharStream(Character...chars) {
		Iterator<Character> iter = Arrays.asList(chars).iterator();
		return new CharStream() {

			@Override
			public char getNext() {
				return iter.next();
			}

			@Override
			public boolean hasNext() {
				return iter.hasNext();
			}

			@Override
			public void consume() {
				iter.next();
			}
		};
		
	}

}
