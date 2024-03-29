package nl.stefandejong;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonBar extends JPanel{
	
	@SuppressWarnings("unused")
	private PuzzleModel puzzleModel;
	private JButton button1;
	private JButton button2;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Maakt 2 knoppen aan in het paneel
	public ButtonBar(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;
		GameController gameController = new GameController(puzzleModel);
		
		button1 = new JButton("Reset");
		button1.addActionListener(gameController);
		button2 = new JButton("Knop 2");
		add(button1);
		add(button2);
	}	
}
