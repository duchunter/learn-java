// BasePlusCommissionEmployeeTest.java
// BasePlusCommissionEmployee class test program

public class BasePlusCommissionEmployeeTest {
  public static void main(String[] args) {
    // Create BasePlusCommissionEmployee object
    BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
      "Bob", "Lewis", "333-33-3333", 5000, .04, 300
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
    System.out.printf("Base salary is %s\n", employee.getBaseSalary());

    // Set new base salary
    employee.setBaseSalary(1000);

    // Display updated info using toString
    System.out.printf(
      "\nUpdated employee information obtained by toString:\n\n%s\n", employee
    );
  }
}
