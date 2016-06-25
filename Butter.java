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
	
	//keep track of the random numbers already picked
	ArrayList<Integer> temp = new ArrayList<Integer>();
	Random r = new Random();

	/**
	 * This method puts all the pictures into each
	 * corresponding array
	 */
	public ArrayDeque<ImageIcon> makeArray(String name, int numCard) {
		
		ArrayDeque<ImageIcon> pictures = new ArrayDeque<ImageIcon>(numCard);
		ArrayDeque<ImageIcon> otherPictures = pictures.clone();
		
		switch(name){
		case "Animals":
			for( int i = 0; i < numCard/2; i++){
				// May work, maybe not. The 9 is there so that the array will pick from 0-9 hopefully. 
				// Thanks stackOverflow :D
				int rnd = new Random().nextInt(9);
				
				do {
					rnd = r.nextInt(numCard);
					
					} while(temp.contains(rnd));
					
					temp.add(rnd);
				
				otherPictures.add( new ImageIcon( "a" + rnd + ".jpg" ) );
				
				// Should prevent repeat pictures!
				if( pictures.contains( new ImageIcon( "a" + rnd + ".jpg" )) ){
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
				int rnd = new Random().nextInt(9);
				
				do {
					rnd = r.nextInt(numCard);
					
					} while(temp.contains(rnd));
					
					temp.add(rnd);
					
				otherPictures.add( new ImageIcon( "p" + rnd + ".jpg" ) );
				
				if( pictures.contains( new ImageIcon( "p" + rnd + ".jpg" )) ){
					i--;
				} else {
					pictures.add( otherPictures.getFirst() );
					pictures.add( otherPictures.poll() );
				}
	        }
			break;
		
		case "Traditional": // see Animals for cool little commenty things
			for( int i = 0; i < numCard/2; i++){
				int rnd = new Random().nextInt(9);
				
				do {
					rnd = r.nextInt(numCard);
					
					} while(temp.contains(rnd));
					
					temp.add(rnd);
				
				// the traditional pictures are png files, while the plant and animal are jpg files
				otherPictures.add( new ImageIcon( "t" + rnd + ".png" ) );
				
				if( pictures.contains( new ImageIcon( "t" + rnd + ".png" )) ){
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
