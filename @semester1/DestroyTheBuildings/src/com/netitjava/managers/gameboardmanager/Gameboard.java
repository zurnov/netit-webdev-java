package com.netitjava.managers.gameboardmanager;

public class Gameboard {
	private final int ROW_COUNT = 15;
	private final int COL_COUNT = 15;
	private GameboardObject[][] collection = null;
	
	private Gameboard() {
		collection = new GameboardObject[ROW_COUNT][COL_COUNT];
	}
}
