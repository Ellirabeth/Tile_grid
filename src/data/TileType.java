package data;

public enum TileType {
	
	Grass("grass_64", true), Dirt ("mud_64",false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}

}
