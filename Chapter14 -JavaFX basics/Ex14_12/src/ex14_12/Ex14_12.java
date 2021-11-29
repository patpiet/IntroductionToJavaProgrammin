/*
    Write a program that uses a bar chart to display the percentages
    of the overall grade represented by projects, quizzes, midterm exams, and the
    final exam, as shown in Figure 14.46b. Suppose that projects take 20 percent and
    are displayed in red, quizzes take 10 percent and are displayed in blue, midterm
    exams take 30 percent and are displayed in green, and the final exam takes 40
    percent and is displayed in orange. Use the Rectangle class to display the bars.
    Interested readers may explore the JavaFX BarChart class for further study
 */
package ex14_12;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_12 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create all bar charts
        VBox projectBarChart = getBarChart(200, "Project - 20%", Color.RED);
        VBox quizBarChart = getBarChart(100, "Quiz - 10%", Color.BLUE);
        VBox midtermBarChart = getBarChart(300, "Midterm - 30%", Color.GREEN);
        VBox finalBarChart = getBarChart(400, "Final - 40%", Color.ORANGE);

        // Create FlowPane to store all charts
        FlowPane pane = new FlowPane();
        pane.setHgap(10);
        pane.setAlignment(Pos.BOTTOM_CENTER);
        
        // Add all charts to the FlowPane
        pane.getChildren().add(projectBarChart);
        pane.getChildren().add(quizBarChart);
        pane.getChildren().add(midtermBarChart);
        pane.getChildren().add(finalBarChart);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 440, 450);
        primaryStage.setTitle("Exercise_14_12"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // Return a VBox pane with a bar chart
    public static VBox getBarChart(int size, String text, Color color){
        // Create VBox to store chart
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        vBox.setSpacing(10);
        
        // Create rectangle to represent chart and set its color and description
        Rectangle projectsBar = new Rectangle(100, size);
        projectsBar.setFill(color);
        Text textNode = new Text(100, 500, text);
        textNode.setFill(color);
        
        vBox.getChildren().add(textNode);
        vBox.getChildren().add(projectsBar);
        
        return vBox;
    }
    
}
