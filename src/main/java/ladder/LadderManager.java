package ladder;
import java.util.Random;

public class LadderManager {

	private int height;
	private int joinUser;
	private String[][] ladderInfo;

	public LadderManager(int height, int joinUser) {
		this.height = height;
		this.joinUser = joinUser;
	}

	public String[][] makeLadder() {
		ladderInfo = new String[height][joinUser];
		for (int k = 0; k < height; k++) {
			makeBranchFlag(k);
		}
		return ladderInfo;
	}

	public void makeBranchFlag(int k) {
		for (int i = 0; i < joinUser; i++) {
			ladderInfo[k][i] = makeBranch(k, i);
		}
	}

	public String makeBranch(int k, int i) {
		Random rand = new Random();
		if (rand.nextInt(2) == 1) {
			return "-";
		}
		return " ";
	}

}
