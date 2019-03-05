import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
  // Attributes
  public static final int MAX_NUMBERS_ORDERED = 10;
  private static int nbOrders = 0;
  private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered = 0;
  private LocalDate dateOrdered;

  // Constructor
  public Order() {
    super();
    LocalDate dateOrdered = LocalDate.now();
    this.dateOrdered = dateOrdered;
    nbOrders += 1;
  }

  // Getter and Setter
  // nbOrders
  public static int getNbOrders() {
    return nbOrders;
  }

  // dateOrdered
  public LocalDate getDateOrdered() {
    return dateOrdered;
  }

  public void setDateOrdered(LocalDate dateOrdered) {
    this.dateOrdered = dateOrdered;
  }

  // qtyOrdered
  public int getQtyOrdered() {
    return qtyOrdered;
  }

  public void setQtyOrdered(int qtyOrdered) {
    this.qtyOrdered = qtyOrdered;
  }

  // METHODS

  // Print order
  public void printOrder() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

    System.out.println("****************Order*******************");
    System.out.println("Date: " + this.dateOrdered.format(formatter));
    System.out.println("Ordered items:");
    for (int i = 0; i < qtyOrdered; i++) {
      System.out.printf(
        "%d. DVD - %s - %s - %s - %d: %f$ %s\n",
        i + 1,
        itemOrdered[i].getTitle(),
        itemOrdered[i].getCategory(),
        itemOrdered[i].getDirector(),
        itemOrdered[i].getLength(),
        itemOrdered[i].getCost(),
        itemOrdered[i].getIsFree() ? "(free)" : ""
      );
    }
    System.out.println("Total cost: " + totalCost() + '$');
    System.out.println("****************************************\n");
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

  public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    int length = dvdList.length;
    if (this.qtyOrdered + length > MAX_NUMBERS_ORDERED) {
      System.out.println(
        "List is full, remaining: "
        + (MAX_NUMBERS_ORDERED - this.qtyOrdered)
        + " slots"
      );
      return;
    }

    for (int i = 0; i < length; i++) {
      this.addDigitalVideoDisc(dvdList[i]);
    }
  }

  public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc... dvdList) {
    int length = dvdList.length;
    if (this.qtyOrdered + length + 1 > MAX_NUMBERS_ORDERED) {
      System.out.println(
        "List is full, remaining: "
        + (MAX_NUMBERS_ORDERED - this.qtyOrdered)
        + " slots"
      );
      return;
    }

    this.addDigitalVideoDisc(disc1);
    this.addDigitalVideoDisc(dvdList);
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
      if (!this.itemOrdered[i].getIsFree()) {
        total += this.itemOrdered[i].getCost();
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
