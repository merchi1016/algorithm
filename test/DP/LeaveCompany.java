package DP;

// 퇴사 p.377
// https://www.acmicpc.net/problem/14501

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class LeaveCompany {
	public void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n];
		int[] p = new int[n];
		
		// 데이터 초기화
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		dp(t, p, n);
	}
	
	// 다이나믹 프로그래밍 기법으로 최대 수익 구하기(바텀업)
	public void dp(int[] t, int[] p, int n) {
		int[] dp = new int[n+1];
		int max = 0;
		
		// dp 테이블 거꾸로 확인
		for(int i = n - 1; i >= 0; i--) {
			int time = t[i] + i;
			
			// 상담이 기간을 벗어나는 경우
			if(time > n) {
				dp[i] = max;
			}else { // 상담이 기간 내에 끝나는 경우
				// 현재까지의 최고 이익 계산
				dp[i] = Math.max(dp[time]+p[i], dp[i+1]);
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}
	
	public static void main(String[] args) throws IOException{
		LeaveCompany lc = new LeaveCompany();
		lc.solution();
	}

}
