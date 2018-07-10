import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {
  // Background color
  private static final Color BACKGROUND = Color.WHITE;

  // Array that hold all balls
  private Ball[] ballList;

  // Inititalize new ball list
  public void init(int quantity) {
    ballList = new Ball[quantity];
    int i = 0;
    while (i != quantity) {
      // Create a new ball and check its validity
      Ball newBall = new Ball();

      // Make sure ball is inside the frame
      if (newBall.inFrame(getWidth(), getHeight())) {
        // Create an array of other balls
        Ball[] otherBalls = new Ball[i];
        System.arraycopy(ballList, 0, otherBalls, 0, i);

        // Make sure ball is not colliding with other balls
        boolean isFit = true;
        for (Ball other : otherBalls) {
          if (Ball.twoBallCollide(newBall, other)) {
            isFit = false;
            break;
          }
        }

        // If the new ball is fit, add to ball list
        if (isFit) {
          ballList[i] = newBall;
          i++;
        }
      }
    }
  }

  // Update panel for next frame
  public void update() {
    // Update of ball movement tendency
    for (int i = 0; i < ballList.length; i++) {
      // Create an array of other balls
      Ball[] otherBalls = new Ball[ballList.length - i - 1];
      System.arraycopy(ballList, i + 1, otherBalls, 0, otherBalls.length);

      // Perform check
      ballList[i].updateMovement(otherBalls, getWidth(), getHeight());
    }

    // Apply new position to all balls
    for (Ball ball : ballList) {
      ball.updatePosition();
    }
  }

  // Draw panel
  public void paintComponent(Graphics g) {
    setBackground(BACKGROUND);
    super.paintComponent(g);
    for (Ball ball : ballList) {
      ball.draw(g);
    }
  }
}
