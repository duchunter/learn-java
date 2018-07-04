// GradeBookTest.java
// Create GradeBook obj and call its method with inputed course name

import java.util.Scanner;

public class GradeBookTest {
  public static void main(String[] args) {
    // Create obj
    Scanner input = new Scanner(System.in);
    GradeBook myGradeBook = new GradeBook();

    // Get course name
    System.out.println("Enter course name:");
    String courseName = input.nextLine();

    // Print a blank line
    System.out.println();

    // Call method
    myGradeBook.displayMessage(courseName);
  }
}
