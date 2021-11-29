/*
    (Display a 3 * 3 grid) Write a program that displays a 3 * 3 grid, as shown in
    Figure 14.47c. Use red color for vertical lines and blue for horizontals. The lines
    are automatically resized when the window is resized.
 */
package ex14_16;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Ex14_16 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creae pane
        Pane pane = new Pane();
        
        // list to store lines
        ArrayList<Shape> list = new ArrayList<>();
        
        // Create vertical lines 
        Line leftLine = new Line();
        
        leftLine.startXProperty().bind(pane.widthProperty().multiply(0.33));
        leftLine.setStartY(0);
        leftLine.endXProperty().bindBidirectional(leftLine.startXProperty());
        leftLine.endYProperty().bind(pane.heightProperty());
        leftLine.setStroke(Color.RED);
        list.add(leftLine);
        
        Line rightLine = new Line();
        
        rightLine.startXProperty().bind(pane.widthProperty().multiply(0.66));
        rightLine.setStartY(0);
        rightLine.endXProperty().bindBidirectional(rightLine.startXProperty());
        rightLine.endYProperty().bind(pane.heightProperty());
        rightLine.setStroke(Color.RED);
        list.add(rightLine);
        
        // Create horizontal lines
        Line topLine = new Line();
        
        topLine.setStartX(0);
        topLine.startYProperty().bind(pane.heightProperty().multiply(0.33));
        topLine.endXProperty().bind(pane.widthProperty());
        topLine.endYProperty().bindBidirectional(topLine.startYProperty());
        topLine.setStroke(Color.BLUE);
        list.add(topLine);

        
        Line bottomLine = new Line();
        
        bottomLine.setStartX(0);
        bottomLine.startYProperty().bind(pane.heightProperty().multiply(0.66));
        bottomLine.endXProperty().bind(pane.widthProperty());
        bottomLine.endYProperty().bindBidirectional(bottomLine.startYProperty());
        bottomLine.setStroke(Color.BLUE);
        list.add(bottomLine);
        

        
        
        pane.getChildren().addAll(list);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Exercise_14_16"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
