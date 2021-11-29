/*
    Write a program that paints a smiley face, as shown in
    Figure 14.46a.
*/
package ex14_11;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Ex14_11 extends Application{ 
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        // Create head (Circle0
        Circle head = new Circle(150, 150, 100);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        
        // Create nose (Triangle)
        Polygon nose = new Polygon();
        nose.setFill(Color.WHITE);
        nose.setStroke(Color.BLACK);
        nose.setRotate(30);
        
        ObservableList<Double> list = nose.getPoints();
        
        for (int i = 0; i < 3; i++) {
            list.add(150 + 30 * Math.cos(2* i * Math.PI /3));
            list.add(160 - 30 * Math.sin(2* i * Math.PI /3));
        }
        
        // Create smile (arc)
        Arc smile = new Arc(150, 150, 70, 70, -30, -120);
        smile.setFill(Color.WHITE);
        smile.setStroke(Color.BLACK);
        
        // Create left eye
        Ellipse leftEyeEllipse = new Ellipse(110, 110, 25, 18);
        leftEyeEllipse.setFill(Color.WHITE);
        leftEyeEllipse.setStroke(Color.BLACK);
        
        Circle leftEyeCircle = new Circle(110, 110, 10);
        
        // Create right eye
        Ellipse rightEyeEllipse = new Ellipse(190, 110, 25, 18);
        rightEyeEllipse.setFill(Color.WHITE);
        rightEyeEllipse.setStroke(Color.BLACK);
        
        Circle rightEyeCircle = new Circle(190, 110, 10);
        
        
        // Add all part to the pane
        pane.getChildren().add(head);
        pane.getChildren().add(nose);
        pane.getChildren().add(smile);
        pane.getChildren().add(leftEyeEllipse);
        pane.getChildren().add(leftEyeCircle);
        pane.getChildren().add(rightEyeEllipse);
        pane.getChildren().add(rightEyeCircle);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
