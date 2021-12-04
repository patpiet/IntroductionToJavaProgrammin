/*
    (Game: eye-hand coordination) Write a program that displays a circle of radius
    10 pixels filled with a random color at a random location on a pane, as shown
    in Figure 15.29b. When you click the circle, it disappears and a new randomcolor
    circle is displayed at another random location. After twenty circles are
    clicked, display the time spent in the pane, as shown in Figure 15.29c.
 */
package ex15_19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex15_19 extends Application{
    final double WIDTH = 400, HEIGHT = 400;
    int counter = 0;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        // start the clock
        long start = System.currentTimeMillis();
        // Create a circle
        Circle circle = new Circle(randomX(), randomY(), 10);
        circle.setFill(randomColor());
        
        pane.getChildren().add(circle);
        
        
        circle.setOnMouseClicked(e ->{
            // stop when counter hits 20
            if(counter < 20){
                // Create and display ''new'' random circle
                circle.setCenterX(randomX());
                circle.setCenterY(randomY());
                circle.setFill(randomColor());
                counter++;
                System.out.println(counter);
            }
        });
        
        pane.setOnMouseClicked(e ->{
            if (counter == 20){
                // Remove the last circle from the pane
                pane.getChildren().clear();
                // Stop the clock
                long end = System.currentTimeMillis();
                // Create text to display
                Text text = new Text("Time spent is " + (end - start) + "milliseconds.");
                text.setX(100);
                text.setY(100);
                pane.getChildren().add(text);
                // increse counter in order to show the text only once
                counter++;
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_19"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
        
    }
    // returns random x location on the pane 
    public double randomX(){
        return (Math.random() * WIDTH);
    }
    // returns random y location on the pane 
    public double randomY(){
        return (Math.random() * HEIGHT);
    }
    // returns random color oboject
    public Color randomColor(){
        return new Color(Math.random(), Math.random(), Math.random(), Math.random());
    }
}
