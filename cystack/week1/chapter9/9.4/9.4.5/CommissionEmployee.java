// CommissionEmployee.java
// CommissionEmployee class represents an employee paid a
// percentage of gross sales

public class CommissionEmployee extends Object {
  private String firstName;
  private String lastName;
  private String socialSecurityNumber;
  private double grossSales;
  private double commissionRate;

  // Constructor
  public CommissionEmployee(
    String first, String last, String ssn, double sales, double rate
  ) {
    firstName = first;
    lastName = last;
    socialSecurityNumber = ssn;

    // Validate and store grossSales + commissionRate
    setGrossSales(sales);
    setCommissionRate(rate);
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

  // Calculate earnings
  public double earnings() {
    return getCommissionRate() * getGrossSales();
  }

  // Return String representation of CommissionEmployee Object
  @Override
  public String toString() {
    String name = String.format(
      "commission employee: %s %s\n", getFirstName(), getLastName()
    );
    String ssn = String.format(
      "social security number: %s\n", getSocialSecurityNumber()
    );
    String gSales = String.format("gross sales: %.2f\n", getGrossSales());
    String cRate = String.format(
      "commission rate: %.2f\n", getCommissionRate()
    );

    return name + ssn + gSales + cRate;
  }
}
