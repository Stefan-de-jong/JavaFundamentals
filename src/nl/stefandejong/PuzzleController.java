package nl.stefandejong;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleController implements ActionListener {
	
	private PuzzleModel puzzleModel;
	private int row, col;
	
	// Krijgt bij het aanmaken van de controller het model mee, inclusief een eigen rij en kolom
	// Middels deze rij en kolom kan deze onderstaande methodes uitvoeren bij het clickevent
	public PuzzleController(PuzzleModel puzzleModel, int row, int col) {
		this.puzzleModel = puzzleModel;
		this.row = row;
		this.col = col;
	}	
	
	// Als er op een knop wordt geklikt worden onderstaande methodes van het model aangeroepen
	// Is de puzzle opgelost, dan klinkt een beep
	// Is de move niet mogelijk, dan klinkt ook een beep
	@Override
	public void actionPerformed(ActionEvent e) {
		if (puzzleModel.isSolved() || !puzzleModel.moveTile(row, col))
			Toolkit.getDefaultToolkit().beep();
	}
}
