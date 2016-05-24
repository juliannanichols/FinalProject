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
		JMenu subMenu;
		
		menuBar = new JMenuBar();

		menu = new JMenu(""); // title
		menuItem = new JMenuItem(""); // menu item
		menuItem.setActionCommand("");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
	}

}
