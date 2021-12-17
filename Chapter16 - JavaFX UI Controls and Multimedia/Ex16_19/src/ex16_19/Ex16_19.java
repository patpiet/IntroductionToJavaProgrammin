/*
    Control a group of fans) Write a program that displays three fans in a group,
    with control buttons to start and stop all of them, as shown in Figure 16.44.
 */
package ex16_19;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex16_19 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create border pane
        BorderPane pane = new BorderPane();

        // Create Flow pane
        FlowPane flowPane = new FlowPane();

        // Create fans
        FanPane fan1 = new FanPane();
        FanPane fan2 = new FanPane();
        FanPane fan3 = new FanPane();

        // Add three fans to the flow pane
        flowPane.getChildren().add(fan1);
        flowPane.getChildren().add(fan2);
        flowPane.getChildren().add(fan3);

        // Create hbox to store buttons
        HBox hBox = new HBox();
        Button btStart = new Button("Start All");
        Button btStop = new Button("Stop All");

        hBox.getChildren().addAll(btStart, btStop);
        hBox.setAlignment(Pos.CENTER);

        pane.setTop(flowPane);
        pane.setBottom(hBox);

        // Action handlers for buttons
        btStart.setOnAction(e -> {
            for (Node fan: flowPane.getChildren()) {
                if(fan instanceof FanPane){
                    ((FanPane) fan).play();
                }
            }
        });
        btStop.setOnAction(e -> {
            for (Node fan: flowPane.getChildren()) {
                if(fan instanceof FanPane){
                    ((FanPane) fan).pause();
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 900, 370);
        primaryStage.setTitle("Exercise_16_19"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    public class FanPane extends VBox {
        private BooleanProperty isReverse = new SimpleBooleanProperty();
        private Circle circle;
        private Arc[] arcs = new Arc[4];
        private Pane pane = new Pane();
        private HBox hBox = new HBox(10);
        private Button btPause = new Button("Pause");
        private Button btResume = new Button("Resume");
        private Button btReverse = new Button("Reverse");
        private Slider slSpeed = new Slider(0.1, 2, 1);
        private Timeline animation;

        // Construct a fan with buttons and slider
        public FanPane() {
            this.circle = new Circle(150, 135, 135, Color.WHITE);
            this.circle.setStroke(Color.BLACK);
            for (int j = 0; j < 4; j++) {
                arcs[j] = new Arc(150, 135, 120, 120, 90 * j, 30);
                arcs[j].setStroke(Color.BLACK);
                arcs[j].setFill(Color.BLACK);
                arcs[j].setType(ArcType.ROUND);
            }
            pane.getChildren().add(circle);
            pane.getChildren().addAll(arcs);
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(btPause, btResume, btReverse);
            setSpacing(10);
            getChildren().addAll(hBox, pane, slSpeed);

            // Handle the animation
            EventHandler<ActionEvent> eventHandler = e -> {
                for (Arc arc : arcs) {
                    if (isReverse.getValue() == Boolean.FALSE) {
                        arc.setStartAngle(arc.getStartAngle() + 1);
                    } else {
                        arc.setStartAngle(arc.getStartAngle() - 1);
                    }
                }
            };
            // Create animation
            animation = new Timeline(new KeyFrame(Duration.millis(2.5), eventHandler));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();

            // Create slider
            // Event handlers when buttons clicked
            btPause.setOnAction(e -> animation.pause());
            btResume.setOnAction(e -> animation.play());
            btReverse.setOnAction(e -> {
                System.out.println(animation.getRate());
                if (isReverse.getValue() == Boolean.FALSE) {
                    isReverse.setValue(Boolean.TRUE);
                }
            });
            // Event handler for slider
            animation.rateProperty().bind(slSpeed.valueProperty());
        }

        // start animation
        public void play() {
            animation.play();
        }

        // pause animation
        public void pause() {
            animation.pause();
        }

    }
}
