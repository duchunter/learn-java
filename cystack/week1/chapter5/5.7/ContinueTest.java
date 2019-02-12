// ContinueTest.java
// Testing continue in for loop

public class ContinueTest {
  public static void main(String[] args) {
    int count;
    for (count = 1; count <= 10; count++) {
      if (count == 5) continue;
      System.out.printf("%d   ", count);
    }

    System.out.println("\nSkipped value 5");
  }
}
