// RollDice.java - section 6.9
// Roll a six-sided dice 6,000,000 times and output frequency

import java.util.Random;

public class RollDice {
  public static void main(String[] args) {
    Random randomNumber = new Random();
    int result;
    int f1 = 0;
    int f2 = 0;
    int f3 = 0;
    int f4 = 0;
    int f5 = 0;
    int f6 = 0;

    // Roll the dice 6000000 times
    for (int x = 1; x <= 6000000; x++) {
      // Get value from 1 to 6
      result = 1 + randomNumber.nextInt(6);

      // Increase counter based on result
      switch (result) {
        case 1:
          f1++;
          break;
        case 2:
          f2++;
          break;
        case 3:
          f3++;
          break;
        case 4:
          f4++;
          break;
        case 5:
          f5++;
          break;
        case 6:
          f6++;
          break;
      }
    }

    // Output frequency
    System.out.printf("Face 1: %d\n", f1);
    System.out.printf("Face 2: %d\n", f2);
    System.out.printf("Face 3: %d\n", f3);
    System.out.printf("Face 4: %d\n", f4);
    System.out.printf("Face 5: %d\n", f5);
    System.out.printf("Face 6: %d\n", f6);
  }
}
