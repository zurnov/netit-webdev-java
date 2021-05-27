package com.netitjava.managers.piecemanager.parent;

public class BuildingUnit {
	protected int row;
	protected int col;
	protected int size;
	protected String symbol;
	protected boolean isBreakable;
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public boolean isBreakable() {
		return isBreakable;
	}
	public void setBreakable(boolean isBreakable) {
		this.isBreakable = isBreakable;
	}
	
	
	
}
