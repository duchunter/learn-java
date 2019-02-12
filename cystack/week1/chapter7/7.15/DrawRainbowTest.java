// DrawRainbowTest.java
// Test application to display a rainbow

import javax.swing.JFrame;

public class DrawRainbowTest {
  public static void main(String[] args) {
    // Create panel and window
    DrawRainbow panel = new DrawRainbow();
    JFrame application = new JFrame();

    // Config window
    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    application.add(panel);
    application.setSize(400, 250);
    application.setVisible(true);
  }
}
