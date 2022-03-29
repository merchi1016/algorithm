package Implementation;

import java.util.Scanner;

public class KingdomKnight {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		// 위치 입력받기
		String pos = sc.next();
		int row = pos.charAt(1) - '0';
		int column = pos.charAt(0) - 'a' + 1;
		
		// 이동할 수 있는 8가지 방향 정의
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		// 8가지 방향 위치 이동 가능한지 확인
		int result = 0;
		for(int i = 0; i < 8; i++) {
			// 이동하고자 하는 위치 확인
			int nextRow = row + dx[i];
			int nextCol = column + dy[i];
			
			// 해당 위치로 이동 가능하면 카운트 증가
			if(nextRow >= 1 && nextRow <=8 &&
					nextCol >= 1 && nextCol <= 8) {
				result += 1;
			}
		}
		System.out.println(result);
	}
}
