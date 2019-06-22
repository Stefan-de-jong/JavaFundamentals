package nl.stefandejong;

import java.util.Observable;

public class PuzzleModel extends Observable{
	
	public static final int ROWS = 4;
	public static final int COLS = 4;
	private int[][] tiles;
		
	public PuzzleModel() {
		init();
	}
	
	public void init() {
		tiles = new int[ROWS][COLS];
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if ( row != ROWS-1 || col != COLS-1 ) {
					tiles[row][col] = (row * COLS)+col+1;
				} else tiles[row][col] = -1;				
			}			
		}
		
	}
	
	public int getValue(int row, int col) {
		return tiles[row][col];
	}
	
	
	public boolean moveTile(int row, int col) {
		return checkNeighbourForEmpty(row, col, -1, 0) || checkNeighbourForEmpty(row, col, 1, 0) || checkNeighbourForEmpty(row, col, 0, -1) || checkNeighbourForEmpty(row, col, 0, 1);
	}
	
	
	public boolean checkNeighbourForEmpty(int row, int col, int rDelta, int cDelta) {
		int rowNeighbour = row + rDelta;
		int colNeighbour = col + cDelta;
		
		if( isValidTile(rowNeighbour, colNeighbour) && tiles[rowNeighbour][colNeighbour] == -1 ) {
			swapTiles(row, col, rowNeighbour, colNeighbour);
			return true;
		}
		return false;
	}
	
	public boolean isValidTile(int row, int col) {
		return row >= 0 && row < ROWS && col >= 0 && col < COLS;
	}
	
	public void swapTiles(int row1, int col1, int row2, int col2) {
		int temp = tiles[row1][col1];
		tiles[row1][col1] = tiles[row2][col2];
		tiles[row2][col2] = temp;
		setChanged();
		notifyObservers();
	}
	
	
	

}
