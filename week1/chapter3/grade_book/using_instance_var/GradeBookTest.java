// GradeBookTest.java
// Creating and manipulating a GradeBook object

import java.util.Scanner;

public class GradeBookTest {
  public static void main(String[] args) {
    // Create obj
    Scanner input = new Scanner(System.in);
    GradeBook myGradeBook = new GradeBook();

    // Print initial course name
    System.out.printf(
      "Initial course name is: %s\n",
      myGradeBook.getCourseName()
    );

    // Get and set new course name
    System.out.println("Enter course name:");
    String courseName = input.nextLine();
    myGradeBook.setCourseName(courseName);

    // Print a blank line
    System.out.println();

    // Call method
    myGradeBook.displayMessage();
  }
}
