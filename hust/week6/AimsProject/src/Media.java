public class Media {
  private String id;
  private String title;
  private String category;
  private float cost;
  private boolean isFree = false;

  // Constructor
  public Media(String id, String title) {
	this.id = id;
	this.title = title;
  }

  public Media(String id, String title, String category) {
    this(id, title);
    this.category = category;
  }

  public Media(String id, String title, String category, float cost) {
    super();
    this.id = id;
    this.title = title;
    this.category = category;
    this.cost = cost;
  }

  // Getter and setter
  public String getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getCategory() {
    return this.category;
  }
  public void setCategory(String category) {
    this.category = category;
  }

  public float getCost() {
    return this.cost;
  }
  public void setCost(float cost) {
    this.cost = cost;
  }

  public boolean getIsFree() {
    return isFree;
  }
  public void setIsFree(boolean isFree) {
    this.isFree = isFree;
  }

  // Medthods
  public void printMedia() {
    System.out.print("- " + id + " - " + title + " - " + category + ": " + cost);
    if (isFree) {
      System.out.print(" (free)");
    }

    System.out.println();
  }
}
