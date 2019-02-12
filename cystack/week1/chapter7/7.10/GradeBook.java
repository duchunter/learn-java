// GradeBook.java
// GradeBook class using a two-dimensional array to store and process grades

public class GradeBook {
  // Instance var
  private String courseName;
  private int[][] grades;

  // Constructor
  public GradeBook(String name, int[][] gradeArray) {
    courseName = name;
    grades = gradeArray;
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

  public void processGrades() {
    // Output grades array
    outputGrades();

    // Output min and max grade
    System.out.println();
    System.out.printf("Lowest grade is %d\n", getMinimum());
    System.out.printf("Highest grade is %d\n\n", getMaximum());

    // Print grade distribution chart
    outputBarChart();
  }

  // Find minimum grade
  public int getMinimum() {
    // Set initial min value
    int min = grades[0][0];

    // Loop through grades array, if grade lower than min, assign it to min
    for (int[] studentGrades : grades) {
      for (int grade : studentGrades) {
        if (grade < min) {
          min = grade;
        }
      }
    }

    // Done, return min
    return min;
  }

  // Find maximum grade
  public int getMaximum() {
    // Set initial max value
    int max = grades[0][0];

    // Loop through grades array, if grade greater than max, assign it to max
    for (int[] studentGrades : grades) {
      for (int grade : studentGrades) {
        if (grade > max) {
          max = grade;
        }
      }
    }

    // Done, return max
    return max;
  }

  // Determine average grade in a set of grade
  public double getAverage(int[] setOfGrade) {
    int total = 0;

    // Sum all grades
    for (int grade : setOfGrade) {
      total += grade;
    }

    // Return average of grades
    return (double) total / setOfGrade.length ;
  }

  // Output bar chart displaying grade distribution
  public void outputBarChart() {
    System.out.println("Grade distribution:");

    // Stores frequency of grades in each range of 10 grades
    int[] frequency = new int[11];

    // For each grade, increment the appropriate frequency
    for (int[] studentGrades : grades) {
      for (int grade : studentGrades) {
        frequency[grade / 10] += 1;
      }
    }

    // For each grade frequency, print bar in chart
    for (int count = 0; count < frequency.length; count++) {
      // Output bar label ("00-09: ", ..., "90-99: ", "100: ")
      if (count == 10) {
        System.out.printf("%5d: ", 100);
      } else {
        System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);
      }

      // Print bar of *
      for (int stars = 0; stars < frequency[count]; stars++) {
        System.out.print("*");
      }

      // Start a new line of output
      System.out.println();
    }
  }

  // Output content of grade array
  public void outputGrades() {
    System.out.println("The grades are:\n");

    // Output column heading
    System.out.printf("%12s", " ");
    for (int test = 0; test < grades[0].length; test++) {
      System.out.printf("%7s", "Test " + (test + 1));
    }

    System.out.printf("%10s\n", "Average");

    // Create rows
    for (int student = 0; student < grades.length; student++) {
      System.out.printf("%-12s", "Student " + (student + 1));

      // All grade
      for (int grade : grades[student]) {
        System.out.printf("%7d", grade);
      }

      // Average
      System.out.printf("%10.2f\n", getAverage(grades[student]));
    }
  }
}
