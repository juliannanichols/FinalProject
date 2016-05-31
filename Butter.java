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
	
	Bubbles bub = new Bubbles();
	ImageIcon[] traditional = new ImageIcon[10];
	ImageIcon[] animal = new ImageIcon[10];
	ImageIcon[] plant = new ImageIcon[10];
	ImageIcon[] food = new ImageIcon[10];
	
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
		
		for (int i = 0; i < food.length; i++ ) {
			food[i] = new ImageIcon("f" + i + ".png");
        }
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setCards( String name ){
		
		name = bub.input;
		
		switch(name){
		case "Animals":
			//not sure if ths is right at all
			//trying to get it to randomly pick
			//then assign to buttons
			for(int i = 0; i < animal.length; i++ ) {
				int rnd = new Random().nextInt(animal.length);
				
			}
			break;
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
