import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.TimerTask;
import java.util.Timer;

public class Frame {
  // Some constant
  private static final int SCREEN_WIDTH = 500;
  private static final int SCREEN_HEIGHT = 500;
  private static final long ANIMATION_PERIOD = 20L;
  private static final long ANIMATION_DELAY = 0L;

  public static void main(String[] args) {
    // Get number of balls to simulate
    String numOfBalls = JOptionPane.showInputDialog("Enter number of balls");

    // Create new frame and panel
    JFrame app = new JFrame();
    Panel panel = new Panel();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setResizable(false);
    app.add(panel);
    app.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    app.setVisible(true);

    // Inititalize ball list
    panel.init(Integer.parseInt(numOfBalls));

    // Set repeat action
    TimerTask repeatedTask = new TimerTask() {
      public void run() {
        panel.update();
        panel.repaint();
      }
    };

    // Set interval
    Timer timer = new Timer("Timer");
    long delay  = ANIMATION_DELAY;
    long period = ANIMATION_PERIOD;
    timer.scheduleAtFixedRate(repeatedTask, delay, period);
  }
}
