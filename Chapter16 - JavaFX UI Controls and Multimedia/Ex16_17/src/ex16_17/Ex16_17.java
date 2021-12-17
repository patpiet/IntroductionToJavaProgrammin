/*
    (Use ScrollBar and Slider) Write a program that uses scroll bars or sliders
    to select the color for a text, as shown in Figure 16.43b. Four horizontal
    scroll bars are used for selecting the colors: red, green, blue, and opacity
    percentages.
 */
package ex16_17;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex16_17 extends Application {

    // Text to change color
    Text text = new Text("Show colors");
    // Creats sliders
    Slider slRed = new Slider(0, 1, 0);
    Slider slGreen = new Slider(0, 1, 0);
    Slider slBlue = new Slider(0, 1, 0);
    Slider slOpacity = new Slider(0, 1, 1);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Border Pane
        BorderPane pane = new BorderPane();

        // Create a pane for text
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(text);
        
        // Create hBox
        GridPane gridPane = new GridPane();

        // Create slider labels
        Label lbRed = new Label("Red");
        Label lbGreen = new Label("Green");
        Label lbBlue = new Label("Blue");
        Label lbOpacity = new Label("Opacity");

        // Add the sliders to the pane
        gridPane.add(lbRed, 0, 0);
        gridPane.add(slRed, 1, 0);
        gridPane.add(lbGreen, 0, 1);
        gridPane.add(slGreen, 1, 1);
        gridPane.add(lbBlue, 0, 2);
        gridPane.add(slBlue, 1, 2);
        gridPane.add(lbOpacity, 0, 3);
        gridPane.add(slOpacity, 1, 3);

        
        
        pane.setTop(stackPane);
        pane.setBottom(gridPane);
        
        
        // Action event handlers
        slRed.valueProperty().addListener(ov -> changeColor());
        slGreen.valueProperty().addListener(ov -> changeColor());
        slBlue.valueProperty().addListener(ov -> changeColor());
        slOpacity.valueProperty().addListener(ov -> changeColor());
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_17"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    // Change color to the Color form slider values
    void changeColor() {
        text.setFill(new Color(slRed.getValue(), slGreen.getValue(), slBlue.getValue(), slOpacity.getValue()));
    }
}
