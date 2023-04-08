package lab1.MapObject;

public class Trap extends MapObject{
	private boolean isFilled;
	
	public Trap(int xCoor, int yCoor) {
		super(xCoor,  yCoor);
		this.isFilled = false;
		setCustom('⊙');
	}
	
	public boolean isFilled() {
		return isFilled;
	}
	public void setIsFilled(boolean isFilled) {
		this.isFilled = isFilled;
		setTrap();
	}
	public void setTrap() {
		if(isFilled) setCustom('×');
		else setCustom('⊙');
	}
	
}