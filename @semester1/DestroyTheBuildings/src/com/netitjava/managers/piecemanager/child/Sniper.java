package com.netitjava.managers.piecemanager.child;

import com.netitjava.managers.piecemanager.parent.Unit;

public class Sniper extends Unit {

	public Sniper(int row,int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol("2");
	}
}
