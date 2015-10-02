public class PlayerStats {

	
	
	public static void main(String[] args) {
		Stats();	
	}
	//Stats
	public static int DEX;
	public static int HP;
	public static int totalHP;
	public static int AC;
	public static int STR;
	public static int INT;
	public static void Stats(){
		DEX = RNG.D4();
		HP = 20 + DEX;
		totalHP = HP;
		AC = 3 + DEX;
		STR = 2 + RNG.D4();
		INT = RNG.D4();
	}
	//
}
