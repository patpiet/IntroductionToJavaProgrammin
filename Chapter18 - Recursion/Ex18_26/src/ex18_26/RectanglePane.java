/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex18_26;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author User
 */
public class RectanglePane extends Pane {

    private boolean marked = false;
    private Line line1;
    private Line line2;
    private Rectangle rectangle;

    public RectanglePane() {
        rectangle = new Rectangle(0, 0, 30, 30);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        line1 = new Line(0, 0, 30, 30);
        line1.setStroke(Color.WHITE);
        line2 = new Line(30, 0, 0, 30);
        line2.setStroke(Color.WHITE);
        getChildren().addAll(rectangle, line1, line2);
    }

    public void mark() {
        if (!isMarked()) {
            line1.setStroke(Color.BLACK);
            line2.setStroke(Color.BLACK);
            marked = true;
        } else {
            line1.setStroke(Color.WHITE);
            line2.setStroke(Color.WHITE);
            marked = false;
        }

    }

    public boolean isMarked() {
        return marked;
    }
    
    public void setMarked(boolean bool){
        if(bool == true){
            line1.setStroke(Color.GRAY);
            line2.setStroke(Color.GRAY);
        }
        marked = bool;
    }
    
    public void markColor(){
        marked = true;
        rectangle.setFill(Color.GRAY);
    }
}
