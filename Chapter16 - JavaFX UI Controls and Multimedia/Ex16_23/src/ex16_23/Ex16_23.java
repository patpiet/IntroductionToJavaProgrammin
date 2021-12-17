/*
        (Create an image animator with audio) Create animation in Figure 16.46b to
    meet the following requirements:
    ■ Allow the user to specify the animation speed in a text field.
    ■ Get the number of iamges and image’s file-name prefix from the user. For
    example, if the user enters n for the number of images and L for the image
    prefix, then the files are L1.gif, L2.gif, and so on, to Ln.gif. Assume that the
    images are stored in the image directory, a subdirectory of the program’s
    class directory. The animation displays the images one after the other.
    ■ Allow the user to specify an audio file URL. The audio is played while the
    animation runs.
 */
package ex16_23;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_23 extends Application {

    // Control index of image to display
    int index = 0;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();

        // Create button for starting animation
        Button btStart = new Button("Start animation");

        // Create pane for images
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(400, 200);

        // Creaate grid pane for the menu
        GridPane gridPane = new GridPane();

        Label lb = new Label("Enter information for animation.");
        Label lbSpeed = new Label("Animation speed in miliseconds ");
        TextField tfSpeed = new TextField();
        Label lbPrefix = new Label("Image file prefix ");
        TextField tfPrefix = new TextField();
        Label lbImagesNumber = new Label("Number of images ");
        TextField tfImagesNumber = new TextField();
        Label lbUrl = new Label("Audio file URL");
        TextField tfUrl = new TextField();

        // set up the nodes in the grid pane
        gridPane.add(lb, 0, 0);
        gridPane.add(lbSpeed, 0, 1);
        gridPane.add(tfSpeed, 1, 1);
        gridPane.add(lbPrefix, 0, 2);
        gridPane.add(tfPrefix, 1, 2);
        gridPane.add(lbImagesNumber, 0, 3);
        gridPane.add(tfImagesNumber, 1, 3);
        gridPane.add(lbUrl, 0, 4);
        gridPane.add(tfUrl, 1, 4);

        pane.setRight(btStart);
        pane.setCenter(stackPane);
        pane.setBottom(gridPane);

        // Handler for button ''Start Animation''
        btStart.setOnAction(e -> {
            // store details about animation
            double speedMilliseconds = Double.parseDouble(tfSpeed.getText());
            String prefix = tfPrefix.getText();
            int imagesNum = Integer.parseInt(tfImagesNumber.getText());
            String audioUrl = tfUrl.getText();

            // Create audio clip object
            AudioClip audio = new AudioClip(audioUrl);
            audio.play();
            index = 1;
            
            // Create handler for animation
            EventHandler<ActionEvent> eventHandler = ex -> {
                // Display image
                stackPane.getChildren().clear();
                stackPane.getChildren().add(new ImageView(new Image("image/" + prefix + "" + index + ".png")));
                index++;
            };
            // Create animation
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(speedMilliseconds), eventHandler));
            animation.setCycleCount(imagesNum);
            animation.play();
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_23"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

}
