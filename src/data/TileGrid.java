package data;

import org.lwjgl.opengl.Drawable;

import static helpers.Artist.*;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glTranslatef;

public class TileGrid {
	public Tile[][] map;
	
	public TileGrid(int[][] newMap){
		
		map = new Tile[11][11];
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
					switch (newMap[j][i]) {
					case 0:
						map[i][j] = new Tile (i * 64f, j * 64f, 63.9f, 64.1f, TileType.Water);
						break;
					case 1:
						map[i][j] = new Tile (i * 64f, j * 64f, 63.9f, 64.1f, TileType.Dirt);
						break;
					case 2:
						map[i][j] = new Tile (i * 64f, j * 64f, 63.9f, 64.1f, TileType.Grass);
					
						
				}
			}
		}
	}
	
	public void SetTile(int xCoord, int yCoord, TileType type){
		map[xCoord][yCoord] = new Tile (xCoord * 64, yCoord*64, 63.9f, 64.1f, type); //size replace tile
	}
	
	public Tile GetTile(int xCoord, int yCoord){
		return map[xCoord][yCoord];
	}
	public void Draw(){
		glColor3f(1.0f,1.0f,1.0f);
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				Tile t = map[i][j];
				
				DrawQuadTex(t.getTexture(), t.getX()-32*i-32*j, t.getY()+32*i-32*j, t.getWidth(), t.getHeight());  //size tile on grid
			}			
		}
		
	
/*		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				Tile t = map[i][j];
				glColor3f(1.0f,0.0f,1.0f);
				DrawQuadDot(  t.getX()-32.1f*i-31.9f*j+WIDHT/2-32, t.getY()+32.1f*i-31.9f*j, t.getWidth(), t.getHeight()); //1 pix Bug
			}			
		}
		
		glColor3f(1.0f,1.0f,1.0f); //need too set null color, when Grid.Draw repeat
*/

	}

}
