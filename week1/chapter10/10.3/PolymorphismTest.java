// PolymorphismTest.java
// Test assigning superclass and subclass references to superclass and
// subclass variables, then assign subclass reference to superclass variable

public class PolymorphismTest {
  public static void main(String[] args) {
    // Assign superclass reference to superclass variable
    CommissionEmployee commission = new CommissionEmployee(
      "Sue", "Jones", "222-22-2222", 10000, .06
    );

    // Assign subclass reference to subclass variable
    BasePlusCommissionEmployee basePlus = new BasePlusCommissionEmployee(
      "Bob", "Lewis", "333-33-3333", 5000, .04, 300
    );

    // Assign subclass reference to superclass variable
    CommissionEmployee commission2 = basePlus;

    // Invoke toString on superclass object using superclass variable
    System.out.print("Call CommissionEmployee's toString ");
    System.out.print("with superclass reference to superclass object:\n\n");
    System.out.print(commission.toString());
    System.out.print("\n\n");

    // Invoke toString on subclass object using subclass variable
    System.out.print("Call BasePlusCommissionEmployee's toString ");
    System.out.print("with subclass reference to subclass object:\n\n");
    System.out.print(basePlus.toString());
    System.out.print("\n\n");

    // Invoke toString on subclass object using superclass variable
    System.out.print("Call BasePlusCommissionEmployee's toString ");
    System.out.print("with superclass reference to subclass object:\n\n");
    System.out.print(commission2.toString());
    System.out.print("\n\n");
  }
}
