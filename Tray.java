/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a tray. 
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

public class Tray implements DrawingObject
{
	private Trapezoid base;
	private Square frontEdge, backEdge;
	private Line corner1, corner2;
	private double xPosition, yPosition, size;
	private Color cBase, cInside, cFront;
	private Tray tray;
	
	//The constructor instantiates objects of the Trapezoid, Square, and Line classes. 
	//The accepted values also represent the color, coordinates, and size of the tray and the shapes used to draw it.
	public Tray(double x, double y, double s, Color cb, Color ci, Color cf)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cBase = cb;
		cInside = ci;
		cFront = cf;
		base = new Trapezoid(xPosition, yPosition, size, cBase);
		frontEdge = new Square(xPosition, yPosition+size*11/12, size*7/3, size/12, cFront);
		backEdge = new Square(xPosition+size/3, yPosition-size/12, size*5/3, size/12, cInside);
		corner1 = new Line(xPosition+size/3, yPosition-size/12,xPosition+size/3, yPosition, 1, cBase);
		corner2 = new Line(xPosition+size*2, yPosition-size/12, xPosition+size*2, yPosition, 1, cBase);
	}

	//This method draws the Trapezoid, Square, and Line objects using the assigned values. It also makes use of the Path2D.Double class to draw irregular shapes. 
	public void draw(Graphics2D g2d)
	{
		base.draw(g2d);
		backEdge.draw(g2d);
		
		Path2D.Double leftEdge = new Path2D.Double();
		leftEdge.moveTo(xPosition+size/3, yPosition-size/12);
		leftEdge.lineTo(xPosition+size/3, yPosition);
		leftEdge.lineTo(xPosition, yPosition+size);
		leftEdge.lineTo(xPosition, yPosition+size*11/12);
		leftEdge.closePath();
		g2d.setColor(cInside);
		g2d.fill(leftEdge);

		Path2D.Double rightEdge = new Path2D.Double();
		rightEdge.moveTo(xPosition+size*2, yPosition-size/12);
		rightEdge.lineTo(xPosition+size*2, yPosition);
		rightEdge.lineTo(xPosition+size*7/3, yPosition+size);
		rightEdge.lineTo(xPosition+size*7/3, yPosition+size*11/12);
		rightEdge.closePath();
		g2d.setColor(cInside);
		g2d.fill(rightEdge);

		corner1.draw(g2d);
		corner2.draw(g2d);
		frontEdge.draw(g2d);
	}
}