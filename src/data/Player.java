package data;

import helpers.Color_RGB;

import org.lwjgl.input.Mouse;

import static helpers.Artist.*;
import static helpers.Color_RGB.*;
import static data.TileGrid.*;

public class Player {

	private TileGrid grid;
	private Color_RGB setColor= new Color_RGB();
	
	public Player(TileGrid grid) {
		this.grid = grid;
	}
	
	public void setTile() {
			int GrilleX = 583;	//Alert
			int GrilleY = 692;  //Alert
			float ISO_HEIGHT_HALF = 5.5f;
			float ISO_WIDTH_HALF = 5.5f;
			float RealX = Mouse.getX() - GrilleX ;
		float RealY = Mouse.getY() - GrilleY ;
		float GrilleU = (float)(-1 - (Math.floor((RealX * ISO_HEIGHT_HALF + RealY * ISO_WIDTH_HALF) / (2 * ISO_HEIGHT_HALF * ISO_WIDTH_HALF) / 5.8)));
        float GrilleV = (float)(-1 - (Math.floor((-RealX * ISO_HEIGHT_HALF + RealY * ISO_WIDTH_HALF) / (2 * ISO_HEIGHT_HALF * ISO_WIDTH_HALF) / 5.8)));
		//grid.SetTile(7, 6, grid.GetTile(3,0).getType()); //duplicate tile
		float tempy=GrilleU;
		float tempx=GrilleV;
		if ((tempx>=0)&&(tempy>=0)&&((tempx<TileSizeX)&&(tempy<TileSizeY))) {
			grid.SetTile((int)(tempx),(int)(tempy), TileType.Grass);
		}
		
		//setColor.grey();
		
	}


	 
}
