import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Potato extends JPanel implements ActionListener, Serializable {

	private static final long serialVersionUID = 1L;
	JPanel matchingPane = new JPanel(); 
	Jelly jelly = new Jelly();
	
	public Potato( Jelly jel ) {
		super();
		
		jelly = jel;
		
		this.setSize( 200, 1000 );
        this.setLayout( new GridLayout( 2, 6 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        JButton button;
        
        button = new JButton( "Card1" );
        button.setActionCommand( "card1" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Card2" );
        button.setActionCommand( "card2" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Card3" );
        button.setActionCommand( "card3" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Card4" );
        button.setActionCommand( "card4" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Card5" );
        button.setActionCommand( "card5" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Card6" );
        button.setActionCommand( "card6" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Card7" );
        button.setActionCommand( "card7" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Card8" );
        button.setActionCommand( "card8" );
        button.addActionListener( this );
        matchingPane.add( button );
       
        
        this.add( matchingPane, BorderLayout.WEST );
 
        this.setVisible( true );
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		//this needs code
	}
	
}