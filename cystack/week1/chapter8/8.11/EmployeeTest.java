// EmployeeTest.java
// Static member demonstration

public class EmployeeTest {
  public static void main(String[] args){
    // Show that count is 0 before creating Employees
    System.out.printf(
      "Employees before instantiation: %d\n", Employee.getCount()
    );

    // Create two Employees, count should be 2
    Employee e1 = new Employee("Susan", "Baker");
    Employee e2 = new Employee("Bob", "Blue");

    // Show that count is 2 after creating two Employees
    System.out.println("\nEmployees after instantiation: ");
    System.out.printf("via e1.getCount(): %d\n", e1.getCount());
    System.out.printf("via e2.getCount(): %d\n", e2.getCount());
    System.out.printf("via Employee.getCount(): %d\n", Employee.getCount());

    // Get names of Employees
    System.out.printf(
      "\nEmployee 1: %s %s", e1.getFirstName(), e1.getLastName()
    );
    System.out.printf(
      "\nEmployee 2: %s %s\n", e2.getFirstName(), e2.getLastName()
    );

    // Preparing for garbage collection
    e1 = null;
    e2 = null;
  }
}
