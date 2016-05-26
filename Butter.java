import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// this is for the switch statement and the methods for changing cards..like making them blank

/**
 * 
 * @author Julianna Nichols
 * @author Isabelle Schroeder
 */
public class Butter implements ActionListener{
	
	Bubbles bub = new Bubbles();

	/**
	 * 
	 * @param name
	 */
	public void setCards( String name ){
		
		name = bub.input;
		
		switch(name){
		case "":
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
	public void actionPerformed(ActionEvent arg0) {
		// possibly do while loop?	
	}
}
