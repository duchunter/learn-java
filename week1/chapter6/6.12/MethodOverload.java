// MethodOverload.java - section 6.12
// Overloaded method declarations

public class MethodOverload {
  public static void main(String[] args) {
    System.out.printf("Square of 7 is: %d\n", square(7));
    System.out.printf("Square of 7.5 is: %f\n", square(7.5));
  }

  // Using int argument
  public static int square(int num) {
    System.out.printf("\nCalled square with int argument: %d\n", num);
    return num * num;
  }

  // Using double argument
  public static double square(double num) {
    System.out.printf("\nCalled square with double argument: %f\n", num);
    return num * num;
  }
}
