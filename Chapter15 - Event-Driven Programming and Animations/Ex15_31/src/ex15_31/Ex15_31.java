/*
    (Geometry: pendulum) Write a program that animates a pendulum swinging,
    as shown in Figure 15.35. Press the UP arrow key to increase the speed and the
    DOWN key to decrease it. Press the S key to stop animation and the R key to
resume it.
 */
package ex15_31;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex15_31 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create a pane
        Pane pane = new Pane();
        
        // Create small circle
        Circle circle = new Circle(150, 20, 3);
        
        // Create arc
        Arc arc = new Arc(150, 100, 150, 75, -30, -120);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.WHITE);
        
        // Create big circle
        Circle bCircle = new Circle(150, 175, 10);
        
        // Create line
        Line line = new Line(150, 20, 150, 175);
        line.endXProperty().bind(bCircle.translateXProperty().add(bCircle.getCenterX()));
        line.endYProperty().bind(bCircle.translateYProperty().add(bCircle.getCenterY()));

        
        pane.getChildren().addAll(arc, circle, line, bCircle);
        
        // Create Path transition
        PathTransition pt = new PathTransition(Duration.millis(10000), arc, bCircle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.setRate(5);
        pt.play();
        
        // Change the speed of animation when key pressed
        pane.setOnKeyPressed(e ->{
            if(e.getCode() == UP){
                pt.setRate(pt.getRate() + 1);
            }
            else if(e.getCode() == DOWN && pt.getRate() != 1){
                pt.setRate(pt.getRate() - 1);
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Exercise_15_31"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
        pane.requestFocus();
    }
    
}
