import javax.swing.JOptionPane;

public class ChoosingOption {
  public static void main(String[] args) {
    Object[] buttons = {
      "I do",
      "I don't"
    };

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

    JOptionPane.showMessageDialog(
      null,
      "You have chosen: " + (
        option == JOptionPane.YES_OPTION ? "Yes" : "No"
      )
    );

    System.exit(0);
  }
}
