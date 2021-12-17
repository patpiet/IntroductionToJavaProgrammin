/*
    (Play, loop, and stop a sound clip) Write a program that meets the following
    requirements:
    ■ Get an audio file from the class directory using AudioClip.
    ■ Place three buttons labeled Play, Loop, and Stop, as shown in Figure 16.46a.
    ■ If you click the Play button, the audio file is played once. If you click the
    Loop button, the audio file keeps playing repeatedly. If you click the Stop
    button, the playing stops.
 */
package ex16_22;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Ex16_22 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create hbox
        HBox pane = new HBox(10);
        
        // Create buttons
        Button btPlay = new Button("Play");
        Button btLoop = new Button("Loop");
        Button btStop = new Button("Stop");
        
        pane.getChildren().addAll(btPlay, btLoop, btStop);
        
        // Create audio object
        AudioClip audio = new AudioClip("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");

        // Create action handlers for buttons
        btPlay.setOnAction(e -> audio.play());
        btStop.setOnAction(e -> audio.stop());
        btLoop.setOnAction(e -> audio.setCycleCount(Timeline.INDEFINITE));
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_22"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
