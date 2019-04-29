package sortfx;

import java.lang.Math;

import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Disk {
  private static final int BORDER_RADIUS = 30;

  // Attributes
  private int x;
  private int y;
  public Rectangle self;

  // Constructor
  public Disk(int index) {
    int width = Pole.MAX_WIDTH - (index + 1) * 20;
  	int x = (Pole.MAX_WIDTH - width) / 2;
  	int y = (Pole.MAX_DISK - index) * Pole.HEIGHT_UNIT - Pole.POLE_BORDER_RADIUS / 2;

    this.x = x;
    this.y = y;
    self = new Rectangle(x, y, width, Pole.HEIGHT_UNIT);
    self.setArcWidth(BORDER_RADIUS);
    self.setArcHeight(BORDER_RADIUS);
    self.setFill(Pole.colors[index]);
  }

  // Move up and down
  void moveVertical(int index) {
	  int y = (Pole.MAX_DISK - index) * Pole.HEIGHT_UNIT - Pole.POLE_BORDER_RADIUS / 2;
    int delta = y - this.y;
    this.y = y;
    move(0, delta);
  }

  // Move right or left
  void moveHorizontal(int offset) {
	  int delta = offset * (Pole.MAX_WIDTH + Pole.BASE_PADDING);
    x = x + delta;
    move(delta, 0);
  }

  // Move
  void move(int x, int y) {
    TranslateTransition transition = new TranslateTransition(
      Duration.millis(500),
      self
    );

    transition.setByX(x);
    transition.setByY(y);
    transition.play();
  }
}
