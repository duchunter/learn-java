// Employee.java
// Employee class with references to other objects

public class Employee
{
  // Fields
  private String firstName;
  private String lastName;
  private Date birthDate;
  private Date hireDate;

  // Constructor
  public Employee(String fName, String lName, Date bDate, Date hDate) {
    firstName = fName;
    lastName = lName;
    birthDate = bDate;
    hireDate = hDate;
  }

  // convert to String format
  public String toString() {
    return String.format(
      "%s, %s Hired: %s Birthday: %s", lastName, firstName, hireDate, birthDate
    );
  }
}
