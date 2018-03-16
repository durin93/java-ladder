package ladder.view;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.BranchLine;
import ladder.domain.DataProcess;
import ladder.domain.Result;
import ladder.domain.User;

public class PrintManager {

	public static void printUser(List<String> joinUser) {
		for (int i = 0; i < joinUser.size(); i++) {
			System.out.print(joinUser.get(i) + "     ");
		}
		System.out.print("\n");
	}

	public static void printLadder(ArrayList<BranchLine> branchLines) {
		for (int i = 0; i < branchLines.size(); i++) {
			System.out.print("|");
			printLadder(branchLines, i);
			System.out.print("\n");
		}
	}

	public static void printLadder(ArrayList<BranchLine> branchLines, int i) {
		for (int j = 0; j < branchLines.get(i).getLength() - 1; j++) {
			System.out.print(DataProcess.checkBranch(i, j, branchLines));
			System.out.print("|");
		}
	}

	public static void printResult(Result result) {
		for (int i = 0; i < result.getResultListSize(); i++) {
			System.out.print(result.getResult(i) + "     ");
		}
		System.out.print("\n");
	}

	public static void printFinalResult(String resultUserName, String resultName) {
		System.out.println("실행결과는");
		System.out.println(resultUserName + " : " + resultName);
	}

	public static void printFinalResult(ArrayList<User> userArriveInfo, Result result) {
		System.out.println("실행결과는");
		for (int i = 0; i < userArriveInfo.size(); i++) {
			System.out.println(
					userArriveInfo.get(i).getName() + " : " + DataProcess.getResultName(userArriveInfo, result, i));
		}
	}
}
