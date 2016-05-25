import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author Julianna Nichols
 * @author Isabelle Schroeder
 */
public class Bubbles extends JFrame implements ActionListener, Serializable {

	private static final long serialVersionUID = 1L;
	String input = null;
	String [] switchDeck = { "Animals" , "Plants" , "Letters" , "Colors" };
	String [] cardBack = { "Flowers" , "Stars" };
	int [] numberCards = { 6 , 8 , 10 , 12 , 14 , 16 , 18 , 20}; 
	int numCards = 6;
	
	public Bubbles() {
		super();

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Options"); // title
		menuItem = new JMenuItem("Switch Deck"); // menu item
		menuItem.setActionCommand("Switch Deck");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Change Card Back"); // menu item
		menuItem.setActionCommand("Card Back");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Change Number of Cards"); // menu item
		menuItem.setActionCommand("Number");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		menuBar.add(Box.createHorizontalGlue()); //putting help on the far right
		
		menu = new JMenu("Help");
		menuItem = new JMenuItem("About");
		menuItem.setActionCommand("About");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		this.setJMenuBar(menuBar);
		this.setSize(600, 600);
		this.setVisible(true);
		
	}
	
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "Switch Deck":
			input = (String) JOptionPane.showInputDialog(null, "Pick which deck you would like to play with..",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, switchDeck, switchDeck[1]);
			switch (input) {
			case "Animals":
				//assign the deck, call on the method that randomizes
				break;
			case "Plants":

				break;
			case "Letters":

				break;
			case "Colors":

				break;
			}
			break;
		case "Card Back":
			input = (String) JOptionPane.showInputDialog(null, "Pick which card back you would like to use..",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, cardBack, cardBack[1]);
			switch (input) {
			case "":
				//setting variable equal 
				break;
			case "":
				
				break;
			case "";
				break;
			}
			break;
		case "Number":
			input = (String) JOptionPane.showInputDialog(null, "How many cards you would you like to play with?",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, numberCards, numberCards[1]);
			break;
		}
	}

}