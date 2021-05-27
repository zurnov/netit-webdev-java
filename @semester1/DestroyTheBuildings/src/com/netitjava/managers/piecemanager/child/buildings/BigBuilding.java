package com.netitjava.managers.piecemanager.child.buildings;

import com.netitjava.managers.piecemanager.parent.BuildingUnit;

public class BigBuilding extends BuildingUnit {

	public BigBuilding(int row,int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol("&");
		this.setSize(9);
		this.setBreakable(isBreakable);
	}
}
