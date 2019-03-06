import java.io.FileReader;

public class NoGarbage {
  public static void main(String[] args) throws Exception {
    FileReader fr = new FileReader("test.txt");

    int i;
    StringBuilder sb = new StringBuilder();
    while ((i = fr.read()) != -1) {
      sb.append((char) i);
    }

    System.out.println(sb.toString());
  }
}
