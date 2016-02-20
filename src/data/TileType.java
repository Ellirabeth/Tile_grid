package data;

public enum TileType {
	
	Grass("water3", true), Dirt ("dirt3",false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}

}
