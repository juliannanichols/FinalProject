import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Potato extends JPanel implements ActionListener, Serializable {

	private static final long serialVersionUID = 1L;
	JPanel matchingPane = new JPanel(); 
	Bubbles bubble = new Bubbles();
	JButton[] cards = new JButton[bubble.numCards];
	
	public Potato( Bubbles bub ) {
		super();
		
		bubble = bub;
		
		this.setSize( 200, 1000 );
        this.setLayout( new GridLayout( 2, 6 ) );
        this.setBorder( BorderFactory.createEtchedBorder() ); // may take this out
        JButton button;
        
        for( int i = 0; i < cards.length; i++){
        	button = new JButton( "Card" + i );
        	button.setActionCommand( "card" + i );
        	button.addActionListener( this );
        	matchingPane.add( button );
        }
        
        this.add( matchingPane, BorderLayout.WEST );
 
        this.setVisible( true );
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		//for( int i = 0; ) need array of 
	}
	
}