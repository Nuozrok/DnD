import java.util.Scanner;

public class EnemyEncounter {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		PlayerStats.main(null);
		enemy();
		System.out.println("You are attacked by a(n) " + enemy + "!");
		stats();
		initiative();
		combat();
		System.out.println("Victory!");
		// Checks to see if you leveled up
		experience();
		PlayerStats.main(null);
	}

	// Initiative
	public static int playerInit;
	public static int enemyInit;
	public static int init;

	public static void initiative() {
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
	public static int DMG;
	public static void combat() {
		while(true){
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
    						System.out.println("====================");
    						System.out.println("Back");
    						response = input.nextLine().toLowerCase();
    						if (response.equals("roll")) {
    							loop2 = false;
    							attack();
    							// if enemy dies
    							if (HP <= 0) {
    								System.out.println("You have slain the " + enemy + "!");
    								return;
    							}
    						} else if (response.equals("back")) {
    							combat();
    						}
    					}
    				} else if (response.equals("magic")) {
    					loop1 = false;
    					magic();
    					// if enemy dies
    					if (HP <= 0) {
    						System.out.println("You have slain the " + enemy + "!");
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
    			if (RNG.num > 0.2*PlayerStats.AC) {
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
    			} else if (RNG.num <= 0.2*PlayerStats.AC) {
    				System.out.println("The " + enemy + " rolls " + RNG.num);
    				System.out.println("The " + enemy + " misses!");
    			}
    			init--;
    		}
		}
	}

	public static void attack() {
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

	public static void magic() {
		System.out.println("You have " +PlayerStats.MP+ "/" +PlayerStats.totalMP+" MP");
		System.out.println("What would you like to cast?");
		Spells.canCast();
		Spells.casting();
	}
	//

	// Enemy

	// To be modified via 'if statements' further in development
	public static String enemy;

    //Enemies in caps are bosses
	public static void enemy(){
		enemy = null;
		while(enemy == null){
		        spawnEnemy();
		}
	}
	//Spawn Enemy based on player level and randomly choose enemy, or the "boss"
    public static void spawnEnemy(){
        RNG.D100();
        if(PlayerStats.LVL <= 2){
            if(RNG.num <= 90){
                enemy = "imp";
            }else{
                enemy = "IMP LORD";
            }
        }else if(PlayerStats.LVL > 2 && PlayerStats.LVL <= 3){
            if(RNG.num <= 20){
                enemy = "imp";
            }else if(RNG.num > 20 && RNG.num <= 90){
                enemy = "toadman";
            }else{
                enemy = "IMP LORD";
            }
        }else if(PlayerStats.LVL > 3 && PlayerStats.LVL <= 5){
            if(RNG.num <= 10){
                enemy = "toadman";
            }else if(RNG.num > 10 && RNG.num <= 90){
                enemy = "giant spider";
            }else{
                enemy = "BROODMOTHER";
            }
        }else if (PlayerStats.LVL > 5 && PlayerStats.LVL <= 8){
            if(RNG.num <= 30){
                enemy = "goblin sorceror";
            }else if(RNG.num > 30 && RNG.num <= 60){
                enemy = "goblin warrior";
            }else if(RNG.num >60 && RNG.num <= 90){
                enemy = "goblin archer";
            }else if(RNG.num > 90 && RNG.num <= 100){
                enemy = "GOBLIN CHIEFTAN";   
            }
        } 
    }
    
	// Stats
	public static int DEX;
	public static int HP;
	public static int totalHP;
	public static int AC;
	public static int STR;
	public static int INT;

	public static void stats(){
	    if(enemy.equals("imp")){
	        DEX = RNG.D4();
		    HP = 5 + DEX;
		    totalHP = HP;
		    AC = 0;
		    STR = RNG.D4() - 2;
		    if(STR < 0){
		        STR = 0;
		    }
		    INT = RNG.D4();
	    }else if(enemy.equals("IMP LORD")){
	        DEX = RNG.D4();
	        HP = 14 + DEX;
	        totalHP = HP;
	        AC = 4;
	        STR = RNG.D4();
	        INT = RNG.D4();
	    }else if(enemy.equals("toadman")){
	        DEX = RNG.D4();
	        HP = 10 + DEX;
	        totalHP = HP;
	        AC = 2;
	        STR = RNG.D4();
	        INT = RNG.D4() + 1;
	    }else if(enemy.equals("giant spider")){
	        DEX = RNG.D4();
	        HP = 16 + DEX;
	        totalHP = HP;
	        AC = 0;
	        STR = RNG.D4();
	        INT = RNG.D4() + 2;
	    }else if(enemy.equals("BROODMOTHER")){
	        DEX = RNG.D4();
	        HP = 20 + DEX;
	        totalHP = HP;
	        AC = 0;
	        STR = RNG.D4() + 3;
	        INT = RNG.D4();
	    }else if(enemy.equals("goblin sorceror")){
	        DEX = RNG.D4();
	        HP = 14 + DEX;
	        totalHP = HP;
	        AC = 2;
	        STR = RNG.D4();
	        INT = RNG.D4() + 4;
	    }else if(enemy.equals("goblin warrior")){
	        DEX = RNG.D4();
	        HP = 20 + DEX;
	        totalHP = HP;
	        AC = 6;
	        STR = RNG.D4() + 1;
	        INT = RNG.D4();
	    }else if(enemy.equals("goblin archer")){
	        DEX = RNG.D4();
	        HP = 16 + DEX;
	        totalHP = HP;
	        AC = 3;
	        STR = RNG.D4() + 3;
	        INT = RNG.D4();
	    }else if(enemy.equals("GOBLIN CHIEFTAN")){
	        DEX = RNG.D4();
	        HP = 24 + DEX;
	        totalHP = HP;
	        AC = 6;
	        STR = RNG.D4() + 4;
	        INT = RNG.D4() + 2;
	//The troll is still not anywhere near balanced for current level bracket
	//	}else if(enemy.equals("troll")){
	//	    DEX = RNG.D8();
	//	    HP = 32 + DEX;
	//	    totalHP = HP;
	//	    AC = 0;
	//	    STR = RNG.D4() + 4;
	//	    INT = RNG.D4();
		}
	}
	//

    //How much experience is given when the enemy is slain
    public static void experience(){
        PlayerStats.currentEXP += (12*AC + 8*totalHP);
        System.out.println("You gained " +(12*AC + 8*totalHP)+ " experience!");
    }
}
