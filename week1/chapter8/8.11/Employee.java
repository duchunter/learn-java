// Employee.java
// Static variable used to maintain a count of the number of
// Employee objects in memory.

public class Employee
{
  // Fields
  private String firstName;
  private String lastName;
  private static int employeeCount = 0;

  // Constructor
  public Employee(String first, String last) {
    firstName = first;
    lastName = last;
    employeeCount++;
  }

  // Get first name
  public String getFirstName() {
    return firstName;
  }

  // Get last name
  public String getLastName() {
    return lastName;
  }

  // Get count
  public static int getCount() {
    return employeeCount;
  }
}
