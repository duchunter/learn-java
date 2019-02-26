public class DateTest {
  public static void main(String[] args) {
    // BASIC TEST
    // System.out.println("\n\tBASIC TEST\n");
    // System.out.println("* Init from current date:");
    // MyDate date1 = new MyDate();
    // date1.print();
    // date1.accept();
    // date1.print();
    // System.out.println("Current month: " + date1.getMonth());
    // date1.setDay(31);
    // System.out.println("Current day: " + date1.getDay());
    // date1.print();
    // date1.setMonth(20);
    // date1.setYear(-1);
    // date1.setDay(19);
    // System.out.println("Current day: " + date1.getDay());
    //
    // System.out.println("\n* Init from 3 params (100, 100, 100):");
    // MyDate date2 = new MyDate(100, 100, 100);
    // date2.print();
    // System.out.println("Current day: " + date2.getDay());
    //
    // System.out.println("\n* Init from string '100/100/100':");
    // MyDate date3 = new MyDate("100/100/100");
    // date3.print();
    // System.out.println("Current day: " + date3.getDay());

    // OVERLOAD SET MONTH TEST
    System.out.println("\n\tOVERLOAD SET MONTH TEST\n");
    MyDate date4 = new MyDate();
    date4.print();
    date4.setMonth("November");
    date4.print("dd/mm/yyy");
    date4.setMonth("Nov");
    date4.print("dd/MM/yyy");

    // SORT DATE TEST
    MyDate date1 = new MyDate("1/10/1990");
    MyDate date2 = new MyDate("1/10/1990");
    MyDate date3 = new MyDate("10/1/1998");
    System.out.println("Compare date1 with date2 return " + DateUtils.compareDate(date1, date2));
    System.out.println("Compare date1 with date3 return " + DateUtils.compareDate(date1, date3));
    System.out.println("Compare date4 with date3 return " + DateUtils.compareDate(date4, date3));

    MyDate[] dateList = { date4, date2, date1, date4, date3, date2 };
    DateUtils.sortDate(dateList);
  }
}
