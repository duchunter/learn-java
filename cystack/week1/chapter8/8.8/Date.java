// Date.java
// Date class declaration

public class Date {
  // Fields
  private int month;
  private int day;
  private int year;

  // Const - day per month
  private static final int[] daysPerMonth = {
    0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
  };

  // Constructor validate month and day
  public Date(int m, int d, int y) {
    // Validate month first then day
    month = checkMonth(m);
    day = checkDay(d);

    // Year can be any
    year = y;

    System.out.printf("Date object constructor for date %s\n", this);
  }

  // Validate month
  private int checkMonth(int m) {
    if (m > 0 && m <= 12) {
      return m;
    } else {
      throw new IllegalArgumentException("month must be 1-12");
    }
  }

  // Validate day
  private int checkDay(int d) {
    // Check if day in range for month
    if (d > 0 && d <= daysPerMonth[month]) {
      return d;
    }

    // Check for leap year, first it must be Feb 29th
    if (month == 2 && d == 29) {
      // Then that year must be leap year
      if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
        return d;
      }
    }

    // Invalid day
    throw new IllegalArgumentException(
      "day out-of-range for the specified month and year"
    );
  }

  // Return a String in format month/day/year
  public String toString() {
    return String.format("%d/%d/%d", month, day, year);
  }
}
