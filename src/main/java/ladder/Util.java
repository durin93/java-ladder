package ladder;

import java.util.Random;

public class Util {

	public static Boolean getRandomBoolean() {
		Random rand = new Random();
		if (rand.nextInt(8) > 3) {
			return true;
		}
		return false;
	}

}
