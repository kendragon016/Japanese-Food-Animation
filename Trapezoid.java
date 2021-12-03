/**
	*This class implements the DrawingObject interface. It accepts the values to be used as the coordinates, size and color of the trapezoid shape.
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

public class Trapezoid implements DrawingObject
{
	private double xPosition, yPosition, size;
	private Color color;
	
	//The constructor accepts 4 values. These represent the color, coordinates and size of the trapezoid to be drawn.
	public Trapezoid(double x, double y, double s, Color c)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		color = c;
	}

	//This method draws the trapezoid using the assigned values. It makes use of the Path2D.Double class.
	public void draw(Graphics2D g2d)
	{
		Path2D.Double top = new Path2D.Double();
		top.moveTo(xPosition, yPosition+size);
		top.lineTo(xPosition+size*7/3, yPosition+size);
		top.lineTo(xPosition+size*2, yPosition);
		top.lineTo(xPosition+size/3, yPosition);
		top.closePath();
		g2d.setColor(color);
		g2d.fill(top);
	}
}