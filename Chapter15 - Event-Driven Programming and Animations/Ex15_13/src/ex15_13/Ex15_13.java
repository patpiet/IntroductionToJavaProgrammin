/*
    (Geometry: inside a rectangle?) Write a program that draws a fixed rectangle
    centered at (100, 60) with width 100 and height 40. Whenever the mouse is
    moved, display a message indicating whether the mouse point is inside the rectangle
    at the mouse point or outside of it, as shown in Figure 15.27b. To detect
    whether a point is inside a polygon, use the contains method defined in the
    Node class.
 */
package ex15_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex15_13 extends Application{
    private Text text = new Text(20, 150, "");
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a Pane
        Pane pane = new Pane();
        
        // Create a rectangle
        Rectangle rectangle = new Rectangle(100, 60, 100, 40);
        
        pane.getChildren().addAll(rectangle, text);
        
        pane.setOnMouseMoved(e ->{
            if(rectangle.contains(e.getX(), e.getY())){
//            if(rectangle.isHover()){
                text.setText("Mouse Point is inside the rectangle");
            }else{
                text.setText("Mouse Point is not inside the rectangle");
            }
            
        });

        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Exercise_15_12"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    
        pane.requestFocus();
    }
    
}
