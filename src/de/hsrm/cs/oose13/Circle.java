package de.hsrm.cs.oose13;

public class Circle extends Ellipse{
	
	public Circle(Vertex corner, double diameter) {
		super(corner, diameter, diameter);
	}
	
	public Circle(Vertex corner, Vertex movement, double diameter) {
		super(corner, movement, diameter, diameter);
	}
}
