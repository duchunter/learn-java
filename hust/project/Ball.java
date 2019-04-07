import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
  private Random randomNumbers = new Random();
  private enum Wall { NONE, TOP, BOTTOM, LEFT, RIGHT }
  private static final int MIN_SPEED = 1;
  private static final int MAX_SPEED = 6;
  private static final int MIN_RADIUS = 20;
  private static final int MAX_RADIUS = 50;

  // Ball properties
  private final int radius;
  private int x;
  private int y;
  private int speedX;
  private int speedY;
  private Color color;
  private int newX;
  private int newY;
  private boolean collided;

  // Constructor
  public Ball() {
    // Generate random coordinates
    x = randomNumbers.nextInt(300);
    y = randomNumbers.nextInt(300);
    radius = MIN_RADIUS + randomNumbers.nextInt(MAX_RADIUS);
    speedX = MIN_SPEED + randomNumbers.nextInt(MAX_SPEED);
    speedY = MIN_SPEED + randomNumbers.nextInt(MAX_SPEED);

    // Generate random color
    int r = randomNumbers.nextInt(256);
    int g = randomNumbers.nextInt(256);
    int b = randomNumbers.nextInt(256);
    color = new Color(r, g, b);
  }

  // Create a temporary copy of the ball
  public Ball(Ball b) {
    radius = b.radius;
    speedX = b.speedX;
    speedY = b.speedY;
    x = b.x;
    y = b.y;
  }

  // Estimate the next location of the ball
  public static Ball futureBall(Ball b) {
    Ball nextBall = new Ball(b);
    nextBall.x += nextBall.speedX;
    nextBall.y += nextBall.speedY;
    return nextBall;
  }

  // Check if 2 balls collides each other
  public static boolean twoBallCollide(Ball b1, Ball b2) {
    int diffX = Math.abs(b1.x - b2.x);
    int diffY = Math.abs(b1.y - b2.y);
    double distance = Math.sqrt(diffX * diffX + diffY * diffY);
    return distance < (b1.radius + b2.radius);
  }

  // Check if this ball is about to collide with other ball
  public boolean willCollideWithBall(Ball b) {
    Ball b1 = futureBall(this);
    Ball b2 = futureBall(b);
    return twoBallCollide(this, b) && twoBallCollide(b1, b2);
  }

  // Handle balls colliding
  public static void handleCollideBalls(Ball b1, Ball b2) {
    b1.newX += b2.speedX;
    b1.newY += b2.speedY;
    b2.newX += b1.speedX;
    b2.newY += b1.speedY;
    b1.collided = true;
    b2.collided = true;
  }

  // Check if ball still in frame
  public boolean inFrame(int width, int height) {
    return (x - radius) > 0
      && (y - radius) > 0
      && (x + radius) < width
      && (y + radius) < height;
  }

  // Check if ball is collided with wall
  public boolean collideWithWall(int width, int height) {
    return (x - radius) < 0
      || (y - radius) < 0
      || (x + radius) > width
      || (y + radius) > height;
  }

  // Check if ball is about to collide with wall
  public Wall willCollideWithWall(int width, int height) {
    Ball nextBall = futureBall(this);
    if (!inFrame(width, height)) {
      if ((nextBall.x - radius) < 0) return Wall.LEFT;
      if ((nextBall.y - radius) < 0) return Wall.TOP;
      if ((nextBall.x + radius) > width) return Wall.RIGHT;
      if ((nextBall.y + radius) > height) return Wall.BOTTOM;
    }

    return Wall.NONE;
  }

  // Handle wall colliding
  public void handleCollideWithWall(Wall side) {
    switch (side) {
      case TOP: case BOTTOM:
        speedY *= -1;
        newY *= -1;
        break;
      case LEFT: case RIGHT:
        speedX *= -1;
        newX *= -1;
        break;
    }
  }

  // Update movement tendency (speedX and speedY)
  public void updateMovement(Ball[] otherBalls, int width, int height) {
    // Avoid colliding with walls
    Wall side;
    while ((side = willCollideWithWall(width, height)) != Wall.NONE) {
      handleCollideWithWall(side);
    }

    // Avoid colliding with other balls
    for (Ball other : otherBalls) {
      if (willCollideWithBall(other)) {
        handleCollideBalls(this, other);
      }
    }

    if (collided) {
      speedX = newX;
      speedY = newY;
      if (speedX > MAX_SPEED || speedY > MAX_SPEED) {
        speedX /= 2;
        speedY /= 2;
      }

      newX = 0;
      newY = 0;
      collided = false;
    }
  }

  // Apply speedX and speedY to update ball location
  public void updatePosition() {
    x += speedX;
    y += speedY;
  }

  // Draw a ball
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x - radius, y - radius, radius * 2, radius * 2);
  }
}
