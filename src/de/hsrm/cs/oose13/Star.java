package de.hsrm.cs.oose13;

import java.awt.Graphics;
import java.awt.Polygon;

public class Star extends GeometricObject{

    private int spickes;
    private double innerDiameter;
    private double outerDiameter;
    private double radius;
    private Polygon myPolygon;

    private boolean runter = true;
    private boolean rechts = true;
    
    public Star(Vertex corner, int spickes, double innerDiameter, double outerDiameter){
    	this(corner, new Vertex(0,0), spickes, innerDiameter, outerDiameter);
    }

    public Star(Vertex corner, Vertex movement, int spickes, double innerDiameter, double outerDiameter){
    	super(corner, movement, outerDiameter, outerDiameter);
    	this.spickes = spickes;
    	this.innerDiameter = innerDiameter;
    	this.outerDiameter = outerDiameter;
    	setRadius(outerDiameter/2);
    	createPolygon();
    }
    
	@Override
	public void paintMeTo(Graphics g) {
		g.drawPolygon(myPolygon);
	}
    
	@Override
	public void move(){

		if(corner.getX() <= 0 || corner.getX() >= 800-outerDiameter){
			if(rechts){
				rechts = false; 
			}else{
				rechts = true;
			}
			movement.setX(movement.getX()-movement.getX()*2);
		}
    	
		if(corner.getY() <= 0 || corner.getY() >= 600-outerDiameter){
			if(runter){
				runter = false; 
			}else{
				runter = true;
			}
			movement.setY(movement.getY()-movement.getY()*2);
		}
    	corner.move(movement);
    	createPolygon();
	}
	
	private void createPolygon(){
		int xPoints[] = new int[spickes*2];
		int yPoints[] = new int[spickes*2];
		int q = 5;
		float step = 360.f / (float)(spickes);
		float pos = 0;
		for (int i=0; i<spickes*2; i++) {
			float rad = (float) (2*Math.PI*pos / 360.f);
			pos += step*q;
			xPoints[i] = (int) (radius+radius*Math.sin(rad)+corner.getX());
			yPoints[i] = (int) (radius+radius*Math.cos(rad)+corner.getY());
		}

		myPolygon = new Polygon(xPoints,yPoints,spickes*2);
	}
	
    //Getter
    public int getSpickes(){
    	return spickes;
    }

    public double getInnerDiameter(){
    	return innerDiameter;
    }

    public double getOuterDiameter(){
    	return outerDiameter;
    }

    public double getRadius(){
    	return radius;
    }
    
    //Setter
    public void setSpickes(int spickes){
    	this.spickes = spickes;
    	createPolygon();
    }

    public void setInnerDiameter(double innerDiameter2){
    	this.innerDiameter = innerDiameter2;
    	createPolygon();
    }

    public void setOuterDiameter(double outerDiameter2){
    	this.outerDiameter = outerDiameter2;
    	createPolygon();
    }

    public void setRadius(double radius){
    	this.radius = radius;
    }
}
