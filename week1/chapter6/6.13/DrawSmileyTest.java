// DrawSmileyTest.java - section 6.13
// Test app that displays a smiley face

import javax.swing.JFrame;

public class DrawSmileyTest {
  public static void main(String[] args) {
    // Create new panel
    DrawSmiley panel = new DrawSmiley();

    // Create window
    JFrame app = new JFrame();

    // Config window
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.add(panel);
    app.setSize(230, 250);
    app.setVisible(true);
  }
}
