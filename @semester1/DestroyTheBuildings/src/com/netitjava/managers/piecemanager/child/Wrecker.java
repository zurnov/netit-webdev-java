package com.netitjava.managers.piecemanager.child;

import com.netitjava.managers.piecemanager.parent.Unit;

public class Wrecker extends Unit {

	public Wrecker(int row,int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol("4");
	}
}
