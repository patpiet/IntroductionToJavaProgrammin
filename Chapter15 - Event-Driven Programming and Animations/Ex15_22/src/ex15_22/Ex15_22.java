/*
    (Auto resize cylinder) Rewrite Programming Exercise 14.10 so that the cylinder’s
    width and height are automatically resized when the window is resized.
 */
package ex15_22;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Ex15_22 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        // Create two sides
        Line line1 = new Line(160, 40, 160, 120);
        line1.startXProperty().bind(pane.widthProperty().multiply(0.8));
        line1.startYProperty().bind(pane.heightProperty().multiply(0.2666666666));
        line1.endXProperty().bind(pane.widthProperty().multiply(0.8));
        line1.endYProperty().bind(pane.heightProperty().multiply(0.8));
        
        Line line2 = new Line(40, 40, 40, 120);
        line2.startXProperty().bind(pane.widthProperty().multiply(0.2));
        line2.startYProperty().bind(pane.heightProperty().multiply(0.2666666666));
        line2.endXProperty().bind(pane.widthProperty().multiply(0.2));
        line2.endYProperty().bind(pane.heightProperty().multiply(0.8));
        
        
        // Create top ellipse
        Ellipse ellipseTop = new Ellipse(100,40, 60, 20);
        ellipseTop.setFill(Color.WHITE);
        ellipseTop.setStroke(Color.BLACK);
        ellipseTop.centerXProperty().bind(pane.widthProperty().divide(2));
        ellipseTop.centerYProperty().bind(pane.heightProperty().multiply(0.2666666666));
        ellipseTop.radiusXProperty().bind(pane.widthProperty().multiply(0.3));
        ellipseTop.radiusYProperty().bind(pane.heightProperty().multiply(0.13333333));
        
        
        // Create dashed top arc
        Arc arcTop = new Arc(100, 120, 60, 20, 0, 180);
        arcTop.setFill(Color.WHITE);
        arcTop.setStroke(Color.BLACK);
        arcTop.getStrokeDashArray().addAll(6.0, 21.0);
        arcTop.centerXProperty().bind(pane.widthProperty().divide(2));
        arcTop.centerYProperty().bind(pane.heightProperty().multiply(0.8));
        arcTop.radiusXProperty().bind(pane.widthProperty().multiply(0.3));
        arcTop.radiusYProperty().bind(pane.heightProperty().multiply(0.13333333));
        
        // Create bottom arc
        Arc arcBottom = new Arc(100, 120, 60, 20, 0, -180);
        arcBottom.setFill(Color.WHITE);
        arcBottom.setStroke(Color.BLACK);
        arcBottom.centerXProperty().bind(pane.widthProperty().divide(2));
        arcBottom.centerYProperty().bind(pane.heightProperty().multiply(0.8));
        arcBottom.radiusXProperty().bind(pane.widthProperty().multiply(0.3));
        arcBottom.radiusYProperty().bind(pane.heightProperty().multiply(0.13333333));
        
        pane.getChildren().addAll(line1, line2, ellipseTop, arcTop, arcBottom);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 150);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
    }
    
}
