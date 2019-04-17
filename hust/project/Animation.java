package sortfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import java.util.concurrent.TimeUnit;

public class Animation extends Application {
  public int[] array = { 7, 13, 5, 9, 11, 2, 20, 14, 7 };
  public Column[] cols = new Column[array.length];

  @Override
  public void start(Stage stage) {
    init();
    stage.setTitle("Test");
    final Scene scene = new Scene(new Group(), 600, 450);
    scene.setFill(Color.WHITE);
    for (int i = 0; i < array.length; i++) {
    	((Group)scene.getRoot()).getChildren().add(cols[i].self);
    }

    stage.setScene(scene);
    stage.show();

    pick(0);
  }

  public EventHandler<ActionEvent> pass = new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {

      }
  };

  public static void main(String[] args) {
      Application.launch(args);
  }

  public void init() {
    for (int i = 0; i < array.length; i++) {
      Column col = new Column(i * 40, 10, array[i]);
      cols[i] = col;
    }
  }

  public void pick(int i) {
    EventHandler<ActionEvent> next = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          loop(i - 1, i);
        }
    };

    EventHandler<ActionEvent> kickstart = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          cols[i].setFinished();
          cols[i].moveVertical(-1, pass);
          pick(i + 1);
        }
    };

    if (i == 0) {
      cols[i].setSelected();
      cols[i].moveVertical(1, kickstart);
      return;
    }

    if (i < array.length) {
      cols[i].setSelected();
      cols[i].moveVertical(1, next);
    }
  }

  public void loop(int i, int current) {
    EventHandler<ActionEvent> nextPick = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          pick(current + 1);
        }
    };

    EventHandler<ActionEvent> nextLoop = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          if (i > 0) {
            loop(i - 1, current);
          } else {
            cols[i].setFinished();
            cols[i].moveVertical(-1, nextPick);
          }
        }
    };

    if (array[i + 1] < array[i]) {
      int tmp = array[i + 1];
      array[i + 1] = array[i];
      array[i] = tmp;

      Column tmpCol = cols[i + 1];
      cols[i + 1] = cols[i];
      cols[i] = tmpCol;

      cols[i + 1].moveHorizontal(1, pass);
      cols[i].moveHorizontal(-1, nextLoop);
    } else {
      cols[i + 1].setFinished();
      cols[i + 1].moveVertical(-1, nextPick);
    }
  }
}
