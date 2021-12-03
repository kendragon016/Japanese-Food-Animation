/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a dipping bowl. 
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

public class DippingBowl implements DrawingObject
{
	private Square base;
	private Circle opening, sauce;
	private double xPosition, yPosition, size;
	private Color cBody, cOpening, cSauce;

	//The constructor instantiates an object of the Square class and 2 objects from the Circle class. 
	//The accepted values also represent the color, coordinates, and size of the dipping bowl and the shapes used to draw it.
	public DippingBowl(double x, double y, double s, Color cb, Color co, Color cs)
	{
		xPosition = x;
		yPosition = y;
		size = s;	
		cBody = cb;
		cOpening = co;
		cSauce = cs;
		base = new Square(xPosition+size/4, yPosition+size/5, size/2, size*0.15, cOpening);
		opening = new Circle(xPosition, yPosition-size*0.12, size, size/4, cOpening);
		sauce = new Circle(xPosition+size*0.05, yPosition-size/18, size*0.9, size*3/16, cSauce);
	}

	//This method draw the square and circle objects. It also makes use of the Path2D.Double class to draw a curved path.  
	public void draw(Graphics2D g2d)
	{
		base.draw(g2d);

		Path2D.Double body = new Path2D.Double();
		body.moveTo(xPosition, yPosition);
		body.curveTo(xPosition, yPosition+size*2/5, xPosition+size, yPosition+size*2/5, xPosition+size, yPosition);
		body.closePath();
		g2d.setColor(cBody);
		g2d.fill(body);

		opening.draw(g2d);
		sauce.draw(g2d);
	}
}