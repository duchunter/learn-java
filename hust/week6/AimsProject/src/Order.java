import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
  // Attributes
  private int id;
  private static int nbOrders = 0;
  private List<Media> itemOrdered = new ArrayList<Media>();
  private LocalDate dateOrdered;

  // Constructor
  public Order() {
    super();
    LocalDate dateOrdered = LocalDate.now();
    this.dateOrdered = dateOrdered;
  }

  // Getter and Setter
  public LocalDate getDateOrdered() {
    return dateOrdered;
  }

  // METHODS

  // Print order
  public void printOrder() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

    System.out.println("****************Order*******************");
    System.out.println("Date: " + this.dateOrdered.format(formatter));
    System.out.println("Ordered items:");
    for (Media media : itemOrdered) {
      System.out.printf(
        "- %s - %s: %f$ %s\n",
        media.getTitle(),
        media.getCategory(),
        media.getCost(),
        media.getIsFree() ? "(free)" : ""
      );
    }
    System.out.println("Total cost: " + totalCost() + '$');
    System.out.println("****************************************\n");
  }

  // Add
  public void addMedia(Media media) {
    if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
      System.out.println("List is full");
      return;
    }

    this.itemOrdered.add(media);
    this.qtyOrdered += 1;
    System.out.println(media.getTitle() + " added");
  }

  // Remove
  public void removeMedia(Media media) {
    if (this.qtyOrdered == 0) {
      System.out.println("List is empty");
      return;
    }

    // Find media and remove
    String title = media.getTitle();
    for (Media med : itemOrdered) {
      if (med.getTitle() == title) {
        this.itemOrdered.remove(med);
        this.qtyOrdered -= 1;
        System.out.println(title + " removed");
        return;
      }
    }

    System.out.println(title + " not exists");
  }

  // Cost
  public float totalCost() {
    float total = 0;
    for (Media media : this.itemOrdered) {
      if (!media.getIsFree()) {
        total += media.getCost();
      }
    }

    return total;
  }

  // Get a lucky item
  public DigitalVideoDisc getALuckyItem() {
    int luckyIndex = (int)(this.nbOrders * Math.random());
    this.itemOrdered[luckyIndex].setIsFree(true);
    return this.itemOrdered[luckyIndex];
  }
}
