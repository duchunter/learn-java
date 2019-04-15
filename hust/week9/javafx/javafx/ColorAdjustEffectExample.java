package hust.soict.ictglobal.gui.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ColorAdjustEffectExample extends Application {

	@Override
	public void start(Stage stage) {

		String imageUrl = "//o7planning.org/templates/o7planning/resources/images/favi.png";
		Image image = new Image(imageUrl);

		ImageView imageView1 = new ImageView(image);
		imageView1.setX(100);
		imageView1.setY(20);

		ImageView imageView2 = new ImageView(image);

		imageView2.setX(100);
		imageView2.setY(170);

		// Create the ColorAdjust
		ColorAdjust colorAdjust = new ColorAdjust();

		// Setting the contrast value
		colorAdjust.setContrast(0.3);

		// Setting the hue value
		colorAdjust.setHue(-0.05);

		// Setting the brightness value
		colorAdjust.setBrightness(0.9);

		// Setting the saturation value
		colorAdjust.setSaturation(0.7);

		// Applying ColorAdjust effect to the ImageView node
		imageView2.setEffect(colorAdjust);

		Group root = new Group(imageView1, imageView2);

		Scene scene = new Scene(root, 450, 320);
		stage.setTitle("JavaFX ColorAdjust Effect");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}

}
