package ladder;

import java.util.ArrayList;

public class BranchLine {
	private ArrayList<Branch> oneBranchLine;

	public BranchLine() {
		this.oneBranchLine = new ArrayList<Branch>();
	}

	public void add(Branch branch) {
		oneBranchLine.add(branch);
	}

	public ArrayList<Branch> getOneBranchLine() {
		return oneBranchLine;
	}

}
