/*
    Write a program that displays a 10-by-10 square matrix,
    as shown in Figure 14.45a. Each element in the matrix is 0 or 1, randomly generated.
    Display each number centered in a text field. Use TextField’s setText
    method to set value 0 or 1 as a string.
 */
package ex14_07;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex14_07 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        
        // Assign a textField to each cell in the matrix
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int random = (int) (Math.random() * 2);
                // set the textField
                TextField textField = new TextField();
                textField.setText(random + "");
                textField.setPrefSize(25, 25);
                
                pane.add(textField, i, j);
            }
        }
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_07"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
    }
    
}
