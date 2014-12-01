package de.hsrm.cs.oose13;

public class Vertex{
    private double x;
    private double y;
    public Vertex(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "x: "+x+", y: "+y+"";
    }
    
    @Override
    public boolean equals(Object obj){
	if(this.getClass()==obj.getClass()) return false;
	Vertex that = (Vertex)obj;
	return this.x==that.getX() && this.y==that.getY();
    }
    
    public void move(Vertex v){
    		this.x = this.x + v.x;
    		this.y = this.y + v.y;
    }
    
    public void moveTo(Vertex v){
        this.x = v.x;
        this.y = v.y;
    }

    /*Getter*/
    public double getX(){
    	return x;
    }
    	
    public double getY(){
    	return y;
    }	
    	
    /*Setter*/
    public void setX(double x){
    	this.x = x;
    }
    	
    public void setY(double y){
    	this.y = y;   	
    }
}
