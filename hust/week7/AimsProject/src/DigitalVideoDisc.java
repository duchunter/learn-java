public class DigitalVideoDisc extends Disc implements Playable {
  // Constructor
  public DigitalVideoDisc(String id, String title) {
    super(id, title);
  }

  public DigitalVideoDisc(String id, String title, String category) {
    super(id, title, category);
  }

  public DigitalVideoDisc(String id, String title, String category, float cost) {
    super(id, title, category, cost);
  }

  public DigitalVideoDisc(String id, String title, String category, String director, float cost) {
    super(id, title, category, director, cost);
  }

  public DigitalVideoDisc(String id, String title, String category, String director, int length, float cost) {
    super(id, title, category, director, length, cost);
  }

  // METHODS

  // Implement play
  public void play() {
    System.out.println("Playing DVD: " + this.getTitle());
    System.out.println("DVD length: " + this.getLength());
  }

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
