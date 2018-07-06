import java.awt.Color;
import java.awt.Graphics;

public class Ball {
  private int radius;
  private int speed;
  private int x;
  private int y;
  private int angle;

  // Constructor
  public Ball(int r, int s, int positionX, int positionY, int a) {
    radius = r;
    speed = s;
    x = positionX;
    y = positionY;
    angle = a;
  }

  // Check if colliding with other ball
  public boolean isCollideWithBall(Ball b) {
    int diffX = Math.abs(x - b.x);
    int diffY = Math.abs(y - b.y);
    double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    return distance <= (radius + b.radius);
  }

  // Check if ball still in frame
  public boolean inFrame(int width, int height) {
    int r = radius;
    return (x - r) >= 0
      && (y - r) >= 0
      && (x + r) <= width
      && (y + r) <= height;
  }

  // Check if colliding with wall
  public boolean isCollideWithWall(int width, int height) {
    int r = radius;
    return (x - r) <= 0
      || (y - r) <= 0
      || (x + r) >= width
      || (y + r) >= height;
  }

  // Update position
  public void nextFrame() {
    if (isCollideWithWall()) {
      angle += 180;
      if (angle >= 360) {
        angle -= 360;
      }
    }

    double radians = Math.toRadians(angle);
    double sin = Math.sin(radians);
    double cos = Math.cos(radians);
    x += speed * cos;
    y -= speed * sin;
  }

  // Draw a ball
  public void draw(Graphics g) {
    int cornerX = x - radius;
    int cornerY = y - radius;

    if (cornerX < 0) cornerX = 0;
    if (cornerY < 0) cornerY = 0;

    g.setColor(Color.BLACK);
    g.fillOval(cornerX, cornerY, radius * 2, radius * 2);
  }
}
