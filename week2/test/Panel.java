import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Panel extends JPanel {
  private Random randomNumbers = new Random();
  private ArrayList< Ball > balls = new ArrayList< Ball >();

  // Constructor
  public Panel(int i) {
    setBackground(Color.WHITE);
    createBall(i);
  }

  // Create balls
  public void createBall(int quantity) {
    while (balls.size() != quantity) {
      // Generate random coordinates
      int x = randomNumbers.nextInt(300);
      int y = randomNumbers.nextInt(300);
      int radius = 20 + randomNumbers.nextInt(100);

      // Add the ball to the list of balls to be displayed
      Ball newBall = new Ball(radius, 0, x, y, 0);

      if (newBall.inFrame(getWidth(), getHeight())) {
        continue;
      }

      boolean isFit = true;
      for (Ball ball : balls) {
        if (newBall.isCollideWithBall(ball)) {
          System.out.println("Collide");
          isFit = false;
        }
      }

      if (isFit) {
        balls.add(newBall);
      }
    }
  }

  // Draw panel
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the lines
    for (Ball item : balls) {
      item.draw(g);
    }
  }
}
