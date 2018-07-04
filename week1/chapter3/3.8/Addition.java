// Addition.java
// Add 2 number using GUI

import javax.swing.JOptionPane;

public class Addition {
  public static void main(String[] args) {
    int num1, num2;
    String input, message;

    // Get the first number
    input = JOptionPane.showInputDialog("Enter the first number");
    num1 = Integer.parseInt(input);

    // Get the second number
    input = JOptionPane.showInputDialog("Enter the second number");
    num2 = Integer.parseInt(input);

    // Output the result
    message = String.format("Sum: %d", num1 + num2);
    JOptionPane.showMessageDialog(null, message);
  }
}
