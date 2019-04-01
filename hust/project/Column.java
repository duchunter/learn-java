import java.awt.Graphics;

public class Column extends Component {
  // Column size unit constants
  private static final int HEIGHT_UNIT = 5;
  private static final int WIDTH_UNIT = 5;
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

  // Methods

  // Move up and down
  void moveVertical(int offset) {
    int y = super.getY();
    super.setY(y + offset * maxValue * HEIGHT_UNIT + PADDING);
  }

  // Move right or left
  void moveHorizontal(int offset) {
    int x = super.getX();
    super.setX(x + offset * (WIDTH_UNIT + PADDING));
  }

  // Draw a column
  @Override
  public void draw(Graphics g) {
    g.setColor(super.getColor());
    g.fillRect(super.getX(), super.getY(), width, height);
  }
}
