import java.util.Scanner;

public class PlayerStats {
	public static void main(String[] args) {
	    //leveling up
	    if(currentEXP == totalEXP){
	        currentEXP = 0.0;
	        LVL++;
	        totalEXP = Math.pow(LVL/0.08, 2);
	        System.out.println("Level up!");
	        System.out.println("You are now level " +LVL);
	        boolean loop = true;
	        while(loop == true){
	            System.out.println("What stat would you like to increase?");
	            System.out.println("====================");
	            System.out.println("DEX\t\t" +DEX+ "\nAC\t\t" +AC+ "\nSTR\t\t" +STR
	                +"\nINT\t\t" +INT);
	            System.out.println("====================");
	            Scanner input = new Scanner(System.in);
	            String response = input.nextLine().toLowerCase();
	            if(response.equals("dex") || response.equals("dexterity")){
	                DEX += 1;
	                loop = false;
	            }else if(response.equals("ac") || response.equals("armour class")){
	                AC += 1;
	                loop = false;
	            }else if(response.equals("str") || response.equals("strength")){
	                STR += 1;
	                loop = false;
	            }else if(response.equals("int") || response.equals("intelligence")){
	                INT += 1;
	                loop = false;
	            }
	        }
	        System.out.println("Your new stats are:\nDEX\t\t" +DEX+ "\nAC\t\t" +AC+ "\nSTR\t\t" +STR
	                +"\nINT\t\t" +INT);
	    }
	}
	//Stats
	public static int DEX;
	public static int HP;
	public static int totalHP;
	public static int AC;
	public static int STR;
	public static int INT;
	//
	
	//Experience
	//level
	public static int LVL = 1;
	//current amount of experience
	public static double currentEXP = 0.0;
	//experience needed to level up
	public static double totalEXP = Math.pow(LVL/0.08, 2);
	
}
