import java.util.Arrays;

public class NumericArray {
  public static void main(String[] args) {
    int arr[] = { 1789, 2035, 1899, 1456, 2013 };

    Arrays.sort(arr);
    int sum = Arrays.stream(arr).sum();
    double avg = Arrays.stream(arr).average().orElse(Double.NaN);

    System.out.println("Sorted array: " + Arrays.toString(arr));
    System.out.println("Sum: " + sum);
    System.out.println("Average value: " + avg);
  }
}
