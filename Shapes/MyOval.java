package Q2;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape {
	

	public MyOval(int x1, int y1, int x2, int y2,Color color, boolean isFull) {
		super(x1,y1,x2,y2,color,isFull);
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		if (getIsFull()) 
			g.fillOval(this.getX1(), this.getY1(), getWidth(), getHeight());
		else 
			g.drawOval(this.getX1(), this.getY1(), getWidth(), getHeight());
	}
	
	
}
