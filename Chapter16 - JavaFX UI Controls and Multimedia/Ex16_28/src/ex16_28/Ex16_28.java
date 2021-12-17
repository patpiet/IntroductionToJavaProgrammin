/*
    (Slide show) Programming Exercise 15.30 developed a slide show using images.
    Rewrite that program to develop a slide show using text files. Suppose ten text
    files named slide0.txt, slide1.txt, . . . , and slide9.txt are stored in the text directory.
    Each slide displays the text from one file. Each slide is shown for one second,
    and the slides are displayed in order. When the last slide finishes, the first
    slide is redisplayed, and so on. Use a text area to display the slide.
 */
package ex16_28;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static javafx.animation.Animation.Status.RUNNING;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_28 extends Application{
    // SET NUMBER OF SLIDES
    final int NUMBER_OF_SLIDES = 9;
    // Create stackPane
    StackPane pane = new StackPane();
    // control the number of slide
    int counter = 0;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        addSlide(counter);

        // Event handler fo the animation
        EventHandler<ActionEvent> eventHandler = e -> {
            // Restart the slide show
            if(counter == NUMBER_OF_SLIDES){
                counter = -1;
            }
            // Clear the pane
            pane.getChildren().clear();
            counter++;
            try {
                addSlide(counter);
            } catch (FileNotFoundException ex) {
                System.out.println("File with index" + counter + " not found");
            }
        };

        
        // Create timeline animation
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
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
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_15_30"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    // adds next slide to the pane
    public void addSlide(int counter) throws FileNotFoundException {
        Scanner input = new Scanner(new File("slides/slide" + counter + ".txt"));
        String description = "";
        while(input.hasNextLine()){
            description += input.nextLine() + "\n";
        }
        TextArea ta = new TextArea(description);

        pane.getChildren().add(new ScrollPane(ta));
    }
    
}
