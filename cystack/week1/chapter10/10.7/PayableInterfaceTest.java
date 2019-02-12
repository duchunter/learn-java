// PayableInterfaceTest.java
// Tests interface Payable

public class PayableInterfaceTest {
  public static void main( String[] args ) {
    // Create Payable array and populate with objects that implement Payable
    Payable[] payableObjects = new Payable[4];

    // Populate with Invoice objects
    payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
    payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);

    // Populate with Employee objects
    payableObjects[2] = new SalariedEmployee(
      "John", "Smith", "111-11-1111", 800.00
    );
    payableObjects[3] = new SalariedEmployee(
      "Lisa", "Barnes", "888-88-8888", 1200.00
    );

    // Process each element in array payableObjects
    System.out.println("Invoices and Employees processed polymorphically:\n");
    for (Payable currentPayable : payableObjects) {
      // Output currentPayable info
      System.out.println(currentPayable.toString());

      // Output payment amount
      System.out.printf(
        "payment due: $%,.2f\n\n", currentPayable.getPaymentAmount()
      );
    }
  }
}
