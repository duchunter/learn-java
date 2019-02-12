import java.util.Scanner;

class Triangle {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get height
    System.out.print("Enter height: ");
    int height = input.nextInt();

    int level;
    int padding;
    int stars;
    int lastline = 1 + 2 * (height - 1);
    int count;

    // Draw triangle
    for (level = 1; level <= height; level++) {
      stars = 1 + 2 * (level - 1);
      padding = (lastline - stars) / 2;

      for (count = 0; count < padding; count++) {
        System.out.print(" ");
      }

      for (count = 0; count < stars; count++) {
        System.out.print("*");
      }

      System.out.print("\n");
    }
  }
}
