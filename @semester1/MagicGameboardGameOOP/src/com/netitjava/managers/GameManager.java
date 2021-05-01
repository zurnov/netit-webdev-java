package com.netitjava.managers;

import com.netitjava.gameboard.GameBoardObject;
import com.netitjava.gameboard.pieces.Piece;
import com.netitjava.gameboard.tiles.GameBoardTile;

public class GameManager {
	private GameBoardObject[][] gameBoard;
	private final int ROW_SIZE = 9;
	private final int COL_SIZE = 7;
	
	public GameManager() {
		this.gameBoard = new Piece[this.ROW_SIZE][this.COL_SIZE]; 
	}
	
	private void render() {
		for(int row = 0; row < this.ROW_SIZE; row++) {
			for(int col = 0; col < this.COL_SIZE; col++) {
				System.out.print(this.gameBoard[row][col].render());
			}
			System.out.println("");
		}
	}
	
	private void bootstrap() {
		
		for(int row = 0; row < this.ROW_SIZE; row++) {
			for(int col = 0; col < this.COL_SIZE; col++) {
				this.gameBoard[row][col] = new GameBoardTile(row,col);
			}
		}
	}
}
