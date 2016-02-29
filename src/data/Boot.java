package data;

import helpers.Clock;

import java.awt.AlphaComposite;

import javax.print.DocFlavor.INPUT_STREAM;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;
import static helpers.Input.*;
import static helpers.Text.*;

public class Boot {
	public Boot() {
		
		BeginSession();
		//Input_Key();
		int[][] map = {
				{2,1,1,2,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,0,0,2,2,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
				{1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
				{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		};

		
		TileGrid grid = new TileGrid(map);
		grid.SetTile(7, 6, grid.GetTile(3,0).getType()); //duplicate tile
		Enemy e=new Enemy(QuickLoad("ultralisk-attack_3"), grid.GetTile(3, 3), 64.1f, 63.9f, 1);
 		while(!Display.isCloseRequested()){
 			Clock.update();
 			e.Update();
 			
 			grid.Draw();
 			glLoadIdentity();
 			e.Draw();
 			glLoadIdentity();
 			
 			glColor3f(0.0f,0.0f,1.0f); //need off Blend_ALPHA
 			DrawSquad(0, 50, 100, 100);
 			glColor3f(0.0f,1.0f,1.0f); //need off Blend_ALPHA
 			DrawSquad(10, 70, 100, 100);
 			glColor3f(1.0f,0.0f,1.0f); //need off Blend_ALPHA
 			DrawSquad(20, 90, 100, 100);
 			DrawQuadDot(140, 50, 100, 100);
 			
 			drawString("o p q r s t u", 10, 10);
 			

 			Display.update();
 			Display.sync(60);
 		}
 		
		Display.destroy();
		System.exit(0);
		
	}

	public static void main (String[] arqs){
		new Boot();
	}
}
