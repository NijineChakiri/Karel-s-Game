package lab1.Command;
import lab1.Map.Map;
import lab1.MapObject.Avatar;

public class Quit extends Command {

	public Quit(Map map, Avatar avatar) {
		super(map, avatar);
	}

	public boolean execute(String[] args) {
        return false;
    }
}