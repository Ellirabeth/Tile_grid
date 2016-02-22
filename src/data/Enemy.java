package data;

import java.util.Map;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
public class Enemy {
	private int  health;
	private float speed, x, y,width, height;
	private Texture texture;
	private Tile startTile;
	
	public Enemy(Texture texture,Tile startTile, float heigth, float widht, int speed){
		this.texture = texture;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = widht;
		this.height = heigth;
		this.health = health;
		this.speed = speed;
	}
	
	public void Draw () {
		DrawQuadTex(texture, x-x/2-y/2, y+x/2-y/2, width, height);
	}
}
