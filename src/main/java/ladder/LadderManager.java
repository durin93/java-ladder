package ladder;

import java.util.ArrayList;
import java.util.Random;

public class LadderManager {

	private ArrayList<Branch> branch;
	private ArrayList<BranchLine> branchArr;

	public LadderManager() {
		branch = new ArrayList<Branch>();
		branchArr = new ArrayList<BranchLine>();
	}

	public ArrayList<Branch> makeLadder(int joinUser, int height) {
		for (int i = 0; i < height; i++) {
			makeLadderCol(i, joinUser);
		}
		return branch;
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
			branch.add(new Branch(i, k));
			return false;
		}
		return true;
	}

	public void addMatchBranch(int height) {
		for (int b = 0; b < height; b++) {
			addBranchLine(checkMatchBranch(b, new BranchLine()));
		}
	}

	public BranchLine checkMatchBranch(int b, BranchLine oneBranchLine) {
		for (int c = 0; c < branch.size(); c++) {
			if (branch.get(c).matchBranch(branch.get(c), b)) {
				oneBranchLine.add(branch.get(c));
			}
		}
		return oneBranchLine;
	}

	public void addBranchLine(BranchLine oneBranchLine) {
		if (oneBranchLine != null) {
			branchArr.add(oneBranchLine);
		}
	}

	public ArrayList<BranchLine> getBranchArr() {
		return branchArr;
	}

}
