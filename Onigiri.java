/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw an onigiri. 
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

public class Onigiri implements DrawingObject
{
	private RoundTriangle rice;
	private double xPosition, yPosition, size;
	private Color cRice, cNori;

	//The constructor instantiates an object of the RoundTriangle class. 
	//The accepted values also represent the color, coordinates, and size of the onigiri and the shapes used to draw it.
	public Onigiri(double x, double y, double s, Color cr, Color cn)
	{
		xPosition = x;
		yPosition = y;
		size = s;	
		cRice = cr;
		cNori = cn;	
		rice = new RoundTriangle(xPosition, yPosition, size, cRice);
	}

	//This method draws the RoundTriangle object using the assigned values. 
	//It also makes use of the RoundRectangle2D.Double class to draw a round-cornered rectangle. 
	public void draw(Graphics2D g2d)
	{
		rice.draw(g2d);
		
		//RoundRectangle2D from https://kodejava.org/how-do-i-draw-a-round-rectangle-in-java-2d/
		RoundRectangle2D.Double nori = new RoundRectangle2D.Double(               
			xPosition-size/6, yPosition+size*3/5, size/3, size*0.4, size/16, size/16 
		);
		g2d.setColor(cNori);
		g2d.fill(nori);
	}
}