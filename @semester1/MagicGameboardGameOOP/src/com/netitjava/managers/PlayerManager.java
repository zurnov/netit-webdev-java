package com.netitjava.managers;

import java.util.ArrayList;

import com.netitjava.enums.PlayerColorEnum;
import com.netitjava.gameboard.pieces.*;

public class PlayerManager {
	private PlayerColorEnum color;
	private int score;
	private ArrayList<Piece> unplacedPieceCollection;
	private ArrayList<Piece> pieceCollection;

	public PlayerManager(PlayerColorEnum color) {
		this.color = color;
		
		this.pieceCollection			= new ArrayList<>();
		this.unplacedPieceCollection 	= new ArrayList<>();
		this.unplacedPieceCollection.add(new Knight (-1,-1));
		this.unplacedPieceCollection.add(new Knight (-1,-1));
		this.unplacedPieceCollection.add(new Dwarf (-1,-1));
		this.unplacedPieceCollection.add(new Dwarf (-1,-1));
		this.unplacedPieceCollection.add(new Elf (-1,-1));
		this.unplacedPieceCollection.add(new Elf (-1,-1));
	}
	
	public String getName() {
		if(this.color == PlayerColorEnum.BLACK) return "�������";
		if(this.color == PlayerColorEnum.RED) return "���������";
		return "�����������";
	}
	
	public ArrayList<Piece> getUnplacedPieceColletion(){
		return this.unplacedPieceCollection;
	}
	
	public void place(int pieceIndex, int row, int col) {
		Piece unplacedPiece = this.unplacedPieceCollection.get(pieceIndex);
		if(unplacedPiece.isMovePossible(row, col)) {
			unplacedPiece.move(row, col);
			this.unplacedPieceCollection.remove(pieceIndex);
		}
	}
	
}
