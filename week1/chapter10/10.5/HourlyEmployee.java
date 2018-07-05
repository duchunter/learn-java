// HourlyEmployee.java
// HourlyEmployee class extends Employee

public class HourlyEmployee extends Employee {
  private double wage;
  private double hours;

  // Constructor
  public HourlyEmployee(
    String first, String last, String ssn,
    double hourlyWage, double hoursWorked
  ) {
    super(first, last, ssn);
    setWage(hourlyWage);
    setHours(hoursWorked);
  }

  // Set wage
  public void setWage(double hourlyWage) {
    if (hourlyWage >= 0.0) {
      wage = hourlyWage;
    } else {
      throw new IllegalArgumentException("Hourly wage must be >= 0.0");
    }
  }

  // Get wage
  public double getWage() {
    return wage;
  }

  // Set hours worked
  public void setHours(double hoursWorked) {
    if ((hoursWorked >= 0.0) && (hoursWorked <= 168.0)) {
      hours = hoursWorked;
    } else {
      throw new IllegalArgumentException(
        "Hours worked must be >= 0.0 and <= 168.0"
      );
    }
  }

  // Return hours worked
  public double getHours() {
    return hours;
  }

  // calculate earnings; override abstract method earnings in Employee
  @Override
  public double earnings() {
    double hoursWorked = getHours();
    double wagePerHour = getWage();

    // No overtime
    if (hoursWorked <= 40) {
      return wagePerHour * hoursWorked;
    }

    // Overtime
    return 40 * wagePerHour + (hoursWorked - 40) * wagePerHour * 1.5;
  }

  // Return String representation of HourlyEmployee object
  @Override
  public String toString() {
    String info = String.format("hourly employee: %s\n", super.toString());
    String hourlyWage = String.format("hourly wage: %.2f\n", getWage());
    String hoursWorked = String.format("hours worked: %.2f\n", getHours());

    return info + hourlyWage + hoursWorked;
  }
}
