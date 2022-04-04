package solved_ac;

// 체스판 다시 칠하기
// https://www.acmicpc.net/problem/1018
// 22.04.03 못풀었음

import java.util.Scanner;

public class P1018 {
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] chess = new char[N][M];
		int min = 64;
		int cnt = 0;
		
		// 체스판 저장
		for(int i=0;i<N;i++) {
			String line = sc.next();
			for(int j=0;j<M;j++) {
				chess[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0;i < N - 7;i++) {
			for(int j=0;j <M - 7;j++) {
				cnt = countRePainting(chess, i, j);
				min = Math.min(min, cnt);
			}
		}
		
		
		System.out.println(min);
	}
	
	// 다시 칠해야하는 정사각형 개수 구하기
	public static int countRePainting(char[][] chess, int n, int m) {
		int result = 0;
		int wrong_cnt = 0;
		
		char f_color = chess[n][m];
		
		for(int i=n;i < n + 8;i++) {
			for(int j=m;j < m + 8;j++) {
				// 올바르지 않은 색상 카운팅
				if(chess[i][j] != f_color) {
					wrong_cnt++;
				}
				
				// 다음 색으로 변경
				if(f_color == 'B') {
					f_color = 'W';
				}else {
					f_color = 'B';
				}
			}
			if(f_color == 'B') {
				f_color = 'W';
			}else {
				f_color = 'B';
			}
		}
		
		// 첫번째 칸으로 기준으로 할 때 다시 색칠해야 할 개수(wrong_count)와
		// 첫번째 칸의 색의 반대되는 색을 기준으로 할 때 색칠할 개수 중 최소값 반환
		result = Math.min(wrong_cnt, 64- wrong_cnt);
		
		return result;
	}
}
