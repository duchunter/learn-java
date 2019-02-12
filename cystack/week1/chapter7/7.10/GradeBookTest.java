// GradeBookTest.java
// Create GradeBook object, input grades and display grade report

public class GradeBookTest {
  public static void main(String[] args) {
    // Test array of student grades
    int[][] gradesArray = {
      { 87, 96, 70 },
      { 68, 87, 90 },
      { 94, 100, 90 },
      { 100, 81, 82 },
      { 83, 65, 85 },
      { 78, 87, 65 },
      { 85, 75, 83 },
      { 91, 94, 100 },
      { 76, 72, 84 },
      { 87, 93, 73 }
    };

    // Create obj
    GradeBook myGradeBook = new GradeBook(
      "CS101 Introduction to Java Programming",
      gradesArray
    );

    // Display a welcome msg
    myGradeBook.displayMessage();

    // Display grade report
    myGradeBook.processGrades();
  }
}
