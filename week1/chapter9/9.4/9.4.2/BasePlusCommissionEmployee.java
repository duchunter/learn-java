// BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class represents an employee who receives
// a base salary in addition to commission

public class BasePlusCommissionEmployee extends Object {
  private String firstName;
  private String lastName;
  private String socialSecurityNumber;
  private double grossSales;
  private double commissionRate;
  private double baseSalary;

  // Constructor
  public BasePlusCommissionEmployee(
    String first, String last, String ssn,
    double sales, double rate, double salary
  ) {
    firstName = first;
    lastName = last;
    socialSecurityNumber = ssn;

    // Validate and store grossSales + commissionRate + baseSalary
    setGrossSales(sales);
    setCommissionRate(rate);
    setBaseSalary(salary);
  }

  // Set first name
  public void setFirstName(String first) {
    firstName = first;
  }

  // Get first name
  public String getFirstName() {
    return firstName;
  }

  // Set last name
  public void setLastName(String last) {
    lastName = last;
  }

  // Get last name
  public String getLastName() {
    return lastName;
  }

  // Set social security number
  public void setSocialSecurityNumber(String ssn) {
    socialSecurityNumber = ssn;
  }

  // Get social security number
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  // Set gross sales amount
  public void setGrossSales(double sales) {
    if (sales >= 0.0) {
      grossSales = sales;
    } else {
      throw new IllegalArgumentException("Gross sales must be >= 0.0");
    }
  }

  // Get gross sales amount
  public double getGrossSales() {
    return grossSales;
  }

  // Set commission rate
  public void setCommissionRate(double rate) {
    if (rate > 0.0 && rate < 1.0) {
      commissionRate = rate;
    } else {
      throw new IllegalArgumentException(
        "Commission rate must be > 0.0 and < 1.0"
      );
    }
  }

  // Get commission rate
  public double getCommissionRate() {
    return commissionRate;
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
