/*
    (Geometry: find the bounding rectangle) Write a program that enables the user
    to add and remove points in a two-dimensional plane dynamically, as shown
    in Figure 15.29a. A minimum bounding rectangle is updated as the points are
    added and removed. Assume that the radius of each point is 10 pixels.
 */
package ex15_17;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex15_17 extends Application {
        static Pane pane = new Pane();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create list to store all circles
        ArrayList<Circle> list = new ArrayList<>();

        pane.setOnMouseClicked(e -> {
            if (e.getButton() == PRIMARY) {
                // Create circle
                Circle circle = new Circle(e.getX(), e.getY(), 10);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLACK);
                System.out.println(circle.getBoundsInLocal());
                list.add(circle);
                // Display Circle
                pane.getChildren().add(circle);
            } else if (e.getButton() == SECONDARY) {
                // loop through all visible circles, if the circles is hovered - remove it from the pane
                for (Circle circle : list) {
                    if (circle.isHover()) {
                        pane.getChildren().remove(circle);
                        list.remove(circle);
                        drawRectangle(list);
                    }
                }
            }
            drawRectangle(list);
            
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Exercise_15_17"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.

        pane.requestFocus();
    }

    public static void drawRectangle(ArrayList<Circle> list){
        // Delete previous rectangle
        pane.getChildren().removeIf(node -> node instanceof Rectangle);
        
        // Return if list empty
        if(list.isEmpty()) return;
        
        // set all bounds to the first circle
        Circle top = list.get(0);
        Circle bottom = list.get(0);
        Circle left = list.get(0);
        Circle right = list.get(0);
        
        // Loop through all circles and set the bounds to appropraite circles
        for(Circle circle: list){
            if(circle.getCenterX() < left.getCenterX()) left = circle;
            if(circle.getCenterX() > right.getCenterX()) right = circle;
            if(circle.getCenterY() < top.getCenterY()) top = circle;
            if(circle.getCenterY() > bottom.getCenterY()) bottom = circle;
        }
        // Create boundary rectangle 
        Rectangle rectangle = new Rectangle(
                left.getCenterX() - 10, // set centerX
                top.getCenterY() - 10,  // set centerY
                right.getCenterX() + 20 - left.getCenterX(), // set width
                bottom.getCenterY() + 20 - top.getCenterY()); // set height
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().add(rectangle);
    }
    
}
