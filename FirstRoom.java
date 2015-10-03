import java.util.Scanner;

public class FirstRoom{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        //Description of the room
        System.out.println("");
    
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
        }else if(response.equals("dwarf")){
            RollStats("dwarf");
        }else if(response.equals("halfling")){
            RollStats("halfling");
        }else if(response.equals("elf")){
            RollStats("elf");
        }else if(response.equals("orc")){
            RollStats("orc");
        }
    }
    public static void RollStats(String race){
        boolean loop = true;
		while (loop == true) {
			System.out.println("====================");
			System.out.println("Roll for your dexterity.");
			System.out.println("====================");
			String response = input.nextLine().toLowerCase();    
			if (response.equals("roll")) {
				loop = false;
				System.out.print("You roll: ");
				RNG.Roll(20);
				// if player is a race set dexterity to be this...blah blah blah, else its just the Roll
				// repeat with all stats
			}
        }
    }
}
