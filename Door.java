/**
	*This class implements the DrawingObject interface and accepts the coordinates, size and color of the shapes needed to draw 2 doors. 
	*The original door is from the inner class OrigDoor.
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

public class Door implements DrawingObject
{
	private double xPosition, yPosition, size;
	private Color cFrame, cScreen, cOutline;
	private OrigDoor left, right;
	private Square frame, screen;
	private Line v1, v2, v3, v4, h1, h2, h3, h4;	
	
	//The constructor instantiates 2 OrigDoor objects. The accepted values also represent the color, coordinates, and size of the door.
	public Door(double x, double y, double s, Color co, Color cf, Color cs)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cFrame = cf;
		cScreen = cs;
		cOutline = co;	
		left = new OrigDoor(xPosition, yPosition, size, cOutline, cFrame, cScreen);
		right = new OrigDoor(xPosition, yPosition, size, cOutline, cFrame, cScreen);
	}

	//This method draws the doors using the assigned values. It flips the right door which is just a reflection of the left door.
	public void draw(Graphics2D g2d)
	{
		left.draw(g2d);

		AffineTransform reset = g2d.getTransform();
		g2d.scale(-1, 1); 									     //g2d.scale() from https://gist.github.com/eed3si9n/632780
		g2d.translate(-1024,0);
		right.draw(g2d);
		g2d.setTransform(reset);
	}

	//This method is called to open the doors. It moves the left door to the left and the right door to the right.
	public void left(double n)
	{
		xPosition -= n;
		frame.left(n);
		screen.left(n);
		v1.left(n);
		v2.left(n);
		v3.left(n);
		v4.left(n);
		h1.left(n);
		h2.left(n);
		h3.left(n);
		h4.left(n);
	}

	//This method is called to close the doors. It moves the left door to the right and the right door to the left.
	public void right(double n)
	{
		xPosition +=n;
		frame.right(n);
		screen.right(n);
		v1.right(n);
		v2.right(n);
		v3.right(n);
		v4.right(n);
		h1.right(n);
		h2.right(n);
		h3.right(n);
		h4.right(n);
	}

	//This inner class accepts the coordinates, size, and color of shapes needed to create and draw one side of the door. 
	//It makes use 2 square objects, and 8 line objects to create it.
	class OrigDoor
	{
		//The constructor instantiates the 2 square objects and 8 line objects.
		//It also accepts the values that represent the size and coordinates of the shapes needed for the door.
		public OrigDoor(double x, double y, double s, Color co, Color cf, Color cs)
		{
			frame = new Square(xPosition, yPosition, size*16, size*11, cFrame);
			screen = new Square(xPosition, yPosition, size*15, size*9, cScreen);
			v1 = new Line(xPosition+size*3, yPosition, xPosition+size*3, yPosition+size*9, 3, cFrame);
			v2 = new Line(xPosition+size*6, yPosition, xPosition+size*6, yPosition+size*9, 3, cFrame);
			v3 = new Line(xPosition+size*9, yPosition, xPosition+size*9, yPosition+size*9, 3, cFrame);
			v4 = new Line(xPosition+size*12, yPosition, xPosition+size*12, yPosition+size*9, 3, cFrame);
			h1 = new Line(xPosition, yPosition+size, xPosition+size*15, yPosition+size, 3, cFrame);
			h2 = new Line(xPosition, yPosition+size*3, xPosition+size*15, yPosition+size*3, 3, cFrame);
			h3 = new Line(xPosition, yPosition+size*5, xPosition+size*15, yPosition+size*5, 3, cFrame);
			h4 = new Line(xPosition, yPosition+size*7, xPosition+size*15, yPosition+size*7, 3, cFrame);
		}

		//This method draws the square and line objects. It also makes use of the Rectangle2D.Double class to draw the door's outline.
		public void draw(Graphics2D g2d)
		{
			frame.draw(g2d);
			
			AffineTransform stroke = g2d.getTransform();
			g2d.setStroke(new BasicStroke(3));
			Rectangle2D.Double frameOutline = new Rectangle2D.Double(
				xPosition-size, yPosition-size, 
				size*17, size*12
			);
			g2d.setColor(cOutline);
			g2d.draw(frameOutline);
			g2d.setTransform(stroke);

			screen.draw(g2d);
			v1.draw(g2d);
			v2.draw(g2d);
			v3.draw(g2d);
			v4.draw(g2d);
			h1.draw(g2d);
			h2.draw(g2d);
			h3.draw(g2d);
			h4.draw(g2d);
		}
	}
}