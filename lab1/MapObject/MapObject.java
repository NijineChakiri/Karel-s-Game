package lab1.MapObject;
import lab1.Map.Map;

public abstract class MapObject{
	private int xCoor, yCoor;
	private char custom;
	
	public void placeObject(Map map) {
		map.getMap()[getxCoor()][getyCoor()] = custom;
	}
	
	public MapObject(int xCoor, int yCoor) {
		setLocation(xCoor, yCoor);
	}
	
	public int getxCoor() {
		return this.xCoor;
	}
	
	public int getyCoor() {
		return this.yCoor;
	}
	
	public void setCustom(char custom) {
		this.custom = custom;
	}
	
	public void setLocation(int xCoor, int yCoor) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;		
	}
	
}