package Q2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestMyShape extends JPanel {

   public static void main(String[] a) {
      JFrame f = new JFrame();
      f.setSize(400, 400);
      f.add(new TestMyShape());
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }

   public void paint(Graphics g) {
      
	   ArrayList<MyShape> shapes = new ArrayList<MyShape>(); 
	   ArrayList<MyShape> clonedShapes = new ArrayList<MyShape>(); 

	   // lines
	   shapes.add(new MyLine(randInt(0,200),randInt(0,200),randInt(0,200),randInt(0,200), Color.BLUE));
	   shapes.add(new MyLine(randInt(0,200),randInt(0,200),randInt(0,200),randInt(0,200), Color.RED));

	   // rectangles 
	   shapes.add(new MyRectangle(randInt(0,200),randInt(0,200),randInt(0,200),randInt(0,200),Color.GREEN, true));
	   shapes.add(new MyRectangle(randInt(0,200),randInt(0,200),randInt(0,200),randInt(0,200),Color.YELLOW, true));

	   // ellipses 
	   shapes.add(new MyOval(randInt(0,200),randInt(0,200),randInt(0,200),randInt(0,200),Color.DARK_GRAY,true));
	   shapes.add(new MyOval(randInt(0,200),randInt(0,200),randInt(0,200),randInt(0,200),Color.CYAN,true));

	   // create shapes 
	   for (MyShape shape : shapes) { 		  
		   shape.draw(g);
		   clonedShapes.add((MyShape) shape.clone()); 	
		   
	   }

	   // create and draw cloned shapes
	   for (MyShape clonedShape : clonedShapes) {
		   clonedShape.setX1(clonedShape.getX1()+10);
		   clonedShape.setY1(clonedShape.getY1()+10);
		   
		   if (clonedShape instanceof MyBoundedShape) {
			   MyBoundedShape myBoundedShpae = (MyBoundedShape) clonedShape;
			   if (myBoundedShpae.getIsFull()) {
				   myBoundedShpae.setEmpty();
			   }
			   else {
				   myBoundedShpae.setFull(); 
			   }
		   }
		   clonedShape.draw(g);
	   }
   }
   
   public static int randInt(int min, int max) {

	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
   
}