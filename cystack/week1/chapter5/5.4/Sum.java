// Sum.java
// Summing even integers with the for statement

public class Sum {
  public static void main(String[] args) {
    int total = 0;
    for (int num = 2; num <= 20; num += 2) {
      total += num;
    }

    System.out.printf("Total: %d\n", total);
  }
}
