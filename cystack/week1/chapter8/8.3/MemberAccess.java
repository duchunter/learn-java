// MemberAccess.java
// Show that accessing private member will throw an exception

public class MemberAccess {
  public static void main(String[] args) {
    Time1 time = new Time1();
    time.hour = 7;
    time.minute = 8;
    time.second = 9;
  }
}
