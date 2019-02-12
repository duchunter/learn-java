// SumArray.java - section 7.4
// Computing the sum of the elements of an array

public class SumArray {
  public static void main(String[] args) {
    // Init var
    int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
    int total = 0;
    int length = array.length;

    // Add each element's value to total
    for (int i = 0; i < length; i++) {
      total += array[i];
    }

    // Print result
    System.out.printf( "Total of array elements: %d\n", total );
  }
}
