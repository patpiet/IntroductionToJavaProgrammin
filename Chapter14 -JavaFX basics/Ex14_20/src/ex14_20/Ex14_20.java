/*
    Write a static method that draws an arrow line from a starting
    point to an ending point in a pane using the following method header:

    public static void drawArrowLine(double startX, double startY,
    double endX, double endY, Pane pane)

    Write a test program that randomly draws an arrow line, as shown in Figure 14.49a
 */
package ex14_20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Ex14_20 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        drawArrowLine(430, 330, 30, 130, pane);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    // draws an arrow line from a starting point to and ending point in a pane 
    public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {
        // Create line arrow
        Line line = new Line(startX, startY, endX, endY);

        // Create pointer
        Polyline pointer = new Polyline();
        pointer.getPoints().addAll(new Double[]{
            endX - 20, endY - 15,
            endX, endY,
            endX + 20, endY - 15
        });
        
        // Add shapes to the pane
        pane.getChildren().add(line);
        pane.getChildren().add(pointer);
    }

}
