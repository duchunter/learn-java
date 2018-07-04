// GradeBook.java
// GradeBook class that solves class-average problem using
// sentinel-controlled repetition

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

  // Calculate average grade
  public void determineClassAvarage() {
    // Init var
    Scanner input = new Scanner(System.in);
    double average;
    int inputGrade;
    int counter = 0;
    int total = 0;

    // Get the first value
    System.out.print("Enter grade 1 (enter -1 to stop): ");
    inputGrade = input.nextInt();

    // Loop until user enter sentinel value (-1)
    while (inputGrade != -1) {
      total += inputGrade;
      counter++;
      System.out.printf("Enter grade %d (enter -1 to stop): ", counter + 1);
      inputGrade = input.nextInt();
    }

    // Calculate average and output result
    if (counter > 0) {
      // If user entered at least 1 grade
      average = (double) total / counter;
      System.out.printf(
        "\nTotal grade of %d students is: %d\n", counter, total
      );
      System.out.printf("Average grade is: %.2f\n", average);
    } else {
      // If no grade were entered
      System.out.println("No grades were entered");
    }
  }
}
