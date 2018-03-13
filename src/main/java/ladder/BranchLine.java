package ladder;

import java.util.ArrayList;

public class BranchLine {
	private ArrayList<Integer> oneBranchSet;

	public BranchLine() {
		this.oneBranchSet = new ArrayList<>();
	}

	public void add(int row, ArrayList<Integer> oneBranchSet) {
		this.oneBranchSet = oneBranchSet;
	}

	public ArrayList<Integer> getOneBranchSet() {
		return oneBranchSet;
	}

	public String chkIsBranch(int col, int j) {
		if (oneBranchSet.size() != 0 && oneBranchSet.get(col) == j) {
			return "-----";
		}
		return "     ";
	}

	public boolean matchBranch(int row, int b) {
		return row == b;
	}

}
