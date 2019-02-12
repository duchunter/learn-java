// Shapes.java - section 5.10
// Demonstrates drawing different shapes.

import java.awt.Graphics;
import javax.swing.JPanel;

public class Shapes extends JPanel {
  private int choice;

  // Constructor
  public Shapes(int userChoice) {
    choice = userChoice;
  }

  // Draw a shape starting from top left corner
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < 10; i++) {
      switch (choice) {
        // Draw rectangle
        case 1:
          g.drawRect(10 + 10 * i, 10 + 10 * i, 50 + 10 * i, 50 + i * 10);
          break;

        // Draw oval
        case 2:
          g.drawOval(10 + 10 * i, 10 + 10 * i, 50 + 10 * i, 50 + i * 10);
          break;
      }
    }
  }
}
