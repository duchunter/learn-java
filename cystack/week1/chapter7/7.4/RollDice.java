// RollDice.java - secion 7.4
// Dice-rolling program using arrays instead of switch

import java.util.Random;

public class RollDice {
  public static void main(String[] args) {
    // Init var
    Random randomNumbers = new Random();
    int[] frequency = new int[6];
    int length = frequency.length;

    // Roll 6000000 times, use dice value as frequency index
    for (int roll = 1; roll <= 6000000; roll++) {
      frequency[randomNumbers.nextInt(6)] += 1;
    }

    // Output result
    System.out.printf( "%4s%12s\n", "Face", "Frequency" );
    for (int i = 0; i < length; i++) {
      System.out.printf("%4d%12d\n", (i + 1), frequency[i]);
    }
  }
}
