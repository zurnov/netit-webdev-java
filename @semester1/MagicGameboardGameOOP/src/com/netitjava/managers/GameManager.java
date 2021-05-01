package com.netitjava.managers;

import java.util.ArrayList;

import com.netitjava.gameboard.GameBoardObject;
import com.netitjava.gameboard.pieces.Dwarf;
import com.netitjava.gameboard.pieces.Elf;
import com.netitjava.gameboard.pieces.Knight;
import com.netitjava.gameboard.pieces.Piece;
import com.netitjava.gameboard.tiles.GameBoardTile;

public class GameManager {
	private GameBoardObject[][] gameBoard;
	private final int ROW_SIZE = 9;
	private final int COL_SIZE = 7;
	
	private ArrayList<Piece> blackPlayer;
	private ArrayList<Piece> redPlayer;
	
	public GameManager() {
		this.gameBoard = new Piece[this.ROW_SIZE][this.COL_SIZE]; 
		this.blackPlayer = new ArrayList<>();
		this.blackPlayer.add(new Knight(-1,-1));
		this.blackPlayer.add(new Knight(-1,-1));
		this.blackPlayer.add(new Dwarf(-1,-1));
		this.blackPlayer.add(new Dwarf(-1,-1));
		this.blackPlayer.add(new Elf(-1,-1));
		this.blackPlayer.add(new Elf(-1,-1));
		
		
		this.redPlayer = new ArrayList<>();
		this.redPlayer.add(new Knight(-1,-1));
		this.redPlayer.add(new Knight(-1,-1));
		this.redPlayer.add(new Dwarf(-1,-1));
		this.redPlayer.add(new Dwarf(-1,-1));
		this.redPlayer.add(new Elf(-1,-1));
		this.redPlayer.add(new Elf(-1,-1));
	}
	
	public void startGame() {
		this.bootstrap();
		this.render();
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
