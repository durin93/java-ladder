package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.view.InputManager;
import ladder.view.PrintManager;

public class GameController {
	public static void startGame() {
		List<String> joinUser = InputManager.joinUser();
		Result result = Result.makeResultList(InputManager.result());
		ArrayList<BranchLine> branchLines = LadderManager.makeLadder(joinUser.size(), InputManager.maxLadder());

		startPrintProcess(joinUser, result, branchLines);
		startResultProcess(DataProcess.getUserArriveInfo(branchLines, joinUser), result, joinUser);
	}

	public static void startPrintProcess(List<String> joinUser, Result result, ArrayList<BranchLine> branchLines) {
		PrintManager.printUser(joinUser);
		PrintManager.printLadder(branchLines);
		PrintManager.printResult(result);
	}

	public static void startResultProcess(ArrayList<User> userArriveInfo, Result result, List<String> joinUser) {
		String resultUserName = InputManager.printQuestion();
		if (resultUserName.equals("all")) {
			PrintManager.printFinalResult(userArriveInfo, result);
			return;
		}
		int userNum = DataProcess.getUserNum(joinUser, resultUserName);
		String resultName = DataProcess.getResultUserName(userArriveInfo, result, userNum);
		PrintManager.printFinalResult(resultUserName, resultName);
	}

}
