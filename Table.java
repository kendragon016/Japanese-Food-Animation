/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw a table. 
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

public class Table implements DrawingObject
{
	private Square left, right, edge;
	private Trapezoid top;
	private double xPosition, yPosition, size;
	private Color cMain, cShadow;

	//The constructor instantiates 3 objects of the Square class and an object of the Trapezoid class. 
	//The accepted values also represent the color, coordinates, and size of the table and the shapes used to draw it.
	public Table(double x, double y, double s, Color cm, Color cs)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cMain = cm;
		cShadow = cs;
		left = new Square(xPosition+size*2, yPosition+size*12, size*2, size*3, cMain);
		right = new Square(xPosition+size*24, yPosition+size*12, size*2, size*3, cMain);
		top = new Trapezoid(xPosition, yPosition, 384, cMain);
		edge = new Square(xPosition, yPosition+size*12, size*28, size/2, cShadow);
	}

	//This method draws the Square and Trapezoid objects using the assigned values. It also makes use of the Path2D.Double class to draw 2 irregular shapes. 
	public void draw(Graphics2D g2d)
	{	
		left.draw(g2d);
		right.draw(g2d);

		Path2D.Double leftSide = new Path2D.Double();
		leftSide.moveTo(xPosition+size*4, yPosition+size*15);
		leftSide.lineTo(xPosition+size*5, yPosition+size*14);
		leftSide.lineTo(xPosition+size*5, yPosition+size*10);
		leftSide.lineTo(xPosition+size*4, yPosition+size*10);
		leftSide.closePath();
		g2d.setColor(cShadow);
		g2d.fill(leftSide);

		Path2D.Double rightSide = new Path2D.Double();
		rightSide.moveTo(xPosition+size*24, yPosition+size*15);
		rightSide.lineTo(xPosition+size*23, yPosition+size*14);
		rightSide.lineTo(xPosition+size*23, yPosition+size*10);
		rightSide.lineTo(xPosition+size*24, yPosition+size*10);
		rightSide.closePath();
		g2d.setColor(cShadow);
		g2d.fill(rightSide);

		top.draw(g2d);
		edge.draw(g2d);
	} 
}
