package nl.stefandejong;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PuzzlePanelView extends JPanel implements Observer{
	
	private PuzzleModel puzzleModel;	
	private JButton[][] buttons = new JButton[PuzzleModel.ROWS][PuzzleModel.COLS];
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// De resources, gekoppeld aan een icoon-variabele	
	private ImageIcon img1 = new ImageIcon(getClass().getResource("/image01.png"));
	private ImageIcon img2 = new ImageIcon(getClass().getResource("/image02.png"));
	private ImageIcon img3 = new ImageIcon(getClass().getResource("/image03.png"));
	private ImageIcon img4 = new ImageIcon(getClass().getResource("/image04.png"));
	private ImageIcon img5 = new ImageIcon(getClass().getResource("/image05.png"));
	private ImageIcon img6 = new ImageIcon(getClass().getResource("/image06.png"));
	private ImageIcon img7 = new ImageIcon(getClass().getResource("/image07.png"));
	private ImageIcon img8 = new ImageIcon(getClass().getResource("/image08.png"));
	private ImageIcon img9= new ImageIcon(getClass().getResource("/image09.png"));
	private ImageIcon img10 = new ImageIcon(getClass().getResource("/image10.png"));
	private ImageIcon img11 = new ImageIcon(getClass().getResource("/image11.png"));
	private ImageIcon img12 = new ImageIcon(getClass().getResource("/image12.png"));
	private ImageIcon img13 = new ImageIcon(getClass().getResource("/image13.png"));
	private ImageIcon img14 = new ImageIcon(getClass().getResource("/image14.png"));
	private ImageIcon img15 = new ImageIcon(getClass().getResource("/image15.png"));	
	
	// Maakt op basis van het puzzlemodel een nieuwe gridlayout (rijen en kolommen) en knoppen
	// Wordt aangemeld als observer zodat het panel op de hoogte blijft van updates
	// Bij aanmaken van de knoppen wordt meteen de controller toegevoegd
	public PuzzlePanelView(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;
		puzzleModel.addObserver(this);
		setLayout(new GridLayout(PuzzleModel.ROWS,PuzzleModel.COLS));
		
		for (int row = 0; row < PuzzleModel.ROWS; row++) {
			for (int col = 0; col < PuzzleModel.COLS; col++) {
				buttons[row][col] = new JButton();
				buttons[row][col].setSize(135, 135);
				buttons[row][col].addActionListener(new PuzzleController(puzzleModel, row, col));
				printTile(row, col);				
				this.add(buttons[row][col]);
			}
		}
	}
	
	// Zorgt voor het correcte icoon op een knop, afhankelijk van de waarde die deze heeft in het het onderliggende model
	private void printTile(int row, int col) {
		if (puzzleModel.getValue(row, col) != -1) {
			buttons[row][col].setIcon(getButtonIcon(puzzleModel.getValue(row, col)));
		}
		else{
			buttons[row][col].setIcon(null);
			buttons[row][col].setOpaque(false);
			buttons[row][col].setContentAreaFilled(false);
			buttons[row][col].setBorderPainted(false);
		}
	}
	
	// Bij een update van het model zorgt deze methode voor het opnieuw 'printen' van alle tegels, waardoor de juiste iconen worden weergegeven
	private void refresh() {
		for (int row = 0; row < PuzzleModel.ROWS; row++) {
			for (int col = 0; col <  PuzzleModel.COLS; col++) {
				printTile(row, col);
			}
		}
	}	

	// Bij notifyobservers wordt deze methode aangeroepen, welke refresh aanroept zodat het model opnieuw wordt weergegeven
	@Override
	public void update(Observable o, Object arg) {
		refresh();		
	}
	
	// Geeft op basis van de value terug wel icoon hierbij hoort
	private ImageIcon getButtonIcon(int value) {
        switch ( value ) {
            case 1 :
                return img1;                
            case 2 :
                return img2;
            case 3 :
                return img3;                
            case 4 :
                return img4;   
            case 5 :
                return img5;                
            case 6 :
                return img6;   
            case 7 :
                return img7;                
            case 8 :
                return img8;   
            case 9 :
                return img9;                
            case 10 :
                return img10;   
            case 11 :
                return img11;                
            case 12 :
                return img12;   
            case 13 :
                return img13;                
            case 14 :
                return img14;   
            case 15 :
                return img15;                            
        }
		return null;
    }  
}
