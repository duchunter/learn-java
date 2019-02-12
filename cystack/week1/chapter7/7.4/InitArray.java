// InitArray.java - section 7.4
// Initializing array using 2 method
public class InitArray {
  public static void main(String[] args) {
    initArrayUsingInitializer();
    initDefaultArray();
  }

  // Init array using initializer
  public static void initArrayUsingInitializer() {
    // Create new array using initializer
    int[] array = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };

    // Display all value
    printArray(array);
  }

  // Init array in default method and assign value
  public static void initDefaultArray() {
    // Constant length
    final int ARRAY_LENGTH = 10;

    // Create new array and assign value
    int[] array = new int[ARRAY_LENGTH];
    for (int i = 0; i < ARRAY_LENGTH; i++) {
      // Assign even number
      array[i] = 2 + i * 2;
    }

    // Display all value
    printArray(array);
  }

  public static void printArray(int[] array) {
    // Store array length outside for loop to prevent re-evaluate every loop
    int length = array.length;

    // Display all value
    System.out.printf("%-8s%s\n", "Index", "Value");
    for (int i = 0; i < length; i++) {
      System.out.printf("%-8d%d\n", i, array[i]);
    }
  }
}
