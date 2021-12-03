/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a nigiri. 
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

public class Nigiri implements DrawingObject
{
	private Circle salmon, rice;
	private double xPosition, yPosition, size;
	private Color cSalmon, cRice, cNori;

	//The constructor instantiates 2 objects of the Circle class. 
	//The accepted values also represent the color, coordinates, and size of the nigiri and the shapes used to draw it.
	public Nigiri(double x, double y, double s, Color cs, Color cr, Color cn)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cSalmon = cs;
		cRice = cr;
		cNori = cn;
		rice = new Circle(xPosition+size*5/32, yPosition+size*0.1, size*53/64, size*13/32, cRice);
		salmon = new Circle(xPosition, yPosition, size, size/2, cSalmon);
	}

	//This method draws the Circle objects using the assigned values. 
	//It also makes use of the RoundRectangle2D.Double class to draw a round-cornered rectangle. 
	public void draw(Graphics2D g2d)
	{
		AffineTransform reset = g2d.getTransform();
		g2d.translate(270, 0);
		salmon.draw(g2d);
		rice.draw(g2d);
		
		//RoundRectangle2D from https://kodejava.org/how-do-i-draw-a-round-rectangle-in-java-2d/
		RoundRectangle2D.Double nori = new RoundRectangle2D.Double(
			xPosition+size*7/16, yPosition, size/8, size*33/64, size/25, size/16 
		);
		g2d.setColor(cNori);
		g2d.fill(nori);
		g2d.setTransform(reset);
	}
}