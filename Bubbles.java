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
	int numCards = 6; // 6 is default
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
			
			/*
			this was just a check
			System.out.println("array II " + arrayII);
			System.out.println("pictures " + pictures);
			*/
			
			//tempII = pictures.poll();
			//cards[rnd].setIcon(tempII);
			
			
			arrayII.add(pictures.poll());
			temp.add(rnd);
			
			
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
		System.out.println("in compare method");
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
			 * 
			 * not the most efficient but it works!!!
			 */
			if(cards[0].getIcon() == tempCB) {
				tempII = arrayII.get(0);
				cards[0].setIcon(tempII);
				
				if(pic1 == null && pickedCard1 == 20) {
					pic1 = tempII;
					pickedCard1 = 0; 
				} else {
					pic2 = tempII;
					pickedCard2 = 0;
					compare(pic1, pic2, pickedCard1, pickedCard2);
				}
				
			} else {
				cards[0].setIcon(tempCB);
			}
			
			break;
		case "Card 1":
			if(cards[1].getIcon() == tempCB) {
				tempII = arrayII.get(1);
				cards[1].setIcon(tempII);
				
				if(pic1 == null && pickedCard1 == 20) {
					pic1 = tempII;
					pickedCard1 = 1; 
				} else {
					pic2 = tempII;
					pickedCard2 = 1;
					compare(pic1, pic2, pickedCard1, pickedCard2);
				}
				
			} else {
				cards[1].setIcon(tempCB);
			}
			
			break;
		case "Card 2":
			if(cards[2].getIcon() == tempCB) {
				tempII = arrayII.get(2);
				cards[2].setIcon(tempII);
				
				if(pic1 == null && pickedCard1 == 20) {
					pic1 = tempII;
					pickedCard1 = 2; 
				} else {
					pic2 = tempII;
					pickedCard2 = 2;
					compare(pic1, pic2, pickedCard1, pickedCard2);
				}
				
			} else {
				cards[2].setIcon(tempCB);
			}
			break;	
		case "Card 3":
			if(cards[3].getIcon() == tempCB) {
				tempII = arrayII.get(3);
				cards[3].setIcon(tempII);
				
				if(pic1 == null && pickedCard1 == 20) {
					pic1 = tempII;
					pickedCard1 = 3; 
				} else {
					pic2 = tempII;
					pickedCard2 = 3;
					compare(pic1, pic2, pickedCard1, pickedCard2);
				}
				
			} else {
				cards[3].setIcon(tempCB);
			}
			break;
		case "Card 4":
			if(cards[4].getIcon() == tempCB) {
				tempII = arrayII.get(4);
				cards[4].setIcon(tempII);
				
				if(pic1 == null && pickedCard1 == 20) {
					pic1 = tempII;
					pickedCard1 = 4; 
				} else {
					pic2 = tempII;
					pickedCard2 = 4;
					compare(pic1, pic2, pickedCard1, pickedCard2);
				}
				
			} else {
				cards[4].setIcon(tempCB);
			}
			break;	
		case "Card 5":
			if(cards[5].getIcon() == tempCB) {
				tempII = arrayII.get(5);
				cards[5].setIcon(tempII);
				
				if(pic1 == null && pickedCard1 == 20) {
					pic1 = tempII;
					pickedCard1 = 5; 
				} else {
					pic2 = tempII;
					pickedCard2 = 5;
					compare(pic1, pic2, pickedCard1, pickedCard2);
				}
				
			} else {
				cards[5].setIcon(tempCB);
			}
			break;
		case "Card 6":
			break;	
		case "Card 7":
			break;
		case "Card 8":
			break;	
		case "Card 9":
			break;
		case "Card 10":
			break;	
		case "Card 11":
			break;
		case "Card 12":
			break;	
		case "Card 13":
			break;
		case "Card 14":
			break;	
		case "Card 15":
			break;
		case "Card 16":
			break;
		case "Card 17":
			break;
		case "Card 18":
			break;	
		case "Card 19":
			break;
		}
	}

}