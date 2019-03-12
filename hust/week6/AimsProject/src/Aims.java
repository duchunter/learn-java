public class Aims {
  private static final int MAX_LIMITTED_ORDERS = 2;

  public static void main(String[] args) {
    // Test basic object function and constructor
    // System.out.println("\n\tBASIC TEST\n");
    // Order anOrder = new Order();
    // DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king");
    // dvd1.setCategory("Animation");
    // dvd1.setCost(19.95f);
    // dvd1.setDirector("Roger Allers");
    // dvd1.setLength(87);
    // anOrder.addDigitalVideoDisc(dvd1);
    //
    // DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
    // dvd2.setCategory("Science Fiction");
    // dvd2.setCost(24.95f);
    // dvd2.setDirector("George Lucas");
    // dvd2.setLength(124);
    // anOrder.addDigitalVideoDisc(dvd2);
    //
    // DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
    // dvd3.setCategory("Animation");
    // dvd3.setCost(18.99f);
    // dvd3.setDirector("John Musker");
    // dvd3.setLength(90);
    // anOrder.addDigitalVideoDisc(dvd3);
    //
    // anOrder.removeDigitalVideoDisc(dvd2);
    // anOrder.printOrder();
    //
    // // Test method overload
    // System.out.println("\n\tMETHOD OVERLOAD TEST\n");
    // DigitalVideoDisc[] dvdList = { dvd1, dvd2, dvd3 };
    // anOrder.addDigitalVideoDisc(dvdList);
    // anOrder.printOrder();
    //
    // anOrder.addDigitalVideoDisc(dvd2, dvd3, dvd1, dvd3, dvd2, dvd1);
    // anOrder.printOrder();
    //
    // System.out.println("Total cost: " + anOrder.totalCost());
    //
    // // Test class member
    // System.out.println("\n\tCLASS MEMBER TEST\n");
    // Order order1;
    // if (Order.getNbOrders() > MAX_LIMITTED_ORDERS) {
    //   System.out.println("Cannot create new order");
    // } else {
    //   order1 = new Order();
    //   order1.printOrder();
    // }
    //
    // Order order2;
    // if (Order.getNbOrders() >= MAX_LIMITTED_ORDERS) {
    //   System.out.println("Max order reached! Cannot create new order");
    // } else {
    //   order2 = new Order();
    //   order2.printOrder();
    // }
    //
    // // Test search method
    // System.out.println("\n\tSEARCH METHOD TEST\n");
    // System.out.println("Test with dvd1: " + dvd1.getTitle());
    // System.out.println("Search 'lion': " + dvd1.search("lion"));
    // System.out.println("Search 'the king lion': " + dvd1.search("the king lion"));
    // System.out.println("Search 'the boar': " + dvd1.search("the boar"));
  }

  public static void showMenu() {
    System.out.println("Order Management Application:");
    System.out.println("-----------------------------");
    System.out.println("1. Create new order");
    System.out.println("2. Add item to the order");
    System.out.println("3. Delete item by id");
    System.out.println("4. Display the items list of order");
    System.out.println("0. Exit");
    System.out.println("-----------------------------");
    System.out.println("Please choose a number: 0-1-2-3-4");
  }
}
