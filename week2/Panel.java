import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Panel extends JPanel {
  private Random randomNumbers = new Random();
  private static ArrayList< Ball > ballList = new ArrayList< Ball >();
  public static int screenWidth = 500;
  public static int screenHeight = 500;

  // Constructor
  public Panel(int i) {
    setBackground(Color.WHITE);
    if (ballList.size() == 0) {
      init(i);
    } else {
      update();
    }
  }

  // Update
  public void update() {
    for (Ball ball : ballList) {
      ball.nextFrame();
    }
  }

  // Init
  public void init(int quantity) {
    while (ballList.size() != quantity) {
      // Generate random coordinates
      int x = randomNumbers.nextInt(300);
      int y = randomNumbers.nextInt(300);
      int radius = 20 + randomNumbers.nextInt(100);

      // Add the ball to the list of balls to be displayed
      Ball newBall = new Ball(radius, 15, x, y, 0);

      if (newBall.inFrame(getWidth(), getHeight())) {
        continue;
      }

      boolean isFit = true;
      for (Ball ball : ballList) {
        if (newBall.isCollideWithBall(ball)) {
          System.out.println("Collide");
          isFit = false;
        }
      }

      if (isFit) {
        ballList.add(newBall);
      }
    }
  }

  // Draw panel
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the lines
    for (Ball item : ballList) {
      item.draw(g);
    }
  }
}
