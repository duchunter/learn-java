// Scope.java - section 6.11
// Scope class demonstrates field and local variable scopes

public class Scope {
  private static int x = 1;

  public static void main(String[] args) {
    int x = 5;

    // Value of local x before test
    System.out.printf("Local x in main is %d\n", x);

    // Perform test
    useLocalVariable();
    useField();
    useLocalVariable();
    useField();

    // Value of local x after test
    System.out.printf("\nLocal x in main is %d\n", x);
  }

  // Init local x each call
  public static void useLocalVariable() {
    int x = 25;
    System.out.printf(
      "\nLocal x on entering method useLocalVariable is %d\n", x
    );
    x++;
    System.out.printf(
      "local x before exiting method useLocalVariable is %d\n", x
    );
  }

  // Use class field x each call
  public static void useField() {
    System.out.printf(
      "\nLocal x on entering method useField is %d\n", x
    );
    x *= 10;
    System.out.printf(
      "local x before exiting method useField is %d\n", x
    );
  }
}
