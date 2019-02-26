public class DateUtils {
  public static int compareDate(MyDate date1, MyDate date2) {
    if (date1.getYear() > date2.getYear()) {
      return 1;
    }

    if (date1.getYear() < date2.getYear()) {
      return -1;
    }

    if (date1.getMonth() > date2.getMonth()) {
      return 1;
    }

    if (date1.getMonth() < date2.getMonth()) {
      return -1;
    }

    if (date1.getDay() > date2.getDay()) {
      return 1;
    }

    if (date1.getDay() < date2.getDay()) {
      return -1;
    }

    return 0;
  }

  public static void sortDate(MyDate[] dateList) {
    
  }
}
