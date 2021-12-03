/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a plate. 
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

public class Plate implements DrawingObject
{
	private Square edge;
	private Trapezoid plate;
	private double xPosition, yPosition, size;
	private Color cPlate, cEdge;
	
	//The constructor instantiates an object of the Square and Trapezoid classes. 
	//The accepted values also represent the color, coordinates, and size of the plate and the shapes used to draw it.
	public Plate(double x, double y, double s, Color cp, Color ce)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cPlate = cp;
		cEdge = ce;
		plate = new Trapezoid(xPosition, yPosition, size, cPlate);
		edge = new Square(xPosition, yPosition+size, size*7/3, size/12, cEdge);
	}

	//This method draws the Square and Trapezoid objects using the assigned values. 
	public void draw(Graphics2D g2d)
	{
		plate.draw(g2d);
		edge.draw(g2d);
	}
}