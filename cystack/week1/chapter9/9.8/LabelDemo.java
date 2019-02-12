// LabelDemo.java
// Demonstrates the use of labels

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class LabelDemo {
  public static void main(String[] args) {
    // Create a label with plain text
    JLabel northLabel = new JLabel("North");

    // Create an icon from an image so we can put it on a JLabel
    ImageIcon labelIcon = new ImageIcon("icon.jpeg");

    // Create a label with an Icon instead of text
    JLabel centerLabel = new JLabel(labelIcon);

    // Set the label to display text + icon
    JLabel southLabel = new JLabel(labelIcon);
    southLabel.setText("South");

    // Create a frame to hold the labels
    JFrame app = new JFrame();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add the labels to the frame
    app.add(northLabel, BorderLayout.NORTH);
    app.add(centerLabel, BorderLayout.CENTER);
    app.add(southLabel, BorderLayout.SOUTH);
    app.setSize(700, 700);
    app.setVisible(true);
  }
}
