/*
    Rotate a rectangle) Write a program that rotates a rectangle 15 degrees right
    when the Rotate button is clicked, as shown in Figure 15.24b.
 */
package ex15_02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex15_02 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create rectangle object
        Rectangle rectangle = new Rectangle(50, 50, 50, 80);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button btRotate = new Button("Rotate");
        hBox.getChildren().add(btRotate);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(rectangle);
        borderPane.setBottom(hBox);

        
        // Event handler
        btRotate.setOnAction(e ->rectangle.setRotate(rectangle.getRotate() + 15));
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("Exercise_15_02"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
        btRotate.requestFocus();
    }

}
