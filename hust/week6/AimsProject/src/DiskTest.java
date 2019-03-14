public class DiskTest {
  public static void main(String[] args) {
    Order anOrder = new Order("1");
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("1", "The lion king", "Animation", 19.95f);

    dvd1.setDirector("Roger Allers");
    dvd1.setLength(87);
    anOrder.addMedia(dvd1);

    DigitalVideoDisc dvd2 = new DigitalVideoDisc("2", "Star Wars", "Science Fiction", 24.95f);
    dvd2.setDirector("George Lucas");
    dvd2.setLength(124);
    anOrder.addMedia(dvd2);

    DigitalVideoDisc dvd3 = new DigitalVideoDisc("3", "Aladdin", "Animation", 18.99f);
    dvd3.setDirector("John Musker");
    dvd3.setLength(90);
    anOrder.addMedia(dvd3);

    anOrder.getALuckyItem();
    anOrder.printOrder();
  }
}
