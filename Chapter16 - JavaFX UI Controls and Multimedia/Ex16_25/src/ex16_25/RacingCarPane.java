/*
 */
package ex16_25;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RacingCarPane extends Pane {
    private double speed;
    private ObservableList<Node> car = getChildren();
    private Timeline animation;
    private Polygon polygon;
    private Circle c1;
    private Circle c2;
    private Rectangle rectangle;
    private EventHandler<ActionEvent> eventHandler;

    public RacingCarPane() {
        // Create a car
        c1 = new Circle(15, 95, 5);
        c2 = new Circle(35, 95, 5);
        rectangle = new Rectangle(0, 80, 50, 10);
        rectangle.setFill(Color.AQUA);
        polygon = new Polygon();
        polygon.setFill(Color.BLUE);
        polygon.getPoints().addAll(new Double[]{
            20.0, 70.0,
            30.0, 70.0,
            40.0, 80.0,
            10.0, 80.0
        });
        // set up the pane
        getChildren().addAll(c1, c2, rectangle, polygon);
        setStyle("-fx-border-color: black");
        setPrefSize(400, 100);

        // Create animation handler
        eventHandler = e -> {
            // Move the car
            if (rectangle.getX() + rectangle.getWidth() != getWidth()) {
                for (Node node : car) {
                    if (node instanceof Circle) {
                        ((Circle) node).setCenterX(((Circle) node).getCenterX() + 1);
                    } else if (node instanceof Rectangle) {
                        ((Rectangle) node).setX(((Rectangle) node).getX() + 1);
                    } else if (node instanceof Polygon) {
                        movePolygon();
                    }
                }
            } else {
                // Reset the car when the race finishes
                resetCar();
            }

        };

        // Create animation
        animation = new Timeline(new KeyFrame(Duration.millis(10), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    // moves all points of polygon to the right
    private void movePolygon() {
        ObservableList<Double> list = polygon.getPoints();

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                list.set(i, list.get(i) + 1);
            }
        }
    }

    // Resets the coordinates of the car to the start
    private void resetCar() {
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

    // play the animation of car racing
    public void play() {
        animation.play();
    }

    // pause the animation of car racing
    public void pause() {
        animation.pause();
    }

    // set speed method 
    public void setSpeed(double speed) {
        // sets maximum to max 100, if given speed is greaten than 100 it acts like it was 100
        if(speed >= 101)
            this.speed = 1;
        else
            this.speed = Math.abs(speed - 101);
        // Update the keyFrame
        animation.stop();
        animation.getKeyFrames().clear();
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(this.speed), eventHandler));
        animation.play();
        this.speed = speed;
    }

    // return speed
    public double getSpeed() {
        return this.speed;
    }
}
