import java.util.Scanner;

public class Aims {
  private static final int MAX_LIMITTED_ORDERS = 2;

  public static void main(String[] args) {
    MemoryDaemon daemon = new MemoryDaemon();
    Thread thread = new Thread(daemon);
    thread.setDaemon(true);
    thread.start();

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
