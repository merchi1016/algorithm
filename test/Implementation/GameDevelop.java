package Implementation;

import java.util.Scanner;

public class GameDevelop {
	
	public static int n, m, pX, pY, pD;
	
	// �������� ȸ��
	public static void turn_left() {
		pD -= 1;
		if(pD == -1)
			pD = 3;
	}
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		// �� ũ��
		n = sc.nextInt();
		m = sc.nextInt();
		// �÷��̾� ��ġ, �����ִ� ����
		pX = sc.nextInt();
		pY = sc.nextInt();
		pD = sc.nextInt();
		// ��
		int[][] map = new int[n][m];
		// �̵��� ���� üũ�ϴ� ��
		int[][] chMap = new int[n][m];
		// ��, ��, ��, �� ���� ����
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		// �� ����
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		// ���� ���� �� ī��Ʈ.
		// �÷��̾ ���� �ִ� ���� �湮�� ���̹Ƿ� 1�� �ʱ�ȭ
		int cnt = 1;
		// ȸ���� ��
		int turn_time = 0;
		while(true) {
			// �������� ȸ��
			turn_left();
			int nx = pX + dx[pD];
			int ny = pY + dy[pD];
			
			// ȸ���� ���� ���鿡 ������ ���� ĭ�� �����ϴ� ��� �̵�
			if(chMap[nx][ny] == 0 && map[nx][ny] == 0) {
				chMap[nx][ny] = 1;
				pX = nx;
				pY = ny;
				cnt += 1;
				turn_time = 0;
				continue;
			}else{ // ȸ���� ���� ��� ����ĭ�̰ų� �ٴ��� ���
				turn_time += 1;
			}
			
			// �� ���� �� �� ���� ���
			if(turn_time == 4) {
				nx = pX - dx[pD];
				ny = pY - dy[pD];
				// �ڷ� �̵������ϸ� �̵��ϱ�
				if(chMap[nx][ny] == 0) {
					pX = nx;
					pY = ny;
				}else { // �ڰ� �ٴٷ� ���� �ִ� ���
					break;
				}
				
				turn_time = 0;
			}
		}
	}
}
