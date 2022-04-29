package graph;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// 단지 번호 붙이기
// https://www.acmicpc.net/problem/2667

public class P2667 {
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> house;
	static int hIdx = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		map = new int[n][n];
		visited = new boolean[n][n];
		house = new ArrayList<Integer>();
		
		// 맵 생성하기
		for(int i = 0; i < n; i++) {
			String line = sc.next();
			for(int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		// (0,0) 부터 순회하면서 방문표시하고 집 찾기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					house.add(1);
					findHouse(n, i, j);
					hIdx++;
				}
			}
		}
		
		System.out.println(house.size());
		Collections.sort(house);
		for(int h:house) {
			System.out.println(h);
		}
		
	}
	
	// 상하좌우 집 찾기
	public static void findHouse(int n, int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if(mx >= 0 && my >= 0 && mx < n && my < n) {
				if(map[mx][my] == 1 && !visited[mx][my]) {
					house.set(hIdx, house.get(hIdx) + 1);
					findHouse(n, mx, my);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		solution();
	}
}
