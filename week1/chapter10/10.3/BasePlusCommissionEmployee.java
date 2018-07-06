// BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class that extends CommissionEmployee

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
    return getBaseSalary() + super.earnings();
  }

  // Return String representation of CommissionEmployee Object
  @Override
  public String toString() {
    String bSalary = String.format("base salary: %.2f\n", getBaseSalary());

    return super.toString() + bSalary;
  }
}
