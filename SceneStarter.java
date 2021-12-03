/**
	*This class contains the main method and instantiates a SceneFrame object. 
	*It calls on the methods that set up the GUI and button, mouse and key listeners for the scene and the corresponding actions. 
	*
	*@author Kendra Kirsten L. Go (192252)
	*@version 01 April 2020
**/

/*
	I have not discussed the Java language code in my program with anyone other than my instructor or the teaching assistants  assigned to this course.
	
	I have not used Java language code obtained from another student, or any other unauthorized source, either modified or unmodified.
	
	If any Java language code or documentation used in my program was obtained from another source, such as a textbook or website, that has been clearly noted with a proper citation in the comments of my program.

*/
	
public class SceneStarter
{
	public static void main(String[] args)
	{
		SceneFrame sceneFrame = new SceneFrame();
		sceneFrame.setUpGUI();
		sceneFrame.setUpKeyListener();
		sceneFrame.setUpMouseListener();
		sceneFrame.setUpButtonListener();
	}
}