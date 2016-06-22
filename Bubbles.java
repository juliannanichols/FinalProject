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
	String [] numberCards = { "6" , "8" , "10" , "12" , "14" , "16" , "18" , "20" }; // card amount options
	String [] switchDeck = { "Animals" , "Plants" , "Traditional" }; // deck options
	String [] cardBack = { "Classic" , "Stars" , "Flowers" }; // card back options
	String input = null; // so the user can have options
	Potato matching = new Potato(); // for potato things. Mostly adding buttons to the JPanel in this JFrame
	Butter but = new Butter(); // so we can call methods from butter
	int numCards = 10; // 6 is default
	JButton button; // THE button
	JButton[] cards = new JButton[numCards];
	ArrayDeque<ImageIcon> pictures = new ArrayDeque<ImageIcon>(numCards); // deque of images!
	ArrayList<Integer> temp = new ArrayList<Integer>();
	Random r = new Random();
	ImageIcon tempII; //temporary image icon
	ImageIcon tempCB; //temporary card back
	ArrayList<ImageIcon> arrayII = new ArrayList<ImageIcon>(numCards);
	ImageIcon pic1 = null;
	ImageIcon pic2;
	//I used 20 because the max number card we can have is 19
	//It's my version of null...probably not the best way to
	//do this but you know.........
	int pickedCard1 = 20;
	int pickedCard2;
	ImageIcon anotherVariable;
	Object[] anotherTempArray;
	int dog;
	
	
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
			
			//cards[i] so it gets added into that array
			//can't remember at this exact moment why it helped
			//but I think it did...so ..yeah
			
			//http://www.coderanch.com/t/340584/GUI/java/create-JButton-Array
			//why I did that....
			
			//I realized that in the set buttons method it is setting to a button..
			//but we weren't relating the 'button' to the 'cards' so...then I
			//put then in the array we are adding the cards to and..
			//temporary happiness!
			
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
		int rnd;
		for( int w = 0; w < numCards; w++ ) {
			do {
			rnd = r.nextInt(numCards);

			} while(temp.contains(rnd));
			/* 
			 * this is used in the switch statement so the button 
			 * can switch pictures  
			 * 
			 * I realize it is basically just making a copy....
			 * not my original intention but my brain is fried and
			 * can't think of a way to fix it right now
			 */
			
			//tempII = pictures.poll();
			//cards[rnd].setIcon(tempII);
			
			//why wont it pick the next one..
			//it's like doing one and deleting both of that kind
			
			
			
			tempII = pictures.poll();
			cards[rnd].setIcon(tempII);
			
			arrayII.add(tempII);
			temp.add(rnd);
			
			System.out.println("rnd = " + rnd);
			System.out.println("tempII = " + tempII);
			System.out.println("pictures = " + pictures);
			}
	}
	
	/**
	 * This is for setting the back of the "cards".
	 */
	public void setBack( String s ) {
		switch(s){
		case "Classic":
			tempCB = new ImageIcon("b2.jpg");
			for( int w = 0; w < numCards; w++ ){
				cards[w].setIcon( new ImageIcon("b2.jpg") );
			}
			break;
		case "Stars":
			tempCB = new ImageIcon("b1.jpg");
			for( int w = 0; w < numCards; w++ ){
				cards[w].setIcon( new ImageIcon("b1.jpg") );
			}
			break;
		case "Flowers":
			tempCB = new ImageIcon("b0.jpg");
			for( int w = 0; w < numCards; w++ ){
				cards[w].setIcon( new ImageIcon("b0.jpg") );
			}
			break;
		}
	}
	
	/**
	 * Compare two cards
	 */
	public void compare(ImageIcon icon1, ImageIcon icon2, int c1, int c2) {
		//System.out.println("in compare method");
		if(icon1 == icon2) {
			cards[c1].setEnabled(false);
			cards[c2].setEnabled(false);
		} else {
			cards[c1].setIcon(tempCB);
			cards[c2].setIcon(tempCB);
		}
		
		pic1 = null;
		pickedCard1 = 20;
	}
	
	/**
	 * This is to try to condense code..avoid a lot of repeat code
	 */
	public void whatToDo(int cats) {
		
		/*
		 * if card 0 is clicked..
		 * this puts the randomly selected image
		 * that was assigned there (in setButtons)
		 * onto the button
		 * 
		 * now it's checking if the back is already set
		 * if it is then it will set the animal (or whatever)
		 * picture..
		 * if it isn't then the card back will be set
		 */
		if(cards[cats].getIcon() == tempCB) {
			tempII = arrayII.get(cats);
			cards[cats].setIcon(tempII);
			
			if(pic1 == null && pickedCard1 == 20) {
				pic1 = tempII;
				pickedCard1 = cats; 
			} else {
				pic2 = tempII;
				pickedCard2 = cats;
				compare(pic1, pic2, pickedCard1, pickedCard2);
			}
			
		} else {
			cards[cats].setIcon(tempCB);
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
			
			/*
			 * do we need this repaint(); ??
			 * I commented it out and it still worked the same ...? not sure 
			 */
			
			repaint();
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
			
			for( int i = 0; i < numCards; i++) {
				cards[i] = new JButton( "" );
	        	cards[i].setActionCommand( "Card" );
	        	cards[i].addActionListener( this );
	        	matching.add( cards[i] );
	        }
			repaint();
			break; //break for "number" block
		case "Card 0":
			dog = 0;
			whatToDo(dog);
			break;
		case "Card 1":
			dog = 1;
			whatToDo(dog);
			break;
		case "Card 2":
			dog = 2;
			whatToDo(dog);
			break;	
		case "Card 3":
			dog = 3;
			whatToDo(dog);
			break;
		case "Card 4":
			dog = 04;
			whatToDo(dog);
			break;	
		case "Card 5":
			dog = 5;
			whatToDo(dog);
			break;
		case "Card 6":
			dog = 6;
			whatToDo(dog);
			break;	
		case "Card 7":
			dog = 7;
			whatToDo(dog);
			break;
		case "Card 8":
			dog = 8;
			whatToDo(dog);
			break;	
		case "Card 9":
			dog = 9;
			whatToDo(dog);
			break;
		case "Card 10":
			dog = 10;
			whatToDo(dog);
			break;	
		case "Card 11":
			dog = 11;
			whatToDo(dog);
			break;
		case "Card 12":
			dog = 12;
			whatToDo(dog);
			break;	
		case "Card 13":
			dog = 13;
			whatToDo(dog);
			break;
		case "Card 14":
			dog = 14;
			whatToDo(dog);
			break;	
		case "Card 15":
			dog = 15;
			whatToDo(dog);
			break;
		case "Card 16":
			dog = 16;
			whatToDo(dog);
			break;
		case "Card 17":
			dog = 17;
			whatToDo(dog);
			break;
		case "Card 18":
			dog = 18;
			whatToDo(dog);
			break;	
		case "Card 19":
			dog = 19;
			whatToDo(dog);
			break;
		}
	}

}