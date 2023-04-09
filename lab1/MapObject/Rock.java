package lab1.MapObject;

public class Rock extends MapObject{
	private int reachable;   //0 unchecked, 1 reachable, 2 unreachable
	public Rock(int xCoor, int yCoor) {
		super(xCoor,  yCoor);
		setReachable(0);
		setCustom('●');
	}
	public int getReachable() {
		return reachable;
	}
	public void setReachable(int reachable) {
		this.reachable = reachable;
	}
}