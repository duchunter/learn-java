// BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class try to access superclass protected field
// and not get error

public class BasePlusCommissionEmployee extends CommissionEmployee {
  private double baseSalary;

  // Constructor
  public BasePlusCommissionEmployee(
    String first, String last, String ssn,
    double sales, double rate, double salary
  ) {
    // Call superclass constructor
    super(first, last, ssn, sales, rate);

    // Validate and set base salary
    setBaseSalary(salary);
  }

  // Set base salary
  public void setBaseSalary(double salary) {
    if (salary >= 0.0) {
      baseSalary = salary;
    } else {
      throw new IllegalArgumentException("Base salary must be >= 0.0");
    }
  }

  // Get base salary
  public double getBaseSalary() {
    return baseSalary;
  }

  // Calculate earnings
  @Override
  public double earnings() {
    return baseSalary + (commissionRate * grossSales);
  }

  // Return String representation of CommissionEmployee Object
  @Override
  public String toString() {
    String name = String.format(
      "commission employee: %s %s\n", firstName, lastName
    );
    String ssn = String.format(
      "social security number: %s\n", socialSecurityNumber
    );
    String gSales = String.format("gross sales: %.2f\n", grossSales);
    String cRate = String.format("commission rate: %.2f\n", commissionRate);
    String bSalary = String.format("base salary: %.2f\n", baseSalary);

    return name + ssn + gSales + cRate + bSalary;
  }
}
