package lab1.MapObject;
import java.util.Scanner;
import lab1.Command.*;
import lab1.Map.*;

public class Avatar extends MapObject{
	private int direction;
	private int lastX, lastY;
	private int rocksInBag;
	private boolean isTrapped;
	
	public Avatar(int xCoor, int yCoor, int direction){
		super(xCoor, yCoor);
		setDirection(direction);
		this.rocksInBag = 0;
		this.isTrapped = false;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
		switch(getDirection()){
			case 0:
				setCustom('►');
				break;
			case 90:
				setCustom('▲');
				break;
			case 180:
				setCustom('◄');
				break;
			case 270:
				setCustom('▼');
				break;
			default:
				setCustom('?');
				break;
		}
	}
	
	public int getlastX() {
		return this.lastX;
	}
	
	public int getlastY() {
		return this.lastY;
	}
	
	public boolean isTrapped() {
		return isTrapped;
	}

	public void setIsTrapped(boolean istrapped) {
		this.isTrapped = istrapped;
	}

	public int getRocksInBag() {
		return this.rocksInBag;
	}
	
	public void setlastLocation(int lastX, int lastY) {
		this.lastX = lastX;
		this.lastY = lastY;
	}
	
	public void setRocksInBag(int rocksInBag) {
		this.rocksInBag = rocksInBag;
	}	
	
	public boolean getCommand(Scanner scanner, Map map){
		System.out.println("Please enter a command: ");
		String command = scanner.nextLine();
		
		if(command.equals("Q")) return false;
		if(!command.substring(command.length() - 1, command.length()).equals(")")) {
			System.out.println("You're asking for something that doesn't exist.");
			System.out.println("Maybe you should read the user manual first.");	  
			return true;
		}
		
		command = command.trim().replaceAll("\\s*\\(\\s*","(").replaceAll("\\s*\\)\\s*", ")").substring(0, command.length() - 1);
		String [] cmdParts = command.split("\\(");
		String cmdName = cmdParts[0];
		String cmdArgs[] = cmdParts.length > 1 ? cmdParts[1].split(",") : null;
		
		try {
		    String cmdClassName = cmdName.substring(0, 1).toUpperCase() + cmdName.substring(1);
		    Class<?> cls = Class.forName("lab1.Command." + cmdClassName);
		    Command cmd = (Command) cls.getDeclaredConstructor(Map.class, Avatar.class).newInstance(map, this);
		    return cmd.execute(cmdArgs);		    
		} catch (Exception ex) {
			System.out.println("You're asking for something that doesn't exist.");
			System.out.println("Maybe you should read the user manual first.");	    
		    return true;
		}	
	}
}