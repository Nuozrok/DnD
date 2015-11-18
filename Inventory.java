import java.util.Scanner;
import java.io.*;

public class Inventory{
	public static void main(String[] args) {
	    content();
	    //creates array of objects in inventory
        boolean loop = true;
        while(loop == true){
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
                unApplyStats();
                applyStats();
            }else if(response.equalsIgnoreCase("return")){
                loop = false;
                return;
            }
        }
        Inventory.main(null);
	}
	//Inventory
    public static Gear[] inv = new Gear[10];
    public static void content(){
        //for testing purposes
        //to be later put in via Loot.java
        //inv[0] = Gear.headgear0;
        //inv[1] = Gear.chestpiece0;
        //inv[2] = Gear.bracers0;
    }
    
	//Print items in your inventroy and their descriptions 
	public static void checkContent(){
	    String buffer;
	    System.out.println("You have:");
        if(inv[0] == null){
            System.out.println("Nothing!");
        }else{
            System.out.println("Item name:\t"
            +"Stat modifiers:\t\t\t"
            +"Equipped?");
        }
        for (int i = 0; i < inv.length; i ++){
            if (inv[i] != null){
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
	}
	//equip gear in your inventory
	public static void equip(){
	    boolean loop1 = true;
	    while(loop1 == true){
	        Scanner input = new Scanner(System.in);
	        System.out.println("====================");
	        System.out.println("What type of gear would you like to equip?");
	        System.out.println("headgear\nchestpiece\nbracers\ngloves\nring\nleggings\nboots\nweapon");
	        System.out.println("====================");
	        System.out.println("back");
	        String response = input.nextLine();
	        if(response.equalsIgnoreCase("headgear")){
	            loop1 = false;
                boolean loop2 = true;
                while(loop2 == true){
                    for(int i = 0; i < inv.length; i ++){
                        if(inv[i] != null && inv[i].type == "headgear" && inv[i].lvlReq <= PlayerStats.LVL){
                            System.out.println("====================");
	                        System.out.println("Which headgear would you like to equip?");
	                        System.out.println("====================");
                            //list said gear type currently in inventory, their stats, and what is currently equipped
                            System.out.println("Item name:\t"
                            +"Stat modifiers:\t\t\t"
                            +"Equipped?");
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
                            //if choice was x, then equip x and print that x was equipped
                            response = input.nextLine();
                            if(response.equalsIgnoreCase(inv[i].name) && inv[i].type == "headgear"){
                                loop2 = false;
                                //if gear is being swapped
                                if(Equipment.headgear != null){
                                    Gear[] buffer = new Gear[1];
                                    buffer[0] = Equipment.headgear;
                                    Equipment.headgear = inv[i];
                                    inv[i] = buffer[0];
                                    buffer[0] = null;
                                //if gear is just being equipped to an empty slot    
                                }else{
                                    Equipment.headgear = inv[i];
                                    inv[i] = null;
                                }    
                                System.out.println(Equipment.headgear.name + " was equipped");
                                return;
                            }else{
                                break;
                            }
                        }else if(i == (inv.length-1)){
                            loop2 = false;
                        }
                    }
                }
                loop2 = false;
                System.out.println("Nothing to equip!");
                return;
	        }else if(response.equalsIgnoreCase("chestpiece")){
	            loop1 = false;
                boolean loop2 = true;
                while(loop2 == true){
                    for(int i = 0; i < inv.length; i ++){
                        if(inv[i] != null && inv[i].type == "chestpiece" && inv[i].lvlReq <= PlayerStats.LVL){
                            System.out.println("====================");
	                        System.out.println("Which chestpiece would you like to equip?");
	                        System.out.println("====================");
                            //list said gear type currently in inventory, their stats, and what is currently equipped
                            System.out.println("Item name:\t"
                            +"Stat modifiers:\t\t\t"
                            +"Equipped?");
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
                            if(Equipment.chestpiece == inv[i]){
                               System.out.println("yes");
                            }else{
                                System.out.println("no");
                            }
                            //if choice was x, then equip x and print that x was equipped
                            response = input.nextLine();
                            if(response.equalsIgnoreCase(inv[i].name) && inv[i].type == "chestpiece"){
                                loop2 = false;
                                //if gear is being swapped
                                if(Equipment.chestpiece != null){
                                    Gear[] buffer = new Gear[1];
                                    buffer[0] = Equipment.chestpiece;
                                    Equipment.chestpiece = inv[i];
                                    inv[i] = buffer[0];
                                    buffer[0] = null;
                                //if gear is just being equipped to an empty slot    
                                }else{
                                    Equipment.chestpiece = inv[i];
                                    inv[i] = null;
                                }
                                System.out.println(Equipment.chestpiece.name + " was equipped");
                                return;
                            }else{
                                break;
                            }
                        }else if(i == (inv.length-1)){
                            loop2 = false;
                        }
                    }
                }
                loop2 = false;
                System.out.println("Nothing to equip!");
                return;
	        }else if(response.equalsIgnoreCase("bracers")){
                loop1 = false;
                boolean loop2 = true;
                while(loop2 == true){
                    for(int i = 0; i < inv.length; i ++){
                        if(inv[i] != null && inv[i].type == "bracers" && inv[i].lvlReq <= PlayerStats.LVL){
                            System.out.println("====================");
	                        System.out.println("Which bracers would you like to equip?");
	                        System.out.println("====================");
                            //list said gear type currently in inventory, their stats, and what is currently equipped
                            System.out.println("Item name:\t"
                            +"Stat modifiers:\t\t\t"
                            +"Equipped?");
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
                            if(Equipment.bracers == inv[i]){
                               System.out.println("yes");
                            }else{
                                System.out.println("no");
                            }
                            //if choice was x, then equip x and print that x was equipped
                            response = input.nextLine();
                            if(response.equalsIgnoreCase(inv[i].name) && inv[i].type == "bracers"){
                                loop2 = false;
                                //if gear is being swapped
                                if(Equipment.bracers != null){
                                    Gear[] buffer = new Gear[1];
                                    buffer[0] = Equipment.bracers;
                                    Equipment.bracers = inv[i];
                                    inv[i] = buffer[0];
                                    buffer[0] = null;
                                //if gear is just being equipped to an empty slot    
                                }else{
                                    Equipment.bracers = inv[i];
                                    inv[i] = null;
                                }
                                System.out.println(Equipment.bracers.name + " was equipped");
                                return;
                            }else{
                                break;
                            }
                        }else if(i == (inv.length-1)){
                            loop2 = false;
                        }
                    }
                }
                loop2 = false;
                System.out.println("Nothing to equip!");
                return;    
	        }else if(response.equalsIgnoreCase("gloves")){
                loop1 = false;
                boolean loop2 = true;
                while(loop2 == true){
                    for(int i = 0; i < inv.length; i ++){
                        if(inv[i] != null && inv[i].type == "gloves" && inv[i].lvlReq <= PlayerStats.LVL){
                            System.out.println("====================");
	                        System.out.println("Which gloves would you like to equip?");
	                        System.out.println("====================");
                            //list said gear type currently in inventory, their stats, and what is currently equipped
                            System.out.println("Item name:\t"
                            +"Stat modifiers:\t\t\t"
                            +"Equipped?");
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
                            if(Equipment.gloves == inv[i]){
                               System.out.println("yes");
                            }else{
                                System.out.println("no");
                            }
                            //if choice was x, then equip x and print that x was equipped
                            response = input.nextLine();
                            if(response.equalsIgnoreCase(inv[i].name) && inv[i].type == "gloves"){
                                loop2 = false;
                                //if gear is being swapped
                                if(Equipment.gloves != null){
                                    Gear[] buffer = new Gear[1];
                                    buffer[0] = Equipment.gloves;
                                    Equipment.gloves = inv[i];
                                    inv[i] = buffer[0];
                                    buffer[0] = null;
                                //if gear is just being equipped to an empty slot    
                                }else{
                                    Equipment.gloves = inv[i];
                                    inv[i] = null;
                                }
                                System.out.println(Equipment.gloves.name + " was equipped");
                                return;
                            }else{
                                break;
                            }
                        }else if(i == (inv.length-1)){
                            loop2 = false;
                        }
                    }
                }
                loop2 = false;
                System.out.println("Nothing to equip!");
                return;
	        }else if(response.equalsIgnoreCase("ring")){
                loop1 = false;
                boolean loop2 = true;
                while(loop2 == true){
                    for(int i = 0; i < inv.length; i ++){
                        if(inv[i] != null && inv[i].type == "ring" && inv[i].lvlReq <= PlayerStats.LVL){
                            System.out.println("====================");
	                        System.out.println("Which ring would you like to equip?");
	                        System.out.println("====================");
                            //list said gear type currently in inventory, their stats, and what is currently equipped
                            System.out.println("Item name:\t"
                            +"Stat modifiers:\t\t\t"
                            +"Equipped?");
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
                            if(Equipment.ring == inv[i]){
                               System.out.println("yes");
                            }else{
                                System.out.println("no");
                            }
                            //if choice was x, then equip x and print that x was equipped
                            response = input.nextLine();
                            if(response.equalsIgnoreCase(inv[i].name) && inv[i].type == "ring"){
                                loop2 = false;
                                //if gear is being swapped
                                if(Equipment.ring != null){
                                    Gear[] buffer = new Gear[1];
                                    buffer[0] = Equipment.ring;
                                    Equipment.ring = inv[i];
                                    inv[i] = buffer[0];
                                    buffer[0] = null;
                                //if gear is just being equipped to an empty slot    
                                }else{
                                    Equipment.ring = inv[i];
                                    inv[i] = null;
                                }
                                System.out.println(Equipment.ring.name + " was equipped");
                                return;
                            }else{
                                break;
                            }
                        }else if(i == (inv.length-1)){
                            loop2 = false;
                        }
                    }
                }
                loop2 = false;
                System.out.println("Nothing to equip!");
                return; 
    	    }else if(response.equalsIgnoreCase("leggings")){
                loop1 = false;
                boolean loop2 = true;
                while(loop2 == true){
                    for(int i = 0; i < inv.length; i ++){
                        if(inv[i] != null && inv[i].type == "leggings" && inv[i].lvlReq <= PlayerStats.LVL){
                            System.out.println("====================");
	                        System.out.println("Which leggings would you like to equip?");
	                        System.out.println("====================");
                            //list said gear type currently in inventory, their stats, and what is currently equipped
                            System.out.println("Item name:\t"
                            +"Stat modifiers:\t\t\t"
                            +"Equipped?");
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
                            if(Equipment.leggings == inv[i]){
                               System.out.println("yes");
                            }else{
                                System.out.println("no");
                            }
                            //if choice was x, then equip x and print that x was equipped
                            response = input.nextLine();
                            if(response.equalsIgnoreCase(inv[i].name) && inv[i].type == "leggings"){
                                loop2 = false;
                                //if gear is being swapped
                                if(Equipment.leggings != null){
                                    Gear[] buffer = new Gear[1];
                                    buffer[0] = Equipment.leggings;
                                    Equipment.leggings = inv[i];
                                    inv[i] = buffer[0];
                                    buffer[0] = null;
                                //if gear is just being equipped to an empty slot    
                                }else{
                                    Equipment.leggings = inv[i];
                                    inv[i] = null;
                                }
                                System.out.println(Equipment.leggings.name + " was equipped");
                                return;
                            }else{
                                break;
                            }
                        }else if(i == (inv.length-1)){
                            loop2 = false;
                        }
                    }
                }
                loop2 = false;
                System.out.println("Nothing to equip!");
                return;
	        }else if(response.equalsIgnoreCase("boots")){
	            loop1 = false;
                boolean loop2 = true;
                while(loop2 == true){
                    for(int i = 0; i < inv.length; i ++){
                        if(inv[i] != null && inv[i].type == "boots" && inv[i].lvlReq <= PlayerStats.LVL){
                            System.out.println("====================");
	                        System.out.println("Which boots would you like to equip?");
	                        System.out.println("====================");
                            //list said gear type currently in inventory, their stats, and what is currently equipped
                            System.out.println("Item name:\t"
                            +"Stat modifiers:\t\t\t"
                            +"Equipped?");
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
                            if(Equipment.boots == inv[i]){
                               System.out.println("yes");
                            }else{
                                System.out.println("no");
                            }
                            //if choice was x, then equip x and print that x was equipped
                            response = input.nextLine();
                            if(response.equalsIgnoreCase(inv[i].name) && inv[i].type == "boots"){
                                loop2 = false;
                                //if gear is being swapped
                                if(Equipment.boots != null){
                                    Gear[] buffer = new Gear[1];
                                    buffer[0] = Equipment.boots;
                                    Equipment.boots = inv[i];
                                    inv[i] = buffer[0];
                                    buffer[0] = null;
                                //if gear is just being equipped to an empty slot    
                                }else{
                                    Equipment.boots = inv[i];
                                    inv[i] = null;
                                }
                                System.out.println(Equipment.boots.name + " was equipped");
                                return;
                            }else{
                                break;
                            }
                        }else if(i == (inv.length-1)){
                            loop2 = false;
                        }
                    }
                }
                loop2 = false;
                System.out.println("Nothing to equip!");
                return;
	        }else if(response.equalsIgnoreCase("weapon")){
	            loop1 = false;
                boolean loop2 = true;
                while(loop2 == true){
                    for(int i = 0; i < inv.length; i ++){
                        if(inv[i] != null && inv[i].type == "weapon" && inv[i].lvlReq <= PlayerStats.LVL){
                            System.out.println("====================");
	                        System.out.println("Which weapon would you like to equip?");
	                        System.out.println("====================");
                            //list said gear type currently in inventory, their stats, and what is currently equipped
                            System.out.println("Item name:\t"
                            +"Stat modifiers:\t\t\t"
                            +"Equipped?");
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
                            if(Equipment.weapon == inv[i]){
                               System.out.println("yes");
                            }else{
                                System.out.println("no");
                            }
                            //if choice was x, then equip x and print that x was equipped
                            response = input.nextLine();
                            if(response.equalsIgnoreCase(inv[i].name) && inv[i].type == "weapon"){
                                loop2 = false;
                                //if gear is being swapped
                                if(Equipment.weapon != null){
                                    Gear[] buffer = new Gear[1];
                                    buffer[0] = Equipment.weapon;
                                    Equipment.weapon = inv[i];
                                    inv[i] = buffer[0];
                                    buffer[0] = null;
                                //if gear is just being equipped to an empty slot    
                                }else{
                                    Equipment.weapon = inv[i];
                                    inv[i] = null;
                                }
                                System.out.println(Equipment.weapon.name + " was equipped");
                                return;
                            }else{
                                break;
                            }
                        }else if(i == (inv.length-1)){
                            loop2 = false;
                        }
                    }
                }
                loop2 = false;
                System.out.println("Nothing to equip!");
                return;
	        }else if(response.equalsIgnoreCase("back")){
	            loop1 = false;
	            return;
	        }         
	    }
	}
	//reset stats from unequiping old gear
	public static void unApplyStats(){
	    PlayerStats.DEX = PlayerStats.dDEX;
	    PlayerStats.HP = PlayerStats.dHP;
	    PlayerStats.totalHP = PlayerStats.dTotalHP;
    	PlayerStats.AC = PlayerStats.dAC;
	    PlayerStats.STR = PlayerStats.dSTR;
    	PlayerStats.INT = PlayerStats.dINT;
    	PlayerStats.MP = PlayerStats.dMP;
    	PlayerStats.totalMP = PlayerStats.dTotalMP;
	}
	
	//apply stats to player when gear is Equipped
	public static void applyStats(){
	    //if something is equipped
	    //headgear
	    if(Equipment.headgear != null){
	       //check each modification and apply it to the appropriate stat
	       if(!Equipment.headgear.mod1Stat.equalsIgnoreCase("null")){
	           if(Equipment.headgear.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.headgear.mod1;
	           }
	           if(Equipment.headgear.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.headgear.mod1;
	           }
	           if(Equipment.headgear.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.headgear.mod1;
	           }
	           if(Equipment.headgear.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.headgear.mod1;
	           }
	       }
	       if(!Equipment.headgear.mod2Stat.equalsIgnoreCase("null")){
	           if(Equipment.headgear.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.headgear.mod2;
	           }
	           if(Equipment.headgear.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.headgear.mod2;
	           }
	           if(Equipment.headgear.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.headgear.mod2;
	           }
	           if(Equipment.headgear.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.headgear.mod2;
	           }
	       }
	       if(!Equipment.headgear.mod3Stat.equalsIgnoreCase("null")){
	           if(Equipment.headgear.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.headgear.mod3;
	           }
	           if(Equipment.headgear.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.headgear.mod3;
	           }
	           if(Equipment.headgear.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.headgear.mod3;
	           }
	           if(Equipment.headgear.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.headgear.mod3;
	           }
	       }
	    }
	    //chestpiece
	    if(Equipment.chestpiece != null){
	       //check each modification and apply it to the appropriate stat
	       if(!Equipment.chestpiece.mod1Stat.equalsIgnoreCase("null")){
	           if(Equipment.chestpiece.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.chestpiece.mod1;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.chestpiece.mod1;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.chestpiece.mod1;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.chestpiece.mod1;
	           }
	       }
	       if(!Equipment.chestpiece.mod2Stat.equalsIgnoreCase("null")){
	           if(Equipment.chestpiece.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.chestpiece.mod2;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.chestpiece.mod2;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.chestpiece.mod2;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.chestpiece.mod2;
	           }
	       }
	       if(!Equipment.chestpiece.mod3Stat.equalsIgnoreCase("null")){
	           if(Equipment.headgear.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.chestpiece.mod3;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.chestpiece.mod3;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.chestpiece.mod3;
	           }
	           if(Equipment.chestpiece.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.chestpiece.mod3;
	           }
	       }
	    }
	    //bracers
	    if(Equipment.bracers != null){
	       //check each modification and apply it to the appropriate stat
	       if(!Equipment.bracers.mod1Stat.equalsIgnoreCase("null")){
	           if(Equipment.bracers.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.bracers.mod1;
	           }
	           if(Equipment.bracers.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.bracers.mod1;
	           }
	           if(Equipment.bracers.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.bracers.mod1;
	           }
	           if(Equipment.bracers.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.bracers.mod1;
	           }
	       }
	       if(!Equipment.bracers.mod2Stat.equalsIgnoreCase("null")){
	           if(Equipment.bracers.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.bracers.mod2;
	           }
	           if(Equipment.bracers.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.bracers.mod2;
	           }
	           if(Equipment.bracers.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.bracers.mod2;
	           }
	           if(Equipment.bracers.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.bracers.mod2;
	           }
	       }
	       if(!Equipment.bracers.mod3Stat.equalsIgnoreCase("null")){
	           if(Equipment.bracers.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.bracers.mod3;
	           }
	           if(Equipment.bracers.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.bracers.mod3;
	           }
	           if(Equipment.bracers.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.bracers.mod3;
	           }
	           if(Equipment.bracers.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.bracers.mod3;
	           }
	       }
	    }
	    //gloves
	    if(Equipment.gloves != null){
	       //check each modification and apply it to the appropriate stat
	       if(!Equipment.gloves.mod1Stat.equalsIgnoreCase("null")){
	           if(Equipment.gloves.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.gloves.mod1;
	           }
	           if(Equipment.gloves.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.gloves.mod1;
	           }
	           if(Equipment.gloves.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.gloves.mod1;
	           }
	           if(Equipment.gloves.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.gloves.mod1;
	           }
	       }
	       if(!Equipment.gloves.mod2Stat.equalsIgnoreCase("null")){
	           if(Equipment.gloves.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.gloves.mod2;
	           }
	           if(Equipment.gloves.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.gloves.mod2;
	           }
	           if(Equipment.gloves.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.gloves.mod2;
	           }
	           if(Equipment.gloves.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.gloves.mod2;
	           }
	       }
	       if(!Equipment.gloves.mod3Stat.equalsIgnoreCase("null")){
	           if(Equipment.gloves.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.gloves.mod3;
	           }
	           if(Equipment.gloves.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.gloves.mod3;
	           }
	           if(Equipment.gloves.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.gloves.mod3;
	           }
	           if(Equipment.gloves.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.gloves.mod3;
	           }
	       }
	    }
	    //ring
	    if(Equipment.ring != null){
	       //check each modification and apply it to the appropriate stat
	       if(!Equipment.ring.mod1Stat.equalsIgnoreCase("null")){
	           if(Equipment.ring.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.ring.mod1;
	           }
	           if(Equipment.ring.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.ring.mod1;
	           }
	           if(Equipment.ring.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.ring.mod1;
	           }
	           if(Equipment.ring.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.ring.mod1;
	           }
	       }
	       if(!Equipment.ring.mod2Stat.equalsIgnoreCase("null")){
	           if(Equipment.ring.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.ring.mod2;
	           }
	           if(Equipment.ring.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.ring.mod2;
	           }
	           if(Equipment.ring.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.ring.mod2;
	           }
	           if(Equipment.ring.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.ring.mod2;
	           }
	       }
	       if(!Equipment.ring.mod3Stat.equalsIgnoreCase("null")){
	           if(Equipment.ring.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.ring.mod3;
	           }
	           if(Equipment.ring.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.ring.mod3;
	           }
	           if(Equipment.ring.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.ring.mod3;
	           }
	           if(Equipment.ring.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.ring.mod3;
	           }
	       }
	    }
	    //leggings
	    if(Equipment.leggings != null){
	       //check each modification and apply it to the appropriate stat
	       if(!Equipment.leggings.mod1Stat.equalsIgnoreCase("null")){
	           if(Equipment.leggings.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.leggings.mod1;
	           }
	           if(Equipment.leggings.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.leggings.mod1;
	           }
	           if(Equipment.leggings.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.leggings.mod1;
	           }
	           if(Equipment.leggings.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.leggings.mod1;
	           }
	       }
	       if(!Equipment.leggings.mod2Stat.equalsIgnoreCase("null")){
	           if(Equipment.leggings.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.leggings.mod2;
	           }
	           if(Equipment.leggings.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.leggings.mod2;
	           }
	           if(Equipment.leggings.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.leggings.mod2;
	           }
	           if(Equipment.leggings.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.leggings.mod2;
	           }
	       }
	       if(!Equipment.leggings.mod3Stat.equalsIgnoreCase("null")){
	           if(Equipment.leggings.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.leggings.mod3;
	           }
	           if(Equipment.leggings.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.leggings.mod3;
	           }
	           if(Equipment.leggings.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.leggings.mod3;
	           }
	           if(Equipment.leggings.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.leggings.mod3;
	           }
	       }
	    }
	    //boots
	    if(Equipment.boots != null){
	       //check each modification and apply it to the appropriate stat
	       if(!Equipment.boots.mod1Stat.equalsIgnoreCase("null")){
	           if(Equipment.boots.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.boots.mod1;
	           }
	           if(Equipment.boots.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.boots.mod1;
	           }
	           if(Equipment.boots.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.boots.mod1;
	           }
	           if(Equipment.boots.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.boots.mod1;
	           }
	       }
	       if(!Equipment.boots.mod2Stat.equalsIgnoreCase("null")){
	           if(Equipment.boots.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.boots.mod2;
	           }
	           if(Equipment.boots.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.boots.mod2;
	           }
	           if(Equipment.boots.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.boots.mod2;
	           }
	           if(Equipment.boots.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.boots.mod2;
	           }
	       }
	       if(!Equipment.boots.mod3Stat.equalsIgnoreCase("null")){
	           if(Equipment.boots.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.boots.mod3;
	           }
	           if(Equipment.boots.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.boots.mod3;
	           }
	           if(Equipment.boots.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.boots.mod3;
	           }
	           if(Equipment.boots.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.boots.mod3;
	           }
	       }
	    }
	    //weapon
	    if(Equipment.weapon != null){
	       //check each modification and apply it to the appropriate stat
	       if(!Equipment.weapon.mod1Stat.equalsIgnoreCase("null")){
	           if(Equipment.weapon.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.weapon.mod1;
	           }
	           if(Equipment.weapon.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.weapon.mod1;
	           }
	           if(Equipment.weapon.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.weapon.mod1;
	           }
	           if(Equipment.weapon.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.weapon.mod1;
	           }
	       }
	       if(!Equipment.weapon.mod2Stat.equalsIgnoreCase("null")){
	           if(Equipment.weapon.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.weapon.mod2;
	           }
	           if(Equipment.weapon.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.weapon.mod2;
	           }
	           if(Equipment.weapon.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.weapon.mod2;
	           }
	           if(Equipment.weapon.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.weapon.mod2;
	           }
	       }
	       if(!Equipment.weapon.mod3Stat.equalsIgnoreCase("null")){
	           if(Equipment.weapon.mod1Stat.equals("DEX")){
	            PlayerStats.DEX += Equipment.weapon.mod3;
	           }
	           if(Equipment.weapon.mod1Stat.equals("AC")){
	            PlayerStats.AC += Equipment.weapon.mod3;
	           }
	           if(Equipment.weapon.mod1Stat.equals("STR")){
	            PlayerStats.STR += Equipment.weapon.mod3;
	           }
	           if(Equipment.weapon.mod1Stat.equals("INT")){
	            PlayerStats.INT += Equipment.weapon.mod3;
	           }
	       }
	    }
	}
}