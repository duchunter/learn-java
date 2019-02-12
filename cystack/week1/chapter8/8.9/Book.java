// Book.java
// Declaring an enum type with constructor and explicit instance fields
// and accessors for these fields

public enum Book {
  // Declare constants of enum type
  JHTP("Java How to Program", "2012"),
  CHTP("C How to Program", "2007"),
  IW3HTP("Internet & World Wide Web How to Program", "2008"),
  CPPHTP("C++ How to Program", "2012"),
  VBHTP("Visual Basic 2010 How to Program", "2011"),
  CSHARPHTP("Visual C# 2010 How to Program", "2011");

  // Instance fields
  private final String title;
  private final String copyrightYear;

  // enum constructor
  Book(String bookTitle, String year) {
    title = bookTitle;
    copyrightYear = year;
  }

  // Accessor for field title
  public String getTitle() {
    return title;
  }

  // Accessor for field copyrightYear
  public String getCopyrightYear() {
    return copyrightYear;
  }
}
