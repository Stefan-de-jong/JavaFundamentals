package nl.stefandejong;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

public class TileButton extends JButton implements Observer{	
	
	private PuzzleModel puzzleModel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TileButton(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;
		puzzleModel.addObserver(this);		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
