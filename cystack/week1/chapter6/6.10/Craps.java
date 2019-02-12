// Craps.java - section 6.10
// Simulates the dice game craps

import java.util.Random;

public class Craps {
  // Random number obj
  private static final Random randomNumber = new Random();

  // Enumerate game status
  private enum Status { WIN, LOSE, CONTINUE };

  // Some constants represent common rolls
  private static final int SNAKE_EYES = 2;
  private static final int TREY = 3;
  private static final int SEVEN = 7;
  private static final int YO_LEVEN = 11;
  private static final int BOX_CARS = 12;

  public static void main(String[] args) {
    // Init var
    int point = 0;
    Status gameStatus;

    // First roll
    int result = rollDice();
    switch (result) {
      // Win
      case SEVEN: case YO_LEVEN:
        gameStatus = Status.WIN;
        break;

      // Lose
      case SNAKE_EYES: case TREY: case BOX_CARS:
        gameStatus = Status.LOSE;
        break;

      // Continue
      default:
        gameStatus = Status.CONTINUE;
        point = result;
        System.out.printf("\nPoint: %d\n", point);
    }

    // If status is CONTINUE, roll until either win or lose
    while (gameStatus == Status.CONTINUE) {
      result = rollDice();

      // Win if result = point
      if (result == point) {
        gameStatus = Status.WIN;
      }

      // Lose if result is 7
      if (result == 7) {
        gameStatus = Status.LOSE;
      }
    }

    // Display final game status
    System.out.println(gameStatus == Status.WIN ? "You win" : "You lose");
    System.out.println();
  }

  public static int rollDice() {
    // Get 2 random value and get their sum
    int num1 = 1 + randomNumber.nextInt(6);
    int num2 = 1 + randomNumber.nextInt(6);
    int sum = num1 + num2;

    // Print result and return sum
    System.out.printf("Player rolled %d + %d = %d\n", num1, num2, sum);
    return sum;
  }
}
