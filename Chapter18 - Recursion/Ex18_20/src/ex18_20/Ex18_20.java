/*
    (Display circles) Write a Java program that displays ovals, as shown in Figure
    18.12b. The circles are centered in the pane. The gap between two adjacent
    circles is 10 pixels, and the gap between the border of the pane and the largest
    circle is also 10.
 */
package ex18_20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author patpiet
 */
public class Ex18_20 extends Application{
    // Create stack pane
    StackPane pane = new StackPane();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane.setPrefSize(300, 300);
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Exercise_18_20"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
        
        displayCircles();
        pane.widthProperty().addListener(e -> displayCircles());
        pane.heightProperty().addListener(e -> displayCircles());
    }
    
    public void displayCircles(){
        pane.getChildren().clear();
        Circle circle = new Circle(5);
        displayCircles(circle);     // recursive helper method
    }

    private void displayCircles(Circle circle) {
        // set up the circle
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        // finish when the gap between border and biggest circles is greater than 10
        if(circle.getRadius() >= pane.getWidth() / 2 - 10
           || circle.getRadius() >= pane.getHeight() / 2 - 10){     // base case
            pane.getChildren().add(circle);
        // draw another circle with radius + 5px
        }else{
            pane.getChildren().add(circle);
            displayCircles(new Circle(circle.getRadius() + 5));     // recursive call
        }
    }
}
