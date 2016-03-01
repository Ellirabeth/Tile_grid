package data;

import java.awt.AlphaComposite;
import java.util.Map;

import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;
import static helpers.Clock.*;

public class Enemy {
	private int  health;
	private float speed, x, y,width, height;
	private Texture texture;
	private Tile startTile;
	private boolean first = true;
	
	public Enemy(Texture texture,Tile startTile, float heigth, float widht, float speed){
		this.texture = texture;
		this.startTile = startTile; 
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = widht;
		this.height = heigth;
		this.speed = speed;
	}
	
	public void Update() {
		if (first)
			first = false;
		else
			x += Delta() * speed;
	}
	
	public void Draw () {
		DrawQuadTex(texture, x-x/2-y/2, y+x/2-y/2, width, height);
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	

}
