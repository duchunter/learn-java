import java.io.FileReader;

public class GarbageCreator {
  public static void main(String[] args) throws Exception  {
    FileReader fr = new FileReader("test.txt");

    int i;
    String str = "";
    while ((i = fr.read()) != -1) {
      str += (char) i;
    }

    System.out.println(str);
  }
}
