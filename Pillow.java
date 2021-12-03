/**
	*This class implements the DrawingObject interface and accepts the coordinates, size and color of the shapes needed to draw 2 pillows. 
	*The original pillow is from the inner class OrigPillow.
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

public class Pillow implements DrawingObject
{
	private OrigPillow pillow1, pillow2;
	private Color cTop, cSide;
	private double xPosition, yPosition, size;
	
	//The constructor instantiates 2 OrigPillow objects. The accepted values also represent the color, coordinates, and size of the pillows.
	public Pillow(double x, double y, double s, Color ct, Color cs)
	{
		xPosition = x;
		yPosition = y;
		size = s;	
		cTop = ct;
		cSide = cs;
		pillow1 = new OrigPillow(xPosition, yPosition, size, cTop, cSide);
		pillow2 = new OrigPillow(xPosition, yPosition, size, cTop, cSide);
	}

	//This method draws the pillow using the assigned values. It flips and moves the objects into the correct positions.
	public void draw(Graphics2D g2d)
	{
		pillow1.draw(g2d);
		AffineTransform flipPillow = g2d.getTransform();
		g2d.scale(-1, 1); 													//g2d.scale() from https://gist.github.com/eed3si9n/632780
		g2d.translate(-1024,0);					
		pillow2.draw(g2d);
		g2d.setTransform(flipPillow);
	}

	//This inner class accepts the coordinates, size, and color of shapes needed to create and draw one pillow. 
	//It makes use a of a Square object to create it.
	class OrigPillow
	{
		private Square side;
		
		//The constructor instantiates an objects of the Square class. 
		//It also accepts the values that represent the size and coordinates of the shapes needed to draw the pillow.
		public OrigPillow(double x, double y, double s, Color ct, Color cs)
		{
			side = new Square(xPosition, yPosition+size*0.95, size, size/8, cSide);	
		}	

		
		//This method draws the square. It also makes use of the RoundRectangle class to draw a round cornered rectangle.
		public void draw(Graphics2D g2d)
		{
			AffineTransform reset = g2d.getTransform();
			g2d.rotate(Math.toRadians(15), xPosition, yPosition);
			
			//RoundRectangle2D from https://kodejava.org/how-do-i-draw-a-round-rectangle-in-java-2d/
			RoundRectangle2D.Double top = new RoundRectangle2D.Double(         
				xPosition, yPosition, size, size, size/4, size/4
			);
			g2d.setColor(cTop);
			g2d.fill(top);

			side.draw(g2d);

			g2d.setTransform(reset);

		}
	}
}