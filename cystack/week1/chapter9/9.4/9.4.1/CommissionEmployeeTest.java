// CommissionEmployeeTest.java
// CommissionEmployee class test program

public class CommissionEmployeeTest {
  public static void main(String[] args) {
    // Create CommissionEmployee object
    CommissionEmployee employee = new CommissionEmployee(
      "Sue", "Jones", "222-22-2222", 10000, .06
    );

    // Get commission employee data
    System.out.println("Employee information obtained by get methods: \n");
    System.out.printf("First name is %s\n", employee.getFirstName());
    System.out.printf("Last name is %s\n", employee.getLastName());
    System.out.printf(
      "Social security number is %s\n", employee.getSocialSecurityNumber()
    );
    System.out.printf("Gross sales is %.2f\n", employee.getGrossSales());
    System.out.printf(
      "Commission rate is %.2f\n", employee.getCommissionRate()
    );

    // Set new grossSales and commissionRate
    employee.setGrossSales(500);
    employee.setCommissionRate(.1);

    // Display updated info using toString
    System.out.printf(
      "\nUpdated employee information obtained by toString:\n\n%s\n", employee
    );
  }
}
