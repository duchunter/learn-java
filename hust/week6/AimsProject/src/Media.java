public class Media {
  private int id;
  private String title;
  private String category;
  private float cost;
  private boolean isFree = false;

  // Constructor
  public Media(String title, String category, float cost) {
    super();
    this.title = title;
    this.category = category;
    this.cost = cost;
  }

  // Getter and setter
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
}
