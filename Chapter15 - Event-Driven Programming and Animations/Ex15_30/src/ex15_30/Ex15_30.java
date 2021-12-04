/*
    (Slide show) Twenty-five slides are stored as image files (slide0.jpg, slide1
    .jpg, . . . , slide24.jpg) in the image directory downloadable along with the
    source code in the book. The size of each image is 800 * 600. Write a program
    that automatically displays the slides repeatedly. Each slide is shown for
    two seconds. The slides are displayed in order. When the last slide finishes, the
    first slide is redisplayed, and so on. Click to pause if the animation is currently
    playing. Click to resume if the animation is currently paused.
 */
package ex15_30;

import static javafx.animation.Animation.Status.RUNNING;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex15_30 extends Application {

    // Create stackPane
    StackPane pane = new StackPane();
    // control the number of slide
    int counter = 0;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        addImage(counter);

        // Event handler fo the animation
        EventHandler<ActionEvent> eventHandler = e -> {
            // Restart the slide show
            if(counter == 24){
                counter = -1;
            }
            pane.getChildren().clear();
            counter++;
            addImage(counter);
        };

        
        // Create timeline animation
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(2000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        // pause/resume wnhe clicked
        pane.setOnMouseClicked(e ->{
            if (animation.getStatus() == RUNNING){
                animation.pause();
            }else
                animation.play();
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Exercise_15_30"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    // adds next slide to the pane
    public void addImage(int counter) {
        Image image = new Image("image/slide" + counter + ".png");

        ImageView img = new ImageView(image);
        
        pane.getChildren().add(img);
    }

}
