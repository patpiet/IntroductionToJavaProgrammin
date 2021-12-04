/*
    (Animation: self-avoiding random walk) Revise the preceding exercise to display
    the walk step by step in an animation, as shown in Figure 15.37c and d.
 */
package ex15_35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex15_35 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create walk Pane
        WalkPane walkPane = new WalkPane(16);
        walkPane.setPrefSize(160, 160);
        
        // Create vBox
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);
        
        // Create button
        Button btStart = new Button("Start");
        
        pane.getChildren().addAll(walkPane, btStart);
        
        
        btStart.setOnAction(e ->{
            walkPane.createWalk();
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_34"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
