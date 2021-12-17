/*
    Traffic lights) Write a program that simulates a traffic light. The program lets
    the user select one of three lights: red, yellow, or green. When a radio button
    is selected, the light is turned on. Only one light can be on at a time (see
    Figure 16.37a). No light is on when the program starts.
 */
package ex16_03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex16_03 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane paneForLights = new Pane();
        paneForLights.setPrefSize(150, 100);
        
        // Create the base of the lights
        Rectangle rectangle = new Rectangle(59, 5, 27, 80);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        
        // Create VBox to store circles
        VBox vBox = new VBox(5);
        // Create and formt the circles
        Circle redLight = new Circle(72.5, 20, 10);
        redLight.setFill(null);
        redLight.setStroke(Color.BLACK);
        Circle yellowLight = new Circle(72.5, 45, 10);
        yellowLight.setFill(null);
        yellowLight.setStroke(Color.BLACK);
        Circle greenLight = new Circle(72.5, 70, 10);
        greenLight.setFill(null);
        greenLight.setStroke(Color.BLACK);
        
        paneForLights.getChildren().addAll(rectangle, redLight, yellowLight, greenLight);
        
        // Create HBox for radio buttons
        HBox paneForRadioButtons = new HBox(5);
        
        // Create radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");
        
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        
        paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbGreen);
        
        rbRed.setOnAction(e -> {
            yellowLight.setFill(null);
            greenLight.setFill(null);
            redLight.setFill(Color.RED);
        });
        
        rbYellow.setOnAction(e -> {
            redLight.setFill(null);
            greenLight.setFill(null);
            yellowLight.setFill(Color.YELLOW);
        });
        
        rbGreen.setOnAction(e -> {
            yellowLight.setFill(null);
            redLight.setFill(null);
            greenLight.setFill(Color.GREEN);
        });
        
        BorderPane pane = new BorderPane();
        pane.setTop(paneForLights);
        pane.setBottom(paneForRadioButtons);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_03"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
