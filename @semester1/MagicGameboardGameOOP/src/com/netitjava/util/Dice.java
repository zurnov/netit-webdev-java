package com.netitjava.util;

import java.util.Random;

public final class Dice {
	
	private Dice() {
		
	}
	
	public static int six() {
		return roll(6);
	}
	
	private static int roll(int upperBound) {
		Random randomNumberGenerator = new Random();
		return randomNumberGenerator.nextInt(upperBound) + 1;
	}

}
