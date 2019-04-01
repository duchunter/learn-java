import java.awt.Color;
import java.awt.Graphics;

public abstract class Component {
  // Color constants
  public static final Color BLUE = new Color(173, 216, 230);
  public static final Color GREEN = new Color(0, 128, 0);
  public static final Color ORANGE = new Color(255, 165, 0);
  public static final Color RED = new Color(221, 20, 60);

  // Attributes
  private int x;
  private int y;
  private Color color;

  // Constructor
  public Component(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  // Getter and Setter
  void setX(int x) {
    this.x = x;
  }

  int getX() {
    return x;
  }

  void setY(int y) {
    this.y = y;
  }

  int getY() {
    return y;
  }

  void setColor(Color color) {
    this.color = color;
  }

  Color getColor() {
    return color;
  }

  // Methods
  abstract void draw(Graphics g);
}
