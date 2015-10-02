import java.util.Scanner;
public class PlayerCommands{

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Commands();
	}
	
	
	//Commands
	public static void Commands(){
		String command = (input.nextLine().toLowerCase());
		if(command.equals("stats")){
			System.out.println("You have:\n"+PlayerStats.AC +" armor class\n"+
					PlayerStats.DEX +" dexterity\n"+PlayerStats.totalHP +" total hit points\n"+
					PlayerStats.INT +" intelligence\n"+PlayerStats.STR +" strength\n");
		}
		if(command.equals("hp") || command.equals("health")){
			System.out.println("You have "+PlayerStats.HP+"HP");
		}
		if(command.equals("inv") || command.equals("inventory")){
			System.out.println("NOT YET IMPLEMENTED");
		}
	}
	//
}
