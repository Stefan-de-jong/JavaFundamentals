package nl.stefandejong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GameController implements ActionListener {
	
	private PuzzleModel puzzleModel;
	
	public GameController(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;		
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = e.getActionCommand();		
		switch (buttonName) {
		case "Reset" :
			int response = JOptionPane.showConfirmDialog(null, "Are you sure? The whole puzzle will be shuffled!", "Confirm",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    if (response == JOptionPane.NO_OPTION) {
			    	JOptionPane.showMessageDialog(null, "...returning to puzzle", "Reset cancelled", JOptionPane.INFORMATION_MESSAGE);
			    } else if (response == JOptionPane.YES_OPTION) {
			    	puzzleModel.reset();
			    	JOptionPane.showMessageDialog(null, "Shuffled, have another go!", "Game reset", JOptionPane.INFORMATION_MESSAGE);
			    } else if (response == JOptionPane.CLOSED_OPTION) {
			    	JOptionPane.showMessageDialog(null, "...returning to puzzle", "Reset cancelled", JOptionPane.INFORMATION_MESSAGE);
			    }			
			break;
		case "2" : 
			// ToDo
			// eventueel voor 2e knop nog een functie
			break;				
		}
		
	}

}
