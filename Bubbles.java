import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * 
 * @author Julianna Nichols
 * @author Isabelle Schroeder
 */
public class Bubbles extends JFrame implements ActionListener, Serializable {

	private static final long serialVersionUID = 1L;
	
	public Bubbles() {
		super();

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		//JMenu subMenu;
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Options"); // title
		menuItem = new JMenuItem("Switch Deck"); // menu item
		menuItem.setActionCommand("Switch Deck");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		menuBar.add(Box.createHorizontalGlue()); //putting help on the far right
		
		menu = new JMenu("Help");
		menuItem = new JMenuItem("About");
		menuItem.setActionCommand("About");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		this.setJMenuBar(menuBar);
		this.setSize(600, 600);
		this.setVisible(true);
		
	}
	
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
	}

}