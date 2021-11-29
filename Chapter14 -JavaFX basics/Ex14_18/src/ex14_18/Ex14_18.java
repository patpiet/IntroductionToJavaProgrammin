/*
    Write a program that draws a diagram for the function
    f(x) = x2 (see Figure 14.48b).
 */
package ex14_18;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_18 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        // Create slope
        Polyline polyline = new Polyline();
        ObservableList<Double> slopePoints = polyline.getPoints();
        double scaleFactor = 0.0125;
        
        for (int x = -100; x <= 100; x++) {
            slopePoints.add(x + 150.0);
            slopePoints.add(scaleFactor * x * x + 50);
        }
        polyline.setRotate(180);
        
        // Create y and x axis
        Line lineX = new Line(0, 175, 280, 175);

        Line lineY = new Line(150,250, 150, 30);
        
        // Create arrows linked with bots axis
        Polyline arrowX = new Polyline();
        arrowX.getPoints().addAll(new Double[]{
            135.0, 45.0,
            150.0, 30.0,
            165.0, 45.0
        });
        
        Polyline arrowY = new Polyline();
        arrowY.getPoints().addAll(new Double[]{
            260.0, 160.0,
            280.0, 175.0,
            260.0, 190.0
        });
        
        
        
        // Create text objects to label axis
        Text x = new Text("x");
        x.setX(280);
        x.setY(160);
        x.setFont(new Font("Times Roman", 20));
        
        Text y = new Text("y");
        y.setX(170);
        y.setY(30);
        y.setFont(new Font("Times Roman", 20));
        

        pane.getChildren().add(polyline);
        pane.getChildren().add(lineX);
        pane.getChildren().add(lineY);
        pane.getChildren().add(arrowX);
        pane.getChildren().add(arrowY);
        pane.getChildren().add(x);
        pane.getChildren().add(y);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Exercise_14_18"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

}
