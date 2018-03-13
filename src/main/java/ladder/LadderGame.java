package ladder;

import java.util.List;
import java.util.Scanner;

public class LadderGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintManager prManager = new PrintManager();
		LadderManager ldManager = new LadderManager();

		List<String> joinUser = prManager.joinUser(sc);
		int maxLadder = prManager.maxLadder(sc);

		ldManager.makeLadder(joinUser.size(), maxLadder);
		prManager.printLadder(ldManager.getBranchLineArr(), joinUser);
	}
}
