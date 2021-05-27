package com.netitjava.managers.piecemanager.child;

import com.netitjava.managers.piecemanager.parent.Unit;

public class Tank extends Unit {

	public Tank(int row,int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol("1");
	}
}
