/**
	*This class implements the DrawingObject interface and accepts the coordinates, size and color of the shapes needed to draw 2 tree branches. 
	*The original tree is from inner class OrigTree.
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

public class Tree implements DrawingObject
{
	private double xPosition, yPosition, size;
	private Color cTree, cBranch;
	private OrigTree left, right;
	
	//The constructor instantiates 2 OrigTree objects. The accepted values also represent the color, coordinates, and size of the tree branches.
	public Tree(double x, double y, double s, Color ct)
	{
		xPosition = x;
		yPosition = y;
		size = s;
		cTree = ct;
		left = new OrigTree(xPosition, yPosition, size, cTree);
		right = new OrigTree(xPosition, yPosition, size, cTree);	
	}

	//This method draws the tree branches using the assigned values. It flips and moves the objects into the correct positions.
	public void draw(Graphics2D g2d)
	{
		Path2D.Double branch = new Path2D.Double();
		branch.moveTo(xPosition+size*15/16, yPosition-size*0.25);
		branch.lineTo(xPosition+size*23/16, yPosition-size);
		branch.lineTo(xPosition+size*5/2, yPosition-size*37/32);
		branch.lineTo(xPosition+size*5/2, yPosition-size*35/32);
		branch.lineTo(xPosition+size*3/2, yPosition-size*13/16);
		branch.lineTo(xPosition+size*1.2, yPosition-size*0.25);
		branch.closePath();
		g2d.setColor(cTree);
		g2d.fill(branch);

		left.draw(g2d);
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(-1, 1);
		g2d.translate(-1030, -40);
		right.draw(g2d);		
		g2d.setTransform(reset);	
	}

	//This inner class accepts the coordinates, size, and color of shapes needed to create and draw one tree branch. 
	//It accepts values to be used as the coordinates, color, and size of the tree branch.
	class OrigTree
	{
		public OrigTree(double x, double y, double s, Color ct){}

		//This method draws the tree branch. It makes use of the Path2D.Double class to draw it.
		public void draw(Graphics2D g2d)
		{
			Path2D.Double tree = new Path2D.Double();
			tree.moveTo(xPosition, yPosition);
			tree.lineTo(xPosition+size/4, yPosition-size*3/16);
			tree.lineTo(xPosition+size*3/4, yPosition-size*3/16);
			tree.lineTo(xPosition+size*13/8, yPosition-size*9/16);
			tree.lineTo(xPosition+size*2.4, yPosition-size/2);
			tree.lineTo(xPosition+size*3, yPosition-size*9/16);
			tree.lineTo(xPosition+size*3, yPosition-size/2);
			tree.lineTo(xPosition+size*19/8, yPosition-size*11/32);
			tree.lineTo(xPosition+size*55/32, yPosition-size*5/16);
			tree.lineTo(xPosition+size*21/16, yPosition);
			tree.lineTo(xPosition+size*11/16, yPosition+size*5/32);
			tree.lineTo(xPosition+size/2, yPosition+size*3/4);
			tree.lineTo(xPosition, yPosition+size);
			tree.closePath();
			g2d.setColor(cTree);
			g2d.fill(tree);
		}
	}
}