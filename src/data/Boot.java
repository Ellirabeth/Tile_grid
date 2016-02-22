package data;

import javax.print.DocFlavor.INPUT_STREAM;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;
import static helpers.Input.*;

public class Boot {
	public Boot() {
		
		BeginSession();
		//Input_Key();
		int[][] map = {
				{1,1,1,2,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,0,0,2,2,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
				{1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
				{1,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		};

		
		TileGrid grid = new TileGrid(map);
		grid.SetTile(7, 6, grid.GetTile(3,0).getType()); //duplicate tile
 		while(!Display.isCloseRequested()){
 			
 			grid.Draw();
 			
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
