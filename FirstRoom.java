import java.util.Scanner;

public class FirstRoom{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        PlayerStats.main(null);
        //Description of the room
        System.out.println("");
    
        boolean loop = true; 
        while(loop == true){  
            System.out.println("====================");
            System.out.println("But who are you?");
            System.out.println("What is your race?");
            System.out.println("Human\t\tNo bonus, no penalty\t\tA boring people with " 
                +"nothing much to gain or lose\nDwarf\t\t+2AC, -2INT\t\t\tSkillful armoursmiths "
                +"lacking rational thinking\nHalfling\t+2DEX, -2STR\t\t\tA small people with "
                +"big hearts and tiny fists\nElf\t\t+2INT, -2DEX\t\t\tNoblemen and scholars with "
                +"fragile bodies\nOrc\t\t+4STR, -2INT, -2AC\t\tBrute barbarians equipped with unkempt gear");
            System.out.println("====================");
        
            String response = input.nextLine().toLowerCase();    
            
            if(response.equals("human")){
                RollStats("human");
                loop = false;
            }else if(response.equals("dwarf")){
                RollStats("dwarf");
                loop = false;
            }else if(response.equals("halfling")){
                RollStats("halfling");
                loop = false;
            }else if(response.equals("elf")){
                RollStats("elf");
                loop = false;
            }else if(response.equals("orc")){
                RollStats("orc");
                loop = false;
            }
        }
        //temporary connection from first room to a fight
        EnemyEncounter.main(null);
    }    
    public static void RollStats(String race){
        boolean loop = true;
		while (loop == true) {
			boolean loop2 = true;
			while (loop2 == true){
		    	System.out.println("====================");
			    System.out.println("Roll for your dexterity.");
		    	System.out.println("====================");
		    	String response1 = input.nextLine().toLowerCase();    
			    if (response1.equals("roll")) {
			    	loop = false;
			    	loop2 = false;
			    	System.out.print("You roll: ");
			    	RNG.Roll(4);
			    	if (race.equals("halfling")){
			    	    PlayerStats.dDEX = RNG.num + 2;
			    	}else if(race.equals("elf")){
			    	    PlayerStats.dDEX = RNG.num - 2;
			    	}else{
			    	    PlayerStats.dDEX = RNG.num;
			    	}
			    }
			}    
			loop2 = true;
			while (loop2 == true){
			    System.out.println("====================");
			    System.out.println("Roll for your armour class.");
			    System.out.println("====================");
			    String response2 = input.nextLine().toLowerCase();    
			    if (response2.equals("roll")) {
		    		loop = false;
		    		loop2 = false;
		    		System.out.print("You roll: ");
		    		RNG.Roll(4);
		    		if (race.equals("dwarf")){
		    		    PlayerStats.dAC = RNG.num + 2;
		    		}else if(race.equals("orc")){
		    		    PlayerStats.dAC = RNG.num - 2;
		    		}else{
		    		    PlayerStats.dAC = RNG.num;
		    		}
		    	}
			}
			loop2 = true;
			while (loop2 == true){
		    	System.out.println("====================");
		    	System.out.println("Roll for your strength.");
		    	System.out.println("====================");
		    	String response3 = input.nextLine().toLowerCase();    
		    	if (response3.equals("roll")) {
		    		loop = false;
		    		loop2 = false;
		    		System.out.print("You roll: ");
		    		RNG.Roll(4);
		    		if (race.equals("orc")){
		    		    PlayerStats.dSTR = RNG.num + 4;
		    		}else if(race.equals("halfling")){
		    		    PlayerStats.dSTR = RNG.num - 2;
		    		}else{
		    		    PlayerStats.dSTR = RNG.num;
			    	}
			    }
			}
			loop2 = true;
			while (loop2 == true){
			    System.out.println("====================");
			    System.out.println("Roll for your intelligence.");
			    System.out.println("====================");
			    String response4 = input.nextLine().toLowerCase();    
			    if (response4.equals("roll")) {
			    	loop = false;
			    	loop2 = false;
			    	System.out.print("You roll: ");
			    	RNG.Roll(4);
			    	if (race.equals("elf")){
			    	    PlayerStats.dINT = RNG.num + 2;
			    	}else if(race.equals("dwarf") || race.equals("orc")){
			    	    PlayerStats.dINT = RNG.num - 2;
			    	}else{
			    	    PlayerStats.dINT = RNG.num;
			    	}
			    }
			}
        }
        //Sets minimum value of all stats to 0
	    if(PlayerStats.dDEX < 0){
	        PlayerStats.dDEX = 0;
	    }
	    if(PlayerStats.dAC < 0){
	        PlayerStats.dAC = 0;
	    }
	    if(PlayerStats.dSTR < 0){
	        PlayerStats.dSTR = 0;
	    }
	    if(PlayerStats.dINT < 0){
	        PlayerStats.dINT = 0;
	    }
	    
	    //Set HP & MP
	    PlayerStats.dHP = 20 + PlayerStats.dDEX;
	    PlayerStats.dMP = 20 + PlayerStats.dINT;
	    PlayerStats.dTotalMP = PlayerStats.dMP;
	    PlayerStats.dTotalHP = PlayerStats.dHP;
        System.out.println("You are a(n) " +race+ " with " +PlayerStats.dDEX+ " dexterity, " +PlayerStats.dAC
            + " armour class, " +PlayerStats.dSTR+ " strength, " +PlayerStats.dINT+ " intelligence, " 
            + PlayerStats.dTotalHP+ " total health, and " +PlayerStats.dTotalMP+ " total mana.");
        
        //Set starting stats to default stats   
        PlayerStats.DEX = PlayerStats.dDEX;
	    PlayerStats.HP = PlayerStats.dHP;
	    PlayerStats.totalHP = PlayerStats.dTotalHP;
    	PlayerStats.AC = PlayerStats.dAC;
	    PlayerStats.STR = PlayerStats.dSTR;
    	PlayerStats.INT = PlayerStats.dINT;
    	PlayerStats.MP = PlayerStats.dMP;
    	PlayerStats.totalMP = PlayerStats.dTotalMP;
    }
}
