// GradeBookTest.java
// Creating and manipulating a GradeBook object

public class GradeBookTest {
  public static void main(String[] args) {
    // Create obj
    GradeBook myGradeBook1 = new GradeBook(
      "CS101 Introduction to Java Programming"
    );

    GradeBook myGradeBook2 = new GradeBook(
      "CS102 Data Structures in Java"
    );

    // Print initial course name
    System.out.printf(
      "GradeBook1 course name is: %s\n",
      myGradeBook1.getCourseName()
    );

    // Print initial course name
    System.out.printf(
      "GradeBook2 course name is: %s\n",
      myGradeBook2.getCourseName()
    );
  }
}
