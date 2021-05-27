package com.netitjava.managers;

public class GameKeyManager {
	public static final String FORWARD 		= "w";
	public static final String BACKWARD 	= "s";
	public static final String LEFT 		= "a";
	public static final String RIGHT 		= "d";
	
	
	public static boolean isDirectionKey(String keyCodeParameter) {
		
		return 	process(keyCodeParameter).equals(FORWARD) 	||
				process(keyCodeParameter).equals(LEFT) 	||
				process(keyCodeParameter).equals(BACKWARD) ||
				process(keyCodeParameter).equals(RIGHT);
	}
	
	private static String process(String keyCodeParameter) {
		return keyCodeParameter.toLowerCase(); 
	}
}
