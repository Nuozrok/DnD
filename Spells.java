import java.util.Scanner;
public class Spells {
	
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	
	}
	//Spells
	public static void heal(){
		boolean loop = true;
		while(loop == true){
			System.out.println("====================");
			System.out.println("Roll to heal");
			System.out.println("====================");
			String response = input.nextLine().toLowerCase();	
			if(response.equals("roll")){
				RNG.D4();
				System.out.println("You roll "+RNG.num);
				System.out.println("You heal "+(PlayerStats.INT * RNG.num)+"HP");
				PlayerStats.HP = PlayerStats.HP + (PlayerStats.INT * RNG.num);
				if(PlayerStats.HP > PlayerStats.totalHP){
					loop = false;
					PlayerStats.HP = PlayerStats.totalHP;
				}
				loop = false;
				System.out.println("You have "+PlayerStats.HP +"HP");
			}
		}
	}
	public static void fireball(){
		System.out.println("You shoot a fireball");
		boolean loop1 = true;
		while(loop1 == true){
			System.out.println("====================");
			System.out.println("Roll to see if it hits");
			System.out.println("====================");
			String response = input.nextLine().toLowerCase();	
			if(response.equals("roll")){
				loop1 = false;
				RNG.D20();
				int roll = RNG.num;
				if(RNG.num > EnemyEncounter.AC){
					System.out.println("You roll "+roll);
						if(roll == 1){
						System.out.println("Critical fail!");
						System.out.println("You miss!");
					}else{
						System.out.println("You roll "+roll);
						System.out.println("It hits!");
						boolean loop2 = true;
						while(loop2 == true){
							System.out.println("====================");
							System.out.println("Roll for damage");
							System.out.println("====================");
							if(input.nextLine().toLowerCase().equals("roll")){
								loop2 = false;
								RNG.D8();
								System.out.println("You roll "+RNG.num);
								EnemyEncounter.HP = EnemyEncounter.HP - (PlayerStats.INT + RNG.num);
								System.out.println("You deal " + (PlayerStats.INT + RNG.num) +" damage");
								System.out.println("The "+EnemyEncounter.enemy+" has "+EnemyEncounter.HP +"HP");
							}
						}
					}
				}else if(RNG.num < EnemyEncounter.AC){
					System.out.println("You roll "+roll);
					System.out.println("You miss!");
				}
			}
		}
	}
	//
	
	//CanCast?
	public static void canCast(){
		System.out.println("You know how to cast:");
		System.out.println("====================");
		if(PlayerStats.INT >= 1){
			System.out.println("Heal\t\t5"); //mana cost of 5
		}
		if(PlayerStats.INT >= 4){
			System.out.println("Fireball\t7"); //mana cost of 7
		}
		System.out.println("====================");
		System.out.println("Back");
	}
	//
	
	//Casting
	public static void casting(){
		boolean loop = true;
		while(loop == true){
		String response = input.nextLine().toLowerCase();	
			if(response.equals("heal") && PlayerStats.INT >= 1 && PlayerStats.MP >= 5){
				loop = false;
				heal();
                PlayerStats.MP -= 5;
			}else if(response.equals("heal") && PlayerStats.INT >= 1 && PlayerStats.MP < 5){
			    loop = false;
			    System.out.println("Insufficient mana!");
			    canCast();
			}else if(response.equals("fireball") && PlayerStats.INT >= 4 && PlayerStats.MP >= 7){
				loop = false;
				fireball();
				PlayerStats.MP -= 7;
			}else if(response.equals("fireball") && PlayerStats.INT >= 4 && PlayerStats.MP < 7){
			    loop = false;
			    System.out.println("Insufficient mana!");
			    canCast();	
			}else if(response.equals("back")){
				EnemyEncounter.combat();
			}else canCast();
		}
		
	}
	//
}
