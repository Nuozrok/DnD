import java.util.Scanner;
import java.io.*;

public class Inventory{
	public static void main(String[] args) {
	    Equipped();
	    //creates array of objects in inventory
        boolean loop = true;
        while(loop == true){
            Gear.main(null);
            Scanner input = new Scanner(System.in);
            System.out.println("====================");
            System.out.println("Check or equip?");
            System.out.println("====================");
            String response = input.next(); 
            if(response.equalsIgnoreCase("check")){
                loop = false;
                checkContent();
            }else if(response.equalsIgnoreCase("equip")){
                loop = false;
                equip();
            }
        }
        Equipped();
	}
	//Inventory
    public static Gear inv[] = Gear.items();
    public static void content(){
        inv[0] = Gear.headgear0;
        inv[1] = Gear.chestpiece0;
        inv[2] = Gear.bracers0;
    }
	//Print items in your inventroy and their descriptions 
	public static void checkContent(){
	    String buffer;
	    System.out.println("You have:");
        int counter = 0;
        for (int i = 0; i < inv.length; i ++){
            if (inv[i] != null){
                System.out.println(inv[counter].name);
                counter++;
            }
        }
	}
	//equip gear in your inventory
	public static void equip(){
	    boolean loop = true;
	    while(loop == true){
	        Scanner input = new Scanner(System.in);
	        System.out.println("====================");
	        System.out.println("What type of gear would you like to equip?");
	        System.out.println("headgear\nchestpiece\nbracers\ngloves\nring\nleggings\nboots\nweapon");
	        System.out.println("====================");
	        System.out.println("back");
	        String response = input.next();
	        if(response.equalsIgnoreCase("headgear")){
	            loop  = false;
	            System.out.println("====================");
	            System.out.println("Which headgear would you like to equip?");
	            //list headgear currently in inventory, their stats, and what is currently equipped
                
	            System.out.println("====================");
	            
                TextIO.readStandardInput();
	            //if choice was x, then equip x and print that x was equipped
	        }else if(response.equalsIgnoreCase("chestpiece")){
	        
	        }else if(response.equalsIgnoreCase("bracers")){

	        }else if(response.equalsIgnoreCase("gloves")){

	        }else if(response.equalsIgnoreCase("ring")){

    	    }else if(response.equalsIgnoreCase("leggings")){

	        }else if(response.equalsIgnoreCase("boots")){
	        
	        }else if(response.equalsIgnoreCase("weapon")){
	        
	        }else if(response.equalsIgnoreCase("back")){
	            loop = false;
	            break;
	        }         
	    }
	}

    
    //indicates what gear is currently equipped, and applies appropriate stat modifications
    //will be called when items are being equipped in Inventory.java
    public static void Equipped(){
        Equipment.headgear = Gear.items(null).headgear0;
        Equipment.chestpiece = Gear.items(null).chestpiece0;
        Equipment.bracers = Gear.items(null).bracers0;
    }
}
