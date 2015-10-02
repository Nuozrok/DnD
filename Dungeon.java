
public class Dungeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		public static final int maxRooms = 10;
	}

	// Create First Room
	public static void Start() {
	    
	    // this is commited again again
		Room firstRoom = new Room();
		Room rooms(maxRooms);
		firstRoom.id = 0;
		firstRoom = rooms(0);

	}
	//

	// Generate Rooms
	public static void Generate() {

		int roomCount = 0;
		while (roomCount < maxRooms) {
			// 1. create a room
			roomCount++;
			Room currentRoom = new Room();
			currentRoom.id = roomCount;

            // which direction will the door be (don't forget to check that door isn't already there)
			switch (RNG.D4()) {
			case 1:
			    // forward door
				rooms(roomCount - 1).canMoveNorth() = currentRoom.id;
				
				// backwards door
                currentRoom.canMoveSouth() = rooms(roomCount - 1).id;
				break;
			case 2:
                rooms(roomCount - 1).canMoveEast() = currentRoom.id; 
                
                currentRoom.canMoveWest() = rooms(roomCount - 1).id;
				break;
			case 3:
                rooms(roomCount - 1).canMoveWest() = currentRoom.id;
                currentRoom.canMoveEast() = rooms(roomCount - 1).id;
			
				break;
			case 4:
                rooms(roomCount - 1).canMoveSouth() = currentRoom.id;  
			    currentRoom.canMoveNorth() = rooms(roomCount - 1).id;
			
				break;
			}
			
		}
		// 2. pick a room
		// 3. choose a wall
		// 4. randomly add a door to the wall, or do not
		// 5. repeat steps 2 and 3, marxRooms more times, such that there is at least 1
		// door per room
		// 6. add a room adjacent to each door, unless a room already exists

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
