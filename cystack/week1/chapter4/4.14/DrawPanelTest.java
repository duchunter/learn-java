// DrawPanelTest.java
// Display DrawPanel

import javax.swing.JFrame;

public class DrawPanelTest {
  public static void main(String[] args) {
    // Create a panel that contains the drawing
    DrawPanel panel = new DrawPanel();

    // Create frame to hold the panel
    JFrame app = new JFrame();

    // Config window
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.add(panel);
    app.setSize(250, 250);
    app.setVisible(true);
  }
}
