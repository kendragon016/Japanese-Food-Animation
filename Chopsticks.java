/**
	*This class implements the DrawingObject interface and accepts the coordinates, size and color of the shapes needed to draw 2 pairs of chopsticks. 
	*The original pair of chopsticks is from the inner class OrigChopsticks.
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

public class Chopsticks implements DrawingObject
{
	private double xPosition, yPosition, width, height;
	private Color cChopstick;
	private OrigChopsticks chopsticks1, chopsticks2;
	
	//The constructor instantiates 2 OrigChopsticks objects. The accepted values also represent the color, coordinates, and size of the chopsticks.
	public Chopsticks(double x, double y, double w, double h, Color cc)
	{
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		cChopstick = cc;
		chopsticks1 = new OrigChopsticks(xPosition, yPosition, width, height, cChopstick);
		chopsticks2 = new OrigChopsticks(xPosition, yPosition, width, height, cChopstick);
	}

	//This method draws the chopsticks using the assigned values. It rotates and moves the objects into the correct positions.
	public void draw(Graphics2D g2d)
	{
		AffineTransform reset2 = g2d.getTransform();
		g2d.rotate(Math.toRadians(15), 210, 400);
		g2d.translate(-40, 0);
		chopsticks1.draw(g2d);
		g2d.setTransform(reset2);

		AffineTransform reset3 = g2d.getTransform();
		g2d.translate(605, -155);
		g2d.rotate(Math.toRadians(165), 205, 395);
		chopsticks2.draw(g2d);
		g2d.setTransform(reset3);
	}

	//This inner class accepts the coordinates, size, and color of shapes needed to create and draw one pair of chopsticks. 
	//It makes use 2 triangle objects to create it.
	class OrigChopsticks
	{
		private Triangle left, right;
	
		//The constructor instantiates two objects of the Triangle class. It also accepts the values that represent the size and coordinates of the triangles.
		public OrigChopsticks(double x, double y, double w, double h, Color cc)
		{
			left = new Triangle(xPosition, yPosition, width, height, cChopstick);
			right = new Triangle(xPosition+width*1.2, yPosition, width, height, cChopstick);
		}

		//This method draws the two trianlges. These are the left and right side of the chopsticks.
		public void draw(Graphics2D g2d)
		{
			left.draw(g2d);
			right.draw(g2d);	
		}
	}
}