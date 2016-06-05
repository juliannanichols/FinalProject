import java.util.*; //needed to use Random
import javax.swing.*;
import com.sun.prism.*; //needed to use Image

// this is for the switch statement and the methods for changing cards..like making them blank

/**
 * 
 * @author Julianna Nichols
 * @author Isabelle Schroeder
 */
public class Butter extends ArrayDeque<ImageIcon>{
		
	private static final long serialVersionUID = 1L;

	/**
	 * This method puts all the pictures into each
	 * corresponding array
	 */
	public ArrayDeque<ImageIcon> makeArray(String name, int numCards) {
		
		ArrayDeque<ImageIcon> pictures = new ArrayDeque<ImageIcon>(numCards);
		ArrayDeque<ImageIcon> otherPictures = pictures.clone();
		
		switch(name){
		case "Animals":
			for (int i = 0; i < numCards/2; i++ ) {
				// May work, maybe not. The 9 is there so that the array will pick from 0-9 hopefully. 
				// Thanks stackOverflow :D
				int rnd = new Random().nextInt(9);
				pictures.add( new ImageIcon("a" + rnd + ".jpg"));
				otherPictures.remove(new ImageIcon("a" + rnd + ".jpg")); // remove the pictures from the array list here
	        }
			
				//dq
				// remove images from the list
				//call random on copy of array list
				
				// random for list of cards and for buttons
			break;
		case "Plants":
			for (int i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(9);
				pictures.add( new ImageIcon("p" + rnd + ".jpg"));
				otherPictures.remove(new ImageIcon("p" + rnd + ".jpg"));
	        }
			break;
		
		case "Traditional":
			for (int i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(9);
				pictures.add( new ImageIcon("t" + rnd + ".png"));
				otherPictures.remove(new ImageIcon("t" + rnd + ".png"));
			}
			break;
		}
		return pictures;
	}

}
