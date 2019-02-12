// PayrollSystemTest.java
// Employee hierarchy test program

public class PayrollSystemTest {
  public static void main(String[] args) {
    // Create subclass objects
    SalariedEmployee salaried = new SalariedEmployee(
      "John", "Smith", "111-11-1111", 800.00
    );
    HourlyEmployee hourly = new HourlyEmployee(
      "Karen", "Price", "222-22-2222", 16.75, 40
    );
    CommissionEmployee commission = new CommissionEmployee(
      "Sue", "Jones", "333-33-3333", 10000, .06
    );
    BasePlusCommissionEmployee basePlus = new BasePlusCommissionEmployee(
      "Bob", "Lewis", "444-44-4444", 5000, .04, 300
    );

    // Call earnings() individually
    System.out.println("Employees processed individually:\n");
    System.out.printf(
      "%s\nearned: $%,.2f\n\n", salaried, salaried.earnings()
    );
    System.out.printf(
      "%s\nearned: $%,.2f\n\n", hourly, hourly.earnings()
    );
    System.out.printf(
      "%s\nearned: $%,.2f\n\n", commission, commission.earnings()
    );
    System.out.printf(
      "%s\nearned: $%,.2f\n\n", basePlus, basePlus.earnings()
    );

    // Create Employee array and init with value
    Employee[] employees = new Employee[4];
    employees[0] = salaried;
    employees[1] = hourly;
    employees[2] = commission;
    employees[3] = basePlus;

    // Call earnings() polymorphically + raise salary for basePlus
    System.out.println("Employees processed polymorphically:\n");
    for (Employee currentEmployee : employees) {
      System.out.println(currentEmployee);

      // Determine whether element is a BasePlusCommissionEmployee
      if (currentEmployee instanceof BasePlusCommissionEmployee) {
        // Downcast Employee reference to BasePlusCommissionEmployee reference
        BasePlusCommissionEmployee employee;
        employee = (BasePlusCommissionEmployee) currentEmployee;

        // Increase base salary by 10%
        employee.setBaseSalary(1.10 * employee.getBaseSalary());
        System.out.printf(
          "new base salary with 10%% increase is: $%,.2f\n",
          employee.getBaseSalary()
        );
      }

      // Not BasePlusCommissionEmployee
      System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings());
    }

    // Get type name of each object in employees array
    for (int i = 0; i < employees.length; i++) {
      System.out.printf(
        "Employee %d is a %s\n", i, employees[i].getClass().getName()
      );
    }
  }
}
