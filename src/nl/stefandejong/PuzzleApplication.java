package nl.stefandejong;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PuzzleApplication extends JFrame{
	
	PuzzleModel puzzleModel; 		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private PuzzleApplication() {
		init();
	}	
	
	// Maakt een nieuwe instantie van PuzzleModel en roept createGui aan
	private void init(){
		puzzleModel = new PuzzleModel();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createGui();	
			}
		});			
	}
	
	// Maakt de GUI, stelt in dat deze niet te resizen is ivm proporties van de afbeeldingen
	private void createGui() {		
		setBounds(650, 250, 540, 540);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Puzzle Game!");		

		@SuppressWarnings("unused")
		PuzzleConsoleView consoleView = new PuzzleConsoleView(puzzleModel);		
		PuzzlePanelView panelView = new PuzzlePanelView(puzzleModel);
		StatusBalk statusBalk = new StatusBalk(puzzleModel);
		ButtonBar buttonBar = new ButtonBar();
		setVisible(true);
		
		add(panelView, BorderLayout.CENTER);
		add(statusBalk, BorderLayout.SOUTH);
		add(buttonBar, BorderLayout.NORTH);
		
		this.setResizable(false);		
	}
	

	public static void main(String[] args) {
		new PuzzleApplication();
	}

}
