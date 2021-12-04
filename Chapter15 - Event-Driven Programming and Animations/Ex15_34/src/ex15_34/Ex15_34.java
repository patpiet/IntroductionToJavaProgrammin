/*
    (Simulation: self-avoiding random walk) A self-avoiding walk in a lattice is a
    path from one point to another that does not visit the same point twice. Selfavoiding
    walks have applications in physics, chemistry, and mathematics. They
    can be used to model chain-like entities such as solvents and polymers. Write
    a program that displays a random path that starts from the center and ends at a
    point on the boundary, as shown in Figure 15.37a or ends at a dead-end point
    (i.e., surrounded by four points that have already been visited), as shown in
    Figure 15.37b. Assume the size of the lattice is 16 by 16.
 */
package ex15_34;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex15_34 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create walk Pane
        WalkPane walkPane = new WalkPane();
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
