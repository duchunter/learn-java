import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
  // Attributes
  private List<String> authors = new ArrayList<String>();

  // Constructor
  public Book(String title, String category, float cost) {
    super(title, category, cost);
  }

  // Methods
  public void addAuthor(String author) {
    if (isAuthorExist(author)) {
      System.out.println("Author " + author + " already exists");
    } else {
      this.authors.add(author);
      System.out.println("Author " + author + " added");
    }
  }

  public void removeAuthor(String author) {
    if (!isAuthorExist(author)) {
      System.out.println("Author " + author + " not exists");
    } else {
      this.authors.remove(author);
      System.out.println("Author " + author + " removed");
    }
  }

  public void print() {
    System.out.println(this.authors.toString());
  }

  // Supporting methods
  private boolean isAuthorExist(String author) {
    for (String name : this.authors) {
      if (author.equals(name)) {
        return true;
      }
    }

    return false;
  }
}
