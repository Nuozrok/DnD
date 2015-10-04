import java.util.Scanner;

public class FirstRoom{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
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
			    	    PlayerStats.DEX = RNG.num + 2;
			    	}else if(race.equals("elf")){
			    	    PlayerStats.DEX = RNG.num - 2;
			    	}else{
			    	    PlayerStats.DEX = RNG.num;
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
		    		    PlayerStats.AC = RNG.num + 2;
		    		}else if(race.equals("orc")){
		    		    PlayerStats.AC = RNG.num - 2;
		    		}else{
		    		    PlayerStats.AC = RNG.num;
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
		    		    PlayerStats.STR = RNG.num + 4;
		    		}else if(race.equals("halfling")){
		    		    PlayerStats.STR = RNG.num - 2;
		    		}else{
		    		    PlayerStats.STR = RNG.num;
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
			    	    PlayerStats.INT = RNG.num + 2;
			    	}else if(race.equals("dwarf") || race.equals("orc")){
			    	    PlayerStats.INT = RNG.num - 2;
			    	}else{
			    	    PlayerStats.INT = RNG.num;
			    	}
			    }
			}
        }
        //Sets minimum value of all stats to 0
	    if(PlayerStats.DEX < 0){
	        PlayerStats.DEX = 0;
	    }
	    if(PlayerStats.AC < 0){
	        PlayerStats.AC = 0;
	    }
	    if(PlayerStats.STR < 0){
	        PlayerStats.STR = 0;
	    }
	    if(PlayerStats.INT < 0){
	        PlayerStats.INT = 0;
	    }
        System.out.println("You are a(n) " +race+ " with " +PlayerStats.DEX+ " dexterity, " +PlayerStats.AC
            + " armour class, " +PlayerStats.STR+ " strength, " +PlayerStats.INT+ " intelligence, " 
            + PlayerStats.totalHP+ " total health.");
    }
}
