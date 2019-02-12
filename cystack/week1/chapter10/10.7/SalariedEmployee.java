// SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee

public class SalariedEmployee extends Employee {
  private double weeklySalary;

  // Constructor
  public SalariedEmployee(
    String first, String last, String ssn, double salary
  ) {
    super(first, last, ssn);
    setWeeklySalary( salary );
  }

  // Set salary
  public void setWeeklySalary(double salary) {
    if (salary >= 0.0) {
      weeklySalary = salary;
    } else {
      throw new IllegalArgumentException("Weekly salary must be >= 0.0");
    }
  }

  // Get weekly salary
  public double getWeeklySalary() {
    return weeklySalary;
  }

  // Calculate earnings override abstract method earnings in Employee
  @Override
  public double getPaymentAmount() {
    return getWeeklySalary();
  }

  // Return String representation of SalariedEmployee object
  @Override
  public String toString() {
    String info = String.format("salaried employee: %s\n", super.toString());
    String salary = String.format("weekly salary: %.2f\n", getWeeklySalary());

    return info + salary;
  }
}
