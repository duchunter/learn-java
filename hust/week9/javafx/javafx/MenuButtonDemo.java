package hust.soict.ictglobal.gui.javafx;

import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class MenuButtonDemo extends Application {

   @Override
   public void start(Stage primaryStage) throws Exception {
 
       // Create MenuItems
       MenuItem menuItemVI = new MenuItem("Vietnamese");
       MenuItem menuItemEN = new MenuItem("English");
       MenuItem menuItemIN = new MenuItem("India");

 
       // Create a MenuButton with Text & 3 Items
       MenuButton menuButton = new MenuButton("Language", null, menuItemEN,menuItemIN,menuItemVI);
       
       FlowPane root = new FlowPane();
       root.setPadding(new Insets(10));
       root.setVgap(5);
       root.setHgap(5);
 
       root.getChildren().addAll(menuButton);
 
       Scene scene = new Scene(root, 320, 150);
 
       primaryStage.setTitle("JavaFX MenuButton");
       primaryStage.setScene(scene);
       primaryStage.show();
   }
 
   public static void main(String[] args) {
       Application.launch(args);
   }
 
}
