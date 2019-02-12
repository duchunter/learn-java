// Invoice.java
// Invoice class that implements Payable

public class Invoice implements Payable {
  private String partNumber;
  private String partDescription;
  private int quantity;
  private double pricePerItem;

  // Constructor
  public Invoice(String part, String description, int count, double price) {
    partNumber = part;
    partDescription = description;
    setQuantity(count);
    setPricePerItem(price);
  }

  // Set part number
  public void setPartNumber(String part) {
    partNumber = part;
  }

  // Get part number
  public String getPartNumber() {
    return partNumber;
  }

  // Set description
  public void setPartDescription(String description) {
    partDescription = description;
  }

  // Get description
  public String getPartDescription() {
    return partDescription;
  }

  // Set quantity
  public void setQuantity(int count) {
    if (count >= 0) {
      quantity = count;
    } else {
      throw new IllegalArgumentException("Quantity must be >= 0");
    }
  }

  // Get quantity
  public int getQuantity() {
    return quantity;
  }

  // Set price per item
  public void setPricePerItem(double price) {
    if (price >= 0.0) {
      pricePerItem = price;
    } else {
      throw new IllegalArgumentException("Price per item must be >= 0");
    }
  }

  // Get price per item
  public double getPricePerItem() {
    return pricePerItem;
  }

  // Return String representation of Invoice object
  @Override
  public String toString() {
    String info = String.format(
      "part number: %s (%s)\n", getPartNumber(), getPartDescription()
    );
    String qty = String.format("quantity: %d\n", getQuantity());
    String price = String.format("price per item: %,.2f", getPricePerItem());

    return "invoice:\n" + info + qty + price;
  }

  // Method required to carry out contract with interface Payable
  @Override
  public double getPaymentAmount() {
    return getQuantity() * getPricePerItem();
  }
}
