import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/*
 * so this is like all commented out because bubbles and potato end
 * calling on each other and that causes a recursion error..baaaaaaaaaaaaad thing
 * so this is probably going to have to be the class for the randomizing
 */

public class Potato extends JPanel implements ActionListener, Serializable {
	
	private static final long serialVersionUID = 1L;

	public Potato() {
		this.setLayout( new GridLayout( 2, 6 ) );
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}