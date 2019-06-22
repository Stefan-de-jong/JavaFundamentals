package nl.stefandejong;

import java.util.Observable;
import java.util.Observer;

public class PuzzleConsoleView implements Observer{
	
	private PuzzleModel puzzleModel;

	public PuzzleConsoleView(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;
		puzzleModel.addObserver(this);
	}
	
	private void printTile(int row, int col) {		
		if (puzzleModel.getValue(row, col) != -1)
			System.out.printf("  %2d", puzzleModel.getValue(row, col));
			else System.out.printf(" [%2d]", puzzleModel.getValue(row, col));
	}
	
	public void refresh() {
		for (int row = 0; row < PuzzleModel.ROWS; row++) {
			for (int col = 0; col < PuzzleModel.COLS; col++) {
				printTile(row, col);
			}			
			System.out.println();
		}
		System.out.println();
	}

	@Override
	public void update(Observable o, Object arg) {
		refresh();		
	}
}
