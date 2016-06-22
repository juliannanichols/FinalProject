import java.util.ArrayDeque;

import javax.swing.*;

/**
 * 
 * @author Julianna Nichols
 * @author Isabelle Schroeder
 */
public class Jelly {
	
	static boolean visibility = false;
	
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	String input = null; // so the user can have options
    	Butter but = new Butter();
       	int numCards = 8; // 20 because that is the max number of cards
    	Bubbles bubble = new Bubbles();
    	String [] switchDeck = { "Animals" , "Plants" , "Traditional" }; // deck options
    	ArrayDeque<ImageIcon> pictures = new ArrayDeque<ImageIcon>(numCards); // deque of images!
    	
//      Bubbles myFrame = new Bubbles();
//      myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //so it fills whole screen
    	
        input = (String) JOptionPane.showInputDialog(null, "Pick which deck you would like to play with..",
				"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, switchDeck, switchDeck[0]);
		pictures = but.makeArray(input, numCards);
		// this is what's actually causing the NullPointer to be thrown, but I don't know why...
		// I checked, and pictures is not empty, so setButtons should be receiving the arrayDeque
		bubble.setButtons(pictures);
		bubble.setBack("Classic");
    }
}
