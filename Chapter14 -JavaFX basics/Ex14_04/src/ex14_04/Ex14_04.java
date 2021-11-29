/*
    Write a program that displays five texts vertically, as shown in
    Figure 14.44a. Set a random color and opacity for each text and set the font of
    each text to Times Roman, bold, italic, and 22 pixels.
 */
package ex14_04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_04 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane object
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        // Create font for the texts
        Font font = Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 22.0);
        // Add five text object to the pane
       for (int i = 0; i < 5; i++) {
            // set random color
            Color color = new Color(Math.random(), Math.random(), Math.random(), Math.random());
            Text label = new Text("Java");
            label.setRotate(90);
            label.setFill(color);
            label.setFont(font);
            pane.getChildren().add(label);
        }

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_04"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
