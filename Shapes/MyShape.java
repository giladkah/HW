package Q2;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape implements Cloneable {

	private int x1, x2, y1, y2; 
	private Color color; 
	
	public MyShape(int x1, int y1, int x2, int y2, Color color) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.color = color; 
	}
	
	public void setX1(int x1) {
		this.x1=x1; 
	}
	
	public void setX2(int x2) {
		this.x2=x2; 
	}

	public void setY1(int y1) {
		this.y1=y1; 
	}

	public void setY2(int y2) {
		this.y2=y2; 
	}
	
	public int getX1() {
		return x1; 
	}
	
	public int getX2() {
		return x2; 
	}
	
	public int getY1() {
		return y1; 
	}
	
	public int getY2() {
		return y2; 
	}
	
	public Color getColor() {
		return color; 
	}
	public abstract void draw(Graphics g);
	
	
    @Override
    public Object clone() {	
    	try {
    		return super.clone();
    	} catch (CloneNotSupportedException e) {
    		throw new InternalError(e.toString());
    	} 		

    }
    
}
