package Q2;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape {

	
	public MyRectangle(int x1, int y1, int x2, int y2,Color color, boolean isFull) {
		super(x1,y1,x2,y2,color, isFull);
		
		//this.height = p2.getX();
	    //this.width = p2.getY(); 

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		if (getIsFull()) 
			g.fillRect (this.getX1(), this.getY1(), getWidth(), getHeight());
		else 
			g.clearRect(this.getX1(), this.getY1(), getWidth(), getHeight());
		
	}

}
