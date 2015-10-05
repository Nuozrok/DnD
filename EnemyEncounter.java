import java.util.Scanner;

public class EnemyEncounter {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		PlayerStats.main(null);
		Enemy();
		System.out.println("You are attacked by a " + enemy + "!");
		Stats();
		Initiative();
		Combat();
		System.out.println("Victory!");
		// Checks to see if you leveled up
		Experience();
		PlayerStats.main(null);
		System.exit(0);
	}

	// Initiative
	public static int playerInit;
	public static int enemyInit;
	public static int init;

	public static void Initiative() {
		boolean loop = true;
		while (loop == true) {
			System.out.println("====================");
			System.out.println("Roll for initiative");
			System.out.println("====================");
			if (input.nextLine().toLowerCase().equals("roll")) {
				loop = false;
				System.out.print("You roll: ");
				RNG.Roll(20);
				playerInit = RNG.num;
				;
			}
		}
		System.out.print("The " + enemy + " rolls: ");
		RNG.Roll(20);
		enemyInit = RNG.num;
		if (playerInit >= enemyInit) {
			init = 0;
		} else
			init = 1;
	}
	//

	// Combat
	public static boolean combat;
	public static int DMG;

	public static void Combat() {
		combat = true;
		while (combat = true) {
			// player's move
			if (init == 0) {
				boolean loop1 = true;
				while (loop1 == true) {
					System.out.println("Your turn");
					System.out.println("====================");
					System.out.println("Attack or magic?");
					System.out.println("====================");
					String response = input.nextLine().toLowerCase();
					if (response.equals("attack")) {
						loop1 = false;
						boolean loop2 = true;
						while (loop2 == true) {
							System.out.println("====================");
							System.out.println("Roll to attack");
							System.out.println("Back");
							System.out.println("====================");
							response = input.nextLine().toLowerCase();
							if (response.equals("roll")) {
								loop2 = false;
								Attack();
								// if enemy dies
								if (HP <= 0) {
									System.out.println("You have slain the " + enemy + "!");
									combat = false;
									return;
								}
							} else if (response.equals("back")) {
								Combat();
							}
						}
					} else if (response.equals("magic")) {
						loop1 = false;
						Magic();
						// if enemy dies
						if (HP <= 0) {
							System.out.println("You have slain the " + enemy + "!");
							combat = false;
							return;
						}
					}
				}
				init++;
			}
			// enemy's move
			if (init == 1) {
				System.out.println("It's the " + enemy + "'s turn");
				RNG.D20();
				if (RNG.num > PlayerStats.AC) {
					if (RNG.num == 20) {
						System.out.println("The " + enemy + " rolls " + RNG.num);
						System.out.println("Critical hit!");
						DMG = STR + RNG.D4();
						PlayerStats.HP = PlayerStats.HP - (DMG * 2);
						System.out.println("The " + enemy + " rolls for damage");
						System.out.println("The " + enemy + " rolls " + RNG.num);
						System.out.println("The " + enemy + " deals " + (DMG * 2) + " damage");
						System.out.println("You have " + PlayerStats.HP + "HP and " + PlayerStats.MP + " MP");
						// if player dies
						if (PlayerStats.HP <= 0) {
							System.out.println("You have been slain!");
							System.exit(0);
						}
					} else if (RNG.num == 1) {
						System.out.println("The " + enemy + " rolls " + RNG.num);
						System.out.println("Critical fail!");
						System.out.println("The " + enemy + " misses!");
					} else {
						System.out.println("The " + enemy + " rolls " + RNG.num);
						System.out.println("It hits!");
						System.out.println("The " + enemy + " rolls for damage");
						DMG = STR + RNG.D4();
						System.out.println("The " + enemy + " rolls " + RNG.num);
						PlayerStats.HP = PlayerStats.HP - DMG;
						System.out.println("The " + enemy + " deals " + DMG + " damage");
						System.out.println("You have " + PlayerStats.HP + "HP and " + PlayerStats.MP + " MP");
						// if player dies
						if (PlayerStats.HP <= 0) {
							System.out.println("You have been slain!");
							System.exit(0);
						}
					}
				} else if (RNG.num <= PlayerStats.AC) {
					System.out.println("The " + enemy + " rolls " + RNG.num);
					System.out.println("The " + enemy + " misses!");
				}
				init--;
			}
		}
		return;
	}

	public static void Attack() {
		RNG.D20();
		if (RNG.num > AC) {
			if (RNG.num == 20) {
				System.out.println("You roll " + RNG.num);
				System.out.println("Critical hit!");
				boolean loop = true;
				while (loop == true) {
					System.out.println("====================");
					System.out.println("Roll for damage");
					System.out.println("====================");
					if (input.nextLine().toLowerCase().equals("roll")) {
						loop = false;
						DMG = PlayerStats.STR + RNG.D4();
						System.out.println("You roll " + RNG.num);
						HP = HP - (DMG * 2);
						System.out.println("You deal " + (DMG * 2) + " damage");
						System.out.println("The " + enemy + " has " + HP + "HP");
					}
				}
			} else if (RNG.num == 1) {
				System.out.println("You roll " + RNG.num);
				System.out.println("Critical fail!");
				System.out.println("You miss!");
			} else {
				System.out.println("You roll " + RNG.num);
				System.out.println("It hits!");
				boolean loop = true;
				while (loop == true) {
					System.out.println("====================");
					System.out.println("Roll for damage");
					System.out.println("====================");
					if (input.nextLine().toLowerCase().equals("roll")) {
						loop = false;
						DMG = PlayerStats.STR + RNG.D4();
						System.out.println("You roll " + RNG.num);
						HP = HP - DMG;
						System.out.println("You deal " + DMG + " damage");
						System.out.println("The " + enemy + " has " + HP + "HP");
					}
				}
			}
		} else if (RNG.num < AC) {
			System.out.println("You roll " + RNG.num);
			System.out.println("You miss!");
		}
	}

	public static void Magic() {
		System.out.println("You have " +PlayerStats.MP+ "/" +PlayerStats.totalMP+" MP");
		System.out.println("What would you like to cast?");
		Spells.CanCast();
		Spells.Casting();
	}
	//

	// Enemy

	// To be modified via 'if statements' further in development
	public static String enemy;

	public static void Enemy() {
		enemy = "troll";
	}
	//

	// Stats
	public static int DEX;
	public static int HP;
	public static int totalHP;
	public static int AC;
	public static int STR;
	public static int INT;

	public static void Stats() {
		DEX = RNG.D8();
		HP = 32 + DEX;
		totalHP = HP;
		AC = 0;
		STR = RNG.D4();
		INT = RNG.D4();
	}
	//

    //How much experience is given when the enemy is slain
    public static void Experience(){
        PlayerStats.currentEXP += (12*AC + 8*totalHP);
        System.out.println("You gained " +(12*AC + 8*totalHP)+ " experience!");
    }
}
