package data;

import java.util.ArrayList;

import static helpers.Clock.*;
import data.Tile.*;

public class Wave {
	
	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	
	public Wave(float spawnTime, Enemy enemyType) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		timeSinceLastSpawn=0;
		enemyList = new ArrayList<Enemy>();
	}
	
	public void update() {
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {
			Spawn();
			timeSinceLastSpawn = 0;
		}
		
		for (Enemy e: enemyList){
			e.Update(); 
			e.Draw();
		}
	}
	
	private void Spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), 64, 64, enemyType.getSpeed()));
	}

}
