import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Aims {
  private static final int MAX_LIMITTED_ORDERS = 2;

  public static void main(String[] args) {
    // Daemon thread to check memory used
    MemoryDaemon daemon = new MemoryDaemon();
    Thread thread = new Thread(daemon);
    thread.setDaemon(true);
    thread.start();

    // Main menu
    int choice;
    Scanner input = new Scanner(System.in);
    Order order = null;

    do {
      showMenu();
      choice = input.nextInt();
      input.nextLine();
      System.out.println();
      switch (choice) {
        // Create new order
        case 1: {
          System.out.print("Enter order id: ");
          String id = input.nextLine();
          order = new Order(id);
          System.out.println("New order created !");
          break;
        }

        // Add item to order
        case 2: {
          if (order == null) {
            System.out.println("Please create an order first !");
            break;
          }

          order.addCustomMedia();
          break;
        }

        // Delete item by id
        case 3: {
          if (order == null) {
            System.out.println("Please create an order first !");
            break;
          }

          System.out.print("Enter id: ");
          String id = input.nextLine();
          order.removeMedia(id);
          break;
        }

        // Display items list
        case 4: {
          if (order == null) {
            System.out.println("Please create an order first !");
            break;
          }

          order.printOrder();
          break;
        }

        default:
          if (choice != 0) {
            System.out.println("Invalid choice !!!");
          }
      }
    } while (choice != 0);

    input.close();

    // Test sorting
    List<DigitalVideoDisc> discs = new ArrayList<DigitalVideoDisc>();

    DigitalVideoDisc dvd1 = new DigitalVideoDisc("1", "The lion king", "Animation", 19.95f);
    dvd1.setDirector("Roger Allers");
    dvd1.setLength(87);

    DigitalVideoDisc dvd2 = new DigitalVideoDisc("2", "Star Wars", "Science Fiction", 24.95f);
    dvd2.setDirector("George Lucas");
    dvd2.setLength(124);

    DigitalVideoDisc dvd3 = new DigitalVideoDisc("3", "Aladdin", "Animation", 18.99f);
    dvd3.setDirector("John Musker");
    dvd3.setLength(90);

    discs.add(dvd2);
    discs.add(dvd1);
    discs.add(dvd3);

    System.out.println("-------------------------------------");
    System.out.println("The DVDs currently in the order are: ");
    for (DigitalVideoDisc disc : discs) {
      System.out.println(disc.getTitle());
    }

    Collections.sort(discs);

    System.out.println("-------------------------------------");
    System.out.println("The DVDs in sorted order are: ");
    for (DigitalVideoDisc disc : discs) {
      System.out.println(disc.getTitle());
    }

    System.out.println("-------------------------------------");
  }

  public static void showMenu() {
    System.out.println("\nOrder Management Application:");
    System.out.println("-----------------------------");
    System.out.println("1. Create new order");
    System.out.println("2. Add item to the order");
    System.out.println("3. Delete item by id");
    System.out.println("4. Display the items list of order");
    System.out.println("0. Exit");
    System.out.println("-----------------------------");
    System.out.print("Please choose a number: 0-1-2-3-4: ");
  }
}
