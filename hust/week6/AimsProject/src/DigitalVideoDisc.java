public class DigitalVideoDisc extends Media {
  // Attributes
  public static final int MAXWORD = 20;
  private String director;
  private int length;

  // Constructor
  public DigitalVideoDisc(String title, String category, float cost) {
    super(title, category, cost);
  }

  public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    this(title, category, cost);
    this.director = director;
    this.length = length;
  }

  // Getter and Setter

  // Director
  public String getDirector() {
    return director;
  }
  public void setDirector(String director) {
    this.director = director;
  }

  // Length
  public int getLength() {
    return length;
  }
  public void setLength(int length) {
    this.length = length;
  }

  // METHODS

  // Search
  public boolean search(String title) {
    String[] brokenTitle = this.getTitle().split(" ");
    String[] brokenString = title.split(" ");
    boolean isFound = false;

    int i, j;
    for (i = 0; i < brokenString.length; i++) {
      isFound = false;
      for (j = 0; j < brokenTitle.length; j++) {
        if (brokenString[i].equalsIgnoreCase(brokenTitle[j])) {
          isFound = true;
          break;
        }
      }

      if (isFound == false) {
        break;
      }
    }

    return isFound;
  }
}
