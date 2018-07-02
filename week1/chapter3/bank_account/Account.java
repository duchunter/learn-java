// Account.java
// Account class with a constructor to validate
// and initialize instance variable balance of type double

public class Account {
  private double balance;

  // Constructor
  public Account(double initialBalance) {
    if (initialBalance > 0.0) {
      balance = initialBalance;
    }
  }

  // Add an amount to account
  public void credit(double amount) {
    balance = balance + amount;
  }

  // Get balance
  public double getBalance() {
    return balance;
  }
}
