package hust.soict.ictglobal.student;

import java.util.Scanner;

public class StudentTest {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter id: ");
    String id = input.nextLine();

    System.out.print("Enter name: ");
    String name = input.nextLine();

    Student student = new Student(id, name);

    System.out.print("Enter birthday: ");
    String birthday = input.nextLine();
    try {
      student.setBirthday(birthday);
    } catch (IllegalBirthDayFormatException e) {
      e.printStackTrace();
      return;
    }

    System.out.print("Enter gpa: ");
    float gpa = input.nextFloat();
    try {
      student.setGPA(gpa);
    } catch (IllegalGPAException e) {
      e.printStackTrace();
      return;
    }

    student.print();
    input.close();
  }
}
