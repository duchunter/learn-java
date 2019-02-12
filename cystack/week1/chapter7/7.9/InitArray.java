// InitArray.java - section 7.9
// Initializing two-dimensional array and display value by row

public class InitArray {
  public static void main(String[] args) {
    int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] array2 = { { 1, 2 }, { 3 }, { 4, 5, 6 } };

    // Display array1
    System.out.println("Values in array1 by row are");
    outputArray(array1);

    // Display array2
    System.out.println("\nValues in array2 by row are");
    outputArray(array2);
  }

  // Output rows and columns of a two-dimensional array
  public static void outputArray(int[][] array) {
    // Loop through array's rows
    for (int row = 0; row < array.length; row++) {
      // Loop through columns of current row
      for (int column = 0; column < array[row].length; column++) {
        System.out.printf("%d ", array[row][column]);
      }

      // Start new line of output
      System.out.println();
    }
  }
}
