package de.hsrm.cs.oose13;

import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends GeometricObject{

   public Ellipse(Vertex corner, double width, double height) {
 	super(corner, width, height);
   }
	
    public Ellipse(Vertex corner, Vertex movement, double width, double height) {
	super(corner, movement, width, height);
    }
	
    @Override
    public String toString(){
        return "Ellipse mit: obere linke Ecke: "+corner.toString()+", Breite: "+width+", Hoehe: "+height+", movement: "+movement.toString()+"";
    }
    
    @Override
    public double size(){
    	return Math.PI*(width/2)*(height/2);
    }
	
    @Override
    public void paintMeTo(Graphics g) {
    	g.setColor(Color.RED);
    	g.fillOval((int)corner.getX(), (int)corner.getY(), (int)width, (int)height);
    	g.setColor(Color.BLACK);
    }
}
