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
		
		// 2���� �迭�� ������ �ֱ�
		
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
//			// �����Ͽ� �����͸� �־�д�.
//			Arrays.sort(arr[i]);
//		}
//		
//		// ù ���� �����͸� �־�д�.
//		answer = arr[0][0];
//		
//		// �� ���� ���� ���� ���� ���Ͽ� ���� ���� ���� ã�´�.
//		for(int i=0;i<n;i++) {
//			if(answer < arr[i][0]) {
//				answer = arr[i][0];
//			}
//		}
		
		return answer;
	}
}
