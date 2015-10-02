import java.lang.*;

public class Dungeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    public static final Room playerRoom;
		public static final int maxRooms = 9;
	}

	// Create First Room
	public static void Start() {
	   
	   
		Room firstRoom = new Room();
	    playerRoom = firstRoom;
		Room rooms[maxRooms];
		firstRoom.id = 0;
		rooms[0] = firstRoom;

	}
	

	// Generate Rooms
	public static void Generate() {

		int roomCount = 0;
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

	}
	//

	public static void Content() {
		RNG.D100();
		if (RNG.num <= 75) {
			Generate();
			EnemyEncounter.main(null);
			changeRoom();
		} else if (RNG.num > 75 && RNG.num <= 90) {
			Generate();
			changeRoom();
		} else if (RNG.num > 90 && RNG.num <= 100) {
			Generate();
			Loot.main(null);
			changeRoom();
		}
	}
	//
}
