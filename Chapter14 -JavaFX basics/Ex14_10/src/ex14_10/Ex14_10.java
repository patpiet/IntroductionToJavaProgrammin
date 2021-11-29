/*
    Write a program that draws a cylinder, as shown in
    Figure 14.45b. You can use the following method to set the dashed stroke for an arc:

    arc.getStrokeDashArray().addAll(6.0, 21.0);
 */
package ex14_10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Ex14_10 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        
        // Create two sides
        Line line2 = new Line(40, 40, 40, 120);
        Line line1 = new Line(160, 40, 160, 120);
        
        // Create top ellipse
        Ellipse ellipseTop = new Ellipse(100,40, 60, 20);
        ellipseTop.setFill(Color.WHITE);
        ellipseTop.setStroke(Color.BLACK);
        
        
        // Create dashed top arc
        Arc arcTop = new Arc(100, 120, 60, 20, 0, 180);
        arcTop.setFill(Color.WHITE);
        arcTop.setStroke(Color.BLACK);
        arcTop.getStrokeDashArray().addAll(6.0, 21.0);
        
        // Create bottom arc
        Arc arcBottom = new Arc(100, 120, 60, 20, 0, -180);
        arcBottom.setFill(Color.WHITE);
        arcBottom.setStroke(Color.BLACK);
        
        pane.getChildren().add(line1);
        pane.getChildren().add(line2);
        pane.getChildren().add(ellipseTop);
        pane.getChildren().add(arcTop);
        pane.getChildren().add(arcBottom);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 150);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
    }
    
}
