/*
    You should
    define a pane class for displaying the ball and provide the methods for moving
    the ball left, right, up, and down, as shown in Figure 15.24c.
 */
package ex15_03;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends BorderPane{
    private final double radius = 20;
    private double x = 100, y = 100;
    private Circle circle = new Circle(100, 100, radius);
    
    
    // no arg constructor
    BallPane(){
        circle.setFill(Color.BLUE);
        getChildren().add(circle);
    }
    // move the ball to the left
    public void moveLeft(){
        if(circle.getCenterX() > 20)
        circle.setCenterX(x - 5);
        x = circle.getCenterX();
    }
    
    // move the ball to the right
    public void moveRight(){
        if(circle.getCenterX() < getWidth() - 20){
            circle.setCenterX(x + 5);
            x = circle.getCenterX();
        }
    }
    
    // move the ball up
    public void moveUp(){
        if(circle.getCenterY() > 20){
            circle.setCenterY(y - 5);
            y = circle.getCenterY();
        }
    }
    // move the ball down
    public void moveDown(){
        if(circle.getCenterY() < getHeight() - 20){
            circle.setCenterY(y + 5);
            y = circle.getCenterY();
        }
    }
    
}
