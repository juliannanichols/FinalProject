import java.awt.event.*;
import java.util.*; //needed to use Random
import javax.swing.*;
import com.sun.prism.*; //needed to use Image

// this is for the switch statement and the methods for changing cards..like making them blank

/**
 * 
 * @author Julianna Nichols
 * @author Isabelle Schroeder
 */
public class Butter implements ActionListener {
	
	//Bubbles bub = new Bubbles();
	ImageIcon[] traditional = new ImageIcon[10];
	ImageIcon[] animal = new ImageIcon[10];
	ImageIcon[] plant = new ImageIcon[10];
	
	/**
	 * This method puts all the pictures into each
	 * corresponding array
	 */
	public void makeArray() {
		
		for (int i = 0; i < traditional.length; i++ ) {
			traditional[i] = new ImageIcon("t" + i + ".png");
        }
		
		for (int i = 0; i < animal.length; i++ ) {
			animal[i] = new ImageIcon("a" + i + ".png");
        }
		
		for (int i = 0; i < plant.length; i++ ) {
			plant[i] = new ImageIcon("p" + i + ".png");
        }
		
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setCards( String name, int numCards ){
		
		switch(name){
		case "Animals":
			for(int i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(animal.length);
				
				//dq
				// remove images from the list
				//call random on copy of array list
				
				// random for list of cards and for buttons
				
				
			}
			break;
		case "Plants":
		}
	}
	
	/**
	 * 
	 */
	public void setBack(){
	
	}
	
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		// possibly do while loop?	
	}
}
