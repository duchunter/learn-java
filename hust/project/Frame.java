import javax.swing.JFrame;

public class Frame {
  // Some constant
  private static final int SCREEN_WIDTH = 600;
  private static final int SCREEN_HEIGHT = 600;

  public static void main(String[] args) {
    // Create new frame and panel
    JFrame app = new JFrame();
    Panel panel = new Panel();
    app.setTitle("Insertion sort");
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setResizable(false);
    app.add(panel);
    app.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    app.setVisible(true);
  }
}
