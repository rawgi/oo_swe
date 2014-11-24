package de.hsrm.cs.oose13;

public class GeometricObject{
    protected Vertex corner; //obere links
    protected Vertex movement;
    protected double width;
    protected double height;
    
    public GeometricObject(Vertex corner, double width, double height){
        this(corner, new Vertex(0,0), width, height);
    }
    
    public GeometricObject(Vertex corner, Vertex movement, double width, double height){
        this.corner = corner;
        this.movement = movement;
        setWidth(width);
        setHeight(height);
    }

    public String toString(){
        return "obere linke Ecke: "+corner.toString()+", Breite: "+width+", Hoehe: "+height+", movement: "+movement.toString()+"";
    }

    public void move(){
    	corner.move(movement);
    }
    
    public void move(Vertex v){
        corner.move(v);
    }
    
    public double size(){
    	return height*width;
    }
    
    public boolean isLargerThan(GeometricObject that){
    	return this.size() > that.size();
    }
    
    //im fenster geht die y-achse nach unten
    public boolean isAbove(GeometricObject that){
    	return this.corner.getY()+height < that.corner.getY();
    }
    
    public boolean isUnderneeth(GeometricObject that){
    	return that.isAbove(this);
    }
    
    public boolean isLeftOf(GeometricObject that){
    	return this.corner.getX()+this.width < that.getCorner().getX();
    }
    
    public boolean isRightOf(GeometricObject that){
    	return that.isLeftOf(this);
    }
    
    public boolean touches(GeometricObject that){
    	return !this.isAbove(that) && !this.isUnderneeth(that) &&
    			!this.isLeftOf(that) && !this.isRightOf(that);
    }
    
    /*Getter*/
    public Vertex getCorner(){
    	return corner;
    }
    
    public Vertex getMovement(){
    	return movement;
    }
    
    public double getWidth(){
    	return width;
    }
    
    public double getHeight(){
    	return height;
    }
    
    /*Setter*/
    public void setCorner(Vertex corner){
    	this.corner = corner;
    }
    
    public void setMovement(Vertex movement){
    	this.movement = movement;
    }
    
    public void setHeight(double height){
    	if(height >= 0){
    		this.height = height;
    	}else{
    		throw new IllegalArgumentException("Height must be 0 or higher.");
    	}
    }
    
    public void setWidth(double width){
    	if(width >= 0){
    		this.width = width;
    	}else{
    		throw new IllegalArgumentException("Width must be 0 or higher.");
    	}
    }
}