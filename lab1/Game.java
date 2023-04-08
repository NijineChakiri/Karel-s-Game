package lab1;
import java.util.Scanner;
import lab1.Map.*;
import lab1.MapObject.*;
import lab1.Player.Player;

public class Game{
	public void title(Player player){
		System.out.println("--------------------------------------------------------");
		System.out.printf("|%25s    %-25s|\n", player.getStuName(), player.getStuNum());
		System.out.println("|              Welcome to Karel's world!               |");
		System.out.println("|          ----------------------------------          |");
		System.out.println("|                                                      |");
		System.out.println("|      Please choose a stage or create a new map:      |");
		System.out.println("|                                                      |");
		System.out.println("|          STAGE1   STAGE2   STAGE3   NEWMAP           |");
		System.out.println("|                                                      |");
		System.out.println("|   tips: Remember, You can use 'Q' to quit anywhere   |");
		System.out.println("--------------------------------------------------------");
	}
	
	public Map chooseMap(Scanner scanner) {
		System.out.println("Please choose a stage or create a new map: ");
		String choose = scanner.nextLine();
		switch (choose) {
		    case "STAGE1":
		    	System.out.println("Stage1? I thought you would choose something more challenging.");
		    	return new Stage1();
		    case "STAGE2":
		    	System.out.println("Stage2 is a quite easy one, trust me, just mind the wall...");
		    	return new Stage2();
		    case "STAGE3":
		    	return new Stage3();	    	
		    case "NEWMAP":
		    	System.out.println("Oops, we're still polishing up this feature.");
		    	System.out.println("Wanna give it a shot?");
		    	System.out.println("Start with Stage 1 and Stage 2, they're like warm-up exercises for your brain! ");
		    	return chooseMap(scanner);
		    case "Q":
		    	return null;
		    default:
		    	System.out.println("Looks like you enjoy ordering dishes that aren't on the menu.");
		    	return chooseMap(scanner);
		}
	}
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
	
	public void startGame(){
		Scanner scanner = new Scanner(System.in);
		Player newPlayer = new Player("anonymous", 1234567);
		
		title(newPlayer);
		int ifChange = newPlayer.setInfo(scanner);
		if(ifChange == 1) title(newPlayer);	
		else if(ifChange == -1) finishGame(newPlayer);
		
		Map map = chooseMap(scanner);
		if(map != null){
			Avatar avatar = new Avatar(map.getInitX(), map.getInitY(), map.getInitDirection());
			map.reloadMap(avatar);
			while(avatar.getCommand(scanner, map)){
				map.reloadMap(avatar);
				if(map.getRockList().size() <= 0) {
					win(newPlayer);
				}
				if(avatar.isTrapped()) {
					lose(newPlayer);
				}
			}
			finishGame(newPlayer);
		} else {
			finishGame(newPlayer);
		}
	}
	
	public void finishGame(Player player) {
   	 	System.out.println("Time to go outside and collect some real rocks! See you next time, " + player.getStuName() + '!');
		System.exit(0); 	 
	}
	
	public void win(Player player) {
		System.out.println("You win! Good job, " + player.getStuName() + '!');
		System.exit(0);
	}
	
	public void lose(Player player) {
		System.out.println("You lose! Remember to fix your eyes before playing next time, " + player.getStuName() + '!');
		System.exit(0);
	}
	
	public static void main(String [] args) {
		Game game = new Game();
		game.startGame();		
	}
}
