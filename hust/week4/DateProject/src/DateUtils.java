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
    quickSort(dateList, 0, dateList.length - 1);
    System.out.println("List after sort:");
    for (int i = 0; i < dateList.length; i++) {
      dateList[i].print();
    }
  }

  private static void quickSort(MyDate[] dateList, int left, int right) {
    int i, j;
    MyDate pivot;
    MyDate temp;
    if (left < right) {
        i = left;
        j = right + 1;
        pivot = dateList[left];
        do {
            do {
                i++;
            } while (i < right && compareDate(dateList[i], pivot) == -1);

            do {
                j--;
            } while (j > left && compareDate(dateList[j], pivot) == 1);

            if (i < j) {
                temp = dateList[i];
                dateList[i] = dateList[j];
                dateList[j] = temp;
            }
        } while (i < j);

        temp = dateList[left];
        dateList[left] = dateList[j];
        dateList[j] = temp;
        quickSort(dateList, left, j - 1);
        quickSort(dateList, j + 1, right);
    }
  }
}
