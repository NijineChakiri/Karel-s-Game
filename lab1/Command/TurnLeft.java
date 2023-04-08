package lab1.Command;
import lab1.Map.Map;
import lab1.MapObject.Avatar;

public class TurnLeft extends Command {
    public TurnLeft(Map map, Avatar avatar) {
    	super(map, avatar);
	}

	public boolean execute(String[] args) {
    	turn(90);
        return true;
    }
}