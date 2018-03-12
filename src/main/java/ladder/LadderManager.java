package ladder;

import java.util.ArrayList;
import java.util.Random;

public class LadderManager {

	private ArrayList<Branch> branch;
	private ArrayList<ArrayList<Branch>> branchArr;
	private ArrayList<Branch> rowMatchedBranch;

	private int height;
	private int joinUser;

	public LadderManager(int joinUser, int height) {
		branch = new ArrayList<Branch>();
		branchArr = new ArrayList<ArrayList<Branch>>();
		this.joinUser = joinUser;
		this.height = height;
	}

	public void makeLadder() {
		for (int i = 0; i < height; i++) {
			makeLadder(i);
		}
	}

	public void makeLadder(int i) {
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

	public void addMatchBranch() {
		for (int b = 0; b < height; b++) {
			rowMatchedBranch = new ArrayList<Branch>();
			addMatchBranch(b);
			chkMatchBranch();
		}
	}

	public void addMatchBranch(int b) {
		for (int c = 0; c < branch.size(); c++) {
			chkMatchBranch(b, c);
		}
	}

	public void chkMatchBranch(int b, int c) {
		if (branch.get(c).getRow() == b) {
			rowMatchedBranch.add(branch.get(c));
		}
	}

	public void chkMatchBranch() {
		if (rowMatchedBranch != null) {
			branchArr.add(rowMatchedBranch);
		}
	}

	public ArrayList<ArrayList<Branch>> sortLadder() {
		Branch temp = null;
		for (int i = 0; i < branchArr.size() - 1; i++) {
			sortLadder(temp, i);
		}
		return branchArr;
	}

	public void sortLadder(Branch temp, int i) {
		for (int j = 0; j < branchArr.get(i).size() - 1; j++) {
			temp = new Branch(0, 0);
			sortLadder(temp, i, j);
		}
	}

	public void sortLadder(Branch temp, int i, int j){
		if (branchArr.get(i).get(j).getCol() > branchArr.get(i).get(j + 1).getCol()) {
			temp = branchArr.get(i).get(j);
			branchArr.get(i).set(i, branchArr.get(i).get(j + 1));
			branchArr.get(i).set(i + 1, temp);
		}
	}
	
}
