/*
    Write a program that displays a tic-tac-toe board, as shown
    in Figure 14.43b. A cell may be X, O, or empty. What to display at each cell is
    randomly decided. The X and O are images in the files x.gif and o.gif.
 */
package ex14_02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex14_02 extends Application{



    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create GridPane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);
        
        // Create X and O objects
        Image imageX = new Image("image/x.png");
        Image imageO = new Image("image/o.png");
        
        // Fill each cell on the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            
                // randomly assign an image or empty space to a cell
                int random = (int) (Math.random() * 3);
                ImageView element = null;
                switch (random){
                    case 0:
                        element = new ImageView(imageX);break;
                    case 1:
                        element = new ImageView(imageO);break;
                    case 2:
                        element = new ImageView();break;
                }
                element.setFitWidth(50);
                element.setFitHeight(50);
               pane.add(element, i, j);  
            }
            
        }
        
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 150, 150);
        primaryStage.setTitle("Exercise_14_02"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
