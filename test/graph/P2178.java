package graph;

// 미로 탐색
// https://www.acmicpc.net/problem/2178

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class P2178 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		// 남아있는 enter 를 읽기 위함
		sc.nextLine();
		
		// map 초기화
		for(int i = 1; i <= n; i++) {
			String line = sc.nextLine();
			for(int j = 1; j <= m; j++) {
				map[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		bfs(n, m, 1, 1);
		
		System.out.println(map[n][m]);
	}
	
	public static void bfs(int n, int m, int sx, int sy) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[sx][sy] = true;
		q.offer(new int[]{sx, sy});
		
		while(!q.isEmpty()) {
			int[] location = q.poll();
			int x = location[0];
			int y = location[1];
			
			for(int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				
				if(mx > 0 && mx <= n && my > 0 && my <= m) {
					if(!visited[mx][my]) {
						visited[mx][my] = true;
						if(map[mx][my] != 0) {
							map[mx][my] = map[x][y] + 1;
							q.offer(new int[] {mx,my});
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		solution();
	}
}
