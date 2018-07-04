// Time2Test.java
// Test overloaded constructors used to initialize Time2 objects

public class Time2Test {
  public static void main(String[] args) {
    // Init var
    Time2 t1 = new Time2();
    Time2 t2 = new Time2(2);
    Time2 t3 = new Time2(21, 34);
    Time2 t4 = new Time2(12, 25, 42);
    Time2 t5 = new Time2(t4);

    // Test t1 - no argument
    System.out.println("Constructed with:" );
    System.out.println("t1: all arguments defaulted");
    System.out.printf("%s\n", t1.toUniversalString());
    System.out.printf("%s\n", t1.toString());

    // Test t2 - 1 argument
    System.out.println("t2: hour supplied");
    System.out.printf("%s\n", t2.toUniversalString());
    System.out.printf("%s\n", t2.toString());

    // Test t3 - 2 arguments
    System.out.println("t3: hour and minute supplied");
    System.out.printf("%s\n", t3.toUniversalString());
    System.out.printf("%s\n", t3.toString());

    // Test t4 - 3 arguments
    System.out.println("t4: all arguments supplied");
    System.out.printf("%s\n", t4.toUniversalString());
    System.out.printf("%s\n", t4.toString());

    // Test t5 - using other Time2 obj
    System.out.println("t5: t4 supplied");
    System.out.printf("%s\n", t5.toUniversalString());
    System.out.printf("%s\n", t5.toString());

    // Attempt to initialize t6 with invalid values
    try {
      Time2 t6 = new Time2(27, 74, 99);
    } catch (IllegalArgumentException e) {
      // Catch exception
      System.out.printf(
        "\nException while initializing t6: %s\n", e.getMessage()
      );
    }
  }
}
