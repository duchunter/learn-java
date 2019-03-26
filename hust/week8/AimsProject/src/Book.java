import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.TreeMap;

public class Book extends Media {
  // Attributes
  private List<String> authors = new ArrayList<String>();
  private String content;
  private List<String> contentTokens = new ArrayList<String>();
  private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

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
    contentTokens.clear();
    for (String word : this.content.split("[.,]\\s|\\s")) {
      word = word.toLowerCase();
      contentTokens.add(word);
      boolean hasKey = wordFrequency.containsKey(word);
      if (!hasKey) {
        wordFrequency.put(word, 1);
      } else {
        wordFrequency.replace(word, wordFrequency.get(word) + 1);
      }
    }

    Collections.sort(contentTokens);
  }

  public void print() {
    printMedia();
    System.out.println("Authors: " + this.authors.toString());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Book info:\n\tID: " + getId());
    sb.append("\n\tTitle: " + getTitle());
    sb.append("\n\tCategory: " + getCategory());
    sb.append("\n\tCost: " + getCost());
    sb.append("\n\tIs free: " + getIsFree());
    sb.append("\n\tAuthors: " + authors.toString());
    sb.append("\n\tContent length: " + contentTokens.size());
    sb.append("\n\tWord frequency: ");
    for( Map.Entry m : wordFrequency.entrySet()) {
      sb.append("\n" + m.getKey() + ": " + m.getValue());
    }

    sb.append("\n");
    return sb.toString();
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
