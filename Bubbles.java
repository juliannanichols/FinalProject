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
	
	// card amount options
	static String [] numberCards = { "6" , "8" , "10" , "12" , "14" , "16" , "18" , "20" };
	
	// deck options
	String [] switchDeck = { "Animals" , "Plants" , "Traditional" };
	
	// card back options
	String [] cardBack = { "Classic" , "Stars" , "Flowers" };
	JButton[] cards = new JButton[numCards];
	
	// deque of images!
	ArrayDeque<ImageIcon> pictures = new ArrayDeque<ImageIcon>(numCards); 
	
	// so the card can flip back and forth
	ArrayList<ImageIcon> arrayII;
	
	// so the user can have options
	//(kind and number of cards they want to play with, what card back they want to use)
	String input = null;
	
	// for potato things. Mostly adding buttons to the JPanel in this JFrame
	Potato matching = new Potato();
	
	// so we can call methods from butter
	Butter but = new Butter();
	static int numCards = 12;
	//JButton button;
	
	//temporary image icon
	ImageIcon tempII;
	
	// card back
	ImageIcon back;

	ImageIcon pic1 = null;
	ImageIcon pic2;
	
	//I used 20 because the max number card we can have is 19
	//It's my version of null...probably not the best way to
	//do this but you know.........
	int card1 = 20;
	int card2;
	
	//
	int dog;
	Random r = new Random();
	
	// used to make sure pictures are associated with the correct button
	ImageIcon[] holding = new ImageIcon[numCards];
	
	public Bubbles() {
		super();

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		this.setLayout(new BorderLayout());
		this.setName("JMenuFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

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
		for( int i = 0; i < numCards; i++) {
			
			cards[i] = new JButton( "" );
			
			cards[i].setActionCommand( "Card " + i );
        	cards[i].addActionListener( this );
        	matching.add( cards[i] );
        }
		
		this.setJMenuBar(menuBar);
		this.setSize(600, 600);
		this.setVisible(true); // setting the frame visible
		
	}

	/**
	 * Set the pictures for the buttons!
	 * The pictures are set to a random button.
	 */
	public void setButtons( ArrayDeque<ImageIcon> pictures ) {
		/*
		 *  this array keeps track of what "cards" (random numbers)
		 *  have been picked already
		 */
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int rnd;
		for( int w = 0; w < numCards; w++ ) {
			do {
			rnd = r.nextInt(numCards);

			} while(temp.contains(rnd));
			
			// getting first picture
			tempII = pictures.poll();
			
			// setting the random card to that picture
			// cards[rnd].setIcon(tempII);
			
			// putting the picture in the correct position
			// if rnd = 4, picture is put at the 4th position
			holding[rnd] = tempII;
			 
			temp.add(rnd);
			}
		// convert from array to arrayList
		arrayII = new ArrayList<ImageIcon>(Arrays.asList(holding));
		System.out.print("arrayII = " + arrayII);
	}
	
	/**
	 * This is for setting the back of the "cards".
	 */
	public void setBack( String s ) {
		switch(s){
		case "Classic":
			back = new ImageIcon("b2.jpg");
			for( int w = 0; w < numCards; w++ ){
				cards[w].setIcon( new ImageIcon("b2.jpg") );
			}
			break;
		case "Stars":
			back = new ImageIcon("b1.jpg");
			for( int w = 0; w < numCards; w++ ){
				cards[w].setIcon( new ImageIcon("b1.jpg") );
			}
			break;
		case "Flowers":
			back = new ImageIcon("b0.jpg");
			for( int w = 0; w < numCards; w++ ){
				cards[w].setIcon( new ImageIcon("b0.jpg") );
			}
			break;
		}
	}
	
	/**
	 * Required and super useful actionPerformed method!
	 */
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "Switch Deck":
			input = (String) JOptionPane.showInputDialog(null, "Pick which deck you would like to play with..",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, switchDeck, switchDeck[0]);
			pictures = but.makeArray(input, numCards);
			// this is what's actually causing the NullPointer to be thrown, but I don't know why...
			// I checked, and pictures is not empty, so setButtons should be receiving the arrayDeque
			setButtons(pictures);
			break; //break for "switch deck" block
		case "Card Back":
			input = (String) JOptionPane.showInputDialog(null, "Pick which card back you would like to use..",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, cardBack, cardBack[0]);
			repaint();
			break; //break for "card back" block	
		case "Number":
			input = (String) JOptionPane.showInputDialog(null, "How many cards you would you like to play with?",
					"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, numberCards,numberCards[0]);
			numCards = Integer.parseInt(input); // parsing the string to an int
			break; //break for "number" block
		default:
			//this is because some only have one digit and others have two
			if(e.getActionCommand().length() == 6) {
				//converting the string to an int
				dog = Integer.parseInt(e.getActionCommand().substring(e.getActionCommand().length() - 1));
			} else {
				//converting the string to an int
				dog = Integer.parseInt(e.getActionCommand().substring(5, 7));
			}
			whatToDo(dog);
			break;
		}
	}
	
	/**
	 * When a card is clicked, this tells it what to do
	 * ie: if the card back is face up then it will show the picture
	 * and vice versa
	 */
	public void whatToDo(int cat) {
	
		if(cards[cat].getIcon() == back) {
			// enters if the card's back is shown
			 
			/*
			 * setting the temporary variable to the picture
			 * that has been assigned to that card 
			 */
			tempII = arrayII.get(cat);
			
			// setting the card 
			cards[cat].setIcon(tempII);
			
			if(pic1 == null && card1 == 20) {
				// enters if this is the first picture picked
				// since we only want two cards face up at any given time 
				pic1 = tempII;
				card1 = cat; 
			} else {
				// enters if there is already a card picked
				pic2 = tempII;
				card2 = cat;
				compare(pic1, pic2, card1, card2);
			}
			
		} else {
			/*
			 * enters if the picture is shown
			 */
			cards[cat].setIcon(back);
		}
	}
	
	/**
	 * Compare two cards
	 */
	public void compare(ImageIcon icon1, ImageIcon icon2, int c1, int c2) {
		if(icon1 == icon2) {
			// if they are the same
			cards[c1].setEnabled(false);
			cards[c2].setEnabled(false);
		} else {
			// if they are different
			
			
			//want to use this but this isn't the right place
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			
			cards[c1].setIcon(back);
			cards[c2].setIcon(back);
		}
		
		pic1 = null;
		card1 = 20;
	}
}