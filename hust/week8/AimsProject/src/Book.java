import java.util.ArrayList;
import java.util.List.SortedList;
import java.util.List;
import java.util.Map;
import java.util.List.SortedMap;

public class Book extends Media {
  // Attributes
  private List<String> authors = new ArrayList<String>();
  private String content;
  private List<String> contentTokens = new SortedList<String>();
  private Map<String, Integer> wordFrequency = new SortedMap<String, Integer>();

  // Constructor
  public Book(String id, String title) {
    super(id, title);
  }

  public Book(String id, String title, String category) {
    super(id, title, category);
  }

  public Book(String id, String title, String category, float cost) {
    super(id, title, category, cost);
  }

  public Book(String id, String title, String category, float cost, String content) {
    super(id, title, category, cost);
    this.content = content;
    processContent();
  }

  // Getter and setter
  public String getContent() {
    return this.content;
  }
  public void setContent(String content) {
    this.content = content;
    processContent();
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

  public void processContent() {
    System.out.println(this.content.split("re*(,|.)\\s"));
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
