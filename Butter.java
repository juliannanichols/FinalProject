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
	
	//keep track of the random numbers already picked (both ArrayLists)
	ArrayList<Integer> tempPic = new ArrayList<Integer>();
	ArrayList<Integer> tempButton = new ArrayList<Integer>();
	Random r = new Random();

	/**
	 * This method puts all the pictures into each
	 * corresponding array
	 */
	public ArrayDeque<ImageIcon> makeArray(String name, int numCard) {
		
		ArrayDeque<ImageIcon> pictures = new ArrayDeque<ImageIcon>(numCard);
		ArrayDeque<ImageIcon> otherPictures = pictures.clone();
		int rndButton;
		int rndPic;
		
		switch(name){
		case "Animals":
			for( int i = 0; i < numCard/2; i++){
				// May work, maybe not. The 9 is there so that the array will pick from 0-9 hopefully. 
				// Thanks stackOverflow :D
				do {
					rndPic = r.nextInt(9);
				} while((rndPic > 9) & (tempPic.contains(rndPic))); 
				//okay why doesn't this do while work...like I can't see what's wrong and why it isn't making sure both are true
				//I don't want the number it chooses if it is greater than 9 or in the array (an array that is holding numbers
				//THAT HAVE ALREADY BEEN PICKED
				
				System.out.println("rndPic = " + rndPic);
				System.out.println("tempPic = " + tempPic);
				
				tempPic.add(rndPic);
									
				do {
					rndButton = r.nextInt(numCard);
					} while(tempButton.contains(rndButton));
				
					// added so we know what buttons already have a picture assigned
					tempButton.add(rndButton);
				
				otherPictures.add( new ImageIcon( "a" + rndPic + ".jpg" ) );
				
				// Should prevent repeat pictures!
				if( pictures.contains( new ImageIcon( "a" + rndPic + ".jpg" )) ){
					i--; // so there will still be the correct number of cards
				} else {
					// Adds image to the end of the deque AND removes it from otherPictures!! 
					// Use both getFirst and poll so that there will be 2 of each card!
					// How spiffy!!!! :)
					pictures.add( otherPictures.getFirst() );
					pictures.add( otherPictures.poll() );
				}
	        }
			break;
			
		case "Plants": // see Animals for cool little commenty things
			for( int i = 0; i < numCard/2; i++){
				do {
					rndPic = r.nextInt(9);
				} while(rndPic > 9 && tempPic.contains(rndPic));
				
				tempPic.add(rndPic);
				
				do {
					rndButton = r.nextInt(numCard);
					
					} while(tempButton.contains(rndButton));
					
					tempButton.add(rndButton);
					
				otherPictures.add( new ImageIcon( "p" + rndPic + ".jpg" ) );
				
				if( pictures.contains( new ImageIcon( "p" + rndPic + ".jpg" )) ){
					i--;
				} else {
					pictures.add( otherPictures.getFirst() );
					pictures.add( otherPictures.poll() );
				}
	        }
			break;
		
		case "Traditional": // see Animals for cool little commenty things
			for( int i = 0; i < numCard/2; i++){
				do {
					rndPic = r.nextInt(9);
				} while(rndPic > 9 && tempPic.contains(rndPic));
				
				tempPic.add(rndPic);
				
				do {
					rndButton = r.nextInt(numCard);
					
					} while(tempButton.contains(rndButton));
					
					tempButton.add(rndButton);
				
				// the traditional pictures are png files, while the plant and animal are jpg files
				otherPictures.add( new ImageIcon( "t" + rndPic + ".png" ) );
				
				if( pictures.contains( new ImageIcon( "t" + rndPic + ".png" )) ){
					i--;
				} else {
					pictures.add( otherPictures.getFirst() );
					pictures.add( otherPictures.poll() );
				}
			}
			break;
		}
		return pictures;
	}

}
