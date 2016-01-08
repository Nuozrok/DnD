import java.util.Scanner;
public class PlayerCommands{

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		commands();
	}
	
	
	//Commands
	public static void commands(){
		String command = (input.nextLine().toLowerCase());
		if(command.equals("stats")){
			System.out.println("You have:\n"+PlayerStats.AC +" AC\n"+
					PlayerStats.DEX +" DEX\n"+PlayerStats.totalHP +" total HP\n"+
					PlayerStats.INT +" INT\n"+PlayerStats.STR +" STR\n");
		}
		if(command.equals("hp") || command.equals("health")){
			System.out.println("You have "+PlayerStats.HP+"HP");
		}	
		if(command.equals("mp") || command.equals("mana")){
			System.out.println("You have "+PlayerStats.MP+"MP");	
		}
		if(command.equals("inv") || command.equals("inventory")){
			System.out.println("NOT YET IMPLEMENTED");
		}
	}
	//
}
