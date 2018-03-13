package ladder;

import java.util.ArrayList;
import java.util.Random;

public class LadderManager {

	private ArrayList<Integer> oneBranchSet;
	private ArrayList<BranchLine> BranchLineArr;

	public LadderManager() {
		BranchLineArr = new ArrayList<BranchLine>();
	}

	public void makeLadder(int joinUser, int height) {
		for (int i = 0; i < height; i++) {
			oneBranchSet = new ArrayList<Integer>();
			makeLadderCol(i, joinUser);
			BranchLine branchLine = new BranchLine();
			branchLine.add(i, oneBranchSet);
			BranchLineArr.add(branchLine);
		}
	}

	public void makeLadderCol(int i, int joinUser) {
		boolean flag = true;
		for (int k = 0; k < joinUser - 1; k++) {
			flag = makeBranchResult(flag, i, k);
		}
	}

	public boolean makeBranchResult(boolean flag, int i, int k) {
		if (flag) {
			return makeBranch(i, k);
		}
		return true;
	}

	public boolean makeBranch(int i, int k) {
		Random rand = new Random();
		int rn = rand.nextInt(10);
		if (rn < 5) {
			oneBranchSet.add(k);
			return false;
		}
		return true;
	}

	public void addBranchLine(BranchLine oneBranchLine) {
		if (oneBranchLine != null) {
			BranchLineArr.add(oneBranchLine);
		}
	}

	public ArrayList<BranchLine> getBranchLineArr() {
		return BranchLineArr;
	}

}
