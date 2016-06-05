import java.awt.BorderLayout;
import java.awt.GridLayout;
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
	String [] numberCards = { "6" , "8" , "10" , "12" , "14" , "16" , "18" , "20" };
	String [] switchDeck = { "Animals" , "Plants" , "Traditional" , "Food" };
	String [] cardBack = { "Classic" , "Stars" , "Flowers" };
	String input = null;
	Potato matching = new Potato();
	Butter but = new Butter();
	int numCards = 6;
	int i;
	static JButton button;
	JButton[] cards = new JButton[numCards];
	JButton[] cards2 = cards;
	ArrayDeque<ImageIcon> pictures = new ArrayDeque<ImageIcon>(numCards);
	
	public Bubbles() {
		super();

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		this.setLayout(new BorderLayout());
		this.setName("JMenuFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(matching, BorderLayout.CENTER);
		
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
		
		//creating the buttons
		for( i = 0; i < cards.length; i++) {
        	button = new JButton( "Card " + i );
        	
        	// so, I'm not sure if this will work or not, but maybe we just want all of the cards
        	// to have the card actionCommand and then we need to figure out how to just have two
        	// buttons activated without super sadness
        	// actually, it's probably better if we can find a magical way to pass the int into the switch...
        	button.setActionCommand( "Card" );     //+ i );
        	button.addActionListener( this );
        	matching.add( button );
        }
		
		this.setJMenuBar(menuBar);
		this.setSize(600, 600);
		this.setVisible(true);
		
		
	}

	/**
	 * 
	 */
	public void setButtons( ArrayDeque<ImageIcon> pictures ) {
		Random r = new Random();
		for( int w = 0; w < numCards; w++ ) {
			int rnd = r.nextInt(numCards);
			// this is causing a NullPointerException and causing sadness. Thoughts?
			// I think it's because I'm not doing the copy array part right, but I'm not sure
			cards[rnd].setIcon(pictures.getFirst());
			cards2[rnd].remove(rnd);
		}
	}
	
	/**
	 *
	 */
	public void setBack( ImageIcon[] images ) {
		// biscuits, I forgot that we don't have pictures for the back yet
		switch(){
		case "":
		}
	}
	
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "Switch Deck":
			input = (String) JOptionPane.showInputDialog(null, "Pick which deck you would like to play with..",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, switchDeck, switchDeck[0]);
			pictures = but.makeArray(input, numCards);
			setButtons(pictures);
			break; //break for "switch deck" block
		case "Card Back":
			input = (String) JOptionPane.showInputDialog(null, "Pick which card back you would like to use..",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, cardBack, cardBack[0]);
			break; //break for "card back" block	
		case "Number":
			input = (String) JOptionPane.showInputDialog(null, "How many cards you would you like to play with?",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, numberCards,numberCards[0]);
			numCards = Integer.parseInt(input);
			break; //break for "number" block
		case "Card":
			
		}
	}

}