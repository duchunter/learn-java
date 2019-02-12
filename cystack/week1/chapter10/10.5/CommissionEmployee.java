// CommissionEmployee.java
// CommissionEmployee class extends Employee

public class CommissionEmployee extends Employee {
  private double grossSales;
  private double commissionRate;

  // Constructor
  public CommissionEmployee(
    String first, String last, String ssn, double sales, double rate
  ) {
    super(first, last, ssn);
    setGrossSales(sales);
    setCommissionRate(rate);
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
  @Override
  public double earnings() {
    return getCommissionRate() * getGrossSales();
  }

  // Return String representation of CommissionEmployee Object
  @Override
  public String toString() {
    String info = String.format("commission employee: %s\n", super.toString());
    String gSales = String.format("gross sales: %.2f\n", getGrossSales());
    String cRate = String.format(
      "commission rate: %.2f\n", getCommissionRate()
    );

    return info + gSales + cRate;
  }
}
