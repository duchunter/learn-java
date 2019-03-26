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

  // Get number of track
  public int getTrackLength() {
    return this.tracks.size();
  }

  // Implement play
  public void play() {
    System.out.println("Artist: " + this.getArtist());
    System.out.println("CD length: " + this.getLength());
    for (Track track : this.tracks) {
      track.play();
    }
  }

  // Compare
  @Override
  public int compareTo(Media media) {
    if (media == this) {
      return 0;
    }

    if (!(media instanceof CompactDisc)) {
      return super.compareTo(media);
    }

    CompactDisc cd = (CompactDisc) media;

    int nbTrack1 = this.getTrackLength();
    int nbTrack2 = cd.getTrackLength();

    if (nbTrack1 < nbTrack2) return -1;
    if (nbTrack1 > nbTrack2) return 1;

    int length1 = this.getLength();
    int length2 = cd.getLength();

    if (length1 < length2) return -1;
    if (length1 > length2) return 1;
    return 0;
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
