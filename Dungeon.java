import java.lang.*;
import java.util.*;

public class Dungeon {

    public static Room playerRoom;
    public static int numberOfRooms = 0;
	public static int maxRooms = 9;
	public static Room[] rooms = new Room[maxRooms];
    public static Room currentRoom = new Room();
	
	public static void main(String[] args) {
	    start();
	    FirstRoom.main(null);
	    //temporary route directly to EnemyEncounter
	    //EnemyEncounter.main(null);

	    //loop until end of program
	    while(true){
	        Content();
	    }
    }

	// create first room
	public static void start() {
	    playerRoom = currentRoom;
		currentRoom.id = 0;
		rooms[0] = currentRoom;
	}
	
	// adds another room to the maze
	public static void generate() {

      		// 1. create a room
      		currentRoom = new Room();
      		numberOfRooms++;
			currentRoom.id = numberOfRooms;
            // which direction will the door be (don't forget to check that door isn't already there)

        	// 4. randomly add a door to the wall
        	int randomDirection;
        	boolean foundADirection = false;
        	
        	while(foundADirection == false)
        	{
        	    randomDirection = RNG.D4();
    			switch (randomDirection) {
    			case 1:
    			    if (currentRoom.canMoveSouth == -1)
    			    {
        			    // forward door
        				rooms[numberOfRooms - 1].canMoveNorth = currentRoom.id;
        				currentRoom.description += "\nThere is a room to the north of you";

        				// backwards door
                        currentRoom.canMoveSouth = rooms[numberOfRooms - 1].id;
        				currentRoom.description += "\nThere is a room to the south of you";
        				foundADirection = true;
    			    }
        	    	break;
        			    
    			case 2:
    			    if(currentRoom.canMoveWest == -1)
    			    {
                        rooms[numberOfRooms - 1].canMoveEast = currentRoom.id;
        				currentRoom.description += "\nThere is a room to the east of you";

                        currentRoom.canMoveWest = rooms[numberOfRooms - 1].id;
        				currentRoom.description += "\nThere is a room to the west of you";
    		        	foundADirection = true;
    			    }
        			break;
    			case 3:
			        if(currentRoom.canMoveEast == -1)
			        {
                        rooms[numberOfRooms - 1].canMoveWest = currentRoom.id;
        				currentRoom.description += "\nThere is a room to the east of you";

                        currentRoom.canMoveEast = rooms[numberOfRooms - 1].id;
        				currentRoom.description += "\nThere is a room to the west of you"; 
			            foundADirection = true;
			        }
    				break;
     			case 4:
     			    if(currentRoom.canMoveNorth == -1)
     			    {
                        rooms[numberOfRooms - 1].canMoveSouth = currentRoom.id;  
        				currentRoom.description += "\nThere is a room to the south of you";

        			    currentRoom.canMoveNorth = rooms[numberOfRooms - 1].id;
        				currentRoom.description += "\nThere is a room to the north of you";
     			        foundADirection = true;
     			    }
    				break;
    			}	
    		}
    		System.out.println("====================");
    		System.out.println(currentRoom.description);
    		System.out.println("====================");
	}
	//

	// Enter New Room
	public static void changeRoom() {
        Scanner whichDirection = new Scanner(System.in);
        String selectedRoom = whichDirection.nextLine();
        
        // did they choose a valid direction and is there a door there?
        if (selectedRoom.equalsIgnoreCase("North") && currentRoom.canMoveNorth != -1)
        {
            int id = currentRoom.canMoveNorth;
            System.out.println("Walking northward");
            currentRoom = rooms[id];
        }
        else if(selectedRoom.equalsIgnoreCase("South") && currentRoom.canMoveSouth != -1)
        {
            int id = currentRoom.canMoveSouth;
            System.out.println("Walking southward");
            currentRoom = rooms[id];
        }
        else if(selectedRoom.equalsIgnoreCase("East") && currentRoom.canMoveEast != -1)
        {
            int id = currentRoom.canMoveEast;
            System.out.println("Walking eastward");
            currentRoom = rooms[id];
        }
        else if(selectedRoom.equalsIgnoreCase("West") && currentRoom.canMoveWest != -1)
        {
            int id = currentRoom.canMoveWest;
            System.out.println("Walking westward");
            currentRoom = rooms[id];
        }
        else{
            System.out.println("====================");
    		System.out.println(currentRoom.description);
    		System.out.println("====================");
    		changeRoom();
        }
        
	}
	//

	public static void Content() {
		RNG.D100();
		if (RNG.num <= 75) {
			generate();
			changeRoom();
			EnemyEncounter.main(null);
		} else if (RNG.num > 75 && RNG.num <= 90) {
		    System.out.println("Doesn't seem to be anything special here");
		    generate();
			changeRoom();
		} else if (RNG.num > 90 && RNG.num <= 100) {
			generate();
			changeRoom();
			Loot.main(null);
		}
	}
	//
}
