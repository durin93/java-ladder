package ladder;

import java.util.ArrayList;

public class BranchLine {
	private ArrayList<Branch> oneBranchSet;

	public BranchLine() {
		this.oneBranchSet = new ArrayList<Branch>();
	}

	public void add(Branch branch) {
		oneBranchSet.add(branch);
	}

	public ArrayList<Branch> getOneBranchSet() {
		return oneBranchSet;
	}

	public String chkIsBranch(int col, int j, BranchLine branchLine) {
		if (branchLine.getOneBranchSet().size() != 0 && branchLine.getOneBranchSet().get(col).getCol() == j) {
			return "-----";
		}
		return "     ";
	}

}
