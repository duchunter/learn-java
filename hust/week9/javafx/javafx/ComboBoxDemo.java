package hust.soict.ictglobal.gui.javafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {

	@Override
	public void start(Stage stage) {

		ComboBox<Planet> comboBox = new ComboBox<Planet>();

		ObservableList<Planet> list = PlanetDAO.getPlanetList();

		comboBox.setItems(list);
		comboBox.getSelectionModel().select(1);

		FlowPane root = new FlowPane();
		root.setPadding(new Insets(5));
		root.setHgap(5);

		root.getChildren().add(new Label("Select Planet:"));
		root.getChildren().add(comboBox);

		stage.setTitle("ComboxBox");
		Scene scene = new Scene(root, 350, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
