/*
    Write two programs, such that one displays the
    mouse position when the mouse button is clicked (see Figure 15.26a) and the
    other displays the mouse position when the mouse button is pressed and ceases
    to display it when the mouse button is released.

    ''Just the second one''
 */
package ex15_08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex15_08 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        // Create text object with position
        Text text = new Text();
        
        pane.setOnMousePressed(e ->{
            text.setText("(" + e.getSceneX() + ", " + e.getSceneY() + ")");
            text.setX(e.getSceneX());
            text.setY(e.getSceneY());
        });
        
        pane.setOnMouseReleased(e ->{
            text.setText(null);
        });
        
        pane.getChildren().add(text);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise_15_08"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
