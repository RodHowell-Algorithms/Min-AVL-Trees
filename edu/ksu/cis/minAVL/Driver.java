// File: Driver.java
// A demo to display minimum-sized AVL Trees of a given height.

package edu.ksu.cis.minAVL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import edu.ksu.cis.viewer.TreeFrame;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A demo to display minimum-sized AVL Trees of a given height.
 * The contents of the nodes are consecutive integers beginning with 0.
 */
public class Driver extends JPanel {

  /**
   * The text field in which the height of the tree is given.
   */
  JTextField height = new JTextField(5);

  /**
   * Used for consistency in serialization.
   */
  private static final long serialVersionUID = 1L;

  /** Constructs a new Driver applet.
   */
  public Driver() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
      // This shouldn't happen
      e.printStackTrace();
    }
    setLayout(new FlowLayout());
    add(new JLabel("Enter Height: "));
    height.addActionListener(new TextEntryListener(this));
    add(height);
  }

  /**
   * Starts the program as an application.
   */
  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setContentPane(new Driver());
    f.addWindowListener(new Terminator());
    f.setTitle("Min AVL Tree");
    f.pack();
    f.setVisible(true);
  }

  /**
   * Returns the height provided by the user.
   * @throws NumberFormatException if the height is not a valid integer.
   */
  public int getTreeHeight() throws NumberFormatException {
    return Integer.parseInt(height.getText());
  }
}

/**
 * The event handler for the height field.
 */
class TextEntryListener implements ActionListener {

  /**
   * The driver applet.
   */
  private Driver theDriver;

  /**
   * Constructs a new TextEntryListener.
   */
  public TextEntryListener(Driver d) {
    theDriver = d;
  }

  /**
   * Handles the event.
   */
  public void actionPerformed(ActionEvent e) {
    try {
      int h = theDriver.getTreeHeight();
      if (h < 0) throw new NumberFormatException();
      JFrame f = new TreeFrame(new MinAVLTree(h, 0), h,
			       new Font("Monospaced", Font.BOLD, 12));
      f.setTitle("Height = " + h);
      f.setVisible(true);
    }
    catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(theDriver, 
				    "Please enter a nonnegative integer.",
				    "Invalid input",
				    JOptionPane.WARNING_MESSAGE);
    }
  }
}

/**
 * The event handler for closing the driver frame.
 */
class Terminator extends WindowAdapter {

  /**
   * Handles the event by terminating the program.
   */
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }
}
