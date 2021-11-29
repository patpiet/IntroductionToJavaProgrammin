/*
    Modify Programming Exercise 4.6 to create five
    random points on a circle, form a polygon by connecting the points clockwise,
    and display the circle and the polygon, as shown in Figure 14.51b.
 */
package ex14_25;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Ex14_25 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        // Create circle
        Circle circle = new Circle(100, 100, 80);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        // Create polygon object
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        
        ObservableList<Double> list = polygon.getPoints();
        
        // Create new polygons until it is connected clockwise
        do {
            list.removeAll(list);
            for (int i = 0; i < 5; i++) {
                double angle = Math.random() * 2 * Math.PI;
                list.addAll(new Double(80 * Math.cos(angle) + circle.getCenterX()),
                        new Double(80 * Math.sin(angle) + circle.getCenterY()));
            }
            
        } while (! isSumOfEdgesPositive(list));
        

        pane.getChildren().addAll(circle, polygon);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane,200,200);
        primaryStage.setTitle("Exercise_14_25"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // returns true when the sum of edges is positive, so the polygon is clockwise
    public static boolean isSumOfEdgesPositive(ObservableList<Double> list){
        // Create array to store points
        double[][] array = new double[5][2];
        
        int index = 0;
        // assign points from lsit to array
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = list.get(index);
                index++;
            }
        }
        
        // store the signed area
        double area = 0;
        
        for (int i = 0; i < array.length - 1; i++) {
            area += ( array[i][0] * array[i + 1][1] ) - (array[i + 1][0] * array[i][1]);  
        }
        
        area += ( array[4][0] * array[0][1] ) - (array[0][0] * array[4][1]);  
        
        return area < -25000;
    }
}
