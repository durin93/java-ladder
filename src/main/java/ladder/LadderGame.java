package ladder;

public class LadderGame {
	public static void main(String[] args) {

		UserInput input = new UserInput();
		int joinUser = input.joinUser();
		int height = input.maxLadder();

		LadderManager ldManager = new LadderManager(height, joinUser);
		String[][] ladderInfo = ldManager.makeLadder();

		GameOutput gameOutput = new GameOutput(ladderInfo);
		gameOutput.printLadder(ladderInfo);

	}
}
