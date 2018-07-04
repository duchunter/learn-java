// ArrayManipulations.java - section 7.13
// Test Arrays class methods and System.arraycopy.

import java.util.Arrays;

public class ArrayManipulations {
  public static void main(String[] args) {
    // Sort doubleArray in ascending order
    double[] doubleArray = { 8.4, 9.3, 0.2, 7.9, 3.4 };
    Arrays.sort(doubleArray);
    displayArray(doubleArray, "doubleArray");

    // Fill 10-element array with 7s
    int[] filledIntArray = new int[10];
    Arrays.fill(filledIntArray, 7);
    displayArray(filledIntArray, "filledIntArray");

    // Copy intArray into intArrayCopy
    int[] intArray = { 1, 2, 3, 4, 5, 6 };
    int[] intArrayCopy = new int[intArray.length];
    System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
    displayArray(intArray, "intArray");
    displayArray(intArrayCopy, "intArrayCopy");

    // Compare intArray and intArrayCopy for equality
    boolean b = Arrays.equals(intArray, intArrayCopy);
    System.out.printf("\n\nintArray %s intArrayCopy\n", (b ? "==" : "!="));

    // Compare intArray and filledIntArray for equality
    b = Arrays.equals(intArray, filledIntArray);
    System.out.printf("intArray %s filledIntArray\n", (b ? "==" : "!="));

    // Search intArray for the value 5
    int location = Arrays.binarySearch(intArray, 5);
    if (location >= 0) {
      // Found
      System.out.printf("Found 5 at element %d in intArray\n", location);
    } else {
      // Not found
      System.out.println("5 not found in intArray");
    }

    // Search intArray for the value 123
    location = Arrays.binarySearch(intArray, 123);
    if (location >= 0) {
      // Found
      System.out.printf("Found 123 at element %d in intArray\n", location);
    } else {
      // Not found
      System.out.println("123 not found in intArray");
    }
  }

  // Output values in each array (int version)
  public static void displayArray(int[] array, String description) {
    System.out.printf("\n%s: ", description);
    for (int value : array) {
      System.out.printf("%d ", value);
    }
  }

  // Output values in each array (double version)
  public static void displayArray(double[] array, String description) {
    System.out.printf("\n%s: ", description);
    for (double value : array) {
      System.out.printf("%.1f ", value);
    }
  }
}
