package nl.stefandejong;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBalk extends JPanel implements Observer{
	
	private PuzzleModel puzzleModel;
	private JLabel label1;
	private JLabel label2;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Maakt 2 labels aan in het paneel en hun horizontale positie in het paneel
	public StatusBalk(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;
		puzzleModel.addObserver(this);
		
		label1 = new JLabel("Label 1 ...");
		label2 = new JLabel("Label 2 ...");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		setLayout(new GridLayout(1,2));
		add(label1);
		add(label2);
		refresh();
	}
	
	private void refresh() {
		label1.setText("Aantal zetten: " + puzzleModel.aantalZetten);
	}

	@Override
	public void update(Observable o, Object arg) {
		refresh();
		
	}

	
}
