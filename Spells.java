import java.util.Scanner;
public class Spells {
	
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	
	}
	//Spells
	public static void Heal(){
		boolean loop = true;
		while(loop == true){
			System.out.println("Roll to heal");
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
	public static void Fireball(){
		System.out.println("You shoot a fireball");
		boolean loop1 = true;
		while(loop1 == true){
			System.out.println("Roll to see if it hits");
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
							System.out.println("Roll for damage");
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
	public static void CanCast(){
		System.out.println("You can cast:");
		System.out.println("====================");
		if(PlayerStats.INT >= 1){
			System.out.println("Heal");
		}
		if(PlayerStats.INT >= 4){
			System.out.println("Fireball");
		}
		System.out.println("====================");
		System.out.println("Back");
	}
	//
	
	//Casting
	public static void Casting(){
		boolean loop = true;
		while(loop == true){
		String response = input.nextLine().toLowerCase();	
			if(response.equals("heal") && PlayerStats.INT >= 1){
				loop = false;
				Heal();
			}else if(response.equals("fireball") && PlayerStats.INT >= 4){
				loop = false;
				Fireball();
			}else if(response.equals("back")){
				EnemyEncounter.Combat();
			}else CanCast();
		}
		
	}
	//
}
