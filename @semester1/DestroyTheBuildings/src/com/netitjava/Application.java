package com.netitjava;
import com.netitjava.managers.gameboardmanager.*;
import com.netitjava.managers.GameManager;
import com.netitjava.managers.piecemanager.*;

public class Application {
	
	public static void main(String[] args) {
		
		GameManager game = new GameManager();
		game.startGame();
		
		
	}
}
