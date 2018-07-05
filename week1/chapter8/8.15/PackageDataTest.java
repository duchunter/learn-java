// Fig. 8.17: PackageDataTest.java
// Package-access members of a class are accessible by other classes
// in the same package.

public class PackageDataTest {
  public static void main( String[] args ) {
    PackageData packageData = new PackageData();

    // Output String representation of packageData
    System.out.printf("After instantiation:\n%s\n", packageData);

    // Change package access data in packageData object
    packageData.number = 77;
    packageData.string = "Goodbye";

    // Output String representation of packageData
    System.out.printf("\nAfter changing values:\n%s\n", packageData);
  }
}

// Class with package access instance variables
class PackageData {
  int number;
  String string;

  // Constructor
  public PackageData() {
    number = 0;
    string = "Hello";
  }

  // Return PackageData object String representation
  public String toString() {
    return String.format("number: %d; string: %s", number, string);
  }
}
