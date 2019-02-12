// Time1.java
// Time1 class declaration maintains the time in 24-hour format

public class Time1 {
  private int hour;
  private int minute;
  private int second;

  // Set a new time value using universal time
  // Throw exception if hour, minute or second is invalid
  public void setTime(int h, int m, int s) {
    if (
      (h >= 0 && h < 24)        // Validate hour
      && (m >= 0 && m < 60)     // Validate minute
      && (s >= 0 && s < 60)     // Validate second
    ) {
      // Ok -> set value
      hour = h;
      minute = m;
      second = s;
    } else {
      // Invalid -> throw exception
      throw new IllegalArgumentException(
        "hour, minute and/or second was out of range"
      );
    }
  }

  // Convert to format HH:MM:SS
  public String toUniversalString() {
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }

  // Convert to format H:MM:SS AM/PM
  public String toString() {
    return String.format(
      "%d:%02d:%02d %s",
      (hour == 0 || hour == 12) ? 12 : hour % 12,
      minute,
      second,
      hour < 12 ? "AM" : "PM"
    );
  }
}
