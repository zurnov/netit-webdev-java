package com.netitjava.managers.piecemanager.child;

import com.netitjava.managers.piecemanager.parent.Unit;

public class Tile extends Unit{

	public Tile(int row,int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol("x");
	}
}
