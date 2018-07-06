import javax.swing.JFrame;
import java.util.TimerTask;
import java.util.Timer;

public class Frame {
  public static void main(String[] args) {
    // Create new frame
    JFrame app = new JFrame();

    // Set repeat action
    TimerTask repeatedTask = new TimerTask() {
      public void run() {
        Panel newPanel = new Panel(1);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(newPanel);
        app.setSize(500, 500);
        app.setVisible(true);
      }
    };

    // Set interval
    Timer timer = new Timer("Timer");
    long delay  = 0L;
    long period = 100L;
    timer.scheduleAtFixedRate(repeatedTask, delay, period);
  }
}
