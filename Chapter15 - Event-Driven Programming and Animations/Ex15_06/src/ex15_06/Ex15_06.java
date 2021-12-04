/*
    Alternate two messages) Write a program to display the text Java is fun
    and Java is powerful alternately with a mouse click.
 */
package ex15_06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex15_06 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a Stack Pane
        StackPane pane = new StackPane();
        
        Text text = new Text("Java is Fun");
        
        pane.setOnMouseClicked(e ->{
            if(text.getText().equals("Java is Fun")){
                text.setText("Java is powerful");
            }else
                text.setText("Java is Fun");
        });
        
        
        pane.getChildren().add(text);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane,200, 200);
        primaryStage.setTitle("Exercise_15_06"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
