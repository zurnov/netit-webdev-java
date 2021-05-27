package com.netitjava.managers.piecemanager.child.buildings;

import com.netitjava.managers.piecemanager.parent.BuildingUnit;

public class SmallBuilding extends BuildingUnit {
	
	public SmallBuilding(int row,int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol("@");
		this.setSize(4);
		this.setBreakable(isBreakable);
	}
}
