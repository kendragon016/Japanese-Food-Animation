/**
	*This program sets up the GUI and its size. It also sets up the button, key, and mouse listeners for the animation of the scene. 
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
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;

public class SceneFrame
{
	private JFrame frame;
	private JButton eat, refill;
	private JLabel mouse, key;
	private SceneCanvas sceneCanvas;
	private JPanel buttonsPanel;
	private ArrayList<DrawingObject> items, wasabi;
	private boolean running;
	private Timer animateTimer;

	//The constructor instantiates the JFrame, JPanel with JButtons and the 2 ArrayLists. It also instantiates the SceneCanvas along with its width and height.
	public SceneFrame()
	{
		running = false;
		frame = new JFrame();
		eat = new JButton("EAT");
		refill = new JButton("REFILL");
		mouse = new JLabel("Click anywhere to animate cherry blossoms", SwingConstants.CENTER);			
		key = new JLabel("Press C key to close doors, O to open", SwingConstants.CENTER);				
		//SwingConstants.CENTER from https://stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel

		sceneCanvas = new SceneCanvas(1024, 768);
		buttonsPanel = new JPanel();
		items = new ArrayList<DrawingObject>();
		wasabi = new ArrayList<DrawingObject>();
	}

	//This method sets up the GUI and its contents. The program is set to end when the window is closed.
	public void setUpGUI()
	{
		Container cp = frame.getContentPane();
		frame.setTitle("Project 1 - Go, Kendra Kirsten - 192252");
		cp.add(sceneCanvas, BorderLayout.CENTER);
		cp.add(buttonsPanel,BorderLayout.SOUTH);
		buttonsPanel.setLayout(new GridLayout (1, 4));
		buttonsPanel.add(key);
		buttonsPanel.add(eat);
		buttonsPanel.add(refill);
		buttonsPanel.add(mouse);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); 
		frame.setVisible(true);
	}

	//This method declares and instantiates a MouseListenerTetser object. The MouseListener is also added to the SceneCanvas object. 
	public void setUpMouseListener()
	{
		MouseListenerTester ml = new MouseListenerTester();
		sceneCanvas.addMouseListener(ml);
	}

	//This class implements MouseListener. It sets up the methods that call on actions to be done when the mouse is clicked.
	private class MouseListenerTester implements MouseListener
	{													         //MouseListener from https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html 
		@Override 
		public void mousePressed(MouseEvent e){}
   		@Override
   		public void mouseReleased(MouseEvent e){}
    	@Override
    	public void mouseEntered(MouseEvent e){}
   		@Override 
   		public void mouseExited(MouseEvent e) {}
   		
   		//This method creates and starts a new Timer when the mouse is clicked. If a timer is already running, it cancels the timer. 
   		//The temp object in the ArrayList drawingObjects of the SceneCanvas is replaced with the sakuraFall object.
   		@Override 
		public void mouseClicked(MouseEvent e)
		{
			if(!running){
				running = true;
				sceneCanvas.getList().set(1, sceneCanvas.getFall());
				animateTimer = new Timer();
				animateTimer.scheduleAtFixedRate(new ScheduleTask(), 0, 500);
			}else{
				animateTimer.cancel();
				running = false;
				sceneCanvas.getList().set(1, sceneCanvas.getTemp());
				sceneCanvas.repaint();
			}
		}

		//This class calls on the actions to be done once the Timer starts. The actions are repeated until the timer is cancelled
		class ScheduleTask extends TimerTask
		{
			//While the timer is running, this method repeatedly repaints the scene. 
			//This causes the sakura flowers to constantly chnge positions as if they were moving in the wind.
			@Override
			public void run()
			{
				sceneCanvas.repaint();				
			}
		}

	}

	//This method declares and instantiates a KeyListenertester object. The KeyListener is also added and set to focus on the SceneCanvas object.
	public void setUpKeyListener()                                        								
	{
		KeyListenerTester kl = new KeyListenerTester();
		sceneCanvas.addKeyListener(kl);
		sceneCanvas.setFocusable(true);                     //setFocusable() and requestFocusInWindow() 
		sceneCanvas.requestFocusInWindow();					//from https://stackoverflow.com/questions/8482268/java-keylistener-not-called
	}		

	//This class implements KeyListener. It sets up the methods that call on actions to be done when a certain key is pressed.
	private class KeyListenerTester implements KeyListener  //KeyListeners from https://stackoverflow.com/questions/10876491/how-to-use-keylistener
	{
		boolean open = false;
		boolean error = true;
		int counter = 0;
		Timer doorTimer;                      			 //utility timer from http://zetcode.com/tutorials/javagamestutorial/animation/

		@Override  									 
		public void keyTyped(KeyEvent ke){}
		@Override
		public void keyReleased(KeyEvent ke){}	
		
		//This method contains the actions to be done when a key is pressed. It creates and starts a new timer when the O or C key is pressed.
		@Override
		public void keyPressed(KeyEvent ke)										
		{
			if(ke.getKeyCode() == KeyEvent.VK_O){
				if (running)
				{
					sceneCanvas.getList().set(1, sceneCanvas.getTemp());
					sceneCanvas.repaint();
					running = false;
					animateTimer.cancel();
				}
				sceneCanvas.setEnabled(false); 					//setEnabled() from https://stackoverflow.com/questions/9851403/disable-keylistener-in-java
				open = true;
				doorTimer = new Timer();
				doorTimer.scheduleAtFixedRate(new ScheduleTask(), 0, 80);			
			}else if(ke.getKeyCode() == KeyEvent.VK_C){
				if (running)
				{
					sceneCanvas.getList().set(1, sceneCanvas.getTemp());
					sceneCanvas.repaint();
					running = false;
					animateTimer.cancel();
				}
				sceneCanvas.setEnabled(false);
				open = false;
				doorTimer = new Timer();
				doorTimer.scheduleAtFixedRate(new ScheduleTask(), 0, 80);
			}				
		}

		//This class calls on the actions to be done once the Timer starts. The actions are repeated until the timer is cancelled
		class ScheduleTask extends TimerTask
		{
			//This method calls on actions that are done on objects of the Door class. It repeatedly moves the door to close or open it when the C or O key is pressed, respectively.
			@Override
			public void run()
			{
				if(open && !error){
					sceneCanvas.getDoor().left(16);
					sceneCanvas.repaint();	
					counter++;
					if(counter>18){
						doorTimer.cancel();
						doorTimer = new Timer();
						counter = 0;
						open = false;
						error = true;
						sceneCanvas.setEnabled(true);
					}
				}else if(!open && error){
					sceneCanvas.getDoor().right(16);
					sceneCanvas.repaint();
					counter++;
					if(counter>18){
						doorTimer.cancel();
						doorTimer = new Timer();
						counter = 0;
						open = true;
						error = false;
						sceneCanvas.setEnabled(true);
					}
				}else{
					doorTimer.cancel();
					doorTimer = new Timer();
					sceneCanvas.setEnabled(true);
				}
			}
		}
		
	}

	//This method declares and instantiates a ButtonListener object. The ButtonListener is also added to the refill and eat buttons. 
	//Focusable is set to false to avoid conflict with the KeyListener.
	public void setUpButtonListener()
	{
		ButtonListener bl = new ButtonListener();
		refill.addActionListener(bl);
		eat.addActionListener(bl);
		refill.setFocusable(false);
		eat.setFocusable(false);
	}
	
	//This class implements ActionListener. It sets up the methods that call on actions to be done when a certain button is clicked.
	private class ButtonListener implements	ActionListener
	{
		int f = 33;
		int s = 34;
		int counter = 1;
		boolean food = true;
		Timer foodTimer = new Timer();

		//This method calls on the actions to be done when the eat or refill button is clicked. It starts a new timer after each click. 
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Object o = e.getSource();
		
			if (o == eat) {
				if (running)
				{
					sceneCanvas.getList().set(1, sceneCanvas.getTemp());
					sceneCanvas.repaint();
					running = false;
					animateTimer.cancel();
				}
				foodTimer.scheduleAtFixedRate(new ScheduleTask(), 200, 800);
				food = true;    
			}else if(o == refill){
				if (running)
				{
					sceneCanvas.getList().set(1, sceneCanvas.getTemp());
					sceneCanvas.repaint();
					running = false;
					animateTimer.cancel();
				}
				foodTimer.scheduleAtFixedRate(new ScheduleTask(), 200, 800);  
				food = false;	
			}				
		}

		//This class calls on the actions to be done once the Timer starts. The actions are repeated until the timer is cancelled
		class ScheduleTask extends TimerTask 
		{
			//This method makes the food and dirnks objects repeatedly disappear (removed from the drawingObjects ArrayList) in pairs when the eat button 
			//is clicked. Everything is redrawn (added back to the drawingObjects ArrayList) when the refill button is clicked.
			@Override
			public void run()
			{
				if(food){
					if (f<sceneCanvas.getList().size()){   					 //clear(), size() and remove() 
						items.add(sceneCanvas.getList().get(s));			//from https://www.w3schools.com/java/java_arraylist.asp
						items.add(sceneCanvas.getList().get(f));
						sceneCanvas.getList().remove(s);
						sceneCanvas.getList().remove(f);
						sceneCanvas.repaint();	
					}else{
						foodTimer.cancel();
						foodTimer = new Timer();
					}
					
				}else if(!food){
					if(counter == 1){
						for (DrawingObject x : items)
						{
							if (Circle.class.isAssignableFrom(x.getClass())) 		  //Class.class.isAssignableFrom(Obj.getClass() from
							{													     //https://stackoverflow.com/questions/541749/how-to-determine-an-objects-class
								sceneCanvas.getList().add(x);					  	 
							}
						}
						sceneCanvas.repaint();
						counter++;

					}else if(counter == 2){
						for (DrawingObject x : items)
						{
							if (Maki.class.isAssignableFrom(x.getClass()))
							{
								sceneCanvas.getList().add(x);
							}
						}

						for (DrawingObject x : items)
						{
							if (Wasabi.class.isAssignableFrom(x.getClass()))
							{
								wasabi.add(x);
							}
						}
						
						sceneCanvas.getList().add(wasabi.get(0));
						sceneCanvas.repaint();
						counter++;
					}else if (counter == 3){
						for (DrawingObject x : items)
						{
							if (Onigiri.class.isAssignableFrom(x.getClass()))
							{
								sceneCanvas.getList().add(x);
							}
						}

						sceneCanvas.repaint();
						counter++;
					}else if(counter == 4){
						for (DrawingObject x : items)
						{
							if (Nigiri.class.isAssignableFrom(x.getClass()))
							{
								sceneCanvas.getList().add(x);
							}
						}
						sceneCanvas.getList().add(wasabi.get(1));
						sceneCanvas.repaint();
						counter++;
					}else{
						counter = 1;
						items.clear();
						wasabi.clear();
						foodTimer.cancel();
						foodTimer = new Timer();
					}
					
				}
				
			}
		}
	}			
}