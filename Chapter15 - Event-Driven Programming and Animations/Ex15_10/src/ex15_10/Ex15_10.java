/*
    Enter and display a string) Write a program that receives a string from the
    keyboard and displays it on a pane. The Enter key signals the end of a string.
    Whenever a new string is entered, it is displayed on the pane.
 */
package ex15_10;

import javafx.application.Application;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex15_10 extends Application{
    private String str = "";
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        StackPane pane = new StackPane();
        
        pane.setOnKeyPressed(e ->{
            // When letter or key is pressed add to the string
            if(Character.isLetterOrDigit(e.getText().charAt(0))){
                str += e.getText().charAt(0);
            }
            else if(e.getCode() == ENTER){
                // clear the pane
                pane.getChildren().clear();
                // display the string
                pane.getChildren().add(new Text(str));
                str = "";
            }
            
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 100, 100);
        primaryStage.setTitle("Exercise_15_10"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
        pane.requestFocus();
    }
    
}
