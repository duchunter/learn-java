// ArrayListCollection.java
// ArrayList<T> collection demonstration

import java.util.ArrayList;

public class ArrayListCollection {
  public static void main(String[] args) {
    // Create a new ArrayList of Strings with an initial capacity of 10
    ArrayList< String > items = new ArrayList< String >();

    // Append an item to the list
    items.add("red");

    // Insert the value at index 0
    items.add(0, "yellow");

    // Display the colors in the list using counter method
    System.out.print("Display list contents with counter-controlled loop:");
    for (int i = 0; i < items.size(); i++) {
      System.out.printf(" %s", items.get(i));
    }

    // Display colors using enhanced for in the display method
    display(items, "\nDisplay list contents with enhanced for statement:");

    // Add 2 new elements and display
    items.add("green");
    items.add("yellow");
    display(items, "List with two new elements:");

    // Remove 'yellow' and display
    items.remove("yellow");
    display(items, "Remove first instance of yellow:");

    // Remove item at index 1 and display
    items.remove(1);
    display(items, "Remove second list element (green):");

    // Check if a value is in the List
    System.out.printf(
      "'red' is %sin the list\n", items.contains("red") ? "": "not "
    );

    // Display number of elements in the List
    System.out.printf("Size: %s\n", items.size());
  }

  // Display the ArrayList's elements
  public static void display(ArrayList< String > items, String header) {
    // Display header
    System.out.print(header);

    // Display each element in items
    for (String item : items) {
      System.out.printf(" %s", item);
    }

    // Line break
    System.out.println();
  }
}
