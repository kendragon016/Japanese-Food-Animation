/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a round cornered triangle. 
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

public class RoundTriangle implements DrawingObject
{
	private Square cover;
	private double xPosition, yPosition, size; //size = 64
	private Color color;

	//The constructor instantiates an object of the Square class. 
	//The accepted values also represent the color, coordinates, and size of the round cornered triangle.
	public RoundTriangle(double x, double y, double s, Color c)
	{
		xPosition = x;
		yPosition = y;
		size = s;	
		color = c;
		cover = new Square(xPosition-size/4, yPosition+size/2, size/2, size*0.49, color);
	}

	//This method draws the Square object using the assigned values. It also makes use of the Path2D.Double class to draw curved paths. 
	public void draw(Graphics2D g2d)
	{
		cover.draw(g2d);

		Path2D.Double rt = new Path2D.Double();
		rt.moveTo(xPosition+size/4, yPosition+size/2);
		rt.curveTo(xPosition+size/2, yPosition+size, xPosition+size/2, yPosition+size, xPosition, yPosition+size);
		rt.moveTo(xPosition, yPosition+size);
		rt.curveTo(xPosition-size/2, yPosition+size, xPosition-size/2, yPosition+size, xPosition-size/4, yPosition+size/2);
		rt.moveTo(xPosition-size/4, yPosition+size/2);
		rt.curveTo(xPosition, yPosition, xPosition, yPosition, xPosition+size/4, yPosition+size/2);
		g2d.setColor(color);
		g2d.fill(rt);
	}
}