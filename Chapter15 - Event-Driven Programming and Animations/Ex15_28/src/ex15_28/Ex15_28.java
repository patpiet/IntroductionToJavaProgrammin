/*
    (Display a running fan) Write a program that displays a running fan, as shown
    in Figure 15.33c. Use the Pause, Resume, Reverse buttons to pause, resume,
    and reverse fan running.
 */
package ex15_28;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex15_28 extends Application {
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

        // Event handlers when buttons clicked
        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> {
            if (isReverse) {
                isReverse = false;
            } else {
                isReverse = true;
            }
        });

        // Create vbox
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(pane, hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setTitle("Exercise_15_28"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
}
