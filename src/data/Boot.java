package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

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

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 600, 400, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		while(!Display.isCloseRequested()){


			Display.update();
			Display.sync(60);
		}

		Display.destroy();
	}

	public static void main (String[] arqs){
		new Boot();
	}
}
