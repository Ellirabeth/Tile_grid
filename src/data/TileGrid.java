package data;

import org.lwjgl.opengl.Drawable;

import static helpers.Artist.*;

public class TileGrid {
	public Tile[][] map;
	
	public TileGrid(){
		map = new Tile [20][15];
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				map[i][j] = new Tile (i * 65, j * 65, 65, 65, TileType.Grass);
			}
		}
	}

	public TileGrid(int[][] newMap){
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				if ( newMap[j][i] == 0)
					 map[i][j] = new Tile (i * 63.9f, (float) (j * 64), 63.9f, 64.1f, TileType.Grass);
				else  
					map[i][j] = new Tile (i * 63.9f, (float) (j * 64), 63.9f, 64.1f, TileType.Dirt);
			}
		}
	}
	
	public void Draw(){
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX()-32*i-32*j, t.getY()+32*i-32*j, t.getWidth(), t.getHeight());
			}			
		}
	}

}
