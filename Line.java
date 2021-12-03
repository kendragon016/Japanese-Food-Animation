/**
	*This class implements the DrawingObject interface. It accepts the values to be used as the coordinates, thickness, and color of the line.
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

public class Line implements DrawingObject
{
	private double xPosition1, yPosition1, xPosition2, yPosition2;
	private int thick;
	private Color color;

	//The constructor accepts 6 values. These represent the color, coordinates and thickness of the line to be drawn.
	public Line(double x1, double y1, double x2, double y2, int t, Color c)
	{
		xPosition1 = x1;
		yPosition1 = y1;
		xPosition2 = x2;
		yPosition2 = y2;
		thick = t;
		color = c;
	}

	//This method draws the line using the assigned values. It makes use of the Line2D.Double class.
	public void draw(Graphics2D g2d)
	{
		g2d.setStroke(new BasicStroke(thick));

		Line2D.Double line = new Line2D.Double(
			xPosition1, yPosition1, 
			xPosition2, yPosition2
		);
		g2d.setColor(color);
		g2d.draw(line);
	}

	//This method is called to move the line to the right. The value accepted is the distance by which the line moves. 
	public void right(double n)
	{
		xPosition1 += n;
		xPosition2 += n;
	}

	//This method is called to move the line to the left. The value accepted is the distance by which the line moves.
	public void left(double n)
	{
		xPosition1 -=n;
		xPosition2 -=n;
	}
}