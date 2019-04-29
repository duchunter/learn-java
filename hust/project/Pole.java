package sortfx;

import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Pole {
  public static final int HEIGHT_UNIT = 20;
  public static final int MAX_WIDTH = 150;
  public static final int MAX_DISK = 7;
  public static final int BASE_PADDING = 20;
  public static final int BASE_BORDER_RADIUS = 10;
  public static final int POLE_BORDER_RADIUS = 20;
  public static final Color[] colors = {
    Color.BLUE,
    Color.GREEN,
    Color.RED,
    Color.YELLOW,
    Color.ORANGE,
    Color.PINK,
    Color.PURPLE
  };

  public VBox self;

  // Constructor
  public Pole() {
    // Base
    int depth = (MAX_DISK + 2) * HEIGHT_UNIT;
    int width = MAX_WIDTH * 3 + BASE_PADDING * 2;
    Rectangle base = new Rectangle(0, depth, width, HEIGHT_UNIT);
    base.setArcWidth(BASE_BORDER_RADIUS);
    base.setArcHeight(BASE_BORDER_RADIUS);
    base.setFill(Color.GREY);

    // Pole
    Rectangle pole1 = new Rectangle(0, 0, HEIGHT_UNIT, depth - HEIGHT_UNIT);
    pole1.setArcWidth(POLE_BORDER_RADIUS);
    pole1.setArcHeight(POLE_BORDER_RADIUS);
    pole1.setFill(Color.GREY);

    Rectangle pole2 = new Rectangle(0, 0, HEIGHT_UNIT, depth - HEIGHT_UNIT);
    pole2.setArcWidth(POLE_BORDER_RADIUS);
    pole2.setArcHeight(POLE_BORDER_RADIUS);
    pole2.setFill(Color.GREY);

    Rectangle pole3 = new Rectangle(0, 0, HEIGHT_UNIT, depth - HEIGHT_UNIT);
    pole3.setArcWidth(POLE_BORDER_RADIUS);
    pole3.setArcHeight(POLE_BORDER_RADIUS);
    pole3.setFill(Color.GREY);

    // Poles
    HBox poles = new HBox();
    poles.getChildren().addAll(pole1, pole2, pole3);
    poles.setAlignment(Pos.CENTER);
    poles.setSpacing((width - HEIGHT_UNIT * 3) / 3 + 5);

    self = new VBox();
    self.getChildren().addAll(poles, base);
    self.setAlignment(Pos.TOP_CENTER);
    self.setSpacing(POLE_BORDER_RADIUS * -0.5);
  }
}
