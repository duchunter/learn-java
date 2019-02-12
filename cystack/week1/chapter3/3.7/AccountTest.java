// AccountTest.java
// Input and output float numbers with Account obj

import java.util.Scanner;

public class AccountTest {
  public static void main(String[] args) {
    // Create new obj
    Account acc1 = new Account(50);
    Account acc2 = new Account(-7.3);

    // Get initial balance
    System.out.printf("Account1 balance: $%2f\n", acc1.getBalance());
    System.out.printf("Account2 balance: $%2f\n", acc2.getBalance());

    // Add an amount to account 1
    Scanner input = new Scanner(System.in);
    double depositAmount;
    System.out.print("\nEnter deposit amount for account 1: ");
    depositAmount = input.nextDouble();
    acc1.credit(depositAmount);

    // Print balance
    System.out.printf("\nAccount1 balance: $%2f\n", acc1.getBalance());
    System.out.printf("Account2 balance: $%2f\n", acc2.getBalance());

    // Add an amount to account 2
    System.out.print("\nEnter deposit amount for account 2: ");
    depositAmount = input.nextDouble();
    acc2.credit(depositAmount);

    // Print balance
    System.out.printf("\nAccount1 balance: $%2f\n", acc1.getBalance());
    System.out.printf("Account2 balance: $%2f\n", acc2.getBalance());
  }
}
