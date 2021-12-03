/**
	*This class implements the DrawingObject interface. It accepts the values to be used as the coordinates, size and color of the square shape.
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

public class Square implements DrawingObject
{
	private double xPosition, yPosition, width, height;
	private Color color;
	
	//The constructor accepts 5 values. These represent the color, coordinates and size of the square to be drawn.
	public Square(double x, double y, double w, double h, Color c)
	{
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		color = c;
	}

	//This method draws the square using the assigned values. It makes use of the Rectangle2D.Double class.
	public void draw(Graphics2D g2d)
	{
		Rectangle2D.Double square = new Rectangle2D.Double(
			xPosition, yPosition, 
			width, height
		);
		g2d.setColor(color);
		g2d.fill(square);
	}

	//This method is called to move the square to the right. The value accepted is the distance by which the square moves. 
	public void right(double n)
	{
		xPosition += n;
	}

	//This method is called to move the square to the left. The value accepted is the distance by which the square moves. 
	public void left(double n)
	{
		xPosition -=n;
	}
}