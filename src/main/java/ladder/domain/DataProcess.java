package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class DataProcess {

	public static final int MAXNAMELEGTH = 5;
	public static final int RANDOMRANGE = 8;
	public static final int RANDOMMIN = 3;

	public static Boolean checkFlag(List<String> names) {
		return !checkNamesLength(names);
	}

	public static Boolean checkNamesLength(List<String> names) {
		int flag = 0;
		for (int i = 0; i < names.size(); i++) {
			flag = checkNamesLength(names, i, flag);
		}
		return flag <= 0;
	}

	public static int checkNamesLength(List<String> names, int i, int flag) {
		if (names.get(i).length() > MAXNAMELEGTH) {
			System.out.print("최대 5글자 까지만 입력가능합니다." + (i + 1) + "번째 이름 길이초과\n");
			flag++;
		}
		return flag;
	}

	public static String checkBranch(int i, int j, ArrayList<BranchLine> branchArr) {
		if (branchArr.get(i).getPoint(j)) {
			return "-----";
		}
		return "     ";
	}

	public static Boolean getQuarter(int randNum) {
		if (randNum > RANDOMMIN) {
			return true;
		}
		return false;
	}

	public static int getUserNum(List<String> joinUser, String userName) {
		return joinUser.indexOf(userName);
	}

	public static int getUserArrivePosition(ArrayList<User> userArriveInfo, int userNum) {
		int position = 0;
		for (int i = 0; i < userArriveInfo.size(); i++) {
			position = getUserArrivePosition(userArriveInfo, userNum, i);
		}
		return position;
	}

	public static int getUserArrivePosition(ArrayList<User> userArriveInfo, int userNum, int i) {
		if (userArriveInfo.get(i).isSameNum(userNum)) {
			return i;
		}
		return 0;
	}

	public static ArrayList<User> getUserArriveInfo(ArrayList<BranchLine> branchLines, List<String> joinUser) {
		ResultManager resultManager = ResultManager.makeUserList(branchLines, joinUser);
		return resultManager.getUserArriveResult();
	}

	public static String getResultUserName(ArrayList<User> userArriveInfo, Result result, int userNum) {
		int userResultPosition = DataProcess.getUserArrivePosition(userArriveInfo, userNum);
		int resultPosition = userArriveInfo.get(userResultPosition).getCol();
		return result.getResult(resultPosition);
	}

	public static String getResultName(ArrayList<User> userArriveInfo, Result result, int i) {
		return result.getResult(userArriveInfo.get(i).getCol());
	}

}