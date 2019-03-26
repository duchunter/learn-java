import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
  // Attributes
  private String artist;
  private List<Track> tracks = new ArrayList<Track>();

  // Constructor
  public CompactDisc(String id, String title, String category, String director, int length, float cost, String artist) {
    super(id, title, category, director, length, cost);
    this.artist = artist;
  }

  // Getter and Setter
  public String getArtist() {
    return artist;
  }
  public void setArtist(String artist) {
    this.artist = artist;
  }

  // Methods

  // Add track
  public void addTrack(Track track) {
    if (isTrackExist(track)) {
      System.out.println("Track " + track.getTitle() + " already exists");
    } else {
      this.tracks.add(track);
      System.out.println("Track " + track.getTitle() + " added");
    }
  }

  // Remove track
  public void removeTrack(Track track) {
    if (!isTrackExist(track)) {
      System.out.println("Track " + track.getTitle() + " not exists");
    } else {
      this.tracks.remove(track);
      System.out.println("Track " + track.getTitle() + " removed");
    }
  }

  // Get total length
  public int getLength() {
    int length = 0;
    for (Track track : this.tracks) {
      length += track.getLength();
    }

    return length;
  }

  // Implement play
  public void play() {
    System.out.println("Artist: " + this.getArtist());
    System.out.println("CD length: " + this.getLength());
    for (Track track : this.tracks) {
      track.play();
    }
  }

  // Supporting methods
  private boolean isTrackExist(Track track) {
    for (Track trk : this.tracks) {
      if (trk.getTitle().equals(track.getTitle())) {
        return true;
      }
    }

    return false;
  }
}