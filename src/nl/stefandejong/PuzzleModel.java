package nl.stefandejong;

import java.awt.Toolkit;
import java.util.Observable;

import javax.swing.JOptionPane;

public class PuzzleModel extends Observable{
	
	public static final int ROWS = 4;
	public static final int COLS = 4;
	private int[][] tiles;
	private int[][] correctTiles;
		
	public PuzzleModel() {
		//testInit();
		init();
		shuffle();
	}
	
	public void init() {
		tiles = new int[ROWS][COLS];
		correctTiles = new int [ROWS][COLS];
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if ( row != ROWS-1 || col != COLS-1 ) {
					tiles[row][col] = (row * COLS)+col+1;
					correctTiles[row][col] = (row * COLS)+col+1;
				}
				else {
					tiles[row][col] = -1;
					correctTiles[row][col] = -1;
				}
			}			
		}		
	}
	
	public void shuffle() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				swapTiles(row, col, (int)(Math.random()*ROWS), (int)(Math.random()*COLS));
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
		
		if (isSolved()) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "You solved the puzzle!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public boolean isSolved() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				
				if (tiles[row][col] == correctTiles[row][col]) {
					continue;
				}else return false;
			}
		}return true;
	}
	
		

	// Simpele initialisatie om te testen
	@SuppressWarnings("unused")
	private void testInit() {
		tiles = new int[][]{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,-1,15}};
		
		correctTiles = new int[][]{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,-1}};
	}	
	
}
