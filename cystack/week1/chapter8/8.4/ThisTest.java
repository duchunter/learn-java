// ThisTest.java
// Test 'this' used implicitly and explicitly to refer to members of an object

public class ThisTest {
  public static void main(String[] args) {
    SimpleTime time = new SimpleTime(15, 30, 19);
    System.out.println(time.buildString());
  }
}

// Class SimpleTime demonstrates the 'this' reference
class SimpleTime {
  private int hour;
  private int minute;
  private int second;

  // Constructor
  public SimpleTime(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  // Use explicit and implicit 'this' to call toUniversalString
  public String buildString() {
    // Explicit
    String string1 = String.format(
      "%24s: %s\n", "this.toUniversalString()", this.toUniversalString()
    );

    // Implicit
    String string2 = String.format(
      "%24s: %s\n", "toUniversalString()", toUniversalString()
    );
    return string1 + string2;
  }

  // Convert to format HH:MM:SS
  public String toUniversalString() {
    return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
  }
}
