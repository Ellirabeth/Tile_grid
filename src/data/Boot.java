package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Boot {
	public Boot() {
		Display.setTitle("My_Title_game");
		try {
			Display.setDisplayMode(new DisplayMode(600, 600));
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main (String[] arqs){
		new Boot();
	}
}
