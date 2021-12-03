/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a cup. 
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

public class Cup implements DrawingObject
{
	private Circle opening;
	private double xPosition, yPosition, size;
	private Color cBody, cOpening;

	//The constructor instantiates an object of the Circle class. 
	//The accepted values also represent the color, coordinates, and size of the cup and the shapes used to draw it.
	public Cup(double x, double y, double s, Color cb, Color co)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cBody = cb;
		cOpening = co;
		opening = new Circle(xPosition, yPosition-size/4, size, size/2, cOpening);
	}

	//This method draws the Circle object using the assigned values. It also makes use of the Path2D.Double class to draw 2 curved paths. 
	public void draw(Graphics2D g2d)
	{
		Path2D.Double body = new Path2D.Double();
		body.moveTo(xPosition, yPosition);
		body.curveTo(xPosition, yPosition+size*1.25, xPosition+size, yPosition+size*1.25, xPosition+size, yPosition);
		body.closePath();
		g2d.setColor(cBody);
		g2d.fill(body);

		Path2D.Double design = new Path2D.Double();
		design.moveTo(xPosition+size/20-1, yPosition+size*2/5);
		design.curveTo(xPosition+size/20-1, yPosition+size*7/10, xPosition+size*9/10+1, yPosition+size*7/10, xPosition+size*15/16+1, yPosition+size*2/5);
		g2d.setColor(cOpening);
		g2d.draw(design);

		opening.draw(g2d);
	}
}