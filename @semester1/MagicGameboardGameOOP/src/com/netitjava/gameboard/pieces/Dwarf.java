package com.netitjava.gameboard.pieces;

public class Dwarf extends Piece {
	
	public Dwarf(int row,int col) {
		super(row,col,6,2,12,2,2);
		
//		this.setAttack(6);
//		this.setDefence(2);
//		this.setHealth(12);
//		this.setDistance(2);
//		this.setSpeed(2);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String render() {
		return "@";
	}

	
}
