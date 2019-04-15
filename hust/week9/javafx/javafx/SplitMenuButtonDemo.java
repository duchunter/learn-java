package hust.soict.ictglobal.gui.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SplitMenuButtonDemo extends Application {

	private int count = 1;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label label = new Label();

		// Create MenuItems
		MenuItem menuItemVI = new MenuItem("Vietnamese");
		MenuItem menuItemEN = new MenuItem("English");
		MenuItem menuItemIN = new MenuItem("India");

		// Create a MenuButton with 3 Items
		SplitMenuButton splitMenuButton = new SplitMenuButton(menuItemVI, menuItemEN, menuItemIN);

		splitMenuButton.setText("Language");

		// Handling when the user clicks on the left side of SplitMenuButton.
		splitMenuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				label.setText("Clicked " + count++);
			}
		});

		FlowPane root = new FlowPane();
		root.setPadding(new Insets(10));
		root.setVgap(5);
		root.setHgap(5);

		root.getChildren().addAll(splitMenuButton, label);

		Scene scene = new Scene(root, 320, 150);

		primaryStage.setTitle("JavaFX SplitMenuButton (o7planning.org)");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
