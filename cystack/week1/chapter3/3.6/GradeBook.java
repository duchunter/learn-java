// GradeBook.java
// contains a courseName instance variable and methods to set and get its value

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
      "Welcome to the Grade Book for \n%s!\n",
      getCourseName()
    );
  }
}
