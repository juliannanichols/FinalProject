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
		ArrayDeque<ImageIcon> otherPictures = new ArrayDeque<ImageIcon>(10);
		int i = 0;
		
		switch(name){
		case "Animals":
			do{ 
				otherPictures.add( new ImageIcon( "a" + i + ".jpg"));
				i++;
			} while( i <= 10 );
			
			for( i = 0; i < numCards/2; i++){
				// May work, maybe not. The 9 is there so that the array will pick from 0-9 hopefully. 
				// Thanks stackOverflow :D
				int rnd = new Random().nextInt(9);
				
				
				//make array with all of the pictures in, set new array to have numCards length
				//get random picture from original array and set to new array
				//delete from original array
				
				pictures.add( new ImageIcon("a" + rnd + ".jpg")); // adds image to the end of the deque
				otherPictures.remove(new ImageIcon("a" + rnd + ".jpg")); // should remove the image from the deque
	        }
			
				//dq
				// remove images from the list
				//call random on copy of array list
				
				// random for list of cards and for buttons
			break;
		case "Plants":
			for( i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(9);
				pictures.add( new ImageIcon("p" + rnd + ".jpg"));
				otherPictures.remove(new ImageIcon("p" + rnd + ".jpg"));
	        }
			break;
		
		case "Traditional":
			for( i = 0; i < numCards/2; i++ ) {
				int rnd = new Random().nextInt(9);
				pictures.add( new ImageIcon("t" + rnd + ".png"));
				otherPictures.remove(new ImageIcon("t" + rnd + ".png"));
			}
			break;
		}
		return pictures;
	}

}
