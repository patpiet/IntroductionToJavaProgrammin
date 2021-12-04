/*
    (Animation: ball on curve) Write a program that animates a ball moving along
    a sine curve, as shown in Figure 15.32. When the ball gets to the right border,
    it starts over from the left. Enable the user to resume/pause the animation with
    a click on the left/right mouse button.
 */
package ex15_25;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex15_25 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        // Create sinus
        Polyline sinus = new Polyline();
        ObservableList<Double> listSin = sinus.getPoints();
        for (int x = -225; x <= 225; x++) {
            listSin.add(x + 225.0);
            listSin.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI) + 75);
        }
        sinus.setStroke(Color.RED);
        
        // Create y and x axis
        Line lineX = new Line(0, 175, 480, 175);

        Line lineY = new Line(225, 250, 225, 30);

        
        // Create arrows linked with both axis
        Polyline arrowY = new Polyline();
        arrowY.getPoints().addAll(new Double[]{
            210.0, 45.0,
            225.0, 30.0,
            240.0, 45.0
        });

        Polyline arrowX = new Polyline();
        arrowX.getPoints().addAll(new Double[]{
            460.0, 160.0,
            480.0, 175.0,
            460.0, 190.0
        });

        // Create text objects to label axis
        Text x = new Text("x");
        x.setX(480);
        x.setY(160);
        x.setFont(new Font("Times Roman", 20));

        Text y = new Text("y");
        y.setX(245);
        y.setY(30);
        y.setFont(new Font("Times Roman", 20));
        
        // Create axis values
        Text zero = new Text("0");
        zero.setX(228);
        zero.setY(185);
        
        // Create circle to animate
        Circle circle = new Circle(10, 10, 15);
        
        // Create path transmition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(8000));
        pt.setPath(sinus);
        pt.setNode(circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        // resume/pause the animation when left/right clicked
        pane.setOnMouseClicked(e -> {
            if(e.getButton() == SECONDARY)
            pt.pause();
                });
        pane.setOnMouseReleased(e ->{
            if(e.getButton() == PRIMARY)
            pt.play();
                });        
        
        pane.getChildren().addAll(sinus, lineX, lineY, arrowX, arrowY, x, y, zero, circle);
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_18"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

}
