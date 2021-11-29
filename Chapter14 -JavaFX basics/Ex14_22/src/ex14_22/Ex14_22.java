/*
    Write a program that draws two circles with radius
    15 pixels, centered at random locations, with a line connecting the two circles.
    The line should not cross inside the circles, as shown in Figure 14.49c.
 */
package ex14_22;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Ex14_22 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
                // Create pane
        Pane pane = new Pane();
        
        final double WIDTH = 200, HEIGHT = 200;
        
        // Create circles
        Circle c1 = new Circle(Math.random() * WIDTH, Math.random() * HEIGHT, 15);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);
        Circle c2 = new Circle(Math.random() * WIDTH, Math.random() * HEIGHT, 15);
        c2.setFill(Color.WHITE);
        c2.setStroke(Color.BLACK);

        // Create line object
        Line line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        
        pane.getChildren().add(line);
        pane.getChildren().add(c1);
        pane.getChildren().add(c2);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
