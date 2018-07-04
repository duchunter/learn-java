// Comparision.java
// Output the sum of 2 intergers inputed by user

import java.util.Scanner;

public class Comparision {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num1,
        num2;

    // Get input
    System.out.print("Enter the first number: ");
    num1 = input.nextInt();

    System.out.print("Enter the second number: ");
    num2 = input.nextInt();

    // Compare and output if satisfies condition
    if (num1 == num2) {
      System.out.printf("%d == %d\n", num1, num2);
    }

    if (num1 != num2) {
      System.out.printf("%d != %d\n", num1, num2);
    }

    if (num1 <= num2) {
      System.out.printf("%d <= %d\n", num1, num2);
    }

    if (num1 >= num2) {
      System.out.printf("%d >= %d\n", num1, num2);
    }

    if (num1 < num2) {
      System.out.printf("%d < %d\n", num1, num2);
    }

    if (num1 > num2) {
      System.out.printf("%d > %d\n", num1, num2);
    }
  }
}
