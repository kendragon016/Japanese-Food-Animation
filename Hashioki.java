/**
	*This class implements the DrawingObject interface and accepts the coordinates, size and color of the shapes needed to draw 2 pieces of hashioki. 
	*The original hashioki is from the inner class OrigHashioki.
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

public class Hashioki implements DrawingObject
{
	private double xPosition, yPosition, width, height;
	private Color cTop, cFront, cSide;
	private OrigHashioki hashioki1, hashioki2;
	
	//The constructor instantiates 2 OrigHashioki objects. The accepted values also represent the color, coordinates, and size of the hashioki.
	public Hashioki(double x, double y, double w, double h, Color ct, Color cf, Color cs)
	{
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		cTop = ct;
		cFront = cf;
		cSide = cs;
		hashioki1 = new OrigHashioki(xPosition, yPosition, width, height, cTop, cFront, cSide);
		hashioki2 = new OrigHashioki(xPosition, yPosition, width, height, cTop, cFront, cSide);
	}

	//This method draws the hashioki using the assigned values. It flips and moves the objects into the correct positions.
	public void draw(Graphics2D g2d)
	{
		hashioki1.draw(g2d);
		AffineTransform reset = g2d.getTransform();
		g2d.scale(-1, 1); 										//g2d.scale() from https://gist.github.com/eed3si9n/632780
		g2d.translate(-1045, 105);																	
		hashioki2.draw(g2d);
		g2d.setTransform(reset);
	}

	//This inner class accepts the coordinates, size, and color of shapes needed to create and draw one hashioki. 
	//It makes use of a square object to create it.
	class OrigHashioki
	{
		private Square bottom;
	
		//The constructor instantiates the square object. 
		//It also accepts the values that represent the size and coordinates of the shapes needed to draw the hashioki.
		public OrigHashioki(double x, double y, double w, double h, Color ct, Color cf, Color cs)
		{
			bottom = new Square(xPosition-width*0.08, yPosition+height, width, height/2, cFront);
		}

		//This method draws the square. It also makes use of the Path2D.Double to draw the irregular shapes.
		public void draw(Graphics2D g2d)
		{
			Path2D.Double parallelogram = new Path2D.Double();
			parallelogram.moveTo(xPosition, yPosition);
			parallelogram.lineTo(xPosition+width, yPosition);
			parallelogram.lineTo(xPosition+width*0.92 , yPosition+height);
			parallelogram.lineTo(xPosition-width*0.08, yPosition+height);
			parallelogram.closePath();
			g2d.setColor(cTop);
			g2d.fill(parallelogram);

			bottom.draw(g2d);

			Path2D.Double edge = new Path2D.Double();
			edge.moveTo(xPosition+width, yPosition);
			edge.lineTo(xPosition+width*0.92, yPosition+height);
			edge.lineTo(xPosition+width*0.92, yPosition+height*1.5);
			edge.lineTo(xPosition+width, yPosition+height/2);
			edge.closePath();
			g2d.setColor(cSide);
			g2d.fill(edge);	
		}
	}
	
}