package com.netitjava.managers.piecemanager.child.buildings;

import com.netitjava.managers.piecemanager.parent.BuildingUnit;

public class MediumBuilding extends BuildingUnit {
	
	public MediumBuilding(int row,int col) {
		this.setRow(row);
		this.setCol(col);
		this.setSymbol("%");
		this.setSize(6);
		this.setBreakable(isBreakable);
	}
}
