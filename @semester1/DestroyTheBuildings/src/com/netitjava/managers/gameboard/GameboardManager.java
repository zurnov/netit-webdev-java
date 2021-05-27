package com.netitjava.managers.gameboard;

import com.netitjava.managers.piecemanager.child.*;
import com.netitjava.managers.piecemanager.child.Tile;
import com.netitjava.util.Console;

public class GameboardManager {

	private final int GAMEBOARD_SIZE = 15;
	private Object[][] gameboard;
	
	public GameboardManager() {
		this.gameboard = new Object[GAMEBOARD_SIZE][GAMEBOARD_SIZE];
		
	}
	public void start() {
		this.boostrap();
		this.render();
	}
	private void render() {
		for(int row = 0; row < this.GAMEBOARD_SIZE; row++) {
			for(int col = 0; col < this.GAMEBOARD_SIZE; col++) {
				
				if(gameboard[row][col] instanceof Tile) {
					Console.log(((Tile) this.gameboard[row][col]).getSymbol());
				}
				if(gameboard[row][col] instanceof Tank) {
					Console.log(((Tank) this.gameboard[row][col]).getSymbol());
				}
				if(gameboard[row][col] instanceof Sniper) {
					Console.log(((Sniper) this.gameboard[row][col]).getSymbol());
				}
				if(gameboard[row][col] instanceof Spy) {
					Console.log(((Spy) this.gameboard[row][col]).getSymbol());
				}
				if(gameboard[row][col] instanceof Wrecker) {
					Console.log(((Wrecker) this.gameboard[row][col]).getSymbol());
				}
				
			}
			Console.logln("");
		
		}
		this.isBuildingPlacementPossible(14,10,2,2);
	}
	private void boostrap() {
		this.generateTile();
		this.generateTeam();
		
		
	}
	private void generateTile() {
		
		for(int row = 0; row < GAMEBOARD_SIZE; row++) {
			for(int col = 0; col < GAMEBOARD_SIZE; col++) {
				this.setGameboardElement(row, col, new Tile(row, col));
			}
		}	
	}
	private void generateTeam() {
		
		this.setGameboardElement(14, 11, new Tank(14, 11));
		this.setGameboardElement(14, 12, new Sniper(14, 12));
		this.setGameboardElement(14, 13, new Spy(14, 13));
		this.setGameboardElement(14, 14, new Wrecker(14, 14));
		
	}
	private void setGameboardElement(int row, int col, Object element) {
		this.gameboard[row][col] = element;
	}
	
	private void generateSmallBuilding(int row,int col,int size) {
		
	}
	private boolean isBuildingPlacementPossible(int row,int col,int lenght,int wight) {
		if(this.isTileClear(row, col)){
			for(int i = 0; i < lenght - 1; i++) {
				for(int j = 0; j < wight - 1; j++) {
					if(!this.isTileClear(row++, col++)) {
						Console.log("false");
						return false;
					}
					
				}
			}
			
		}
		else {
			Console.log("false2");
			return false;
		}
		
		Console.log("true");
		return true;	
	}
	private boolean isTileClear(int row,int col) {
		if(gameboard[row][col] instanceof Tile) {
			((Tile) this.gameboard[row][col]).getSymbol();
			return true;
		}
		return false;
	}
}
