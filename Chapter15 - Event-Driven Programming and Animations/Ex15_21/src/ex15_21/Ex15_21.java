/*
    (Drag points) Draw a circle with three random points on the circle. Connect
    the points to form a triangle. Display the angles in the triangle. Use the mouse
    to drag a point along the perimeter of the circle. As you drag it, the triangle and
    angles are redisplayed dynamically, as shown in Figure 15.30b. For computing
    angles in a triangle, see Listing 4.1.
 */
package ex15_21;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex15_21 extends Application {
    // Create Pane
    Pane pane = new Pane();
    // Create text objects
    Text t1 = new Text();
    Text t2 = new Text();
    Text t3 = new Text();
    // Create big Circle
    Circle circle = new Circle(200, 150, 100);
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        // Create lsit for nodes
        ObservableList<Node> nodes = pane.getChildren();

        // Create three circles with random coordiantes
        Circle c1 = createCircle();
        Circle c2 = createCircle();
        Circle c3 = createCircle();

        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(c1);
        circles.add(c2);
        circles.add(c3);
        
        // Create triangle
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> points = polygon.getPoints();

        nodes.addAll(circle, polygon, c1, c2, c3, t1, t2, t3);
        assignPoints(points, circles);
        computeAngles(points, c1, c2, c3);
        
        //Drag the circles
        pane.setOnMouseDragged(e -> {
            for (Circle c : circles) {
                if (c.isHover()) {
                    double deltaX = c.getCenterX() - circle.getCenterX();
                    double deltaY = c.getCenterY() - circle.getCenterY();
                    double orthoX = -deltaY * c.getRadius() / circle.getRadius();
                    double orthoY = deltaX * c.getRadius() / circle.getRadius();
                    double newDeltaX = deltaX + orthoX;
                    double newDeltaY = deltaY + orthoY;
                    double newLength = Math.sqrt(newDeltaX * newDeltaX + newDeltaY * newDeltaY);
                    
                    c.setCenterX(circle.getCenterX() + newDeltaX * circle.getRadius() / newLength);
                    c.setCenterY(circle.getCenterY() + newDeltaY * circle.getRadius() / newLength);
                }
                computeAngles(points, c1, c2, c3);
                assignPoints(points, circles);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("Exercise_15_20"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    // Set the points of circles as triangle boundaries
    public void assignPoints(ObservableList<Double> points, ArrayList<Circle> circles) {
        // clear the triangle
        points.clear();
        // loop through all nodes in the pane and update points
        for (Circle c : circles) {
                points.add(c.getCenterX());
                points.add(c.getCenterY());
        }
    }
    // Compute angles
    public void computeAngles(ObservableList<Double> points, Circle c1, Circle c2, Circle c3) {
        // Compute three sides
        double a = distance(c2, c3);
        double b = distance(c1, c3);
        double c = distance(c1, c2);

        // Compute three triangles
        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c)
                / (-2 * b * c)));
        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c)
                / (-2 * a * c)));
        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a)
                / (-2 * a * b)));
        
        // Set text objects
        t1.setText(String.format("%.2f", A));
        t1.xProperty().bind(c1.centerXProperty().add(5));
        t1.yProperty().bind(c1.centerYProperty().subtract(10));
        t2.setText(String.format("%.2f", B));
        t2.xProperty().bind(c2.centerXProperty().add(5));
        t2.yProperty().bind(c2.centerYProperty().subtract(10));
        t3.setText(String.format("%.2f", C));
        t3.xProperty().bind(c3.centerXProperty().add(5));
        t3.yProperty().bind(c3.centerYProperty().subtract(10));
        
    }
    // returns distance from centers of circles
    public static double distance(Circle c1, Circle c2) {
        return Math.hypot(c1.getCenterX() - c2.getCenterX(), c1.getCenterY() - c2.getCenterY()) - c1.getRadius() - c2.getRadius();
    } 
    
    // returns random X and Y coordinate in array around the main circle
    public Circle createCircle(){
        double[] array = new double[2];
        
        double angle = Math.random() * 360;
        
        array[0] = circle.getRadius() * Math.cos(angle) + circle.getCenterX();
        array[1] = circle.getRadius() * Math.sin(angle) + circle.getCenterY();

        return new Circle(array[0], array[1], 10);
    }
}
