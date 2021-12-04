/*
    (Move a circle using keys) Write a program that moves a circle up, down, left,
    or right using the arrow keys.
 */
package ex15_11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ex15_11 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Pane
        Pane pane = new Pane();
        
        // Create a circle
        Circle circle = new Circle(100, 100, 20);
        
        pane.setOnKeyPressed(e ->{
            switch(e.getCode()){
                case UP: circle.setCenterY(circle.getCenterY() - 5); break;
                case DOWN: circle.setCenterY(circle.getCenterY() + 5); break;
                case LEFT: circle.setCenterX(circle.getCenterX() - 5); break;
                case RIGHT: circle.setCenterX(circle.getCenterX() + 5); break;
            }
        });
        
        pane.getChildren().add(circle);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise_15_10"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
        pane.requestFocus();
    }
    
}
