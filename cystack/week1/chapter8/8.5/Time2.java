// Time2.java
// Time2 class declaration with overloaded constructors.

public class Time2 {
  private int hour;
  private int minute;
  private int second;

  // No argument constructor
  public Time2() {
    this(0, 0, 0);
  }

  // Hour supplied constructor
  public Time2(int h) {
    this(h, 0, 0);
  }

  // Hour and minute supplied constructor
  public Time2(int h, int m) {
    this( h, m, 0 );
  }

  // Hour, minute, second supplied constructor
  public Time2(int h, int m, int s) {
    setTime(h, m, s);
  }

  // Another Time2 object supplied constructor
  public Time2(Time2 time) {
    this(time.hour, time.minute, time.second);
  }

  // Set a new time value
  public void setTime( int h, int m, int s ) {
    setHour(h);
    setMinute(m);
    setSecond(s);
  }

  // Validate and set hour
  public void setHour(int h) {
    if (h >= 0 && h < 24) {
      hour = h;
    } else {
      throw new IllegalArgumentException("hour must be 0-23");
    }
  }

  // Validate and set minute
  public void setMinute(int m) {
    if (m >= 0 && m < 60) {
      minute = m;
    } else {
      throw new IllegalArgumentException("minute must be 0-59");
    }
  }

  // Validate and set second
  public void setSecond(int s) {
    if ( s >= 0 && s < 60 ) {
      second = s;
    } else {
      throw new IllegalArgumentException("second must be 0-59");
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
