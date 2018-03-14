package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputManager {
	
	public static Scanner sc = new Scanner(System.in);
	
	public List<String> joinUser() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		List<String> names = Arrays.asList(sc.nextLine().split(","));
		return names;
	}

	public int maxLadder() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return sc.nextInt();
	}
}
