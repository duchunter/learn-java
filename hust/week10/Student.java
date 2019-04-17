package hust.soict.ictglobal.student;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Student {
  private String studentID;
  private String studentName;
  private String birthday;
  private float gpa;

  public Student(String studentID, String studentName) {
    this.studentID = studentID;
    this.studentName = studentName;
  }

  public String getStudentID() {
    return studentID;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public String getName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) throws IllegalBirthDayFormatException {
    try {
      DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      format.setLenient(false);
      Date date = format.parse(birthday);
      this.birthday = birthday;
    } catch (ParseException e) {
      throw(new IllegalBirthDayFormatException());
    }
  }

  public float getGPA() {
    return gpa;
  }

  public void setGPA(float gpa) throws IllegalGPAException {
    if (gpa < 0 || gpa > 10) {
      throw(new IllegalGPAException());
    } else {
      this.gpa = gpa;
    }
  }

  public void print() {
    System.out.println("ID: " + studentID);
    System.out.println("Name: " + studentName);
    System.out.println("Birthday: " + birthday);
    System.out.println("GPA: " + gpa);
  }
}
