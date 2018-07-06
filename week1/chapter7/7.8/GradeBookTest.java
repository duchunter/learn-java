// GradeBookTest.java
// Create GradeBook object, input grades and display grade report

public class GradeBookTest {
  public static void main(String[] args) {
    // Test array of student grades
    int[] gradesArray = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };

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
