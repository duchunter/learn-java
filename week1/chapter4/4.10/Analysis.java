// Analysis.java
// Analysis of examination results using nested control statements

import java.util.Scanner;

public class Analysis {
  public static void main(String[] args) {
    // Init var
    Scanner input = new Scanner(System.in);
    int inputResult;
    int studentCounter = 1;
    int passCounter = 0;
    int failCounter = 0;
    String instruction = "(1 = passed, 2 = failed)";

    // Loop until user entered results for 10 students
    while (studentCounter <= 10) {
      // Get user input
      System.out.printf(
        "Enter result of student %d %s: ", studentCounter, instruction
      );
      inputResult = input.nextInt();

      // Evaluate input to increase counter
      if (inputResult == 1) {
        // Increase pass counter
        passCounter++;
      } else {
        // Increase fail counter
        failCounter++;
      }

      studentCounter++;
    }

    // Output analysis result
    System.out.printf("\nPassed: %d, Failed: %d\n", passCounter, failCounter);

    // Check if more than 8 students passed
    if (passCounter > 8) {
      System.out.println("Bonus to instructor");
    }
  }
}
