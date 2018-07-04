// Addition.java
// Output the sum of 2 intergers inputed by user

import java.util.Scanner;

public class Addition {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num1,
        num2,
        sum;

    // Get input
    System.out.print("Enter the first number: ");
    num1 = input.nextInt();

    System.out.print("Enter the second number: ");
    num2 = input.nextInt();

    // Add and output result
    sum = num1 + num2;
    System.out.printf("Sum: %d\n", sum);
  }
}
