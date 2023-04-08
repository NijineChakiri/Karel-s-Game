package lab1.Player;
import java.util.Scanner;

public class Player{
	private String stuName;
	private int stuNum;
	private boolean ifChange;
	
	public Player(String stuName, int stuNum) {
		this.stuName = stuName;
		this.stuNum = stuNum;
		this.ifChange = false;
	}
	
	public String getStuName() {
		return this.stuName;
	}
	
	public int getStuNum() {
		return this.stuNum;
	}
	
	public boolean getIfChange() {
		return this.ifChange;
	}
	
	public int setInfo(Scanner scanner) {			
		System.out.println("Would you like to change your personal information? (Y/N)");			
		while(true){
			String choose = scanner.nextLine();
			switch(choose) {
				case "N":
					System.out.println("Do you seriously not remember who you are?!");
					System.out.println("Fine, looks like we've got another mystery person on our hands.");
					return 0;
				case "Y":
					System.out.println("Please enter your name: ");
					this.stuName = scanner.nextLine();
					while(true){
						System.out.println("Please enter your student number: ");
						try {
						   this.stuNum = Integer.parseInt(scanner.nextLine());
						   this.ifChange = true;
						   return 1;
						} catch(NumberFormatException ex) {
						   System.out.println("I'm pretty sure that wasn't a number.");
						}
					}
				case "Q":
					return -1;
				default:
					System.out.println("Just type Y or N, Y for Yes and N for No. Got it?");				
			}
		}
	}
}