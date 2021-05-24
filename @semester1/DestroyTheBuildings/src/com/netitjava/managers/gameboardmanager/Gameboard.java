package com.netitjava.managers.gameboardmanager;
import com.netitjava.util.Console;

public class Gameboard {
	
	private final int ROW_COUNT = 15;
	private final int COL_COUNT = 15;
	private GameboardObject[][] collection = null;
	private static Gameboard internalInstance = null;
	
	private Gameboard() {
		collection = new GameboardObject[ROW_COUNT][COL_COUNT];
	
	}
	
	public static Gameboard getInstance() {
		if(internalInstance == null) {
			internalInstance = new Gameboard(); 
		}
		return internalInstance;
	}
	
	public GameboardObject getElement(int row,int col) {
		return collection[row][col];
	}
	
	public void render() {
		for(int row = 0; row < ROW_COUNT; row++) {
			for(int col = 0; col < COL_COUNT; col++) {
				Console.log(collection[row][col].render());
			}
			Console.logln("");
		}
	}
	
	public void setElement(int row, int col, GameboardObject element) {
		collection[row][col] = element;
	}
}
