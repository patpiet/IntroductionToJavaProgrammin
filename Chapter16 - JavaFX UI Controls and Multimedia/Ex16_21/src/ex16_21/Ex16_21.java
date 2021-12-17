/*
    Count-down stopwatch) Write a program that allows the user to enter time in
    seconds in the text field and press the Enter key to count down the seconds,
    as shown in Figure 16.45d. The remaining seconds are redisplayed every
    one second. When the seconds are expired, the program starts to play music
    continuously.
 */
package ex16_21;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_21 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        IntegerProperty seconds = new SimpleIntegerProperty();
        
        // create stack pane
        StackPane pane = new StackPane();
        
        // Create text field
        TextField tf = new TextField();
        tf.setAlignment(Pos.CENTER);
        pane.getChildren().add(tf);
        
        // Create media player object with mp3 audio
        MediaPlayer mp = new MediaPlayer(new Media("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"));
        mp.setCycleCount(Timeline.INDEFINITE);
        
        // count the seconds down timeline object
        EventHandler<ActionEvent> eventHandler = e ->{
            // count down the seconds
            if(seconds.get() > 0){
                seconds.set(seconds.getValue() - 1);
                tf.setText(seconds.get() + "");
            }
            // start playing audio
            else{
                mp.play();
            }
        
        };
        // Create time line object to count the seconds 
        Timeline counter = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        counter.setCycleCount(Timeline.INDEFINITE);
        
        // action handler for text field
        tf.setOnAction(e ->{
            seconds.setValue(Integer.parseInt(tf.getText()));
            counter.play();
            mp.stop();
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_21"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
