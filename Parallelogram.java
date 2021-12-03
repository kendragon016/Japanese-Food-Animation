/**
	*This class implements the DrawingObject interface and accepts the coordinates, size and color of the shapes needed to draw 2 parallelograms. 
	*The original prallelogram is from inner class OrigParallelogram.
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

public class Parallelogram implements DrawingObject
{
	private double xPosition, yPosition, width, height;
	private Color color;
	private OrigParallelogram mat1, mat2;

	//The constructor instantiates 2 OrigParallelogram objects. The accepted values also represent the color, coordinates, and size of the parallelogram.
	public Parallelogram(double x, double y, double w, double h, Color c)
	{
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		color = c;
		mat1 = new OrigParallelogram(xPosition, yPosition, width, height, color);
		mat2 = new OrigParallelogram(xPosition, yPosition, width, height, color);
	}

	//This method draws the parallelogram using the assigned values. It flips and moves the objects into the correct positions.
	public void draw(Graphics2D g2d)
	{
		mat1.draw(g2d);
		AffineTransform reset = g2d.getTransform();
		g2d.scale(-1, 1); 															//g2d.scale() from https://gist.github.com/eed3si9n/632780
		g2d.translate(-1024, 0);																	
		mat2.draw(g2d);
		g2d.setTransform(reset);
	}

	//This inner class accepts the coordinates, size, and color of shapes needed to create and draw one parallelogram. 
	class OrigParallelogram
	{
		public OrigParallelogram(double x, double y, double w, double h, Color c){}
		
		//This method draws the parallelogram. It makes use of the Path2D.Double class.
		public void draw(Graphics2D g2d)
		{
			Path2D.Double parallelogram = new Path2D.Double();
			parallelogram.moveTo(xPosition, yPosition);
			parallelogram.lineTo(xPosition+width, yPosition);
			parallelogram.lineTo(xPosition+width/2 , yPosition+height);
			parallelogram.lineTo(xPosition-width/2, yPosition+height);
			parallelogram.closePath();
			g2d.setColor(color);
			g2d.fill(parallelogram);
		}
	}
	
}