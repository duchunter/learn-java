package sortfx;

import java.util.Date;

import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Column {
  // Column size unit constants
  private static final int HEIGHT_UNIT = 10;
  private static final int WIDTH_UNIT = 20;
  private static final int PADDING = 20;
  private static final int BORDER_RADIUS = 10;

  // Max height among columns
  private static int maxValue = 0;

  // Attributes
  private int x;
  private int y;
  private int value;
  private int height;
  private int width;
  private Color color;
  Rectangle rect;
  public VBox self;

  // Constructor
  public Column(int x, int y, int value) {
  	this.x = x;
  	this.y = y;
    this.value = value;
    this.height = value * HEIGHT_UNIT;
    this.width = WIDTH_UNIT;
    this.color = Color.ORANGE;
    if (value > maxValue) {
      maxValue = value;
    }

    rect = new Rectangle(0, 0, this.width, this.height);
    rect.setArcWidth(BORDER_RADIUS);
    rect.setArcHeight(BORDER_RADIUS);
    rect.setFill(this.color);

    Text text = new Text("" + value);
    text.setFont(new Font("Arial",20));

    self = new VBox();
    self.getChildren().addAll(text, rect);
    self.setAlignment(Pos.TOP_CENTER);
    self.setTranslateX(x);
    self.setTranslateY(y);
  }

  // Move up and down
  void moveVertical(int offset, EventHandler callback) {
	  int delta = offset * maxValue * HEIGHT_UNIT + PADDING;
    y = y + delta;
    move(0, delta, callback);
  }

  // Move right or left
  void moveHorizontal(int offset, EventHandler callback) {
	  int delta = offset * (WIDTH_UNIT + PADDING);
    x = x + delta;
    move(delta, 0, callback);
  }

  // Move
  void move(int x, int y, EventHandler callback) {
    TranslateTransition transition = new TranslateTransition(
      Duration.millis(500),
      self
    );

    transition.setByX(x);
    transition.setByY(y);
    transition.setOnFinished(callback);
    transition.play();
  }

  void setSelected() {
    changeColor(Color.RED);
  }

  void setFinished() {
    changeColor(Color.BLUE);
  }

  void setConsidering() {
    changeColor(Color.GREEN);
  }

  // Change color
  void changeColor(Color color) {
    FillTransition fill = new FillTransition();
    fill.setDuration(Duration.millis(500));
    fill.setFromValue(this.color);
    fill.setToValue(color);
    fill.setShape(rect);
    this.color = color;
    fill.play();
  }
}
