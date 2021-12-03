/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a lantern. 
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

public class Lantern implements DrawingObject
{
	private double xPosition, yPosition, size;
	private Color cHook, cTop, cMiddle;
	private Square top, bottom;
	private Line hook;
	
	//The constructor instantiates 2 objects of the Square class and an object of the Line class. 
	//The accepted values also represent the color, coordinates, and size of the lantern and the shapes used to draw it.
	public Lantern(double x, double y, double s, Color ch, Color ct, Color cm)
	{
		xPosition = x;
		yPosition = y;
		size = s;	
		cHook = ch;
		cTop = ct;
		cMiddle = cm;
		top = new Square(xPosition, yPosition, size, size*.2, cTop);
		bottom = new Square(xPosition, yPosition+size*23/15, size, size*.2, cTop);
		hook = new Line(xPosition+size/2, yPosition, xPosition+size/2, yPosition-size/2, 4, cHook);
	}

	//This method draws the Line and Sqaure objects using the assigned values. 
	//It also makes use of the RoundRectangle2D.Double class to draw a round cornered rectangle.
	public void draw(Graphics2D g2d)
	{
		hook.draw(g2d);
		top.draw(g2d);
		bottom.draw(g2d);

		//RoundRectangle2D from https://kodejava.org/how-do-i-draw-a-round-rectangle-in-java-2d/
		RoundRectangle2D.Double middle = new RoundRectangle2D.Double(             
			xPosition-size*2/3, yPosition+size*.2, size*7/3, size*4/3, size*1.5625, size*5/2
		);
		g2d.setColor(cMiddle);
		g2d.fill(middle);
	}
}