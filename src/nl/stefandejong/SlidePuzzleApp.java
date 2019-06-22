package nl.stefandejong;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SlidePuzzleApp extends JFrame{
	
	PuzzleModel puzzleModel; 
	PuzzleConsoleView consoleView;
	PuzzlePanelView panelView;
	StatusBalk statusBalk;
	ButtonBar buttonBar;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	public SlidePuzzleApp() {
		init();
	}	
	
	private void init(){
		puzzleModel = new PuzzleModel();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createGui();	
			}
		});			
	}


	private void createGui() {		
		setBounds(50, 50, 540, 540);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Puzzle Game!");		

		consoleView = new PuzzleConsoleView(puzzleModel);
		consoleView.refresh();
		panelView = new PuzzlePanelView(puzzleModel);
		statusBalk = new StatusBalk();
		buttonBar = new ButtonBar();
		

		setVisible(true);
		add(panelView, BorderLayout.CENTER);
		add(statusBalk, BorderLayout.SOUTH);
		add(buttonBar, BorderLayout.NORTH);
		panelView.setVisible(true);
		this.setResizable(false);
	}
	

	public static void main(String[] args) {
		new SlidePuzzleApp();
	}

}
