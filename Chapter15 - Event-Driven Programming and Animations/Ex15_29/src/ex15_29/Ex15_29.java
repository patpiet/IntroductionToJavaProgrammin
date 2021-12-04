/*
    (Racing car) Write a program that simulates car racing, as shown in
    Figure 15.34a. The car moves from left to right. When it hits the right end, it
    restarts from the left and continues the same process. You can use a timer to
    control animation. Redraw the car with a new base coordinates (x, y), as shown
    in Figure 15.34b. Also let the user pause/resume the animation with a button
    press/release and increase/decrease the car speed by pressing the UP and
    DOWN arrow keys.
 */
package ex15_29;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex15_29 extends Application {
        // control the speed of the car
        int speedDuration = 10;

        public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create a pane
        Pane pane = new Pane();
        
        // Create buttons
        HBox hBox = new HBox();
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        hBox.setSpacing(10);
        hBox.getChildren().addAll(btPause, btResume);
        
        pane.getChildren().add(hBox);

        // Create a car
        Circle c1 = new Circle(15, 95, 5);
        Circle c2 = new Circle(35, 95, 5);
        Rectangle rectangle = new Rectangle(0, 80, 50, 10);
        rectangle.setFill(Color.AQUA);
        Polygon polygon = new Polygon();
        polygon.setFill(Color.BLUE);
        polygon.getPoints().addAll(new Double[]{
            20.0, 70.0,
            30.0, 70.0,
            40.0, 80.0,
            10.0, 80.0
        });

        ObservableList<Node> car = pane.getChildren();

        // Create animation handler
        EventHandler<ActionEvent> eventHandler = e -> {
            // Move the car
            if (rectangle.getX() + rectangle.getWidth() != pane.getWidth()) {
                for (Node node : car) {
                    if (node instanceof Circle) {
                        ((Circle) node).setCenterX(((Circle) node).getCenterX() + 1);
                    } else if (node instanceof Rectangle) {
                        ((Rectangle) node).setX(((Rectangle) node).getX() + 1);
                    } else if (node instanceof Polygon) {
                        movePolygon((Polygon) node);
                    }
                }
            } else {
                // Reset the car when the race finishes
                resetCar(c1, c2, rectangle, polygon);
            }

        };
        
        // Create animation
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(10), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        pane.getChildren().addAll(c1, c2, rectangle, polygon);
        
        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        pane.setOnKeyPressed(e ->{
            // Update speed
            if(e.getCode() == UP && speedDuration != 1){
                speedDuration -= 1;
            }
            else if(e.getCode() == DOWN){
                speedDuration += 1;
            }
                // Update the keyFrame
                animation.stop();
                animation.getKeyFrames().clear();
                animation.getKeyFrames().add(new KeyFrame(Duration.millis(speedDuration), eventHandler));
                animation.play();
        });
        

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 100);
        primaryStage.setTitle("Exercise_15_29"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    // moves all points in polygon to the right
    public void movePolygon(Polygon polygon) {
        ObservableList<Double> list = polygon.getPoints();

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                list.set(i, list.get(i) + 1);
            }
        }
    }

    // Resets the coordinates of the car to the start
    public void resetCar(Circle c1, Circle c2, Rectangle rectangle, Polygon polygon) {
        c1.setCenterX(15);
        c2.setCenterX(35);
        rectangle.setX(0);
        polygon.getPoints().clear();
        polygon.getPoints().addAll(new Double[]{
            20.0, 70.0,
            30.0, 70.0,
            40.0, 80.0,
            10.0, 80.0
        });
    }
}
