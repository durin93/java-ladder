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

	public void makeLadder(int joinUser, int height) {
		for (int i = 0; i < height; i++) {
			makeLadderCol(i, joinUser);
		}
	}

	public void makeLadderCol(int i, int joinUser) {
		for (int k = 0; k < joinUser - 1; k++) {
			makeBranch(i, k);
		}
	}

	public void makeBranch(int i, int k) {
		Random rand = new Random();
		int rn = rand.nextInt(10);
		if (rn < 5) {
			branch.add(new Branch(i, k));
		}
	}

	public void addMatchBranch(int height) {
		for (int b = 0; b < height; b++) {
			addBranchLine(chkMatchBranch(b, new BranchLine()));
		}
		chkNearBranch();
	}

	public BranchLine chkMatchBranch(int b, BranchLine oneBranchLine) {
		for (int c = 0; c < branch.size(); c++) {
			if (branch.get(c).getRow() == b) {
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

	public void chkNearBranch() {
		for (int i = 0; i < branchArr.size(); i++) {
			chkNearBranch(i);
		}
	}

	public void chkNearBranch(int i) {
		for (int j = 0; j < branchArr.get(i).getOneBranchLine().size(); j++) {
			removeNearBranch(i, j);
		}
	}

	public void removeNearBranch(int i, int j) {
		if (j < branchArr.get(i).getOneBranchLine().size() - 1 && branchArr.get(i).getOneBranchLine().get(j).getCol()
				+ 1 == branchArr.get(i).getOneBranchLine().get(j + 1).getCol()) {
			branchArr.get(i).getOneBranchLine().remove(j);
		}

		if (j < branchArr.get(i).getOneBranchLine().size() - 1 && branchArr.get(i).getOneBranchLine().get(j)
				.getCol() == branchArr.get(i).getOneBranchLine().get(j + 1).getCol() - 1) {
			branchArr.get(i).getOneBranchLine().remove(j + 1);
		}
	}

	public ArrayList<BranchLine> sortLadder() {
		for (int i = 0; i < branchArr.size() - 1; i++) {
			sortLadder(i);
		}
		return branchArr;
	}

	public void sortLadder(int i) {
		for (int j = 0; j < branchArr.get(i).getOneBranchLine().size() - 1; j++) {
			sortLadder(i, j);
		}
	}

	public void sortLadder(int i, int j) {
		Branch temp = new Branch(0, 0);
		if (branchArr.get(i).getOneBranchLine().get(j).getCol() > branchArr.get(i).getOneBranchLine().get(j + 1)
				.getCol()) {
			temp = branchArr.get(i).getOneBranchLine().get(j);
			branchArr.get(i).getOneBranchLine().set(i, branchArr.get(i).getOneBranchLine().get(j + 1));
			branchArr.get(i).getOneBranchLine().set(i + 1, temp);
		}
	}

}
