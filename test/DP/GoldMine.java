package DP;

// 금광 p.375

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoldMine {
	public void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		// 금광 데이터 초기화
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] mine = new int[n][m];
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n ; j++) {
				for(int k = 0; k < m ; k++) {
					mine[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp(mine, n, m);
		}
	}
	
	// 다이나믹 프로그래밍으로 최대값 구하기
	public void dp(int[][] mine, int n, int m) {
		int[][] d = new int[n][m];
		int max = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0) {
					d[j][i] = mine[j][i];
					max = Math.max(max, d[j][i]);
				}else{
					if(j == 0) {
						d[j][i] = Math.max(d[j][i-1] + mine[j][i], d[j+1][i-1] + mine[j][i]);
						max = Math.max(max, d[j][i]);
					}else if(j > 0 && j < n - 1) {
						d[j][i] = Math.max(d[j][i-1] + mine[j][i], d[j+1][i-1] + mine[j][i]);
						d[j][i] = Math.max(d[j][i], d[j-1][i-1] + mine[j][i]);
						max = Math.max(max, d[j][i]);
					}else {
						d[j][i] = Math.max(d[j-1][i-1] + mine[j][i], d[j][i-1] + mine[j][i]);
						max = Math.max(max, d[j][i]);
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	// 답안 코드
	public void dp2(int[][] mine, int n, int m) {
		int[][] dp = new int[n][m];
		
		// 다이나믹 프로그래밍을 위한 2차원 dp 테이블 초기화
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dp[i][j] = mine[i][j];
			}
		}
		
		// 다이나믹 프로그래밍 진행
		for(int j = 1; j < m; j++) {
			for(int i = 0; i < n; i++) {
				int leftUp, leftDown, left;
				
				// 왼쪽 위에서 오는 경우
				if(i == 0) leftUp = 0;
				else leftUp = dp[i - 1][j - 1];
				
				// 왼쪽 아래에서 오는 경우
				if(i == n - 1) leftDown = 0;
				else leftDown = dp[i + 1][j - 1];
				
				// 왼쪽에서 오는 경우
				left = dp[i][j - 1];
				
				dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
			}
		}
		
		int result = 0;
		
		for(int i = 0; i < n ; i++) {
			result = Math.max(result, dp[i][m - 1]);
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) throws IOException {
		GoldMine gm = new GoldMine();
		gm.solution();
	}

}
