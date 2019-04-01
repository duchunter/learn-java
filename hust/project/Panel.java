import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {
  // Background color
  private static final Color BACKGROUND = Color.WHITE;

  // Draw panel
  public void paintComponent(Graphics g) {
    setBackground(BACKGROUND);
    super.paintComponent(g);
    Column col1 = new Column(10, 20, 10);
    Column col2 = new Column(40, 20, 30);
    col1.moveVertical(1);
    col1.draw(g);
    col2.draw(g);
  }
}
