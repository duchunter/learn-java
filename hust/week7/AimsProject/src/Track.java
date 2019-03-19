public class Track implements Playable {
  // Attributes
  private String title;
  private int length;

  // Constructor
  public Track(String title, int length) {
    this.title = title;
    this.length = length;
  }

  // Getter and Setter
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public int getLength() {
    return length;
  }
  public void setLength(int length) {
    this.length = length;
  }

  // Methods

  // Implement play
  public void play() {
    System.out.println("Playing track: " + this.getTitle());
    System.out.println("Track length: " + this.getLength());
  }
}
