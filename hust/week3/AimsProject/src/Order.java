public class Order {
  // Attributes
  public static final int MAX_NUMBERS_ORDERED = 10;
  private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered = 0;

  // Constructor
  public Order() {
    super();
  }

  // Getter and Setter
  // qtyOrdered
  public int getQtyOrdered() {
    return qtyOrdered;
  }

  public void setQtyOrdered(int qtyOrdered) {
    this.qtyOrdered = qtyOrdered;
  }

  // Methods

  // Print order
  public void printOrder() {
    System.out.println("Order list:");
    for (int i = 0; i < qtyOrdered; i++) {
      System.out.println(
        "- " + itemOrdered[i].getTitle() + " " + itemOrdered[i].getCost()
      );
    }
  }

  // Add
  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
      System.out.println("List is full");
      return;
    }

    this.itemOrdered[this.qtyOrdered] = disc;
    this.qtyOrdered += 1;
    System.out.println(disc.getTitle() + " added");
  }

  // Remove
  public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    if (this.qtyOrdered == 0) {
      System.out.println("List is empty");
      return;
    }

    // Find index
    int index;
    String title = disc.getTitle();
    for (index = 0; index < qtyOrdered; index++) {
      if (this.itemOrdered[index].getTitle() == title) {
        break;
      }
    }

    if (index == qtyOrdered) {
      System.out.println(title + " not exists");
    }

    // Remove index
    DigitalVideoDisc newList[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    System.arraycopy(itemOrdered, 0, newList, 0, index);
    System.arraycopy(
      itemOrdered,
      index + 1,
      newList,
      index,
      this.qtyOrdered - index - 1
    );

    this.qtyOrdered -= 1;
    this.itemOrdered = newList;
  }

  // Cost
  public float totalCost() {
    float total = 0;
    for (int i = 0; i < this.qtyOrdered; i++) {
      total += this.itemOrdered[i].getCost();
    }

    return total;
  }
}
