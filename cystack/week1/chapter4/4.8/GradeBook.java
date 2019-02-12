// GradeBook.java
// GradeBook class that solves class-average problem using
// counter-controlled repetition

import java.util.Scanner;

public class GradeBook {
  // Instance var
  private String courseName;

  // Constructor
  public GradeBook(String name) {
    courseName = name;
  }

  // Setter
  public void setCourseName(String name) {
    courseName = name;
  }

  // Getter
  public String getCourseName() {
     return courseName;
  }

  // Display msg
  public void displayMessage() {
    System.out.printf(
      "Welcome to the Grade Book for \n%s!\n\n", getCourseName()
    );
  }

  // Calculate average grade of 10 students inputed by user
  public void determineClassAvarage() {
    // Init var
    Scanner input = new Scanner(System.in);
    int average;
    int counter = 1;
    int total = 0;

    // Loop until user entered 10 grades
    while (counter <= 10) {
      System.out.printf("Enter grade %d: ", counter++);
      total += input.nextInt();
    }

    // Calculate average and output result
    average = total / 10;
    System.out.printf("\nTotal grade is: %d\n", total);
    System.out.printf("Average grade is: %d\n", average);
  }
}
