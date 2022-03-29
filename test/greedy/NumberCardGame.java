package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCardGame {
	public static int solution() {
		int answer = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		
		// 2차원 배열에 데이터 넣기
		
		for(int i=0;i<n;i++) {
			int min = 10001;
			
			for(int j=0;j<m;j++) {
				int x = sc.nextInt();
				min = Math.min(min, x);
			}
			answer = Math.max(answer, min);
		}
		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				arr[i][j] = sc.nextInt();
//			}
//			// 정렬하여 데이터를 넣어둔다.
//			Arrays.sort(arr[i]);
//		}
//		
//		// 첫 행의 데이터를 넣어둔다.
//		answer = arr[0][0];
//		
//		// 각 행의 가장 작은 값을 비교하여 제일 높은 값을 찾는다.
//		for(int i=0;i<n;i++) {
//			if(answer < arr[i][0]) {
//				answer = arr[i][0];
//			}
//		}
		
		return answer;
	}
}
