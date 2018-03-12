package ladder;


public class LadderGame {

	public static void main(String[] args) {

		PrintManager prManager = new PrintManager();
		LadderManager ldManager = new LadderManager(prManager.joinUser(), prManager.maxLadder());

		ldManager.makeLadder();
		ldManager.addMatchBranch();
		prManager.printLadder(ldManager.sortLadder());
	}
}
