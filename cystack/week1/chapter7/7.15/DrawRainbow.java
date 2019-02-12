// DrawRainbow.java
// Demonstrates using colors in an array by drawing a rainbow

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawRainbow extends JPanel {
  // Define 2 colors
  private final static Color VIOLET = new Color(128, 0, 128);
  private final static Color INDIGO = new Color(75, 0, 130);

  // Colors to use in the rainbow, starting from the innermost
  // The two white entries result in an empty arc in the center
  private Color[] colors = {
    Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
    Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED
  };

  // Constructor
  public DrawRainbow() {
    // Set background color to white
    setBackground(Color.WHITE);
  }

  // Draws a rainbow using concentric arcs
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Radius of an arc
    int radius = 20;

    // Draw the rainbow near the bottom-center
    int centerX = getWidth() / 2;
    int centerY = getHeight() - 10;

    // Draws filled arcs starting with the outermost
    for (int i = colors.length; i > 0; i--) {
      // Set the color for the current arc
      g.setColor(colors[i - 1]);

      // Fill the arc from 0 to 180 degrees
      g.fillArc(
        centerX - i * radius, // top-left corner X
        centerY - i * radius, // top-left cornet Y
        i * radius * 2,       // width
        i * radius * 2,       // height
        0,                    // starting angle
        180                   // sweep
      );
    }
  }
}
