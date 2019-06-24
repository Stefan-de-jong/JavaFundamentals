package nl.stefandejong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener {
	
	private PuzzleModel puzzleModel;
	
	public ButtonController(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;		
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		String kolom = e.getActionCommand();		
		switch (kolom) {
		case "New game" :
			puzzleModel.reset();
			break;
		case "2" : 
			//ToDo;
			break;				
		}
		
	}

}
