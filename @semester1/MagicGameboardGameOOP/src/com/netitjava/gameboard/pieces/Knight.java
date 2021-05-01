package com.netitjava.gameboard.pieces;

public class Knight extends Piece {
	
	public Knight(int row,int col) {
		super(row, col, 8,3,15,1,1);
		
//		this.setAttack(8);
//		this.setDefence(3);
//		this.setHealth(15);
//		this.setDistance(1);
//		this.setSpeed(1);
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
		return "%";
	}
 
}
