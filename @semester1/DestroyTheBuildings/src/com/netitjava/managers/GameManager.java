package com.netitjava.managers;
import com.netitjava.managers.piecemanager.*;
import com.netitjava.managers.gameboardmanager.*;

public class GameManager {
	private final int ROW_COUNT = 7;
	private final int COL_COUNT = 9;

	public GameManager() {

		
		
	}
	public void startGame() {
		
			// 0. Bootstrap main game board
			this.bootstrap();
			this.render();
	}
	private void render() {
		Gameboard.getInstance().render();
	}
	private void bootstrap() {
		
		for(int row = 0; row < this.ROW_COUNT; row++) {
			for(int col = 0; col < this.COL_COUNT; col++) {
				
				
				Gameboard.getInstance().setElement(row, col, new GameboardTile(row, col));
			}
		}
	}
}
