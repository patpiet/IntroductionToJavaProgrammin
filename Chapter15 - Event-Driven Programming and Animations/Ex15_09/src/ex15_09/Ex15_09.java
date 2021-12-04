/*
    (Draw lines using the arrow keys) Write a program that draws line segments
    using the arrow keys. The line starts from the center of the pane and draws
    toward east, north, west, or south when the right-arrow key, up-arrow key, leftarrow
    key, or down-arrow key is pressed, as shown in Figure 15.26b.
 */
package ex15_09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Ex15_09 extends Application{
    final double WIDTH = 300, HEIGHT = 100; 
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Pane
        LinePane pane = new LinePane();
        
        // Create a handler to draw a line
        pane.setOnKeyPressed(e ->{
            switch(e.getCode()){
                case LEFT: pane.drawWest(); break;
                case RIGHT: pane.drawEast(); break;
                case UP: pane.drawNorth(); break;
                case DOWN: pane.drawSouth(); break;
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_15_09"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
        
        pane.requestFocus();
    }
    
    public class LinePane extends Pane{
        private double x = getWidth() / 2.0, y = getHeight() / 2.0;
    
        // Constructor
        public LinePane(){
            x = WIDTH / 2.0;
            y = HEIGHT / 2.0;
        }
        // Draw a line to the right
        public void drawEast(){
            if(x < getWidth()){
                Line line = new Line(x, y, x + 10, y);
                getChildren().add(line);
                x += 10;
            }
        }
        public void drawWest(){
            if(x > 0){
                Line line = new Line(x, y, x - 10, y);
                x -= 10;
                getChildren().add(line);
            }
        }
        // Draw a line up
        public void drawNorth(){
            if(y > 0){
                Line line = new Line(x, y, x, y - 10);
                y -= 10;
                getChildren().add(line);
            }
        }
        // Draw a line down
        public void drawSouth(){
            if(y < getHeight()){
                Line line = new Line(x, y, x, y + 10);
                y += 10;
                getChildren().add(line);
            }
        }
    }
}
