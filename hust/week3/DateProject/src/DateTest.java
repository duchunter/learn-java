public class DateTest {
  public static void main(String[] args) {
    System.out.println("* Init from current date:");
    MyDate date1 = new MyDate();
    date1.print();
    date1.accept();
    date1.print();
    System.out.println("Current month: " + date1.getMonth());
    date1.setDay(31);
    System.out.println("Current day: " + date1.getDay());
    date1.print();
    date1.setMonth(20);
    date1.setYear(-1);
    date1.setDay(19);
    System.out.println("Current day: " + date1.getDay());

    System.out.println("\n* Init from 3 params (100, 100, 100):");
    MyDate date2 = new MyDate(100, 100, 100);
    date2.print();
    System.out.println("Current day: " + date2.getDay());

    System.out.println("\n* Init from string '100/100/100':");
    MyDate date3 = new MyDate("100/100/100");
    date3.print();
    System.out.println("Current day: " + date3.getDay());
  }
}
