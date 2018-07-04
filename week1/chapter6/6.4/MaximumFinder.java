// MaximumFinder.java - section 6.4
// Programmer-declared method maximum with three double parameters

import java.util.Scanner;

public class MaximumFinder {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get input value
    System.out.print("Enter 3 float number seperated by spaces: ");
    double num1 = input.nextDouble();
    double num2 = input.nextDouble();
    double num3 = input.nextDouble();

    // Print out maximum value
    System.out.println("Maximum: " + maximum(num1, num2, num3));
  }

  // Function that return maximum of 3 value
  public static double maximum(double num1, double num2, double num3) {
    double max = num1;
    if (num2 > max) max = num2;
    if (num3 > max) max = num3;
    return max;
  }
}
