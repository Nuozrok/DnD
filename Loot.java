import java.util.Scanner;
import java.util.ArrayList;

public class Loot {

	public static void main(String[] args) {
		System.out.println("Loot!");
		//make sure an item cannot drop more than once per game
		ArrayList<Gear> itemPool = new ArrayList<Gear>();
		//headgear
		itemPool.add(Gear.headgear0);
		
		//chestpiece
		itemPool.add(Gear.chestpiece0);
		
		//bracers
		itemPool.add(Gear.bracers0);
		
		//gloves
		itemPool.add(Gear.gloves0);
		
		//ring
		itemPool.add(Gear.ring0);
		
		//leggings
		itemPool.add(Gear.leggings0);
		
		//boots
		itemPool.add(Gear.boots0);
		
		//weapon
		itemPool.add(Gear.weapon0);
		
		
		Gear[] item = new Gear[1];
		//itemPool contain all items in Gear.java
		//if an item is dropped, it is removed from the itemPool
		//the itemPool can only drop items that are within 5 levels of the player
		
		//while the item's level is not with 5 levels of the players, pick another item to drop
		do{
		    item[0] = itemPool.get((int)(Math.random()*itemPool.size()));
	    }while(item[0].lvlReq > (PlayerStats.LVL + 5) || item[0].lvlReq < (PlayerStats.LVL - 5));
        
        //print result
        System.out.println("You walk to the center of the room and open a chest\nIt contains "+item[0].name+ "!");
        
        //add the item if there is room in the inventory
        for(int i = 0; i < Inventory.inv.length; i ++){
            if(Inventory.inv[i] == null){
                System.out.println(item[0].name + " has been added to your inventory!");
                Inventory.inv[i] = item[0];
                return;
            }
        }    
        System.out.println("Your inventory if full!");
        System.out.println("Choose something to discard");
        
        //print inventory and request removal of one of them
        System.out.println("Item name:\tStat modifiers:\t\t\tEquipped?");
        for (int i = 0; i < Inventory.inv.length; i ++){
            if (Inventory.inv[i] != null){
                //print name and tab
                System.out.print(Inventory.inv[i].name +"\t");
                //if there is a mod 1, print it and tab
                if(Inventory.inv[i].mod1 != 0){
                    System.out.print("+"+Inventory.inv[i].mod1+" "+Inventory.inv[i].mod1Stat+"\t");
                    //if no more mods, then tab
                    if(Inventory.inv[i].mod2 == 0){
                        System.out.print("\t\t\t");
                    }
                //if no mods at all, then tab
                }else{
                    System.out.print("\t\t\t");
                }
                //if there is a mod 2, print it and tab
                if(Inventory.inv[i].mod2 != 0){
                    System.out.print("+"+Inventory.inv[i].mod2+" "+Inventory.inv[i].mod2Stat+"\t");
                    //if no more mods, then tab
                    if(Inventory.inv[i].mod3 == 0){
                        System.out.print("\t");
                    }
                }
                //if there is a mod 3, print and tab
                if(Inventory.inv[i].mod3 != 0){
                    System.out.print("+"+Inventory.inv[i].mod2+" "+Inventory.inv[i].mod2Stat+"\t");
                    //if no more mods, then tab
                    if(Inventory.inv[i].mod3 == 0){
                        System.out.print("\t");
                   }
                }
               //print if it is equippped
                if(Equipment.headgear == Inventory.inv[i]){
                   System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }
            Scanner input = new Scanner(System.in);
            if(input.next().equalsIgnoreCase(Inventory.inv[i].name)){
                Inventory.inv[i] = null;
                System.out.println(Inventory.inv[i].name + " has been discarded");
            }
            for(int j = 0; j < Inventory.inv.length; j ++){
                if(Inventory.inv[j] != null){
                    System.out.println(item[0].name + " has been added to your inventory!");
                    Inventory.inv[j] = item[0];
                }
            } 
        }    
        //offer access to inventory
        System.out.println("====================");
        System.out.println("Would you like to access your inventory now? (yes/no)");
        System.out.println("====================");
        boolean loop = true;
        while(loop == true){
            Scanner input = new Scanner(System.in);
            String response = input.next();
            if(response.equalsIgnoreCase("yes")){
                loop = false;
                Inventory.main(null);
            }else if (response.equalsIgnoreCase("no")){
                loop = false;
            }       
        }    
	}
}
