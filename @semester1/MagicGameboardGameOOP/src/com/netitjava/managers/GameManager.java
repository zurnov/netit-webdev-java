package com.netitjava.managers;
import com.netitjava.;

import java.util.ArrayList;

import com.netitjava.enums.PlayerColorEnum;
import com.netitjava.gameboard.GameBoardObject;
import com.netitjava.gameboard.pieces.Piece;
import com.netitjava.gameboard.tiles.GameBoardTile;
import com.netitjava.util.Console;

public class GameManager {
	private GameBoardObject[][] gameBoard;
	private final int ROW_SIZE = 7;
	private final int COL_SIZE = 9;
	
	private ArrayList<PlayerManager> playerManagerCollection;
	private int activePlayerIndex = 0;
	
	public GameManager() {
		this.gameBoard = new GameBoardObject[this.ROW_SIZE][this.COL_SIZE]; 
		this.playerManagerCollection = new ArrayList<PlayerManager>();
		this.playerManagerCollection.add(new PlayerManager(PlayerColorEnum.BLACK));
		this.playerManagerCollection.add(new PlayerManager(PlayerColorEnum.RED));
		
	}
	
	public void startGame() {
		this.bootstrap();
		this.render();
		
		PlayerManager activePlayer = this.getActivePlayer();
		String playerName = activePlayer.getName();
		Console.log(playerName + " са на ход.");
		Console.log("Разполагате със следните фигури: ");
		
		ArrayList<Piece> collection = activePlayer.getUnplacedPieceColletion();
		for(int i = 0; i < collection.size();i++) {
			Console.log("("+ i +") " + collection.get(i));
		}
		 int pieceID = Console.promtInt("Коя единица искате да позиционирате: ");
		 int pieceRow = Console.promtInt("На кой ред: ");
		 int pieceCol = Console.promtInt("На коя колонка: ");
		 activePlayer.place(pieceID, pieceRow, pieceCol);
	}
	
	private PlayerManager getActivePlayer() {
		return this.playerManagerCollection.get(activePlayerIndex);
	}
	
	private void endTurn() {
		activePlayerIndex++;
		
		if(this.playerManagerCollection.size() == activePlayerIndex) {
			activePlayerIndex = 0;
		}
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
