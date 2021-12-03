/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a maki. 
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

public class Maki implements DrawingObject
{
	private Circle base, top, rice;
	private Square body;
	private double xPosition, yPosition, size;
	private Color cMiddle, cRice, cNori;
	
	//The constructor instantiates 3 objects of the Circle class and an object of the Square class. 
	//The accepted values also represent the color, coordinates, and size of the maki and the shapes used to draw it.
	public Maki(double x, double y, double s, Color cm, Color cr, Color cn)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cMiddle = cm;
		cRice = cr;
		cNori = cn;	
		base = new Circle(xPosition, yPosition+size*5/8, size*1.5, size*3/4, cNori);
		body = new Square(xPosition, yPosition, size*1.5, size, cNori);
		top = new Circle(xPosition, yPosition-size*5/16, size*1.5, size*3/4, cNori);
		rice = new Circle(xPosition+size/16, yPosition-size/4, size*1.375, size*5/8, cRice);
	}

	//This method draws the Square and Circles object using the assigned values. 
	//It also makes use of the RoundRectangle2D.Double class to draw a round-cornered rectangle. 
	public void draw(Graphics2D g2d)
	{
		base.draw(g2d);
		body.draw(g2d);
		top.draw(g2d);
		rice.draw(g2d);

		//RoundRectangle2D from https://kodejava.org/how-do-i-draw-a-round-rectangle-in-java-2d/
		RoundRectangle2D.Double middle = new RoundRectangle2D.Double(               
			xPosition+size*3/8, yPosition-size/12, size*3/4, size/4, size/6, size/6 
		);
		g2d.setColor(cMiddle);
		g2d.fill(middle);
	}
}