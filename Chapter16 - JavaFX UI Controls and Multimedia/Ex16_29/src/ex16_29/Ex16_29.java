/*
    (Display a calendar) Write a program that displays the calendar for the current
    month. You can use the Prior and Next buttons to show the calendar of the
    previous or next month. Display the dates in the current month in black and
    display the dates in the previous month and next month in gray, as shown in
    Figure 16.48.
 */
package ex16_29;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex16_29 extends Application{
    // Create Date object with current date
    LocalDate date = LocalDate.now();
    LocalDate priorMonthDate = date.minusMonths(1);
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create border pane
        BorderPane borderPane = new BorderPane();
        // Create date label
        Label lbDate = new Label(date.getMonth() + ", " + date.getYear());

        FlowPane flowPane = new FlowPane();
        // Create Label with Days of week
        Text lbDays = new Text(String.format("%-14s%-14s%-13s%-16s%-13s%-14s%-14s", 
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));
        flowPane.getChildren().add(lbDays);
        displayCalendar(borderPane);
        
        borderPane.setTop(new StackPane(lbDate));
        borderPane.setCenter(flowPane);
        
        VBox pane = new VBox(5);
        
        // Create Vbox for buttons
        HBox vBox = new HBox(5);
        Button btPrior = new Button("Prior");
        Button btNext = new Button("Next");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(btPrior, btNext);
        
        pane.getChildren().addAll(borderPane, vBox);
        
        // Update the calendar
        btPrior.setOnAction(e ->{
            // update the date to one month behind
            date = date.minusMonths(1);
            priorMonthDate = date.minusMonths(1);
            // display new calendar
            displayCalendar(borderPane);
            lbDate.setText(date.getMonth() + ", " + date.getYear());
        });
        btNext.setOnAction(e ->{
            // update the date to the next month
            date = date.plusMonths(1);
            priorMonthDate = date.minusMonths(1);
            // display new calendar
            displayCalendar(borderPane);
            lbDate.setText(date.getMonth() + ", " + date.getYear());
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_29"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // displays calendar
    public void displayCalendar(BorderPane borderPane){
        // Create vbox for columns 
        VBox vBox = new VBox(5);
        vBox.setPrefHeight(120);
        // index of the of the week of  first day of the month
        int firstDayWeek = date.withDayOfMonth(1).getDayOfWeek().getValue();
        
        // lenght of prior month
        int lengthOfPriorMonth = priorMonthDate.lengthOfMonth();
        // the last sunday integer of prior month
        int lastSundayPriorMonth = priorMonthDate.withDayOfMonth(lengthOfPriorMonth - firstDayWeek + 1).getDayOfMonth();

        // increase day every each day
        int day = 1;
        // increase the day for the gray days of next month
        int dayNextMonth = 1;
        // Decide how many rows of calendar
        int columns = (firstDayWeek >= 5) ?  6 : 5;
        
        // loop 'columns' times
        for (int i = 0; i < columns; i++) {
            // Create hbox for one columns of days
            HBox hBox = new HBox();
            // loop through all days
            for (int j = 0; j < 7; j++) {
                // Decide on the day of the month
                if(lastSundayPriorMonth <= lengthOfPriorMonth){
                    Text t = new Text(String.format("%-19d", lastSundayPriorMonth));
                    t.setFill(Color.GRAY);
                    hBox.getChildren().add(t);
                    lastSundayPriorMonth++;
                }else if(day <= date.lengthOfMonth()){
                    hBox.getChildren().add(new Text(String.format("%-19d", day)));
                    day++;
                }else{
                    Text t = new Text(String.format("%-19d", dayNextMonth));
                    t.setFill(Color.GRAY);
                    hBox.getChildren().add(t);
                    dayNextMonth++;
                }
            }
            // Add column of the days
            vBox.getChildren().add(hBox);
        }
        // Update the calendar
        borderPane.setBottom(vBox);
    }
}
