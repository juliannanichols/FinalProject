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
	
	/**
	 * This method puts all the pictures into each
	 * corresponding array
	 */
	public void makeArray(String name, int numCards) {
		ImageIcon[] pictures = new ImageIcon[numCards];
		
		switch(name){
		case "Animals":
			for (int i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(pictures.length);
				pictures[i] = new ImageIcon("a" + rnd + ".png");
	        }
			
				//dq
				// remove images from the list
				//call random on copy of array list
				
				// random for list of cards and for buttons
				
			break;
		case "Plants":
			for (int i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(pictures.length);
				pictures[i] = new ImageIcon("p" + i + ".png");
	        }
			
			break;
		
		case "Traditional":
			for (int i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(pictures.length);
				pictures[i] = new ImageIcon("t" + i + ".png");
			}
			break;
		}
	
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setButtons(){
		
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
