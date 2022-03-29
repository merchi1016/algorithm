package Implementation;

import java.util.Scanner;

public class GameDevelop {
	
	public static int n, m, pX, pY, pD;
	
	// 왼쪽으로 회전
	public static void turn_left() {
		pD -= 1;
		if(pD == -1)
			pD = 3;
	}
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		// 맵 크기
		n = sc.nextInt();
		m = sc.nextInt();
		// 플레이어 위치, 보고있는 방향
		pX = sc.nextInt();
		pY = sc.nextInt();
		pD = sc.nextInt();
		// 맵
		int[][] map = new int[n][m];
		// 이동한 곳을 체크하는 맵
		int[][] chMap = new int[n][m];
		// 북, 동, 남, 서 방향 정의
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		// 맵 구성
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		// 가본 땅의 수 카운트.
		// 플레이어가 원래 있는 곳도 방문한 곳이므로 1로 초기화
		int cnt = 1;
		// 회전한 수
		int turn_time = 0;
		while(true) {
			// 왼쪽으로 회전
			turn_left();
			int nx = pX + dx[pD];
			int ny = pY + dy[pD];
			
			// 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
			if(chMap[nx][ny] == 0 && map[nx][ny] == 0) {
				chMap[nx][ny] = 1;
				pX = nx;
				pY = ny;
				cnt += 1;
				turn_time = 0;
				continue;
			}else{ // 회전한 이후 모두 가본칸이거나 바다인 경우
				turn_time += 1;
			}
			
			// 네 방향 갈 수 없는 경우
			if(turn_time == 4) {
				nx = pX - dx[pD];
				ny = pY - dy[pD];
				// 뒤로 이동가능하면 이동하기
				if(chMap[nx][ny] == 0) {
					pX = nx;
					pY = ny;
				}else { // 뒤가 바다로 막혀 있는 경우
					break;
				}
				
				turn_time = 0;
			}
		}
	}
}
