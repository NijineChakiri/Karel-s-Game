package lab1.Command;
import lab1.Map.Map;
import lab1.MapObject.Avatar;

public class TurnRight extends Command {
    public TurnRight(Map map, Avatar avatar) {
    	super(map, avatar);
	}

	public boolean execute(String[] args) {
    	turn(-90);
        return true;
    }
}