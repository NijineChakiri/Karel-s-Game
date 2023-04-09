package lab1.Command;
import lab1.MapObject.*;
import lab1.Map.*;

public class PickRock extends Command {
	
	public PickRock(Map map, Avatar avatar) {
		super(map, avatar);
	}
	
	public boolean execute(String[] args) {
		avatar.setlastLocation(avatar.getxCoor(), avatar.getyCoor());
		move();
		MapObject pickedRock = null;			
		for (MapObject rock : map.getRockList()) {
		    if (rock.getxCoor() == avatar.getxCoor() && rock.getyCoor() == avatar.getyCoor()) {
		        pickedRock = rock;
		        break;
		    }
		}
		if(pickedRock != null) {
			map.getRockList().remove(pickedRock);
			avatar.setRocksInBag(avatar.getRocksInBag() + 1);
			System.out.println("You have got a rock!");
			System.out.println("Now you have " + avatar.getRocksInBag() + " in your bag.");
		} else {
			System.out.println("Amazing! You managed to put air in your bag!");		
		}
		avatar.setLocation(avatar.getlastX(), avatar.getlastY());
		return true;
	}
}