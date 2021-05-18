package com.netitjava.managers.gameboardmanager;
import com.netitjava.managers.gameboardmanager.GameboardObject;
public class GameboardTile extends GameboardObject {

	protected int row;
	protected int col;
	
	public GameboardTile(int row, int col) {
		super(row, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String render() {
		
		return "x";
	}

}
