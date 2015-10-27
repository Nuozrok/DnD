import java.util.Scanner;
import java.io.*;

public class Inventory{
	public static void main(String[] args) {
	    content();
	    Equipped();
	    //creates array of objects in inventory
        boolean loop = true;
        while(loop == true){
            Gear.main(null);
            Scanner input = new Scanner(System.in);
            System.out.println("====================");
            System.out.println("Check, equip, or return?");
            System.out.println("====================");
            String response = input.next(); 
            if(response.equalsIgnoreCase("check")){
                loop = false;
                checkContent();
            }else if(response.equalsIgnoreCase("equip")){
                loop = false;
                equip();
            }else if(response.equalsIgnoreCase("return")){
                return;
            }
        }
        Equipped();
        Inventory.main(null);
	}
	//Inventory
    public static Gear[] inv = new Gear[10];
    public static void content(){
        //for testing purposes
        //to be later put in via Loot.java
        inv[0] = Gear.headgear0;
        inv[1] = Gear.chestpiece0;
        inv[2] = Gear.bracers0;
    }
	//Print items in your inventroy and their descriptions 
	public static void checkContent(){
	    String buffer;
	    System.out.println("You have:");
        for (int i = 0; i < inv.length; i ++){
            if (inv[i] != null){
                System.out.println(inv[i].name);
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
	            System.out.println("====================");
	            //list said gear type currently in inventory, their stats, and what is currently equipped
                System.out.println("Item name:\t"
                +"Stat modifiers:\t\t\t"
                +"Equipped?");
                for (int i = 0; i < inv.length; i ++){
                    if (inv[i] != null && inv[i].type == "headgear"){
                       //print name and tab
                       System.out.print(inv[i].name +"\t");
                       //if there is a mod 1, print it and tab
                       if(inv[i].mod1 != 0){
                           System.out.print("+"+inv[i].mod1+" "+inv[i].mod1Stat+"\t");
                           //if no more mods, then tab
                           if(inv[i].mod2 == 0){
                               System.out.print("\t\t\t");
                           }
                       //if no mods at all, then tab
                       }else{
                           System.out.print("\t\t\t");
                       }
                       //if there is a mod 2, print it and tab
                       if(inv[i].mod2 != 0){
                           System.out.print("+"+inv[i].mod2+" "+inv[i].mod2Stat+"\t");
                           //if no more mods, then tab
                           if(inv[i].mod3 == 0){
                               System.out.print("\t");
                           }
                       }
                       //if there is a mod 3, print and tab
                       if(inv[i].mod3 != 0){
                           System.out.print("+"+inv[i].mod2+" "+inv[i].mod2Stat+"\t");
                           //if no more mods, then tab
                           if(inv[i].mod3 == 0){
                               System.out.print("\t");
                           }
                       }
                       //print if it is equippped
                       if(Equipment.headgear == inv[i]){
                           System.out.println("yes");
                       }else{
                           System.out.println("no");
                       }
                    }
                }
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
        Equipment.headgear = Gear.headgear0;
        Equipment.chestpiece = Gear.chestpiece0;
        Equipment.bracers = Gear.bracers0;
    }
}
