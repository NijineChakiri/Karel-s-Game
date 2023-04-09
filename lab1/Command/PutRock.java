package lab1.Command;
import lab1.MapObject.*;
import lab1.Map.*;

public class PutRock extends Command {
	
	public PutRock(Map map, Avatar avatar) {
		super(map, avatar);
	}
	
	public boolean execute(String[] args) {
		avatar.setlastLocation(avatar.getxCoor(), avatar.getyCoor());
		if(avatar.getRocksInBag() > 0){
			move();	
			MapObject filledTrap = null;
			for (MapObject trap : map.getTrapList()) {
			    if (trap.getxCoor() == avatar.getxCoor() && trap.getyCoor() == avatar.getyCoor()) {
			    	filledTrap = trap;
			        break;
			    }
			}
			if(filledTrap != null) {
				if(!((Trap) filledTrap).isFilled()){
					((Trap) filledTrap).setIsFilled(true);
					avatar.setRocksInBag(avatar.getRocksInBag() - 1);
					System.out.println("You have put down a rock, now you can walk through the filled trap!");
					System.out.println("Now you have " + avatar.getRocksInBag() + " in your bag.");	
				} else {
					System.out.println("The trap has already been filled!");
				}				
			} else {
				System.out.println("Rocks are designed to fill traps, not for fun!");			
			}
			avatar.setLocation(avatar.getlastX(), avatar.getlastY());
		} else {
			System.out.println("You should pick a rock first!");
		}
		return true;
	}
}