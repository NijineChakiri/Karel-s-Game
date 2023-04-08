package lab1.MapObject;

public class Wall extends MapObject{
	
	public Wall(int xCoor, int yCoor) {
		super(xCoor,  yCoor);
		setCustom('■');
	}
}