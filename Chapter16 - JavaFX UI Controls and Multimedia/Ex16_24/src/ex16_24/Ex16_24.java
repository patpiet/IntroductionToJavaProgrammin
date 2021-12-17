/*
    (Revise Listing 16.14 MediaDemo.java) Add a slider to enable the user to set the
    current time for the video and a label to display the current time and the total
    time for the video. As shown in Figure 16.47a, the total time is 5 minutes and 3
    seconds and the current time is 3 minutes and 58 seconds. As the video plays, the
    slider value and current time are continuously updated.
 */
package ex16_24;

import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_24 extends Application {

    private static final String MEDIA_URL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4";

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Upload the video
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(720);
        mediaView.setFitHeight(420);
        mediaPlayer.setVolume(0.5);
        // Create BorderPane
        BorderPane pane = new BorderPane();

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(mediaView);

        // Create HBox for menu 
        HBox hBox = new HBox(10);

        // Create elemnents for menu
        Button btAction = new Button(">");
        Label lbTime = new Label("Time");
        Slider slTime = new Slider();
        Label lbDuration = new Label();
        Label lbVolume = new Label("Volume");
        Slider slVolume = new Slider(0, 1, 0.5);

        hBox.getChildren().addAll(btAction, lbTime, slTime, lbDuration, lbVolume, slVolume);
        hBox.setAlignment(Pos.CENTER);

        pane.setCenter(stackPane);
        pane.setBottom(hBox);

        mediaPlayer.setOnReady(() -> {
            // set up duration label
            // MAX Duration part
            long millis = (long) media.getDuration().toMillis();
            String maxDuration = String.format("/%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                    - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            //bind the current time
            lbDuration.textProperty().bind(
                    Bindings.createStringBinding(() -> {
                        Duration time = mediaPlayer.getCurrentTime();
                        return String.format("%02d:%02d:%02d/" + maxDuration,
                                (int) time.toHours(),
                                (int) time.toMinutes() % 60,
                                (int) time.toSeconds() % 60);
                    },
                            mediaPlayer.currentTimeProperty()));
            
            // set the max value of slider to total duration of media
            slTime.setMax(mediaPlayer.getTotalDuration().toSeconds());
            // bind the slider with duration of media
            mediaPlayer.currentTimeProperty().addListener(ov ->{
                if(!slTime.isPressed())
                slTime.setValue(mediaPlayer.getCurrentTime().toSeconds());
            });
            // play the media when slider clicked
            slTime.setOnMouseReleased(e ->{
                mediaPlayer.seek(Duration.millis(slTime.getValue() * 1000));
            });
            // bind the volume of media to the slider
            slVolume.valueProperty().addListener(ov ->{
                mediaPlayer.setVolume(slVolume.getValue());
            });
        });

        // play/pause media handler
        btAction.setOnAction(e ->{
            if(">".equals(btAction.getText())){
                btAction.setText("||");
                mediaPlayer.play();
            }else{
                btAction.setText(">");
                mediaPlayer.pause();
            }
            
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_24"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

}
