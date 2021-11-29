/*
    Write a program that displays a drawing for the popular hangman
    game, as shown in Figure 14.48a.
 */
package ex14_17;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Ex14_17 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        // Create list to store the shapes
        ArrayList<Shape> shapes = new ArrayList<>(); 
        
        // Create arc object
        Arc arc = new Arc(40, 190, 30, 15, 0, 180);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        
        shapes.add(arc);
        
        // Create vertical line
        Line lineV = new Line(40,175, 40, 20);
        shapes.add(lineV);
        
        // Create horizontal line
        Line lineH = new Line(40, 20, 140, 20);
        shapes.add(lineH);
        
        // Create rope
        Line rope = new Line(140, 20, 140, 35);
        shapes.add(rope);
        
        // Create head
        Circle head = new Circle(140, 50, 15);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        shapes.add(head);
        
        // Create body
        Line body = new Line(140, 65, 140, 120);
        shapes.add(body);
        
        
        // Create legs
        Line leftLeg = new Line(140, 120, 120, 170);
        shapes.add(leftLeg);

        Line rightLeg = new Line(140, 120, 160, 170);
        shapes.add(rightLeg);
        
        // Create arms
        Line leftArm = new Line(128.5, 62, 90, 90);
        shapes.add(leftArm);

        Line rightArm = new Line(151.5, 62, 190, 90);
        shapes.add(rightArm);
        
        // Add shapes to the pane
        pane.getChildren().addAll(shapes);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise_14_17"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
