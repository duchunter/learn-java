// DrawPanel.java
// Program that uses class MyLine to draw random lines

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
  private Random randomNumbers = new Random();
  private MyLine[] lines;

  // Constructor
  public DrawPanel() {
    setBackground(Color.WHITE);
    lines = new MyLine[5 + randomNumbers.nextInt(5)];

    // Create lines
    for (int count = 0; count < lines.length; count++) {
      // Generate random coordinates
      int x1 = randomNumbers.nextInt(300);
      int y1 = randomNumbers.nextInt(300);
      int x2 = randomNumbers.nextInt(300);
      int y2 = randomNumbers.nextInt(300);

      // Generate a random color
      int r = randomNumbers.nextInt(256);
      int g = randomNumbers.nextInt(256);
      int b = randomNumbers.nextInt(256);
      Color color = new Color(r, g, b);

      // Add the line to the list of lines to be displayed
      lines[count] = new MyLine(x1, y1, x2, y2, color);
    }
  }

  // Draw panel
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the lines
    for (MyLine line : lines) {
      line.draw(g);
    }
  }
}
