/*
    (Count-up stopwatch) Write a program that simulates a stopwatch, as shown
    in Figure 16.45a. When the user clicks the Start button, the button’s label is
    changed to Pause, as shown in Figure 16.45b. When the user clicks the Pause
    button, the button’s label is changed to Resume, as shown in Figure 16.45c. The
    Clear button resets the count to 0 and resets the button’s label to Start.
 */
package ex16_20;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_20 extends Application {
    int seconds = 0;
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Border Pane
        BorderPane pane = new BorderPane();

        // Create Stack Pane
        StackPane stackPane = new StackPane();

        // Create stop watch
        Text timeText = new Text();
        timeText.setFont(new Font("Arial", 30));
        stackPane.getChildren().add(timeText);

        // Create Hbox for buttons
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button btControl = new Button("Start");
        Button btClear = new Button("Clear");

        hBox.getChildren().addAll(btControl, btClear);

        pane.setTop(stackPane);
        pane.setBottom(hBox);

        // Create calendar object to control time
        Calendar calendarCounter = Calendar.getInstance();
        
        // reset the calendar object 
        resetCounter(calendarCounter);
        // display the time
        timeText.setText(new SimpleDateFormat("HH:mm:ss").format(calendarCounter.getTime()));
        
        // event every 1 second to update counter
        EventHandler<ActionEvent> eventHandler =  e ->{
            seconds++;
            resetCounter(calendarCounter);
            calendarCounter.set(Calendar.SECOND, seconds);
            timeText.setText(new SimpleDateFormat("HH:mm:ss").format(calendarCounter.getTime()));
            
        };
        
        // Create Timeline to count the time
        Timeline tlCounter = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        tlCounter.setCycleCount(Timeline.INDEFINITE);
        
        // Action handlers for buttons
        btControl.setOnAction(e -> {
            // start counting
            if("Start".equals(btControl.getText()) || "Resume".equals(btControl.getText())) {
                btControl.setText("Pause");
                tlCounter.play();
            }
            // pause counting
            else if("Pause".equals(btControl.getText())){
                btControl.setText("Resume");
                tlCounter.pause();
            }
        });
        // clear the watch
        btClear.setOnAction(e ->{
            btControl.setText("Start");
            tlCounter.pause();
            resetCounter(calendarCounter);
            seconds = 0;
            timeText.setText(new SimpleDateFormat("HH:mm:ss").format(calendarCounter.getTime()));
        });
        
        

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_20"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.

    }
    // Resetes the calendar object so it shows 00:00:00
    public void resetCounter(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
    }
}
