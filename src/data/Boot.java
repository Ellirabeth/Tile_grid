package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;

public class Boot {
	public Boot() {
		BeginSession();
 
 		while(!Display.isCloseRequested()){


 			DrawSquad(50, 50, 100, 100);
 			DrawSquad(150, 150, 100, 100);
	 
 			Display.update();
 			Display.sync(60);
 		}
		
	}

	public static void main (String[] arqs){
		new Boot();
	}
}
