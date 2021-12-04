/*
    (Move a rectangle using mouse) Write a program that displays a rectangle.
    You can point the mouse inside the rectangle and drag (i.e., move with mouse
    pressed) the rectangle wherever the mouse goes. The mouse point becomes the
    center of the rectangle.
 */
package ex15_18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex15_18 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        // Create a rectangle
        Rectangle rectangle = new Rectangle(150, 150, 40, 20);
        
        pane.getChildren().add(rectangle);
        
        rectangle.setOnMouseDragged(e ->{
            rectangle.setX(e.getX() - rectangle.getWidth() / 2.0);
            rectangle.setY(e.getY() - rectangle.getHeight() / 2.0);
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Exercise_15_18"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    
        rectangle.requestFocus();
    }
    
}
