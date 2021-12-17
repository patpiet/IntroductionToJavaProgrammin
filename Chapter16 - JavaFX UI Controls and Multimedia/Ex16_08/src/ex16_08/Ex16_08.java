/*
    (Geometry: two circles intersect?) Write a program that enables the user to
    specify the location and size of the circles and displays whether the two circles
    intersect, as shown in Figure 16.39a. Enable the user to point the mouse inside a
    circle and drag it. As the circle is being dragged, the circle’s center coordinates
    in the text fields are updated.
 */
package ex16_08;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Ex16_08 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // CREATE GUI

        // Create Border Pane
        BorderPane pane = new BorderPane();

        // Create pane for Circle
        Pane paneForCircles = new Pane();
        paneForCircles.setPrefSize(300, 250);

        // Create Label within circle
        Label lbIntersect = new Label();
        lbIntersect.setAlignment(Pos.CENTER);

        // Create circles
        Circle circle1 = new Circle(50, 50, 10);
        circle1.setFill(null);
        circle1.setStroke(Color.BLACK);
        circle1.setPickOnBounds(true);

        Circle circle2 = new Circle(150, 150, 40);
        circle2.setFill(null);
        circle2.setStroke(Color.BLACK);
        circle2.setPickOnBounds(true);
        paneForCircles.getChildren().addAll(circle1, circle2, lbIntersect);

        // Create HBox for menu of two circles
        HBox hBox = new HBox(5);

        // Create Grid pane for circle1 menu
        GridPane paneCircle1 = new GridPane();
        paneCircle1.setStyle("-fx-border-color: black");
        Label lbCircle1 = new Label("Enter circle 1 info:");
        Label lbX1 = new Label("Center x: ");
        TextField tfX1 = new TextField();
        tfX1.setPrefColumnCount(6);
        Label lbY1 = new Label("Center y: ");
        TextField tfY1 = new TextField();
        tfY1.setPrefColumnCount(6);
        Label lbRadius1 = new Label("Radius: ");
        TextField tfRadius1 = new TextField();
        tfRadius1.setPrefColumnCount(6);

        // Add the nodes to the grid pane
        paneCircle1.add(lbCircle1, 0, 0);
        paneCircle1.add(lbX1, 0, 1);
        paneCircle1.add(tfX1, 1, 1);
        paneCircle1.add(lbY1, 0, 2);
        paneCircle1.add(tfY1, 1, 2);
        paneCircle1.add(lbRadius1, 0, 3);
        paneCircle1.add(tfRadius1, 1, 3);

        // Create Grid pane for circle2 menu
        GridPane paneCircle2 = new GridPane();
        paneCircle2.setStyle("-fx-border-color: black");
        Label lbCircle2 = new Label("Enter circle 2 info:");
        Label lbX2 = new Label("Center x: ");
        TextField tfX2 = new TextField();
        tfX2.setPrefColumnCount(6);
        Label lbY2 = new Label("Center y: ");
        TextField tfY2 = new TextField();
        tfY2.setPrefColumnCount(6);
        Label lbRadius2 = new Label("Radius: ");
        TextField tfRadius2 = new TextField();
        tfRadius2.setPrefColumnCount(6);

        // Add the nodes to the grid pane
        paneCircle2.add(lbCircle2, 0, 0);
        paneCircle2.add(lbX2, 0, 1);
        paneCircle2.add(tfX2, 1, 1);
        paneCircle2.add(lbY2, 0, 2);
        paneCircle2.add(tfY2, 1, 2);
        paneCircle2.add(lbRadius2, 0, 3);
        paneCircle2.add(tfRadius2, 1, 3);

        // Creat button
        Button btIntersection = new Button("Check Intersection");
        StackPane stackPane = new StackPane(btIntersection);
        stackPane.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(paneCircle1, paneCircle2);

        pane.setTop(paneForCircles);
        pane.setCenter(hBox);
        pane.setBottom(stackPane);

        // Create Action Handlers
        // Bind text fields with circles
        tfX1.textProperty().bindBidirectional(circle1.centerXProperty(), new NumberStringConverter());
        tfY1.textProperty().bindBidirectional(circle1.centerYProperty(), new NumberStringConverter());
        tfRadius1.textProperty().bindBidirectional(circle1.radiusProperty(), new NumberStringConverter());

        tfX2.textProperty().bindBidirectional(circle2.centerXProperty(), new NumberStringConverter());
        tfY2.textProperty().bindBidirectional(circle2.centerYProperty(), new NumberStringConverter());
        tfRadius2.textProperty().bindBidirectional(circle2.radiusProperty(), new NumberStringConverter());

        circle1.setOnMouseDragged(e -> {
            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());
        });

        circle2.setOnMouseDragged(e -> {
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());
        });

        btIntersection.setOnAction(e ->{
            if(!isIntersected(circle1, circle2)){
                lbIntersect.setText("Two circles intersect? No");
            }else{
                lbIntersect.setText("Two circles intersect? Yes");
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_16_08"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    //Returns 1 when circles teach each other, 
    public boolean isIntersected(Circle c1, Circle c2) {
        return Math.hypot(c1.getCenterX() - c2.getCenterX(),
                c1.getCenterY() - c2.getCenterY()
        ) <= (c1.getRadius() + c2.getRadius());
    }
}
