// BarChart.java - section 7.4
// Bar chart printing program based on grade distribution

public class BarChart {
  public static void main(String[] args) {
    // Init array
    int[] array = { 0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1 };
    int length = array.length;

    // Draw bar chart
    System.out.println( "Grade distribution:" );
    for (int i = 0; i < length; i++) {
      // Output bar label ("00-09: ", ..., "90-99: ", "100: ")
      if (i == 10) {
        System.out.printf("%5d: ", 100);
      } else {
        System.out.printf("%02d-%02d: ", (i * 10), (i * 10 + 9));
      }

      // Print bar using *
      for (int stars = 0; stars < array[i]; stars++) {
        System.out.print("*");
      }

      // Start a new line of output
      System.out.println();
    }
  }
}
