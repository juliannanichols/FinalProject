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
        
        button = new JButton( "Rectangle" );
        button.setActionCommand( "rectangle" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Circle" );
        button.setActionCommand( "circle" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Line" );
        button.setActionCommand( "line" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Word Box" );
        button.setActionCommand( "string" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Star" );
        button.setActionCommand( "star" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Arc" );
        button.setActionCommand( "arc" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "Move" );
        button.setActionCommand( "move" );
        button.addActionListener( this );
        matchingPane.add( button );
        
        button = new JButton( "fake button" );
        //button.setActionCommand( "move" );
        //button.addActionListener( this );
        matchingPane.add( button );
       
        
        this.add( matchingPane, BorderLayout.WEST );
        
        this.setVisible( true );
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}