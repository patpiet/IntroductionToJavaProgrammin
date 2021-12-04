/*
    (Auto resize stop sign) Rewrite Programming Exercise 14.15 so that the stop
    sign’s width and height are automatically resized when the window is resized.
 */
package ex15_23;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Ex15_23 extends Application {
    // Create stack pane

    StackPane pane = new StackPane();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Crate octagon object
        Polygon octagon = new Polygon();
        octagon.setRotate(-22.5);
        octagon.setFill(Color.RED);

        final double WIDTH = 200, HEIGHT = 200;

        double centerX = WIDTH / 2, centerY = HEIGHT / 2;

        // Store the points
        ObservableList<Double> list = octagon.getPoints();

        // Create octagon points
        for (int i = 0; i < 8; i++) {
            list.add(centerX + 100 * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY + 100 * Math.sin(2 * i * Math.PI / 8));
        }

        // Create "STOP" text
        Text text = new Text("STOP");
        text.setFont(new Font("Times Roman", 45));
        text.setFill(Color.WHITE);

        

        // Add nodes
        pane.getChildren().add(octagon);
        pane.getChildren().add(text);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_14_15"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.

        pane.widthProperty().addListener(ov -> {
            addPoints(list);
        });
    }
    // Assigns the points to the octagon points list
    public void addPoints(ObservableList<Double> list) {
        list.clear();
        for (int i = 0; i < 8; i++) {
            list.add(pane.getWidth() / 2.0 + pane.getWidth() / 2.0 * Math.cos(2 * i * Math.PI / 8));
            list.add(pane.getHeight() / 2.0 + pane.getHeight() / 2.0 * Math.sin(2 * i * Math.PI / 8));
        }
    }

}
