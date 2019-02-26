public class Aims {
  private static final int MAX_LIMITTED_ORDERS = 2;

  public static void main(String[] args) {
    // Test basic object function and constructor
    System.out.println("\n\tBASIC TEST\n");
    Order anOrder = new Order();
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king");
    dvd1.setCategory("Animation");
    dvd1.setCost(19.95f);
    dvd1.setDirector("Roger Allers");
    dvd1.setLength(87);
    anOrder.addDigitalVideoDisc(dvd1);

    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
    dvd2.setCategory("Science Fiction");
    dvd2.setCost(24.95f);
    dvd2.setDirector("George Lucas");
    dvd2.setLength(124);
    anOrder.addDigitalVideoDisc(dvd2);

    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
    dvd3.setCategory("Animation");
    dvd3.setCost(18.99f);
    dvd3.setDirector("John Musker");
    dvd3.setLength(90);
    anOrder.addDigitalVideoDisc(dvd3);

    anOrder.removeDigitalVideoDisc(dvd2);
    anOrder.printOrder();

    // Test method overload
    System.out.println("\n\tMETHOD OVERLOAD TEST\n");
    DigitalVideoDisc[] dvdList = { dvd1, dvd2, dvd3 };
    anOrder.addDigitalVideoDisc(dvdList);
    anOrder.printOrder();

    anOrder.addDigitalVideoDisc(dvd2, dvd3, dvd1, dvd3, dvd2, dvd1);
    anOrder.printOrder();

    System.out.println("Total cost: " + anOrder.totalCost());

    // Test class member
    System.out.println("\n\tCLASS MEMBER TEST\n");
    Order order1;
    if (Order.getNbOrders() > MAX_LIMITTED_ORDERS) {
      System.out.println("Cannot create new order");
    } else {
      order1 = new Order();
      order1.printOrder();
    }

    Order order2;
    if (Order.getNbOrders() >= MAX_LIMITTED_ORDERS) {
      System.out.println("Max order reached! Cannot create new order");
    } else {
      order2 = new Order();
      order2.printOrder();
    }
  }
}
