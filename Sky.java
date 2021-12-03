/**
	*This class implements the DrawingObject interface. It accepts the coordinates, size and color of the shapes needed to draw the sky. 
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

public class Sky implements DrawingObject
{
	private Square s1, s2, s3, s4, s5, s6, s7, s8, s9;
	private double xPosition, yPosition, width, height;
	private Color cs1, cs2, cs3, cs4, cs5, cs6;

	//The constructor instantiates 6 objects of the Square class. 
	//The accepted values also represent the color, coordinates, and size of the sky and the shapes used to draw it.
	public Sky(double x, double y, double w, double h, Color c1, Color c2, Color c3, Color c4, Color c5, Color c6)
	{
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		cs1 = c1;
		cs2 = c2;
		cs3 = c3;
		cs4 = c4;
		cs5 = c5;
		cs6 = c6;
		s1 = new Square(xPosition, yPosition, width, height, cs6);
		s2 = new Square(xPosition, yPosition+height, width, height, cs5);
		s3 = new Square(xPosition, yPosition+height*2, width, height, cs4);
		s4 = new Square(xPosition, yPosition+height*3, width, height, cs3);
		s5 = new Square(xPosition, yPosition+height*4, width, height, cs2);
		s6 = new Square(xPosition, yPosition+height*5, width, height, cs1);
	}

	//This method draws the Square objects using the assigned values.
	public void draw(Graphics2D g2d)
	{
		s1.draw(g2d);
		s2.draw(g2d);
		s3.draw(g2d);
		s4.draw(g2d);
		s5.draw(g2d);
		s6.draw(g2d);
	}
}