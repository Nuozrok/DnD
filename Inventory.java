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
                System.out.println(inv[i].name +"\t\t" + inv[i].type);
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
                                Equipment.headgear = inv[i];
                                System.out.println(inv[i].name + " was equipped");
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
                                Equipment.chestpiece = inv[i];
                                System.out.println(inv[i].name + " was equipped");
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
                                Equipment.bracers = inv[i];
                                System.out.println(inv[i].name + " was equipped");
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
                                Equipment.gloves = inv[i];
                                System.out.println(inv[i].name + " was equipped");
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
                                Equipment.ring = inv[i];
                                System.out.println(inv[i].name + " was equipped");
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
                                Equipment.leggings = inv[i];
                                System.out.println(inv[i].name + " was equipped");
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
                                Equipment.boots = inv[i];
                                System.out.println(inv[i].name + " was equipped");
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
                                Equipment.weapon = inv[i];
                                System.out.println(inv[i].name + " was equipped");
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
}