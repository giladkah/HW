package Q2;

import java.awt.Color;
import java.awt.Graphics;


public class MyLine extends MyShape  {

	private double length ;
	
	public MyLine(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
		calculateLength();
	}
	
	
	private void calculateLength() {
		
		int x_length = this.getX1() - this.getX2();
		int y_length = this.getY1() - this.getY2();
		
		length =  Math.sqrt(x_length^2 + y_length^2 );

	}
	
	@Override
	public boolean equals(Object obj) {	
		if (obj==null)
			return false;

		if (!(obj instanceof MyLine)) 
			return false; 
	
		MyLine myLine = (MyLine) obj;
		
		return (this.length==myLine.length); 
		
	}


	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());

	}
	
	
}
