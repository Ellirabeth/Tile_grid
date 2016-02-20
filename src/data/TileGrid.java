package data;

import org.lwjgl.opengl.Drawable;

import static helpers.Artist.*;

public class TileGrid {
	public Tile[][] map;
	
	public TileGrid(){
		map = new Tile [20][15];
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				map[i][j] = new Tile (i * 64, j * 64, 64, 64, TileType.Grass);
			}
		}
	}

	public TileGrid(int[][] newMap){
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				if ( newMap[j][i] == 0)
					 map[i][j] = new Tile (i * 64, j * 64, 64, 64, TileType.Grass);
				else  
					map[i][j] = new Tile (i * 64, j * 64, 64, 64, TileType.Dirt);
			}
		}
	}
	
	public void Draw(){
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
	}

}
