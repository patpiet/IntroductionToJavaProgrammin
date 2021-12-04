/*
   (Geometry: add and remove points) Write a program that lets the user click on
   a pane to dynamically create and remove points (see Figure 15.28a). When the
   user left-clicks the mouse (primary button), a point is created and displayed
   at the mouse point. The user can remove a point by pointing to it and rightclicking
   the mouse (secondary button).
 */
package ex15_15;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ex15_15 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Pane 
        Pane pane = new Pane();
        
        // Create list to store all circles
        ArrayList<Circle> list = new ArrayList<>();
        
        pane.setOnMouseClicked(e ->{
            if(e.getButton() == PRIMARY){
                // Create circle
                Circle circle = new Circle(e.getX(), e.getY(), 10);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLACK);
                list.add(circle);
                // Display Circle
                pane.getChildren().add(circle);
            }
            else if(e.getButton() == SECONDARY){
                // loop through all visible circles, if the circles is hovered - remove it from the pane
                for (Circle circle : list) {
                    if(circle.isHover()){
                        pane.getChildren().remove(circle);
                    }
                }
            }
        });
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Exercise_15_15"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
        pane.requestFocus();
    }
    
}
