/*
    Write a program that prompts the user to enter the
    center coordinates, width, and height of two rectangles from the command line.
    The program displays the rectangles and a text indicating whether the two are
    overlapping, whether one is contained in the other, or whether they don’t overlap,
    as shown in Figure 14.50. See Programming Exercise 10.13 for checking the
    relationship between two rectangles.
 */
package ex14_23;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_23 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create scanner  
        Scanner input = new Scanner(System.in);
        // Prompt for data
        System.out.print("Enter center coordinates, width and height of first rectangle: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double width1 = input.nextDouble();
        double height1 = input.nextDouble();

        System.out.print("Enter center coordinates, width and height of second rectangle: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double width2 = input.nextDouble();
        double height2 = input.nextDouble();

        // Create pane
        Pane pane = new Pane();

        // Create rectangle 1
        Rectangle rec1 = new Rectangle(x1, y1, width1, height1);
        rec1.setFill(null);
        rec1.setStroke(Color.BLACK);
        // Create rectangle 2
        Rectangle rec2 = new Rectangle(x2, y2, width2, height2);
        rec2.setFill(null);
        rec2.setStroke(Color.BLACK);

        // Create text object
        Text text = new Text();
        text.setX(100);
        text.setY(100);
        text.setFill(Color.RED);


        // Test if rectangles contain or overlap each other
        if (contains(rec1, rec2) || contains(rec2, rec1)) {
            text.setText("One rectangle is contained in another ");
        } else if (overlaps(rec1, rec2)) {
            text.setText("The rectangles overlap");
        } else {
            text.setText("The rectangles do not overlap ");
        }
        
        pane.getChildren().add(rec1);
        pane.getChildren().add(rec2);
        pane.getChildren().add(text);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_23"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.

    }

    // Returns true if two rectangle overlap with each other
    public boolean contains(Rectangle r1, Rectangle r2) {
        return r2.getY() + r2.getHeight() <= r1.getY() + r1.getHeight()
                && r2.getX() + r2.getWidth() <= r1.getX() + r1.getWidth() 
                && r2.getX() > r1.getX() && r2.getY() > r1.getY();
    }

     // Returns true if the specified rectangles overlap
    public boolean overlaps(Rectangle r1, Rectangle r2) {
        return getDistance(r1.getX(), r2.getX() + r2.getWidth()) < r1.getWidth() + r2.getWidth()
                && getDistance(r1.getY(), r2.getY() + r2.getHeight()) < r1.getHeight() + r2.getHeight();

    }

    private double getDistance(double p1, double p2) {
        return Math.sqrt(Math.pow(p2 - p1, 2));
    }
}
