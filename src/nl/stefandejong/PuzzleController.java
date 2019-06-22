package nl.stefandejong;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleController implements ActionListener {
	
	private PuzzleModel puzzleModel;
	int row, col;
	
	public PuzzleController(PuzzleModel puzzleModel, int row, int col) {
		this.puzzleModel = puzzleModel;
		this.row = row;
		this.col = col;
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!puzzleModel.moveTile(row, col))
			Toolkit.getDefaultToolkit().beep();		
	}
	
	

}
