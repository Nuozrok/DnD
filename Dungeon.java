import java.lang.*;
import java.util.*;

public class Dungeon {

    public static Room playerRoom;
	public static int maxRooms = 9;
	public static void main(String[] args) {

		Start();
		FirstRoom.main(null);
<<<<<<< Updated upstream
		Generate();
		Content();
		
	}

=======
		
		int roomCount = 0;
	
	    Content();
    }
>>>>>>> Stashed changes
	// Create First Room
	public static int roomCount = 0;
	public static Room firstRoom = new Room();
	public static Room[] rooms = new Room[maxRooms];

	public static void Start() {
	    playerRoom = firstRoom;
		firstRoom.id = 0;
		rooms[0] = firstRoom;
	}
	

	// Generate Rooms
	public static void Generate() {

		while (roomCount < maxRooms) {
			// 1. create a room
			roomCount++;
			Room currentRoom = new Room();
			currentRoom.id = roomCount;

            // which direction will the door be (don't forget to check that door isn't already there)

        	// 4. randomly add a door to the wall
    			switch (RNG.D4()) {
    			case 1:
    			    // forward door
    				rooms[roomCount - 1].canMoveNorth = currentRoom.id;
    				currentRoom.description += "\n there is a room to the north of you";  
    				
    				// backwards door
                    currentRoom.canMoveSouth = rooms[roomCount - 1].id;
    				currentRoom.description += "\n there is a room to the south of you";
    				break;
    			case 2:
                    rooms[roomCount - 1].canMoveEast = currentRoom.id; 
    				currentRoom.description += "\n there is a room to the east of you";
    				
                    currentRoom.canMoveWest = rooms[roomCount - 1].id;
    				currentRoom.description += "\n there is a room to the west of you";
    				break;
    			case 3:
                    rooms[roomCount - 1].canMoveWest = currentRoom.id;
    				currentRoom.description += "\n there is a room to the east of you";
    				
                    currentRoom.canMoveEast = rooms[roomCount - 1].id;
    				currentRoom.description += "\n there is a room to the west of you";    			
    				break;
     			case 4:
                    rooms[roomCount - 1].canMoveSouth = currentRoom.id;  
    				currentRoom.description += "\n there is a room to the south of you";
    				
    			    currentRoom.canMoveNorth = rooms[roomCount - 1].id;
    				currentRoom.description += "\n there is a room to the north of you";
    			
    				break;
				
    			}
			
		}
	}
	//

	// Enter New Room
	public static void changeRoom() {
        Scanner whichDirection = new Scanner(System.in);
        String selectedRoom = whichRoom.nextDirection();
        
        // did they choose a valid direction and is there a door there?
        if (selectedRoom.equalsIgnoreCase("North") && currentRoom.canMoveNorth != -1)
        {
            int id = currentRoom.canMoveNorth;
            System.out.println("walking northward");
            currentRoom = rooms[id];
            System.out.println(currentRoom.description);
        }
        else if(selectedRoom.equalsIgnoreCase("South") && currentRoom.canMoveSouth != -1)
        {
            
            int id = currentRoom.canMoveSouth;
            System.out.println("walking southward");
            currentRoom = rooms[id];
            System.out.println(currentRoom.description);    
        }
        else if(selectedRoom.equalsIgnoreCase("East" && currentRoom.canMoveEast != -1))
        {
            int id = currentRoom.canMoveEast;
            System.out.println("walking eastward");
            currentRoom = rooms[id];
            System.out.println(currentRoom.description);
        }
        else if(selectedRoom.equalsIgnoreCase("West") && currentRoom.canMoveWest != -1)
        {
            
            int id = currentRoom.canMoveWest;
            System.out.println("walking westward");
            currentRoom = rooms[id];
            System.out.println(currentRoom.description);
        }
        else{
            System.out.println("sorry, try another direction");
            changeRoom();
        }
        
	}
	//

	public static void Content() {
		RNG.D100();
		if (RNG.num <= 75) {
<<<<<<< Updated upstream
			EnemyEncounter.main(null);
=======
			Generate();
>>>>>>> Stashed changes
			changeRoom();
			EnemyEncounter.main(null);
			
		} else if (RNG.num > 75 && RNG.num <= 90) {
		    System.out.println("Doesn't seem to be anything here");
			changeRoom();
		} else if (RNG.num > 90 && RNG.num <= 100) {
<<<<<<< Updated upstream
			Loot.main(null);
=======
			Generate();
>>>>>>> Stashed changes
			changeRoom();
			Loot.main(null);
		}
	}
	//
}
