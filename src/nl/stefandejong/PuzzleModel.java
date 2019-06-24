package nl.stefandejong;

import java.awt.Toolkit;
import java.util.Observable;

import javax.swing.JOptionPane;

public class PuzzleModel extends Observable{
	
	// Twee constante waardes voor het aantal rijen en kolommen, zodat deze op 1 plek in de applicatie kunnen worden aangepast
	public static final int ROWS = 4;
	public static final int COLS = 4;
	private int[][] tiles;
	private int[][] correctTiles;
	public int nMoves;
	public int nCorrectTiles;
	
	// Door testInit aan te roepen (uncomment) ipv init en shuffle (beiden uit commenten) wordt een makkelijke oplosbare puzzel opgezet om te testen
	public PuzzleModel() {
		//testInit();
		init();
		shuffle();

	}
	
	// Initialiseert de puzzel om te kunnen spelen
	private void init() {
		tiles = new int[ROWS][COLS];
		correctTiles = new int [ROWS][COLS];
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if ( row != ROWS-1 || col != COLS-1 ) {
					tiles[row][col] = (row * COLS)+col+1;
					correctTiles[row][col] = (row * COLS)+col+1;
				}
				else {
					tiles[row][col] = -1;
					correctTiles[row][col] = -1;
				}
			}			
		}
	}
	
	// Wisselt iedere tegel 1 keer, met een random andere tegel
	// Let op, door deze manier van shuffle is het mogelijk dat een puzzle niet oplosbaar is
	// Dit heeft te maken met de logica achter een schuifpuzzel
	// Het aantal inversies, even of oneven, evenals de positie van het 'gat' bepaalt of een puzzle op te lossen is
	public void shuffle() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				swapTiles(row, col, (int)(Math.random()*ROWS), (int)(Math.random()*COLS));
			}
		}
		nMoves = 0;		
		setChanged();
		notifyObservers();
		
	}
	
	// Reset het spel
	public void reset() {
		init();
		shuffle();
	}
	
	
	public int getValue(int row, int col) {
		return tiles[row][col];
	}
		
	// Kijkt mbv de onderliggende methode of een tegel verplaatst kan worden: is de lege tegel links, rechts, boven of onder de geklikte tegel
	public boolean moveTile(int row, int col) {
		return checkNeighbourForEmpty(row, col, -1, 0) || checkNeighbourForEmpty(row, col, 1, 0) || checkNeighbourForEmpty(row, col, 0, -1) || checkNeighbourForEmpty(row, col, 0, 1);
	}
	
	// Kijkt of de tegel naast de aangeklikte tegel geldig is, dus in het speelveld, EN of deze een waarde heeft van -1 (het 'gat')
	// Als dit zo is worden de tegels gewisseld met de onderliggende methode
	private boolean checkNeighbourForEmpty(int row, int col, int rDelta, int cDelta) {
		int rowNeighbour = row + rDelta;
		int colNeighbour = col + cDelta;
		
		if( isValidTile(rowNeighbour, colNeighbour) && tiles[rowNeighbour][colNeighbour] == -1 ) {
			swapTiles(row, col, rowNeighbour, colNeighbour);
			return true;
		}
		return false;
	}
	
	// Kijkt of deze tegel binnen het speelveld valt
	private boolean isValidTile(int row, int col) {
		return row >= 0 && row < ROWS && col >= 0 && col < COLS;
	}
	
	// Wisselt de 2 meegegeven tegels om
	private void swapTiles(int row1, int col1, int row2, int col2) {
		int temp = tiles[row1][col1];
		tiles[row1][col1] = tiles[row2][col2];
		tiles[row2][col2] = temp;
		nMoves++;
		countCorrectTiles();
	
		// Als de tegels gewisseld zijn worden de observers op de hoogte gebracht zodat deze de nieuwe state van het model kunnen weergeven
		setChanged();
		notifyObservers();
		
		// Als de puzzle is opgelost na de 'wissel' komt er een geluid en pop-up
		if (isSolved()) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "You solved the puzzle!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	// Telt het aantal correcte tegels
	private void countCorrectTiles() {
		nCorrectTiles = 0;
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				
				if (tiles[row][col] == correctTiles[row][col]) {
					nCorrectTiles++;					
				}else
					continue;				
			}
		}
	}
	
	// Kijkt of de puzzel is opgelost > komen de waardes in de huidige tegels overeen met de gewenste waarde
	public boolean isSolved() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				
				if (tiles[row][col] == correctTiles[row][col]) {
					continue;
				}else return false;
			}
		}return true;
	}
	
		

	// Simpele initialisatie om te testen, zie comment bovenaan
	// Maakt een puzzle met slechts 1 zet om op te lossen, zodat de werking van isSolved etc makkelijk getest kan worden
	@SuppressWarnings("unused")
	private void testInit() {
		tiles = new int[][]{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,-1,15}};
		
		correctTiles = new int[][]{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,-1}};
			
		countCorrectTiles();
	}	
	
}
