package ladder;

import java.util.ArrayList;
import java.util.List;

public class PrintManager {

	ArrayList<BranchLine> branchArr;

	public void printUser(List<String> joinUser) {
		for (int i = 0; i < joinUser.size(); i++) {
			System.out.print(joinUser.get(i) + "     ");
		}
		System.out.println();
	}

	public void printLadder(ArrayList<BranchLine> branchArr) {
		this.branchArr = branchArr;
		for (int i = 0; i < branchArr.size(); i++) {
			System.out.print("|");
			printLadder(i);
			System.out.println();
		}
	}

	public void printLadder(int i) {
		for (int j = 0; j < branchArr.get(i).getLength() - 1; j++) {
			System.out.print(checkBranch(i, j));
			System.out.print("|");
		}
	}

	public String checkBranch(int i, int j) {
		if (branchArr.get(i).getPoint(j)) {
			return "-----";
		}
		return "     ";
	}

}
