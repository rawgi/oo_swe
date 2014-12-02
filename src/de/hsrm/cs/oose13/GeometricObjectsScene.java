package de.hsrm.cs.oose13;

import java.awt.Graphics;

public class GeometricObjectsScene implements CollisionScene {

	private GeometricObject[] myObjects;
	private int width;
	private int height;

	public GeometricObjectsScene(GeometricObject[] objects, int width, int height) {
		myObjects = objects;
		setWidth(width);
		setHeight(height);
	}

	@Override
	public void collisions() {
		for (int i=0; i<=myObjects.length; i++) {
			GeometricObject obj = myObjects[i];
			for (int j = i + 1; j <= myObjects.length; j++) {
				GeometricObject check = myObjects[j];
				if (obj.touches(check)) {
					myObjects[i].invertXMovement();
					myObjects[i].invertYMovement();
					myObjects[j].invertXMovement();
					myObjects[j].invertYMovement();
				}
			}
			if (obj.getCorner().getX() <= 0
					|| obj.getCorner().getX() + obj.getWidth() >= getWidth()) {
				myObjects[i].invertXMovement();
			}
			if (obj.getCorner().getY() <= 0
					|| obj.getCorner().getY() + obj.getHeight() >= getHeight()) {
				myObjects[i].invertYMovement();
			}
		}
	}

	@Override
	public void move(){
	  for(int i=0; i<=myObjects.length; i++){
	    myObjects[i].move();
	  }
	}

	@Override
	public void paintAll(Graphics g) {
		for (int i = 0; i <= myObjects.length; i++) {
			myObjects[i].paintMeTo(g);
		}
	}

	// Getter
	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	// Setter
	public void setHeight(int height) {
		if (height >= 0) {
			this.height = height;
		} else {
			throw new IllegalArgumentException("Height must be 0 or higher.");
		}
	}

	public void setWidth(int width) {
		if (width >= 0) {
			this.width = width;
		} else {
			throw new IllegalArgumentException("Width must be 0 or higher.");
		}
	}
}
