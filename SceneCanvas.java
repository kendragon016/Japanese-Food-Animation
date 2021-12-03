/**
	*This class extends the JComponent and contains the values to be passed on to the different objects needed the create the scene. 
	*It also sets up the size of the canvas.
	*
	*@author Kendra Kirsten L. Go (192252)
	*@version 01 April 2020
**/

/*
	I have not discussed the Java language code in my program with anyone other than my instructor or the teaching assistants  assigned to this course.
	
	I have not used Java language code obtained from another student, or any other unauthorized source, either modified or unmodified.
	
	If any Java language code or documentation used in my program was obtained from another source, such as a textbook or website, that has been clearly noted with a proper citation in the comments of my program.

*/
	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class SceneCanvas extends JComponent
{
	private int width, height;
	private Random random;
	private ArrayList<DrawingObject> drawingObjects;
	private Square temp, cover, floor;
	private Sky sky;
	private Tree tree;
	private Sakura sakura1, sakura2, sakura3, sakura4, sakura5, sakura6, sakura7, sakura8, sakura9, sakura10, sakura11, sakura12;
	private SakuraFall sakuraFall;
	private Lantern lantern;
	private Door door;
	private Pillow pillow;
	private Table table;
	private Tray tray;
	private Teapot teapot;
	private Cup cup1, cup2;
	private Circle tea1, tea2;
	private Parallelogram mat;
	private DippingBowl db1, db2;
	private Plate plate1, plate2, plate3;
	private Wasabi wasabi1, wasabi2;
	private Maki maki1, maki2, maki3, maki4, maki5, maki6;
	private Onigiri onigiri1, onigiri2;
	private Nigiri nigiri1, nigiri2, nigiri3, nigiri4, nigiri5, nigiri6;
	private Chopsticks chopsticks;
	private Hashioki hashioki;	

	//The constructor instantiates the arraylist and objects to be used in the scene. All the objects are added to the drawingObjects ArrayList.
	public SceneCanvas (int w, int h)
	{
		random = new Random();
		width = w;
		height = h;
		setPreferredSize(new Dimension(width, height));
		drawingObjects = new ArrayList<DrawingObject>();
		
		sky = new Sky(0, 0, width, 32, new Color(228,233,236), new Color(201,211,223), new Color(158,174,197), new Color(128, 145, 173), new Color(121, 138, 168), new Color(111, 127, 155));
		drawingObjects.add(sky);

		sakuraFall = new SakuraFall(width, height, new Color(255, 199, 213));
		
		temp = new Square(-2, -2, 1, 1, Color.BLACK);
		drawingObjects.add(temp);

		lantern = new Lantern(620, 70, 45, Color.BLACK, new Color(155, 186, 181), new Color(245, 219, 193));
		drawingObjects.add(lantern);

		tree = new Tree(208, 115, 85, new Color(89, 54, 34));
		drawingObjects.add(tree);

		sakura1 = new Sakura(230, 95, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura1);

		sakura2 = new Sakura(250, 165, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura2);

		sakura3 = new Sakura(300, 110, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura3);

		sakura4 = new Sakura(340, 35, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura4);

		sakura5 = new Sakura(420, 10, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura5);

		sakura6 = new Sakura(460, 60, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura6);

		sakura7 = new Sakura(380, 80, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura7);

		sakura8 = new Sakura(570, 20, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura8);

		sakura9 = new Sakura(680, 20, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura9);

		sakura10 = new Sakura(725, 70, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura10);

		sakura11 = new Sakura(795, 50, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura11);

		sakura12 = new Sakura(780, 130, 16, new Color(231, 177, 190));
		drawingObjects.add(sakura12);
		
		floor = new Square(0, 352, width, height, new Color(133, 152, 124));
		drawingObjects.add(floor);
		
		door = new Door(-304, 0, 32, new Color(89, 55, 25), new Color(112, 77, 47), new Color(229, 217, 201));
		drawingObjects.add(door);
		
		pillow = new Pillow(32, 400, 192, new Color(25, 36, 55), new Color(13, 24, 42));
		drawingObjects.add(pillow);

		table = new Table(64, 192, 32, new Color(68, 54, 38), new Color(41, 29, 21));
		drawingObjects.add(table);

		tray = new Tray(288, 224, 192, new Color(61, 14, 10), new Color(34, 2, 0), new Color(89, 32, 27));
		drawingObjects.add(tray);

		teapot = new Teapot(430, 224, 160, new Color(70, 94, 93), new Color(47, 71, 70));
		drawingObjects.add(teapot);

		cup1 = new Cup(352, 320, 64, new Color(70, 94, 93), new Color(47, 71, 70));
		drawingObjects.add(cup1);

		cup2 = new Cup(608, 320, 64, new Color(70, 94, 93), new Color(47, 71, 70));
		drawingObjects.add(cup2);

		mat = new Parallelogram(200, 220, 128, 192, new Color(39, 47, 61));
		drawingObjects.add(mat);

		hashioki = new Hashioki(195, 255, 48, 10, new Color(121, 134, 152), new Color(98, 108, 122), new Color(78, 86, 99));
		drawingObjects.add(hashioki);

		chopsticks = new Chopsticks(210, 395, 8, 160, new Color(216, 170, 120));
		drawingObjects.add(chopsticks);

		db1 = new DippingBowl(220, 310, 64, new Color(121, 134, 152), new Color(98, 108, 122), new Color(41, 22, 2));
		drawingObjects.add(db1);

		db2 = new DippingBowl(730, 300, 64, new Color(121, 134, 152), new Color(98, 108, 122), new Color(41, 22, 2));
		drawingObjects.add(db2);

		plate1 = new Plate(128, 448, 96, new Color(216, 170, 120), new Color(173, 126, 82));
		drawingObjects.add(plate1);

		plate2 = new Plate(400, 448, 96, new Color(216, 170, 120), new Color(173, 126, 82));
		drawingObjects.add(plate2);

		plate3 = new Plate(670, 448, 96, new Color(216, 170, 120), new Color(173, 126, 82));
		drawingObjects.add(plate3);

		cover = new Square(1024, -10, width/2, height+10, new Color(238,238,238));
		drawingObjects.add(cover);

		//33rd ELEMENT IN ARRAYLIST
		maki1 = new Maki(176, 448, 24, new Color(209, 72, 59), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(maki1);

		maki2 = new Maki(224, 448, 24, new Color(209, 72, 59), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(maki2);

		nigiri1 = new Nigiri(445, 453, 50, new Color(242, 116, 5), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(nigiri1);

		nigiri2 = new Nigiri(515, 453, 50, new Color(242, 116, 5), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(nigiri2);

		maki3 = new Maki(272, 448, 24, new Color(209, 72, 59), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(maki3);

		onigiri1 = new Onigiri(555, 410, 100, new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(onigiri1);

		maki4 = new Maki(192, 496, 24, new Color(209, 72, 59), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(maki4);

		nigiri4 = new Nigiri(505, 482, 50, new Color(242, 116, 5), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(nigiri4);

		onigiri2 = new Onigiri(465, 425, 100, new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(onigiri2);

		nigiri3 = new Nigiri(435, 482, 50, new Color(242, 116, 5), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(nigiri3);

		maki5 = new Maki(240, 496, 24, new Color(209, 72, 59), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(maki5);

		wasabi1 = new Wasabi(150, 515, 32, new Color(160, 166, 3));
		drawingObjects.add(wasabi1);

		maki6 = new Maki(288, 496, 24, new Color(209, 72, 59), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(maki6);

		nigiri5 = new Nigiri(425, 510, 50, new Color(242, 116, 5), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(nigiri5);

		nigiri6 = new Nigiri(495, 510, 50, new Color(242, 116, 5), new Color(242, 242, 242), new Color(3, 82, 58));
		drawingObjects.add(nigiri6);	

		wasabi2 = new Wasabi(845, 520, 32, new Color(160, 166, 3));
		drawingObjects.add(wasabi2);

		tea1 = new Circle(357.12, 311.68, 54.4, 25.6, new Color(109,127,65));
		drawingObjects.add(tea1);

		tea2 = new Circle(613.12, 311.68, 54.4, 25.6, new Color(109,127,65));
		drawingObjects.add(tea2);
	}

	//This method draws the objects to be used in the scene. A RenderingHeights objects is also created to add antialiasing.
	@Override
	protected void paintComponent (Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		RenderingHints rh = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);

		for(DrawingObject x : drawingObjects)
		{
			x.draw(g2d);
		}
	}

	//This method returns the object from the Door class.
	public Door getDoor()
	{
		return door;
	}

	//This method returns the drawingObjects ArrayList.
	public ArrayList<DrawingObject> getList()
	{
		return drawingObjects;
	}

	//This method returns the object from the SakuraFall class.
	public SakuraFall getFall()
	{
		return sakuraFall;
	}

	//This method returns the temp object from the Square class.
	public Square getTemp()
	{
		return temp;
	}
}