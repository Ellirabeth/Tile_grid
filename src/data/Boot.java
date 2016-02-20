package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;

public class Boot {
	public Boot() {
		BeginSession();
		
		Texture t = QuickLoad("grass_64");
		Texture t2 = QuickLoad("mud_64");
 		while(!Display.isCloseRequested()){
 			DrawQuadTex(t, 0, 0, 64, 64);
 			DrawQuadTex(t2, 64, 0, 64, 64);


	 
 			Display.update();
 			Display.sync(60);
 		}
		
	}

	public static void main (String[] arqs){
		new Boot();
	}
}
