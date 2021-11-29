/*
    Write a program that displays a STOP sign, as shown
    in Figure 14.47b. The octagon is in red and the sign is in white. (Hint: Place an
    octagon and a text in a stack pane.)
 */
package ex14_15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_15 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create stack pane
        StackPane pane = new StackPane();
        
        // Crate octagon object
        Polygon octagon = new Polygon();
        
        final double WIDTH = 200, HEIGHT = 200;
        
        double centerX = WIDTH/2, centerY = HEIGHT/2;
        
        // Store the points
        ObservableList<Double> list = octagon.getPoints();
        
        // Create octagon points
        for (int i = 0; i < 8; i++) {
            list.add(centerX + 80 * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY + 80 * Math.sin(2 * i * Math.PI / 8));
        }
        
        octagon.setRotate(-22.5);
        octagon.setFill(Color.RED);
        
        // Create "STOP" text
        Text text = new Text("STOP");
        text.setFont(new Font("Times Roman", 45));
        text.setFill(Color.WHITE);
        
        // Add nodes
        pane.getChildren().add(octagon);
        pane.getChildren().add(text);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_15"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
