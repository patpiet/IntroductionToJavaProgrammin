/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex18_27;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

/**
 *
 * @author User
 */
public class KochSnowflakePane extends Pane{
    private int order = 0;
    private Polygon polygon;
    
    public KochSnowflakePane(){
    }

    public void setOrder(int order){
        this.order = order;
        paint();
    }
    
    public void paint(){
        Point2D p1 = new Point2D(getWidth() / 2, 10);
        Point2D p2 = new Point2D(10, getHeight() - 10);
        Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
        
        this.getChildren().clear();
        
        displaySnowflakes(0, p1, p2, p3);
    }

    private void displaySnowflakes(int ord, Point2D p1, Point2D p2, Point2D p3) {
        if(ord == order){
            this.getChildren().add(polygon);
        }else{
            polygon.getPoints().addAll(p1.getX(), p1.getY(),
                                       p2.getX(), p2.getY(),
                                       p3.getX(), p3.getY());
                                       
            displaySnowFlakes(int ord + 1, p1/3, p2/3, p3/3);
        }
    }
}
