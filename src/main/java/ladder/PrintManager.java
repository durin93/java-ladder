package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintManager {
	private ArrayList<BranchLine> branchArr;

	public List<String> joinUser(Scanner sc) {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		List<String> names = Arrays.asList(sc.nextLine().split(","));
		return names;
	}

	public int maxLadder(Scanner sc) {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return sc.nextInt();
	}

	public void printLadder(ArrayList<BranchLine> branchArr, List<String> joinUser) {

		this.branchArr = branchArr;
		printUser(joinUser);

		for (int i = 0; i < branchArr.size(); i++) {
			printLadder(i, joinUser.size());
			System.out.print("|\n");
		}
	}

	public void printUser(List<String> joinUser) {
		for (int i = 0; i < joinUser.size(); i++) {
			System.out.print(joinUser.get(i) + "     ");
		}
		System.out.println();
	}

	public void printLadder(int i, int joinUser) {
		int col = 0;
		for (int j = 0; j < joinUser - 1; j++) {
			col = printBranch(i, j, col);
		}
	}

	public int printBranch(int i, int j, int col) {
		System.out.print("|");
		System.out.print(branchArr.get(i).chkIsBranch(col, j, branchArr.get(i)));
		if (branchArr.get(i).chkIsBranch(col, j, branchArr.get(i)) == "-----") {
			col = colUp(col, i);
		}
		return col;
	}

	public int colUp(int col, int i) {
		if (col < branchArr.get(i).getOneBranchSet().size() - 1) {
			col++;
		}
		return col;
	}
}
