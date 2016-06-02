import java.util.*; //needed to use Random
import javax.swing.*;
import com.sun.prism.*; //needed to use Image

// this is for the switch statement and the methods for changing cards..like making them blank

/**
 * 
 * @author Julianna Nichols
 * @author Isabelle Schroeder
 */
public class Butter {
	
	/**
	 * This method puts all the pictures into each
	 * corresponding array
	 */
	public ImageIcon[] makeArray(String name, int numCards) {
		ImageIcon[] pictures = new ImageIcon[numCards];
		
		switch(name){
		case "Animals":
			for (int i = 0; i < numCards/2; i++ ) {
				// may work, maybe not. The 9 is there so that the
				// array will pick from 0-9 hopefully. Thanks stackOverflow
				int rnd = new Random().nextInt(9);
				pictures[i] = new ImageIcon("a" + rnd + ".png");
	        }
			
				//dq
				// remove images from the list
				//call random on copy of array list
				
				// random for list of cards and for buttons
			break;
		case "Plants":
			for (int i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(9);
				pictures[i] = new ImageIcon("p" + rnd + ".png");
	        }
			
			break;
		
		case "Traditional":
			for (int i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(9);
				pictures[i] = new ImageIcon("t" + rnd + ".png");
			}
			break;
		}
		return pictures;
	}

}
