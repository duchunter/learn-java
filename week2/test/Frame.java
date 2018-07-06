import javax.swing.JFrame;
import java.util.TimerTask;
import java.util.Timer;

public class Frame {
  public static void main(String[] args) {
    JFrame app = new JFrame();
    TimerTask repeatedTask = new TimerTask() {
      public void run() {
        Panel newPanel = new Panel(1);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(newPanel);
        app.setSize(500, 500);
        app.setVisible(true);
      }
    };

    Timer timer = new Timer("Timer");
    long delay  = 0L;
    long period = 500L;
    timer.scheduleAtFixedRate(repeatedTask, delay, period);
  }
}
