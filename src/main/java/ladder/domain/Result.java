package ladder.domain;

import java.util.List;

public class Result {
	List<String> resultList;

	public Result(List<String> resultList) {
		this.resultList = resultList;
	}

	public static Result makeResultList(List<String> resultList) {
		return new Result(resultList);
	}

	public List<String> getResultList() {
		return resultList;
	}

	public int getResultListSize() {
		return resultList.size();
	}

	public String getResult(int i) {
		return resultList.get(i);
	}

}
