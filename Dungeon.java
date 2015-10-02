
public class Dungeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		public static final int maxRooms = 10;
	}

	// Create First Room
	public static void Start() {
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

			switch (RNG.D4()) {
			case 1:
				rooms(roomCount - 1).canMoveNorth();
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			}
		}
		// 2. pick a room
		// 3. choose a wall
		// 4. randomly add a door to the wall, or do not
		// 5. repeat steps 2 and 3, 3 more times, such that there is at least 1
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
