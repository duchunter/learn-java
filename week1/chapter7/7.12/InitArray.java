// InitArray.java
// Initializing an array using command-line arguments

public class InitArray {
  public static void main(String[] args) {
    // Check number of arguments
    if (args.length != 3) {
      System.out.println(
        "Error: Please re-enter the entire command, including\n"
        + "an array size, initial value and increment."
      );
    }

    // Ok
    else {
      // Get array size from the first argument and create array
      int arrayLength = Integer.parseInt(args[0]);
      int[] array = new int[arrayLength];

      // Get initial value and increment from the next arguments
      int initialValue = Integer.parseInt(args[1]);
      int increment = Integer.parseInt(args[2]);

      // Assign each array element
      for (int i = 0; i < arrayLength; i++) {
        array[i] = initialValue + increment * i;
      }

      // Display array index and value
      System.out.printf("%s%8s\n", "Index", "Value");
      for (int i = 0; i < arrayLength; i++) {
        System.out.printf("%5d%8d\n", i, array[i]);
      }
    }
  }
}
