import java.util.Random;

public class RNG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Dice
	public static int num;
	public static Random rn = new Random();

	public static int D4() {
		int x = rn.nextInt(4) + 1;
		num = x;
		return x;
	}

	public static int D6() {
		int x = rn.nextInt(6) + 1;
		num = x;
		return x;
	}

	public static int D8() {
		int x = rn.nextInt(8) + 1;
		num = x;
		return x;
	}

	public static int D10() {
		int x = rn.nextInt(10) + 1;
		num = x;
		return x;
	}

	public static int D12() {
		int x = rn.nextInt(12) + 1;
		num = x;
		return x;
	}

	public static int D20() {
		int x = rn.nextInt(20) + 1;
		num = x;
		return x;
	}

	public static int D100() {
		int x = rn.nextInt(100) + 1;
		num = x;
		return x;
	}
	//

	// Roll
	public static void Roll(int x) {
		if (x == 4) {
			System.out.println(D4());
		} else if (x == 6) {
			System.out.println(D6());
		} else if (x == 8) {
			System.out.println(D8());
		} else if (x == 10) {
			System.out.println(D10());
		} else if (x == 12) {
			System.out.println(D12());
		} else if (x == 20) {
			System.out.println(D20());
		} else if (x == 100) {
			System.out.println(D100());
		}
	}
	//
}
