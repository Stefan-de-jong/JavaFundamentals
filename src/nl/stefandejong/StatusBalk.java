package nl.stefandejong;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBalk extends JPanel{
	
	private JLabel label1;
	private JLabel label2;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StatusBalk() {
		label1 = new JLabel("Label 1 ...");
		label2 = new JLabel("Label 2 ...");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		setLayout(new GridLayout(1,2));
		add(label1);
		add(label2);
	}

	
}
