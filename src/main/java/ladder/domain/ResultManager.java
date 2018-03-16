package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultManager {

	private ArrayList<BranchLine> branchLines;
	private ArrayList<User> userArriveResult;

	public static ResultManager makeUserList(ArrayList<BranchLine> branchLines, List<String> joinUser) {
		ArrayList<User> userArriveResult = new ArrayList<>();
		for (int i = 0; i < joinUser.size(); i++) {
			User user = new User(i, joinUser.get(i));
			userArriveResult.add(user);
		}
		return new ResultManager(branchLines, userArriveResult);
	}

	public ResultManager(ArrayList<BranchLine> branchLines, ArrayList<User> userArriveResult) {
		this.userArriveResult = userArriveResult;
		this.branchLines = branchLines;
	}

	public ArrayList<User> getUserArriveResult() {
		for (int i = 0; i < branchLines.size(); i++) {
			getUserArriveResult(i);
			sortUserArriveResult();
		}
		return userArriveResult;
	}

	public void getUserArriveResult(int i) {
		for (int j = 0; j < userArriveResult.size(); j++) {
			updateColProcess(i, j);
		}
	}

	public void updateColProcess(int i, int j) {
		if (j != userArriveResult.size() - 1 && branchLines.get(i).getPoint(j)) {
			userArriveResult.get(j).increaseCol();
			return;
		}
		if (j != 0 && branchLines.get(i).getPoint(j - 1)) {
			userArriveResult.get(j).decreaseCol();
		}
	}

	public void sortUserArriveResult() {
		for (int i = 0; i < userArriveResult.size() - 1; i++) {
			sortUserArriveResult(i);
		}
	}

	public void sortUserArriveResult(int i) {
		if (userArriveResult.get(i).getCol() > userArriveResult.get(i + 1).getCol()) {
			User tempUser = userArriveResult.get(i);
			userArriveResult.set(i, userArriveResult.get(i + 1));
			userArriveResult.set(i + 1, tempUser);
		}
	}

}
