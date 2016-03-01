package helpers;

import java.awt.Color;
import static org.lwjgl.opengl.GL11.*;

public class Color_RGB {
	
	private static float x,y,z;
/*	glColor3f(0.0, 0.0, 0.0);           black
	glColor3f(1.0, 0.0, 0.0);           red
	glColor3f(0.0, 1.0, 0.0);           green
	glColor3f(0.0, 0.0, 1.0);           blue
	glColor3f(1.0, 1.0, 0.0);           yellow
	glColor3f(1.0, 0.0, 1.0);           magenta
	glColor3f(0.0, 1.0, 1.0);           cyan
	glColor3f(1.0, 1.0, 1.0);           white

	GRAY      : java.awt.Color[r=128, g=128, b=128] //0,5
	LIGHT_GRAY: java.awt.Color[r=192, g=192, b=192] //0,7
	DARK_GRAY : java.awt.Color[r=64,  g=64,  b=64]
	PINK      : java.awt.Color[r=255, g=175, b=175] //0,6
	ORANGE    : java.awt.Color[r=255, g=200, b=0] //0,75
		*/
	
	
	public static void blacks(){
		glColor3f(0.0f, 0.0f, 0.0f);
		return;
	}
	
	public static void red(){
		glColor3f(1.0f, 0.0f, 0.0f);
		return;
	}
	
	public static void green(){
		glColor3f(0.0f, 1.0f, 0.0f);
		return;
	}
	
	public static void yellow(){
		glColor3f(1.0f, 1.0f, 0.0f);
		return;
	}
	
	public static void orange(){
		glColor3f(1.0f, 0.75f, 0.0f);
		return;
	}
	
	public static void blue(){
		glColor3f(0.0f, 0.0f, 1.0f);
		return;
	}
	
	public static void magenta(){
		glColor3f(1.0f, 0.0f, 1.0f);
		return;
	}
	
	public static void pink(){
		glColor3f(1.0f, 0.6f, 0.6f);
		return;
	}
	
	public static void cyan(){
		glColor3f(0.0f, 1.0f, 1.0f);
		return;
	}
	
	public static void white(){
		glColor3f(1.0f, 1.0f, 1.0f);
		return;
	}
	
	public static void grey(){
		glColor3f(0.5f, 0.5f, 0.5f);
		return;
	}
	
	public static void light_grey(){
		glColor3f(0.7f, 0.7f, 0.7f);
		return;
	}
	
	public static void dark_grey(){
		glColor3f(0.25f, 0.25f, 0.25f);
		return;
	}
}
	
