/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex20_21;

import java.util.Comparator;

/**
 *
 * @author User
 */
public class GeometricObjectComparator implements Comparator<GeometricObject>, java.io.Serializable {
    
  @Override
  public int compare(GeometricObject o1, GeometricObject o2) {
    return o1.getArea() > o2.getArea() ? 
    	1 : o1.getArea() == o2.getArea() ? 0 : -1;
  }
}