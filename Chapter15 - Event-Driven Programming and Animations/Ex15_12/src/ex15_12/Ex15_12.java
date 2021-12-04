/*
    (Geometry: inside a circle?) Write a program that draws a fixed circle centered
    at (100, 60) with radius 50. Whenever the mouse is moved, display a message
    indicating whether the mouse point is inside the circle at the mouse point or
    outside of it, as shown in Figure 15.27a.
 */
package ex15_12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex15_12 extends Application{
    private Text text = new Text(20, 150, "");
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a Pane
        Pane pane = new Pane();
        
        // Create a circle
        Circle circle = new Circle(100, 60, 50);
        
        Rectangle rect = new Rectangle(100, 60, 100, 40);

        pane.getChildren().addAll(circle, text);
        
        pane.setOnMouseMoved(e ->{
            if(circle.isHover()){
                text.setText("Mouse Point is inside the circle");
            }else{
                text.setText("Mouse Point is not inside the circle");
            }
            
        });

        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise_15_12"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    
        pane.requestFocus();
    }
    
}
