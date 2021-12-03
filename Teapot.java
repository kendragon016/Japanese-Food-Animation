/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a teapot. 
	*
	*@author Kendra Kirsten L. Go (192252)
	*@version 01 April 2020
**/

/*
	I have not discussed the Java language code in my program with anyone other than my instructor or the teaching assistants  assigned to this course.
	
	I have not used Java language code obtained from another student, or any other unauthorized source, either modified or unmodified.
	
	If any Java language code or documentation used in my program was obtained from another source, such as a textbook or website, that has been clearly noted with a proper citation in the comments of my program.

*/

import java.awt.*;
import java.awt.geom.*;

public class Teapot implements DrawingObject
{
	private Circle body, lid, holder;
	private Square stick;
	private double xPosition, yPosition, size;
	private Color cBody, cLid;
	
	//The constructor instantiates objects of the Circle and Square classes. 
	//The accepted values also represent the color, coordinates, and size of the teapot and the shapes used to draw it.
	public Teapot(double x, double y, double s, Color cb, Color cl)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cBody = cb;
		cLid = cl;
		body = new Circle(xPosition, yPosition, size, size*3/5, cBody);
		lid = new Circle(xPosition+size/5, yPosition-size/40, size*3/5, size/5, cLid);
		stick = new Square(xPosition+size*0.49, yPosition+size/80, size/40 , size/16, cBody);
		holder = new Circle(xPosition+size*0.47, yPosition-size/32, size/16, size/16, cBody);
	}

	//This method draws the Circle  and Sqaure objects using the assigned values. It also makes use of the Path2D.Double class to draw 2 curved paths. 
	public void draw(Graphics2D g2d)
	{
		AffineTransform reset = g2d.getTransform();
		g2d.translate(-12, 16); 					
		Path2D.Double spout = new Path2D.Double();
		spout.moveTo(xPosition+size*0.9, yPosition+size/4);
		spout.lineTo(xPosition+size*1.2, yPosition);
		spout.lineTo(xPosition+size*1.3, yPosition+size/10);
		spout.lineTo(xPosition+size*1.2, yPosition+size/10);
		spout.lineTo(xPosition+size*0.9, yPosition+size*2/5);
		spout.closePath();
		g2d.setColor(cLid);
		g2d.fill(spout);
		g2d.setTransform(reset);

		g2d.setStroke(new BasicStroke(3));

		Path2D.Double handle = new Path2D.Double();
		handle.moveTo(xPosition+size/10, yPosition+size/5);
		handle.curveTo(xPosition+size/10, yPosition-size*5/8, xPosition+size*9/10, yPosition-size*5/8, xPosition+size*9/10, yPosition+size/5);
		g2d.setColor(cLid);
		g2d.draw(handle);

		body.draw(g2d);
		lid.draw(g2d);
		stick.draw(g2d);
		holder.draw(g2d);

		AffineTransform reset2 = g2d.getTransform();
		g2d.translate(0, -4); 		
		Path2D.Double design = new Path2D.Double();
		design.moveTo(xPosition, yPosition+size*3/10);
		design.curveTo(xPosition, yPosition+size/2, xPosition+size, yPosition+size/2, xPosition+size-1, yPosition+size*3/10);
		g2d.setColor(cLid);
		g2d.draw(design);
		g2d.setTransform(reset2);
	}
}