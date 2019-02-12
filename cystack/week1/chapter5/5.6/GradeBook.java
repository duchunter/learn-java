// GradeBook.java
// GradeBook class that uses switch statement to count letter grades

import java.util.Scanner;

public class GradeBook {
  // Instance var
  private String courseName;
  private int total;
  private int gradeCounter;
  private int countA;
  private int countB;
  private int countC;
  private int countD;
  private int countF;

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

  // Get input grade from user
  public void inputGrade() {
    // Init var
    Scanner input = new Scanner(System.in);
    int grade;

    // Display instruction
    System.out.println("Enter the integer grades in the range 0-100.");
    System.out.println("Type the end-of-file indicator to terminate input:");
    System.out.println("On UNIX/Linux/Mac OS X type <Ctrl> d then press Enter");
    System.out.println("On Windows type <Ctrl> z then press Enter");

    // Loop until read eof
    while(input.hasNext()) {
      // Get input and increase appropriate value
      grade = input.nextInt();
      total += grade;
      gradeCounter++;

      // Increase letter grade counter based on input grade
      incrementLetterGradeCounter(grade);
    }
  }

  // Function that increase letter counter
  private void incrementLetterGradeCounter(int grade) {
    switch (grade / 10) {
      // 90 to 100
      case 10: case 9:
        countA++;
        break;

      // 80 to 89
      case 8:
        countB++;
        break;

      // 70 to 79
      case 7:
        countC++;
        break;

      // 60 to 69
      case 6:
        countD++;
        break;

      // Below 60
      default:
        countF++;
    }
  }

  // Display grade report
  public void displayGradeReport() {
    System.out.println("\nGrade report:\n");

    // If user enter at least 1 grade
    if (gradeCounter > 0) {
      // Output summary
      double average = (double) total / gradeCounter;
      System.out.printf(
        "Total grade of %d students: %d\n", gradeCounter, total
      );
      System.out.printf("Average: %.2f\n", average);
      System.out.printf("A: %d\n", countA);
      System.out.printf("B: %d\n", countB);
      System.out.printf("C: %d\n", countC);
      System.out.printf("D: %d\n", countD);
      System.out.printf("F: %d\n", countF);
    }

    // If no grades were entered
    else {
      System.out.println("No grades were entered\n");
    }
  }
}
