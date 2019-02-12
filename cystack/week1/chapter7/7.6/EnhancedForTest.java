// EnhancedForTest.java - section 7.6
// Using the enhanced for statement to calculate sum of integers in an array

public class EnhancedForTest {
  public static void main(String[] args) {
    int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
    int total = 0;

    // Add each element's value to total
    for (int number : array) {
      total += number;
    }

    // Output result
    System.out.printf("Total of array elements: %d\n", total);
  }
}
