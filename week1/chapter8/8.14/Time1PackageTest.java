// Time1PackageTest.java
// Time1 object used in an application

import com.deitel.jhtp.ch08.Time1;

public class Time1PackageTest {
  public static void main( String[] args ) {
    // Create and init a Time1 object
    Time1 time = new Time1();

    // Output string representations of the time
    System.out.print("The initial universal time is: ");
    System.out.println(time.toUniversalString());
    System.out.print("The initial standard time is: ");
    System.out.println(time.toString());
    System.out.println();

    // Change time and output updated time
    time.setTime(13, 27, 6);
    System.out.print("Universal time after setTime is: ");
    System.out.println(time.toUniversalString());
    System.out.print("Standard time after setTime is: ");
    System.out.println(time.toString());
    System.out.println();

    // Attempt to set time with invalid values
    try {
      time.setTime(99, 99, 99);
    } catch (IllegalArgumentException e) {
      System.out.printf("Exception: %s\n\n", e.getMessage());
    }

    // Display time after attempt to set invalid values
    System.out.println("After attempting invalid settings:");
    System.out.print("Universal time: ");
    System.out.println(time.toUniversalString());
    System.out.print("Standard time: ");
    System.out.println(time.toString());
  }
}
