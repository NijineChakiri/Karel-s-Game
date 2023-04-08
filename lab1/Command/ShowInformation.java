package lab1.Command;
import lab1.Map.Map;
import lab1.MapObject.*;


public class ShowInformation extends Command{
	private int minDistance;
	private MapObject nearestRock;
	
	public ShowInformation(Map map, Avatar avatar) {
		super(map, avatar);
	}
	
	public boolean execute(String[] args) {
		if(map.getRockList().size() == 1)
			System.out.println("There is 1 rock on the map that you need to collect.");
		else 
			System.out.println("There are " + map.getRockList().size() + " rocks on the map that you need to collect.");
		
		
		if(avatar.getRocksInBag() == 0)
			System.out.println("You have no rock in your bag.");
		else if(avatar.getRocksInBag() == 1)
			System.out.println("You have 1 rock in your bag.");
		else
			System.out.println("You have " + avatar.getRocksInBag() + " rocks in your bag.");
		
		nearestRock = map.getRockList().get(0);
		minDistance = getManhattanDistance(avatar.getxCoor(), nearestRock.getxCoor(), avatar.getyCoor(), nearestRock.getyCoor());
		for (MapObject rock : map.getRockList()) {
		    if(minDistance > getManhattanDistance(avatar.getxCoor(), rock.getxCoor(), avatar.getyCoor(), rock.getyCoor())) {
		    	nearestRock = rock;
		    	minDistance = getManhattanDistance(avatar.getxCoor(), nearestRock.getxCoor(), avatar.getyCoor(), nearestRock.getyCoor());
		    } 
		}
		
		if(minDistance == 1)
			System.out.println("You are 1 step away from the nearest rock.");
		else 
			System.out.println("You are " + minDistance + " steps away from the nearest rock.");
				
		return true;
	}
}