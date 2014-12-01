package de.hsrm.cs.oose13;

public class GeometricObjectsScene implements CollisionScene{
  
  private Array(GeometricObject) myObjects;
  private int width;
  private int height;
  
  public GeometricObjectsScene(Array(GeometricObject) objects, int width, int height){
    myObjects = objects;
    setWidth(width);
    setHeight(height);
  }
  
	public void collisions(){
	  for(int i: myObjects){
	    GeometricObject obj = myObjects.get(i);
	    for(int j = i+1; j <= myObjects; j++){
	      GeometricObject check = myObjects.get(j);
  	      	if(obj.touches(check)){
        		myObjects.get(i).invertXMovement();
            		myObjects.get(i).invertYMovement();
        		myObjects.get(j).invertXMovement();
            		myObjects.get(j).invertYMovement();
	        }
	    }
	    if(obj.getCorner().getX()<=0 || obj.getCorner().getX()+obj.getWidth()>=getWidth()){
	      myObjects.get(i).invertXMovement();
	    }
	    if(obj.getCorner().getY()<=0 || obj.getCorner().getY()+obj.getHeight()>=getHeight()){
	      myObjects.get(i).invertYMovement();
	    }
	  }
	}
	
	public void move(){
	  for(int i=0; i<=myObjects.length(); i++){
	    myObjects.get(i).move;
	  }
	}
	
	public void paintAll(Graphics g){
	  for(int i=0; i<=myObjects.length(); i++){
	    myObjects.get(i).paintMeTo(g);
	  }
	}
	
	//Getter
	public int getWidth(){
	  return this.width;
	}
	
	public int getHeight(){
	  return this.height;
	}
	
	//Setter
    public void setHeight(int height){
    	if(height >= 0){
    		this.height = height;
    	}else{
    		throw new IllegalArgumentException("Height must be 0 or higher.");
    	}
    }
    
    public void setWidth(int width){
    	if(width >= 0){
    		this.width = width;
    	}else{
    		throw new IllegalArgumentException("Width must be 0 or higher.");
    	}
    }
}
