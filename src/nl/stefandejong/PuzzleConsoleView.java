package nl.stefandejong;

import java.util.Observable;
import java.util.Observer;

public class PuzzleConsoleView implements Observer{
	
	private PuzzleModel puzzleModel;

	// Wordt aangemeld als observer zodat de view op de hoogte blijft van updates
	public PuzzleConsoleView(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;
		refresh();
		puzzleModel.addObserver(this);
	}
	
	// 'print' voor een tegel de waarde naar de console
	// bij de lege tegel worden er brackets omheen geplaatst
	private void printTile(int row, int col) {		
		if (puzzleModel.getValue(row, col) != -1)
			System.out.printf("  %2d ", puzzleModel.getValue(row, col));
			else System.out.printf(" [%2d]", puzzleModel.getValue(row, col));
	}
	
	// Zorgt dat iedere tegel in het model geprint wordt, als een rij klaar is volgt een 'enter', alles alles klaar is volgt ook een enter
	private void refresh() {
		for (int row = 0; row < PuzzleModel.ROWS; row++) {
			for (int col = 0; col < PuzzleModel.COLS; col++) {
				printTile(row, col);
			}			
			System.out.println();
		}
		System.out.println();
	}

	// Bij notifyobservers wordt deze methode aangeroepen, welke refresh aanroept zodat het model opnieuw wordt weergegeven
	@Override
	public void update(Observable o, Object arg) {
		refresh();		
	}
}
