// NameDialog.java
// Basic input with a dialog box

import javax.swing.JOptionPane;

public class NameDialog {
  public static void main(String[] args) {
    // Get user's name
    String name = JOptionPane.showInputDialog("Enter your name");

    // Format message and output greeting
    String message = String.format("Welcome, %s, to Java Programming", name);
    JOptionPane.showMessageDialog(null, message);
  }
}
