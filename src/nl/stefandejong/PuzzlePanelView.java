package nl.stefandejong;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PuzzlePanelView extends JPanel implements Observer{
	
	private PuzzleModel puzzleModel;	
	JButton[][] buttons = new JButton[PuzzleModel.ROWS][PuzzleModel.COLS];
	
	private ImageIcon img1 = new ImageIcon("resources/image01.png");
	private ImageIcon img2 = new ImageIcon("resources/image02.png");
	private ImageIcon img3 = new ImageIcon("resources/image03.png");
	private ImageIcon img4 = new ImageIcon("resources/image04.png");
	private ImageIcon img5 = new ImageIcon("resources/image05.png");
	private ImageIcon img6 = new ImageIcon("resources/image06.png");
	private ImageIcon img7 = new ImageIcon("resources/image07.png");
	private ImageIcon img8 = new ImageIcon("resources/image08.png");
	private ImageIcon img9 = new ImageIcon("resources/image09.png");
	private ImageIcon img10 = new ImageIcon("resources/image10.png");
	private ImageIcon img11 = new ImageIcon("resources/image11.png");
	private ImageIcon img12 = new ImageIcon("resources/image12.png");
	private ImageIcon img13 = new ImageIcon("resources/image13.png");
	private ImageIcon img14 = new ImageIcon("resources/image14.png");
	private ImageIcon img15 = new ImageIcon("resources/image15.png");
	
	public PuzzlePanelView(PuzzleModel puzzleModel) {
		this.puzzleModel = puzzleModel;
		puzzleModel.addObserver(this);
		setLayout(new GridLayout(PuzzleModel.ROWS,PuzzleModel.COLS));
		
		for (int row = 0; row < PuzzleModel.ROWS; row++) {
			for (int col = 0; col < PuzzleModel.COLS; col++) {
				buttons[row][col] = new JButton();
				buttons[row][col].setSize(135, 135);
				buttons[row][col].addActionListener(new PuzzleController(puzzleModel, row, col));
				if (puzzleModel.getValue(row, col) != -1) {
					buttons[row][col].setIcon(getButtonIcon(puzzleModel.getValue(row, col)));
				}
				else {
					buttons[row][col].setIcon(null);
					buttons[row][col].setOpaque(false);
					buttons[row][col].setContentAreaFilled(false);
					buttons[row][col].setBorderPainted(false);
				}	
				this.add(buttons[row][col]);
			}
		}
	}
	
	
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
	
	private void refresh() {
		for (int row = 0; row < PuzzleModel.ROWS; row++) {
			for (int col = 0; col <  PuzzleModel.COLS; col++) {
				printTile(row, col);
			}
		}
	}
	
	private void setImage() {
		
	}
	

	@Override
	public void update(Observable o, Object arg) {
		refresh();
		
	}
	
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
