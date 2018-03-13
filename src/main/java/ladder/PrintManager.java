package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintManager {
	private int height;
	private int joinUser;
	private ArrayList<BranchLine> branchArr;

	public List<String> joinUser() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		List<String> names = Arrays.asList(new Scanner(System.in).nextLine().split(","));
		this.joinUser = names.size();
		return names;
	}

	public int maxLadder() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		this.height = new Scanner(System.in).nextInt();
		return height;
	}

	public void printLadder(ArrayList<BranchLine> branchArr, List<String> joinUser) {

		this.branchArr = branchArr;
		printUser(joinUser);

		for (int i = 0; i < height; i++) {
			printLadder(i);
			System.out.print("|\n");
		}
	}

	public void printUser(List<String> joinUser) {
		for (int i = 0; i < joinUser.size(); i++) {
			System.out.print(joinUser.get(i) + "     ");
		}
		System.out.println();
	}

	public void printLadder(int i) {
		int col = 0;

		for (int j = 0; j < joinUser - 1; j++) {
			col = printBranch(i, j, col);
		}
	}

	public int printBranch(int i, int j, int col) {
		System.out.print("|");
		System.out.print(chkIsBranch(i, col, j));
		if (chkIsBranch(i, col, j) == "-----") {
			col = colUp(col, i);
		}
		return col;
	}

	public String chkIsBranch(int i, int col, int j) {
		if (branchArr.get(i).getOneBranchLine().size() != 0
				&& branchArr.get(i).getOneBranchLine().get(col).getCol() == j) {
			return "-----";
		}
		return "     ";
	}

	public int colUp(int col, int i) {
		if (col < branchArr.get(i).getOneBranchLine().size() - 1) {
			col++;
		}
		return col;
	}
}
