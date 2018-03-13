package ladder;

import java.util.List;

public class LadderGame {

	public static void main(String[] args) {

		PrintManager prManager = new PrintManager();
		LadderManager ldManager = new LadderManager();
		List<String> joinUser = prManager.joinUser();

		int maxLadder = prManager.maxLadder();
		ldManager.makeLadder(joinUser.size(), maxLadder);

		ldManager.addMatchBranch(maxLadder);
		prManager.printLadder(ldManager.sortLadder(), joinUser);
	}
}
