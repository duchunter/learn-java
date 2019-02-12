// ShapesTest.java - section 5.10
// Test application that displays class Shapes

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapesTest {
  public static void main(String[] args) {
    // Get user choice
    String input = JOptionPane.showInputDialog(
      "Enter 1 to draw rectangles\n"
      + "Enter 2 to draw ovals"
    );

    // Parse choice to int
    int choice = Integer.parseInt(input);

    // Create new panel
    Shapes panel = new Shapes(choice);

    // Create window to hold the panel
    JFrame app = new JFrame();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.add(panel);
    app.setSize(300, 300);
    app.setVisible(true);
  }
}
