package lab1.Command;
import lab1.Map.*;
import lab1.MapObject.*;

public abstract class Command {
    public abstract boolean execute(String[] args);
    Map map;
    Avatar avatar;
    
    public Command(Map map, Avatar avatar) {
    	this.map = map;
    	this.avatar = avatar;	
    }
    
    public void move() {    	
    	avatar.setLocation(avatar.getxCoor() - converter(1, avatar.getDirection(), "x"), avatar.getyCoor() + converter(1, avatar.getDirection(), "y"));
	}
	
	public void turn(int angel){
		avatar.setDirection(avatar.getDirection() + angel);
		if(avatar.getDirection() >= 360) avatar.setDirection(avatar.getDirection() - 360);
		if(avatar.getDirection() < 0) avatar.setDirection(avatar.getDirection() + 360);
	}
	
	public static int getManhattanDistance(int x1, int x2, int y1, int y2) {
		final int manhattanDistance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		return manhattanDistance;
	}
	
	public int converter(int step, int direction, String axis) {
		double dirRad = Math.toRadians(direction);
		if(axis.equals("x")) {
			return step * (int)(Math.sin(dirRad)); 
		} else if(axis.equals("y")) {
			return step * (int)Math.cos(dirRad); 
		}
		return -1;
	}	
}