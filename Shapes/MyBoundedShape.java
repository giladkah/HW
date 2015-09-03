package Q2;

import java.awt.Color;

public abstract class MyBoundedShape extends MyShape {

	private boolean isFull=false;
	
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean isFull) {
		super(x1, y1, x2, y2, color);
		
		this.isFull=isFull;

	}
	
	public void setFull() {
		isFull=true; 
	}
	
	public void setEmpty() {
		isFull=false; 
	}
	
	public boolean getIsFull() {
		return isFull; 
	}
	
	public int getWidth() {
		return getX2(); 
	}
	
	public int getHeight() {
		return getY2(); 
	}
	
	@Override
	public boolean equals(Object obj) {	
		if (obj==null)
			return false;

		if (!(obj instanceof MyBoundedShape)) 
			return false; 
	
		MyBoundedShape myBoundedShape = (MyBoundedShape) obj;
		
		return ((getWidth()==myBoundedShape.getWidth()) && (this.getHeight()==myBoundedShape.getHeight())); 
		
	}
	
	
}
