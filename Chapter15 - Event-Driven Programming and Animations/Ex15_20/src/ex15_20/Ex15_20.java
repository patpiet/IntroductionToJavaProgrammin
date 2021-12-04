/*
    (Geometry: display angles) Write a program that enables the user to drag the vertices
    of a triangle and displays the angles dynamically as the triangle shape changes,
    as shown in Figure 15.30a. The formula to compute angles is given in Listing 4.1.
 */
package ex15_20;

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

public class Ex15_20 extends Application {
    // Create Pane
    Pane pane = new Pane();
    Text t1 = new Text();
    Text t2 = new Text();
    Text t3 = new Text();
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create lsit for nodes
        ObservableList<Node> nodes = pane.getChildren();

        // Create three circles with random coordiantes
        Circle c1 = new Circle(250, 140, 10);
        Circle c2 = new Circle(300, 200, 10);
        Circle c3 = new Circle(230, 220, 10);

        // Create triangle
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> points = polygon.getPoints();

        nodes.addAll(polygon, c1, c2, c3, t1, t2, t3);
        assignPoints(points, nodes);
        computeAngles(points, c1, c2, c3);
        //Drag the circles
        pane.setOnMouseDragged(e -> {
            for (Node node : nodes) {
                if (node instanceof Circle && node.isHover()) {
                    ((Circle) node).setCenterX(e.getX());
                    ((Circle) node).setCenterY(e.getY());
                }
                computeAngles(points, c1, c2, c3);
                assignPoints(points, nodes);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("Exercise_15_20"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

// Set the points of circles as triangle boundaries
    public void assignPoints(ObservableList<Double> points, ObservableList<Node> nodes) {
        // clear the triangle
        points.clear();
        // loop through all nodes in the pane and update points
        for (Node node : nodes) {
            if (node instanceof Circle) {
                points.add(((Circle) node).getCenterX());
                points.add(((Circle) node).getCenterY());
            }
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
}
