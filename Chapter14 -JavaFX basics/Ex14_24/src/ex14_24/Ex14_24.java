/*
    Write a program that prompts the user to enter
    the coordinates of five points from the command line. The first four points form a
    polygon, and the program displays the polygon and a text that indicates whether
    the fifth point is inside the polygon, as shown in Figure 14.51a. Hint: Use the
    Node’s contains method to test whether a point is inside a node.
 */
package ex14_24;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_24 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();
        
        // Create a polygon object
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        
        ObservableList<Double> list = polygon.getPoints();
        
        list.addAll(new Double(2), new Double(30));
        list.addAll(new Double(4), new Double(130));
        list.addAll(new Double(50), new Double(30));
        list.addAll(new Double(70), new Double(40));
        pane.getChildren().add(polygon);
        
        // Point coordinates
        double x = 12;
        double y = 100;
        
        // Create circle point
        Circle point = new Circle(x, y, 5);
        pane.getChildren().add(point);
        
        // Create text object
        Text text = new Text();
        
        if(polygon.contains(x, y))
            text.setText("The point is inside the polygon");
        else
            text.setText("The point is not inside the polygon");
        
        VBox vBox = new VBox();
        
        vBox.getChildren().addAll(pane, text);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Exercise_14_24"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

}
