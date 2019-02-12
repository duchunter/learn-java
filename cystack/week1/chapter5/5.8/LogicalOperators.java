// LogicalOperators.java
// Logical operators

public class LogicalOperators {
  public static void main(String[] args) {
    // Create truth table for && (conditional AND) operator
    System.out.println("Conditional AND (&&)");
    System.out.printf("false && false: %b\n", false && false);
    System.out.printf("false && true: %b\n", false && true);
    System.out.printf("true && false: %b\n", true && false);
    System.out.printf("true && true: %b\n\n", true && true);

    // Create truth table for || (conditional OR) operator
    System.out.println("Conditional OR (||)");
    System.out.printf("false || false: %b\n", false || false);
    System.out.printf("false || true: %b\n", false || true);
    System.out.printf("true || false: %b\n", true || false);
    System.out.printf("true || true: %b\n\n", true || true);

    // Create truth table for & (boolean logical AND) operator
    System.out.println("Boolean logical AND (&)");
    System.out.printf("false & false: %b\n", false & false);
    System.out.printf("false & true: %b\n", false & true);
    System.out.printf("true & false: %b\n", true & false);
    System.out.printf("true & true: %b\n\n", true & true);

    // Create truth table for | (boolean logical OR) operator
    System.out.println("Boolean logical OR (|)");
    System.out.printf("false | false: %b\n", false | false);
    System.out.printf("false | true: %b\n", false | true);
    System.out.printf("true | false: %b\n", true | false);
    System.out.printf("true | true: %b\n\n", true | true);

    // Create truth table for ^ (exclusive OR) operator
    System.out.println("Boolean logical exclusive OR (^)");
    System.out.printf("false ^ false: %b\n", false ^ false);
    System.out.printf("false ^ true: %b\n", false ^ true);
    System.out.printf("true ^ false: %b\n", true ^ false);
    System.out.printf("true ^ true: %b\n\n", true ^ true);

    // create truth table for ! (logical negation) operator
    System.out.println("Logical NOT (!)");
    System.out.printf("!false: %b\n", !false);
    System.out.printf("!true: %b\n", !true);
  }
}
