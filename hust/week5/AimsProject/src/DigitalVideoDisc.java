public class DigitalVideoDisc {
  // Attributes
  public static final int MAXWORD = 20;
  private String title;
  private String category;
  private String director;
  private int length;
  private float cost;
  private boolean isFree;

  // Constructor
  public DigitalVideoDisc(String title) {
    super();
    this.title = title;
    this.isFree = false;
  }

  public DigitalVideoDisc(String title, String category) {
    super();
    this.title = title;
    this.category = category;
  }

  public DigitalVideoDisc(String title, String category, String director) {
    super();
    this.title = title;
    this.category = category;
    this.director = director;
  }

  public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    super();
    this.title = title;
    this.category = category;
    this.director = director;
    this.length = length;
    this.cost = cost;
  }

  // Getter and Setter

  // Title
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  // Category
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

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

  // Cost
  public float getCost() {
    return cost;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  // isFree
  public boolean getIsFree() {
    return isFree;
  }

  public void setIsFree(boolean isFree) {
    this.isFree = isFree;
  }

  // METHODS

  // Search
  public boolean search(String title) {
    String[] brokenTitle = this.title.split(" ");
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
