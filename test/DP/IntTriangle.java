package DP;

// 정수 삼각형 p.376
// https://www.acmicpc.net/problem/1932

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IntTriangle {
	public void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		// Arrays.fill 은 1차원 배열만 채울 수 있음
		for(int[] cArr:arr) {
			Arrays.fill(cArr, -1);
		}
		
		// 삼각형 데이터 초기화
		for(int i = 0; i < n; i++) {
			int j = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		dp(arr, n);
	}
	
	public void dp(int[][] arr, int n) {
		int[][] dp = new int[n][n];
		
		// dp 테이블 초기화
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dp[i][j] = arr[i][j];
			}
		}
		
		// 최대합 찾기
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					dp[i][j] += dp[i-1][j];
				}else if(j == i){
					dp[i][j] += dp[i-1][j-1];
				}else {
					dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
				}
			}
		}
		
		// 최대값 찾기
		int result = 0;
		for(int i = 0; i < n ;i++) {
			result = Math.max(result, dp[n - 1][i]);
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) throws IOException {
		IntTriangle it = new IntTriangle();
		it.solution();
	}

}
