/*
    Write a program that lets the user click the Refresh button to
    display four cards from a deck of 52 cards, as shown in Figure 15.24a. (See the
    hint in Programming Exercise 14.3 on how to obtain four random cards.)
 */
package ex15_01;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Ex15_01 extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create list with card numbers
        ArrayList<Integer> cards = createList();
        
        Collections.shuffle(cards);
        
        // Create pane to store card objects
        HBox hBox = addCards(cards);
        
        // Create refresh button
        Button btRefresh = new Button("Refresh");
        

        // Create pane
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, btRefresh);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        
        // Event handler
        btRefresh.setOnAction(e -> {
            vBox.getChildren().clear();
            Collections.shuffle(cards);
            vBox.getChildren().addAll(addCards(cards), btRefresh);
        });
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise_15_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage. 
        
        btRefresh.requestFocus();
       
    }
    
    // Returns pane with 4 images of first cards on the list 
    public static HBox addCards(ArrayList<Integer> list){
        HBox hBox = new HBox(5);
        
        for (int i = 0; i < 4; i++) {
            Image image = new Image("image/" + list.get(i) + ".png");
            
            ImageView img = new ImageView(image);
            
            hBox.getChildren().add(img);
        }
        
        return hBox;
    }
    
    // Returns list with numbers 1-52
    public static ArrayList<Integer> createList() {
        ArrayList<Integer> cards = new ArrayList<>();

        for (int i = 1; i < 53; i++) {
            cards.add(i);
        }

        return cards;
    }
}
