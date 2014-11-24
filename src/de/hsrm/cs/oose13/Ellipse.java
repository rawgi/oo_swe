package de.hsrm.cs.oose13;

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
    	return (Math.PI*width*height)/2;
    }
}
