/*
    Write a program that draws two filled circles
    with radius 15 pixels, centered at random locations, with a line connecting the
    two circles. The distance between the two centers is displayed on the line, as
    shown in Figure 14.49b.
 */
package ex14_21;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_21 extends Application{

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        final double WIDTH = 200, HEIGHT = 200;
        
        // Create circles
        Circle c1 = new Circle(Math.random() * WIDTH, Math.random() * HEIGHT, 15);
        Circle c2 = new Circle(Math.random() * WIDTH, Math.random() * HEIGHT, 15);

        // Create line object
        Line line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        
        double distance = Math.hypot(Math.abs(c1.getCenterY() - c2.getCenterY()), Math.abs(c1.getCenterX() - c2.getCenterX()));
        
        // Create text object with distance
        Text distanceText = new Text(distance + " ");
        distanceText.setX(Math.abs(line.getStartX() + line.getEndX()) / 2);
        distanceText.setY(Math.abs(line.getStartY() + line.getEndY()) / 2);
        distanceText.setFill(Color.RED);
        
        pane.getChildren().add(c1);
        pane.getChildren().add(c2);
        pane.getChildren().add(line);
        pane.getChildren().add(distanceText);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
