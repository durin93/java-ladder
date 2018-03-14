package ladder;

import java.util.ArrayList;
import java.util.List;

public class DataProcess {

	public static final int MAXNAMELEGTH = 5;

	public static Boolean checkNamesLength(List<String> names) {
		for (int i = 0; i < names.size(); i++) {
			chkNamesLength(names, i);
		}
		return true;
	}

	public static Boolean chkNamesLength(List<String> names, int i) {
		if (names.get(i).length() > MAXNAMELEGTH) {
			Util.print("최대 5글자 까지만 입력가능합니다." + i + "번째 이름 길이초과\n");
			return false;
		}
		return true;
	}
	
	public static String checkBranch(int i, int j, ArrayList<BranchLine> branchArr) {
		if (branchArr.get(i).getPoint(j)) {
			return "-----";
		}
		return "     ";
	}
	
}
