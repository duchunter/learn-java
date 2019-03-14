import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
  // Attributes
  private static final int MAX_NUMBERS_ORDERED = 10;
  private static Scanner input = new Scanner(System.in);

  private String id;
  private List<Media> itemOrdered = new ArrayList<Media>();
  private LocalDate dateOrdered;

  // Constructor
  public Order(String id) {
    super();
    LocalDate dateOrdered = LocalDate.now();
    this.dateOrdered = dateOrdered;
    this.id = id;
  }

  // Getter and Setter
  public String getId() {
    return id;
  }

  public LocalDate getDateOrdered() {
    return dateOrdered;
  }

  // METHODS

  // Print order
  public void printOrder() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

    System.out.println("****************Order*******************");
    System.out.println("Date: " + this.dateOrdered.format(formatter));
    System.out.println("Ordered items:");
    for (Media media : itemOrdered) {
      media.printMedia();
    }
    System.out.println("Total cost: " + totalCost() + '$');
    System.out.println("****************************************\n");
  }

  // Add
  public void addMedia(Media media) {
    if (this.itemOrdered.size() == MAX_NUMBERS_ORDERED) {
      System.out.println("List is full");
      return;
    }

    this.itemOrdered.add(media);
    System.out.println(media.getTitle() + " added");
  }

  public void addCustomMedia() {
    System.out.println("Select media type:");
    System.out.println("1. DVD");
    System.out.println("2. Book");
    System.out.print("Enter your choice: 1 - 2: ");

    int option = input.nextInt();
    input.nextLine();

    if (option != 1 && option != 2) {
      System.out.println("Invalid choice !!!");
      return;
    }

    System.out.print("Enter id: ");
    String id = input.nextLine();

    System.out.print("Enter title: ");
    String title = input.nextLine();

    System.out.print("Enter category: ");
    String category = input.nextLine();

    System.out.print("Enter cost: ");
    float cost = input.nextFloat();
    input.nextLine();

    // DVD
    if (option == 1) {
      System.out.print("Enter director: ");
      String director = input.nextLine();

      System.out.print("Enter length: ");
      int length = input.nextInt();
      input.nextLine();

      DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
      addMedia(dvd);
      return;
    }

    // Book
    if (option == 2) {
      Book book = new Book(id, title, category, cost);
      System.out.print("Enter number of authors: ");
      int nbAuthors = input.nextInt();
      input.nextLine();

      for (int i = 0; i < nbAuthors; i++) {
        System.out.print("Enter author's name: ");
        String author = input.nextLine();
        book.addAuthor(author);
      }

      addMedia(book);
      return;
    }
  }

  // Remove
  public void removeMedia(String id) {
    if (this.itemOrdered.size() == 0) {
      System.out.println("List is empty");
      return;
    }

    // Find media and remove
    for (Media med : itemOrdered) {
      if (med.getId().equals(id)) {
        String title = med.getTitle();
        this.itemOrdered.remove(med);
        System.out.println(id + " - " + title + " removed");
        return;
      }
    }

    System.out.println(id + " not exists");
  }

  // Cost
  public float totalCost() {
    float total = 0;
    for (Media media : this.itemOrdered) {
      if (!media.getIsFree()) {
        total += media.getCost();
      }
    }

    return total;
  }

  // Get a lucky item
  public Media getALuckyItem() {
    int luckyIndex = (int)(this.itemOrdered.size() * Math.random());
    this.itemOrdered.get(luckyIndex).setIsFree(true);
    return this.itemOrdered.get(luckyIndex);
  }
}
