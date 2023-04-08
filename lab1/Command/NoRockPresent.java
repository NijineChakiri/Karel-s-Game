package lab1.Command;
import lab1.MapObject.*;
import lab1.Map.*;

public class NoRockPresent extends Command {
	
	public NoRockPresent(Map map, Avatar avatar) {
		super(map, avatar);
	}
	
	public boolean execute(String[] args) {
		avatar.setlastLocation(avatar.getxCoor(), avatar.getyCoor());
		move();			
		for (MapObject rock : map.getRockList()) {
		    if (rock.getxCoor() == avatar.getxCoor() && rock.getyCoor() == avatar.getyCoor()) {
		    	System.out.println("false");
		    	avatar.setLocation(avatar.getlastX(), avatar.getlastY());
		        return true;
		    }
		}
		System.out.println("true");
		avatar.setLocation(avatar.getlastX(), avatar.getlastY());
		return true;
	}
}