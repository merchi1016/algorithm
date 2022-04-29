package graph;

// 미로 탐색
// https://www.acmicpc.net/problem/2178

import java.util.Scanner;

public class P2178 {
	static int[][] map;
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n][m];
		
		// map 초기화
		for(int i = 0; i < n; i++) {
			String line = sc.next();
			for(int j = 0; j < m; j++) {
				map[n][m] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				
			}
		}
		
		bfs(n, m);
	}
	
	public static void bfs(int n, int m) {
		
	}
	
	public static void main(String[] args) {
		
	}
}
