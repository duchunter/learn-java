// EnumTest.java
// Testing enum type Book

import java.util.EnumSet;

public class EnumTest {
  public static void main(String[] args) {
    // Print all books
    System.out.println("All books:\n");
    for (Book book : Book.values()) {
      System.out.printf(
        "%-10s%-45s%s\n", book, book.getTitle() , book.getCopyrightYear()
      );
    }

    // Print first four books using EnumSet
    System.out.println("\nDisplay a range of enum constants:\n");
    for (Book book : EnumSet.range(Book.JHTP, Book.CPPHTP)) {
      System.out.printf(
        "%-10s%-45s%s\n", book, book.getTitle() , book.getCopyrightYear()
      );
    }
  }
}
