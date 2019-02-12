import java.util.Scanner;
import java.util.Date;

import java.time.LocalDate;
import java.time.ZoneId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class DaysOfMonth {
  public static void main(String[] args) {
    Date date;
    Scanner input = new Scanner(System.in);
    String dateString;

    // Create input format
    DateFormat format = new SimpleDateFormat("MM/yyyy");
    format.setLenient(false);

    // Loop until user enter a valid month + year
    System.out.print("Enter month and year (MM/yyyy): ");
    while (true) {
      dateString = input.nextLine();
      try {
          date = format.parse(dateString);
          break;
      } catch (ParseException e) {
          System.out.print("Invalid month/year, try again (MM/yyyy): ");
      }
    }

    // Parse Date to LocalDate to get days in month
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int days = localDate.lengthOfMonth();

    // Result
    System.out.println("Days of month: " + days);
    System.exit(0);
  }
}
