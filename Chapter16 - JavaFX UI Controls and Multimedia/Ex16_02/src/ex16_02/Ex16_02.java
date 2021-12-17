/*
    (Select geometric figures) Write a program that draws various figures, as shown
    in Figure 16.36b. The user selects a figure from a radio button and uses a check
    box to specify whether it is filled.
 */
package ex16_02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex16_02 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create stack pane and set initial figure
        StackPane paneForFigure = new StackPane();
        paneForFigure.getChildren().add(new Rectangle(10, 10, 80, 50));
        paneForFigure.getChildren().get(0).setStyle("-fx-fill: null; -fx-stroke: black");
        paneForFigure.setPrefSize(400, 100);
        paneForFigure.setStyle("-fx-border-color: gray");

        // Create pane for buttons
        HBox paneForButtons = new HBox(10);
        paneForButtons.setAlignment(Pos.CENTER);

        // Create buttons
        RadioButton rbCircle = new RadioButton("Circle");
        RadioButton rbRectangle = new RadioButton("Rectangle");
        RadioButton rbEllipse = new RadioButton("Ellipse");
        CheckBox cbFill = new CheckBox("Fill");
        // Gropu the buttons
        ToggleGroup group = new ToggleGroup();
        rbCircle.setToggleGroup(group);
        rbRectangle.setToggleGroup(group);
        rbEllipse.setToggleGroup(group);
        rbRectangle.setSelected(true);

        paneForButtons.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, cbFill);

        BorderPane pane = new BorderPane();
        pane.setTop(paneForFigure);
        pane.setBottom(paneForButtons);

        // Fill/Unfill the figure
        cbFill.setOnAction(e -> {
            if (!cbFill.isSelected()) {
                paneForFigure.getChildren().get(0).setStyle("-fx-fill: null; -fx-stroke: black");
            } else {
                paneForFigure.getChildren().get(0).setStyle("-fx-fill: black; -fx-stroke: black");
            }
        });
        
        // Change the figure displayed
        rbCircle.setOnAction(e -> {
            // Clear the pane and add figure
            paneForFigure.getChildren().clear();
            paneForFigure.getChildren().add(new Circle(10, 10, 40));
            if (!cbFill.isSelected()) {
                paneForFigure.getChildren().get(0).setStyle("-fx-fill: null; -fx-stroke: black");
            }
        });
        rbRectangle.setOnAction(e -> {
            // Clear the pane and add figure
            paneForFigure.getChildren().clear();
            paneForFigure.getChildren().add(new Rectangle(10, 10, 80, 50));
            if (!cbFill.isSelected()) {
                paneForFigure.getChildren().get(0).setStyle("-fx-fill: null; -fx-stroke: black");
            }
        });
        rbEllipse.setOnAction(e -> {
            // Clear the pane and add figure
            paneForFigure.getChildren().clear();
            paneForFigure.getChildren().add(new Ellipse(10, 10, 45, 35));
            if (!cbFill.isSelected()) {
                paneForFigure.getChildren().get(0).setStyle("-fx-fill: null; -fx-stroke: black");
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_02"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.

    }

}
