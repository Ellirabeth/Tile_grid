package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;

public class Boot {
	public Boot() {
		BeginSession();
		
		float width = 50;
		float height = 50;
		float x = 100;
		float y = 100;

		while(!Display.isCloseRequested()){
			glBegin(GL_LINES);
			glVertex2f(10, 10);
			glVertex2f(100, 100);
			glEnd();
			
			glBegin(GL_QUADS);
			glVertex2f(x, y); //Top left corner
			glVertex2f(x + width, y); //Top right corner
			glVertex2f(x + width, y + height); //Bottom right corner
			glVertex2f(x, y + height); //Bottom left corner
			glEnd();

			Display.update();
			Display.sync(60);
		}

		Display.destroy();
	}

	public static void main (String[] arqs){
		new Boot();
	}
}
