/*
    Change color using a mouse) Write a program that displays the color of a
    circle as black when the mouse button is pressed and as white when the mouse
    button is released.
 */
package ex15_07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ex15_07 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create stack pane
        StackPane pane = new StackPane();
        
        // Create circle
        Circle circle = new Circle(30, 30, 30);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        // Add circle to the pane
        pane.getChildren().add(circle);
        
        // Create 
        pane.setOnMousePressed(e ->{
            circle.setFill(Color.BLACK);
        });
        pane.setOnMouseReleased(e ->{
            circle.setFill(Color.WHITE);
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 100, 100);
        primaryStage.setTitle("Exercise_15_07"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
