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
	                dDEX += 1;
	                DEX += 1;
	                loop = false;
	            }else if(response.equals("ac") || response.equals("armour class")){
	                dAC += 1;
	                AC +=1;
	                loop = false;
	            }else if(response.equals("str") || response.equals("strength")){
	                dSTR += 1;
	                STR += 1;
	                loop = false;
	            }else if(response.equals("int") || response.equals("intelligence")){
	                dINT += 1;
	                INT += 1;
	                loop = false;
	            }
	        }
	        System.out.println("Your new stats are:\nDEX\t\t" +DEX+ "\nAC\t\t" +AC+ "\nSTR\t\t" +STR
	                +"\nINT\t\t" +INT);
	    }
	}
	//Default Stats (not modified by equipment. set in firstroom.java)
	public static int dDEX;
	public static int dHP;
	public static int dTotalHP;
	public static int dAC;
	public static int dSTR;
	public static int dINT;
	public static int dMP;
	public static int dTotalMP;
	
	//Stats
	public static int DEX;
	public static int HP;
	public static int totalHP;
	public static int AC;
	public static int STR;
	public static int INT;
	public static int MP;
	public static int totalMP;
	//
	
	//Experience
	//level
	public static int LVL = 1;
	//current amount of experience
	public static double currentEXP = 0.0;
	//experience needed to level up
	public static double totalEXP = Math.pow(LVL/0.08, 2);
	
}
