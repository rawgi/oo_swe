package de.hsrm.cs.oose13;

public class GeometricObjectsScene implements CollisionScene{
  
  private Array(GeometricObject) myObjects;
  
  public GeometricObjectsScene(Array(GeometricObject) objects){
    myObjects = objects;
  }
  
	public void collisions(){
	  for(int i: myObjects){
	    GeometricObject obj = myObjects.get(i);
	    for(int j: myObjects){
	      GeometricObject check = myObjects.get(j);
	      if(!obj.equals(check)){
  	      if(obj.touches(check)){
            myObjects.get(i).invertXMovement();
            myObjects.get(i).invertYMovement();
            myObjects.get(j).invertXMovement();
            myObjects.get(j).invertYMovement();
	        }
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
	
	public int getWidth(){
	  
	}
	
	public int getHeight(){
	  
	}
}
