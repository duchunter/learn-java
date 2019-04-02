import java.awt.Color;
import java.awt.Graphics;

public abstract class Component {
  // Color constants
  public static final Color BLUE = new Color(173, 216, 230);
  public static final Color GREEN = new Color(0, 128, 0);
  public static final Color ORANGE = new Color(255, 165, 0);
  public static final Color RED = new Color(221, 20, 60);

  // Attributes
  protected int x;
  protected int y;
  protected Color color;

  // Animation attributes
  protected int nextX;
  protected int nextY;
  protected int speedX;
  protected int speedY;

  // Constructor
  public Component(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  // Set color
  public void setColor(Color color) {
    this.color = color;
  }

  // Set next destination and speed
  public void setNext(int x, int y, int frames) {
    nextX = x;
    int deltaX = x - this.x;
    if (deltaX != 0) {
      speedX = deltaX / frames;
      if (speedX == 0) {
        speedX = 1;
      }
    } else {
      speedX = 0;
    }

    nextY = y;
    int deltaY = y - this.y;
    if (deltaY != 0) {
      speedY = deltaY / frames;
      if (speedY == 0) {
        speedY = 1;
      }
    } else {
      speedY = 0;
    }
  }

  // Update position
  public void move() {
    x += speedX;
    y += speedY;
    if (x >= nextX) x = nextX;
    if (y >= nextY) y = nextY;
  }

  // Draw component
  abstract void draw(Graphics g);
}
