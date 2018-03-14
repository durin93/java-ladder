package ladder;

import java.util.List;

public class LadderGame {

	public static void main(String[] args) {
		InputManager inputManager = new InputManager();
		PrintManager printManager = new PrintManager();
		LadderManager ladderManager = new LadderManager();

		List<String> joinUser = inputManager.joinUser();
		int maxLadder = inputManager.maxLadder();

		printManager.printUser(joinUser);
		printManager.printLadder(ladderManager.makeLadder(joinUser.size(), maxLadder));
	}
}
