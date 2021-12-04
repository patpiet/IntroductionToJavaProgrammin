/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex15_26;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex15_26 extends Application{
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        // Create arc
        Arc arc = new Arc(150, 120, 100, 50, -20, -140);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        
        // Create circle
        Circle circle = new Circle(100, 100, 20);
        
        // Create and configure a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(arc);
        pt.setNode(circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
        
        // Create and configure a fade transition
        FadeTransition ft = new FadeTransition(Duration.millis(4000), circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        
        pane.getChildren().addAll(arc, circle);
        
        // Stop/resume the animations when mouse clicked/released
        pane.setOnMousePressed(e -> {
            pt.pause();
            ft.pause();
        });
        
        pane.setOnMouseReleased(e -> {
            pt.play();
            ft.play();
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Exercise_15_24"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
