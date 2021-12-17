/*
    (Simulation: raise flag and play anthem) Write a program that displays a flag
    rising up, as shown in Figure 15.14. As the national flag rises, play the national
    anthem. (You may use a flag image and anthem audio file from Listing 16.15.)
 */
package ex16_26;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_26 extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        pane.setPrefSize(400, 200);
        // upload image 
        Image imgUs = new Image("image/us.png");
        ImageView imgViewUs = new ImageView(imgUs);
        imgViewUs.setFitWidth(200);
        imgViewUs.setFitHeight(100);
        // Upload audio
        AudioClip acAnthem = new AudioClip("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
        
        //Create line as a path for animation 
        Line lnPath = new Line(400 * 0.3, 200, 400 * 0.3, 200 * 0.3);
        lnPath.setStroke(Color.WHITE);
        
        pane.getChildren().addAll(lnPath, imgViewUs);
        
        // Create path transition
        PathTransition pt = new PathTransition(new Duration(10000), lnPath, imgViewUs);
        // start animation and audio
        pt.play();
        acAnthem.play(0.1);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_26"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
