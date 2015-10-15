import java.util.Scanner;
import java.io.*;

public class Inventory {

	public static void main(String[] args) {
        boolean loop = true;
        while(loop == true){
            Scanner input = new Scanner(System.in);
            System.out.println("====================");
            System.out.println("Check or equip?");
            System.out.println("====================");
            if(input.next().equalsIgnoreCase("check")){
                loop = false;
                checkContent();
            }else if(input.next().equalsIgnoreCase("equip")){
                loop = false;
                equip();
            }
        }
	}
	//items currently in your inventory
	public static void content(){
	    TextIO.write("inventory.txt");
	}
	//Print items in your inventroy and their descriptions 
	public static void checkContent(){
	
	}
	//equip gear in your inventory
	public static void equip(){
	    //types of armor that can be equipped
	    Gear headgear = new Gear();
	    Gear chestpiece = new Gear();
	    Gear bracers = new Gear();
	    Gear gloves = new Gear();
	    Gear ring = new Gear();
	    Gear leggings = new Gear();
	    Gear boots = new Gear();
	    Gear weapon = new Gear();
	 
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
	            //which headgear to equip?
	            System.out.println("");
	            //list headgear available
	            System.out.println();
	            System.out.println("====================");
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
