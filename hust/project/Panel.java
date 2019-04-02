import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
  // Background color
  private static final Color BACKGROUND = Color.WHITE;
  private static int PERIOD = 1000 / 60;

  public Timer tm = new Timer(PERIOD, this);

  // Attributes
  public static Column col1 = new Column(10, 100, 10);
  public static Column col2 = new Column(40, 100, 30);

  // Init
  public void init() {
    col1.moveVertical(1, 4000 / PERIOD);
    col2.moveHorizontal(3, 4000 / PERIOD);
  }

  // Draw panel
  public void paintComponent(Graphics g) {
    setBackground(BACKGROUND);
    super.paintComponent(g);
    col1.draw(g);
    col2.draw(g);

    tm.start();
  }

  // Action
  public void actionPerformed(ActionEvent e) {
    col1.move();
    col2.move();
    repaint();
  }
}
