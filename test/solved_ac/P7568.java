package solved_ac;

// 덩치
// https://www.acmicpc.net/problem/7568

import java.util.Scanner;

public class P7568 {
	public static void solution() {
		Scanner sc  = new Scanner(System.in);	
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i != j) {
					compareSize(arr, i, j);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(arr[i][2] + 1 + " ");
		}
		
	}
	
	public static void compareSize(int[][] arr, int i, int j) {
		int a_weight = arr[i][0];
		int b_weight = arr[j][0];
		int a_height = arr[i][1];
		int b_height = arr[j][1];
		
		if(a_weight < b_weight && a_height < b_height) {
			arr[i][2]++;
		}
	}
}
