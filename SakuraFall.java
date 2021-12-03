/**
	*This class implements the DrawingObject interface and accepts the coordinates, size and color needed to draw the Sakura objects. 
	*These will be populated in an array of Sakura flowers.
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

public class SakuraFall implements DrawingObject
{
	private int width, height;
	private Random random;
	private Color cFlower;
	private Sakura[] flowers;
	
	//The constructor instantiates the Sakura array which will consist of 150 elements. 
	//It accepts the values to be used as the coordinates and color of the sakura flowers.
	public SakuraFall(int w, int h, Color cf)
	{
		random = new Random();
		width = w;
		height = h;
		cFlower = cf;
		flowers = new Sakura[150];
	}

	//This method draws 150 sakura flowers. These will be populated inside the Sakura array.
	public void draw(Graphics2D g2d)
	{
		for (int i = 0; i<flowers.length; i++)
		{
			// random().nextInt() from https://stackoverflow.com/questions/2444019/how-do-i-generate-a-random-integer-between-min-and-max-in-java
			flowers[i] = new Sakura(random.nextInt(width), random.nextInt(height), random.nextInt(13)+4, cFlower);
			flowers[i].draw(g2d);
		}
	}
}