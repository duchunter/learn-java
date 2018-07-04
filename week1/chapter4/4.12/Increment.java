// Increment.java
// Test prefix increment and postfix increment

public class Increment {
  public static void main(String[] args) {
    int c;

    // Test prefix increment
    c = 5;
    System.out.println(c);
    System.out.println(++c);
    System.out.println(c);

    // Skip a line
    System.out.println();

    // Test postfix increment
    c = 5;
    System.out.println(c);
    System.out.println(c++);
    System.out.println(c);
  }
}
