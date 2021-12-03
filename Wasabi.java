/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw the wasabi. 
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

public class Wasabi implements DrawingObject
{
	private Circle bottom, middle, top;
	private double xPosition, yPosition, size; //size = 96
	private Color color;

	//The constructor instantiates 3 object of the Circle class. 
	//The accepted values also represent the color, coordinates, and size of the wasabi and the shapes used to draw it.
	public Wasabi(double x, double y, double s, Color c)
	{
		xPosition = x;
		yPosition = y;
		size = s;	
		color = c;
		bottom = new Circle(xPosition, yPosition, size, size/3, c);
		middle = new Circle(xPosition+size/6, yPosition-size/8, size*2/3, size/4, c);
		top = new Circle(xPosition+size/3, yPosition-size/5, size/3, size/6, c);
	}

	//This method draws the Circle objects using the assigned values.
	public void draw(Graphics2D g2d)
	{
		bottom.draw(g2d);
		middle.draw(g2d);
		top.draw(g2d);
	}
}