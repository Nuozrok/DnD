import java.util.Scanner;
import java.io.*;

public class Inventory {

	public static void main(String[] args) {
        Gear.main(null);
        content();
        boolean loop = true;
        while(loop == true){
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
	}
	//items currently in your inventory
	public static void content(){
	    TextIO.writeFile("Inventory.txt");
	    //TextIO.put("test");
	}
	//Print items in your inventroy and their descriptions 
	public static void checkContent(){
	    System.out.println("You have:");
	    TextIO.readFile("Inventory.txt");
	    String inv = TextIO.getln();
	    TextIO.writeStandardOutput();
	    TextIO.putln(inv);
	}
	//equip gear in your inventory
	public static void equip(){
	    Scanner input = new Scanner(System.in);
	    System.out.println("====================");
	    System.out.println("What would you like to equip?");
	    System.out.println("headgear\nchestpiece\nbracers\ngloves\nring\nleggings\nboots\nweapon");
	    System.out.println("====================");
	    String response = input.next();
	    boolean loop = true;
	    while(loop = true){
	        if(response.equalsIgnoreCase("headgear")){
	            System.out.println("====================");
	            System.out.println("Which headgear would you like to equip?");
	            //if item is headgear and in your inventory, then list it as a choice
	            //print choices
	            System.out.println();
	            System.out.println("====================");
	            //if choice was x, then equip x and print that x was equipped
	            System.out.println("back");
	        }else if(response.equalsIgnoreCase("chestpiece")){
	        
	        }else if(response.equalsIgnoreCase("bracers")){

	        }else if(response.equalsIgnoreCase("gloves")){

	        }else if(response.equalsIgnoreCase("ring")){

    	    }else if(response.equalsIgnoreCase("leggings")){

	        }else if(response.equalsIgnoreCase("boots")){
	        
	        }else if(response.equalsIgnoreCase("weapon")){
	        
	        }         
	    }
	}
}
