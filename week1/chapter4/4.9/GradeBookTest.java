// GradeBookTest.java
//  Create GradeBook object and invoke its determineClassAverage method

public class GradeBookTest {
  public static void main(String[] args) {
    // Create obj
    GradeBook myGradeBook = new GradeBook(
      "CS101 Introduction to Java Programming"
    );

    // Display a welcome msg
    myGradeBook.displayMessage();

    // Determine average grade
    myGradeBook.determineClassAvarage();
  }
}
