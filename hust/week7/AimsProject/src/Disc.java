abstract class Disc extends Media {
  // Attributes
  private String director;
  private int length;

  // Constructor
  public Disc(String id, String title) {
    super(id, title);
  }

  public Disc(String id, String title, String category) {
    super(id, title, category);
  }

  public Disc(String id, String title, String category, float cost) {
    super(id, title, category, cost);
  }

  public Disc(String id, String title, String category, String director, float cost) {
    this(id, title, category, cost);
    this.director = director;
  }

  public Disc(String id, String title, String category, String director, int length, float cost) {
    this(id, title, category, director, cost);
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
}
