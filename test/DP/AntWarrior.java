package DP;
// 개미전사

import java.util.Scanner;
public class AntWarrior {
	// 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
	public static int[] d = new int[100];
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] wh = new int[n];
		for(int i = 0; i < n; i++) {
			wh[i] = sc.nextInt();
		}
		
		// 보텀업 형식 다이나믹 프로그래밍 진행
		d[0] = wh[0];
		d[1] = Math.max(wh[0], wh[1]);
		
		for(int i = 2; i < n; i++){
			d[i] = Math.max(d[i-1], d[i-2] + wh[i]);
		}
		
		System.out.println(d[n-1]);
	}
	
	public static void main(String[] args) {
		AntWarrior aw = new AntWarrior();
		aw.solution();
	}

}
