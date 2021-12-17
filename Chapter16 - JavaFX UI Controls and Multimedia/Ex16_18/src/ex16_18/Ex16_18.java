/*
    (Simulation: a running fan) Rewrite Programming Exercise 15.28 to add a slider
    to control the speed of the fan, as shown in Figure 16.43c.
 */
package ex16_18;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_18 extends Application{
    // Controls the reverse handlers
    boolean isReverse = false;
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        //  Create a circle
        Circle c = new Circle(150, 135, 135, Color.WHITE);
        c.setStroke(Color.BLACK);
        // Create four arcs and store it in array
        Arc[] a = new Arc[4];
        for (int j = 0; j < 4; j++) {
            a[j] = new Arc(150, 135, 120, 120, 90 * j, 30);
            a[j].setStroke(Color.BLACK);
            a[j].setFill(Color.BLACK);
            a[j].setType(ArcType.ROUND);
        }
        pane.getChildren().add(c);
        pane.getChildren().addAll(a);

        // Create hbox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        // Create buttons
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        hBox.getChildren().addAll(btPause, btResume, btReverse);

        // Handle the animation
        EventHandler<ActionEvent> eventHandler = e -> {
            for (Arc arc : a) {
                if (isReverse) {
                    arc.setStartAngle(arc.getStartAngle() + 1);
                } else {
                    arc.setStartAngle(arc.getStartAngle() - 1);
                }
            }

        };
        // Create animation
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(2.5), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
        // Create slider
        Slider slSpeed = new Slider(0.1, 2, 1);

        // Event handlers when buttons clicked
        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> {
            System.out.println(animation.getRate());
            if (isReverse) {
                isReverse = false;
            } else {
                isReverse = true;
            }
        });
        // Event handler for slider
        animation.rateProperty().bind(slSpeed.valueProperty());
        
        // Create vbox
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(hBox, pane, slSpeed);

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 300, 320);
        primaryStage.setTitle("Exercise_15_28"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
}
