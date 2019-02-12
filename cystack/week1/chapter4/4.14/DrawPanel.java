// DrawPanel.java
// Draw 'X' on the window

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
  public void paintComponent(Graphics g) {
    // Call paintComponent to ensure the panel displays correctly
    super.paintComponent(g);

    // Get window height and width
    int width = getWidth();
    int height = getHeight();

    // Draw 'X'
    g.drawLine(0, 0, width, height);
    g.drawLine(width, 0, 0, height);
  }
}
