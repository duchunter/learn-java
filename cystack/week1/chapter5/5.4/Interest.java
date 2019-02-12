// Interest.java
// Compound-interest calculations with for

public class Interest {
  public static void main(String[] args) {
    // Init var
    double amount;
    double rate = 0.05;
    double principal = 1000;

    // Display header
    System.out.printf("%4s%20s\n", "Year", "Amount");

    // Output for each year
    for (int year = 1; year <= 10; year++) {
      amount = principal * Math.pow(1 + rate, year);
      System.out.printf("%4d%,20.2f\n", year, amount);
    }
  }
}
