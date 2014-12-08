package de.hsrm.cs.oose13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Star extends GeometricObject{

    private int spickes;
    private double innerDiameter;
    private double outerDiameter;
    private double radius;
    private Polygon myPolygon = new Polygon();

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
    	g.setColor(Color.yellow);
    	g.fillPolygon(myPolygon);
    	g.setColor(Color.black);
    }
    
    @Override
    public void move(){
    	corner.move(movement);
    	createPolygon();
    }
	
    private void createPolygon(){
	myPolygon.reset();
	for(int i =1; i<=spickes*2; i++){
		if(i%2==0){
			myPolygon.addPoint((int)(corner.getX()+this.radius+this.radius*Math.cos((i*2*Math.PI)/(this.spickes*2))),
				(int)(corner.getY()+this.radius+(this.radius*Math.sin((i*2*Math.PI)/(this.spickes*2)))));
		}else{
			myPolygon.addPoint((int)(corner.getX()+this.radius+(this.innerDiameter/2)*Math.cos((i*2*Math.PI)/(this.spickes*2))),
				(int)(corner.getY()+this.radius+((this.innerDiameter/2)*Math.sin((i*2*Math.PI)/(this.spickes*2)))));
		}
	}
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

    public void setInnerDiameter(double innerDiameter){
    	this.innerDiameter = innerDiameter;
    	createPolygon();
    }

    public void setOuterDiameter(double outerDiameter){
    	this.outerDiameter = outerDiameter;
    	createPolygon();
    }

    public void setRadius(double radius){
    	this.radius = radius;
    }
}
