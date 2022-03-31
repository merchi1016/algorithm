package solved_ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부녀회장이 될테야
// https://www.acmicpc.net/problem/2775

import java.util.Scanner;

public class P2775 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] floor_0 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int result = 0;
		
		for(int i=0;i<T;i++) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			
			getPeopleNum(floor_0, K, N);
		}
	}
	
	// 사람 수 구하기
	public static void getPeopleNum(int[] floor_0, int K, int N) {
		int people = 0;
		// k-1 층까지의 사람 수를 구함
		for(int i=0; i<K ;i++) {
			if(i == 0)
				continue;
			
			for(int j=1; j<N;j++) {
				floor_0[j] += floor_0[j-1];
			}
		}
		
		for(int i=0;i<N;i++) {
			people += floor_0[i];
		}
		
		System.out.println(people);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////
	
	
	// 다른 풀이
	// https://st-lab.tistory.com/78
	public static void solution2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[15][15];
		
		make_APT(arr);
		
		for(int i=0;i<T;i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[k][n]).append('\n');
		}
		System.out.println(sb);
	}
	
	// 아파트 생성
	public static void make_APT(int[][] arr) {
		for(int k=0;k<arr[0].length;k++) {
			for(int n=1;n<arr.length;n++) {
				if(k == 0) {
					arr[k][n] = n;
				}else {
					arr[k][n] = arr[k-1][n] + arr[k][n-1];
				}
			}
		}
	}
}
