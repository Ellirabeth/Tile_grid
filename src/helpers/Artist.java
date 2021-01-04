package helpers;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.*;


import java.io.IOException;
import java.io.InputStream;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.EXTBlendFuncSeparate;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Artist {

	public static final int WIDTH = 1200, HEIGHT = 700;
	
	public static void BeginSession() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("My_Title_game");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		//glPushMatrix();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear The Screen And The Depth Buffer
		EXTBlendFuncSeparate.glBlendFuncSeparateEXT
        (
                    GL_SRC_ALPHA,
                    GL_ONE_MINUS_SRC_ALPHA,
                    GL_ONE,
                    GL_ONE_MINUS_SRC_ALPHA
        );

		glLoadIdentity();
	}
	
	public static  void DrawSquad(float x, float y, float width, float height){
		glBegin(GL_QUADS);
	
			glVertex2f(x, y); //Top left corner
			glVertex2f(x + width, y); //Top right corner
			glVertex2f(x + width, y + height); //Bottom right corner
			glVertex2f(x, y + height); //Bottom left corner
		glEnd();
		glLoadIdentity();
	}
	
	public static void DrawSquad_2x5D(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
		//glLineWidth (20);
		//glBegin(GL_LINE_LOOP);
		glVertex2f(x, y); //Top left corner
																//glColor3f(0.0f,0.0f,1.0f); //blue color
		glVertex2f(x + width/2, y+height/2); //Top right corner
																//glColor3f(0.0f,1.0f,0.0f); //green color
		glVertex2f(x , y + height); //Bottom right corner
																//glColor3f(1.0f,0.0f,0.0f); //blue red
		glVertex2f(x-width/2, y + height/2); //Bottom left corner
		
		glEnd();
		glLoadIdentity();
	}
	
	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height){
		tex.bind();
		glPolygonMode(GL_FRONT_AND_BACK,GL_FILL);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA); //setup alpha
		glEnable(GL_BLEND); // Turn alpha
			glTranslatef(x, y, 0); //set layer 0
				glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex2f(0 + WIDTH /2-17, 0+7); //Top left corner
				
				glTexCoord2f(1,0); //Bottom left corner
				glVertex2f(0 - width/2 + WIDTH /2-17, 0 + height/2+7);
				
				glTexCoord2f(1,1); //Bottom right corner
				glVertex2f(0 + WIDTH /2-17, 0 + height+7);
				
				glTexCoord2f(0, 1); //Top right corner
				glVertex2f(0 + width/2 + WIDTH /2-17, 0 + height/2+7);
				glEnd();
		glDisable(GL_BLEND); // Off alpha
		glLoadIdentity();
		
	}
	
	public static void DrawQuadDot(float x, float y, float width, float height){
		glPointSize(5);
		glBegin(GL_POINTS);
		glColor3d(1,0,0);
			glClear(GL_DEPTH_BUFFER_BIT);
			
			glVertex2f(x, y); //Top left corner
			glVertex2f(x + width, y); //Top right corner
			glVertex2f(x + width, y + height); //Bottom right corner
			glVertex2f(x, y + height); //Bottom left corner
			
		glEnd();
		glLoadIdentity();
	}
	
	public static Texture LoadTexture(String path, String fileType){
		Texture tex=null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tex;
		
	}
	
	public static Texture QuickLoad(String name){
		Texture tex=null;
		tex = LoadTexture("res/" + name + ".png", "PNG");
		return tex;
	}
}

