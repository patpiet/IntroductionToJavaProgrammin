/*
    (Use radio buttons) Write a GUI program as shown in Figure 16.36a. You can
    use buttons to move the message to the left and right and use the radio buttons to
    change the color for the message displayed.
 */
package ex16_01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex16_01 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox paneForRadioButtons = new HBox(20);
        paneForRadioButtons.setAlignment(Pos.CENTER);
        // Create radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);

        // Create toggle group
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        // Initial color of text - black
        rbBlack.setSelected(true);

        // Create pane for the text
        Pane paneForText = new Pane();
        paneForText.setPrefSize(500, 100);
        paneForText.setStyle("-fx-border-color: gray");
        Text text = new Text("Programming is fun");
        text.setX(200);
        text.setY(50);
        text.yProperty().bind(paneForText.heightProperty().divide(2));
        paneForText.getChildren().add(text);

        // Create Pane for buttons
        HBox paneForButtons = new HBox(10);
        paneForButtons.setAlignment(Pos.CENTER);

        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");
        paneForButtons.getChildren().addAll(btLeft, btRight);

        // Create border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setTop(paneForRadioButtons);
        pane.setBottom(paneForButtons);
        
        // Move text left/right
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        // Change the color 
        rbRed.setOnAction(e ->{
            if(rbRed.isSelected())
                text.setFill(Color.RED);
            });
        rbYellow.setOnAction(e ->{
            if(rbYellow.isSelected())
                text.setFill(Color.YELLOW);
            });
        rbBlack.setOnAction(e ->{
            if(rbBlack.isSelected())
                text.setFill(Color.BLACK);
            });
        rbOrange.setOnAction(e ->{
            if(rbOrange.isSelected())
                text.setFill(Color.ORANGE);
            });
        rbGreen.setOnAction(e ->{
            if(rbGreen.isSelected())
                text.setFill(Color.GREEN);
            });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.

    }

}
