package ladder;

public class GameOutput {

	private String[][] ladder;
	private int height;
	private int joinUser;

	public GameOutput(String[][] ladder) {
		this.ladder = ladder;
		this.height = ladder.length;
		this.joinUser = ladder[0].length;
	}

	public void printLadder(String[][] ladder) {
		for (int i = 0; i < height; i++) {
			printColumn(i);
			System.out.println();
		}
	}

	public void printColumn(int i) {
		for (int k = 0; k < joinUser; k++) {
			System.out.print("|");
			printBranch(i, k);
		}
	}

	public void printBranch(int i, int k) {
		if (k < joinUser - 1) {
			System.out.print(ladder[i][k]);
		}
	}
}
