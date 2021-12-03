/**
	*This class implements the DrawingObject interface and accepts the coordinates, size and color of the shapes needed to draw a Sakura flower. 
	*The Sakura petal is from the inner class Petal.
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
import java.util.*;

public class Sakura implements DrawingObject
{
	private double xPosition, yPosition, size, ySpeed;
	private Color cFlower;
	private Petal petal1, petal2, petal3, petal4, petal5;
	private Random random;

	//The constructor instantiates 5 Petal objects. The accepted values also represent the color, coordinates, and size of the petals.
	public Sakura(double x, double y, double s, Color cf)
	{
		random = new Random();
		xPosition = x;
		yPosition = y;
		size = s;
		cFlower = cf;
		petal1 = new Petal(xPosition, yPosition, size, cFlower);
		petal2 = new Petal(xPosition, yPosition, size, cFlower);
		petal3 = new Petal(xPosition, yPosition, size, cFlower);
		petal4 = new Petal(xPosition, yPosition, size, cFlower);
		petal5 = new Petal(xPosition, yPosition, size, cFlower);
	}

	//This method draws the petals using the assigned values. It rotates the objects into the correct positions.
	public void draw(Graphics2D g2d)
	{
		AffineTransform reset = g2d.getTransform();
		petal1.draw(g2d);
		g2d.rotate(Math.toRadians(72), xPosition, yPosition+size*2/3);
		petal2.draw(g2d);
		g2d.rotate(Math.toRadians(72), xPosition, yPosition+size*2/3);
		petal3.draw(g2d);
		g2d.rotate(Math.toRadians(72), xPosition, yPosition+size*2/3);
		petal4.draw(g2d);
		g2d.rotate(Math.toRadians(72), xPosition, yPosition+size*2/3);
		petal5.draw(g2d);
		g2d.setTransform(reset);
	}
	
	//This inner class accepts the coordinates, size, and color of shapes needed to create and draw one sakura petal. 
	//This petal will be used in the class Sakura to form the flower.
	class Petal
	{
		public Petal(double x, double y, double s, Color cf){}

		//This method draws the sakura petal. It makes use of the Path2D.Double class to draw straight and curved paths.
		public void draw(Graphics2D g2d)
		{
			Path2D.Double flower = new Path2D.Double();
			flower.moveTo(xPosition-size/6, yPosition-size/3);
			flower.lineTo(xPosition, yPosition-size/6);
			flower.lineTo(xPosition+size/6, yPosition-size/3);
			flower.curveTo(xPosition+size*2/5, yPosition+size/15, xPosition+size*2/5, yPosition+size*7/15, xPosition, yPosition+size*2/3);
			flower.curveTo(xPosition-size*2/5, yPosition+size*7/15, xPosition-size*2/5, yPosition+size/15, xPosition-size/6, yPosition-size/3);
			g2d.setColor(cFlower);
			g2d.fill(flower);
		}
	}
}