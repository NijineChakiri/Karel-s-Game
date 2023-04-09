package lab1.Command;
import lab1.MapObject.*;
import lab1.Map.*;

public class Move extends Command {
	public Move(Map map, Avatar avatar) {
		super(map, avatar);
	}
	
    public boolean execute(String[] args) {
    	avatar.setlastLocation(avatar.getxCoor(), avatar.getyCoor());
        if (args != null && args.length > 0) {
        	try {
				   int step = Integer.parseInt(args[0]);
				   for(int i = 0;i < step;i++) {
					   try {
						   move();
						   if(map.getMap()[avatar.getxCoor()][avatar.getyCoor()] == '⊙') {
							   System.out.println("You got trapped!");
							   avatar.setIsTrapped(true);
							   break;
						   } else if(!map.getWalkableTiles().contains(map.getMap()[avatar.getxCoor()][avatar.getyCoor()])) {
							   System.out.println("That was a hard hit, haha!");
							   avatar.setLocation(avatar.getlastX(), avatar.getlastY());
							   break;
						   }
					   }catch(java.lang.ArrayIndexOutOfBoundsException ex) {
							System.out.println("Where do you fancy heading?");
							avatar.setLocation(avatar.getlastX(), avatar.getlastY());
							break;
					   }					   
				   }					   
				} catch(NumberFormatException ex) {
				   System.out.println("I'm getting strong 'put a number in it' vibes from those parentheses.");
				}
        } else {
        	final String [] step = {"1"};
        	execute(step);
        }
        return true;
    }
}