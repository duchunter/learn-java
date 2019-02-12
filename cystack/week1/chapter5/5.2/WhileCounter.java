// WhileCounter.java
// Counter-controlled repetition with the while repetition statement

public class WhileCounter {
  public static void main(String[] args) {
    int counter = 0;
    while (++counter <= 10) {
      System.out.printf("%d   ", counter);
    }

    System.out.println();
  }
}
