package ladder.domain;

public class User {

	private int col;
	private int num;
	private String name;

	public int getNum() {
		return num;
	}

	public User(int col, String name) {
		num = col;
		this.name = name;
		this.col = col;
	}

	public int getCol() {
		return col;
	}

	public String getName() {
		return name;
	}

	public void increaseCol() {
		col++;
	}

	public void decreaseCol() {
		col--;
	}

	public Boolean isSameNum(int userNum) {
		return num == userNum;
	}

}
