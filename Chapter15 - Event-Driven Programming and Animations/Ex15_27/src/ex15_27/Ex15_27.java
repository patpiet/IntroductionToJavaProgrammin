/*
    (Control a moving text) Write a program that displays a moving text, as shown
    in Figure 15.33a and b. The text moves from left to right circularly. When it
    disappears in the right, it reappears from the left. The text freezes when the
    mouse is pressed and moves again when the button is released.
 */
package ex15_27;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex15_27 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Pane
        Pane pane = new Pane();
        
        // Create line
        Line line = new Line(55, 100, 330, 100);
        line.setStroke(Color.WHITE);
        
        // Create text to be moved
        Text text = new Text("Programming is fun");
        
        // Create path transition
        PathTransition pt = new PathTransition(Duration.millis(4000), line, text);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        
        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());
        
        pane.getChildren().addAll(line, text);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("Exercise_15_27"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
