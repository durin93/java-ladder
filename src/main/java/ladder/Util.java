package ladder;

import java.util.Random;

public class Util {

	public static final int RANDOMRANGE = 8;
	public static final int RANDOMMIN = 3;

	public static Boolean getRandomBoolean() {
		Random rand = new Random();
		if (rand.nextInt(RANDOMRANGE) > RANDOMMIN) {
			return true;
		}
		return false;
	}

	public static void print(String word) {
		System.out.print(word);
	}

}
