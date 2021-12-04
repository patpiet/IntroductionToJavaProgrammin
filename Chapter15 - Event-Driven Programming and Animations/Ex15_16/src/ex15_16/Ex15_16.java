/*
    (Two movable vertices and their distances) Write a program that displays two
    circles with radius 10 at location (40, 40) and (120, 150) with a line connecting
    the two circles, as shown in Figure 15.28b. The distance between the circles
    is displayed along the line. The user can drag a circle. When that happens, the
    circle and its line are moved and the distance between the circles is updated.
 */
package ex15_16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex15_16 extends Application {

    private static Circle circle1 = new Circle(40, 40, 10);
    private static Circle circle2 = new Circle(120, 150, 10);
    private static Line line = new Line();
    private static Text text = new Text("" + (int) (distance(circle1, circle2)));

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a pane
        Pane pane = new Pane();
        
        // Set circles
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        
        
        // Bind the line with the circles
        line.startXProperty().bind(circle1.centerXProperty());
        line.startYProperty().bind(circle1.centerYProperty());
        line.endXProperty().bind(circle2.centerXProperty());
        line.endYProperty().bind(circle2.centerYProperty());

        // Assign position of the distance text
        text.setX(Math.abs(line.getStartX() + line.getEndX()) / 2);
        text.setY(Math.abs(line.getStartY() + line.getEndY()) / 2);

        pane.getChildren().addAll(line, circle1, circle2, text);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_16"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.

        circle1.requestFocus();
        circle1.requestFocus();

        // circle handlers
        circle1.setOnMouseDragged(e -> {
            dragCircle(circle1, e);
        });

        circle2.setOnMouseDragged(e -> {
            dragCircle(circle2, e);
        });
    }

    // Returns the distance between two circles
    public static double distance(Circle c1, Circle c2) {
        return Math.hypot(c1.getCenterX() - c2.getCenterX(), c1.getCenterY() - c2.getCenterY()) - c1.getRadius() - c2.getRadius();
    }
    // Drags a circle
    public static void dragCircle(Circle circle, MouseEvent e){
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());
            text.setX(Math.abs(line.getStartX() + line.getEndX()) / 2);
            text.setY(Math.abs(line.getStartY() + line.getEndY()) / 2);
            text.setText("" + (int) (distance(circle1, circle2))); 
    }
}
