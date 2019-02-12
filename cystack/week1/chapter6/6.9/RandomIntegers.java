// RandomIntegers.java - section 6.9
// Get random integers from 1 to 6

import java.util.Random;

public class RandomIntegers {
  public static void main(String[] args) {
    Random randomNumber = new Random();
    int result;

    // Roll the dice 20 times
    for (int x = 1; x <= 20; x++) {
      // Get value from 1 to 6
      result = 1 + randomNumber.nextInt(6);
      System.out.printf("%d   ", result);

      // Line break every 5 value
      if (x % 5 == 0) {
        System.out.println();
      }
    }
  }
}
