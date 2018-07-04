// Fig. 7.13: PassArray.java
// Passing arrays and an individual array element to methods

public class PassArray {
  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5 };
    System.out.println(
      "Effects of passing reference to entire array:\n"
      + "The values of the original array are: "
    );

    // Output original array elements
    for (int value : array) {
      System.out.printf("%d   ", value);
    }

    // Pass array reference and modify
    modifyArray( array );

    // Output modified array elements
    System.out.println("\n\nThe values of the modified array are:");
    for (int value : array) {
      System.out.printf("%d   ", value);
    }

    System.out.printf(
      "\n\nEffects of passing array element value:\n"
      + "array[3] before modifyElement: %d\n",
      array[3]
    );

    // Attempt to modify array[3] by passing value
    modifyElement(array[3]);

    // Output value after modified
    System.out.printf("array[3] after modifyElement: %d\n", array[3]);
  }

  // Multiply each element of an array by 2
  public static void modifyArray(int[] array) {
    int length = array.length;
    for (int i = 0; i < length; i++) {
      array[i] *= 2;      
    }
  }

  // Multiply argument by 2
  public static void modifyElement(int element) {
    element *= 2;
    System.out.printf("Value of element in modifyElement: %d\n", element);
  }
}
