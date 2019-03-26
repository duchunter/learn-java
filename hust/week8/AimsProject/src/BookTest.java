public class BookTest {
  public static void main(String[] args) {
    Book book = new Book("1", "test");
    book.setContent("A very long content. It's a content, and a content");
    System.out.print(book.toString());
  }
}
