package com.netitjava.gameboard.pieces;

public class Elf extends Piece {
	
	public Elf(int row,int col) {
		super(row,col,5,1,10,3,3);
		
//		this.setAttack(5);
//		this.setDefence(1);
//		this.setHealth(10);
//		this.setDistance(3);
//		this.setSpeed(3);
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
		return "&";
	}
	
}
