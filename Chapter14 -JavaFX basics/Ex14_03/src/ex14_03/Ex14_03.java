/*
    Write a program that displays three cards randomly
    selected from a deck of 52, as shown in Figure 14.43c. The card image files
    are named 1.png, 2.png, …, 52.png and stored in the image/card directory.
    All three cards are distinct and selected randomly. Hint: You can select random
    cards by storing the numbers 1–52 to an array list, perform a random shuffle
    introduced in Section 11.12, and use the first three numbers in the array list as
    the file names for the image.
 */
package ex14_03;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex14_03 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Create list with cards
        ArrayList<Integer> cards = createList();
        // Shuffle the list
        Collections.shuffle(cards);
        
        HBox hBox = addCards(cards);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(hBox);
        primaryStage.setTitle("Exercise_14_03"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // Returns pane with 3 images of first cards on the list 
    public static HBox addCards(ArrayList<Integer> list){
        HBox hBox = new HBox(5);
        
        for (int i = 0; i < 3; i++) {
            Image image = new Image("image/" + list.get(i) + ".png");
            
            ImageView img = new ImageView(image);
            
            hBox.getChildren().add(img);
        }
        
        return hBox;
    }
    
    // Returns list with numbers 1-52
    public static ArrayList<Integer> createList(){
        ArrayList<Integer> cards = new ArrayList<>();
        
        for (int i = 1; i < 53; i++) {
            cards.add(i);
        }
        
        return cards;
    }
}
