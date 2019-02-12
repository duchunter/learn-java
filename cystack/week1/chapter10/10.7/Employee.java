// Employee.java
// Employee abstract superclass

public abstract class Employee implements Payable {
  private String firstName;
  private String lastName;
  private String socialSecurityNumber;

  // Constructor
  public Employee(String first, String last, String ssn) {
    firstName = first;
    lastName = last;
    socialSecurityNumber = ssn;
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

  // Return String representation of Employee object
  @Override
  public String toString() {
    return String.format(
      "%s %s\nsocial security number: %s",
      getFirstName(), getLastName(), getSocialSecurityNumber()
    );
  }
}
