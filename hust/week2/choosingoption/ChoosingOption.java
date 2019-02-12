import javax.swing.JOptionPane;

public class ChoosingOption {
  public static void main(String[] args) {
    Object[] buttons = {
      "I do",
      "I don't"
    };

    // Show popup with custom buttons
    int option = JOptionPane.showOptionDialog(
      null,
      "Do you want to change to first class ticket?",
      "Choose an option",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.PLAIN_MESSAGE,
      null,
      buttons,
      null
    );

    // Show result popup
    JOptionPane.showMessageDialog(
      null,
      "You have chosen: " + (
        option == JOptionPane.YES_OPTION ? "Yes" : "No"
      )
    );

    System.exit(0);
  }
}
