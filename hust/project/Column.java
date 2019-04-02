import java.awt.Graphics;

public class Column extends Component {
  // Column size unit constants
  private static final int HEIGHT_UNIT = 10;
  private static final int WIDTH_UNIT = 20;
  private static final int PADDING = 20;

  // Max height among columns
  private static int maxValue = 0;

  // Attributes
  private int value;
  private int height;
  private int width;

  // Constructor
  public Column(int x, int y, int value) {
    super(x, y, Component.BLUE);
    this.value = value;
    this.height = value * HEIGHT_UNIT;
    this.width = WIDTH_UNIT;
    if (value > maxValue) {
      maxValue = value;
    }
  }

  // Move up and down
  void moveVertical(int offset, int frames) {
    int nextY = y + offset * maxValue * HEIGHT_UNIT + PADDING;
    setNext(x, nextY, frames);
  }

  // Move right or left
  void moveHorizontal(int offset, int frames) {
    int nextX = x + offset * (WIDTH_UNIT + PADDING);
    setNext(nextX, y, frames);
  }

  // Draw a column
  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x, y, width, height);
  }

  // Test
  public void info() {
    System.out.println(x);
    System.out.println(y);
    System.out.println(color);
    System.out.println(nextX);
    System.out.println(nextY);
    System.out.println(speedX);
    System.out.println(speedY);
    System.out.println(value);
    System.out.println(height);
    System.out.println(width);
  }
}
