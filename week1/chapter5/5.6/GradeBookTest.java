// GradeBookTest.java
// Create GradeBook object, input grades and display grade report

public class GradeBookTest {
  public static void main(String[] args) {
    // Create obj
    GradeBook myGradeBook = new GradeBook(
      "CS101 Introduction to Java Programming"
    );

    // Display a welcome msg
    myGradeBook.displayMessage();

    // Input grade
    myGradeBook.inputGrade();

    // Display grade report
    myGradeBook.displayGradeReport();
  }
}
