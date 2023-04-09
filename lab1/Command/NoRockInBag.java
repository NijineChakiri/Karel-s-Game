package lab1.Command;
import lab1.Map.Map;
import lab1.MapObject.Avatar;

public class NoRockInBag extends Command{
	public NoRockInBag(Map map, Avatar avatar) {
		super(map, avatar);
	}
	
	public boolean execute(String[] args) {
		if(avatar.getRocksInBag() > 0)
			System.out.println("false");
		else 
			System.out.println("true");
		return true;
	}
}